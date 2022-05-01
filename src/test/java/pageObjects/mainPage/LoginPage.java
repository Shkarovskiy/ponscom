package pageObjects.mainPage;

import Business.User;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    User user = new User("shkarovskiy", "abc123");
    private String loginPageURL = "https://account.pons.com/en/public/signin";
    private SelenideElement emailField = $("#email");
    private SelenideElement passwordField = $("#password");
    private SelenideElement loginBTN = $(".sc-bdvvtL.ijRfyI.button.primary.md");

    public MainPage login(){
        open(loginPageURL);
        new PrivacyPopup().clickIAgreeBTN();
        emailField.val(user.getName());
        passwordField.val(user.getPassword());
        loginBTN.click();
        new MyAccountPage().clickXBTN();
        return new MainPage();
    }



}
