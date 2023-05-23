package ui.pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class Login_page {
    public Login_page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='username']")
    WebElement username;
    @FindBy(xpath = "//input[@name='password']")
    WebElement password;
    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement loginButton;

    public void Login(String username, String password) throws InterruptedException {
        //Thread.sleep(3000);
        this.username.clear();
        this.username.sendKeys(username);
        //Thread.sleep(3000);
        this.password.clear();
        this.password.sendKeys(password);
        loginButton.click();
    }

    @FindBy(xpath = "//div[contains(text(),'Authentication failed')]")
    WebElement errorMessage;

    public void validateErrorMessage(String errorMessage) {
        Assert.assertEquals(errorMessage, BrowserUtils.getTextandTrim(this.errorMessage));
    }
}
