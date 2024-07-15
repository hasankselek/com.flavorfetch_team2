package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomerPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class US_015 {

    CustomerPage customerPage = new CustomerPage();

    @Test
    public void TC_1501() //Access  My Orders Page Test
    {
        ReusableMethods.accessToCustomer("customeruser_mehmet", "customerpassword_mehmet");
        ReusableMethods.wait(1);
        customerPage.profileDropdownMenu.click();
        ReusableMethods.wait(1);

        Assert.assertTrue(customerPage.myOrdersLink.isDisplayed());
        Assert.assertTrue(customerPage.myOrdersLink.isEnabled());
        customerPage.myOrdersLink.click();
        ReusableMethods.wait(1);

        String expectedUrl = "https://qa.flavorfetch.com/account/orders";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl);


        Driver.quitDriver();
    }

    @Test
    public void TC_1502() //Access  Orders Page Test
    {
        accesOrdersPage();

        List<String> ordersStringList = ReusableMethods.stringListesineDonustur(customerPage.ordersList);
        String expectedFirstOrder = "Team2";
        String actualFirstOrder = ordersStringList.get(0);

        Assert.assertEquals(actualFirstOrder, expectedFirstOrder);


        Driver.quitDriver();


    }

    @Test
    public void TC_1503() //selected Order's View Test
    {
        accesOrdersPage();
        customerPage.firstOrdersDropdownButton.click();
        ReusableMethods.wait(1);
        Assert.assertTrue(customerPage.ordersPageViewButton.isDisplayed());
        Assert.assertTrue(customerPage.ordersPageViewButton.isEnabled());
        customerPage.ordersPageViewButton.click();
        ReusableMethods.wait(1);

        WebElement ordersDetails = Driver.getDriver().findElement(By.xpath("//*[@class='order-details-panel section-cart open']"));
        Assert.assertTrue(ordersDetails.isDisplayed());
        Driver.quitDriver();
    }

    @Test
    public void TC_1504() //selected Order's Buy again Test
    {
        accesOrdersPage();
        customerPage.firstOrdersDropdownButton.click();
        ReusableMethods.wait(1);

        Assert.assertTrue(customerPage.ordersPagebuyAgainButton.isDisplayed());
        Assert.assertTrue(customerPage.ordersPagebuyAgainButton.isEnabled());
        customerPage.ordersPagebuyAgainButton.click();
        ReusableMethods.wait(1);

        WebElement buyAgainPopup = Driver.getDriver().findElement(By.xpath("//section[@class='el-drawer__body']"));
        Assert.assertTrue(buyAgainPopup.isDisplayed());

        customerPage.orderpageGoToCheckoutLink.click();
        ReusableMethods.wait(1);

        customerPage.placeOrderLink.click();
        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = "https://qa.flavorfetch.com/account/checkout";
        Assert.assertEquals(actualUrl,expectedUrl);
        ReusableMethods.wait(1);

        Driver.quitDriver();

    }

    @Test
    public void TC_1505() //Download Pdf Test
    {
        accesOrdersPage();
        customerPage.firstOrdersDropdownButton.click();
        ReusableMethods.wait(1);

        Assert.assertTrue(customerPage.ordersPageDownloadPdfButton.isDisplayed());
        Assert.assertTrue(customerPage.ordersPageDownloadPdfButton.isEnabled());
        customerPage.ordersPageDownloadPdfButton.click();
        ReusableMethods.wait(1);

        Driver.quitDriver();


    }

    @Test
    public void TC_1506() {
        accesOrdersPage();
        customerPage.firstOrdersDropdownButton.click();
        ReusableMethods.wait(1);

        Assert.assertTrue(customerPage.ordersPageWriteAReviewButton.isDisplayed());
        Assert.assertTrue(customerPage.ordersPageWriteAReviewButton.isEnabled());
        customerPage.ordersPageWriteAReviewButton.click();



        Driver.quitDriver();


    }

    public void accesOrdersPage() {
        ReusableMethods.accessToCustomer("customeruser_mehmet", "customerpassword_mehmet");
        ReusableMethods.wait(1);
        customerPage.profileDropdownMenu.click();
        ReusableMethods.wait(1);

        Assert.assertTrue(customerPage.myOrdersLink.isDisplayed());
        Assert.assertTrue(customerPage.myOrdersLink.isEnabled());
        customerPage.myOrdersLink.click();
        ReusableMethods.wait(1);

        String expectedUrl = "https://qa.flavorfetch.com/account/orders";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl);

        Assert.assertTrue(customerPage.ordersLink.isEnabled());
        Assert.assertTrue(customerPage.ordersLink.isDisplayed());
        String actualText = customerPage.ordersLink.getText();
        String expectedText = "Orders";
        Assert.assertEquals(actualText, expectedText);

        customerPage.ordersLink.click();
        ReusableMethods.wait(1);


    }
}
