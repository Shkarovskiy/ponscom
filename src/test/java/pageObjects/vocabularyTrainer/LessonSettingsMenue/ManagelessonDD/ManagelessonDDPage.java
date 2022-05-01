package pageObjects.vocabularyTrainer.LessonSettingsMenue.ManagelessonDD;

import com.codeborne.selenide.ElementsCollection;
import pageObjects.vocabularyTrainer.LessonSettingsMenue.ManagelessonDD.ManagelessonDDPopups.DeleteLessonPopupPage;
import pageObjects.vocabularyTrainer.LessonSettingsMenue.ManagelessonDD.ManagelessonDDPopups.EditLessonTitlePopupPage;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$$;

public class ManagelessonDDPage {
    public ManageLessonDDPopups manageLessonDDPopups;
    private ElementsCollection managelessonDDOptions = $$(".dropdown.open li a");

    public DeleteLessonPopupPage clickDeleteLessonOption() {
        managelessonDDOptions
                .findBy(exactText("Delete lesson")).click();
        return new DeleteLessonPopupPage();
    }

    public ManageLessonDDPopups clickManagelessonDDOption(ManageLessonDDOptions managelessonDDOptionEnum) {
        switch (managelessonDDOptionEnum) {
            case DELETE_LESSON:
                managelessonDDOptions.findBy(exactText("Delete lesson")).click();
                manageLessonDDPopups = new DeleteLessonPopupPage();
                break;
            case EDIT_LESSON_TITLE:
                managelessonDDOptions.findBy(exactText("Edit lesson title")).click();
                manageLessonDDPopups = new EditLessonTitlePopupPage();
                break;
        }
        return manageLessonDDPopups;
    }
}


