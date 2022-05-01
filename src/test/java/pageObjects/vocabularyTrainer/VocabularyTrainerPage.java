package pageObjects.vocabularyTrainer;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pageObjects.PageObjectParent;
import pageObjects.vocabularyTrainer.AddLessonDD.AddLessonDDPage;
import pageObjects.vocabularyTrainer.AddLessonDD.CreateLessonPopupPage;
import pageObjects.vocabularyTrainer.LessonSettingsMenue.LessonSettingsMenuePage;
import pageObjects.vocabularyTrainer.LessonSettingsMenue.ManagelessonDD.ManageLessonDDOptions;
import pageObjects.vocabularyTrainer.LessonSettingsMenue.ManagelessonDD.ManageLessonDDPopups;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class VocabularyTrainerPage extends PageObjectParent {

    private String vocabularyTrainerPageURL = "https://trainer.pons.com/dictionaries/bgru/lessons";

    private SelenideElement addLessonDDBTN = $("div.manage-lessons.dropdown span");
    //private SelenideElement LessonSettingsMenueBTN; //is derived from listOfAllDisplayedLessons

    private ElementsCollection listOfAllDisplayedLessons = $$("div.lesson__title span:first-child");

    public VocabularyTrainerPage openVocabularyTrainerPage() {
        return (VocabularyTrainerPage) openPage(vocabularyTrainerPageURL);
    }

    public AddLessonDDPage clickAddLessonDDBTN() {
        addLessonDDBTN.click();
        return new AddLessonDDPage();
    }

    public SelenideElement findLessonByTitle(String searchedLessonTitle) {
        return listOfAllDisplayedLessons.
                findBy(exactText(searchedLessonTitle));
    }

    public void createNewLesson(String titleOfNewLesson) {
        CreateLessonPopupPage createLessonPopupPage =
                clickAddLessonDDBTN()
                        .clickCreateNewlesson();

        createLessonPopupPage.setTitleField(titleOfNewLesson);
        createLessonPopupPage.clickSaveBTN();
    }

    public LessonSettingsMenuePage clickLessonSettingsMenuBTN(String titleOfTargetLesson) {
        listOfAllDisplayedLessons.
                findBy(exactText(titleOfTargetLesson))
                .ancestor("div")
                .sibling(1)
                .click();
        return new LessonSettingsMenuePage();
    }

    public void deleteLesson(String titleOfLessonToDelete) {
        clickLessonSettingsMenuBTN(titleOfLessonToDelete)
                .clickManageLessonDDBTN()
                .clickManagelessonDDOption(
                        ManageLessonDDOptions.DELETE_LESSON)
                .clickYesBTN();
        System.out.println("---delete");
    }

    public void editLessonTitle(String lessonToUpdate, String newLessonTitle){
        ManageLessonDDPopups editLessonTitlePopupPage =
                clickLessonSettingsMenuBTN(lessonToUpdate)
                .clickManageLessonDDBTN()
                .clickManagelessonDDOption(
                        ManageLessonDDOptions.EDIT_LESSON_TITLE);

        editLessonTitlePopupPage
                .setEditLessonTitleField(newLessonTitle);
        editLessonTitlePopupPage
                .clickYesBTN();
    }

}



















