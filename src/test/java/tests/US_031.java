package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MerchantPage;
import utilities.Driver;
import utilities.JSUtilities;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class US_031 {

    MerchantPage merchantPage = new MerchantPage();

    @Test
    public void TC_3101() //Access To All Orders Page Test
    {
        merchantPage = new MerchantPage();
        accessToAllOrders();

        Driver.quitDriver();

    }

    @Test
    public void TC_3102() //All Orders ID Test
    {
        merchantPage = new MerchantPage();
        accessToAllOrders();

        List<String> allOrdesIdStringList = ReusableMethods.stringListesineDonustur(merchantPage.allOrdersIdList);
        List<Integer> allOrdesIdIntegerList = new ArrayList<>();

        ReusableMethods.stringListToIntegerList(allOrdesIdStringList, allOrdesIdIntegerList);

        for (int i = 0; i < allOrdesIdIntegerList.size() - 1; i++) {
            Assert.assertTrue(allOrdesIdIntegerList.get(i) > allOrdesIdIntegerList.get(i + 1));
        }
        ReusableMethods.wait(1);

        Driver.quitDriver();

    }

    @Test
    public void TC_3103() //View Button Test
    {
        merchantPage = new MerchantPage();
        accessToAllOrders();

        List<String> allOrdesIdStringList = ReusableMethods.stringListesineDonustur(merchantPage.allOrdersIdList);

        Assert.assertTrue(merchantPage.allOrdersPageFirstViewButton.isDisplayed());
        Assert.assertTrue(merchantPage.allOrdersPageFirstViewButton.isEnabled());
        merchantPage.allOrdersPageFirstViewButton.click();
        ReusableMethods.wait(1);

        List<String> allWindows = new ArrayList<>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(allWindows.get(1));

        String orderDetailsPageOrderId = Driver.getDriver().findElement(By.xpath("(//h5[@class='m-0'])[1]")).getText().replaceAll("\\D", "");
        Assert.assertEquals(orderDetailsPageOrderId, allOrdesIdStringList.get(0));

        Driver.quitDriver();

    }

    @Test
    public void TC_3104() //Download Button Test
    {
        merchantPage = new MerchantPage();
        accessToAllOrders();

        Assert.assertTrue(merchantPage.allOrdersPageFirstDownloadButton.isDisplayed());
        Assert.assertTrue(merchantPage.allOrdersPageFirstDownloadButton.isEnabled());
        merchantPage.allOrdersPageFirstDownloadButton.click();
        ReusableMethods.wait(1);

        Driver.quitDriver();

    }

    @Test
    public void TC_3105() //Date Test
    {
        merchantPage = new MerchantPage();
        accessToAllOrders();
        Actions actions = new Actions(Driver.getDriver());
        actions.click(merchantPage.allOrdersPageDateBanner).perform();

        ReusableMethods.searchDateBeginFinish("11", "Apr", "2023", "10", "Jun", "2024");


        Driver.quitDriver();

    }

    @Test
    public void TC_3106() //Orders Information Tags Test (ORDERS/CANCEL/TOTAL REFUND/TOTAL ORDERS)
    {
        merchantPage = new MerchantPage();
        accessToAllOrders();

        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("(//h5[@class='m-0'])[1]")).isDisplayed());
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("(//h5[@class='m-0'])[2]")).isDisplayed());
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("(//h5[@class='m-0'])[3]")).isDisplayed());
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("(//h5[@class='m-0'])[4]")).isDisplayed());
        Driver.quitDriver();


    }

    @Test
    public void TC_3107() // NEXT Previous Button Test
    {
        merchantPage = new MerchantPage();
        accessToAllOrders();

        WebElement nextButton = Driver.getDriver().findElement(By.xpath("//*[@id='DataTables_Table_0_next']"));
        Assert.assertTrue(nextButton.isDisplayed());
        Assert.assertTrue(nextButton.isEnabled());
        nextButton.click();
        ReusableMethods.wait(1);

        WebElement thirdPageButton = Driver.getDriver().findElement(By.xpath("//*/a[@data-dt-idx='3']"));
        Assert.assertTrue(thirdPageButton.isEnabled());
        Assert.assertTrue(thirdPageButton.isDisplayed());
        thirdPageButton.click();
        ReusableMethods.wait(1);

        WebElement previousButton = Driver.getDriver().findElement(By.xpath("//*[@id='DataTables_Table_0_previous']"));
        Assert.assertTrue(previousButton.isDisplayed());
        Assert.assertTrue(previousButton.isEnabled());
        previousButton.click();
        ReusableMethods.wait(1);

        Driver.quitDriver();


    }

    @Test
    public void TC_3108() //Orders ID Sort Test
    {
        merchantPage = new MerchantPage();
        accessToAllOrders();

        Driver.getDriver().findElement(By.xpath("//*[text()='Order ID']")).click();

        List<String> allOrdesIdStringList = ReusableMethods.stringListesineDonustur(merchantPage.allOrdersIdList);
        List<Integer> allOrdesIdIntegerList = new ArrayList<>();
        ReusableMethods.stringListToIntegerList(allOrdesIdStringList, allOrdesIdIntegerList);

        for (int i = 0; i > allOrdesIdIntegerList.size() - 1; i++) {
            Assert.assertTrue(allOrdesIdIntegerList.get(i) > allOrdesIdIntegerList.get(i + 1));
        }
        ReusableMethods.wait(1);
        Driver.quitDriver();
    }

    @Test
    public void TC_3109() {
        merchantPage = new MerchantPage();
        accessToAllOrders();
        JSUtilities.scrollToBottom(Driver.getDriver());

        WebElement entriesAll = Driver.getDriver().findElement(By.xpath("//*[@class='dataTables_info']"));


        Assert.assertTrue(entriesAll.isDisplayed());

        Driver.quitDriver();


    }


    public void accessToAllOrders() //Access To All Orders Method
    {
        ReusableMethods.accessToMerchant();

        Assert.assertTrue(merchantPage.ordersLink.isDisplayed());
        Assert.assertTrue(merchantPage.ordersLink.isEnabled());
        merchantPage.ordersLink.click();
        ReusableMethods.wait(1);

        Assert.assertTrue(merchantPage.allOrdersLink.isEnabled());
        Assert.assertTrue(merchantPage.allOrdersLink.isDisplayed());
        merchantPage.allOrdersLink.click();
        ReusableMethods.wait(1);

        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = "https://qa.flavorfetch.com/backoffice/orders/history";
        Assert.assertEquals(actualUrl, expectedUrl);
    }


}
