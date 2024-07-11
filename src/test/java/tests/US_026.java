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

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class US_026 {

    MerchantPage merchantPage = new MerchantPage();


    @Test
    public  void TC_2601(){


        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));

        merchantPage.usernametextbox.sendKeys(ConfigReader.getProperty("merchant_username"));
        merchantPage.passwordtextbox.sendKeys(ConfigReader.getProperty("merchant_password"));
        merchantPage.singinButton.click();
        merchantPage.dashboardOrdersIcon.click();
        merchantPage.dasboardNewOrdersIcon.click();
        String siparisAdediStr=merchantPage.ordersQuantitty.getText().replaceAll("\\D","");
        int siparisAdedi=Integer.parseInt(siparisAdediStr);


        if(siparisAdedi==0){
           Assert.assertTrue(merchantPage.noNewOrders.isDisplayed());

        }
        else{ merchantPage.newIcon.click();

            Assert.assertTrue(merchantPage.orderId1.size()>0);
            Assert.assertTrue(merchantPage.customerName.isDisplayed());
            Assert.assertTrue(merchantPage.orderDateAndTime.isDisplayed());
            Assert.assertTrue(merchantPage.totalOrderPrice.isDisplayed());}



        Driver.quitDriver();

    }
    @Test
    public  void  TC_2602(){
        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));

        merchantPage.usernametextbox.sendKeys(ConfigReader.getProperty("merchant_username"));
        merchantPage.passwordtextbox.sendKeys(ConfigReader.getProperty("merchant_password"));
        merchantPage.singinButton.click();
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


            List<WebElement> orderIdListIlkHali = merchantPage.orderId1;

            String reddedilecekOrder = orderIdListIlkHali.get(0).getText();

            merchantPage.rejectButton.click();
            ReusableMethods.wait(3);
            merchantPage.outOfItems.click();
            ReusableMethods.wait(2);
            merchantPage.pupupRejectButton.click();

            List<WebElement> orderIdListSonHali = merchantPage.orderId2;
            String kalanSiparisOrderId = orderIdListSonHali.get(0).getText();

            Assert.assertNotEquals(kalanSiparisOrderId, reddedilecekOrder);
        }
        Driver.quitDriver();


    }
    @Test
    public  void TC_2603(){
        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));

        merchantPage.usernametextbox.sendKeys(ConfigReader.getProperty("merchant_username"));
        merchantPage.passwordtextbox.sendKeys(ConfigReader.getProperty("merchant_password"));
        merchantPage.singinButton.click();
        merchantPage.dashboardOrdersIcon.click();
        merchantPage.dasboardNewOrdersIcon.click();
        String siparisAdediStr=merchantPage.ordersQuantitty.getText().replaceAll("\\D","");
        int siparisAdedi=Integer.parseInt(siparisAdediStr);


        if(siparisAdedi==0){
            Assert.assertTrue(merchantPage.noNewOrders.isDisplayed());
        }
        else {
        Assert.assertTrue(merchantPage.acceptingOrderButton.isDisplayed());

        merchantPage.acceptingOrderButton.click();


        merchantPage.pauseNewOrdersMinutes.click();
        merchantPage.nextButton.click();
        merchantPage.reasonForPausing.click();
        merchantPage.pausingConfirmButton.click();

        Assert.assertFalse(merchantPage.acceptingOrderButton.isEnabled());}
        Driver.quitDriver();

    }

    @Test
    public  void  TC_2604(){
        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));

        merchantPage.usernametextbox.sendKeys(ConfigReader.getProperty("merchant_username"));
        merchantPage.passwordtextbox.sendKeys(ConfigReader.getProperty("merchant_password"));
        merchantPage.singinButton.click();
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

        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));

        merchantPage.usernametextbox.sendKeys(ConfigReader.getProperty("merchant_username"));
        merchantPage.passwordtextbox.sendKeys(ConfigReader.getProperty("merchant_password"));
        merchantPage.singinButton.click();
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
        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
        merchantPage.usernametextbox.sendKeys(ConfigReader.getProperty("merchant_username"));
        merchantPage.passwordtextbox.sendKeys(ConfigReader.getProperty("merchant_password"));
        merchantPage.singinButton.click();
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
        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
        merchantPage.usernametextbox.sendKeys(ConfigReader.getProperty("merchant_username"));
        merchantPage.passwordtextbox.sendKeys(ConfigReader.getProperty("merchant_password"));
        merchantPage.singinButton.click();
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
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='notyf-announcer']")));

            String expectedCancelMesajYazisi="Order is cancelled";
            String actualCancelMesajYazisi=merchantPage.cancelOrderMessage.getText();

            Assert.assertEquals(actualCancelMesajYazisi,expectedCancelMesajYazisi);
        }

        Driver.quitDriver();
    }
    @Test
    public  void TC_2608(){
        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
        merchantPage.usernametextbox.sendKeys(ConfigReader.getProperty("merchant_username"));
        merchantPage.passwordtextbox.sendKeys(ConfigReader.getProperty("merchant_password"));
        merchantPage.singinButton.click();
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
        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
        merchantPage.usernametextbox.sendKeys(ConfigReader.getProperty("merchant_username"));
        merchantPage.passwordtextbox.sendKeys(ConfigReader.getProperty("merchant_password"));
        merchantPage.singinButton.click();
        merchantPage.dashboardOrdersIcon.click();
        merchantPage.dasboardNewOrdersIcon.click();String siparisAdediStr=merchantPage.ordersQuantitty.getText().replaceAll("\\D","");
        int siparisAdedi=Integer.parseInt(siparisAdediStr);

        if(siparisAdedi==0){
            Assert.assertTrue(merchantPage.noNewOrders.isDisplayed());
        }
        else {

          merchantPage.filterBox.click();
          merchantPage.filterBox.sendKeys(ConfigReader.getProperty("orderId"));
       // List<String>fitrelemeSocuElemetleri= ReusableMethods.stringListesineDonustur(merchantPage.filterResultElementleri);

       // System.out.println(fitrelemeSocuElemetleri);
       // List<String > sadeceRakamlarList=new ArrayList<>();

       // for (int i = 0; i <fitrelemeSocuElemetleri.size() ; i++) {
       //     String enSonElement=fitrelemeSocuElemetleri.get(i);
       //     String elementlerinRakamHali=enSonElement.replaceAll("\\s+"," ").replaceAll("\\s","5").replaceAll("\\D","").replaceAll("5"," ");

       //     sadeceRakamlarList.add(elementlerinRakamHali);

       // }


           //List<String>rakamlarListSonHali=new ArrayList<>();
           //for (String eachRakam  :sadeceRakamlarList ) {
           //   if (eachRakam.equals(ConfigReader.getProperty("orderID"))){
           //       rakamlarListSonHali.add(eachRakam);
           //   }

           //}
           //System.out.println(sadeceRakamlarList);
           //System.out.println(rakamlarListSonHali);

           // Assert.assertTrue(rakamlarListSonHali.contains("orderID"));

           String expectedOrderId=ConfigReader.getProperty("orderId");
            String actualOrderId=merchantPage.orderId1.get(0).getText().replaceAll("\\D","");

            Assert.assertEquals(actualOrderId,expectedOrderId);
            Assert.assertTrue(merchantPage.clearIcon.isDisplayed());

            }
        Driver.quitDriver();


        }


    }


