package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MerchantPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_022 {

    MerchantPage merchantPage=new MerchantPage();
    SoftAssert softAssert=new SoftAssert();

    @Test
    public void TC_2201(){
        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
        merchantPage.usernametextbox.sendKeys(ConfigReader.getProperty("merchant_username"));
        merchantPage.passwordtextbox.sendKeys(ConfigReader.getProperty("merchant_password"));
        merchantPage.singinButton.click();
        Assert.assertTrue(merchantPage.merchantNamebutton.isDisplayed());
        merchantPage.merchantNamebutton.click();
        Assert.assertTrue(merchantPage.profileSection.isDisplayed());



    }
}
