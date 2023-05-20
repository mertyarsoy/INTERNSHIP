package ui.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class RegisterPage {

    public RegisterPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[@name='regbtn']")
    WebElement registerButton;

    @FindBy(xpath = "//input[@name='username']")
    WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    WebElement password;

    @FindBy(xpath = "//button[@name='loginbtn']")
    WebElement register;

    @FindBy(xpath = "//div[.='Username already taken']")
    WebElement error;

    public void register(WebDriver driver, String username, String password) throws InterruptedException {
        registerButton.click();
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        register.click();
        Login_page loginPage=new Login_page(driver);
        loginPage.Login(username, password);
    }

    public String getErrorMessage(){
        return BrowserUtils.getTextandTrim(error);
    }

    public void register2(String username){
        registerButton.click();
        this.username.clear();
        this.username.sendKeys(username);
        register.click();
    }


}
