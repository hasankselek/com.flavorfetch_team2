package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MerchantPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class US_26 {

    MerchantPage merchantPage = new MerchantPage();
    @Test
    public  void TC_2601(){


        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));

        merchantPage.usernametextbox.sendKeys(ConfigReader.getProperty("merchant_username"));
        merchantPage.passwordtextbox.sendKeys(ConfigReader.getProperty("merchant_password"));
        merchantPage.singinButton.click();
        merchantPage.dashboardOrdersIcon.click();
        merchantPage.dasboardNewOrdersIcon.click();

        Assert.assertTrue(merchantPage.orderId1.size()>0);
        Assert.assertTrue(merchantPage.customerName.isDisplayed());
        Assert.assertTrue(merchantPage.orderDateAndTime.isDisplayed());
        Assert.assertTrue(merchantPage.totalOrderPrice.isDisplayed());
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

        Assert.assertTrue(merchantPage.acceptedButton.isDisplayed() && merchantPage.acceptedButton.isEnabled());
        Assert.assertTrue(merchantPage.rejectButton.isDisplayed() && merchantPage.rejectButton.isEnabled());


        List<WebElement> orderIdListIlkHali=merchantPage.orderId1;

        String reddedilecekOrder=orderIdListIlkHali.get(0).getText();

        merchantPage.rejectButton.click();
        ReusableMethods.wait(3);
        merchantPage.outOfItems.click();
        ReusableMethods.wait(2);
        merchantPage.pupupRejectButton.click();

        List<WebElement> orderIdListSonHali=merchantPage.orderId2;
        String kalanSiparisOrderId=orderIdListSonHali.get(0).getText();

        Assert.assertNotEquals(kalanSiparisOrderId,reddedilecekOrder);
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
        Assert.assertTrue(merchantPage.acceptingOrderButton.isDisplayed());

        merchantPage.acceptingOrderButton.click();
        merchantPage.pauseMinuteOption.click();
        merchantPage.nextButton.click();
        merchantPage.reasonForPausing.click();
        merchantPage.confirmButton.click();


        Assert.assertFalse(merchantPage.acceptingOrderButton.isEnabled());
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

        merchantPage.addButton.click();
        merchantPage.productTobBeAdded.click();
        ReusableMethods.wait(3);
        merchantPage.addToOrderButton.click();

        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Item added to order']")));

        String expectedMessage="Item added to order";
        String actualMessage=merchantPage.itemAddedToOrderMessage.get(0).getText();
        Assert.assertEquals(actualMessage,expectedMessage);

    }
}
