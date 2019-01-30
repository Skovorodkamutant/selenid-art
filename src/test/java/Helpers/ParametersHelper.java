package Helpers;

import com.codeborne.selenide.Configuration;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;

import java.lang.reflect.Field;
import java.time.Instant;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class ParametersHelper {

    public void getOpen() {
        System.setProperty("selenide.browser","firefox");
        //Configuration.browser = "FIREFOX";
        open("http://sports.innerzone.local/#/login");

    }
    public void getOpenRegistration() {
        System.setProperty("selenide.browser","firefox");
        //Configuration.browser = "FIREFOX";
        open("http://sports.innerzone.local/#/registration");

    }


    public void comboboxes() {
        String plashka = "div.select-group";
        String dropdown = "div.dropdown";
        String vipad = "span.dropdown-content-item-row";

        $$(plashka).findBy(text("Season")).find(dropdown).click();
        $$(vipad).findBy(text("2018")).click();
        $$(plashka).findBy(text("Sport")).find(dropdown).click();
        $$(vipad).findBy(text("Soccer")).click();
        $$(plashka).findBy(text("Team")).find(dropdown).click();
        $$(vipad).findBy(text("Bearcats")).click();

    }

    public void autorisation() {
        open("http://sports.innerzone.local/#/login");
        $(By.id("inputEmail")).setValue("smladmin");
        $(By.id("inputPassword")).setValue("smladmin").pressEnter();
        $(By.xpath("/html/body/app-root/app-dashboard/div/app-navbar/div/span/app-current-entity/modal/div/div/div/div[2]/modal-content/div[2]/div[1]")).click();//выбрать энтити
    }

    public void sportsManagement() {
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/iz-d-menu/div/div[1]/div[1]")).click();
    }

    public void questionareStatus() {

        $(By.xpath("/html/body/app-root/app-dashboard/div/div/iz-d-menu/div/div[2]")).waitUntil(visible, 3000).click();//кнопка раздела

    }


    public final ObjectHelper objectHelper = new ObjectHelper();//объект таймп стемп

    //фэйри
    public String generateRandomUsername() {
        return objectHelper.generateRandomUsername();
    }

    public String firstName() {
        return objectHelper.firstName();
    }

    public String lastName() {
        return objectHelper.lastName();
    }

    public void backPlayer() {
        $("div.players").find("div.table-row").find("div.table-container-row").find("button.theme--white_icon").click();
        $("div.table-root").find("div.container-menu").find("svg-icon.checkbox-custom").click();
        $("button.theme--gray").click();
        $$("label.radio-custom-label").find(text("Move")).click();
        $("div.container-copy-move").find("span.ng-star-inserted").shouldHave(text("Move"));
        $("div.container-copy-move").find("div.select-group").shouldHave(text("Entity")).find("span.dropdown-icon").click();
        $("div.container-copy-move").find("div.dropdown-content-item").shouldHave(text("adickerson1548316124")).click();
        $$("div.dropdown").find(text("- No Selection")).find("span.dropdown-icon").click();
        $$("div.dropdown-content-item").find(text("2018")).click();
        $$("div.select-group").findBy(text("Sports")).find("span.dropdown-icon").click();
        $$("div.dropdown-content-item").find(text("Soccer")).click();
        // $$("div.dropdown").findBy(text(" - No Selection")).find("span.dropdown-icon").click();
        // $$("span.dropdown-content-item__text").find(text("Bearcats")).click();
        $$("div.dropdown").findBy(text(" - No Selection")).find("span.dropdown-icon").click();
        $$("span.dropdown-content-item__text").find(text("Goalkeeper")).click();
        $("body > app-root > app-dashboard > div > div > div > app-sports-management > app-dashboard-title > div.content > div > app-sports-management-board > div > div > div.board.with-shadow > div:nth-child(2) > app-sports-management-tables-change > div.flex-width-row.copy-move.ng-star-inserted > izs-trans-user-window > div > form > button").click();

    }

    public void moveData() {
        $("div.players").find("div.table-row").find("div.table-container-row").find("button.theme--white_icon").click();
        $("div.table-root").find("div.container-menu").find("svg-icon.checkbox-custom").click();
        $("button.theme--gray").click();
        $$("label.radio-custom-label").find(text("Move")).click();
        $("div.container-copy-move").find("span.ng-star-inserted").shouldHave(text("Move"));
        $("div.container-copy-move").find("div.select-group").shouldHave(text("Entity")).find("span.dropdown-icon").click();
        $("div.container-copy-move").find("div.dropdown-content-item").shouldHave(text("adickerson1548316124")).click();
        $$("div.dropdown").find(text("- No Selection")).find("span.dropdown-icon").click();
        $$("div.dropdown-content-item").find(text("2019")).click();
        $$("div.select-group").findBy(text("Sports")).find("span.dropdown-icon").click();
        $$("div.dropdown-content-item").find(text("Basketball")).click();
        //  $$("div.dropdown").findBy(text(" - No Selection")).find("span.dropdown-icon").click();
//    $$("span.dropdown-content-item__text").find(text("Heyho")).click();
        $$("div.dropdown").findBy(text(" - No Selection")).find("span.dropdown-icon").click();
        $$("span.dropdown-content-item__text").find(text("Forward")).click();
        $("body > app-root > app-dashboard > div > div > div > app-sports-management > app-dashboard-title > div.content > div > app-sports-management-board > div > div > div.board.with-shadow > div:nth-child(2) > app-sports-management-tables-change > div.flex-width-row.copy-move.ng-star-inserted > izs-trans-user-window > div > form > button").click();

    }

    public void fiters() {
        $$("div.select-group").findBy(text("Season")).find("div.dropdown").click();
        $$("span.dropdown-content-item-row").findBy(text("2019")).click();
        $$("div.select-group").findBy(text("Sport")).find("div.dropdown").click();
        $$("span.dropdown-content-item-row").findBy(text("Basketball")).click();
        $$("div.select-group").findBy(text("Team")).find("div.dropdown").click();
        $$("span.dropdown-content-item-row").findBy(text("HeyHo")).click();
    }

    public void copyData() {
        $("div.players").find("div.table-row").find("div.table-container-row").find("button.theme--white_icon").click();
        $("div.table-root").find("div.container-menu").find("svg-icon.checkbox-custom").click();
        $("button.theme--gray").click();
        $$("label.radio-custom-label").find(text("Copy")).click();
        $("div.container-copy-move").find("span.ng-star-inserted").shouldHave(text("Copy"));
        $$("div.dropdown").find(text("- No Selection")).find("span.dropdown-icon").click();
        $$("div.dropdown-content-item").find(text("2019")).click();
        $$("div.select-group").findBy(text("Sports")).find("span.dropdown-icon").click();
        $$("div.dropdown-content-item").find(text("Basketball")).click();
        //  $$("div.dropdown").findBy(text(" - No Selection")).find("span.dropdown-icon").click();
        //  $$("span.dropdown-content-item__text").find(text("Heyho")).click();
        $$("div.dropdown").findBy(text(" - No Selection")).find("span.dropdown-icon").click();
        $$("span.dropdown-content-item__text").find(text("Forward")).click();
        $("body > app-root > app-dashboard > div > div > div > app-sports-management > app-dashboard-title > div.content > div > app-sports-management-board > div > div > div.board.with-shadow > div:nth-child(2) > app-sports-management-tables-change > div.flex-width-row.copy-move.ng-star-inserted > izs-trans-user-window > div > form > button").click();
    }
}
