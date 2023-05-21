package ui.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import ui.pages.Cart_page;
import ui.pages.Home_page;
import ui.pages.Login_page;
import utils.ConfigReader_UI_API;
import utils.DriverHelper;

public class Product_stepdef {
    WebDriver driver = DriverHelper.getDriver();
    Login_page loginPage = new Login_page(driver);
    Home_page home = new Home_page(driver);
    Cart_page cart = new Cart_page(driver);


    @Given("user provides username and password")
    public void userProvidesUsernameAndPassword() throws InterruptedException {
       loginPage.Login(ConfigReader_UI_API.readProperty("username"),ConfigReader_UI_API.readProperty("password"));
    }
    @Then("user validates {int} products are listed along with description and price")
    public void user_validates_products_are_listed_along_with_description_and_price(int numberOfProducts) throws InterruptedException {
        home.validateProdNumber(numberOfProducts);
        home.validateProdNames();
        home.validateProdParag();
        home.validateProdPrice();
        home.validateAddCartButton(driver);
    }
    @Then("user validates cart button is working properly and expected amount of names is {int}")
    public void userValidatesCartButtonIsWorkingProperlyAndExpectedAmountOfNamesIs(int expectedAmountOfProducts) {
        cart.validateProductNamesAmount(expectedAmountOfProducts);
    }

}
