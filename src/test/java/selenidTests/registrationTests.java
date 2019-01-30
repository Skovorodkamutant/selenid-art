package selenidTests;

import Helpers.ObjectHelper;
import Helpers.ParametersHelper;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

import java.time.Instant;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class registrationTests extends ParametersHelper {



    @Before
    public void openRegistration() {
     getOpenRegistration();
    }
    Instant instant = Instant.now();
    long timeStampSeconds = instant.getEpochSecond();

    @Test
    public void CorrectFirstStep() {
        $(By.name("entity_name")).setValue(objectHelper.generateRandomUsername() + timeStampSeconds);
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-registration-first-step/form/div[2]/dropdown/div/div/label")).click();
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-registration-first-step/form/div[2]/dropdown/div/div[2]/div[2]")).click();
        $(By.name("first_name")).setValue(objectHelper.firstName());
        $(By.name("last_name")).setValue(objectHelper.lastName()).pressEnter();
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-registration-second-step/form/div[8]/button[1]/div")).shouldHave(text("STEP BACK"));
        close();
    }

    @Test
    public void IncorrectFirstStep() {

        $(By.name("entity_name")).setValue("adickerson1548316124");
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-registration-first-step/form/div[2]/dropdown/div/div/label")).click();
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-registration-first-step/form/div[2]/dropdown/div/div[2]/div[2]")).click();
        $(By.name("first_name")).setValue(objectHelper.firstName());
        $(By.name("last_name")).setValue(objectHelper.lastName()).pressEnter();
        $(By.cssSelector("div.error")).shouldHave(text("Entity name is already used."));
    }

    @Test
    public void NoDataFirstStep() {
        open("http://sports.innerzone.local/#/registration");
        $(By.name("entity_name")).setValue("");
        $(By.name("first_name")).setValue("");
        $(By.name("last_name")).setValue("").pressEnter();
        $(By.name("entity_name")).shouldNot(cssClass("ng-pristine"));
        $(By.name("first_name")).shouldNot(cssClass("ng-pristine"));
        $(By.name("last_name")).shouldNot(cssClass("ng-pristine"));

        close();
    }

    @Test
    public void FirstStepNoSelectedList() {

        $(By.name("entity_name")).setValue(objectHelper.firstName() + timeStampSeconds);
        $(By.name("first_name")).setValue(objectHelper.firstName());
        $(By.name("last_name")).setValue(objectHelper.lastName()).pressEnter();
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-registration-first-step/form/div[2]/dropdown/div/div/label")).shouldHave(text(" - No Selection"));
    }



    @Test
    public void NoDataSecondStep() {
        // open("http://sports.innerzone.local/#/registration");
        $(By.name("entity_name")).setValue(objectHelper.generateRandomUsername() + timeStampSeconds);
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-registration-first-step/form/div[2]/dropdown/div/div/label")).click();
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-registration-first-step/form/div[2]/dropdown/div/div[2]/div[2]")).click();
        $(By.name("first_name")).setValue(objectHelper.firstName());
        $(By.name("last_name")).setValue(objectHelper.lastName()).pressEnter();
        $(By.name("address")).setValue("");
        $(By.name("city")).setValue("");
        $(By.name("state")).setValue("");
        $(By.name("country")).setValue("");
        $(By.name("zip_code")).setValue("");
        $(By.name("email")).setValue("");
        $(By.name("phone")).setValue("").pressEnter();
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-registration-second-step/form/div[6]/input")).shouldHave(cssClass("ng-invalid"));
        close();
    }

    @Test
    public void IncorrectEmailSecondStep() {
        //open("http://sports.innerzone.local/#/registration");
        $(By.name("entity_name")).waitUntil(visible, 5000).setValue(objectHelper.generateRandomUsername() + timeStampSeconds);
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-registration-first-step/form/div[2]/dropdown/div/div/label")).click();
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-registration-first-step/form/div[2]/dropdown/div/div[2]/div[2]")).click();
        $(By.name("first_name")).setValue(objectHelper.firstName());
        $(By.name("last_name")).setValue(objectHelper.lastName()).pressEnter();
        $(By.name("address")).setValue(objectHelper.address());
        $(By.name("city")).setValue(objectHelper.city());
        $(By.name("state")).setValue(objectHelper.state());
        $(By.name("country")).setValue(objectHelper.country());
        $(By.name("zip_code")).setValue("qwerty");
        $(By.name("email")).setValue("mail@sml.c");
        $(By.name("phone")).setValue(objectHelper.phone()).pressEnter();
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-registration-second-step/form/div[6]/input")).shouldHave(cssClass("ng-invalid"));
        close();
    }
    @Test
    public void CorrectSecondStep() {
        open("http://sports.innerzone.local/#/registration");
        $(By.name("entity_name")).setValue(objectHelper.generateRandomUsername() + timeStampSeconds);
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-registration-first-step/form/div[2]/dropdown/div/div/label")).click();
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-registration-first-step/form/div[2]/dropdown/div/div[2]/div[2]")).click();
        $(By.name("first_name")).waitUntil(visible, 5000).setValue(objectHelper.firstName());
        $(By.name("last_name")).waitUntil(visible, 5000).setValue(objectHelper.lastName()).pressEnter();
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-registration-second-step/form/div[1]/input")).waitUntil(visible, 5000).setValue(objectHelper.city());
        $(By.name("city")).waitUntil(visible, 5000).setValue(String.valueOf(objectHelper.city()));
        $(By.name("state")).setValue(objectHelper.state()).waitUntil(visible, 5000).pressEnter();
        $(By.name("country")).waitUntil(visible, 5000).setValue(objectHelper.country());
        $(By.name("zip_code")).setValue("qwerty").waitUntil(visible, 5000).pressEnter();
        $(By.name("email")).waitUntil(visible, 5000).setValue(objectHelper.email());
        $(By.name("phone")).waitUntil(visible, 5000).setValue(objectHelper.phone()).pressEnter();
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-registration-third-step/form/div[5]/button[2]/div")).shouldHave(text("REGISTER"));
        close();
    }

    @Test
    public void ThreeStepEmptyFields() {
        // open("http://sports.innerzone.local/#/registration");
        $(By.name("entity_name")).setValue(objectHelper.generateRandomUsername() + timeStampSeconds);
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-registration-first-step/form/div[2]/dropdown/div/div/label")).click();
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-registration-first-step/form/div[2]/dropdown/div/div[2]/div[2]")).click();
        $(By.name("first_name")).setValue(objectHelper.firstName());
        $(By.name("last_name")).setValue(objectHelper.lastName()).pressEnter();
        $(By.name("address")).setValue(objectHelper.address());
        $(By.name("city")).setValue(objectHelper.city());
        $(By.name("state")).setValue(objectHelper.state());
        $(By.name("country")).setValue(objectHelper.country());
        $(By.name("zip_code")).setValue("qwerty");
        $(By.name("email")).setValue(objectHelper.email());
        $(By.name("phone")).setValue(objectHelper.phone()).pressEnter();
        $(By.name("username")).setValue("");
        $(By.name("password")).setValue("");
        $(By.name("verifyPassword")).setValue("");
        $(By.name("verify")).click();
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-registration-third-step/form/div[5]/button[2]")).pressEnter();
        $(By.name("username")).shouldHave(cssClass("ng-invalid"));
        $(By.name("password")).shouldHave(cssClass("ng-invalid"));
        $(By.name("verifyPassword")).shouldHave(cssClass("ng-invalid"));
        close();
    }

    @Test
    public void CorrectThreeStep() {
        // open("http://sports.innerzone.local/#/registration");
        $(By.name("entity_name")).setValue(objectHelper.generateRandomUsername() + timeStampSeconds);
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-registration-first-step/form/div[2]/dropdown/div/div/label")).click();
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-registration-first-step/form/div[2]/dropdown/div/div[2]/div[2]")).click();
        $(By.name("first_name")).setValue(objectHelper.firstName());
        $(By.name("last_name")).setValue(objectHelper.lastName()).pressEnter();
        $(By.name("address")).setValue(objectHelper.address());
        $(By.name("city")).setValue(objectHelper.city());
        $(By.name("state")).setValue(objectHelper.state());
        $(By.name("country")).setValue(objectHelper.country());
        $(By.name("zip_code")).setValue("qwerty");
        $(By.name("email")).setValue(objectHelper.email());
        $(By.name("phone")).setValue(objectHelper.phone()).pressEnter();
        $(By.name("username")).setValue(objectHelper.username() + timeStampSeconds);
        $(By.name("password")).setValue("qwerty");
        $(By.name("verifyPassword")).setValue("qwerty");
        $(By.name("verify")).click();
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-registration-third-step/form/div[5]/button[2]")).pressEnter();
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-confirm-terms-of-service/div")).shouldHave(text("Click \"Yes\" to confirm that you agree to be bound by the Terms of Use.. If you click \"No\", you will be unable to access the InnerZone.\n" +
                "    ®. questionnaire.."));
        close();
    }

    @Test
    public void ThreeStepNoVerfyPassword() {
        // open("http://sports.innerzone.local/#/registration");
        $(By.name("entity_name")).setValue(objectHelper.generateRandomUsername() + timeStampSeconds);
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-registration-first-step/form/div[2]/dropdown/div/div/label")).click();
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-registration-first-step/form/div[2]/dropdown/div/div[2]/div[2]")).click();
        $(By.name("first_name")).setValue(objectHelper.firstName());
        $(By.name("last_name")).setValue(objectHelper.lastName()).pressEnter();
        $(By.name("address")).setValue(objectHelper.address());
        $(By.name("city")).setValue(objectHelper.city());
        $(By.name("state")).setValue(objectHelper.state());
        $(By.name("country")).setValue(objectHelper.country());
        $(By.name("zip_code")).setValue("qwerty");
        $(By.name("email")).setValue(objectHelper.email());
        $(By.name("phone")).setValue(objectHelper.phone()).pressEnter();
        $(By.name("username")).setValue(objectHelper.username() + timeStampSeconds);
        $(By.name("password")).setValue("qwerty");
        $(By.name("verifyPassword")).setValue("qwertu");
        $(By.name("verify")).click();
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-registration-third-step/form/div[5]/button[2]")).pressEnter();
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-registration-third-step/form/div[3]/input")).shouldHave(cssClass("ng-invalid"));
        close();
    }

    @Test
    public void ThreeStepNoVerify() {
        // open("http://sports.innerzone.local/#/registration");
        $(By.name("entity_name")).setValue(objectHelper.generateRandomUsername() + timeStampSeconds);
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-registration-first-step/form/div[2]/dropdown/div/div/label")).click();
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-registration-first-step/form/div[2]/dropdown/div/div[2]/div[2]")).click();
        $(By.name("first_name")).setValue(objectHelper.firstName());
        $(By.name("last_name")).setValue(objectHelper.lastName()).pressEnter();
        $(By.name("address")).setValue(objectHelper.address());
        $(By.name("city")).setValue(objectHelper.city());
        $(By.name("state")).setValue(objectHelper.state());
        $(By.name("country")).setValue(objectHelper.country());
        $(By.name("zip_code")).setValue("qwerty");
        $(By.name("email")).setValue(objectHelper.email());
        $(By.name("phone")).setValue(objectHelper.phone()).pressEnter();
        $(By.name("username")).setValue(objectHelper.username() + timeStampSeconds);
        $(By.name("password")).setValue("qwerty");
        $(By.name("verifyPassword")).setValue("qwerty");
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-registration-third-step/form/div[5]/button[2]")).pressEnter();
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-registration-third-step/form/div[4]/input")).shouldHave(cssClass("ng-invalid"));

        close();
    }

    @Test
    public void ThreeStepTermsOfUse() {
        $(By.name("entity_name")).setValue(objectHelper.generateRandomUsername() + timeStampSeconds);
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-registration-first-step/form/div[2]/dropdown/div/div/label")).click();
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-registration-first-step/form/div[2]/dropdown/div/div[2]/div[2]")).click();
        $(By.name("first_name")).setValue(objectHelper.firstName());
        $(By.name("last_name")).setValue(objectHelper.lastName()).pressEnter();
        $(By.name("address")).setValue(objectHelper.address());
        $(By.name("city")).setValue(objectHelper.city());
        $(By.name("state")).setValue(objectHelper.state());
        $(By.name("country")).setValue(objectHelper.country());
        $(By.name("zip_code")).setValue("qwerty");
        $(By.name("email")).setValue(objectHelper.email());
        $(By.name("phone")).setValue(objectHelper.phone()).pressEnter();
        $(By.name("username")).setValue(objectHelper.username() + timeStampSeconds);
        $(By.name("password")).setValue("qwerty");
        $(By.name("verifyPassword")).setValue("qwerty");
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-registration-third-step/form/div[4]/a")).click();
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/modal/div/div/div/div[2]/modal-content/app-terms-of-service/div/div[1]")).shouldHave(text("Changes to the Terms of Use"));

        close();
    }

    @Test
    public void ThreeStepTermsOfUseClosed() {
        $(By.name("entity_name")).setValue(objectHelper.generateRandomUsername() + timeStampSeconds);
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-registration-first-step/form/div[2]/dropdown/div/div/label")).click();
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-registration-first-step/form/div[2]/dropdown/div/div[2]/div[2]")).click();
        $(By.name("first_name")).setValue(objectHelper.firstName());
        $(By.name("last_name")).setValue(objectHelper.lastName()).pressEnter();
        $(By.name("address")).setValue(objectHelper.address());
        $(By.name("city")).setValue(objectHelper.city());
        $(By.name("state")).setValue(objectHelper.state());
        $(By.name("country")).setValue(objectHelper.country());
        $(By.name("zip_code")).setValue("qwerty");
        $(By.name("email")).setValue(objectHelper.email());
        $(By.name("phone")).setValue(objectHelper.phone()).pressEnter();
        $(By.name("username")).setValue(objectHelper.username());
        $(By.name("password")).setValue("qwerty");
        $(By.name("verifyPassword")).setValue("qwerty");
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-registration-third-step/form/div[4]/a")).click();
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/modal/div/div/div/div[2]/modal-content/app-terms-of-service/div/div[2]/button")).click();
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/app-title/div/div/h1")).shouldHave(text("REGISTRATION"));

        close();
    }

    @Test
    public void ThreeStepBackStep() {
        $(By.name("entity_name")).setValue(objectHelper.generateRandomUsername() + timeStampSeconds);
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-registration-first-step/form/div[2]/dropdown/div/div/label")).click();
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-registration-first-step/form/div[2]/dropdown/div/div[2]/div[2]")).click();
        $(By.name("first_name")).setValue(objectHelper.firstName());
        $(By.name("last_name")).setValue(objectHelper.lastName()).pressEnter();
        $(By.name("address")).setValue(objectHelper.address());
        $(By.name("city")).setValue(objectHelper.city());
        $(By.name("state")).setValue(objectHelper.state());
        $(By.name("country")).setValue(objectHelper.country());
        $(By.name("zip_code")).setValue("qwerty");
        $(By.name("email")).setValue(objectHelper.email());
        $(By.name("phone")).setValue(objectHelper.phone()).pressEnter();
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-registration-third-step/form/div[5]/button[1]")).pressEnter();
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-registration-second-step/form/div[1]")).shouldHave(text("Street Address"));

        close();
    }

    @Test
    public void ThreeStepUsernameAlredyUsed() {
        // open("http://sports.innerzone.local/#/registration");
        $(By.name("entity_name")).setValue(objectHelper.generateRandomUsername() + timeStampSeconds);
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-registration-first-step/form/div[2]/dropdown/div/div/label")).click();
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-registration-first-step/form/div[2]/dropdown/div/div[2]/div[2]")).click();
        $(By.name("first_name")).setValue(objectHelper.firstName());
        $(By.name("last_name")).setValue(objectHelper.lastName()).pressEnter();
        $(By.name("address")).setValue(objectHelper.address());
        $(By.name("city")).setValue(objectHelper.city());
        $(By.name("state")).setValue(objectHelper.state());
        $(By.name("country")).setValue(objectHelper.country());
        $(By.name("zip_code")).setValue("qwerty");
        $(By.name("email")).setValue(objectHelper.email());
        $(By.name("phone")).setValue(objectHelper.phone()).pressEnter();
        $(By.name("username")).setValue("smladmin");
        $(By.name("password")).setValue("qwerty");
        $(By.name("verifyPassword")).setValue("qwerty");
        $(By.name("verify")).click();
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-registration-third-step/form/div[5]/button[2]")).pressEnter();
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-registration-third-step/form/div[2]")).shouldHave(text("Username name is already used."));
        close();
    }

    @Test
    public void CorrectRegisrtration() {
        $(By.name("entity_name")).setValue(objectHelper.generateRandomUsername() + timeStampSeconds);
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-registration-first-step/form/div[2]/dropdown/div/div/label")).click();
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-registration-first-step/form/div[2]/dropdown/div/div[2]/div[2]")).click();
        $(By.name("first_name")).setValue(objectHelper.firstName());
        $(By.name("last_name")).setValue(objectHelper.lastName()).pressEnter();
        $(By.name("address")).setValue(objectHelper.address());
        $(By.name("city")).setValue(objectHelper.city());
        $(By.name("state")).setValue(objectHelper.state());
        $(By.name("country")).setValue(objectHelper.country());
        $(By.name("zip_code")).setValue("qwerty");
        $(By.name("email")).setValue(objectHelper.email());
        $(By.name("phone")).setValue(objectHelper.phone()).pressEnter();
        $(By.name("username")).setValue(objectHelper.username() + timeStampSeconds);
        $(By.name("password")).setValue("qwerty");
        $(By.name("verifyPassword")).setValue("qwerty");
        $(By.name("verify")).click();
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-registration-third-step/form/div[5]/button[2]")).pressEnter();
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-confirm-terms-of-service/div/div/button[1]")).pressEnter();
        $(By.xpath("/html/body/app-root/app-pages/div/app-login/div/div")).shouldHave(text("LOGIN"));
        close();
    }

    @Test
    public void CorrectRegisrtrationStepBack() {
        $(By.name("entity_name")).setValue(objectHelper.generateRandomUsername() + timeStampSeconds);
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-registration-first-step/form/div[2]/dropdown/div/div/label")).click();
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-registration-first-step/form/div[2]/dropdown/div/div[2]/div[2]")).click();
        $(By.name("first_name")).setValue(objectHelper.firstName());
        $(By.name("last_name")).setValue(objectHelper.lastName()).pressEnter();
        $(By.name("address")).setValue(objectHelper.address());
        $(By.name("city")).setValue(objectHelper.city());
        $(By.name("state")).setValue(objectHelper.state());
        $(By.name("country")).setValue(objectHelper.country());
        $(By.name("zip_code")).setValue("qwerty");
        $(By.name("email")).setValue(objectHelper.email());
        $(By.name("phone")).setValue(objectHelper.phone()).pressEnter();
        $(By.name("username")).setValue(objectHelper.username() + timeStampSeconds);
        $(By.name("password")).setValue("qwerty");
        $(By.name("verifyPassword")).setValue("qwerty");
        $(By.name("verify")).click();
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-registration-third-step/form/div[5]/button[2]")).pressEnter();
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div/div/app-confirm-terms-of-service/div/div/button[2]")).pressEnter();
        $(By.xpath("/html/body/app-root/app-pages/div/app-registration/div")).shouldHave(text("REGISTRATION"));
        close();
    }


}
