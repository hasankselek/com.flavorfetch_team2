package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.CustomerPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_002 {
    CustomerPage customerPage = new CustomerPage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void TC0201(){
        customerPage = new CustomerPage();
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        Assert.assertTrue(customerPage.anaSayfaHeaderLogo.isDisplayed());
        customerPage.anaSayfaHeaderLogo.click();
        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = "https://qa.flavorfetch.com/";
        org.testng.Assert.assertEquals(actualUrl,expectedUrl);
        Driver.quitDriver();
    }
    @Test
    public void TC0202(){

        customerPage = new CustomerPage();
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        ReusableMethods.wait(3);
        Assert.assertTrue(customerPage.cartHeaderButton.isDisplayed());
        customerPage.cartHeaderButton.click();
        Assert.assertTrue(customerPage.cartHeaderSayfa.isDisplayed());
        Driver.quitDriver();
    }

    @Test
    public void     TC0203(){
        customerPage = new CustomerPage();
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        Assert.assertTrue(customerPage.cartikonHeader.isDisplayed());
        customerPage.cartikonHeader.click();
        Assert.assertTrue(customerPage.cartHeaderSayfa.isDisplayed());
        Assert.assertTrue(customerPage.cartikonSayi.isDisplayed());
        String expectedBeklenenSayi = "0";
        String actualBeklenenSayi = customerPage.cartikonSayi.getText();
        Assert.assertEquals(expectedBeklenenSayi,actualBeklenenSayi);
        Driver.quitDriver();

    }
    @Test
    public void TC0204(){
        customerPage = new CustomerPage();
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        ReusableMethods.wait(3);
        Assert.assertTrue(customerPage.signInButton.isDisplayed());
        customerPage.signInButton.click();
        String expectedUrl = "https://qa.flavorfetch.com/account/login";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        Driver.quitDriver();
    }
}
