package ui.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class Cart_page {
    public Cart_page(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//tr//td[2]")
    List<WebElement> actualAmountOfNames;

    public void validateProductNamesAmount(int expectedAmountOfNames){

        Assert.assertEquals(actualAmountOfNames.size(),expectedAmountOfNames);
    }
}
