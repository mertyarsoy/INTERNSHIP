package ui.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import ui.pages.Home_page;
import ui.pages.Login_page;
import utils.DriverHelper;

public class AddToCartStepDef {
    WebDriver driver = DriverHelper.getDriver();
    Login_page loginPage=new Login_page(driver);
    @Given("user provides username {string} password {string}")
    public void userProvidesUsernameYaseminnnPassword(String username, String password) throws InterruptedException {
        loginPage.Login(username,password);
    }

    @When("user clicks Add to cart button")
    public void userClicksAddToCartButton(){
    }
    @Then("user validates check mark on that blue button")
    public void userValidatesCheckMarkOnThatBlueButton() throws InterruptedException {
        Home_page homePage=new Home_page(driver);
        homePage.clickAddToCartButton(driver);
        Assert.assertTrue(homePage.validateAddToCartButtonFunctionality());
    }


}
