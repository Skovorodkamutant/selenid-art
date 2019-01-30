package selenidTests;

import Helpers.ParametersHelper;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class LoginTest extends ParametersHelper {
    @Test
    public void correctLoginAdmin() {
        getOpen();
        $(By.id("inputEmail")).setValue("smladmin");
        $(By.id("inputPassword")).setValue("smladmin").pressEnter();

        $(By.cssSelector("div.header")).shouldHave(text("SELECT ENTITY"));
        close();

    }

    @Test
    public void correctLoginUser() {
        getOpen();
        $(By.id("inputEmail")).setValue("vschneider1548656231");
        $(By.id("inputPassword")).setValue("qwerty").pressEnter();

        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/app-innerzone-profile/iz-profile/div/div/div[1]/button")).shouldHave(text("Save PDF"));
        close();
    }

    @Test
    public void correctLoginCoach() {
        getOpen();
        $(By.id("inputEmail")).setValue("tompop");
        $(By.id("inputPassword")).setValue("qwerty").pressEnter();

        $(By.cssSelector("div.header")).shouldHave(text("SPORTS MANAGEMENT"));
    }

    @Test
    public void correctLoginCapslock() {
        getOpen();
        $(By.id("inputEmail")).setValue("SMLADMIN");
        $(By.id("inputPassword")).setValue("smladmin").pressEnter();

        $(By.cssSelector("div.header")).shouldHave(text("SELECT ENTITY"));

    }

    @Test
    public void incorrectLoginCapslock() {
        getOpen();
        $(By.id("inputEmail")).setValue("SMLADMIN");
        $(By.id("inputPassword")).setValue("SMLADMIN").pressEnter();

        $(By.cssSelector("div.error")).shouldHave(text("Wrong username or password"));

    }

    @Test
    public void incorrectLoginCapslockPassword() {
        getOpen();
        $(By.id("inputEmail")).setValue("smladmin");
        $(By.id("inputPassword")).setValue("SMLADMIN").pressEnter();

        $(By.cssSelector("div.error")).shouldHave(text("Wrong username or password"));

    }

    @Test
    public void incorrectPassword() {
        getOpen();
        $(By.id("inputEmail")).setValue("smladmin");
        $(By.id("inputPassword")).setValue("smladmn").pressEnter();

        $(By.cssSelector("div.error")).shouldHave(text("Wrong username or password"));

    }

    @Test
    public void incorrectLogin() {
        getOpen();
        $(By.id("inputEmail")).setValue("smladmn");
        $(By.id("inputPassword")).setValue("smladmin").pressEnter();

        $(By.cssSelector("div.error")).shouldHave(text("Wrong username or password"));
    }

    @Test
    public void nonData() {
        getOpen();
        $(By.id("inputEmail")).setValue("");
        $(By.id("inputPassword")).setValue("").pressEnter();

        $(By.cssSelector("div.error")).shouldNot(text("Wrong username or password"));
        $(By.cssSelector("div.header")).shouldNot(text("SELECT ENTITY"));
        close();
    }

    @Test
    public void nonLogin() {
        getOpen();
        $(By.id("inputEmail")).setValue("");
        $(By.id("inputPassword")).setValue("smladmin").pressEnter();

        $(By.cssSelector("div.error")).shouldNot(text("Wrong username or password"));
        $(By.cssSelector("div.header")).shouldNot(text("SELECT ENTITY"));
        close();
    }

    @Test
    public void nonPassword() {
        getOpen();
        $(By.id("inputEmail")).setValue("smladmin");
        $(By.id("inputPassword")).setValue("").pressEnter();

        $(By.cssSelector("div.error")).shouldNot(text("Wrong username or password"));
        $(By.cssSelector("div.header")).shouldNot(text("SELECT ENTITY"));
    }
}
