package tests;

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
import utilities.ReusableMethods;
import utilities.TestBaseRaporEskiSürüm;

import java.time.Duration;

public class zMerchantSuit extends TestBaseRaporEskiSürüm {

    static MerchantLoginPage merchantLoginPage;
    static MerchantPage merchantPage;
    static Actions actions;

    @Test
    public void MerchantTest() {
        merchantLoginPage = new MerchantLoginPage();
        merchantPage = new MerchantPage();
        actions = new Actions(Driver.getDriver());

        extentTest = extentReports.createTest("zMerchantSuit", "Restaurant sipariş onay adımlarını uygulayarak siparişi onaylar");

        //TC1901
        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
        extentTest.info("İlgili url'ye gider");
        String exeptedUrl = ConfigReader.getProperty("merchant_Url");
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, exeptedUrl);
        Assert.assertTrue(merchantLoginPage.titleOfLoginPage.isDisplayed());
        extentTest.pass("Doğru url'ye gittiğini doğrular");


        //TC1907
        merchantLoginPage.userBoxMerchantLogin.sendKeys(ConfigReader.getProperty("merchant_username"));
        merchantLoginPage.passwordBoxMerchantLogin.sendKeys(ConfigReader.getProperty("merchant_password"));
        extentTest.info("Geçerli username ve password girer");
        merchantLoginPage.signInButtonMerchantLogin.click();
        extentTest.info("Signin butonuna basar");
        ReusableMethods.wait(1);

        //TC1913
        String expectedUrlContain = ConfigReader.getProperty("urlContent3");
        String actualUrlContain = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrlContain.contains(expectedUrlContain));
        extentTest.pass("Doğru sayfa yönlendirildiğini doğrular");

        Assert.assertTrue(merchantPage.merchantLink.isDisplayed());

        merchantPage.dashboardOrdersIcon.click();
        extentTest.info("Orders yazısına tıklar");
        ReusableMethods.wait(1);
        merchantPage.dasboardNewOrdersIcon.click();
        extentTest.info("New Orders yazısına tıklar");
        String siparisAdediStr = merchantPage.ordersQuantitty.getText().replaceAll("\\D", "");
        int siparisAdedi = Integer.parseInt(siparisAdediStr);


        merchantPage.newIcon.click();
        extentTest.info("New statüsünde bir sipariş olduğunu görüntüler");

        Assert.assertTrue(merchantPage.newOrdersList.size() > 0);
        extentTest.pass("Sipariş sayısının 0'dan fazla olduğunu doğrular");


        Assert.assertTrue(merchantPage.customerName.isDisplayed());
        extentTest.pass("Customer name görüntülendiğini doğrular");
        Assert.assertTrue(merchantPage.orderDateAndTime.isDisplayed());
        extentTest.pass("Sipariş tarihi ve saatinin görüntülendiğini doğrular");
        Assert.assertTrue(merchantPage.totalOrderPrice.isDisplayed());
        extentTest.pass("Toplam sipariş ücretinin görüntülendiğini doğrular");


        merchantPage.addButton.click();
        extentTest.pass("Add butonuna tıklar");
        ReusableMethods.wait(1);

        merchantPage.productTobBeAdded.click();
        extentTest.info("İstenilen ürünü ekler");
        ReusableMethods.wait(2);

        merchantPage.addToOrderButton.click();
        extentTest.info("Add to Order butonuna tıklar");
        ReusableMethods.wait(1);

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Item added to order']")));

        String expectedMessage = "Item added to order";
        String actualMessage = merchantPage.itemAddedToOrderMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage);
        extentTest.pass("Ürünün eklendiğini doğrular");

        actions.sendKeys(Keys.ESCAPE).perform();
        ReusableMethods.wait(3);

        merchantPage.newIcon.click();
        extentTest.info("Siparişe tıklar");


        Assert.assertTrue(merchantPage.acceptedButton.isDisplayed() && merchantPage.acceptedButton.isEnabled());
        Assert.assertTrue(merchantPage.rejectButton.isDisplayed() && merchantPage.rejectButton.isEnabled());

        merchantPage.acceptedButton.click();
        extentTest.info("Siparişi onaylar");
        ReusableMethods.wait(1);

        //TC2703
        merchantPage.ordersProcessingLink.click();
        extentTest.info("Orders Processing'e tıklar");
        ReusableMethods.wait(1);

        Assert.assertTrue(merchantPage.readyForPickupButton.isDisplayed());
        extentTest.pass("Ready For Pickup butonunun görüntülendiğini doğrular");

        merchantPage.readyForPickupButton.click();
        extentTest.info("Ready For Pickup butonuna tıklar");
        ReusableMethods.wait(1);

        merchantPage.ordersReadyLink.click();
        extentTest.info("Orders Ready linkine tıklar");
        ReusableMethods.wait(1);

        merchantPage.completeOrdersReadyPage.click();
        extentTest.info("Complete Orders'a tıklar");
        ReusableMethods.wait(1);

        merchantPage.ordersCompletedLink.click();
        extentTest.info("Completed'atıklar");
        ReusableMethods.wait(1);

        int OrderView =merchantPage.orderProcessingList.size();

        if (OrderView>0){


            Assert.assertTrue(merchantPage.productNameOrderSummary.isDisplayed());
            extentTest.info("Siparis ozetinde urunlerin isimlerinin goruntulendigini dogrular");

            Assert.assertTrue(merchantPage.productPriceOrderSummary.isDisplayed());
            extentTest.info("Urunlerin fiyatinin goruntulendigini dogrular");

            Assert.assertTrue(merchantPage.subTotalQuantityOrderSummary.isDisplayed());
            extentTest.info("Siparis verilen toplam urun adedinin goruntulendigini dogrular");

            Assert.assertTrue(merchantPage.subTotalPriceOrderSummary.isDisplayed());
            extentTest.info("Toplam fiyatin goruntulendigini dogrular");

            Assert.assertTrue(merchantPage.printButton.isDisplayed());
            extentTest.info("Print butonunun görüntülendiğini dogrular");

            Assert.assertTrue(merchantPage.printButton.isEnabled());
            extentTest.info("Print butonunun erisilebilir oldugunu dogrular");

            ReusableMethods.wait(5);
            Driver.quitDriver();
            extentTest.info("Çıkış yapar");
        }
        else {
            Driver.quitDriver();
            extentTest.info("Çıkış yapar");
        }





    }
}
