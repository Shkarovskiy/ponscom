package pageObjects.vocabularyTrainer.AddLessonDD;

import static com.codeborne.selenide.Condition.exactText;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;

public class AddLessonDDPage {
    private ElementsCollection listOfAllOptions = $$("div.manage-lessons.dropdown.open ul.dropdown-menu a");

    public CreateLessonPopupPage clickCreateNewlesson(){
        listOfAllOptions.findBy(exactText("Create new lesson")).click();
        return new CreateLessonPopupPage();
    }
}
