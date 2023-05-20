package ui.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Home_page {
    public Home_page(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(tagName = "h5")
    List <WebElement> names;
    @FindBy(xpath = "//div[@class='card-body']//p[1]")
    List <WebElement> paragraphs;
    @FindBy(xpath = "//div[@class='card-body']//p[2]")
    List <WebElement> prices;


    public void validateProdNumber(int expectedNum) throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals(names.size(),expectedNum);
    }
    public void validateProdNames(){
        List <String> expectedNames = Arrays.asList("Pfizer Vaccine","Sputnik Vaccine","Paracetamol","Tramadol",
                "Aspirine","Advanced Dissection Kit","CALIBRA Sphygmomanometer","LCD Digital Microscope","NIKON DIAPHOT");
        for (int i = 0; i < names.size(); i++) {
            Assert.assertEquals(BrowserUtils.getTextandTrim(names.get(i)),expectedNames.get(i));
        }
    }

    public void validateProdParag(){
        List <String> expectedParag = Arrays.asList("Comirnaty, is an mRNA","Russian Gamaleya Research","mild-to-moderate pain",
                "Tramadol is a synthetic","Aspirin is used to","By Poly Medical","Calibra Aneroid Sphygmomanometer","11 Adjustable LED Lights",
             "Labaratory microscope");
        for (int i = 0; i < paragraphs.size(); i++) {
            Assert.assertTrue(BrowserUtils.getTextandTrim(paragraphs.get(i)).contains(expectedParag.get(i)));
        }
    }
    public void validateProdPrice(){
        List<String> expectedPrice = Arrays.asList("9.99$","6.59$","10.29$","10.39$","5.99$","59.99$","34.99$","253.79$","1845.59$");
        for (int i = 0; i < prices.size(); i++) {
            Assert.assertEquals(BrowserUtils.getTextandTrim(prices.get(i)),expectedPrice.get(i));
        }
    }
}
