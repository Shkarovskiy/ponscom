package pageObjects.vocabularyTrainer.LessonSettingsMenue.ManageEntriesDD;

import static com.codeborne.selenide.Condition.exactOwnText;
import com.codeborne.selenide.ElementsCollection;
import pageObjects.vocabularyTrainer.LessonSettingsMenue.LessonSettingsMenueOptionParent;
import pageObjects.vocabularyTrainer.LessonSettingsMenue.ManageEntriesDD.ManageEntriesDDPopups.KeyInNewVocabularyPopupPage;
import pageObjects.vocabularyTrainer.LessonSettingsMenue.ManageEntriesDD.ManageEntriesDDPopups.ManageEntriesDdPopupParent;

import static com.codeborne.selenide.Selenide.$$;

public class ManageEntriesDdPage extends LessonSettingsMenueOptionParent {
    private ManageEntriesDdPopupParent manageEntriesDdPopupParent;
    private ElementsCollection manageEntriesDdOptions =  $$(".lesson-navbar .dropdown-menu li a");

    public ManageEntriesDdPopupParent clickManageEntriesDdOption(ManageEntriesDDOptions manageEntriesDDOptions){
        switch (manageEntriesDDOptions){
            case KEY_IN_NEW_VOCABULARY:
                manageEntriesDdOptions.findBy(exactOwnText("Key in new vocabulary")).click();
                manageEntriesDdPopupParent = new KeyInNewVocabularyPopupPage();
        }
        return manageEntriesDdPopupParent;
    }

    public void keyInNewVocabulary(String word, String translation){
        KeyInNewVocabularyPopupPage keyInNewVocabularyPopupPage = (KeyInNewVocabularyPopupPage) clickManageEntriesDdOption(
                ManageEntriesDDOptions.KEY_IN_NEW_VOCABULARY);
        keyInNewVocabularyPopupPage.setWordOrPhraseField(word);
        keyInNewVocabularyPopupPage.setTranslationField(translation);
        keyInNewVocabularyPopupPage.clickSaveAndReturnToLessons();
    }
}
