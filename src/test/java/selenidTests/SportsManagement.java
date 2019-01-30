package selenidTests;

import Helpers.ObjectHelper;
import Helpers.ParametersHelper;
import com.codeborne.selenide.Condition;
import com.sun.tools.javac.util.Assert;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import sun.jvm.hotspot.interpreter.Bytecodes;

import java.time.Instant;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SportsManagement extends ParametersHelper {

    Instant instant = Instant.now();
    long timeStampSeconds = instant.getEpochSecond();

    String firstName = (objectHelper.firstName() + timeStampSeconds);
    String lastName = (objectHelper.lastName() + timeStampSeconds);

    @Before
    public void OpenRegistration() {

        autorisation();
        sportsManagement();
        comboboxes();


    }

    @Test
    public void cCreatePlayer() {
        $(By.xpath("//*[@id=\"tableRoot\"]/span/app-table-columns/div/app-table-column/div/div/div[2]/app-table-filter[2]/div/svg-icon")).click();
        $("label.ng-star-inserted").waitUntil(visible, 3000);
        $$("div.dropdown").find(text(" - No Selection")).find("span.dropdown-icon").click();
        $$("div.dropdown-content-item").find(text("Midfielder")).click();
        $$("div.select-group").findBy(text("Title")).find("span.dropdown-icon").click();
        $$("span.dropdown-content-item-row").find(text("Mr")).click();
        $(By.name("first_name")).setValue(firstName);
        $(By.name("last_name")).setValue(lastName);
        $(By.name("number")).setValue("27");
        $(By.name("email")).setValue(timeStampSeconds + objectHelper.email());
        $(By.name("username")).setValue(objectHelper.username() + timeStampSeconds);
        $(By.name("password")).setValue("qwerty");
        $(By.cssSelector("button.theme--default")).click();
        $$(By.cssSelector("span.name")).find(text(firstName + lastName));

    }

    @Test
    public void aIncorrectUsernamePlayer() {
        $(By.xpath("//*[@id=\"tableRoot\"]/span/app-table-columns/div/app-table-column/div/div/div[2]/app-table-filter[2]/div/svg-icon")).click();
        $("label.ng-star-inserted").waitUntil(visible, 3000);
        $$("div.dropdown").find(text(" - No Selection")).find("span.dropdown-icon").click();
        $$("div.dropdown-content-item").find(text("Midfielder")).click();
        $$("div.select-group").findBy(text("Title")).find("span.dropdown-icon").click();
        $$("span.dropdown-content-item-row").find(text("Mr")).click();
        $(By.name("first_name")).setValue(firstName);
        $(By.name("last_name")).setValue(lastName);
        $(By.name("number")).setValue("27");
        $(By.name("email")).setValue(timeStampSeconds + objectHelper.email());
        $(By.name("username")).setValue("qwe");
        $(By.name("password")).setValue("qwerty");
        $(By.cssSelector("button.theme--default")).click();
        $(By.name("username")).shouldHave(cssClass("ng-invalid"));
        // $$(By.cssSelector("span.name")).find()(text(firstName + lastName));
    }

    @Test
    public void bEmptyFieldsPlayer() {
        $(By.xpath("//*[@id=\"tableRoot\"]/span/app-table-columns/div/app-table-column/div/div/div[2]/app-table-filter[2]/div/svg-icon")).click();
        $(By.name("first_name")).setValue("");
        $(By.name("last_name")).setValue("");
        $(By.name("number")).setValue("");
        $(By.name("email")).setValue("");
        $(By.name("username")).setValue("");
        $(By.name("password")).setValue("");
        $(By.cssSelector("button.theme--default")).click();
        $(By.name("first_name")).shouldHave(cssClass("ng-invalid"));
        $(By.name("last_name")).shouldHave(cssClass("ng-invalid"));
        $(By.name("number")).shouldHave(cssClass("ng-invalid"));
        $(By.name("email")).shouldHave(cssClass("ng-invalid"));
        $(By.name("password")).shouldHave(cssClass("ng-invalid"));
        $(By.name("username")).shouldHave(cssClass("ng-invalid"));
        // $$(By.cssSelector("span.name")).find()(text(firstName + lastName));
    }

    @Test
    public void dClosedForm() {
        $(By.xpath("//*[@id=\"tableRoot\"]/span/app-table-columns/div/app-table-column/div/div/div[2]/app-table-filter[2]/div/svg-icon")).click();
        $("svg-icon[src*='assets/images/common/close.svg']").click();
        $("label.title").waitUntil(disappear, 2000);

    }

    @Test
    public void eClosedCoachForm() {
        $("div.coach").shouldHave(text("COACHING STAFF")).find("div.table-filter-btn").click();
        $("svg-icon[src*='assets/images/common/close.svg']").click();
        $("label.title").waitUntil(disappear, 2000);

    }

    @Test
    public void fFilterSearchPlayer() {
        $("div.filter-btn").click();
        $("input.filter-input");
    }

    @Test
    public void gSearchPlayer() {
        $("div.filter-btn").click();
        $("input.filter-input").setValue("Tonyso");
        $(By.cssSelector("div.table-container-row")).shouldHave(text("548656231"));

    }

    @Test

    public void hOpenCoachForm() {
        $("div.coach").shouldHave(text("COACHING STAFF")).find("div.table-filter-btn").click();
        $("div.users-container").find("div.header").shouldHave(text("ADD USER"));
    }

    @Test

    public void lCreateCoach() {
        $("div.coach").shouldHave(text("COACHING STAFF")).find("div.table-filter-btn").click();
        $("div.users-container").find("div.header").shouldHave(text("ADD USER"));
        $$("div.dropdown").find(text(" - No Selection")).find("span.dropdown-icon").click();
        $$("div.dropdown-content-item").find(text("Coach")).click();
        $$("div.select-group").findBy(text("Title")).find("span.dropdown-icon").click();
        $$("span.dropdown-content-item-row").find(text("Mr")).click();
        $(By.name("first_name")).setValue(firstName);
        $(By.name("last_name")).setValue(lastName);
        $(By.name("email")).setValue(timeStampSeconds + objectHelper.email());
        $(By.name("username")).setValue(objectHelper.username() + timeStampSeconds);
        $(By.name("password")).setValue("qwerty");
        $(By.cssSelector("button.theme--default")).click();
        $(By.cssSelector("div.coach")).find("div.rows-container").shouldHave(text(firstName));

    }

    @Test
    public void iCreateEmptyCoach() {
        $("div.coach").shouldHave(text("COACHING STAFF")).find("div.table-filter-btn").click();
        $(By.name("first_name")).setValue("");
        $(By.name("last_name")).setValue("");
        $(By.name("email")).setValue("");
        $(By.name("username")).setValue("");
        $(By.name("password")).setValue("");
        $(By.cssSelector("button.theme--default")).click();
        $(By.name("first_name")).shouldHave(cssClass("ng-invalid"));
        $(By.name("last_name")).shouldHave(cssClass("ng-invalid"));
        $(By.name("email")).shouldHave(cssClass("ng-invalid"));
        $(By.name("username")).shouldHave(cssClass("ng-invalid"));
        $(By.name("username")).shouldHave(cssClass("ng-invalid"));
        $(By.name("password")).shouldHave(cssClass("ng-invalid"));


    }

    @Test

    public void jCreateCoachIncorrectUsername() {
        $("div.coach").shouldHave(text("COACHING STAFF")).find("div.table-filter-btn").click();
        $("div.users-container").find("div.header").shouldHave(text("ADD USER"));
        $$("div.dropdown").find(text(" - No Selection")).find("span.dropdown-icon").click();
        $$("div.dropdown-content-item").find(text("Coach")).click();
        $$("div.select-group").findBy(text("Title")).find("span.dropdown-icon").click();
        $$("span.dropdown-content-item-row").find(text("Mr")).click();
        $(By.name("first_name")).setValue(firstName);
        $(By.name("last_name")).setValue(lastName);
        $(By.name("email")).setValue(timeStampSeconds + objectHelper.email());
        $(By.name("username")).setValue("asa");
        $(By.name("password")).setValue("qwerty");
        $(By.cssSelector("button.theme--default")).click();
        $(By.name("username")).shouldHave(cssClass("ng-invalid"));


    }

    @Test

    public void kCreateCoachIncorrectEmail() {
        $("div.coach").shouldHave(text("COACHING STAFF")).find("div.table-filter-btn").click();
        $("div.users-container").find("div.header").shouldHave(text("ADD USER"));
        $$("div.dropdown").find(text(" - No Selection")).find("span.dropdown-icon").click();
        $$("div.dropdown-content-item").find(text("Coach")).click();
        $$("div.select-group").findBy(text("Title")).find("span.dropdown-icon").click();
        $$("span.dropdown-content-item-row").find(text("Mr")).click();
        $(By.name("first_name")).setValue(firstName);
        $(By.name("last_name")).setValue(lastName);
        $(By.name("email")).setValue("mail@mail.c");
        $(By.name("username")).setValue(objectHelper.generateRandomUsername() + timeStampSeconds);
        $(By.name("password")).setValue("qwerty");
        $(By.cssSelector("button.theme--default")).click();
        $(By.name("email")).shouldHave(cssClass("ng-invalid"));

    }

    @Test
    public void mSearchCoach() {
        $("div.coach").shouldHave(text("COACHING STAFF")).find("div.filter-btn").click();
        String nameCoach = $("div.coach").find("span.name-coach").getText();
        $("div.coach").find("input.filter-input").setValue(nameCoach);
        $("div.coach").find(By.cssSelector("div.table-container-row")).shouldHave(text(nameCoach));
    }

    @Test
    public void nSearchIncorrectCoach() {
        $("div.coach").shouldHave(text("COACHING STAFF")).find("div.filter-btn").click();
        String nameCoach = $("div.coach").find("span.name-coach").getText();
        $("div.coach").find("input.filter-input").setValue("sdfsdfsdfd");
        $("div.coach").find(By.cssSelector("div.empty")).shouldHave(text("You have no coaches"));
    }

    @Test
    public void oClearSearchField() {
        $("div.coach").shouldHave(text("COACHING STAFF")).find("div.filter-btn").click();
        String nameCoach = $("div.coach").find("span.name-coach").getText();
        $("div.coach").find("input.filter-input").setValue("sdfsdfsdfd");
        $("div.coach").find("button.reset").click();
        $("div.coach").find(By.cssSelector("div.empty")).shouldNot(text("sdfsdfsdfd"));
        //  $("div.coach").find("div.rows-container").find("span.ame-coach");
    }

    @Test
    public void pEditPlayer() {
        $("div.players").find("div.table-row").find("div.table-container-row").find("button.theme--white_icon").click();
        $("div.table-root").find("div.container-menu").find("svg-icon.checkbox-custom").click();
        $(By.name("first_name")).setValue("Tonys");
        $("button.theme--default").click();
        $("div.table-root").find("div.rows-container").shouldHave(text("Tonys"));


        //$("div.users-container").shouldHave(text("EDIT"));
    }

    @Test
    public void qEditPlayerForm() {
        $("div.players").find("div.table-row").find("div.table-container-row").find("button.theme--white_icon").click();
        $("div.table-root").find("div.container-menu").find("svg-icon.checkbox-custom").click();
        $(By.name("first_name")).setValue("Tonyso");
        $("button.theme--default").click();
        $("button.theme--default").waitUntil(hidden, 3000);
        $("div.players").find("div.table-row").find("div.table-container-row").find("button.theme--white_icon").click();
        $("div.table-root").find("div.container-menu").find("svg-icon.checkbox-custom").click();
        String assertValue = $(By.name("first_name")).getValue();
        assertEquals(assertValue, "Tonyso");

    }

    @Test
    public void rOpenProfile() {
        $("div.players").find("div.table-row").find("div.table-container-row").find("button.theme--white_icon").click();
        $$("div.menu-item-container").find(text("Profile")).click();
        $("div.profile-info-container").shouldHave(text("COMMUNICATION PROJECTION"));
    }

    @Test
    public void sEditCopy() {
        $("div.players").find("div.table-row").find("div.table-container-row").find("button.theme--white_icon").click();
        $("div.table-root").find("div.container-menu").find("svg-icon.checkbox-custom").click();
        $("button.theme--gray").click();
        $("div.container-copy-move").shouldHave(text("Move"));
    }

    @Test
    public void tEditMoveNoCash() {
        moveData();
        $("svg-icon[src*='assets/images/common/close.svg']").waitUntil(visible,3000).click();
        $("div.players").find("div.table-row").find("div.table-container-row").find("button.theme--white_icon").click();
        $("div.table-root").find("div.container-menu").find("svg-icon.checkbox-custom").click();
        $("button.theme--gray").click();
        $("div.container-copy-move").find("div.dropdown").shouldHave(text("- No Selection"));
    }
    @Test
    public void uEditOpenCopy() {
        $("div.players").find("div.table-row").find("div.table-container-row").find("button.theme--white_icon").click();
        $("div.table-root").find("div.container-menu").find("svg-icon.checkbox-custom").click();
        $("button.theme--gray").click();
        $$("label.radio-custom-label").find(text("Copy")).click();
        $("div.container-copy-move").find("span.ng-star-inserted").shouldHave(text("Copy"));

    }
    @Test @Ignore
    public void vFieldsCopy(){
        $("div.players").find("div.table-row").find("div.table-container-row").find("button.theme--white_icon").click();
        $("div.table-root").find("div.container-menu").find("svg-icon.checkbox-custom").click();
        $("button.theme--gray").click();
        $$("label.radio-custom-label").find(text("Copy")).click();
        $("div.container-copy-move").find("span.ng-star-inserted").shouldHave(text("Copy"));

        $$("div.dropdown").find(text("- No Selection")).find("span.dropdown-icon").click();
        $$("div.dropdown-content-item").find(text("2019")).click();
        $$("div.select-group").findBy(text("Sports")).find("span.dropdown-icon").click();
        $$("div.dropdown-content-item").find(text("Basketball")).click();
//        $$("div.dropdown").findBy(text("- No Selection")).find("span.dropdown-icon").click();
//        $$("div.dropdown-content-item").find(text("Loco4")).click();
        $$("div.dropdown").findBy(text(" - No Selection")).find("span.dropdown-icon").click();
        $$("div.dropdown-content-item").find(text("Guard")).click();

    }
    @Test
    public void wFieldsCopyNoCash(){
        copyData();
        $("div.players").find("div.table-row").find("div.table-container-row").find("button.theme--white_icon").click();
        $("div.table-root").find("div.container-menu").find("svg-icon.checkbox-custom").click();
        $("button.theme--gray").click();
        $$("label.radio-custom-label").find(text("Copy")).click();
        $("div.container-copy-move").find("span.ng-star-inserted").shouldHave(text("Copy"));
        $("div.container-copy-move").find("div.dropdown").shouldHave(text("adickerson1548316124"));
        $$("div.dropdown").find(text("- No Selection")).find("span.dropdown-icon");
    }

    @Test

    public void xEmptiMoveFields(){
        $("div.players").find("div.table-row").find("div.table-container-row").find("button.theme--white_icon").click();
        $("div.table-root").find("div.container-menu").find("svg-icon.checkbox-custom").click();
        $("button.theme--gray").click();
        $("button.theme--default").click();
        $(By.name("name")).shouldHave(cssClass("ng-invalid"));
 //       $(By.name("season")).shouldHave(cssClass("ng-pristine"));
//        $(By.name("sport")).shouldHave(cssClass("ng-invalid"));
//        $(By.name("name")).shouldHave(cssClass("ng-invalid"));
//        $("div.container-copy-move").find(By.name("position")).shouldHave(cssClass("ng-pristine"));

    }

@Test
    public void yMovePlayer(){
    moveData();//данные, для перемещения юзера + кнопка перемещения
    fiters();//выпадающиесписки, для перехода в другую команду
    $$("div.table-container-row").find(text("Tonyso"));//проверка того, что юзер перемещён
    backPlayer();//возвращаем юзера обратно
    $$("div.table-container-row").find(text("You have no players"));//проверка,что в команде юзеров не осталось
}

@Test
    public void zCopyPlayer(){
    copyData();//копирование юзера
    fiters();//выпадающиесписки, для перехода в другую команду
    $$("div.table-container-row").find(text("Tonyso"));//проверка того, что юзер перемещён
    $("div.players").find("div.table-row").find("div.table-container-row").find("button.theme--white_icon").click();
    $$("div.menu-item-container").find(text("Delete")).click();
}
//    @Test
//    public void dragnDrop() {
//        $$(By.cssSelector("span.name")).findBy(text("Jessie Brown")).waitUntil(visible,3000).dragAndDropTo("div.ngx-dnd-container");
//
//        $(By.cssSelector("div.ngx-dnd-container")).find(By.cssSelector("div.player ng-star-inserted"));
//        //$(By.cssSelector("span.table-content-rows")).shouldNot(text("Jessie Brown"));
//        $(By.cssSelector("span.name")).shouldNot(text("Jessie Brown"));
//    }
//    @Test
//    public void openPlayerMenu() {
//        $$(By.cssSelector("span.name")).findBy(text("Jessie Brown")).waitUntil(visible,3000).dragAndDropTo("div.ngx-dnd-container");
//        $(By.cssSelector("span.number")).click();
//        //$(By.cssSelector("span.table-content-rows")).shouldNot(text("Jessie Brown"));
//        //$(By.cssSelector("div.container-menu"));
//        $$(By.cssSelector("span.menu__primarily menu__info_item")).findBy(text("%"));
//    }
//    @Test
//    public void returnPlayer() {
//        $$(By.cssSelector("span.name")).findBy(text("Jessie Brown")).waitUntil(visible,3000).dragAndDropTo("div.ngx-dnd-container");
//        $(By.cssSelector("div.player")).click();
//     //   $$(By.cssSelector("div.menu__actions")).findBy(Condition.attribute("Return to bench")).click();
//        //$(By.cssSelector("span.table-content-rows")).shouldNot(text("Jessie Brown"));
//       // $(By.cssSelector("div.ngx-dnd-container")).shouldNot(Condition.attribute("div.player ng-star-inserted"));
//    }
}