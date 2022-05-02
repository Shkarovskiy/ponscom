package configuration;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Cookie;
import pageObjects.mainPage.LoginPage;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * set base config for Selenide
 * this Class is extended by each testClass to set @beforeAll @afterAll and browser
 */
public class SelenideConfiguration {

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Configuration.timeout = 10000;
    }

    @BeforeAll
    public static void loginAndSetCookies() {
        System.out.println("--@BeforeAll--");
        new LoginPage().login();
        storeCookieInfo();
    }

    @BeforeEach
    public void init() {
        setUp();
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    public static void storeCookieInfo() {
        File f = new File("browser.data");
        try {
            f.delete();
            f.createNewFile();
            FileWriter fos = new FileWriter(f);
            BufferedWriter bos = new BufferedWriter(fos);
            Set<Cookie> cookies = WebDriverRunner.getWebDriver().manage().getCookies();
            for (Cookie ck : cookies) {
                bos.write((ck.getName() + ";" + ck.getValue() + ";" + ck.getDomain() + ";" + ck.getPath() + ";"
                        + ck.getExpiry() + ";" + ck.isSecure()));
                bos.newLine();
            }
            bos.flush();
            bos.close();
            fos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("---storeCookieInfo()");
    }

    public void loadCookieInfo() {
        try {
            File f = new File("browser.data");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                //as far as these cookies don't affect authorization we skip them because they offen get date = null
                //that breaks parsing despite the null check
                if (!(line.startsWith("lang")) && !(line.startsWith("dictuser"))) {
                    StringTokenizer str = new StringTokenizer(line, ";");
                    while (str.hasMoreTokens()) {
                        String name = str.nextToken();
                        String value = str.nextToken();
                        String domain = str.nextToken();
                        String path = str.nextToken();
                        Date expiry = null;
                        String dt = null;
                        if (!(dt = str.nextToken()).equals("null")) {
                            SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
                            expiry = dateFormat.parse(dt);
                        }
                        boolean isSecure = new Boolean(str.nextToken()).booleanValue();
                        Cookie ck = new Cookie(name, value, domain, path, expiry, isSecure);
                        WebDriverRunner.getWebDriver().manage().addCookie(ck);
                    }
                }
                if (line.startsWith("dictuser")) {
                    StringTokenizer str = new StringTokenizer(line, ";");
                    while (str.hasMoreTokens()) {
                        String name = str.nextToken();
                        String value = str.nextToken();
                        String domain = str.nextToken();
                        String path = str.nextToken();
                        Date expiry = null;
                        String dt = null;
                        if (!(dt = str.nextToken()).equals("null")) {
                            SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
//                            expiry = dateFormat.parse(dt);
                            String date = dateFormat.format(Calendar.getInstance().getTime());
                            expiry = dateFormat.parse(date);
                            System.out.println("---current date " + expiry);
                        }
                        boolean isSecure = new Boolean(str.nextToken()).booleanValue();
                        Cookie ck = new Cookie(name, value, domain, path, expiry, isSecure);
                        WebDriverRunner.getWebDriver().manage().addCookie(ck);
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("---loadCookieInfo()");
    }
}
