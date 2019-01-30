package selenidTests;

import Helpers.ParametersHelper;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.Thread.sleep;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Admins extends ParametersHelper {



    @Before
    public void OpenRegistration() {
        getOpen();
        $(By.id("inputEmail")).setValue("smladmin");//логин
        $(By.id("inputPassword")).setValue("smladmin").pressEnter();//пароль
        $(By.xpath("/html/body/app-root/app-dashboard/div/app-navbar/div/span/app-current-entity/modal/div/div/div/div[2]/modal-content/div[2]/div[1]")).click();//выбрать энтити
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/iz-d-menu/div/div[5]")).waitUntil(visible, 3000).click();//кнопка раздела
    }

    @Test

    public void dOpenCreateAdmin() throws InterruptedException {
        $(By.cssSelector("div.rows-container")).shouldNot(text("Test Chuvak"));
        $(By.xpath("//*[@id=\"tableRoot\"]/span/app-table-columns/div/app-table-column[1]/div/div/div[2]/app-table-filter/div/svg-icon")).click();
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/iz-admins-page/app-dashboard-title/div[1]")).shouldHave(text("ADMIN LIST"));
        $(By.cssSelector("div.table-filter-btn")).click();
        $(By.cssSelector("header.header")).shouldHave(text("ADD ADMIN"));
        // $(By.cssSelector("div.rows-container")).shouldNot(text("Test Chuvak"));

    }

    @Test

    public void eCloseCreateAdmin() throws InterruptedException {
        $(By.xpath("//*[@id=\"tableRoot\"]/span/app-table-columns/div/app-table-column[1]/div/div/div[2]/app-table-filter/div/svg-icon")).click();
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/iz-admins-page/app-dashboard-title/div[1]")).shouldHave(text("ADMIN LIST"));
        $(By.cssSelector("div.table-filter-btn")).click();
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/iz-admins-page/app-dashboard-title/div[2]/div/iz-admin-form/form/header/button/svg-icon")).click();
        $(By.cssSelector("header.header")).shouldNot(text("ADD ADMIN"));

    }

    @Test

    public void aAddAdmin() throws InterruptedException {
        $(By.cssSelector("div.rows-container")).shouldNot(text("Test Chuvak"));
        $(By.xpath("//*[@id=\"tableRoot\"]/span/app-table-columns/div/app-table-column[1]/div/div/div[2]/app-table-filter/div/svg-icon")).waitUntil(visible, 3000).click();
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/iz-admins-page/app-dashboard-title/div[1]")).shouldHave(text("ADMIN LIST")).waitUntil(visible, 3000);
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/iz-admins-page/app-dashboard-title/div[2]/div/iz-admin-form/form/div/div/iz-form-dynamic-content/div/iz-form-field[1]/dropdown/div/div/label")).click();
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/iz-admins-page/app-dashboard-title/div[2]/div/iz-admin-form/form/div/div/iz-form-dynamic-content/div/iz-form-field[1]/dropdown/div/div[2]/div[1]/span")).click();
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/iz-admins-page/app-dashboard-title/div[2]/div/iz-admin-form/form/div/div/iz-form-dynamic-content/div/iz-form-field[2]/dropdown/div/div[1]/label")).click();
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/iz-admins-page/app-dashboard-title/div[2]/div/iz-admin-form/form/div/div/iz-form-dynamic-content/div/iz-form-field[2]/dropdown/div/div[2]/div[1]/span/div/span")).click();
        $(By.id("first_name")).setValue("Test");
        $(By.id("last_name")).setValue("Chuvak");
        $(By.id("email")).setValue("test@mail.co");
        $(By.id("username")).setValue("testchuvak");
        $(By.id("password")).setValue("qwerty").pressEnter();
        $$("#div.admin_name_column").findBy(text("Test Chuvak"));


    }

    @Test

    public void bEditAdmin() throws InterruptedException {
        $(By.cssSelector("div.rows-container")).shouldHave(text("Test Chuvak")).waitUntil(visible, 3000);
        $(By.xpath("//*[@id=\"tableRoot\"]/span/app-table-columns/div/app-table-column[1]/div/div/div[2]/app-table-filter/div/svg-icon")).waitUntil(visible, 3000).click();
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/iz-admins-page/app-dashboard-title/div[1]")).shouldHave(text("ADMIN LIST"));
        $(By.xpath("//*[@id=\"tableRoot\"]/span/span/app-table-rows[1]/div/app-table-row[1]/div/div/div[2]/div/app-ellipsis-component/button/div/img")).click();//клик по меню пользователя
        $(By.xpath("//*[@id=\"tableRoot\"]/span/span/app-table-rows[1]/div/app-table-row[1]/div/div/div[2]/app-dropdown-menu/div/div/app-dropdown-menu-item[1]/div")).click();//клик по изменению
        $(By.id("first_name")).setValue("Testy");
        $(By.id("last_name")).setValue("Chuvaka");
        $(By.id("email")).setValue("test@mail.co");
        $(By.id("username")).setValue("testchuvak");
        $(By.id("password")).setValue("qwerty").pressEnter();
        $$("#div.admin_name_column").findBy(text("Testy Chuvaka"));


    }

    @Test
    public void cNextEntity() {
        $(By.cssSelector("div.table-container-row")).shouldHave(text("Testy Chuvaka")).waitUntil(visible, 3000);
        $(By.cssSelector("div.dropdown")).click();
        $(By.xpath("/html/body/app-root/app-dashboard/div/app-navbar/div/span/app-current-entity/div/dropdown/div/div[2]/div[2]/span/div/span")).shouldHave(text("jmoses1548316885")).click();
        $$("#div.admin_name_column").findBy(text("Ed Spillman"));
        $(By.cssSelector("div.table-container-row")).shouldNot(text("Testy Chuvaka"));

    }

    @Test

    public void fCancelDeleteAdmin() throws InterruptedException {
        $(By.cssSelector("div.rows-container")).shouldHave(text("Testy Chuvaka")).waitUntil(visible, 3000);
        $(By.xpath("//*[@id=\"tableRoot\"]/span/app-table-columns/div/app-table-column[1]/div/div/div[2]/app-table-filter/div/svg-icon")).waitUntil(visible, 3000).click();
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/iz-admins-page/app-dashboard-title/div[1]")).shouldHave(text("ADMIN LIST"));
        $(By.xpath("//*[@id=\"tableRoot\"]/span/span/app-table-rows[1]/div/app-table-row[1]/div/div/div[2]/div/app-ellipsis-component/button/div/img")).click();//клик по меню пользователя
        $(By.xpath("//*[@id=\"tableRoot\"]/span/span/app-table-rows[1]/div/app-table-row[1]/div/div/div[2]/app-dropdown-menu/div/div/app-dropdown-menu-item[2]/div")).click();//клик по удалению
        $(By.cssSelector("span.close-on-modal-delete")).click();
        $(By.cssSelector("div.admin_name_column")).shouldHave(text("Testy Chuvaka"));


    }

    @Test

    public void gDeleteAdmin() throws InterruptedException {
        $(By.cssSelector("div.rows-container")).shouldHave(text("Testy Chuvaka")).waitUntil(visible, 3000);
        $(By.xpath("//*[@id=\"tableRoot\"]/span/app-table-columns/div/app-table-column[1]/div/div/div[2]/app-table-filter/div/svg-icon")).waitUntil(visible, 3000).click();
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/iz-admins-page/app-dashboard-title/div[1]")).shouldHave(text("ADMIN LIST"));
        $(By.xpath("//*[@id=\"tableRoot\"]/span/span/app-table-rows[1]/div/app-table-row[1]/div/div/div[2]/div/app-ellipsis-component/button/div/img")).click();//клик по меню пользователя
        $(By.xpath("//*[@id=\"tableRoot\"]/span/span/app-table-rows[1]/div/app-table-row[1]/div/div/div[2]/app-dropdown-menu/div/div/app-dropdown-menu-item[2]/div")).click();//клик по удалению
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/iz-admins-page/modal/div/div/div/div[2]/modal-content/div[3]/button")).click();
        $(By.cssSelector("div.admin_name_column")).shouldNot(text("Testy Chuvaka"));

    }
    @Test
    public void hCorrectsearchAdmin() {
        $(By.cssSelector("div.filter-btn")).click();
        $(By.xpath("//*[@id=\"tableRoot\"]/span/app-table-columns/div/app-table-column[1]/div/div/div[2]/div[1]/input")).setValue("Alexa");
        $(By.cssSelector("div.table-container-row")).shouldHave(text("Alexa Joyce"));
    }
    @Test
    public void iIncorrectearchAdmin() {
        $(By.cssSelector("div.filter-btn")).click();
        $(By.xpath("//*[@id=\"tableRoot\"]/span/app-table-columns/div/app-table-column[1]/div/div/div[2]/div[1]/input")).setValue("%&*%");
        $(By.cssSelector("div.table-container-row")).shouldHave(text("You have no admin"));
    }
    @Test

    public void jAddAdminEmpty() throws InterruptedException {
        $(By.cssSelector("div.rows-container")).shouldNot(text("Test Chuvak"));
        $(By.xpath("//*[@id=\"tableRoot\"]/span/app-table-columns/div/app-table-column[1]/div/div/div[2]/app-table-filter/div/svg-icon")).waitUntil(visible, 3000).click();
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/iz-admins-page/app-dashboard-title/div[1]")).shouldHave(text("ADMIN LIST")).waitUntil(visible, 3000);
        $(By.id("first_name")).setValue("");
        $(By.id("last_name")).setValue("");
        $(By.id("email")).setValue("");
        $(By.id("username")).setValue("");
        $(By.id("password")).setValue("").pressEnter();
        $(By.id("first_name")).shouldHave(cssClass("ng-invalid"));
        $(By.id("last_name")).shouldHave(cssClass("ng-invalid"));
        $(By.id("email")).shouldHave(cssClass("ng-invalid"));
        $(By.id("username")).shouldHave(cssClass("ng-invalid"));
        $(By.id("password")).shouldHave(cssClass("ng-invalid"));
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/iz-admins-page/app-dashboard-title/div[2]/div/iz-admin-form/form/header/button/svg-icon")).click();
        $(By.cssSelector("#div.admin_name_column")).shouldNot(text("Test Chuvak"));


    }


}
