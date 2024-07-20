package tests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomerPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class US_013 extends TestBaseRapor {

    CustomerPage customerPage=new CustomerPage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void TC_1301(){
        actions = new Actions(Driver.getDriver());
        customerPage= new CustomerPage();
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        customerPage.signInButton.click();
        customerPage.emailBox.sendKeys(ConfigReader.getProperty("customeruser_selahattin"));
        customerPage.passwordBox.sendKeys(ConfigReader.getProperty("customerpassword_selahattin"));
        customerPage.loginSigninButton.click();
        customerPage.enterDeliveryAddresstextBox.sendKeys("new york" );
        customerPage.newYorkAddressTextBox.click();
        ReusableMethods.wait2(1);
        //JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        //jse.executeScript("arguments[0].scrollIntoView({block: 'center'});",customerPage.showMoreButton);
        //actions.click(customerPage.showMoreButton).perform();
        customerPage.sandwichRAdioButton.isDisplayed();
        actions.click(customerPage.sandwichRAdioButton).perform();
        customerPage.cookieAccept.click();
        actions.click(customerPage.team2Page).perform();
        actions.click(customerPage.iskenderButton).perform();
        customerPage.checkoutButton.click();
        customerPage.addNewAddressLink.click();
        customerPage.addressPopupTextBox.sendKeys("new");
        customerPage.newYorkAddressTextBox.click();
        ReusableMethods.wait2(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        customerPage.saveButtonChangeAddress.click();
        String expectedYazi = "New York, NY, USA";
        String actualYazi = customerPage.chooseDeliveryText.getText();
        Assert.assertEquals(actualYazi,expectedYazi);
        Driver.quitDriver();
    }
    @Test(groups = "regression")
    public void TC_1302() throws IOException {
        actions = new Actions(Driver.getDriver());
        customerPage= new CustomerPage();
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        extentTest.info("kullanici customer anasayfasina gider");
        customerPage.signInButton.click();
        extentTest.info("signIn linkine tiklar");
        customerPage.emailBox.sendKeys(ConfigReader.getProperty("customeruser_selahattin"));
        extentTest.info("kullanici emailini girer");
        customerPage.passwordBox.sendKeys(ConfigReader.getProperty("customerpassword_selahattin"));
        extentTest.info("kullanici password'unu girer");
        customerPage.loginSigninButton.click();
        extentTest.info("signIn butonuna tiklar");
        customerPage.enterDeliveryAddresstextBox.sendKeys("new york" );
        extentTest.info("kullanici adress text box'ina adresini girer");
        customerPage.newYorkAddressTextBox.click();
        extentTest.info("kullanici cikan adrese tiklar");
        ReusableMethods.wait2(5);
        Assert.assertTrue(customerPage.sandwichRAdioButton.isDisplayed());
        extentTest.pass("kullanici sandwich sekmesinin gorunurlugunu kontrol eder");
        actions.click(customerPage.sandwichRAdioButton).perform();
        extentTest.info("kullanici sandwich butonuna yiklar");
        customerPage.cookieAccept.click();
        extentTest.info("kullanici cookiyi kabul eder");
        actions.click(customerPage.team2Page).perform();
        extentTest.info("kullanici team2 marketine tiklar");
        actions.click(customerPage.iskenderButton).perform();
        extentTest.info("kullanici iskender yemegine tiklar");
        customerPage.checkoutButton.click();
        extentTest.info("kullanici checkout butonuna tiklar");
        ReusableMethods.wait2(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        extentTest.info("kullanici sayfayi asagiya kaydirir");
        ReusableMethods.wait2(1);

        try {
            // Stripe ödeme butonuna tıklayın
            customerPage.stripeButton.click();
            extentTest.info("kullanici stripe buttona tiklar");


            // Hata mesajını kontrol eder
            boolean isErrorMessageDisplayed = customerPage.stripeErrorMessage.isDisplayed();
            extentTest.info("Hata mesajını kontrol eder");

            //add Stripe butonuna tıklar
            customerPage.addStripeButton.click();
            extentTest.pass("kullanici add stripe butonuna tiklar");

            // Eğer hata mesajı görünüyorsa, testi fail et
            if (isErrorMessageDisplayed) {
                String errorMessageText = customerPage.stripeErrorMessage.getText();
                Assert.fail("Hata mesajı alındı: " + errorMessageText);

            }
        } catch (Exception e) {
            // Diğer tüm istisnalar için genel bir hata mesajı
            extentTest.pass("Hata mesajının gözüktüğünü doğrular");
            Assert.fail("Stripe ödeme methodu başarısız " + e.getMessage());

        }
        Driver.quitDriver();
    }
    @Test
    public void TC_1303(){
        actions = new Actions(Driver.getDriver());
        customerPage= new CustomerPage();
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        customerPage.signInButton.click();
        customerPage.emailBox.sendKeys(ConfigReader.getProperty("customeruser_selahattin"));
        customerPage.passwordBox.sendKeys(ConfigReader.getProperty("customerpassword_selahattin"));
        customerPage.loginSigninButton.click();
        customerPage.enterDeliveryAddresstextBox.sendKeys("new york" );
        customerPage.newYorkAddressTextBox.click();
        ReusableMethods.wait2(1);
        customerPage.sandwichRAdioButton.isDisplayed();
        actions.click(customerPage.sandwichRAdioButton).perform();
        customerPage.cookieAccept.click();
        actions.click(customerPage.team2Page).perform();
        actions.click(customerPage.iskenderButton).perform();
        customerPage.checkoutButton.click();
        ReusableMethods.wait2(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait2(1);
        try {
            if (customerPage.savedPaymentMethodsText.isDisplayed()) {
                customerPage.paymentDefaultThreeDat.click();
                ReusableMethods.wait(1);
                customerPage.deleteLinkThreeDat.click();

            }
        } catch (NoSuchElementException e) {
            // Öğe bulunamazsa burası çalışır
            customerPage.cashOnDeliveryButton.click();
            customerPage.addCashButton.click();
            String expectedYazi = "Saved Payment Methods";
            String actualYazi = customerPage.savedPaymentMethodsText.getText();
            Assert.assertEquals(actualYazi, expectedYazi);
        }

        Driver.quitDriver();
    }
    @Test
    public void TC_1304() throws IOException{
        actions = new Actions(Driver.getDriver());
        customerPage= new CustomerPage();
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        extentTest.info("kullanici customer anasayfasina gider");
        customerPage.signInButton.click();
        extentTest.info("kullanici signIn linkine tiklar");
        customerPage.emailBox.sendKeys(ConfigReader.getProperty("customeruser_selahattin"));
        extentTest.info("kullanici emailini girer");
        customerPage.passwordBox.sendKeys(ConfigReader.getProperty("customerpassword_selahattin"));
        extentTest.info("kullanici password'unu girer");
        customerPage.loginSigninButton.click();
        extentTest.info("kullanici signIn butonuna tiklar");
        customerPage.enterDeliveryAddresstextBox.sendKeys("new york" );
        extentTest.info("kullanici adresini girer");
        customerPage.newYorkAddressTextBox.click();
        extentTest.info("kullanici adrese tiklar");
        ReusableMethods.wait2(1);
        customerPage.sandwichRAdioButton.isDisplayed();
        extentTest.info("kullanici sandwich sekmesinin gorunurlugunu kontrol eder");
        actions.click(customerPage.sandwichRAdioButton).perform();
        extentTest.info("kullanici sandwich butonuna yiklar");
        customerPage.cookieAccept.click();
        extentTest.info("kullanici cookiyi kabul eder");
        actions.click(customerPage.team2Page).perform();
        extentTest.info("kullanici team2 marketine tiklar");
        actions.click(customerPage.iskenderButton).perform();
        extentTest.info("kullanici iskender yemegine tiklar");
        customerPage.checkoutButton.click();
        extentTest.info("kullanici checkout butonuna tiklar");
        customerPage.orderTypeMenuText.isDisplayed();
        extentTest.info("kullanici order menunun gorunurlugunu kontrol eder");
        customerPage.orderTypeLink.click();
        extentTest.info("kullanucu order menuye tiklar");
        customerPage.deliveryRadioButton.click();
        extentTest.info("kullanici delivery sekmesine tiklar");
        customerPage.orderTypeSaveButton.click();
        extentTest.info("kullanici save butonuna tiklar");
        customerPage.addNewAddressLink.click();
        extentTest.info("kullanici adres linkine tiklar");
        customerPage.addressPopupTextBox.sendKeys("new");
        extentTest.info("kullanici adresini girer");
        customerPage.newYorkAddressTextBox.click();
        ReusableMethods.wait2(1);
        extentTest.info("kullanici adresine tiklar");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        extentTest.info("kullanici sayfayi asagiya kaydirir");
        customerPage.saveButtonChangeAddress.click();
        ReusableMethods.wait2(1);
        extentTest.info("kullanici save butonuna tiklar");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait2(1);
        extentTest.info("kullanici sayfayi asagiya kaydirir");
        customerPage.cashOnDeliveryButton.click();
        extentTest.info("kullanici cash odeme butonuna tiklar");
        customerPage.addCashButton.click();
        extentTest.info("kullanici Add cash butonuna tiklar");
        customerPage.placeOrderButtonText.isDisplayed();
        extentTest.info("kullanici place order butonunun gorunurlugunu kontrol eder");
        customerPage.placeOrderButton.click();
        extentTest.info("kullanici place order butonuna tiklar");
        String expectedText= "Confirming your order";
        String actualText = customerPage.confirmingText.getText();
        Assert.assertEquals(actualText,expectedText);
        extentTest.pass("kullanici confirming yazisini dogrular");


        Driver.quitDriver();
    }
    @Test
    public void TC_1305(){
        actions = new Actions(Driver.getDriver());
        customerPage= new CustomerPage();
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        customerPage.signInButton.click();
        customerPage.emailBox.sendKeys(ConfigReader.getProperty("customeruser_selahattin"));
        customerPage.passwordBox.sendKeys(ConfigReader.getProperty("customerpassword_selahattin"));
        customerPage.loginSigninButton.click();
        customerPage.enterDeliveryAddresstextBox.sendKeys("new york" );
        customerPage.newYorkAddressTextBox.click();
        ReusableMethods.wait2(1);
        customerPage.sandwichRAdioButton.isDisplayed();
        actions.click(customerPage.sandwichRAdioButton).perform();
        customerPage.cookieAccept.click();
        actions.click(customerPage.team2Page).perform();
        actions.click(customerPage.iskenderButton).perform();
        customerPage.checkoutButton.click();
        customerPage.orderTypeMenuText.isDisplayed();
        customerPage.orderTypeLink.click();
        customerPage.dineinRadioButton.click();
        customerPage.orderTypeSaveButton.click();
        //customerPage.addNewAddressLink.click();
        //customerPage.addressPopupTextBox.sendKeys("new");
        //customerPage.newYorkAddressTextBox.click();
        //ReusableMethods.wait2(1);
        //actions.sendKeys(Keys.PAGE_DOWN).perform();
        //customerPage.saveButtonChangeAddress.click();
        ReusableMethods.wait2(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait2(1);
        try {
            if (customerPage.savedPaymentMethodsText.isDisplayed()) {
                customerPage.paymentDefaultThreeDat.click();
                ReusableMethods.wait(2);
                customerPage.deleteLinkThreeDat.click();
                ReusableMethods.wait(2);
                customerPage.cashOnDeliveryButton.click();
                ReusableMethods.wait(2);
                customerPage.addCashButton.click();
            }
        } catch (NoSuchElementException e) {
            // Öğe bulunamazsa burası çalışır
            customerPage.cashOnDeliveryButton.click();
            customerPage.addCashButton.click();
            String expectedYazi = "Saved Payment Methods";
            String actualYazi = customerPage.savedPaymentMethodsText.getText();
            Assert.assertEquals(actualYazi, expectedYazi);
        }
        customerPage.placeOrderButtonText.isDisplayed();
        actions.click(customerPage.placeOrderButton).perform();
        ReusableMethods.wait2(1);
        String expectedText= "Confirming your order";
        String actualText = customerPage.confirmingText.getText();
        Assert.assertEquals(actualText,expectedText);
        Driver.quitDriver();
    }
    @Test
    public void TC_1306(){
        actions = new Actions(Driver.getDriver());
        customerPage= new CustomerPage();
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        customerPage.signInButton.click();
        customerPage.emailBox.sendKeys(ConfigReader.getProperty("customeruser_selahattin"));
        customerPage.passwordBox.sendKeys(ConfigReader.getProperty("customerpassword_selahattin"));
        customerPage.loginSigninButton.click();
        customerPage.enterDeliveryAddresstextBox.sendKeys("new york" );
        customerPage.newYorkAddressTextBox.click();
        ReusableMethods.wait2(1);
        customerPage.sandwichRAdioButton.isDisplayed();
        actions.click(customerPage.sandwichRAdioButton).perform();
        customerPage.cookieAccept.click();
        actions.click(customerPage.team2Page).perform();
        actions.click(customerPage.iskenderButton).perform();
        customerPage.checkoutButton.click();
        customerPage.orderTypeMenuText.isDisplayed();
        customerPage.orderTypeLink.click();
        customerPage.pickUpRadioButton.click();
        customerPage.orderTypeSaveButton.click();
        //customerPage.addNewAddressLink.click();
        //customerPage.addressPopupTextBox.sendKeys("new");
        //customerPage.newYorkAddressTextBox.click();
        //ReusableMethods.wait2(1);
        //actions.sendKeys(Keys.PAGE_DOWN).perform();
        //customerPage.saveButtonChangeAddress.click();
        ReusableMethods.wait2(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait2(1);
        customerPage.cashOnDeliveryButton.click();
        customerPage.addCashButton.click();
        customerPage.placeOrderButtonText.isDisplayed();
        actions.click(customerPage.placeOrderButton).perform();
        ReusableMethods.wait2(2);
        String expectedText= "Confirming your order";
        String actualText = customerPage.confirmingText.getText();
        Assert.assertEquals(actualText,expectedText);
        Driver.quitDriver();
    }
}
