package tests;

import org.testng.annotations.Test;
import pages.MerchantPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_034 {

    @Test
    public void TC_3401(){
        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
        MerchantPage merchantPage = new MerchantPage();
        merchantPage.usernametextbox.sendKeys(ConfigReader.getProperty("merchant_username"));
        merchantPage.passwordtextbox.sendKeys(ConfigReader.getProperty("merchant_password"));
        merchantPage.singinButton.click();
        merchantPage.ordertypeLinki.click();
        merchantPage.deliveryLinki.click();
        ReusableMethods.wait2(2);
        Driver.quitDriver();
    }
}
