package tests;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MerchantPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class US_026 extends TestBaseRapor {

   static MerchantPage merchantPage = new MerchantPage();


    @Test
    public  void TC_2601(){
        merchantPage=new MerchantPage();
        ReusableMethods.accessToMerchant();
        merchantPage.dashboardOrdersIcon.click();
        merchantPage.dasboardNewOrdersIcon.click();
        String siparisAdediStr=merchantPage.ordersQuantitty.getText().replaceAll("\\D","");
        int siparisAdedi=Integer.parseInt(siparisAdediStr);


        if(siparisAdedi==0){
           Assert.assertTrue(merchantPage.noNewOrders.isDisplayed());

        }
        else{ merchantPage.newIcon.click();

            Assert.assertTrue(merchantPage.newOrdersList.size()>0);

           // Assert.assertTrue(merchantPage.orderId1.size()>0);
            Assert.assertTrue(merchantPage.customerName.isDisplayed());
            Assert.assertTrue(merchantPage.orderDateAndTime.isDisplayed());
            Assert.assertTrue(merchantPage.totalOrderPrice.isDisplayed());
        }

        Driver.quitDriver();

    }
    @Test
    public  void  TC_2602(){
        merchantPage=new MerchantPage();
        ReusableMethods.accessToMerchant();
        merchantPage.dashboardOrdersIcon.click();
        merchantPage.dasboardNewOrdersIcon.click();
        String siparisAdediStr=merchantPage.ordersQuantitty.getText().replaceAll("\\D","");
        int siparisAdedi=Integer.parseInt(siparisAdediStr);

        if(siparisAdedi==0){
            Assert.assertTrue(merchantPage.noNewOrders.isDisplayed());
        }
        else {
            merchantPage.newIcon.click();

            Assert.assertTrue(merchantPage.acceptedButton.isDisplayed() && merchantPage.acceptedButton.isEnabled());
            Assert.assertTrue(merchantPage.rejectButton.isDisplayed() && merchantPage.rejectButton.isEnabled());


            String expectedOrderId = merchantPage.newOrdersList.get(0).getText().replaceAll("\\D", "").replaceFirst("^.", "");
            System.out.println(expectedOrderId);

            merchantPage.rejectButton.click();
            ReusableMethods.wait(3);
            merchantPage.outOfItems.click();
            ReusableMethods.wait(2);
            merchantPage.pupupRejectButton.click();
            ReusableMethods.wait(2);
            List<String> newOrdersListSonHal = ReusableMethods.stringListesineDonustur(merchantPage.newOrdersList);
            Assert.assertFalse(newOrdersListSonHal.contains(expectedOrderId));

    }

        Driver.quitDriver();
    }
    @Test
    public  void TC_2603(){
        extentTest=extentReports.createTest("TC_2603","Testing the visibility and functionality of the 'Accepting Orders' button");
        ReusableMethods.accessToMerchant();
        merchantPage.dashboardOrdersIcon.click();
        merchantPage.dasboardNewOrdersIcon.click();
        extentTest.info("Merchant sayfasından new orders sayfasina ulasir");
        String siparisAdediStr=merchantPage.ordersQuantitty.getText().replaceAll("\\D","");
        int siparisAdedi=Integer.parseInt(siparisAdediStr);


        if(siparisAdedi==0){
            Assert.assertTrue(merchantPage.noNewOrders.isDisplayed());
            extentTest.info("sayfada siparis var mi test eder");
        }
        else {
        Assert.assertTrue(merchantPage.acceptingOrderButton.isDisplayed());
        extentTest.info("aceppting orders butonu gorunurlugu dogrulanir");

        merchantPage.acceptingOrderButton.click();


        merchantPage.pauseNewOrdersMinutes.click();
        merchantPage.nextButton.click();
        merchantPage.reasonForPausing.click();
        merchantPage.pausingConfirmButton.click();
        extentTest.info("Siparis duraklatma sebebi secilir.");

        Assert.assertFalse(merchantPage.acceptingOrderButton.isEnabled());
        extentTest.pass("siparisin duraklatildigi dogrulanir");
        }
        Driver.quitDriver();
        extentTest.info("Sayfayi kapatir");

    }

    @Test
    public  void  TC_2604(){
        ReusableMethods.accessToMerchant();
        merchantPage.dashboardOrdersIcon.click();
        merchantPage.dasboardNewOrdersIcon.click();

        String siparisAdediStr=merchantPage.ordersQuantitty.getText().replaceAll("\\D","");
        int siparisAdedi=Integer.parseInt(siparisAdediStr);

        if(siparisAdedi==0){
            Assert.assertTrue(merchantPage.noNewOrders.isDisplayed());
        }
        else {
        merchantPage.addButton.click();
        merchantPage.productTobBeAdded.click();
        ReusableMethods.wait(3);
        merchantPage.addToOrderButton.click();

        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Item added to order']")));

        String expectedMessage="Item added to order";
        String actualMessage=merchantPage.itemAddedToOrderMessage.getText();

        Assert.assertEquals(actualMessage,expectedMessage);}
        Driver.quitDriver();

    }
    @Test
    public  void TC_2605(){

        ReusableMethods.accessToMerchant();
        merchantPage.dashboardOrdersIcon.click();
        merchantPage.dasboardNewOrdersIcon.click();
        String siparisAdediStr=merchantPage.ordersQuantitty.getText().replaceAll("\\D","");
        int siparisAdedi=Integer.parseInt(siparisAdediStr);

        if(siparisAdedi==0){
            Assert.assertTrue(merchantPage.noNewOrders.isDisplayed());
        }
        else {

        merchantPage.ellipsisIcon.click();
        merchantPage.contactCustomer.click();
        Assert.assertTrue(merchantPage.customerNumber.isDisplayed());}

        Driver.quitDriver();

    }
    @Test
    public  void TC_2606(){
        ReusableMethods.accessToMerchant();
        merchantPage.dashboardOrdersIcon.click();
        merchantPage.dasboardNewOrdersIcon.click();
        String siparisAdediStr=merchantPage.ordersQuantitty.getText().replaceAll("\\D","");
        int siparisAdedi=Integer.parseInt(siparisAdediStr);

        if(siparisAdedi==0){
            Assert.assertTrue(merchantPage.noNewOrders.isDisplayed());
        }
        else {
        merchantPage.ellipsisIcon.click();
        merchantPage.delayOrder.click();
        ReusableMethods.wait(3);
        merchantPage.pauseMinuteOptionDelay.click();
        ReusableMethods.wait(3);
        merchantPage.confirmButtonDelay.click();

        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-live='polite']")));


        String expectedMesajYazisi="Customer is notified about the delayed.";
        String actualMesajYazisi=merchantPage.delayOrderMesssage.getText();

        Assert.assertEquals(actualMesajYazisi,expectedMesajYazisi);}
        Driver.quitDriver();


    }
    @Test
    public  void  TC_2607(){
        ReusableMethods.accessToMerchant();
        merchantPage.dashboardOrdersIcon.click();
        merchantPage.dasboardNewOrdersIcon.click();String siparisAdediStr=merchantPage.ordersQuantitty.getText().replaceAll("\\D","");
        int siparisAdedi=Integer.parseInt(siparisAdediStr);

        if(siparisAdedi==0){
            Assert.assertTrue(merchantPage.noNewOrders.isDisplayed());
        }
        else {

        merchantPage.ellipsisIcon.click();
        merchantPage.cancelOrder.click();
        merchantPage.reasonCancel.click();
        merchantPage.cancelRejectOrderButton.click();
            WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Order is cancelled']")));

            String expectedCancelMesajYazisi="Order is cancelled";
            String actualCancelMesajYazisi=merchantPage.cancelOrderMessage.getText();

            Assert.assertEquals(actualCancelMesajYazisi,expectedCancelMesajYazisi);
        }

        Driver.quitDriver();
    }
    @Test
    public  void TC_2608(){
        ReusableMethods.accessToMerchant();
        merchantPage.dashboardOrdersIcon.click();
        merchantPage.dasboardNewOrdersIcon.click();String siparisAdediStr=merchantPage.ordersQuantitty.getText().replaceAll("\\D","");
        int siparisAdedi=Integer.parseInt(siparisAdediStr);

        if(siparisAdedi==0){
            Assert.assertTrue(merchantPage.noNewOrders.isDisplayed());
        }
        else {

            merchantPage.ellipsisIcon.click();
            Assert.assertTrue(merchantPage.downloadPdf.isDisplayed());
            Assert.assertTrue(merchantPage.downloadPdf.isEnabled());
        }

        Driver.quitDriver();

    }
    @Test
    public  void TC_2609(){
        ReusableMethods.accessToMerchant();
        merchantPage.dashboardOrdersIcon.click();
        merchantPage.dasboardNewOrdersIcon.click();String siparisAdediStr=merchantPage.ordersQuantitty.getText().replaceAll("\\D","");
        int siparisAdedi=Integer.parseInt(siparisAdediStr);

        if(siparisAdedi==0){
            Assert.assertTrue(merchantPage.noNewOrders.isDisplayed());
        }
        else {

          merchantPage.filterBox.click();
          merchantPage.filterBox.sendKeys(ConfigReader.getProperty("orderId"));

                String expectedOrderId = ConfigReader.getProperty("orderId");
                System.out.println(expectedOrderId);

                ReusableMethods.wait(2);
                if (merchantPage.orderId1.isEmpty()){
                    Assert.assertTrue(merchantPage.noResultText.isDisplayed());
                }else {

                String actualOrderId = merchantPage.orderId1.get(0).getText().replaceAll("\\D", "");
                System.out.println(actualOrderId);

                System.out.println(actualOrderId);
                Assert.assertEquals(actualOrderId, expectedOrderId);
                Assert.assertTrue(merchantPage.clearIcon.isDisplayed());
            }}

        Driver.quitDriver();


        }
        @Test
    public  void TC_2610(){
            ReusableMethods.accessToMerchant();
            merchantPage.dashboardOrdersIcon.click();
            merchantPage.dasboardNewOrdersIcon.click();String siparisAdediStr=merchantPage.ordersQuantitty.getText().replaceAll("\\D","");
            int siparisAdedi=Integer.parseInt(siparisAdediStr);

            if(siparisAdedi==0){
                Assert.assertTrue(merchantPage.noNewOrders.isDisplayed());
            }
            else {

                Assert.assertTrue(merchantPage.filterBox.isDisplayed());
                Assert.assertTrue(merchantPage.orderTypeDropdownMenu.isDisplayed());
                Assert.assertTrue(merchantPage.paymentStatusDropdownMenu.isDisplayed());
                Assert.assertTrue(merchantPage.sortDropdownMenu.isDisplayed());


        }

            Driver.quitDriver();

    }

}


