package ponsTests;

import configuration.SelenideConfiguration;
import org.junit.jupiter.api.Test;
import pageObjects.vocabularyTrainer.LessonSettingsMenue.LessonSettingsMenuPage;
import pageObjects.vocabularyTrainer.LessonSettingsMenue.LessonSettingsMenueOptions;
import pageObjects.vocabularyTrainer.LessonSettingsMenue.ManageEntriesDD.ManageEntriesDdPage;
import pageObjects.vocabularyTrainer.LessonSettingsMenue.ManagelessonDD.ManagelessonDDPopups.ResetThisLessonsProgressLevelPopupPage;
import pageObjects.vocabularyTrainer.VocabularyTrainerPage;

import static com.codeborne.selenide.Condition.*;

public class ponsTests extends SelenideConfiguration {

    @Test
    public void createNewLesson() {
        String lessonTitleToCreate = "lesson0007";
        VocabularyTrainerPage vocabularyTrainerPage = new VocabularyTrainerPage().openVocabularyTrainerPage();

        //create lesson (using method of VocabularyTrainerPage)
        vocabularyTrainerPage.createNewLesson(lessonTitleToCreate);

        //check lesson has appeared
        vocabularyTrainerPage
                .findLessonByTitle(lessonTitleToCreate)
                .shouldHave(exactOwnText(lessonTitleToCreate));
    }

    @Test
    public void deleteLesson() {
        String lessonTitle = "lessonXX001";
        VocabularyTrainerPage vocabularyTrainerPage = new VocabularyTrainerPage()
                .openVocabularyTrainerPage();

        vocabularyTrainerPage
                .createNewLesson(lessonTitle);
        vocabularyTrainerPage
                .findLessonByTitle(lessonTitle)
                .shouldHave(exactOwnText(lessonTitle));

        vocabularyTrainerPage.deleteLesson(lessonTitle);
        vocabularyTrainerPage
                .findLessonByTitle(lessonTitle)
                .shouldNot(exist);
    }

    @Test
    public void editLessonTitle() {
        String lessonTitleToUpdate = "lesson0004";
        String newLessonTitle = "editedLessonTitle004";

        VocabularyTrainerPage vocabularyTrainerPage = new VocabularyTrainerPage()
                .openVocabularyTrainerPage();

        vocabularyTrainerPage
                .createNewLesson(lessonTitleToUpdate);
        vocabularyTrainerPage
                .findLessonByTitle(lessonTitleToUpdate)
                .shouldHave(exactOwnText(lessonTitleToUpdate));

        vocabularyTrainerPage
                .editLessonTitle(lessonTitleToUpdate, newLessonTitle);

        vocabularyTrainerPage
                .findLessonByTitle(newLessonTitle)
                .shouldHave(exactOwnText(newLessonTitle));
    }

    @Test
    public void resetLessonsProgressLevel() {
        String lessonToReset = "lessonToResetProgress0001";
        String expectedPopupMessage = "The progress level for all vocabulary in this lesson has been reset.";
        VocabularyTrainerPage vocabularyTrainerPage = new VocabularyTrainerPage().openVocabularyTrainerPage();

        vocabularyTrainerPage
                .createNewLesson(lessonToReset);

        vocabularyTrainerPage
                .resetThisLessonsProgressLevel(lessonToReset);

        new ResetThisLessonsProgressLevelPopupPage()
                .getConfirmationLevelHasBeenReset()
                .shouldHave(exactOwnText(expectedPopupMessage));
    }

    @Test
    public void keyInNewVocabularyOrdinary(){
        String involvedLesson = "lessonToAddWord0001";
        String word = "book";
        String translation = "книга";

        VocabularyTrainerPage vocTrainPage = new VocabularyTrainerPage().openVocabularyTrainerPage();

        vocTrainPage.createNewLesson(involvedLesson);

        ManageEntriesDdPage manageEntriesDdPage = (ManageEntriesDdPage) vocTrainPage
                .clickLessonSettingsMenuBTN(involvedLesson)
                .clickLessonSettingsMenuOption(
                        LessonSettingsMenueOptions.MANAGE_ENTRIES);

        manageEntriesDdPage.keyInNewVocabulary(word, translation);
        new LessonSettingsMenuPage()
                .getListOfWords()
                .findBy(exactText(word));
    }
}

















