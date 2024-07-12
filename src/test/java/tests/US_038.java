package tests;

import com.mongodb.client.model.geojson.LineString;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class US_038 {

    AdminPage adminPage =new AdminPage();
    @Test
    public  void  TC_3801(){
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));

        adminPage.userNameButton.sendKeys(ConfigReader.getProperty("adminuser_kubra")+ Keys.TAB+ConfigReader.getProperty("adminpassword_kubra"));
        adminPage.signInButton.click();
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

        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));

        adminPage.userNameButton.sendKeys(ConfigReader.getProperty("adminuser_kubra")+ Keys.TAB+ConfigReader.getProperty("adminpassword_kubra"));
        adminPage.signInButton.click();
        adminPage.dasboardOrders.click();
        adminPage.dashboardAllOrders.click();
        adminPage.filterButton.click();
        adminPage.filtersByCustomerBox.click();
        ReusableMethods.wait(2);
       // adminPage.boxUnderCustomer.sendKeys(ConfigReader.getProperty("customerName_AllOrder"));

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

        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));

        adminPage.userNameButton.sendKeys(ConfigReader.getProperty("adminuser_kubra")+ Keys.TAB+ConfigReader.getProperty("adminpassword_kubra"));
        adminPage.signInButton.click();
        adminPage.dasboardOrders.click();
        adminPage.dashboardAllOrders.click();
        adminPage.filterButton.click();
        adminPage.filtersByCustomerBox.click();
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

        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));

        adminPage.userNameButton.sendKeys(ConfigReader.getProperty("adminuser_kubra")+ Keys.TAB+ConfigReader.getProperty("adminpassword_kubra"));
        adminPage.signInButton.click();
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
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));

        adminPage.userNameButton.sendKeys(ConfigReader.getProperty("adminuser_kubra")+ Keys.TAB+ConfigReader.getProperty("adminpassword_kubra"));
        adminPage.signInButton.click();
        adminPage.dasboardOrders.click();
        adminPage.dashboardAllOrders.click();
        adminPage.filterButton.click();
        adminPage.filtersByMerchantBox.click();
        adminPage.nameBoxBelowByMerchant.sendKeys(ConfigReader.getProperty("ByMerchant"));
        adminPage.byMerchantOption.click();
        adminPage.applyFiltersButton.click();
        String expectedByOrderTypeValue=ConfigReader.getProperty("ByMerchant");
        for (WebElement cell: adminPage.elementsOfTheFourthColumnByMerchant ) {
            Assert.assertEquals(cell.getText(),expectedByOrderTypeValue);
        }
        Driver.quitDriver();//Expected :Dolan Uyghur Restaurant
                            //Actual   :Team3

    }
    @Test
    public  void T_3806(){
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));

        adminPage.userNameButton.sendKeys(ConfigReader.getProperty("adminuser_kubra")+ Keys.TAB+ConfigReader.getProperty("adminpassword_kubra"));
        adminPage.signInButton.click();
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
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));

        adminPage.userNameButton.sendKeys(ConfigReader.getProperty("adminuser_kubra")+ Keys.TAB+ConfigReader.getProperty("adminpassword_kubra"));
        adminPage.signInButton.click();
        adminPage.dasboardOrders.click();
        adminPage.dashboardAllOrders.click();
        adminPage.dateRangeBox.click();
        adminPage.dateRangeBoxBackIcon.click();
        ReusableMethods.wait(4);
        adminPage.startDateOption.click();
        ReusableMethods.wait(4);
        adminPage.endDateOption.click();
       // String dateText=adminPage.dateRangeResult.get(0).getText();
        //dateText=dateText.replace("Place on","");

        String startDate="2024-01-01";
        String endDate="2024-12-31";
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd MMM yyy h:mm a");
        LocalDateTime start = LocalDateTime.parse(startDate + " 00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        LocalDateTime end = LocalDateTime.parse(endDate + " 23:59", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        for (WebElement dateElement  :adminPage.dateRangeResult ) {
            String dateText= dateElement.getText().replace("Place on","").trim();
            System.out.println(dateText);

            LocalDateTime siparisTarihi=LocalDateTime.parse(dateText,formatter);


            Assert.assertTrue((siparisTarihi.isEqual(start) || siparisTarihi.isAfter(start)) &&
                    (siparisTarihi.isEqual(end) || siparisTarihi.isBefore(end)));

        }


    }
    @Test
    public  void TC_3808(){
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));

        adminPage.userNameButton.sendKeys(ConfigReader.getProperty("adminuser_kubra")+ Keys.TAB+ConfigReader.getProperty("adminpassword_kubra"));
        adminPage.signInButton.click();
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

}
