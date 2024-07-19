package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.MerchantPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class US_029 {

     AdminPage adminPage = new AdminPage();
    MerchantPage merchantPage = new MerchantPage();

    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void TC_2901() {

        adminPage = new AdminPage();
        ReusableMethods.accessAdmin("adminuser_cimen","adminpassword_cimen");

        adminPage.MerchantSide.click();

        adminPage.ListSide.click();

        adminPage.SearchSide.sendKeys("Havana"+ Keys.ENTER);

        adminPage.AutoLoginSide.click();

        ReusableMethods.windowaGec("https://qa.flavorfetch.com/backoffice/merchant/dashboard",Driver.getDriver());

        merchantPage.ordersLink.click();

        merchantPage.ordersCompletedLink.click();

        LocalDate currentDate = LocalDate.now();
      //  DateTimeFormatter tarihFormati=DateTimeFormatter.ofPattern("dd MMM yyyy");
        DateTimeFormatter tarihFormati=DateTimeFormatter.ofPattern("dd");  //Tr formatta ay ingilizce gelmiyor
        String tarihMuhru= currentDate.format(tarihFormati);
      //  System.out.println(tarihMuhru);

       Assert.assertTrue(merchantPage.orderHeaderText.getText().contains(tarihMuhru));

        int OrderView =merchantPage.orderProcessingList.size();

           if (OrderView==0){

                Assert.assertTrue(merchantPage.filterBox.isDisplayed());
                Assert.assertTrue(merchantPage.orderTypeDropdownMenu.isDisplayed());
                Assert.assertTrue(merchantPage.paymentStatusDropdownMenu.isDisplayed());
                Assert.assertTrue(merchantPage.sortDropdownMenu.isDisplayed());


           }else {
               Assert.assertTrue(merchantPage.orderId1.size()>0);
               Assert.assertTrue(merchantPage.customerName.isDisplayed());
               Assert.assertTrue(merchantPage.orderDatenTimeInOrderDetails.isDisplayed());
               Assert.assertTrue(merchantPage.deliveryType.isDisplayed());
               Assert.assertTrue(merchantPage.typeCompleted.isDisplayed());


           String OrderNum=merchantPage.orderNumberInOrderDetails.getText();
           OrderNum=OrderNum.replaceAll("\\D","");
       // System.out.println(OrderNum);

        merchantPage.orderPagefilterBox.sendKeys(OrderNum);

        Assert.assertTrue(merchantPage.leftOrderTable.isDisplayed());

        Actions actions = new Actions(Driver.getDriver());
        actions.click(merchantPage.orderPagefilterBox)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE).perform();

        ReusableMethods.waitFor(4);

        merchantPage.orderPagefilterBox.sendKeys(merchantPage.customerName.getText());

        Assert.assertTrue(merchantPage.leftOrderTable.isDisplayed());

        merchantPage.orderClearButton.click();

        ReusableMethods.waitFor(4);

        Assert.assertEquals(merchantPage.orderPagefilterBox.getAttribute("value"),"");

        //String b=merchantPage.orderPagefilterBox.getAttribute("value");

        merchantPage.orderTypeDropdownMenu.click();

        merchantPage.orderDeliveryTypeList.click();

        Assert.assertTrue(merchantPage.leftOrderTable.getText().contains("Delivery"));

      //  System.out.println(merchantPage.leftOrderTable.getText());

        merchantPage.paymentStatusDropdownMenu.click();

        merchantPage.orderPaidTypeList.click();

        Assert.assertTrue(merchantPage.leftOrderTable.isDisplayed());

        merchantPage.sortDropdownMenu.click();

         Driver.quitDriver();

           }
        Driver.quitDriver();
    }

    @Test
    public void TC_2902() {

        MerchantPage merchantPage = new MerchantPage();
        adminPage = new AdminPage();
        ReusableMethods.accessAdmin("adminuser_cimen","adminpassword_cimen");

        adminPage.MerchantSide.click();

        adminPage.ListSide.click();

        adminPage.SearchSide.sendKeys(" Havana"+ Keys.ENTER);

        adminPage.AutoLoginSide.click();

        ReusableMethods.windowaGec("https://qa.flavorfetch.com/backoffice/merchant/dashboard",Driver.getDriver());

        ReusableMethods.waitFor(3);

        merchantPage.ordersLink.click();

        merchantPage.ordersCompletedLink.click();

        int OrderView =merchantPage.orderProcessingList.size();

        if (OrderView>0){

       //     System.out.println(merchantPage.orderSummaryBody.getText());
       //     System.out.println(merchantPage.orderView.getText());

            Assert.assertTrue(merchantPage.orderSummaryBody.getText().contains(merchantPage.orderView.getText()));

            //Siparis ozetinde urunlerin isimlerinin goruntulendigini dogrular
            Assert.assertTrue(merchantPage.productNameOrderSummary.isDisplayed());
            //Urunlerin fiyatinin goruntulendigini dogrular
            Assert.assertTrue(merchantPage.productPriceOrderSummary.isDisplayed());
            //Siparis verilen toplam urun adedinin goruntulendigini dogrular
            Assert.assertTrue(merchantPage.subTotalQuantityOrderSummary.isDisplayed());
            //Toplam fiyatin goruntulendigini dogrular
            Assert.assertTrue(merchantPage.subTotalPriceOrderSummary.isDisplayed());

            //Siparis fisini yazdirmak icin print butonu bulundugunu dogrular
            Assert.assertTrue(merchantPage.printButton.isDisplayed());
            //Print butonunun erisilebilir oldugunu dogrular
            Assert.assertTrue(merchantPage.printButton.isEnabled());
            //"More options" veya tiklar
            merchantPage.moreOptionsDropdownButton.click();
            //Dropdown menude "Download PDF(A4)" oldugunu dogrular
            Assert.assertTrue(merchantPage.moreOptionsDropdownMenu.getText().contains("Download PDF (A4)"));
            //"Contact customer" oldugunu dogrular
            Assert.assertTrue(merchantPage.moreOptionsDropdownMenu.getText().contains("Contact customer"));
            Driver.quitDriver();

        }
        else {
            Driver.quitDriver();
        }



    }

    @Test
    public void TC_2903() {

        merchantPage = new MerchantPage();
        adminPage = new AdminPage();
        ReusableMethods.accessAdmin("adminuser_cimen","adminpassword_cimen");

        adminPage.MerchantSide.click();

        adminPage.ListSide.click();

        adminPage.SearchSide.sendKeys(" Havana"+ Keys.ENTER);

        adminPage.AutoLoginSide.click();

        ReusableMethods.windowaGec("https://qa.flavorfetch.com/backoffice/merchant/dashboard",Driver.getDriver());

        ReusableMethods.waitFor(3);

        merchantPage.ordersLink.click();

        merchantPage.ordersCompletedLink.click();

        int OrderView =merchantPage.orderProcessingList.size();


        if (OrderView>0) {

            for (int i = 0; i < merchantPage.orderProcessingList.size(); i++) {
                merchantPage.orderProcessingList.get(i).click();
                ReusableMethods.waitFor(5);

                if (Objects.equals(merchantPage.deliveryType2.get(i).getText(), "Delivery"))
                    Assert.assertTrue(merchantPage.checkOrderType.getText().contains("delivery"));


            }


            for (int i = 0; i < merchantPage.orderProcessingList.size(); i++) {
                //   for (int j = 0; j < customer.ar.size(); j++) {
                merchantPage.orderProcessingList.get(i).click();
                ReusableMethods.waitFor(2);
                if (Objects.equals(merchantPage.deliveryType2.get(i).getText(), "Dinein"))
                    Assert.assertTrue(merchantPage.checkOrderType.getText().contains("complete"));


            }


            for (int i = 0; i < merchantPage.orderProcessingList.size(); i++) {
                //   for (int j = 0; j < customer.ar.size(); j++) {
                merchantPage.orderProcessingList.get(i).click();
                ReusableMethods.waitFor(2);
                if (merchantPage.deliveryType2.get(i).getText() == "Pickup")
                    Assert.assertTrue(merchantPage.checkOrderType.getText().contains("complete"));


            }


        }


        Driver.quitDriver();
    }


    }

