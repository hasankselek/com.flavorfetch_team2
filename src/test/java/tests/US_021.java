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
    public void TC_2101() {
        String expectedUrl = "https://qa.flavorfetch.com/backoffice/merchant/dashboard";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);


        Driver.quitDriver();


    }

    @Test
    public void TC_2102() //Merchant Page Dashboard Access and Clickable
        {  merchantPage = new MerchantPage();
        ReusableMethods.accessToMerchant();
        JSUtilities.scrollToBottom(Driver.getDriver());

        Assert.assertTrue(merchantPage.dashboardLink.isEnabled());

        merchantPage.dashboardLink.click();

        String actualDashboardText = merchantPage.dashboardLink.getText();
        String expectedDashboardText = "Dashboard";

        Assert.assertEquals(actualDashboardText, expectedDashboardText);

        Driver.quitDriver();


    }

    @Test
    public void TC_2103() // Merchant Page sidebar All Menus Access
        {  merchantPage = new MerchantPage();
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
    public void TC_2104() // Merchant Page sidebar Merchant Menu Test
    {
        merchantPage = new MerchantPage();
        ReusableMethods.accessToMerchant();

        List<String> beforeClickList = ReusableMethods.stringListesineDonustur(merchantPage.merchantMenuList);

        Assert.assertTrue(merchantPage.merchantLink.isDisplayed());
        merchantPage.merchantLink.click();
        ReusableMethods.wait(1);

        //Information Menu Test
        Assert.assertTrue(merchantPage.informationLink.isDisplayed());
        merchantPage.informationLink.click();
        String expectedTitle = "information";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        ReusableMethods.wait(1);

        //Setting Menu Test
        Assert.assertTrue(merchantPage.settingLink.isDisplayed());
        merchantPage.settingLink.click();
        expectedTitle = "Setting";
        actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        ReusableMethods.wait(1);

        //Order Limit Test
        Assert.assertTrue(merchantPage.orderLimitLink.isDisplayed());
        merchantPage.orderLimitLink.click();
        expectedTitle = "Order limit";
        actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        ReusableMethods.wait(1);

        //Banner Menu Test
        Assert.assertTrue(merchantPage.bannerLink.isDisplayed());
        merchantPage.bannerLink.click();
        expectedTitle = "Banner";
        actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        ReusableMethods.wait(1);

        //Pages Menu Test
        Assert.assertTrue(merchantPage.pagesLink.isDisplayed());
        merchantPage.pagesLink.click();
        expectedTitle = "Pages";
        actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        ReusableMethods.wait(1);

        //Menu Menu Test
        Assert.assertTrue(merchantPage.menuLink.isDisplayed());
        merchantPage.menuLink.click();
        expectedTitle = "menu";
        actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        ReusableMethods.wait(1);

        List<String> afterClickList = ReusableMethods.stringListesineDonustur(merchantPage.merchantMenuList);

        Assert.assertEquals(beforeClickList.size(), afterClickList.size());


        Driver.quitDriver();
    }

    @Test
    public void TC_2105() // Merchant Page sidebar Orders Menu Test
     {
        merchantPage = new MerchantPage();
        ReusableMethods.accessToMerchant();
        List<String> beforeClickList = ReusableMethods.stringListesineDonustur(merchantPage.merchantMenuList);

        Assert.assertTrue(merchantPage.ordersLink.isDisplayed());
        merchantPage.ordersLink.click();
        ReusableMethods.wait(1);

        //New Orders Menu Test
        Assert.assertTrue(merchantPage.newOrdersLink.isDisplayed());
        merchantPage.newOrdersLink.click();
        String expectedTitle = "New Orders";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        ReusableMethods.wait(1);

        //Orders Processing Menu Test
        Assert.assertTrue(merchantPage.ordersProcessingLink.isDisplayed());
        merchantPage.ordersProcessingLink.click();
        expectedTitle = "Orders Processing";
        actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        ReusableMethods.wait(1);

        //Orders Ready Menu Test
        Assert.assertTrue(merchantPage.ordersReadyLink.isDisplayed());
        merchantPage.ordersReadyLink.click();
        expectedTitle = "Orders Ready";
        actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        ReusableMethods.wait(1);

        //Completed Menu Test
        Assert.assertTrue(merchantPage.completedLink.isDisplayed());
        merchantPage.completedLink.click();
        expectedTitle = "Completed";
        actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        ReusableMethods.wait(1);

        //Scheduled Menu Test
        Assert.assertTrue(merchantPage.scheduledLink.isDisplayed());
        merchantPage.scheduledLink.click();
        expectedTitle = "Scheduled";
        actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        ReusableMethods.wait(1);

        //All Orders Menu Test
        Assert.assertTrue(merchantPage.allOrdersLink.isDisplayed());
        merchantPage.allOrdersLink.click();
        expectedTitle = "Order history";
        actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        ReusableMethods.wait(1);

        List<String> afterClickList = ReusableMethods.stringListesineDonustur(merchantPage.merchantMenuList);

        Assert.assertEquals(beforeClickList.size(), afterClickList.size());


        Driver.quitDriver();
    }

    @Test
    public void TC_2106() //Merchant Page sidebar Attributes Menu Test
    {
        merchantPage = new MerchantPage();
        ReusableMethods.accessToMerchant();
        List<String> beforeClickList = ReusableMethods.stringListesineDonustur(merchantPage.merchantMenuList);

        Assert.assertTrue(merchantPage.attributesLink.isDisplayed());
        merchantPage.attributesLink.click();
        ReusableMethods.wait(1);

        //Size Menu Test
        Assert.assertTrue(merchantPage.sizeLink.isDisplayed());
        merchantPage.sizeLink.click();
        String expectedTitle = "Size";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        ReusableMethods.wait(1);

        //Ingredients Menu Test
        Assert.assertTrue(merchantPage.ingredientsLink.isDisplayed());
        merchantPage.ingredientsLink.click();
        expectedTitle = "Ingredients";
        actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        ReusableMethods.wait(1);

        //Cooking Reference Menu Test
        Assert.assertTrue(merchantPage.cookingReferenceLink.isDisplayed());
        merchantPage.cookingReferenceLink.click();
        expectedTitle = "Cooking Reference";
        actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        ReusableMethods.wait(1);

        List<String> afterClickList = ReusableMethods.stringListesineDonustur(merchantPage.merchantMenuList);

        Assert.assertEquals(beforeClickList.size(), afterClickList.size());


        Driver.quitDriver();

    }

    @Test
    public void TC_2107() //Merchant Page sidebar Food Menu Test
    {
        merchantPage = new MerchantPage();
        ReusableMethods.accessToMerchant();
        List<String> beforeClickList = ReusableMethods.stringListesineDonustur(merchantPage.merchantMenuList);

        Assert.assertTrue(merchantPage.foodLink.isDisplayed());
        merchantPage.foodLink.click();
        ReusableMethods.wait(1);

        //Category Menu Test
        Assert.assertTrue(merchantPage.categoryLink.isDisplayed());
        merchantPage.categoryLink.click();
        String expectedTitle = "Category";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        ReusableMethods.wait(1);

        //Addon Category Menu Test
        Assert.assertTrue(merchantPage.addonCategoryLink.isDisplayed());
        merchantPage.addonCategoryLink.click();
        expectedTitle = "Addon Category";
        actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        ReusableMethods.wait(1);

        //Addon Items Menu Test
        Assert.assertTrue(merchantPage.addonItemsLink.isDisplayed());
        merchantPage.addonItemsLink.click();
        expectedTitle = "Addon Item";
        actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        ReusableMethods.wait(1);

        //Items Menu Test
        Assert.assertTrue(merchantPage.itemsLink.isDisplayed());
        merchantPage.itemsLink.click();
        expectedTitle = "Item";
        actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        ReusableMethods.wait(1);

        List<String> afterClickList = ReusableMethods.stringListesineDonustur(merchantPage.merchantMenuList);

        Assert.assertEquals(beforeClickList.size(), afterClickList.size());


        Driver.quitDriver();

    }

    @Test
    public void TC_2108() //Merchant Page sidebar Order Type Menu Test
    {
        merchantPage = new MerchantPage();
        ReusableMethods.accessToMerchant();
        List<String> beforeClickList = ReusableMethods.stringListesineDonustur(merchantPage.merchantMenuList);

        Assert.assertTrue(merchantPage.ordertypeLinki.isDisplayed());
        merchantPage.ordertypeLinki.click();
        ReusableMethods.wait(1);

        //Delivery Menu Test
        Assert.assertTrue(merchantPage.deliveryLinki.isDisplayed());
        merchantPage.deliveryLinki.click();
        String expectedTitle = "delivery";
        String actualTitle = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        ReusableMethods.wait(1);

        //Pickup Menu Test
        Assert.assertTrue(merchantPage.pickupLink.isDisplayed());
        merchantPage.pickupLink.click();
        expectedTitle = "pickup";
        actualTitle = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        ReusableMethods.wait(1);

        //Addon Items Menu Test
        Assert.assertTrue(merchantPage.dineinLinki.isDisplayed());
        merchantPage.dineinLinki.click();
        expectedTitle = "dinein";
        actualTitle = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        ReusableMethods.wait(1);


        List<String> afterClickList = ReusableMethods.stringListesineDonustur(merchantPage.merchantMenuList);

        Assert.assertEquals(beforeClickList.size(), afterClickList.size());


        Driver.quitDriver();

    }

    @Test
    public void TC_2109() //Merchant Page sidebar Payment gateway Menu Test
    {
        merchantPage = new MerchantPage();
        ReusableMethods.accessToMerchant();
        List<String> beforeClickList = ReusableMethods.stringListesineDonustur(merchantPage.merchantMenuList);

        Assert.assertTrue(merchantPage.paymentGatewayLink.isDisplayed());
        merchantPage.paymentGatewayLink.click();
        ReusableMethods.wait(1);

        //All Payments Menu Test
        Assert.assertTrue(merchantPage.allpaymentsLink.isDisplayed());
        merchantPage.allpaymentsLink.click();
        String expectedTitle = "All Payments";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        ReusableMethods.wait(1);

        //Bank Deposit Menu Test
        Assert.assertTrue(merchantPage.bankDepositLink.isDisplayed());
        merchantPage.bankDepositLink.click();
        expectedTitle = "Bank Deposit";
        actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        ReusableMethods.wait(1);


        List<String> afterClickList = ReusableMethods.stringListesineDonustur(merchantPage.merchantMenuList);

        Assert.assertEquals(beforeClickList.size(), afterClickList.size());


        Driver.quitDriver();

    }

    @Test
    public void TC_2110() //Merchant Page sidebar Promo Menu Test
    {
        merchantPage = new MerchantPage();
        ReusableMethods.accessToMerchant();
        List<String> beforeClickList = ReusableMethods.stringListesineDonustur(merchantPage.merchantMenuList);

        Assert.assertTrue(merchantPage.promoLink.isDisplayed());
        merchantPage.promoLink.click();
        ReusableMethods.wait(1);

        //Coupon Menu Test
        Assert.assertTrue(merchantPage.couponLink.isDisplayed());
        merchantPage.couponLink.click();
        String expectedTitle = "Coupon";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        ReusableMethods.wait(1);



        List<String> afterClickList = ReusableMethods.stringListesineDonustur(merchantPage.merchantMenuList);

        Assert.assertEquals(beforeClickList.size(), afterClickList.size());


        Driver.quitDriver();

    }

    @Test
    public void TC_2111() //Merchant Page sidebar Images Menu Test
    {
        merchantPage = new MerchantPage();
        ReusableMethods.accessToMerchant();
        List<String> beforeClickList = ReusableMethods.stringListesineDonustur(merchantPage.merchantMenuList);

        Assert.assertTrue(merchantPage.imagesLink.isDisplayed());
        merchantPage.imagesLink.click();
        ReusableMethods.wait(1);

        //Gallery Menu Test
        Assert.assertTrue(merchantPage.galleryLink.isDisplayed());
        merchantPage.galleryLink.click();
        String expectedTitle = "Gallery";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        ReusableMethods.wait(1);


        //Media Library Menu Test
        Assert.assertTrue(merchantPage.mediaLibraryLink.isDisplayed());
        merchantPage.mediaLibraryLink.click();
        expectedTitle = "Media Library";
        actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        ReusableMethods.wait(1);


        List<String> afterClickList = ReusableMethods.stringListesineDonustur(merchantPage.merchantMenuList);

        Assert.assertEquals(beforeClickList.size(), afterClickList.size());


        Driver.quitDriver();

    }

    @Test
    public void TC_2112() //Merchant Page sidebar Account Menu Test
    {
        merchantPage = new MerchantPage();
        ReusableMethods.accessToMerchant();
        List<String> beforeClickList = ReusableMethods.stringListesineDonustur(merchantPage.merchantMenuList);

        Assert.assertTrue(merchantPage.accountLink.isDisplayed());
        merchantPage.accountLink.click();
        ReusableMethods.wait(1);

        //Statement Menu Test
        Assert.assertTrue(merchantPage.statementLink.isDisplayed());
        merchantPage.statementLink.click();
        String expectedTitle = "Statement";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        ReusableMethods.wait(1);




        List<String> afterClickList = ReusableMethods.stringListesineDonustur(merchantPage.merchantMenuList);

        Assert.assertEquals(beforeClickList.size(), afterClickList.size());


        Driver.quitDriver();

    }

    @Test
    public void TC_2113() //Merchant Page sidebar Buyers Menu Test
    {
        merchantPage = new MerchantPage();
        ReusableMethods.accessToMerchant();
        List<String> beforeClickList = ReusableMethods.stringListesineDonustur(merchantPage.merchantMenuList);

        Assert.assertTrue(merchantPage.buyersLink.isDisplayed());
        merchantPage.buyersLink.click();
        ReusableMethods.wait(1);

        //Gallery Menu Test
        Assert.assertTrue(merchantPage.listLink.isDisplayed());
        merchantPage.listLink.click();
        String expectedTitle = "list";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        ReusableMethods.wait(1);

        // Reviews Menu Test
        Assert.assertTrue(merchantPage.reviewsLink.isDisplayed());
        merchantPage.reviewsLink.click();
        ReusableMethods.wait(1);
        expectedTitle = "reviews";
        actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        ReusableMethods.wait(1);

        List<String> afterClickList = ReusableMethods.stringListesineDonustur(merchantPage.merchantMenuList);

        Assert.assertEquals(beforeClickList.size(), afterClickList.size());


        Driver.quitDriver();

    }

    @Test
    public void TC_2114() //Merchant Page sidebar Users Menu Test
    {
        merchantPage = new MerchantPage();
        ReusableMethods.accessToMerchant();
        List<String> beforeClickList = ReusableMethods.stringListesineDonustur(merchantPage.merchantMenuList);

        Assert.assertTrue(merchantPage.usersLink.isDisplayed());
        merchantPage.usersLink.click();
        ReusableMethods.wait(1);

        //All User Menu Test
        Assert.assertTrue(merchantPage.allUserLink.isDisplayed());
        merchantPage.allUserLink.click();
        String expectedTitle = "User List";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        ReusableMethods.wait(1);

        //All Roles Menu Test
        Assert.assertTrue(merchantPage.allRolesLink.isDisplayed());
        merchantPage.allRolesLink.click();
        expectedTitle = "All Roles";
        actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        ReusableMethods.wait(1);




        List<String> afterClickList = ReusableMethods.stringListesineDonustur(merchantPage.merchantMenuList);

        Assert.assertEquals(beforeClickList.size(), afterClickList.size());


        Driver.quitDriver();

    }

    @Test
    public void TC_2115() //Merchant Page sidebar Reports Menu Test
    {
        merchantPage = new MerchantPage();
        ReusableMethods.accessToMerchant();
        List<String> beforeClickList = ReusableMethods.stringListesineDonustur(merchantPage.merchantMenuList);

        Assert.assertTrue(merchantPage.reportsLink.isDisplayed());
        merchantPage.reportsLink.click();
        ReusableMethods.wait(1);

        //Sales Report Menu Test
        Assert.assertTrue(merchantPage.salesReportLink.isDisplayed());
        merchantPage.salesReportLink.click();
        String expectedTitle = "Sales Report";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        ReusableMethods.wait(1);

        //Sales Summary Menu Test
        Assert.assertTrue(merchantPage.salesSummaryLink.isDisplayed());
        merchantPage.salesSummaryLink.click();
        expectedTitle = "Sales Summary";
        actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        ReusableMethods.wait(1);


        //Refund Report Menu Test
        Assert.assertTrue(merchantPage.refudReporttLink.isDisplayed());
        merchantPage.refudReporttLink.click();
        expectedTitle = "Refund Report";
        actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        ReusableMethods.wait(1);



        List<String> afterClickList = ReusableMethods.stringListesineDonustur(merchantPage.merchantMenuList);

        Assert.assertEquals(beforeClickList.size(), afterClickList.size());


        Driver.quitDriver();

    }

    @Test
    public void TC_2116() //Merchant Page sidebar Inventory Management Menu Test
    {
        merchantPage = new MerchantPage();
        ReusableMethods.accessToMerchant();
        List<String> beforeClickList = ReusableMethods.stringListesineDonustur(merchantPage.merchantMenuList);

        Assert.assertTrue(merchantPage.inventoryManagementLink.isDisplayed());
        merchantPage.inventoryManagementLink.click();
        ReusableMethods.wait(1);

        //Suppliers Menu Test
        Assert.assertTrue(merchantPage.suppliersLink.isDisplayed());
        merchantPage.suppliersLink.click();
        String expectedTitle = "Supplier";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        ReusableMethods.wait(1);




        List<String> afterClickList = ReusableMethods.stringListesineDonustur(merchantPage.merchantMenuList);

        Assert.assertEquals(beforeClickList.size(), afterClickList.size());


        Driver.quitDriver();

    }



}
