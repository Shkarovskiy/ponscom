package pageObjects.vocabularyTrainer.LessonSettingsMenue.ManagelessonDD.ManagelessonDDPopups;

import com.codeborne.selenide.SelenideElement;
import pageObjects.vocabularyTrainer.LessonSettingsMenue.ManagelessonDD.ManageLessonDDPopups;

import static com.codeborne.selenide.Selenide.$;

public class EditLessonTitlePopupPage implements ManageLessonDDPopups {
    private SelenideElement saveBTN = $(".btn.btn-success");
    private SelenideElement editLessonTitleField = $("[name='title']");


    @Override
    public void clickYesBTN(){
        saveBTN.click();
    }

    public void setEditLessonTitleField(String lessonTitle){
        editLessonTitleField.val(lessonTitle);
    }
}
