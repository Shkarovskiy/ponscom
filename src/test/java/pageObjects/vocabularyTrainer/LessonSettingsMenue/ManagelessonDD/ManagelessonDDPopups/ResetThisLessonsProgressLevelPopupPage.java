package pageObjects.vocabularyTrainer.LessonSettingsMenue.ManagelessonDD.ManagelessonDDPopups;

import com.codeborne.selenide.SelenideElement;
import pageObjects.vocabularyTrainer.LessonSettingsMenue.ManagelessonDD.ManageLessonDDPopups;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResetThisLessonsProgressLevelPopupPage implements ManageLessonDDPopups {
    private SelenideElement yesBTN = $(".btn.btn-danger");
    private SelenideElement confirmationLevelHasBeenReset = $(byText("The progress level for all vocabulary in this lesson has been reset."));

    @Override
    public void clickYesBTN() {
        yesBTN.click();
    }

    @Override
    public void setEditLessonTitleField(String lessonTitle) {

    }

    public SelenideElement getConfirmationLevelHasBeenReset(){
        return confirmationLevelHasBeenReset;
    }
}
