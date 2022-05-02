package pageObjects.vocabularyTrainer.LessonSettingsMenue.ManagelessonDD.ManagelessonDDPopups;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class DeleteLessonPopupPage implements ManageLessonDDPopups {
    private SelenideElement yesBTN = $(".btn.btn-danger");

    @Override
    public void clickYesBTN(){
        yesBTN.click();
    }

    @Override
    public void setEditLessonTitleField(String s){
    }
}
