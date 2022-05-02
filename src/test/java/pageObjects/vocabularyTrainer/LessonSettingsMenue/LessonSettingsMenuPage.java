package pageObjects.vocabularyTrainer.LessonSettingsMenue;

import static com.codeborne.selenide.Condition.exactOwnText;
import static com.codeborne.selenide.Condition.exactText;
import com.codeborne.selenide.ElementsCollection;
import pageObjects.vocabularyTrainer.LessonSettingsMenue.ManageEntriesDD.ManageEntriesDdPage;
import pageObjects.vocabularyTrainer.LessonSettingsMenue.ManagelessonDD.ManagelessonDDPage;

import static com.codeborne.selenide.Selenide.$$;

public class LessonSettingsMenuPage {

    private LessonSettingsMenueOptionParent lessonSettingsMenueOptionParent;

    private ElementsCollection lessonSettingsMenuOptions = $$(".lesson-navbar li span");
    private ElementsCollection listOfWords = $$(".btn.btn-link.entry__edit-link");

    //replace list of options with enum
    public ManagelessonDDPage clickManageLessonDDBTN(){
        lessonSettingsMenuOptions
                .findBy(exactText("Manage lesson")).click();
        return new ManagelessonDDPage();
    }

    public LessonSettingsMenueOptionParent clickLessonSettingsMenuOption(LessonSettingsMenueOptions lessonSettingsMenueOptions){
        switch (lessonSettingsMenueOptions){
            case MANAGE_ENTRIES:
                this.lessonSettingsMenuOptions.findBy(exactOwnText("Manage Entries")).click();
                lessonSettingsMenueOptionParent = new ManageEntriesDdPage();
        }
        return lessonSettingsMenueOptionParent;
    }

    public ElementsCollection getListOfWords(){
        return listOfWords;
    }



}
