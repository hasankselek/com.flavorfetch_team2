package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import utilities.Driver;
import utilities.JSUtilities;
import utilities.ReusableMethods;

public class US_036 {

    static AdminPage adminPage = new AdminPage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void TC_3601(){
        adminPage = new AdminPage();
        ReusableMethods.accessAdmin("adminuser_hasan","adminpassword_hasan");

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
        adminPage = new AdminPage();
        ReusableMethods.accessAdmin("adminuser_hasan","adminpassword_hasan");

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

        adminPage = new AdminPage();
        ReusableMethods.accessAdmin("adminuser_hasan","adminpassword_hasan");

        for (int i = 0; i < adminPage.dashboardTotalHeadings.size(); i++) {
            Assert.assertTrue(adminPage.dashboardTotalHeadings.get(i).isDisplayed());
        }

        Driver.quitDriver();

    }

    @Test
    public void TC_3604(){}

    @Test
    public void TC_3605(){}

    @Test
    public void TC_3606(){
        adminPage = new AdminPage();
        ReusableMethods.accessAdmin("adminuser_hasan","adminpassword_hasan");

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
        adminPage = new AdminPage();
        ReusableMethods.accessAdmin("adminuser_hasan","adminpassword_hasan");

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
        for (int i = 0; i < 5; i++) {
            Assert.assertTrue(adminPage.popularItemsInformation.get(i).isDisplayed());
        }

        ReusableMethods.wait(1);

        JSUtilities.scrollToElement(Driver.getDriver(),adminPage.Last30daysSalesButton);

        //Click "Last 30 days sales" title
        actions = new Actions(Driver.getDriver());
        actions.click(adminPage.Last30daysSalesButton).perform();

        ReusableMethods.wait(3);

        //Check that the sales chart appears and the products sold are listed
        Assert.assertTrue(adminPage.last30DaysSalesChartandProducts.isDisplayed());

        //Closes the page
        Driver.quitDriver();

    }

    @Test
    public void TC_3608(){

        adminPage = new AdminPage();
        ReusableMethods.accessAdmin("adminuser_hasan","adminpassword_hasan");

        //Check "Scroll down the page" and "most reviewed" titles are visible
        JSUtilities.scrollToBottom(Driver.getDriver());

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

        for (int i =20; i < 25; i++) {
            Assert.assertTrue(adminPage.popularMerchantsQuantity.get(i).isDisplayed());
        }

        for (int i = 0; i < 5; i++) {
            Assert.assertTrue(adminPage.merchantName.get(i).isEnabled());
        }

        ReusableMethods.wait(1);

        adminPage.popularByReviewButton.click();


        Assert.assertTrue(adminPage.popularMerchantsAndReviewTitle.isDisplayed());
        Assert.assertTrue(adminPage.popularMerchantsAndReviewTitle.getText().contains("Popular by review"));
        Assert.assertTrue(adminPage.popularMerchantsAndReviewTitle.getText().contains("most reviewed"));

        Assert.assertTrue(adminPage.popularByReviewTable.isDisplayed());

        for (int i = 0; i <= 4; i++) {
           Assert.assertTrue(adminPage.merchantName.get(i).isEnabled());
        }

        Driver.quitDriver();
    }

    @Test
    public void TC_3609(){
        adminPage = new AdminPage();
        ReusableMethods.accessAdmin("adminuser_hasan","adminpassword_hasan");

        //Check "Sales overview" graph
        Assert.assertTrue(adminPage.salesOverviewGraph.isDisplayed());

        Driver.quitDriver();

    }

    @Test
    public void TC_3610(){
        adminPage = new AdminPage();
        ReusableMethods.accessAdmin("adminuser_hasan","adminpassword_hasan");

        Assert.assertTrue(adminPage.topCustomersText.isDisplayed());

        JSUtilities.scrollToElement(Driver.getDriver(),adminPage.topCustomersText);

        for (int i = 1; i < 6; i++) {
            String dinamikXpath = "(//tbody)[5]//tr["  + i +  "]";
            WebElement istenenDataElementi = Driver.getDriver().findElement(By.xpath(dinamikXpath));
            Assert.assertTrue(istenenDataElementi.isDisplayed());
        }

        Driver.quitDriver();

    }

