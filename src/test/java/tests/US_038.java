package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class US_038  extends  TestBaseRapor{

   static AdminPage adminPage =new AdminPage();
    @Test
    public  void  TC_3801(){
        adminPage=new AdminPage();
        ReusableMethods.accessAdmin("adminuser_kubra","adminpassword_kubra");
        adminPage.dasboardOrders.click();
        adminPage.dashboardAllOrders.click();
        adminPage.desktopImages.click();
        ReusableMethods.windowaGec("https://qa.flavorfetch.com/",Driver.getDriver());
        String expectedUrl=ConfigReader.getProperty("customer_Url");
        String actualUrl=Driver.getDriver().getCurrentUrl();
        System.out.println(actualUrl);
        Assert.assertEquals(actualUrl,expectedUrl);

        Driver.quitDriver();

    }
    @Test
    public  void TC_3802(){

        adminPage=new AdminPage();
        ReusableMethods.accessAdmin("adminuser_kubra","adminpassword_kubra");
        adminPage.dasboardOrders.click();
        adminPage.dashboardAllOrders.click();
        adminPage.filterButton.click();
        adminPage.filtersByCustomerBox.click();
        ReusableMethods.wait(2);

        adminPage.customerNameOption.click();
        adminPage.applyFiltersButton.click();

        ReusableMethods.wait(4);
        String firstCellValue=ConfigReader.getProperty("customerName_AllOrder");//

        for (WebElement cell: adminPage.elementsOfTheThirdColumn ) {
            Assert.assertEquals(cell.getText(),firstCellValue);
        }
        Driver.quitDriver();
    }
    @Test
    public  void TC_3803(){

        adminPage=new AdminPage();
        ReusableMethods.accessAdmin("adminuser_kubra","adminpassword_kubra");
        adminPage.dasboardOrders.click();
        adminPage.dashboardAllOrders.click();
        adminPage.filterButton.click();

        adminPage.filtersByStatusBox.click();
        adminPage.byStatusOption.click();
        adminPage.applyFiltersButton.click();
        ReusableMethods.wait(4);
        String expectedByStatusValue=ConfigReader.getProperty("ByStatus");//

        for (WebElement cell: adminPage.elementsOfTheSecondColumnByStatus ) {
            Assert.assertEquals(cell.getText(),expectedByStatusValue);
        }
        Driver.quitDriver();

    }
    @Test
    public void TC_3804(){

        adminPage=new AdminPage();
        ReusableMethods.accessAdmin("adminuser_kubra","adminpassword_kubra");
        adminPage.dasboardOrders.click();
        adminPage.dashboardAllOrders.click();
        adminPage.filterButton.click();
        adminPage.filtersByOrderTypeBox.click();
        adminPage.byOrderTypeOption.click();
        adminPage.applyFiltersButton.click();
        String expectedByOrderTypeValue=ConfigReader.getProperty("ByOrderType");
        for (WebElement cell: adminPage.elementsOfTheSecondColumnByStatus ) {
            Assert.assertEquals(cell.getText(),expectedByOrderTypeValue);
        }
        Driver.quitDriver();

    }
    @Test
    public void TC_3805(){


        try {
            extentTest=extentReports.createTest("TC_3805","Visibility and functionality test for the Filters button(By Merchant)");
            adminPage = new AdminPage();
            ReusableMethods.accessAdmin("adminuser_kubra", "adminpassword_kubra");
            adminPage.dasboardOrders.click();
            adminPage.dashboardAllOrders.click();
            extentTest.info("Admin all orders sayfasina gider");

            adminPage.filterButton.click();
            adminPage.filtersByMerchantBox.click();

            adminPage.nameBoxBelowByMerchant.sendKeys(ConfigReader.getProperty("ByMerchant"));
            extentTest.info("By merchant filtrelem kutusuna DolanUyghur Restaurant yazisini gonderirir");
            adminPage.byMerchantOption.click();
            adminPage.applyFiltersButton.click();
            extentTest.info("Filtreleme butonundan restaurant ismine gore filtreleme yapar");
            String expectedByOrderTypeValue = ConfigReader.getProperty("ByMerchant");
            for (WebElement cell : adminPage.elementsOfTheFourthColumnByMerchant) {
                Assert.assertEquals(cell.getText(), expectedByOrderTypeValue);
                extentTest.info("filtreleme sonucunda secilen magaza ismi ve filtrelenen magaza isminin ayni oldugu dogrulanir");
            }
        } finally {

            Driver.quitDriver();//Expected :Dolan Uyghur Restaurant
            //Actual   :Team3

        }



    }
    @Test
    public  void T_3806(){
        adminPage=new AdminPage();
        ReusableMethods.accessAdmin("adminuser_kubra","adminpassword_kubra");
        adminPage.dasboardOrders.click();
        adminPage.dashboardAllOrders.click();

        Assert.assertTrue(adminPage.ordersIcon.isDisplayed());
        String orderText=adminPage.ordersNumber.getText();
        int orderSayisi=Integer.parseInt(orderText);

        Assert.assertTrue(orderSayisi>=0);

        Assert.assertTrue(adminPage.cancelIcon.isDisplayed());
        String cancelText=adminPage.cancelNumber.getText();
        int cancelSayisi=Integer.parseInt(cancelText);

        Assert.assertTrue(cancelSayisi>=0);

        Assert.assertTrue(adminPage.totalRefundIcon.isDisplayed());
        String totalRefundText=adminPage.totalRefunQuantity.getText();

        boolean gecerliBirMiktarMi=totalRefundText.matches("^\\$\\d+\\.\\d{2}$");
        Assert.assertTrue(gecerliBirMiktarMi,ConfigReader.getProperty("ValidAmountMessage"));
        Assert.assertTrue(adminPage.totalOrdersIcon.isDisplayed());

        String totalOrdersText=adminPage.totalOrdersQuantity.getText();
        gecerliBirMiktarMi=totalOrdersText.matches("^\\$\\d+\\.\\d{2}$");
        Assert.assertTrue(gecerliBirMiktarMi,ConfigReader.getProperty("ValidAmountMessage"));

        Driver.quitDriver();


    }

    @Test
    public void TC_3807(){
        adminPage=new AdminPage();
        Actions actions =new Actions(Driver.getDriver());
        ReusableMethods.accessAdmin("adminuser_kubra","adminpassword_kubra");
        adminPage.dasboardOrders.click();
        adminPage.dashboardAllOrders.click();
        adminPage.dateFilterBox.click();
        actions.doubleClick(adminPage.selectedDate).perform();
        ReusableMethods.wait(2);
        Assert.assertTrue(adminPage.orderDateInfo.getText().contains("14"));

        Driver.quitDriver();


    }
    @Test
    public  void TC_3808(){
        adminPage=new AdminPage();
        ReusableMethods.accessAdmin("adminuser_kubra","adminpassword_kubra");
        adminPage.dasboardOrders.click();
        adminPage.dashboardAllOrders.click();
        ReusableMethods.wait(3);
        adminPage.orderIdIcon.click();
        ReusableMethods.wait(3);
        List<WebElement> orderIdSutunElementleriList=adminPage.orderIdColumn;
        List<Integer>orderIds=new ArrayList<>();
        for (WebElement each  :orderIdSutunElementleriList ) {
            orderIds.add(Integer.parseInt(each.getText()));

        }

        List<Integer> sortedOrderIds=new ArrayList<>(orderIds);
        Collections.sort(sortedOrderIds);
        Assert.assertEquals(orderIds,sortedOrderIds);
        Driver.quitDriver();

    }
    @Test
    public  void  TC_3809(){
        adminPage=new AdminPage();
        ReusableMethods.accessAdmin("adminuser_kubra","adminpassword_kubra");
        adminPage.dasboardOrders.click();
        adminPage.dashboardAllOrders.click();
       Assert.assertTrue(adminPage.paymentType.isDisplayed());
       Assert.assertTrue(adminPage.orderType.isDisplayed());
       Assert.assertTrue(adminPage.totalPrice.isDisplayed());
       Assert.assertTrue(adminPage.orderDateInfo.isDisplayed());
       Driver.quitDriver();

    }
    @Test
    public  void TC_3810(){
        adminPage=new AdminPage();
        ReusableMethods.accessAdmin("adminuser_kubra","adminpassword_kubra");
        adminPage.dasboardOrders.click();
        adminPage.dashboardAllOrders.click();
        adminPage.eyeSignUnderActions.click();
        ReusableMethods.windowaGec("https://qa.flavorfetch.com/backoffice/order/view?order_uuid=566827a1-4286-11ef-8af1-3a396e7b202d",Driver.getDriver());
        String expectedUrlIcerik="view";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        Assert.assertTrue(  adminPage.orderIdOrderDetailPage.isDisplayed());
        Assert.assertTrue(adminPage.restaurantNameOrderDetailPage.isDisplayed());
        Assert.assertTrue(adminPage.orderDateOrderDetailPage.isDisplayed());
        Assert.assertTrue(adminPage.paymentStatusOrderDetailPage.isDisplayed());
        Assert.assertTrue(adminPage.printButtonOrderDetailPage.isDisplayed());
        Assert.assertTrue(adminPage.printButtonOrderDetailPage.isEnabled());
        Driver.quitDriver();

    }
    @Test
    public  void TC_3811(){
        adminPage=new AdminPage();
        ReusableMethods.accessAdmin("adminuser_kubra","adminpassword_kubra");
        adminPage.dasboardOrders.click();
        adminPage.dashboardAllOrders.click();
        Assert.assertTrue(adminPage.downloadIcon.isDisplayed());
        Assert.assertTrue(adminPage.downloadIcon.isEnabled());
        Driver.quitDriver();

    }

}
