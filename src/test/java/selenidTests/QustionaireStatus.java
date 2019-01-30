package selenidTests;

import Helpers.ParametersHelper;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.collections.Texts;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class QustionaireStatus extends ParametersHelper {
    //Templates
    String table = "div.table-content-rows";
    String checkbox = "input.checkbox";
    String checkboxdis = "svg-icon.checkbox-custom disabled";
    String click = "label.label-checkbox";
    String sentemail = "div.sent-email_container";
    String rowscontenner = "div.rows-container";
    String listTemplates = "div.ellipsis_box";
    String textTeplate = "label.sent-email_email_info";
    //createTemplate
    String templateButton = "button.theme--gray_icon";
    String templateCollection = "div.dropdown-content";


    //Search
    String header = "div.table-container";
    String searchButton = "div.filter-btn";
    String searchField = "div.class*= ng-untouched";
    String input = "input.filter-input";
    String list = "div.item ng-star-inserted";
    String error = "div.empty";
    //Checkboxes
    String filter = "div.table-filter-btn";
    String contener = "div.menu-item-container";
    String disabled = "svg-icon.class$='disabled'";


    @Before
    public void OpenRegistration() {
        autorisation();
        questionareStatus();
        comboboxes();

    }

    @Test
    public void aOpenQS() {
        $(By.cssSelector("div.header")).shouldHave(text("QUESTIONNAIRE STATUS"));
        $(By.cssSelector("table-content"));
    }


    @Test
    public void bOpenFilterCompleted() {


        $$(table).find(Condition.attribute(checkbox));//проверка на отображение задизейбленных чекбоксов
        $$(table).find(cssClass(checkboxdis));//проверка на активные чекбоксы
        $(filter).click();
        $(contener).shouldHave(text("Completed")).click();
        $$(rowscontenner).find(Condition.attribute(disabled));
    }

    @Test
    public void cOpenFilterNotCompleted() {


        $$(table).find(Condition.attribute(checkbox));//проверка на отображение задизейбленных чекбоксов
        $$(table).find(cssClass(checkboxdis));//проверка на активные чекбоксы
        $(filter).click();
        $$(contener).findBy(text("Not Completed")).click();
        $$(rowscontenner).find(Condition.attribute(checkboxdis));
        $(checkbox).shouldBe(empty);
    }

    @Test
    public void dOpenFilterAll() {


        $$(table).find(Condition.attribute(checkbox));//проверка на отображение задизейбленных чекбоксов
        $$(table).find(cssClass(checkboxdis));//проверка на активные чекбоксы
        $(filter).click();
        $$(contener).findBy(text("All")).click();
        $$(rowscontenner).find(Condition.attribute(checkboxdis));
        $$(rowscontenner).find(Condition.attribute(checkbox));
    }

    @Test
    public void eSearch() {

        $(header).find(searchButton);
        $(searchButton).click();
        $(header).find(searchField);
        $(input).setValue("Brown");
        $$(list).find(text("Brown"));

    }

    @Test
    public void fSearchIncorrectData() {

        $(header).find(searchButton);
        $(searchButton).click();
        $(header).find(searchField);
        $(input).setValue("te1st");
        $(error).shouldHave(text("You have no players"));

    }

    @Test
    public void gSearchSpaces() {

        $(header).find(searchButton);
        $(searchButton).click();
        $(header).find(searchField);
        $(input).setValue("   ");
        $(table).shouldNot(empty);

    }

    @Test
    public void hOpenMassEmail() {

        $$(table).find(Condition.attribute(checkbox));//проверка на отображение задизейбленных чекбоксов
        $$(table).find(cssClass(checkboxdis));//проверка на активные чекбоксы
        $(click).click();
        $(sentemail).shouldHave(text("MASS EMAIL"));
    }

    @Test
    public void iClosedMassEmail() {

        $$(table).find(Condition.attribute(checkbox));//проверка на отображение задизейбленных чекбоксов
        $$(table).find(cssClass(checkboxdis));//проверка на активные чекбоксы
        $(click).click();
        $(click).click();
        $(sentemail).shouldNot(text("MASS EMAIL"));
    }

    @Test
    public void jOpenSelectTemplate() {

        $$(table).find(Condition.attribute(checkbox));//проверка на отображение задизейбленных чекбоксов
        $$(table).find(cssClass(checkboxdis));//проверка на активные чекбоксы
        $(click).click();
        $(sentemail).shouldHave(text("MASS EMAIL"));
        $(By.name("template")).click();
        $(listTemplates).shouldHave(text("Innerzone® Invitation Email")).click();
        $(textTeplate).shouldHave(text("[User Login Information Displays Here]"));


    }

    @Test
    public void kOpenCreateTemplate() {

        $$(table).find(Condition.attribute(checkbox));//проверка на отображение задизейбленных чекбоксов
        $$(table).find(cssClass(checkboxdis));//проверка на активные чекбоксы
        $(click).click();
        $(sentemail).shouldHave(text("MASS EMAIL"));
        //$(By.name("template")).click();
        $(templateButton).click();//открывается окно создания темплейта
        $(sentemail).shouldHave(text("NEW MESSAGE TEMPLATE"));
    }

    @Test
    public void lCreateTemplate() {

        $$(table).find(Condition.attribute(checkbox));//проверка на отображение задизейбленных чекбоксов
        $$(table).find(cssClass(checkboxdis));//проверка на активные чекбоксы
        $(click).click();
        $(sentemail).shouldHave(text("MASS EMAIL"));
        $(templateButton).click();//открывается окно создания темплейта
        $(sentemail).shouldHave(text("NEW MESSAGE TEMPLATE"));
        $(By.name("title")).setValue("Test Temp");
        $(By.name("subject_line")).setValue("Test123");
        $(By.cssSelector("textarea.sent-email_content")).setValue("Test message");
        $(By.name("closing")).setValue("ClosingText");
        $(By.name("signature")).setValue("DisabledText").pressEnter();
        $(sentemail).shouldHave(text("MASS EMAIL"));
        $(By.name("template")).click();
        $(templateCollection).shouldHave(text("Test Temp"));

    }

    @Test
    public void mCreateEmptyTemplate() {

        $$(table).find(Condition.attribute(checkbox));//проверка на отображение задизейбленных чекбоксов
        $$(table).find(cssClass(checkboxdis));//проверка на активные чекбоксы
        $(click).click();
        $(sentemail).shouldHave(text("MASS EMAIL"));
        $(templateButton).click();//открывается окно создания темплейта
        $(sentemail).shouldHave(text("NEW MESSAGE TEMPLATE"));
        $(By.name("title")).setValue("");
        $(By.name("subject_line")).setValue("");
        $(By.cssSelector("textarea.sent-email_content")).setValue("");
        $(By.name("closing")).setValue("");
        $(By.name("signature")).setValue("").pressEnter();

        $(By.name("subject_line")).shouldHave(cssClass("ng-invalid"));
//        boolean invaid = $("input[class$='ng-invalid']").isDisplayed();
//        if(!invaid){
//            screenshot("/Users/ivanzherebilov/Desktop/Новая папка 4");
//        }
        $(By.cssSelector("textarea.sent-email_content")).shouldHave(cssClass("ng-invalid"));
        $(By.name("closing")).shouldHave(cssClass("ng-invalid"));
        $(By.name("signature")).shouldHave(cssClass("ng-invalid"));

    }

    @Test
    public void nClickEditTemplate() {

        $$(table).find(Condition.attribute(checkbox));//проверка на отображение задизейбленных чекбоксов
        $$(table).find(cssClass(checkboxdis));//проверка на активные чекбоксы
        $(click).click();
        $(sentemail).shouldHave(text("MASS EMAIL"));
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/app-email-messages/app-dashboard-title/div[2]/div/div/iz-email-sent/span/iz-email-main/div/form/div[1]/dropdown/div/div/label")).click();
        $$("#div.dropdown-content").find(text("Test Temp"));
        $$("div[class*='dropdown-content-item']").find(text("Test Temp")).hover().find("img[alt*='edit']").click();
        $(By.cssSelector("div.sent-email_title")).shouldHave(text("EDIT MESSAGE TEMPLATE"));
    }

    @Test
    public void oEditTemplate() {

        $$(table).find(Condition.attribute(checkbox));//проверка на отображение задизейбленных чекбоксов
        $$(table).find(cssClass(checkboxdis));//проверка на активные чекбоксы
        $(click).click();
        $(sentemail).shouldHave(text("MASS EMAIL"));
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/app-email-messages/app-dashboard-title/div[2]/div/div/iz-email-sent/span/iz-email-main/div/form/div[1]/dropdown/div/div/label")).click();
        $$("#div.dropdown-content").find(text("Test Temp"));
        $$("div[class*='dropdown-content-item']").find(exactText("Test Temp")).hover().find("img[alt*='edit']").click();
        $(By.cssSelector("div.sent-email_title")).shouldHave(text("EDIT MESSAGE TEMPLATE"));
        $(By.name("title")).setValue("Test Temps");
        $(By.cssSelector("button[class*='theme--default size--small_text_bold icon_position--left']")).click();
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/app-email-messages/app-dashboard-title/div[2]/div/div/iz-email-sent/span/iz-email-main/div/form/div[1]/dropdown/div/div/label")).click();
        $("div[class*='dropdown-content']").shouldHave(text("Test Temps"));
        $$("span[class*='dropdown-content-item__text']").findBy(exactText("Test Temp")).shouldBe(hidden);
        //    $$("#div[class*='dropdown-content-item']").findBy();
    }

    @Test
    public void pDeleteTemplate() {

        $$(table).find(Condition.attribute(checkbox));//проверка на отображение задизейбленных чекбоксов
        $$(table).find(cssClass(checkboxdis));//проверка на активные чекбоксы
        $(click).click();
        $(sentemail).shouldHave(text("MASS EMAIL"));
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/app-email-messages/app-dashboard-title/div[2]/div/div/iz-email-sent/span/iz-email-main/div/form/div[1]/dropdown/div/div/label")).click();
        $$("#div.dropdown-content").find(text("Test Temps"));
        $$("div[class*='dropdown-content-item']").find(exactText("Test Temps")).hover().find("img[src*='assets/images/dropdown-menu/delete.svg']").click();
        $("div[class*='content'").shouldHave(text("Delete")).click();
    }

}
