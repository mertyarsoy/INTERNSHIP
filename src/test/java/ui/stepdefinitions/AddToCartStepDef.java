package ui.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import ui.pages.Home_page;

public class AddToCartStepDef {
    WebDriver driver;
    Home_page homePage=new Home_page(driver);
    @When("user clicks Add to cart button")
    public void userClicksAddToCartButton(){
    }
    @Then("user validates check mark on that blue button")
    public void userValidatesCheckMarkOnThatBlueButton() throws InterruptedException {
        Thread.sleep(5000);
        homePage.validateCheckMark(driver);
    }

}
