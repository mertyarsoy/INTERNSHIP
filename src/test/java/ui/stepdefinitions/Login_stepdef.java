package ui.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import ui.pages.Cart_page;
import ui.pages.Home_page;
import ui.pages.Login_page;
import utils.ConfigReader_UI_API;
import utils.DriverHelper;

public class Login_stepdef {

    WebDriver driver = DriverHelper.getDriver();
    Login_page loginPage = new Login_page(driver);


    @Given("User navigates to the website")
    public void userNavigatesToTheWebsite() {
    }

    @When("User provides username and password")
    public void userProvidesUsernameAndPassword() throws InterruptedException {
        loginPage.Login(ConfigReader_UI_API.readProperty("username"),ConfigReader_UI_API.readProperty("password"));
    }
    @Then("User validates the {string}")
    public void userValidatesThe(String title) {
        Assert.assertEquals("Ecommerce App",title);
    }

    @When("User provides {string} and {string}")
    public void userProvidesAnd(String username, String password) throws InterruptedException {
        loginPage.Login(username,password);
    }

    @Then("User validates {string}")
    public void userValidates(String errorMessage) {
        loginPage.validateErrorMessage(errorMessage);
    }




}
