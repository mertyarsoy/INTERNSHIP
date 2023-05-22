package ui.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import ui.pages.Cart_page;
import ui.pages.Home_page;

public class RemoveFromCartStepDef {
    WebDriver driver;
    Home_page homePage=new Home_page(driver);
    Cart_page cartPage=new Cart_page(driver);
    @When("user navigates to cart page and clicks remove button")
    public void userNavigatesToCartPageAndClicksRemoveButton() throws InterruptedException {
        Thread.sleep(5000);
        homePage.navigateToCart(driver);
        cartPage.clickRemoveButton();
    }
    @Then("user validates {string} message")
    public void userValidatesMessage(String message) {
        cartPage.validateCartIsEmptyMessage(message);
    }

}
