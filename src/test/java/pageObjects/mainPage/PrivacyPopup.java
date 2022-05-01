package pageObjects.mainPage;

import static com.codeborne.selenide.Condition.visible;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Cookie;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.StringTokenizer;

import static com.codeborne.selenide.Selenide.$;

public class PrivacyPopup {

    private SelenideElement iAgreeBTN = $("#onetrust-accept-btn-handler");

    public void clickIAgreeBTN(){
        iAgreeBTN.shouldBe(visible).click();
    }

}






















