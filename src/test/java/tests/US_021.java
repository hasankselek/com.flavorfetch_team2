package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MerchantPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtilities;
import utilities.ReusableMethods;

import java.util.List;

public class US_021 { //Merchant Page Dashboard Access
    MerchantPage merchantPage = new MerchantPage();




    @Test
    public void TC_2101 (){
        String expectedUrl = "https://qa.flavorfetch.com/backoffice/merchant/dashboard";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);


        Driver.quitDriver();


    }
    @Test
    public void TC_2102 (){ //Merchant Page Dashboard Access and Clickable
        merchantPage = new MerchantPage();
        ReusableMethods.accessToMerchant();
        JSUtilities.scrollToBottom(Driver.getDriver());

        Assert.assertTrue(merchantPage.dashboardLink.isEnabled());

        merchantPage.dashboardLink.click();

        String actualDashboardText = merchantPage.dashboardLink.getText();
        String expectedDashboardText = "Dashboard";

        Assert.assertEquals(actualDashboardText,expectedDashboardText);

        Driver.quitDriver();


    }

    @Test
    public void TC_2103(){ // Merchant Page sidebar All Menus Access
        merchantPage = new MerchantPage();
        ReusableMethods.accessToMerchant();
        Assert.assertTrue(merchantPage.merchantLink.isDisplayed());
        merchantPage.merchantLink.click();
        ReusableMethods.wait(1);

        Assert.assertTrue(merchantPage.ordersLink.isDisplayed());
        merchantPage.ordersLink.click();
        ReusableMethods.wait(1);

        Assert.assertTrue(merchantPage.attributesLink.isDisplayed());
        merchantPage.attributesLink.click();
        ReusableMethods.wait(1);

        Assert.assertTrue(merchantPage.foodLink.isDisplayed());
        merchantPage.foodLink.click();
        ReusableMethods.wait(1);

        Assert.assertTrue(merchantPage.ordertypeLinki.isDisplayed());
        merchantPage.ordertypeLinki.click();
        ReusableMethods.wait(1);

        Assert.assertTrue(merchantPage.paymentGatewayLink.isDisplayed());
        merchantPage.paymentGatewayLink.click();
        ReusableMethods.wait(1);

        Assert.assertTrue(merchantPage.promoLink.isDisplayed());
        merchantPage.promoLink.click();
        ReusableMethods.wait(1);

        Assert.assertTrue(merchantPage.imagesLink.isDisplayed());
        merchantPage.imagesLink.click();
        ReusableMethods.wait(1);

        Assert.assertTrue(merchantPage.accountLink.isDisplayed());
        merchantPage.accountLink.click();
        ReusableMethods.wait(1);

        Assert.assertTrue(merchantPage.buyersLink.isDisplayed());
        merchantPage.buyersLink.click();
        ReusableMethods.wait(1);

        Assert.assertTrue(merchantPage.usersLink.isDisplayed());
        merchantPage.usersLink.click();
        ReusableMethods.wait(1);

        Assert.assertTrue(merchantPage.reportsLink.isDisplayed());
        merchantPage.reportsLink.click();
        ReusableMethods.wait(1);

        Assert.assertTrue(merchantPage.inventoryManagementLink.isDisplayed());
        merchantPage.inventoryManagementLink.click();
        ReusableMethods.wait(1);

        Driver.quitDriver();
    }

    @Test
    public void TC_2104(){
        merchantPage = new MerchantPage();
        ReusableMethods.accessToMerchant();
        Assert.assertTrue(merchantPage.merchantLink.isDisplayed());
        merchantPage.merchantLink.click();
        ReusableMethods.wait(1);
        merchantPage.informationLink.click();
        String expectedTitle = "Information";
        String actualTitle = Driver.getDriver().getTitle();
        //Assert.assertTrue(actualTitle.contains(expectedTitle));
    }


}
