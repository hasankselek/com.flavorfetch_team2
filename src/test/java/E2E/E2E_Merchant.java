package E2E;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MerchantLoginPage;
import pages.MerchantPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtilities;
import utilities.ReusableMethods;

import java.time.Duration;

public class E2E_Merchant {

    static MerchantLoginPage merchantLoginPage;
    static MerchantPage merchantPage;
    static Actions actions;

    @Test
    public void E2E_Merchant() {
        merchantLoginPage = new MerchantLoginPage();
        merchantPage = new MerchantPage();
        actions = new Actions(Driver.getDriver());

        //TC1901
        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
        String exeptedUrl = ConfigReader.getProperty("merchant_Url");
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, exeptedUrl);
        Assert.assertTrue(merchantLoginPage.titleOfLoginPage.isDisplayed());


        //TC1907
        merchantLoginPage.userBoxMerchantLogin.sendKeys(ConfigReader.getProperty("merchant_username"));
        merchantLoginPage.passwordBoxMerchantLogin.sendKeys(ConfigReader.getProperty("merchant_password"));
        merchantLoginPage.rememberMeLable.click();
        merchantLoginPage.signInButtonMerchantLogin.click();

        //TC1913
        String expectedUrlContain = ConfigReader.getProperty("urlContent3");
        String actualUrlContain = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrlContain.contains(expectedUrlContain));

        //TC2103

        Assert.assertTrue(merchantPage.merchantLink.isDisplayed());

        Assert.assertTrue(merchantPage.ordersLink.isDisplayed());
        Assert.assertTrue(merchantPage.attributesLink.isDisplayed());
        Assert.assertTrue(merchantPage.foodLink.isDisplayed());
        Assert.assertTrue(merchantPage.ordertypeLinki.isDisplayed());
        Assert.assertTrue(merchantPage.paymentGatewayLink.isDisplayed());
        Assert.assertTrue(merchantPage.promoLink.isDisplayed());
        Assert.assertTrue(merchantPage.imagesLink.isDisplayed());
        Assert.assertTrue(merchantPage.accountLink.isDisplayed());
        Assert.assertTrue(merchantPage.buyersLink.isDisplayed());
        Assert.assertTrue(merchantPage.usersLink.isDisplayed());
        Assert.assertTrue(merchantPage.reportsLink.isDisplayed());
        Assert.assertTrue(merchantPage.inventoryManagementLink.isDisplayed());
        ReusableMethods.wait(3);


        merchantPage.dashboardOrdersIcon.click();
        ReusableMethods.wait(1);
        merchantPage.dasboardNewOrdersIcon.click();
        String siparisAdediStr = merchantPage.ordersQuantitty.getText().replaceAll("\\D", "");
        int siparisAdedi = Integer.parseInt(siparisAdediStr);


        merchantPage.newIcon.click();

        Assert.assertTrue(merchantPage.newOrdersList.size() > 0);

        // Assert.assertTrue(merchantPage.orderId1.size()>0);
        Assert.assertTrue(merchantPage.customerName.isDisplayed());
        Assert.assertTrue(merchantPage.orderDateAndTime.isDisplayed());
        Assert.assertTrue(merchantPage.totalOrderPrice.isDisplayed());


        merchantPage.addButton.click();
        merchantPage.productTobBeAdded.click();
        ReusableMethods.wait(3);
        merchantPage.addToOrderButton.click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Item added to order']")));

        String expectedMessage = "Item added to order";
        String actualMessage = merchantPage.itemAddedToOrderMessage.getText();

        Assert.assertEquals(actualMessage, expectedMessage);
        actions.sendKeys(Keys.ESCAPE).perform();
        ReusableMethods.wait(3);

        merchantPage.newIcon.click();

        Assert.assertTrue(merchantPage.acceptedButton.isDisplayed() && merchantPage.acceptedButton.isEnabled());
        Assert.assertTrue(merchantPage.rejectButton.isDisplayed() && merchantPage.rejectButton.isEnabled());

        merchantPage.acceptedButton.click();


        //TC2703
        Assert.assertTrue(merchantPage.readyForPickupButton.isDisplayed());
        merchantPage.readyForPickupButton.click();
        ReusableMethods.wait(1);




    }
}
