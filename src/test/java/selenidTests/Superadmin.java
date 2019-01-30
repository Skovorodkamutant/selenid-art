package selenidTests;

import Helpers.ParametersHelper;
import com.codeborne.selenide.Condition;
import net.bytebuddy.implementation.bind.annotation.BindingPriority;
import org.bouncycastle.asn1.x509.DisplayText;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Superadmin extends ParametersHelper{

    @Before
    public void OpenRegistration() {
        getOpen();
        autorisation();

      //  $("div[class*='menu-item']").click();
//        boolean deleteUser = $$(By.cssSelector("span.table-content-rows")).find(text("Smith John")).exists();
//        if (deleteUser){
//            $(By.xpath("//*[@id=\"tableRoot\"]/span/span/app-table-rows")).shouldHave(text("Smith John"));
//            $(By.xpath("//*[@id=\"tableRoot\"]/span/span/app-table-rows/div/app-table-row[16]/div/div/div/div/div/app-ellipsis-component/button")).click();
//            $(By.xpath("//*[@id=\"tableRoot\"]/span/span/app-table-rows/div/app-table-row[16]/div/div/div/div/app-dropdown-menu/div/div")).find("#tableRoot > span > span > app-table-rows > div > app-table-row:nth-child(16) > div > div > div > div > app-dropdown-menu > div > div > app-dropdown-menu-item:nth-child(2) > div").click();
//            $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/iz-sa-page/modal/div/div/div/div[2]/modal-content/div[3]/button")).click();
//            $(By.xpath("//*[@id=\"tableRoot\"]/span/span/app-table-rows")).shouldNot(text("Smith John"));
//            close();
//        }
    }

    @Test
    public void aCancelCreateSuperadminFieldIn() {
        $(By.xpath("//*[@id=\"tableRoot\"]/span/app-table-columns/div/app-table-column/div/div/div[2]/app-table-filter/div/svg-icon")).click();
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/iz-sa-page/div/app-dashboard-title/div[2]/div/iz-sa-form/form/div/div/iz-form-dynamic-content/div/iz-form-field[1]/dropdown/div/div[1]/label")).click();
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/iz-sa-page/div/app-dashboard-title/div[2]/div/iz-sa-form/form/div/div/iz-form-dynamic-content/div/iz-form-field[1]/dropdown/div/div[2]/div[1]/span/div/span")).click();
        $(By.id("first_name")).setValue("Smith");
        $(By.id("last_name")).setValue("John");
        $(By.id("email")).setValue("email@test1.ru");
        $(By.id("username")).setValue("johnsmith");
        $(By.id("password")).setValue("qwerty");
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/iz-sa-page/div/app-dashboard-title/div[2]/div/iz-sa-form/form/header/button")).waitUntil(visible, 3000).click();
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/iz-sa-page/div/app-dashboard-title/div[2]/div/iz-sa-form/form/header")).shouldNot(text("ADD SUPER-ADMIN"));
        $(By.cssSelector("span.table-content-rows")).shouldNot(text("Smith John"));
        close();
    }

    @Test
    public void bCreateSuperadmin() {

        $(By.xpath("//*[@id=\"tableRoot\"]/span/app-table-columns/div/app-table-column/div/div/div[2]/app-table-filter/div/svg-icon")).click();
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/iz-sa-page/div/app-dashboard-title/div[2]/div/iz-sa-form/form/div/div/iz-form-dynamic-content/div/iz-form-field[1]/dropdown/div/div[1]/label")).click();
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/iz-sa-page/div/app-dashboard-title/div[2]/div/iz-sa-form/form/div/div/iz-form-dynamic-content/div/iz-form-field[1]/dropdown/div/div[2]/div[1]/span/div/span")).click();
        $(By.id("first_name")).setValue("Smith");
        $(By.id("last_name")).setValue("John");
        $(By.id("email")).setValue("email@test1.ru");
        $(By.id("username")).setValue("johnsmith");
        $(By.id("password")).setValue("qwerty").pressEnter();
        $(By.xpath("//*[@id=\"tableRoot\"]/span/span/app-table-rows")).shouldHave(text("Smith John"));
        close();
    }

    @Test
    public void cCancelCreateSuperadmin() {

        $(By.xpath("//*[@id=\"tableRoot\"]/span/app-table-columns/div/app-table-column/div/div/div[2]/app-table-filter/div/svg-icon")).click();
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/iz-sa-page/div/app-dashboard-title/div[2]/div/iz-sa-form/form/div/div/iz-form-dynamic-content/div/iz-form-field[1]/dropdown/div/div[1]/label")).click();
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/iz-sa-page/div/app-dashboard-title/div[2]/div/iz-sa-form/form/div/div/iz-form-dynamic-content/div/iz-form-field[1]/dropdown/div/div[2]/div[1]/span/div/span")).click();
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/iz-sa-page/div/app-dashboard-title/div[2]/div/iz-sa-form/form/header/button")).click();
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/iz-sa-page/div/app-dashboard-title/div[2]/div/iz-sa-form/form/header")).shouldNot(text("ADD SUPER-ADMIN"));
        close();
    }

    @Test
    public void dCreateSuperadminEmptyFields() {

        $(By.xpath("//*[@id=\"tableRoot\"]/span/app-table-columns/div/app-table-column/div/div/div[2]/app-table-filter/div/svg-icon")).click();
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/iz-sa-page/div/app-dashboard-title/div[2]/div/iz-sa-form/form/button")).click();
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/iz-sa-page/div/app-dashboard-title/div[2]/div/iz-sa-form/form/div/div/iz-form-dynamic-content/div/iz-form-field[1]/dropdown")).shouldHave(cssClass("ng-invalid"));
        $(By.id("first_name")).shouldHave(cssClass("ng-invalid"));
        $(By.id("last_name")).shouldHave(cssClass("ng-invalid"));
        $(By.id("email")).shouldHave(cssClass("ng-invalid"));
        $(By.id("username")).shouldHave(cssClass("ng-invalid"));
        $(By.id("password")).shouldHave(cssClass("ng-invalid"));
        close();
    }

    @Test
    public void eCreateSuperadminTogl() {

        $(By.xpath("//*[@id=\"tableRoot\"]/span/app-table-columns/div/app-table-column/div/div/div[2]/app-table-filter/div/svg-icon")).click();
        $(By.cssSelector("div.switch-on")).click();
        $(By.cssSelector("div.switch-off")).shouldHave(text("No"));
        close();
    }

    @Test
    public void fEditSuperadmin() {
        $$(By.cssSelector("div.list-item-container")).find(text("Smith John")).scrollTo();
        $$(By.cssSelector("div.list-item-container")).find(text("Smith John")).find("button.theme--white_icon").click();
//        $(By.xpath("//*[@id=\"tableRoot\"]/span/span/app-table-rows/div/app-table-row[16]/div/div/div/div/div/app-ellipsis-component/button")).click();
//       $(By.xpath("//*[@id=\"tableRoot\"]/span/span/app-table-rows/div/app-table-row[16]/div/div/div/div/app-dropdown-menu/div/div/app-dropdown-menu-item[1]/div")).click();
        $$(By.cssSelector("div.menu-item-container")).findBy(text("Edit")).click();
        $(By.id("first_name")).setValue("Smithy");
        $(By.id("last_name")).setValue("Johney");
        $(By.id("email")).setValue("email@test1.ru");
        $(By.id("username")).setValue("johnsmithy");
        $(By.id("password")).setValue("qwerty").pressEnter();
        $(By.xpath("//*[@id=\"tableRoot\"]/span/span/app-table-rows")).shouldHave(text("Smithy Johney"));
        close();
    }

    @Test
    public void gCancelDeleteSuperadmin() {
     //   $$(By.cssSelector("div.list-item-container")).find(text("Smithy Johney")).scrollTo();
        $$(By.cssSelector("div.list-item-container")).find(text("Smithy Johney")).find("button.theme--white_icon").click();
        $$(By.cssSelector("div.menu-item-container")).findBy(text("Delete")).click();
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/iz-sa-page/modal/div/div/div/div[2]/modal-content/span")).click();
        $(By.xpath("//*[@id=\"tableRoot\"]/span/span/app-table-rows")).shouldHave(text("Smithy Johney"));
        close();
    }

    @Test
    public void hDeleteSuperadmin() {
        $$(By.cssSelector("div.list-item-container")).find(text("Smithy Johney")).scrollTo();
        $$(By.cssSelector("div.list-item-container")).find(text("Smithy Johney")).find("button.theme--white_icon").click();
        $$(By.cssSelector("div.menu-item-container")).findBy(text("Delete")).click();
        $("div.modal-btn").click();
        $(By.xpath("//*[@id=\"tableRoot\"]/span/span/app-table-rows")).waitUntil(visible, 3000).shouldNot(text("Smithy Johney"));
        $(By.xpath("//*[@id=\"tableRoot\"]/span/span/app-table-rows")).waitUntil(visible, 3000).shouldNot(text("Smith John"));
        close();
    }


}
