package tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_044 {

    // As admin, I should be able to access Merchant sales. I should be able to see it as a list, filter by date and sort by Order ID

    static AdminPage adminPage = new AdminPage();

    @Test
    public void TC_4401(){

        adminPage=new AdminPage();

        //kullanıcı browser açar
        //url girer
        ReusableMethods.accessToAdmin("adminuser_emine","adminpassword_emine");
        //admin olarak giriş yaptıktan sonra sola dashboad sekmesi altında orders sekmesi varlığı görüntüler
        Assert.assertTrue(adminPage.dasboardOrders.isDisplayed());
        //order sekmesi altında tüm siparişlere ulaşabileceğim all order sekmesi varlığı görüntüler
        adminPage.dasboardOrders.click();
        Assert.assertTrue(adminPage.dashboardAllOrders.isDisplayed());
        //all order sekmesine basıldığında tüm siparişlere liste olarak ulaşılabildiğini görüntüler
        adminPage.dashboardAllOrders.click();
        Assert.assertTrue(adminPage.allOrdersWebTable.isDisplayed());
        //sayfayı kapatır
        Driver.quitDriver();


    }  // Test the presence of dashboard and order tab under the dashboard where you can access sales as admin --> PASSED

    @Test
    public void TC_4402(){

        adminPage=new AdminPage();

        Actions actions = new Actions(Driver.getDriver());
        //kullanıcı browser açar
        //url girer
        ReusableMethods.accessToAdmin("adminuser_emine","adminpassword_emine");
        //All order sayfasında sipariş sayısına ve iptal edilen sipariş sayısına ulaşılabildiğini görüntüler
        adminPage.dasboardOrders.click();
        adminPage.dashboardAllOrders.click();
        Assert.assertTrue(adminPage.allOrdersHeaderSection.getText().contains("Orders")&& adminPage.allOrdersHeaderSection.getText().contains("Cancel"));
        //Verilen sipariş sayısı ve iptal edilen sipariş sayısında sipariş verildiği ya da iptal edildiğinde sayının değiştiğini görüntüler
        //İade edilen sipariş tutarı ve kazanılan sipariş tutarı görüntüler
        Assert.assertTrue(adminPage.allOrdersHeaderSection.getText().contains("Total refund")&& adminPage.allOrdersHeaderSection.getText().contains("Total Orders"));
        //Sipariş tutarları siparişlerde artış ya da eksilme  olduğu zaman değiştiği görüntüler
        //Tarih aralığı belirleme kutucu varlığı ve tarih aralığı seçildiğini görüntüler
        Assert.assertTrue(adminPage.dateFilterBox.isDisplayed() && adminPage.dateFilterBox.isEnabled());
        //tarih aralığı seçildiğinde veriln siparişlerden bu aralığa uygun olanların getirildiğini görüntüler
        adminPage.dateFilterBox.click();
        actions.doubleClick(adminPage.sampleDateData).perform(); // 13.07.2024
        ReusableMethods.wait(2);
        Assert.assertTrue(adminPage.orderDateInfo.getText().contains("13"));
        //tarih kutucuğunun yanında sarı filtre kutucuğu varlığını görüntüler
        Assert.assertTrue(adminPage.yellowFilterButton.isDisplayed());
        //sarı filtre kutusunun etkileşimli olduğunu görüntüler
        Assert.assertTrue(adminPage.yellowFilterButton.isEnabled());
        //Order information yazısı altında sipariş bilgilerine ulaşıldığını görüntüler
        Assert.assertTrue(adminPage.orderInfo.isDisplayed());
        //order information yazısı yanında order ıd yazısı varlığını görüntüler
        Assert.assertEquals(adminPage.orderIdFilter.getText(),"Order ID");
        //order ıd tuşuna basıldığında order ıd numarasına göre sıralandığını görüntüler
        adminPage.orderIdFilter.click();
        //sayfanın en alt sol tarafında hangi sayıda siparişlerin görüntülendiğini görüntüler
        actions.moveToElement(adminPage.showingEntryInfo).perform();
        Assert.assertTrue(adminPage.showingEntryInfo.isDisplayed());
        //sayfanın en alt sağ tarafnda sayfa numara kutucuğu  varlığını görüntüler
        Assert.assertTrue(adminPage.paginationBox.isDisplayed());
        //sayfa sekmesinde numaralara basıldığında numaraya basılan sayfaya gittiğini görüntüler
        String actualEntryText=adminPage.showingEntryInfo.getText();
        adminPage.samplePageNumber.click();
        ReusableMethods.wait(3);
        String expectedEntryText=adminPage.showingEntryInfo.getText();
        Assert.assertNotEquals(actualEntryText,expectedEntryText);
        //sayfayı kapatır
        Driver.quitDriver();

    }  // Test of displaying the given order as a list and sorting by order id


}
