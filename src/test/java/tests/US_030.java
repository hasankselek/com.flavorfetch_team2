package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MerchantPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_030 extends TestBaseRapor {

    //As a restaurant manager, I want future orders from my restaurant to be listed on the Scheduled page.

    static MerchantPage merchantPage = new MerchantPage();

    @Test
    public void TC_3001() {
        merchantPage = new MerchantPage();
        //Kullanici browseri acar
        //Url'I girer
        //Acilan sayfada username alanini doldurur
        //Password alanini doldurur
        //"Sign in" butonuna basarak giris yapar
        ReusableMethods.accessToMerchant();
        //Dashboard menusunden Orders'a tiklar
        merchantPage.ordersLink.click();
        //Orders alt menulerinden Scheduled'a tiklar
        merchantPage.scheduledLink.click();
        //Verilen siparislerin listelendigini dogrular
        Assert.assertTrue(merchantPage.scheduledOrdersList.size() > 0);
        //Siparis detaylarinda musteri isminin gorundugunu dogrular
        Assert.assertTrue(merchantPage.customerNameInOrderDetails.isDisplayed());
        //Siparis adetinin gorundugunu dogrular
        Assert.assertTrue(merchantPage.itemQuantitiyInOrderDetails.isDisplayed());
        //Siparis numarasinin gorundugunu dogrular
        Assert.assertTrue((merchantPage.orderNumberInOrderDetails.isDisplayed()));
        //Siparis tarih ve saatinin gorundugunu dogrular
        Assert.assertTrue(merchantPage.orderDatenTimeInOrderDetails.isDisplayed());
        //Siparisi order number veya customer name girerek ile filtreleme alaninin oldugun dogrular
        Assert.assertTrue(merchantPage.filterBox.isDisplayed());
        //"Order type" , "payment status" ve "sort'  secebilmek icin dropdown menuler oldugunu dogrular
        Assert.assertTrue(merchantPage.orderTypeDropdownMenu.isDisplayed());
        Assert.assertTrue(merchantPage.paymentStatusDropdownMenu.isDisplayed());
        Assert.assertTrue(merchantPage.sortDropdownMenu.isDisplayed());
        //Dasboard'a tiklar
        merchantPage.dashboardLink.click();
        //Hesaptan cikis yapar
        merchantPage.merchantNameDropdown.click();
        merchantPage.logoutMerchantDashboard.click();
        //Sayfayi kapatir
        Driver.getDriver().quit();
    }  // Test of display scheduled orders and order details in a list format and filter them -->PASSED


    @Test
    public void TC_3002() {
        merchantPage = new MerchantPage();
        extentTest = extentReports.createTest("TC_3002", "Test of scheduled orders page header section");
        //Kullanici browseri acar
        //Url'I girer
        //Acilan sayfada username alanini doldurur
        //Password alanini doldurur
        //"Sign in" butonuna basarak giris yapar
        ReusableMethods.accessToMerchant();
        extentTest.info("Kullanici browseri acar , url'i girer ve dogru bilgileri yazarak merchant dashboard'a giris yapar");
        //Dashboard menusunden Orders'a tiklar
        merchantPage.ordersLink.click();
        extentTest.info("Dashboard menusunden Orders'a tiklar");
        //Orders alt menulerinden Scheduled'a tiklar
        merchantPage.scheduledLink.click();
        extentTest.info("Orders alt menulerinden Scheduled'a tiklar");
        //Baslik kisminda "Orders scheduled as of today ... " yazdigini dogrular
        Assert.assertTrue(merchantPage.scheduledOrdersLeftHeader.getText().contains("Orders scheduled as of today"));
        extentTest.pass("Baslik kisminda \"Orders scheduled as of today ... \" yazdigini dogrular");
        //"How to manage orders" bilgilendirme sayfasi oldugunu dogrular
        merchantPage.howToManageOrdersLink.click();
        String expectedUrl = "https://qa.flavorfetch.com/backoffice/orders/scheduled/howtomanageorders/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
        extentTest.pass("\"How to manage orders\" bilgilendirme sayfasi oldugunu dogrular");
        //"Accepting Orders" butonunun calistigini dogrular
        Assert.assertTrue(merchantPage.acceptingOrdersButton.isEnabled());
        extentTest.pass("\"Accepting Orders\" butonunun calistigini dogrular");
        //Bildirim butonu gorundugunu  dogrular
        Assert.assertTrue(merchantPage.notificationsButton.isDisplayed());
        extentTest.pass("Bildirim butonu gorundugunu  dogrular");
        //Dasboard'a tiklar
        merchantPage.dashboardLink.click();
        extentTest.info("Dasboard'a tiklar");
        //Hesaptan cikis yapar
        merchantPage.merchantNameDropdown.click();
        merchantPage.logoutMerchantDashboard.click();
        extentTest.info("Hesaptan cikis yapar");
        //Sayfayi kapatir
        Driver.getDriver().quit();
        extentTest.info("Sayfayi kapatir");


    } // Test of scheduled orders page header section --> FAILED

    @Test
    public void TC_3003() {
        merchantPage = new MerchantPage();
        extentTest = extentReports.createTest("TC_3003", "Test of the accept order function");
        //Kullanici browseri acar
        //Url'I girer
        //Acilan sayfada username alanini doldurur
        //Password alanini doldurur
        //"Sign in" butonuna basarak giris yapar
        ReusableMethods.accessToMerchant();
        extentTest.info("Kullanici browseri acar , url'i girer ve dogru bilgileri yazarak merchant dashboard'a giris yapar");
        //Dashboard menusunden Orders'a tiklar
        merchantPage.ordersLink.click();
        extentTest.info("Dashboard menusunden Orders'a tiklar");
        //Orders alt menulerinden Scheduled'a tiklar
        merchantPage.scheduledLink.click();
        extentTest.info("Orders alt menulerinden Scheduled'a tiklar");
        //Verilen siparise tiklar
        merchantPage.scheduledOrdersList.get(1).click();
        extentTest.info("Verilen siparise tiklar");
        ReusableMethods.wait(3);
        //"Accept" butonu oldugunu dogrular
        String expectedButtonText = "Accept";
        String actualButtonText = merchantPage.acceptedButton.getText();
        Assert.assertEquals(actualButtonText, expectedButtonText);
        extentTest.pass("\"Accept\" butonu oldugunu dogrular");
        //Accept butonun erisilebilir oldugunu dogrular
        Assert.assertTrue(merchantPage.acceptedButton.isEnabled());
        extentTest.pass("Accept butonun erisilebilir oldugunu dogrular");
        //Accept butonuna basar ve accepted edildigini dogrular
        merchantPage.acceptedButton.click();
        ReusableMethods.wait(2);
        Assert.assertEquals(merchantPage.orderStatus.getText(), "accepted");
        extentTest.pass("Accept butonuna basar ve accepted edildigini dogrular");
        //Dasboard'a tiklar
        merchantPage.dashboardLink.click();
        extentTest.info("Dasboard'a tiklar");
        //Hesaptan cikis yapar
        merchantPage.merchantNameDropdown.click();
        merchantPage.logoutMerchantDashboard.click();
        extentTest.info("Hesaptan cikis yapar");
        //Sayfayi kapatr
        Driver.getDriver().quit();
        extentTest.info("Sayfayi kapatir");

    } // Test of the accept order function --> FAILED

    @Test
    public void TC_3004() {

        //Kullanici browseri acar
        //Url'I girer
        //Acilan sayfada username alanini doldurur
        //Password alanini doldurur
        //"Sign in" butonuna basarak giris yapar
        ReusableMethods.accessToMerchant();
        //Dashboard menusunden Orders'a tiklar
        merchantPage.ordersLink.click();
        //Orders alt menulerinden Scheduled'a tiklar
        merchantPage.scheduledLink.click();
        //Verilen siparise tiklar
        merchantPage.scheduledOrdersList.get(2).click();
        //Reject butonunun oldugunu dogrular
        String expectedButtonText = "Reject";
        String actualButtonText = merchantPage.rejectButton.getText();
        Assert.assertEquals(actualButtonText, expectedButtonText);
        //Reject butonun erisilebilir oldugunu dogrular
        Assert.assertTrue(merchantPage.rejectButton.isEnabled());
        //Reject butonuna basar
        ReusableMethods.wait(2);
        merchantPage.rejectButton.click();
        //Gerekcenin yazilabilecegi box'in oldugunu dogrular
        Assert.assertTrue(merchantPage.rejectReasonTextBox.isEnabled());
        //Secebilmek icin bir listenin gorundugunu dogrular
        Assert.assertTrue(merchantPage.rejectReasonPickArea.isDisplayed());
        //Seceneklerden birini secer
        merchantPage.rejectReason.click();
        //Reject order butonuna basar
        merchantPage.rejectOrderButton.click();
        //Dasboard'a tiklar
        merchantPage.dashboardLink.click();
        //Hesaptan cikis yapar
        merchantPage.merchantNameDropdown.click();
        merchantPage.logoutMerchantDashboard.click();
        //Sayfayi kapatir
        Driver.getDriver().quit();


    } // Test of the reject order function --> PASSED

    @Test
    public void TC_3005() {
        //Kullanici browseri acar
        //Url'I girer
        //Acilan sayfada username alanini doldurur
        //Password alanini doldurur
        //"Sign in" butonuna basarak giris yapar
        ReusableMethods.accessToMerchant();
        //Dashboard menusunden Orders'a tiklar
        merchantPage.ordersLink.click();
        //Orders alt menulerinden Scheduled'a tiklar
        merchantPage.scheduledLink.click();
        //Verilen siparise tiklar
        merchantPage.scheduledOrdersList.get(1).click();
        //Siparis ozetinde urunlerin isimlerinin goruntulendigini dogrular
        Assert.assertTrue(merchantPage.productNameOrderSummary.isDisplayed());
        //Urunlerin fiyatinin goruntulendigini dogrular
        Assert.assertTrue(merchantPage.productPriceOrderSummary.isDisplayed());
        //Siparis verilen toplam urun adedinin goruntulendigini dogrular
        Assert.assertTrue(merchantPage.subTotalQuantityOrderSummary.isDisplayed());
        //Toplam fiyatin goruntulendigini dogrular
        Assert.assertTrue(merchantPage.subTotalPriceOrderSummary.isDisplayed());
        //Dasboard'a tiklar
        merchantPage.dashboardLink.click();
        //Hesaptan cikis yapar
        merchantPage.merchantNameDropdown.click();
        merchantPage.logoutMerchantDashboard.click();
        //Sayfayi kapatir
        Driver.getDriver().quit();


    } // Test of order summary to include the names, prices, ,total quantity and total price of the ordered items --> PASSED

    @Test
    public void TC_3006() {

        //Kullanici browseri acar
        //Url'I girer
        //Acilan sayfada username alanini doldurur
        //Password alanini doldurur
        //"Sign in" butonuna basarak giris yapar
        ReusableMethods.accessToMerchant();
        //Dashboard menusunden Orders'a tiklar
        merchantPage.ordersLink.click();
        //Orders alt menulerinden Scheduled'a tiklar
        merchantPage.scheduledLink.click();
        //Verilen siparise tiklar
        merchantPage.scheduledOrdersList.get(2).click();
        //Siparis fisini yazdirmak icin print butonu bulundugunu dogrular
        Assert.assertTrue(merchantPage.printButton.isDisplayed());
        //Print butonunun erisilebilir oldugunu dogrular
        Assert.assertTrue(merchantPage.printButton.isEnabled());
        //"More options" veya "..." ibaresine tiklar
        merchantPage.moreOptionsDropdownButton.click();
        //Dropdown menude "Download PDF(A4)" oldugunu dogrular
        Assert.assertTrue(merchantPage.moreOptionsDropdownMenu.getText().contains("Download PDF (A4)"));
        //"Contact customer" oldugunu dogrular
        Assert.assertTrue(merchantPage.moreOptionsDropdownMenu.getText().contains("Contact customer"));
        //Dasboard'a tiklar
        merchantPage.dashboardLink.click();
        //Hesaptan cikis yapar
        merchantPage.merchantNameDropdown.click();
        merchantPage.logoutMerchantDashboard.click();
        //Sayfayi kapatir
        Driver.getDriver().quit();


    } // Test of being able to print the order slip or download as a pdf format and able to contact option with customer --> PASSED

}


























