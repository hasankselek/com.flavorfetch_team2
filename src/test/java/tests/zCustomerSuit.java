package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomerPage;
import pages.MerchantPage;
import utilities.*;

import java.util.ArrayList;
import java.util.List;

public class zCustomerSuit extends TestBaseRaporEskiSürüm {

    static CustomerPage customerPage;
    static Actions actions;
    static MerchantPage merchantPage;

    @Test
    public void CustomerTest(){

        merchantPage = new MerchantPage();
        customerPage = new CustomerPage();
        actions = new Actions(Driver.getDriver());

        extentTest = extentReports.createTest("zCustomerSuit", "Geçerli kullanici ile istenilen resturanttan sipariş verin");

        //TC0101
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        String expectedUrl = "https://qa.flavorfetch.com/" ;
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
        extentTest.info("İlgili url'ye gider");

        //TC0204

        Assert.assertTrue(customerPage.signInButton.isDisplayed());
        extentTest.pass("Signin butonunun görüntülendiğini doğrular");

        //TC0501
        customerPage.signInButton.click();
        extentTest.info("Anasayfa header bolumundeki 'Sign in' butonuna tiklar");
        ReusableMethods.wait(1);

        Assert.assertTrue(customerPage.emailBox.isDisplayed());
        extentTest.pass("Email/telefon numarasi girebilmek icin bir box oldugunu dogrular");

        Assert.assertTrue(customerPage.passwordBox.isDisplayed());
        extentTest.pass("Password girebilmek icin bir box oldugunu dogrular");

        Assert.assertTrue(customerPage.passwordBox.getAccessibleName().contains("*"));
        extentTest.pass("Password girilecek alanin zorunlu oldugunu dogrular");

        Assert.assertTrue(customerPage.passworrdHideShowEye.isDisplayed());
        extentTest.pass("Password'u gizleyip/acmak icin goz ikonu oldugunu dogrular");

        Assert.assertTrue(customerPage.rememberMeCheckBox.isDisplayed());
        extentTest.pass("'Remember me' secenegi icin bir checkbox oldugunu dogrular");

        Assert.assertTrue(customerPage.forgotPasswordLink.isDisplayed());
        extentTest.pass("'Forgot password?' secenegi icin bir link baglantisi oldugunu dogrular");

        Assert.assertTrue(customerPage.signUpButton.isDisplayed());
        extentTest.pass("Yeni kayitlar icin bir 'Sign Up' link baglantisi oldugunu dogrular");


        //TC0502
        customerPage.emailBox.sendKeys(ConfigReader.getProperty("customeruser_gulpembe"));
        extentTest.info("Email alanina doğru email girer");
        ReusableMethods.wait(1);

        customerPage.passwordBox.sendKeys(ConfigReader.getProperty("customerpassword_gulpembe"));
        extentTest.info("Password alanina dogru passwordu girer");
        ReusableMethods.wait(1);

        customerPage.loginSigninButton.click();
        extentTest.info("Sign in butonuna tiklar");
        ReusableMethods.wait(1);

        Assert.assertTrue(customerPage.notificicationsButton.isDisplayed());
        extentTest.pass("Basarili giris yapabildigini dogrular");
        ReusableMethods.wait(1);

        //TC0302
        customerPage.enterDeliveryAddresstextBox.sendKeys("New York");
        extentTest.info("Arama kutucuğuna 'New York' yazar ");
        ReusableMethods.wait(1);

        customerPage.newYorkAddressTextBox.click();
        extentTest.info("Çıkan sonuçlardan New York'u seçer");
        ReusableMethods.wait(1);

        ReusableMethods.wait(3);
        Driver.getDriver().navigate().back();
        extentTest.info("Anasayfaya geri döner");
        ReusableMethods.wait(1);

        //TC1201
        Assert.assertTrue(customerPage.localCuisine.isDisplayed());
        extentTest.pass("Yerel Mutfakların görüntülendiğini doğrular");


        customerPage.sandwichAndWraps.click();
        extentTest.info("Sandwich and Wraps'a tıklar");
        ReusableMethods.wait(1);

        customerPage.team2Restaurant.click();
        extentTest.info("Team2 Restaurant'ını seçer");
        ReusableMethods.wait(2);

        //TC1108
        customerPage.addToCartButton.get(0).click();
        extentTest.info("İstediği ürünü seçer ve Add to Cart butonuyla sepete ekler");
        ReusableMethods.wait(1);

        Assert.assertTrue(customerPage.checkoutButton.isDisplayed());
        extentTest.pass("Checkout butonunun görüntülendiğini doğrular");

        //TC1102
        List<String> orderTypeText = new ArrayList<>();
        for (int i = 0; i < customerPage.customerOrderType.size(); i++) {
            customerPage.customerOrderType.get(i).click();
            extentTest.info(i+" sipariş tipine tıklar");
            ReusableMethods.wait(1);
            orderTypeText.add(customerPage.customerOrderType.get(i).getText());
            Assert.assertTrue(customerPage.customerOrderType.get(i).isDisplayed());
            Assert.assertTrue(customerPage.customerOrderType.get(i).isEnabled());
            Assert.assertEquals(customerPage.customerOrderType.get(i).getText(),orderTypeText.get(i));
            extentTest.pass(i+" sipariş tipinin görüntülendiğini doğrular");
        }


        List<WebElement> priceListWebElement = Driver.getDriver().findElements(By.xpath("//p[@class='mb-0']"));
        List<String> priceListString = ReusableMethods.stringListesineDonustur(priceListWebElement);

        List<Integer> priceList = new ArrayList<>();
        for (int i = 0; i < priceListString.size(); i++) {
            priceList.add(Integer.parseInt(priceListString.get(i).replace("$", "").replace(".", "")));
        }
        int sum = 0;
        for (Integer number : priceList) {
            sum += number;
        }
        int actualPrice = Integer.parseInt(Driver.getDriver().findElement(By.xpath("//*[@id='vue-cart']/div/div[2]/a/div[2]")).
                getText().replace("$", "").replace(".", ""));
        Assert.assertEquals(actualPrice, sum);
        extentTest.pass("Seçilen ürünlerin fiyatlarinin toplaminin checkout kısmındaki toplam fiyatla ayni olduğunu doğrular");
        ReusableMethods.wait(1);

        //Click the "Check out" button
        customerPage.checkoutButton.click();
        extentTest.info("Checkout butonuna tıklar");
        ReusableMethods.wait(1);

        //TC1305
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        extentTest.info("Sayfada aşağıya iner");
        ReusableMethods.wait(1);
        try {
            if (customerPage.savedPaymentMethodsText.isDisplayed()) {
                customerPage.paymentDefaultThreeDat.click();
                extentTest.info("Bir ödeme methodu kayıtlı ise kayıtlı olan ödeme methoduna tıklar");
                ReusableMethods.wait(1);
                customerPage.deleteLinkThreeDat.click();
                extentTest.info("Ödeme methodunu siler");
                ReusableMethods.wait(1);
                customerPage.cashOnDeliveryButton.click();
                extentTest.info("Cash on Delivery butonuna tıklar");
                ReusableMethods.wait(2);
                customerPage.addCashButton.click();
                extentTest.info("Cash ile ödemeyi seçer");

            }
        } catch (NoSuchElementException e) {
            // Öğe bulunamazsa burası çalışır
            customerPage.cashOnDeliveryButton.click();
            ReusableMethods.wait(1);
            extentTest.info("Bir ödeme methodu kayıtlı değilse Cash on Delivery butonuna tıklar");
            customerPage.addCashButton.click();
            ReusableMethods.wait(1);
            extentTest.info("Cash ile ödemeyi seçer");
            String expectedYazi = "Saved Payment Methods";
            String actualYazi = customerPage.savedPaymentMethodsText.getText();
            Assert.assertEquals(actualYazi, expectedYazi);
            extentTest.pass("Ödeme methodunun kaydedildiğini doğrular");
        }
        customerPage.placeOrderButtonText.isDisplayed();
        extentTest.info("Place Order yazisinin görüntüler");
        actions.click(customerPage.placeOrderButton).perform();
        extentTest.info("Place Order butonuna tıklar");
        ReusableMethods.wait2(1);
        String expectedText= "Confirming your order";
        String actualText = customerPage.confirmingText.getText();
        Assert.assertEquals(actualText,expectedText);
        extentTest.pass("Siparişin onayladığını doğrular");
        ReusableMethods.wait(3);

        Driver.quitDriver();
        extentTest.info("Çıkış yapar");

    }
}
