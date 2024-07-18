package E2E;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomerPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class E2E_Customer {

    static CustomerPage customerPage;
    static Actions actions;

    @Test
    public void E2E(){

        customerPage = new CustomerPage();
        actions = new Actions(Driver.getDriver());

        //TC0101
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        String expectedUrl = "https://qa.flavorfetch.com/" ;
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);

        //TC0204


        //TC0501
        //Kullanici browseri acar
        //Url'I girer
        //Anasayfa header bolumundeki 'Sign in' butonuna tiklar
        customerPage.signInButton.click();
        //Email/telefon numarasi girebilmek icin bir box oldugunu dogrular
        Assert.assertTrue(customerPage.emailBox.isDisplayed());
        //Password girebilmek icin bir box oldugunu dogrular
        Assert.assertTrue(customerPage.passwordBox.isDisplayed());
        //Password girilecek alanin zorunlu oldugunu dogrular
        Assert.assertTrue(customerPage.passwordBox.getAccessibleName().contains("*"));
        //Password'u gizleyip/acmak icin goz ikonu oldugunu dogrular
        Assert.assertTrue(customerPage.passworrdHideShowEye.isDisplayed());
        //Remember me' secenegi icin bir checkbox oldugunu dogrular
        Assert.assertTrue(customerPage.rememberMeCheckBox.isDisplayed());
        //Forgot password?' secenegi icin bir link baglantisi oldugunu dogrular
        Assert.assertTrue(customerPage.forgotPasswordLink.isDisplayed());
        //Yeni kayitlar icin bir 'Sign Up' link baglantisi oldugunu dogrular
        Assert.assertTrue(customerPage.signUpButton.isDisplayed());

        //TC0502
        customerPage.emailBox.sendKeys(ConfigReader.getProperty("customeruser_gulpembe"));
        //Password alanina dogru passwordu girer
        customerPage.passwordBox.sendKeys(ConfigReader.getProperty("customerpassword_gulpembe"));
        //Sign in butonuna tiklar ve basarili giris yapabildigini dogrular
        customerPage.loginSigninButton.click();
        Assert.assertTrue(customerPage.notificicationsButton.isDisplayed());


        //TC0302
        customerPage.enterDeliveryAddresstextBox.sendKeys("new york" );
        customerPage.newYorkAddressTextBox.click();
        ReusableMethods.wait(3);
        Driver.getDriver().navigate().back();
        ReusableMethods.wait(3);

        //TC1201
        Assert.assertTrue(customerPage.localCuisine.isDisplayed());
        ReusableMethods.wait(3);
        customerPage.sandwichAndWraps.click();
        customerPage.team2Restaurant.click();
        ReusableMethods.wait(1);

        //TC1108
        customerPage.addToCartButton.get(0).click();
        Assert.assertTrue(customerPage.checkoutButton.isDisplayed());
        String expectedCheckoutText = "Checkout";
        String actualCheckoutText = customerPage.checkoutButton.getText();
        Assert.assertTrue(customerPage.checkoutButton.getText().contains(expectedCheckoutText));

        //TC1102
        List<String> orderTypeText = new ArrayList<>();
        for (int i = 0; i < customerPage.customerOrderType.size(); i++) {
            customerPage.customerOrderType.get(i).click();
            ReusableMethods.wait(1);
            orderTypeText.add(customerPage.customerOrderType.get(i).getText());
            Assert.assertTrue(customerPage.customerOrderType.get(i).isDisplayed());
            Assert.assertTrue(customerPage.customerOrderType.get(i).isEnabled());
            Assert.assertEquals(customerPage.customerOrderType.get(i).getText(),orderTypeText.get(i));

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

        //Click the "Check out" button
        customerPage.checkoutButton.click();
        ReusableMethods.wait(2);

        //TC1305
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait2(1);
        customerPage.cashOnDeliveryButton.click();
        customerPage.addCashButton.click();
        customerPage.placeOrderButtonText.isDisplayed();
        actions.click(customerPage.placeOrderButton).perform();
        ReusableMethods.wait2(1);
        String expectedText= "Confirming your order";
        String actualText = customerPage.confirmingText.getText();
        Assert.assertEquals(actualText,expectedText);

        Driver.quitDriver();

    }
}
