package pageObjects.vocabularyTrainer.LessonSettingsMenue.ManageEntriesDD.ManageEntriesDDPopups;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class KeyInNewVocabularyPopupPage extends ManageEntriesDdPopupParent{
    private SelenideElement wordOrPhraseField = $("#new-entry-source");
    private SelenideElement translationField = $("#new-entry-target");
    private SelenideElement addNewExampleBTN = $(".btn.btn-mini");

    private ElementsCollection examplesList = $$("[name='content']");
    private SelenideElement saveAndCreateNewEntryBTN = $$(".btn.btn-success")
            .findBy(Condition.exactOwnText("Save and create new entry"));
    private SelenideElement saveAndReturnToLessons = $$(".btn.btn-success")
            .findBy(Condition.exactOwnText("Save and return to lessons"));

    public void setWordOrPhraseField(String text){
        wordOrPhraseField.val(text);
    }

    public void setTranslationField(String text){
        translationField.val(text);
    }

    public void clickSaveAndReturnToLessons(){
        saveAndReturnToLessons.click();
    }

}
