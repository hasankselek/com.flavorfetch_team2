package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CustomerPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_012 {

    CustomerPage customerPage = new CustomerPage();
    SoftAssert softAssert = new SoftAssert();
    @Test
    public void TC_1201(){
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        customerPage.signInButton.click();
        customerPage.emailBox.sendKeys(ConfigReader.getProperty("customeruser_meltem"));
        customerPage.passwordBox.sendKeys(ConfigReader.getProperty("customerpassword_meltem"));
        customerPage.loginSigninButton.click();
       // ReusableMethods.wait(5);
        Assert.assertTrue(customerPage.localCuisine.isDisplayed());






    }
}
