package selenidTests;

import Helpers.ObjectHelper;
import Helpers.ParametersHelper;
import com.codeborne.selenide.Condition;
import com.devskiller.jfairy.Fairy;
import com.devskiller.jfairy.producer.person.Person;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;

import java.time.Instant;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MyTeam extends ParametersHelper {

    //first create Fairy object. By default - Locale is English
    Fairy fairy = Fairy.create();
    //Create person object
    Person person = fairy.person();

    private final ObjectHelper objectHelper = new ObjectHelper();
    Instant instant = Instant.now();
    long timeStampSeconds = instant.getEpochSecond();


    //Open
    String selectDir = "div[class*=teams-add-container]";
    //Select
    String metall = "div[class*=box-item]";
    String button = "button.select";
    String cash = "div.border-bottom-top";
    //Create
    String year = "div[class*='dropdown-content']";
    String sport = "div[class*='dropdown-content-item']";
    String gender = String.valueOf(person.getAge() + timeStampSeconds);
    String teamName = (person.getFirstName() + timeStampSeconds);
    String name = String.valueOf(person.getFullName() + timeStampSeconds);
    String numberCard = "input[id*='card-number']";
    String cardName = "input[id*='card-name']";
    String month = "dropdown[name*='month']";
    String monthData = "div[class*='dropdown-content']";
    String cardYear = "input[name*='exp_year']";
    String cvv = "input[name*='cvv']";
    String createButton = "button[type*='submit']";
    String teams = "span[class*='table-content-rows']";
    String closed = "svg-icon[src*='assets/images/common/close.svg']";

    //Detales

    String clickTeam = "img[class*='ng-lazyloaded']";

    @Before
    public void OpenRegistration() {
        getOpen();
        $(By.id("inputEmail")).setValue("smladmin");
        $(By.id("inputPassword")).setValue("smladmin").pressEnter();

        $(By.xpath("/html/body/app-root/app-dashboard/div/app-navbar/div/span/app-current-entity/modal/div/div/div/div[2]/modal-content/div[2]/div[1]")).click();
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/iz-d-menu/div/div[6]/div[1]")).click();
    }

    @Test
    public void openBronze() {
        $$(By.cssSelector(selectDir)).find(text("ADD NEW TEAM"));
        $$(metall).find(text("Bronze")).find(By.cssSelector(button)).click();
        $(By.cssSelector(cash)).shouldHave(text("$700/"));

    }

    @Test
    public void createBronzePack() {
        $$(By.cssSelector(selectDir)).find(text("ADD NEW TEAM"));
        $$(metall).find(text("Bronze")).find(By.cssSelector(button)).click();
        $(By.cssSelector(cash)).shouldHave(text("$700/"));
        $(By.name("season")).click();
        $$(year).find(text("2019")).waitUntil(visible, 3000).click();
        $(By.name("sport")).waitUntil(visible, 3000).click();
        $$(sport).find(text("Golf")).click();
        $(By.name("gender")).setValue(gender);
        $(By.name("name")).setValue(teamName);
        $(cardName).setValue(name);
        $(numberCard).setValue("4242 4242 4242 4242");
        $(month).click();
        $$(monthData).find(text("April")).click();
        $(cardYear).setValue("2027");
        $(cvv).setValue("128");
        $(createButton).click();
        $(createButton).waitUntil(hidden, 10000);
        $(teams).waitUntil(enabled, 10000);
        $(teams).waitUntil(enabled, 10000).shouldHave(text(teamName));


    }

    @Test
    @Ignore
    public void createEmptyBronzePack() {
        $$(By.cssSelector(selectDir)).find(text("ADD NEW TEAM"));
        $$(metall).find(text("Bronze")).find(By.cssSelector(button)).click();
        $(By.cssSelector(cash)).shouldHave(text("$700/"));

        $(createButton).click();
        //проверки
        $(By.name("season")).shouldHave(cssClass("ng-invalid"));
        $(By.name("sport")).shouldHave(cssClass("ng-invalid"));
        $(By.name("gender")).shouldHave(cssClass("ng-invalid"));
        $(By.name("name")).shouldHave(cssClass("ng-invalid"));
        $(cardName).shouldHave(cssClass("ng-invalid"));
        $(numberCard).shouldHave(cssClass("ng-invalid"));
        $(month).shouldHave(cssClass("ng-invalid"));
        //$(monthData).shouldHave(cssClass("ng-invalid"));
        $(cardYear).shouldHave(cssClass("ng-invalid"));
        $(cvv).shouldHave(cssClass("ng-invalid"));
        $(closed).click();
        $(teams).waitUntil(enabled, 10000);
        $(teams).waitUntil(enabled, 10000).shouldNot(text(teamName));
    }


    @Test
    public void openSilver() {
        $$(By.cssSelector(selectDir)).find(text("ADD NEW TEAM"));
        $$(metall).find(text("Silver")).find(By.cssSelector(button)).click();
        $(By.cssSelector(cash)).shouldHave(text("$1250/"));
        $(By.name("season")).click();
        $$(year).find(text("2019")).waitUntil(visible, 3000).click();
        $(By.name("sport")).waitUntil(visible, 3000).click();
        $$(sport).find(text("Golf")).click();
        $(By.name("gender")).setValue(gender);
        $(By.name("name")).setValue(teamName);
        $(cardName).setValue(name);
        $(numberCard).setValue("4242 4242 4242 4242");
        $(month).click();
        $$(monthData).find(text("April")).click();
        $(cardYear).setValue("2027");
        $(cvv).setValue("128");
        $(createButton).click();
        $(createButton).waitUntil(hidden, 10000);
        $(teams).waitUntil(enabled, 10000);
        $(teams).waitUntil(enabled, 10000).shouldHave(text(teamName));

    }

    @Test
    public void openGold() {
        $$(By.cssSelector(selectDir)).find(text("ADD NEW TEAM"));
        $$(metall).find(text("Gold")).find(By.cssSelector(button)).click();
        $(By.cssSelector(cash)).shouldHave(text("$2650/"));
        $(By.name("season")).click();
        $$(year).find(text("2019")).waitUntil(visible, 3000).click();
        $(By.name("sport")).waitUntil(visible, 3000).click();
        $$(sport).find(text("Golf")).click();
        $(By.name("gender")).setValue(gender);
        $(By.name("name")).setValue(teamName);
        $(cardName).setValue(name);
        $(numberCard).setValue("4242 4242 4242 4242");
        $(month).click();
        $$(monthData).find(text("April")).click();
        $(cardYear).setValue("2027");
        $(cvv).setValue("128");
        $(createButton).click();
        $(createButton).waitUntil(hidden, 10000);
        $(teams).waitUntil(enabled, 10000);
        $(teams).waitUntil(enabled, 10000).shouldHave(text(teamName));
    }

    @Test
    public void openTeam() {

        //$(By.xpath("//*[@id=\"tableRoot\"]/span/span/app-table-rows/div/app-table-row[36]/div/div/div[2]")).click();
        $(clickTeam).waitUntil(visible, 3000).click();
        $(By.cssSelector("iz-button-toggle.split")).shouldHave(text("Team Information"));
    }

    @Test
    public void openPositions() {

        $(clickTeam).waitUntil(visible, 3000).click();
        $(By.cssSelector("button.theme--low_priority_grey")).shouldHave(text("Players Position")).click();
        $(By.cssSelector("label.title")).shouldHave(text("PLAYER POSITIONS"));
    }

    @Test
    public void createPosition() {
        $(clickTeam).waitUntil(visible, 3000).click();
        $(By.cssSelector("button[class*='theme--low_priority_grey'")).click();
        $(By.cssSelector("div.modal-teams-header-buckets")).shouldHave(text("PLAYER POSITIONS"));
        $(By.cssSelector("svg-icon[src*='assets/images/common/close.svg'")).click();
        $(By.cssSelector("div.modal-teams-header-buckets")).shouldNot(text("PLAYER POSITIONS"));

    }


}