    @Test
    public void TC_3611(){
        adminPage = new AdminPage();
        ReusableMethods.accessAdmin("adminuser_hasan","adminpassword_hasan");

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
        actions = new Actions(Driver.getDriver());
        adminPage = new AdminPage();
        ReusableMethods.accessAdmin("adminuser_hasan","adminpassword_hasan");

        ReusableMethods.wait(3);

        actions.moveToElement(adminPage.firstCustomerButton).click().perform();

        Assert.assertTrue(adminPage.entriesInformation.isDisplayed());


        if (adminPage.customerPagePageNumbers.size()>3){
            String firstPageFirstOrderID = adminPage.firstPageOrderQuantity.get(0).getText();
            adminPage.customerPagePageNumbers.get(2).click();
            ReusableMethods.wait(5);
            String secondPageFirstOrderID =adminPage.firstPageOrderQuantity.get(0).getText();
            Assert.assertNotEquals(firstPageFirstOrderID,secondPageFirstOrderID);
        }
        else if (adminPage.customerPagePageNumbers.size()==3) {
            String firstPageFirstOrderID = adminPage.firstPageOrderQuantity.get(0).getText();
            adminPage.customerPagePageNumbers.get(2).click();
            ReusableMethods.wait(5);
            String secondPageFirstOrderID =adminPage.firstPageOrderQuantity.get(0).getText();
            Assert.assertEquals(firstPageFirstOrderID,secondPageFirstOrderID);
        }



        Driver.quitDriver();

    }

    @Test
    public void TC_3613(){
        actions = new Actions(Driver.getDriver());
        adminPage = new AdminPage();
        ReusableMethods.accessAdmin("adminuser_hasan","adminpassword_hasan");

        ReusableMethods.wait(3);

        actions.moveToElement(adminPage.firstCustomerButton).click().perform();

        Assert.assertTrue(adminPage.customerPageSearchText.isDisplayed());
        Assert.assertTrue(adminPage.customerPageSearchBox.isDisplayed());

        ReusableMethods.wait(1);


        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(adminPage.customerPageSearchBox).click().perform();

        ReusableMethods.wait(3);

        adminPage.customerPageSearchBox.isEnabled();
        adminPage.customerPageSearchBox.sendKeys("11990"+Keys.ENTER);

        ReusableMethods.wait(3);

        String expectedResult = "11990";
        String actualResult = adminPage.firstPageOrderQuantity.get(0).getText();

        Assert.assertEquals(actualResult,expectedResult);

        Driver.quitDriver();

        }

    @Test
    public void TC_3614(){
        actions = new Actions(Driver.getDriver());
        adminPage = new AdminPage();
        ReusableMethods.accessAdmin("adminuser_hasan","adminpassword_hasan");

        ReusableMethods.wait(1);

        actions.click(adminPage.firstCustomerButton).perform();
        ReusableMethods.wait(1);
        actions.click(adminPage.blockCustomerButton).perform();
        ReusableMethods.wait(1);
        actions.click(adminPage.alertConfirmButton).perform();


        ReusableMethods.wait(1);

        String expectedText = "Unblock Customer";
        String actualText = Driver.getDriver().findElement(By.xpath("//div[text()='Unblock Customer']")).getText();
        Assert.assertEquals(actualText,expectedText);

        ReusableMethods.wait(3);

        adminPage.unBlockCustomerButton.click();



        Driver.quitDriver();

    }

    @Test
    public void TC_3615(){
        actions = new Actions(Driver.getDriver());
        adminPage = new AdminPage();
        ReusableMethods.accessAdmin("adminuser_hasan","adminpassword_hasan");

        JSUtilities.scrollToElement(Driver.getDriver(),adminPage.recentPayoutTable);

        ReusableMethods.wait(2);

        Assert.assertTrue(adminPage.recentPayoutTable.isDisplayed());
        Assert.assertTrue(adminPage.recentPayoutTable.getText().contains("Recent payout"));

        String expectedIcerik = "No recent payout request";
        String actualIcerik = Driver.getDriver().findElement(By.xpath("//h6[text()='No recent payout request']")).getText();
        Assert.assertEquals(actualIcerik,expectedIcerik);

        Driver.quitDriver();

    }

    @Test
    public void TC_3616(){
        actions = new Actions(Driver.getDriver());
        adminPage = new AdminPage();
        ReusableMethods.accessAdmin("adminuser_hasan","adminpassword_hasan");

        JSUtilities.scrollToElement(Driver.getDriver(),adminPage.overviewOfReviewTable);
        Assert.assertTrue(adminPage.overviewOfReviewTable.isDisplayed());
        Assert.assertTrue(adminPage.overviewOfReviewTable.getText().contains("Overview of Review"));

        Assert.assertTrue(adminPage.checkoutAllReviewsButton.isDisplayed());
        Assert.assertTrue(adminPage.checkoutAllReviewsButton.isEnabled());

        ReusableMethods.wait(2);

        actions.click(adminPage.checkoutAllReviewsButton).perform();

        ReusableMethods.wait(2);

        String expectedTitle = "Reviews";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

        Driver.getDriver().navigate().back();

        Driver.quitDriver();


    }

    }


