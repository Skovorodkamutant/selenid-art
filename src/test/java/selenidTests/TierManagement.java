package selenidTests;

import Helpers.ParametersHelper;
import com.codeborne.selenide.Condition;
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
public class TierManagement extends ParametersHelper {
    @Before
    public void OpenTier() {
        getOpen();
        autorisation();
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/iz-d-menu/div/div[4]")).waitUntil(visible, 3000).click();//кнопка раздела
    }

    @Test
    public void openTierManagement() {
        $(By.cssSelector("div.header")).shouldHave(text("TIER MANAGEMENT"));//проверка на то, что раздел открылся
    }

    @Test
    public void openComandList() {
        $(By.cssSelector("div.sml-expandable-item-title")).shouldHave(text("BASKETBALL")).click();
        $(By.xpath("//*[@id=\"tableRoot\"]/span/span/app-table-rows/div/app-table-row/div/div")).waitUntil(visible, 3000).shouldNot(text("You have no teams"));
        $(By.xpath("//*[@id=\"tableRoot\"]/span/span")).waitUntil(visible, 3000).shouldHave(text("2019"));
        close();
    }

    @Test
    public void openEmptyComandList() {
        $$(By.cssSelector("div.sml-expandable-item-title")).find(text("VOLLEYBALL")).click();
        //$(By.xpath("div.sml-expandable-item-title")).shouldHave(text("VOLLEYBALL")).find("div[class*='sml-expandable-item-wrapper']").click();
        $(By.xpath("//*[@id=\"tableRoot\"]/span/span/app-table-rows/div/app-table-row/div/div")).waitUntil(visible, 3000).shouldHave(text("You have no teams"));
    }

    @Test
    public void openCreateForm() {
        $(By.cssSelector("div.sml-expandable-item-title")).shouldHave(text("BASKETBALL"));
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/app-tier-management/app-dashboard-title/div[2]/div/div[1]/app-tier-management-list[1]/expandable/div/div[1]/div[2]")).click();
        $(By.cssSelector("button.close")).click();
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/app-tier-management/app-dashboard-title/div[2]/div/div[2]/app-tier-management-change/div/div[1]")).shouldNot(text("ADD TIER"));
    }

    @Test
    public void openCloseCreateForm() {
        $(By.cssSelector("div.sml-expandable-item-title")).shouldHave(text("BASKETBALL")).find("div.add-btn").click();
       // $("").click();
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/app-tier-management/app-dashboard-title/div[2]/div/div[2]/app-tier-management-change/div/div[1]")).shouldHave(text("ADD TIER"));
    }

    @Test
    public void emptyDataTier() {
        $(By.cssSelector("div.sml-expandable-item-title")).shouldHave(text("BASKETBALL"));
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/app-tier-management/app-dashboard-title/div[2]/div/div[1]/app-tier-management-list[1]/expandable/div/div[1]/div[2]")).click();
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/app-tier-management/app-dashboard-title/div[2]/div/div[2]/app-tier-management-change/div/div[1]")).shouldHave(text("ADD TIER"));
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/app-tier-management/app-dashboard-title/div[2]/div/div[2]/app-tier-management-change/div/div[2]/form/button")).click();
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/app-tier-management/app-dashboard-title/div[2]/div/div[2]/app-tier-management-change/div/div[2]/form/div[1]/dropdown/div/div/label")).shouldHave(text(" - No Selection"));
        $(By.name("gender")).shouldHave(cssClass("ng-invalid"));
        $(By.name("name")).shouldHave(cssClass("ng-invalid"));

    }

    @Test
    public void aAddUser() {
        $(By.cssSelector("div.sml-expandable-item-title")).shouldHave(text("BASKETBALL"));
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/app-tier-management/app-dashboard-title/div[2]/div/div[1]/app-tier-management-list[1]/expandable/div/div[1]/div[2]")).click();
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/app-tier-management/app-dashboard-title/div[2]/div/div[2]/app-tier-management-change/div/div[1]")).shouldHave(text("ADD TIER"));
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/app-tier-management/app-dashboard-title/div[2]/div/div[2]/app-tier-management-change/div/div[2]/form/div[1]/dropdown/div/div[1]/label")).click();
        $$("span.dropdown-content-item-row").find(text("2018")).click();
        $(By.name("gender")).setValue("meny");
        $(By.name("name")).setValue("Test Buffalo").pressEnter();
        $$("#div.table-root").findBy(text("Test Buffalo"));
        close();

    }

    @Test
    public void bEditUserMessage() {
        $(By.cssSelector("div.sml-expandable-item-title")).shouldHave(text("BASKETBALL"));
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/app-tier-management/app-dashboard-title/div[2]/div/div[1]/app-tier-management-list[1]/expandable/div/div/div[1]/span")).click();
        $$("div.table-container-row").find(text("Test Buffalo")).find("button.theme--white_icon").click();
        $(By.cssSelector("div.menu-item-container")).shouldHave(text("Edit")).click();
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/app-tier-management/app-dashboard-title/div[2]/div/div[2]/app-tier-management-change/div/div[1]")).shouldHave(text("EDIT TIER"));
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/app-tier-management/app-dashboard-title/div[2]/div/div[2]/app-tier-management-change/div/div[2]/form/div[1]/dropdown/div/div[1]/label")).click();
        $$("div.dropdown-content-item").find(text("2018")).click();
        $(By.name("gender")).setValue("meny");
        $(By.name("name")).setValue("Test Buffalo").pressEnter();
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/app-tier-management/app-dashboard-title/div[2]/div/div[2]/app-tier-management-change/div/div[2]/form/div[4]/dropdown/div/div/label")).click();
        $$("span.dropdown-content-item__text").find(text("Alexa Joyce")).click();
        //$(By.cssSelector("label.label-checkbox")).click();
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/app-tier-management/app-dashboard-title/div[2]/div/div[2]/app-tier-management-change/div/div[2]/form/button")).click();
        $(By.cssSelector("span.message-title")).waitUntil(visible, 5000).shouldHave(text(" User limit for current group has been reached."));
        close();
    }

    @Test
    public void cDeleteUser() {
        $(By.cssSelector("div.sml-expandable-item-title")).shouldHave(text("BASKETBALL"));
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/app-tier-management/app-dashboard-title/div[2]/div/div[1]/app-tier-management-list[1]/expandable/div/div/div[1]/span")).click();
        $(By.xpath("//*[@id=\"tableRoot\"]/span/span/app-table-rows[3]/div/app-table-row[3]")).find(By.xpath("//*[@id=\"tableRoot\"]/span/span/app-table-rows[3]/div/app-table-row[3]/div/div/app-tier-management-sub-menu/div/div/app-ellipsis-component/button")).waitUntil(visible, 3000).click();
        $(By.xpath("//*[@id=\"tableRoot\"]/span/span/app-table-rows[3]/div/app-table-row[3]/div/div/app-tier-management-sub-menu/div/app-dropdown-menu/div/div")).find("#tableRoot > span > span > app-table-rows:nth-child(3) > div > app-table-row:nth-child(3) > div > div > app-tier-management-sub-menu > div > app-dropdown-menu > div > div > app-dropdown-menu-item:nth-child(2) > div").click();
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/app-tier-management/app-dashboard-title/div[2]/div/div[1]/app-tier-management-list[1]/modal/div/div/div/div[2]/modal-content/div[3]/button")).click();
        $(By.cssSelector("#div.table-root")).shouldNot(text("Test Buffalo"));

    }


}
