package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Category_page {


    public Category_page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = " //div[@class='btn-group']//button[contains(text(),'Vaccines')]")
    static
    WebElement vaccinesButton;

    @FindBy(xpath = "//div[@class='btn-group']//button[contains(text(),'Drugs')]")
    WebElement drugsButton;

    @FindBy(xpath = "//div[@class='btn-group']//button[contains(text(),'Tools')]")
    WebElement toolsButton;

    @FindBy(xpath = "//div[@class='btn-group']//button[contains(text(),'Machinery')]")
    WebElement machinerybutton;

    @FindBy(xpath = "//div[@class='btn-group']//button[contains(text(),'Cars')]")
    WebElement carsbutton;


    public void clickButton() {
        vaccinesButton.click();
        drugsButton.click();
        toolsButton.click();
        machinerybutton.click();
        carsbutton.click();

    }
}
