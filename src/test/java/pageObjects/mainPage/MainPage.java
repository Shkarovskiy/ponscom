package pageObjects.mainPage;

import pageObjects.PageObjectParent;

import static com.codeborne.selenide.Selenide.open;

public class MainPage extends PageObjectParent {
    private String mainPageURL = "https://en.pons.com/translate";

    public MainPage openMainPage(){
        return (MainPage) openPage(mainPageURL);
    }


}
