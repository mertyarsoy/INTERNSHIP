package ui.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import ui.pages.MainPage;
import ui.pages.RegisterPage;
import utils.DriverHelper;

public class RegistrationStepDef {
    WebDriver driver = DriverHelper.getDriver();
    RegisterPage registerPage=new RegisterPage(driver);
    MainPage mainPage=new MainPage(driver);

    @When("User provides {string} and {string} for registration")
    public void user_provides_and_for_registration(String username, String password) throws InterruptedException {
        registerPage.register(driver,username,password);
    }

    @Then("User should be registered and Username should be shown")
    public void userShouldBeRegisteredAndUsernameShouldBeShown() {
        Assert.assertEquals("yaseminnn12",mainPage.getUsername());
    }

    @When("User provides the already created username {string} and password")
    public void userProvidesTheAlreadyCreatedUsernameAndPassword(String username) throws InterruptedException {
        registerPage.register2(username);
    }
    @Then("User gets the {string} error message")
    public void userGetsTheErrorMessage(String error) {
        Assert.assertEquals(error,registerPage.getErrorMessage());
    }

}
