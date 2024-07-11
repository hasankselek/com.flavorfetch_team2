package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MerchantPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class US_027 {

    MerchantPage merchantPage = new MerchantPage();

    @Test
    public void TC_2701() { //Access and Select First Order Test
        accessMerchantAndClickOrderProcessing();

        if (!merchantPage.orderProcessingList.isEmpty()){

            WebElement firstOrder = Driver.getDriver().findElement(By.xpath("(//*[@class='col'])[1]"));
            firstOrder.click();
            Assert.assertTrue(firstOrder.isDisplayed());
            WebElement secondOrder = Driver.getDriver().findElement(By.xpath("(//*[@class='col'])[2]"));
            secondOrder.click();
            Assert.assertTrue(secondOrder.isDisplayed());

        }

        Driver.quitDriver();
    }

    @Test
    public void TC_2702() { //Access and Select Firs Order Later Click Ready For Pickup

        accessMerchantAndClickOrderProcessing();

        if (!merchantPage.orderProcessingList.isEmpty()){
            WebElement firstOrder = Driver.getDriver().findElement(By.xpath("(//*[@class='col'])[1]"));
            firstOrder.click();
            Assert.assertTrue(firstOrder.isDisplayed());

            merchantPage.printButton.click();
            ReusableMethods.wait(1);

            String expectedText = "Print";
            String actualText = merchantPage.printButton.getText();

            Assert.assertEquals(actualText, expectedText);
        }


        Driver.quitDriver();


    }

    @Test
    public void TC_2703_TC_2704_TC_2705() {
        accessMerchantAndClickOrderProcessing();
        int beforeReadyForPickupOrderSize =merchantPage.orderProcessingList.size();
        int afterReadyForPickupOrderSize;
        if (!merchantPage.orderProcessingList.isEmpty()){

            Assert.assertTrue(merchantPage.readyForPickupButton.isDisplayed());
            merchantPage.readyForPickupButton.click();
            ReusableMethods.wait(1);

            List<WebElement> afterOrderprocessingList =Driver.getDriver().findElements(By.xpath("//*[@class='list-unstyled m-0 grey-list-chevron']//li"));

            afterReadyForPickupOrderSize =afterOrderprocessingList.size();
            Assert.assertNotEquals(afterReadyForPickupOrderSize,beforeReadyForPickupOrderSize);

        }else {
            String expectedText = "No results";
            String actualText = Driver.getDriver().findElement(By.xpath("//div[@role='alert']")).getText();
                        Assert.assertEquals(actualText,expectedText);
        }



        Driver.quitDriver();
    }


    public void accessMerchantAndClickOrderProcessing() {
        ReusableMethods.accessToMerchant();

        WebElement orderElement = merchantPage.ordersLink;
        Assert.assertTrue(orderElement.isDisplayed());
        Assert.assertTrue(orderElement.isEnabled());
        orderElement.click();
        ReusableMethods.wait(1);


        WebElement ordersProcessingElement = merchantPage.ordersProcessingLink;
        Assert.assertTrue(ordersProcessingElement.isDisplayed());
        Assert.assertTrue(ordersProcessingElement.isEnabled());
        ordersProcessingElement.click();

        String actualOrderProcessingPageTitle = Driver.getDriver().getTitle();
        String expectedOrderProcessingPageTitle = "Orders Processing";
        Assert.assertEquals(actualOrderProcessingPageTitle, expectedOrderProcessingPageTitle);
        ReusableMethods.wait(1);



    }
}
