package pageObjects;

import static com.codeborne.selenide.Condition.visible;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import configuration.SelenideConfiguration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PageObjectParent {
    private SelenideElement ponsLogo = $(".clearfix.logo");

    public PageObjectParent openPage(String url){
        System.out.println("--PageObjectParent.openPage()");
        open(url);
        ponsLogo.shouldBe(visible);

        new SelenideConfiguration().loadCookieInfo();
        WebDriverRunner.getWebDriver().navigate().refresh();
        return this;
    }
}
