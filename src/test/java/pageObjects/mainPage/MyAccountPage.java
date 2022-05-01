package pageObjects.mainPage;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MyAccountPage {
    private SelenideElement xBTN = $(".icon-icon_base_cross");

    public MainPage clickXBTN(){
        xBTN.click();
        new PrivacyPopup().clickIAgreeBTN();
        return new MainPage();
    }
}
