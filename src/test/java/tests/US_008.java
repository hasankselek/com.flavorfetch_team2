package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomerPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtilities;
import utilities.ReusableMethods;

public class US_008 {

    CustomerPage customerPage = new CustomerPage();


    @Test
    public void TC_0801 (){
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        JSUtilities.scrollToBottom(Driver.getDriver());
        ReusableMethods.wait(1);

        Assert.assertTrue(customerPage.termsandconditionsLink.isDisplayed());
        Assert.assertTrue(customerPage.termsandconditionsLink.isEnabled());

        customerPage.termsandconditionsLink.click();

        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = "https://qa.flavorfetch.com/terms-and-conditions";

        Assert.assertEquals(actualUrl,expectedUrl);

        Driver.quitDriver();

    }

    @Test
    public void TC_0802(){
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        customerPage.italianRestaurants.click();

        JSUtilities.scrollToBottom(Driver.getDriver());
        ReusableMethods.wait(1);

        Assert.assertTrue(customerPage.termsandconditionsLink.isDisplayed());
        Assert.assertTrue(customerPage.termsandconditionsLink.isEnabled());

        customerPage.termsandconditionsLink.click();


        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = "https://qa.flavorfetch.com/terms-and-conditions";

        Assert.assertEquals(actualUrl,expectedUrl);

        Driver.quitDriver();


    }
}
