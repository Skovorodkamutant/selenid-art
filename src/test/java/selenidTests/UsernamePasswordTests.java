package selenidTests;

import Helpers.ParametersHelper;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class UsernamePasswordTests extends ParametersHelper {
    @Before
    public void openLogin() {

        getOpen();
    }

    @Test
    public void username() {

        $(By.xpath("/html/body/app-root/app-pages/div/app-login/div/div/form/div[3]/div/span/a[1]")).pressEnter();

        $("div.title").shouldHave(text("USERNAME RECOVERY"));

    }

    @Test
    public void correctEmail() {
        $(By.xpath("/html/body/app-root/app-pages/div/app-login/div/div/form/div[3]/div/span/a[1]")).pressEnter();
        $(By.xpath("/html/body/app-root/app-pages/div/app-forgot-username/div/div/form/div[1]/div[1]/input")).setValue("1548656231serenity.herman@yahoo.com").pressEnter();
        $(By.cssSelector("div.title")).shouldNot(text("USERNAME RECOVERY"));
        //$(By.cssSelector("div.allert allert-success")).shouldHave(text("Please check your email and click the link to reset your password"));
        $(By.cssSelector("div.title")).shouldHave(text("LOGIN"));

    }

    @Test
    public void nullData() {
        $(By.xpath("/html/body/app-root/app-pages/div/app-login/div/div/form/div[3]/div/span/a[1]")).pressEnter();
        $(By.xpath("/html/body/app-root/app-pages/div/app-forgot-username/div/div/form/div[1]/div[1]/input")).setValue("").pressEnter();

        $("div.error").shouldHave(text("Email address is incorrect"));

    }

    @Test
    public void incorrectEmail() {
        $(By.xpath("/html/body/app-root/app-pages/div/app-login/div/div/form/div[3]/div/span/a[1]")).pressEnter();
        $(By.xpath("/html/body/app-root/app-pages/div/app-forgot-username/div/div/form/div[1]/div[1]/input")).setValue("sml@mail.c").pressEnter();
        $("div.error").shouldHave(text("Enter a valid email address."));

    }

    @Test
    public void incorrectEmailNoAT() {
        $(By.xpath("/html/body/app-root/app-pages/div/app-login/div/div/form/div[3]/div/span/a[1]")).pressEnter();
        $(By.xpath("/html/body/app-root/app-pages/div/app-forgot-username/div/div/form/div[1]/div[1]/input")).setValue("sml2mail.com").pressEnter();
        $("div.error").shouldHave(text("Email address is incorrect"));

    }

    @Test
    public void notFoundEmail() {
        $(By.xpath("/html/body/app-root/app-pages/div/app-login/div/div/form/div[3]/div/span/a[1]")).pressEnter();
        $(By.xpath("/html/body/app-root/app-pages/div/app-forgot-username/div/div/form/div[1]/div[1]/input")).setValue("sml@mail.com").pressEnter();
        $("div.error").shouldHave(text("Not found"));

    }

    @Test
    public void noUsername() {
        $(By.xpath("/html/body/app-root/app-pages/div/app-login/div/div/form/div[3]/div/span/a[2]")).pressEnter();
        $(By.xpath("/html/body/app-root/app-pages/div/app-forgot-password/div/div/app-forgot-password-username-step/form/div[1]/div[1]/input")).setValue("").pressEnter();
        $(By.xpath("/html/body/app-root/app-pages/div/app-forgot-password/div/div/app-forgot-password-username-step/form/div[1]/div[2]")).shouldHave(text("The user name is required and must have a length of 6 characters"));
    }

    @Test
    public void sortUsername() {
        $(By.xpath("/html/body/app-root/app-pages/div/app-login/div/div/form/div[3]/div/span/a[2]")).pressEnter();
        $(By.xpath("/html/body/app-root/app-pages/div/app-forgot-password/div/div/app-forgot-password-username-step/form/div[1]/div[1]/input")).setValue("qwert").pressEnter();
        $(By.xpath("/html/body/app-root/app-pages/div/app-forgot-password/div/div/app-forgot-password-username-step/form/div[1]/div[2]")).shouldHave(text("The user name is required and must have a length of 6 characters"));
    }

    @Test
    public void notFoundUsername() {
        $(By.xpath("/html/body/app-root/app-pages/div/app-login/div/div/form/div[3]/div/span/a[2]")).pressEnter();
        $(By.xpath("/html/body/app-root/app-pages/div/app-forgot-password/div/div/app-forgot-password-username-step/form/div[1]/div[1]/input")).setValue("testtesttest").pressEnter();
        $(By.xpath("/html/body/app-root/app-pages/div/app-forgot-password/div/div/app-forgot-password-username-step/form/div[1]/div[2]")).shouldHave(text("Not found."));
        close();
    }

    @Test
    public void correctUsername() {
        $(By.xpath("/html/body/app-root/app-pages/div/app-login/div/div/form/div[3]/div/span/a[2]")).pressEnter();
        $(By.xpath("/html/body/app-root/app-pages/div/app-forgot-password/div/div/app-forgot-password-username-step/form/div[1]/div[1]/input")).setValue("vschneider1548656231").pressEnter();

        $(By.xpath("/html/body/app-root/app-pages/div/app-forgot-password/div/div")).shouldHave(text("PASSWORD RECOVERY"));
        $(By.xpath("/html/body/app-root/app-toast[1]/div/span")).shouldHave(text(" Please check your email and click the link to reset your password "));
    }
}
