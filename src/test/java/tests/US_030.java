package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MerchantPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_030 {

    //As a restaurant manager, I want future orders from my restaurant to be listed on the Scheduled page.

    MerchantPage merchantPage = new MerchantPage();

    @Test
    public void TC_3001() {
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
}


























