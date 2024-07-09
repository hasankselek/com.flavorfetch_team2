package tests;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
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
        merchantPage.deliverySettingsLinki.isDisplayed();
        merchantPage.dynamicRatesLinki.click();

        String expected = "Delivery Charges Rates";
        String actual = merchantPage.deliverychargesRatesTexti.getText();
        Assert.assertEquals(actual,expected);

        merchantPage.addnewButton.click();

        String expectedYazi ="Add Charges Rates";
        String actualYazi= merchantPage.addChargesTexti.getText();
        Assert.assertEquals(actualYazi,expectedYazi);

        Select selectType = new Select(merchantPage.shippingTypeDropdown);
        selectType.selectByValue("priority");

        merchantPage.fromTextBox.clear();
        merchantPage.fromTextBox.sendKeys("75");

        merchantPage.toTextBox.clear();
        merchantPage.toTextBox.sendKeys("400");

        merchantPage.priceTextBox.sendKeys("15.00");
        merchantPage.deliveryEstimationTextBox.sendKeys("15-25");
        merchantPage.minimumOrderTextBox.sendKeys("4");
        merchantPage.maximumOrderTextBox.sendKeys("20");
        ReusableMethods.wait2(3);
        merchantPage.settingSaveButton.click();

        Driver.quitDriver();
    }
}
