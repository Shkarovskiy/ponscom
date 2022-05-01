package pageObjects.vocabularyTrainer.AddLessonDD;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CreateLessonPopupPage {
    private SelenideElement titleField = $("#new-entry-title");
    private SelenideElement saveBTN = $(".btn.btn-success");

    public void setTitleField(String lessonTitle){
        titleField.val(lessonTitle);
    }

    public void clickSaveBTN(){
        saveBTN.click();
    }
}
