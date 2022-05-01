package pageObjects.vocabularyTrainer.LessonSettingsMenue;

import static com.codeborne.selenide.Condition.exactText;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pageObjects.vocabularyTrainer.LessonSettingsMenue.ManagelessonDD.ManagelessonDDPage;

import static com.codeborne.selenide.Selenide.$$;

public class LessonSettingsMenuePage {

    private ElementsCollection LessonSettingsMenueOptions = $$(".lesson-navbar li span");

    //replace list of options with enum
    public ManagelessonDDPage clickManageLessonDDBTN(){
        LessonSettingsMenueOptions
                .findBy(exactText("Manage lesson")).click();
        return new ManagelessonDDPage();
    }




}
