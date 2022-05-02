package ponsTests;

import static com.codeborne.selenide.Condition.exactOwnText;
import configuration.SelenideConfiguration;
import org.junit.jupiter.api.Test;
import pageObjects.mainPage.MainPage;
import pageObjects.vocabularyTrainer.LessonSettingsMenue.ManagelessonDD.ManageLessonDDOptions;
import pageObjects.vocabularyTrainer.LessonSettingsMenue.ManagelessonDD.ManageLessonDDPopups;
import pageObjects.vocabularyTrainer.LessonSettingsMenue.ManagelessonDD.ManagelessonDDPopups.ResetThisLessonsProgressLevelPopupPage;
import pageObjects.vocabularyTrainer.VocabularyTrainerPage;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

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
    public void deleteLesson(){
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
    public void editLessonTitle(){
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
    public void resetLessonsProgressLevel(){
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
}
