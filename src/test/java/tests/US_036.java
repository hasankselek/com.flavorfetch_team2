package tests;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtilities;
import utilities.ReusableMethods;



public class US_036 {

    AdminPage adminPage = new AdminPage();


    @Test
    public void TC_3601(){


        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));

        adminPage.userNameButton.sendKeys(ConfigReader.getProperty("adminuser_hasan")+Keys.TAB+ConfigReader.getProperty("adminpassword_hasan"));
        adminPage.signInButton.click();

        Assert.assertTrue(adminPage.previewStoreButton.isDisplayed());
        Assert.assertTrue(adminPage.previewStoreButton.isEnabled());

        Assert.assertTrue(adminPage.adminPicture.isDisplayed());

        Assert.assertTrue(adminPage.userprofileName.isDisplayed());
        Assert.assertTrue(adminPage.userprofileName.isEnabled());
        adminPage.userprofileName.click();

        ReusableMethods.wait(2);

        Assert.assertTrue(adminPage.profileText.isDisplayed());
        Assert.assertTrue(adminPage.profileText.isEnabled());

        Assert.assertTrue(adminPage.logoutText.isDisplayed());
        Assert.assertTrue(adminPage.logoutText.isEnabled());

        Assert.assertTrue(adminPage.notificationsIcon.isDisplayed());
        Assert.assertTrue(adminPage.notificationsIcon.isEnabled());

        Driver.quitDriver();

    }

    @Test
    public void TC_3602(){


        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));

        adminPage.userNameButton.sendKeys(ConfigReader.getProperty("adminuser_hasan")+Keys.TAB+ConfigReader.getProperty("adminpassword_hasan"));
        adminPage.signInButton.click();

        Assert.assertTrue(adminPage.notificationsIcon.isDisplayed());
        adminPage.notificationsIcon.click();

        ReusableMethods.wait(2);

        Assert.assertTrue(adminPage.notificationsText.isDisplayed());
        Assert.assertTrue(adminPage.notificationsQuantityText.isDisplayed());

        if(adminPage.notificationsQuantity.isEmpty()){
            Assert.assertTrue(adminPage.emptyNotifications.isDisplayed());
        }
        else{
            Assert.assertTrue(adminPage.clearAllButton.isDisplayed());
            Assert.assertTrue(adminPage.clearAllButton.isEnabled());

            Assert.assertTrue(adminPage.viewAllButton.isDisplayed());
            Assert.assertTrue(adminPage.viewAllButton.isEnabled());

            adminPage.clearAllButton.click();

            ReusableMethods.wait(3);

            int expectedNotificationQuantity = 0;
            int actualNotificationsQuantity = adminPage.notificationsQuantity.size();

            Assert.assertEquals(actualNotificationsQuantity,expectedNotificationQuantity);


        }

        Driver.quitDriver();

    }

    @Test
    public void TC_3603(){

        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));

        adminPage.userNameButton.sendKeys(ConfigReader.getProperty("adminuser_hasan")+Keys.TAB+ConfigReader.getProperty("adminpassword_hasan"));
        adminPage.signInButton.click();

        for (int i = 0; i < adminPage.dashboardTotalHeadings.size(); i++) {
            Assert.assertTrue(adminPage.dashboardTotalHeadings.get(i).isDisplayed());
        }

    }

    @Test
    public void TC_3604(){}

    @Test
    public void TC_3605(){}

    @Test
    public void TC_3606(){
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        adminPage.userNameButton.sendKeys(ConfigReader.getProperty("adminuser_hasan")+Keys.TAB+ConfigReader.getProperty("adminpassword_hasan"));
        adminPage.signInButton.click();

        // Processing
        adminPage.orderStatus.get(1).click();
        for (int i = 0; i < adminPage.acceptedStatus.size(); i++) {
            String expectedStatus ="accepted";
            String actualStatus =  adminPage.acceptedStatus.get(i).getText();
            Assert.assertEquals(actualStatus,expectedStatus);
        }

        // Ready
        adminPage.orderStatus.get(2).click();
        for (int i = 0; i < adminPage.readyForPickupStatus.size(); i++) {
            String expectedStatus ="ready for pickup";
            String actualStatus =  adminPage.readyForPickupStatus.get(i).getText();
            Assert.assertEquals(actualStatus,expectedStatus);
        }

        // Completed
        adminPage.orderStatus.get(3).click();
        for (int i = 0; i < adminPage.deliveredStatus.size(); i++) {
            String expectedStatus ="delivered";
            String actualStatus =  adminPage.deliveredStatus.get(i).getText();
            Assert.assertEquals(actualStatus,expectedStatus);
        }
        Driver.quitDriver();
    }

    @Test
    public void TC_3607(){
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        adminPage.userNameButton.sendKeys(ConfigReader.getProperty("adminuser_hasan")+Keys.TAB+ConfigReader.getProperty("adminpassword_hasan"));
        adminPage.signInButton.click();

        JSUtilities.scrollToElement(Driver.getDriver(),adminPage.popularItemsTitle);

        //Check "Popular items" and "latest popular items" titles are visible
        Assert.assertTrue(adminPage.popularItemsTitle.isDisplayed());
        Assert.assertTrue(adminPage.popularItemsTitle.getText().contains("Popular items"));
        Assert.assertTrue(adminPage.popularItemsTitle.getText().contains("latest popular items"));

        //Check if the "Last 30 days sales" and "Popular Items" titles are visible and active
        Assert.assertTrue(adminPage.popularItemsButton.isDisplayed());
        Assert.assertTrue(adminPage.popularItemsButton.isEnabled());
        Assert.assertTrue(adminPage.Last30daysSalesButton.isDisplayed());
        Assert.assertTrue(adminPage.Last30daysSalesButton.isEnabled());

        //Check item names, types,merchant names and number of items sold of popular items are visible.
        for (int i = 24; i < 29; i++) {
            Assert.assertTrue(adminPage.popularItemsInformation.get(i).isDisplayed());
        }
        for (int i =15; i < 20; i++) {
            Assert.assertTrue(adminPage.popularItemsQuantity.get(i).isDisplayed());
        }

        ReusableMethods.wait(1);
        //Check if images of popular items are visible.
        for (int i = 0; i < 5; i++) {
            Assert.assertTrue(adminPage.popularItemsPictures.get(i).isDisplayed());
        }
        ReusableMethods.wait(1);
        //Click "Last 30 days sales" title
        adminPage.Last30daysSalesButton.click();

        //Check that the sales chart appears and the products sold are listed
        Assert.assertTrue(adminPage.last30DaysSalesChart.isDisplayed());
        Assert.assertFalse(adminPage.last30DaysProducts.isEmpty());

        //Closes the page
        Driver.quitDriver();







    }

    @Test
    public void TC_3608(){

        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        adminPage.userNameButton.sendKeys(ConfigReader.getProperty("adminuser_hasan")+Keys.TAB+ConfigReader.getProperty("adminpassword_hasan"));
        adminPage.signInButton.click();

        //Check "Scroll down the page" and "most reviewed" titles are visible
        JSUtilities.scrollToElement(Driver.getDriver(),adminPage.popularMerchantsAndReviewTitle);

        //Check if the "Popular merchants" and "Popular by review" titles are visible and active
        Assert.assertTrue(adminPage.popularMerchantsAndReviewTitle.isDisplayed());
        Assert.assertTrue(adminPage.popularMerchantsAndReviewTitle.getText().contains("Popular merchants"));
        Assert.assertTrue(adminPage.popularMerchantsAndReviewTitle.getText().contains("best selling restaurant"));

        //Check if the "Last 30 days sales" and "Popular Items" titles are visible and active
        Assert.assertTrue(adminPage.popularMerchantsButton.isDisplayed());
        Assert.assertTrue(adminPage.popularMerchantsButton.isEnabled());
        Assert.assertTrue(adminPage.popularByReviewButton.isDisplayed());
        Assert.assertTrue(adminPage.popularByReviewButton.isEnabled());

        //Check merchant names,merchant types,merchant rating, total number of reviews and number of sales are visible.
        for (int i = 0; i < 5; i++) {
            Assert.assertTrue(adminPage.popularMerchantsInformation.get(i).isDisplayed());
        }
        for (int i =20; i < 24; i++) {
            Assert.assertTrue(adminPage.popularMerchantsQuantity.get(i).isDisplayed());
        }

        //Check "Merhact name " link is active
        for (int i = 5; i <=9 ; i++) {
            adminPage.merchantName.get(i).click();
            String expectedUrlIcerik = "backoffice/vendor/edit/";
            String actualUrl = Driver.getDriver().getCurrentUrl();
            Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
            ReusableMethods.wait(1);
            Driver.getDriver().navigate().back();
            JSUtilities.scrollToBottom(Driver.getDriver());
            ReusableMethods.wait(1);
        }



        ReusableMethods.wait(1);

        //Check if images of popular merchants are visible.
        for (int i = 0; i <5; i++) {
            Assert.assertTrue(adminPage.popularMerchantsPictures.get(i).isDisplayed());
        }
        ReusableMethods.wait(1);

        //Click "Last 30 days sales" title
        adminPage.popularByReviewButton.click();

        //Check merchant names,merchant types,merchant rating, total number of reviews and number of merchant rating are visible.
        Assert.assertTrue(adminPage.popularMerchantsAndReviewTitle.isDisplayed());
        Assert.assertTrue(adminPage.popularMerchantsAndReviewTitle.getText().contains("Popular by review"));
        Assert.assertTrue(adminPage.popularMerchantsAndReviewTitle.getText().contains("most reviewed"));

        Assert.assertTrue(adminPage.popularByReviewTable.isDisplayed());

        //Check "Merchant name " link is active
        for (int i = 5; i <= 9; i++) {
            adminPage.merchantReviewPage.get(i).click();
            String expectedUrlIcerik = "backoffice/vendor/edit/";
            String actualUrl = Driver.getDriver().getCurrentUrl();
            Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
            ReusableMethods.wait(1);
            Driver.getDriver().navigate().back();
            JSUtilities.scrollToBottom(Driver.getDriver());
            ReusableMethods.wait(1);
        }

        //Closes the page
        Driver.quitDriver();
    }

    @Test
    public void TC_3609(){
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        adminPage.userNameButton.sendKeys(ConfigReader.getProperty("adminuser_hasan")+Keys.TAB+ConfigReader.getProperty("adminpassword_hasan"));
        adminPage.signInButton.click();

        //Check "Sales overview" graph
        Assert.assertTrue(adminPage.salesOverviewGraph.isDisplayed());

        Driver.quitDriver();

    }

    @Test
    public void TC_3610(){
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        adminPage.userNameButton.sendKeys(ConfigReader.getProperty("adminuser_hasan")+Keys.TAB+ConfigReader.getProperty("adminpassword_hasan"));
        adminPage.signInButton.click();

        Assert.assertTrue(adminPage.topCustomersText.isDisplayed());

        JSUtilities.scrollToElement(Driver.getDriver(),adminPage.topCustomersText);

        //Check if the image , customer name, date, time of registration
        for (int i = 1; i < 6; i++) {
            String dinamikXpath = "(//tbody)[5]//tr["  + i +  "]";
            WebElement istenenDataElementi = Driver.getDriver().findElement(By.xpath(dinamikXpath));
            Assert.assertTrue(istenenDataElementi.isDisplayed());
        }







    }

    @Test
    public void TC_3611(){
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        adminPage.userNameButton.sendKeys(ConfigReader.getProperty("adminuser_hasan")+Keys.TAB+ConfigReader.getProperty("adminpassword_hasan"));
        adminPage.signInButton.click();

        JSUtilities.scrollToElement(Driver.getDriver(),adminPage.topCustomersText);

        adminPage.firstCustomerButton.click();

        Assert.assertTrue(adminPage.customerIDText.isDisplayed());
        Assert.assertTrue(adminPage.customerIDText.getText().contains("Customer ID #"));


        for (int i = 0; i < 4; i++) {
            Assert.assertTrue(adminPage.customerPageAltBasliklar.get(i).isDisplayed());
        }

        Assert.assertTrue(adminPage.adminCustomerInfo.isDisplayed());
        Assert.assertTrue(adminPage.AddresesText.isDisplayed());
        Assert.assertTrue(adminPage.addressesBox.isDisplayed());

        for (int i = 0; i < adminPage.sortingTitles.size(); i++) {
            adminPage.sortingTitles.get(i).isDisplayed();
        }

        Assert.assertEquals(adminPage.sortingTitles.get(0).getText(),"Order ID");
        Assert.assertEquals(adminPage.sortingTitles.get(1).getText(),"Merchant");
        Assert.assertEquals(adminPage.sortingTitles.get(2).getText(),"Total");
        Assert.assertEquals(adminPage.sortingTitles.get(3).getText(),"Status");
        Assert.assertEquals(adminPage.sortingTitles.get(4).getText(),"Action");

        Assert.assertTrue(adminPage.eyeSignAdmin.isDisplayed());
        Assert.assertTrue(adminPage.eyeSignAdmin.isEnabled());

        Assert.assertTrue(adminPage.downloadButtonAdmin.isDisplayed());
        Assert.assertTrue(adminPage.downloadButtonAdmin.isEnabled());


        if(adminPage.firstPageOrderQuantity.size()>1){
            int firstOrderID = Integer.parseInt(adminPage.orderFirstID.getText());
            adminPage.sortingTitles.get(0).click();
            ReusableMethods.wait(2);
            int afterSortingFirstOrderID = Integer.parseInt(adminPage.orderFirstID.getText());
            Assert.assertNotEquals(firstOrderID,afterSortingFirstOrderID);
        }
        else{
            int firstOrderID = Integer.parseInt(adminPage.orderFirstID.getText());
            adminPage.sortingTitles.get(0).click();
            int afterSortingFirstOrderID = Integer.parseInt(adminPage.orderFirstID.getText());
            Assert.assertEquals(firstOrderID,afterSortingFirstOrderID);
        }

        Assert.assertTrue(adminPage.sortingTitles.get(1).isEnabled());
        Assert.assertTrue(adminPage.sortingTitles.get(2).isEnabled());
        Assert.assertTrue(adminPage.sortingTitles.get(3).isEnabled());
        Assert.assertTrue(adminPage.sortingTitles.get(4).isEnabled());

        Driver.quitDriver();

    }

    @Test
    public void TC_3612(){
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        adminPage.userNameButton.sendKeys(ConfigReader.getProperty("adminuser_hasan")+Keys.TAB+ConfigReader.getProperty("adminpassword_hasan"));
        adminPage.signInButton.click();

        JSUtilities.scrollToElement(Driver.getDriver(),adminPage.topCustomersText);

        adminPage.firstCustomerButton.click();

        Assert.assertTrue(adminPage.entriesInformation.isDisplayed());


        if (adminPage.pageNumbers.size()>3){
            String firstPageFirstOrderID = adminPage.firstPageOrderQuantity.get(0).getText();
            adminPage.pageNumbers.get(2).click();
            ReusableMethods.wait(1);
            String secondPageFirstOrderID =adminPage.firstPageOrderQuantity.get(0).getText();
            Assert.assertNotEquals(firstPageFirstOrderID,secondPageFirstOrderID);
        }
        else if (adminPage.pageNumbers.size()==3) {
            String firstPageFirstOrderID = adminPage.firstPageOrderQuantity.get(0).getText();
            adminPage.pageNumbers.get(2).click();
            ReusableMethods.wait(1);
            String secondPageFirstOrderID =adminPage.firstPageOrderQuantity.get(0).getText();
            Assert.assertEquals(firstPageFirstOrderID,secondPageFirstOrderID);
        }




    }

    @Test
    public void TC_3613(){
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        adminPage.userNameButton.sendKeys(ConfigReader.getProperty("adminuser_hasan")+Keys.TAB+ConfigReader.getProperty("adminpassword_hasan"));
        adminPage.signInButton.click();

        JSUtilities.scrollToElement(Driver.getDriver(),adminPage.topCustomersText);

        adminPage.firstCustomerButton.click();

        Assert.assertTrue(adminPage.searchText.isDisplayed());
        Assert.assertTrue(adminPage.searchBox.isDisplayed());

        ReusableMethods.wait(1);


        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(adminPage.searchBox).click().perform();
        ReusableMethods.wait(5);
        adminPage.searchBox.isEnabled();
        adminPage.searchBox.sendKeys("11990"+Keys.ENTER);

        ReusableMethods.wait(3);

        String expectedResult = "11990";
        String actualResult = adminPage.firstPageOrderQuantity.get(0).getText();

        Assert.assertEquals(actualResult,expectedResult);

        ReusableMethods.wait(5);

        Driver.quitDriver();



    }

}
