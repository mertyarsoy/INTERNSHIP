package ui.stepdefinitions;

import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import ui.pages.Category_page;
import utils.DriverHelper;

public class Category_stepdef {



    WebDriver driver = DriverHelper.getDriver();
    Category_page categoryPage = new Category_page(driver);


    @When("User click the  vaccinesButton category")
    public void user_click_the_vaccines_button_category() {
        categoryPage.clickButton();

    }
    @When("User click the drugsButton category")
    public void user_click_the_drugs_button_category() {
        categoryPage.clickButton();

    }
    @When("User click the toolsButton category")
    public void user_click_the_tools_button_category() {
        categoryPage.clickButton();

    }
    @When("User click the carsbutton category")
    public void user_click_the_carsbutton_category() {
        categoryPage.clickButton();


    }

}





