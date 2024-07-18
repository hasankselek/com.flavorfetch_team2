package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomerPage;
import pages.MerchantLoginPage;
import pages.MerchantPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_010 {
    MerchantPage merchantPage = new MerchantPage();
    CustomerPage customerPage = new CustomerPage();
    Actions actions = new Actions(Driver.getDriver());
    Faker faker = new Faker();
    String fakerFirstName = faker.name().firstName();
    String fakerLastName = faker.name().lastName();
    String fakeUserName = faker.name().username();
    String fakerPassword = faker.internet().password();
    String fakeremailAdress = faker.internet().emailAddress();




    @Test
    public void TC1001(){
        customerPage = new CustomerPage();
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Assert.assertTrue(customerPage.joinButton.isDisplayed());
        customerPage.joinButton.click();
        String expectedUrl = "https://qa.flavorfetch.com/merchant/signup";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        Assert.assertTrue(customerPage.merchantBecameYazi.isDisplayed());
        Assert.assertTrue(customerPage.GetSalesYazi.isDisplayed());
        Assert.assertTrue(customerPage.storeText.isDisplayed());
        Assert.assertTrue(customerPage.storeAdress.isDisplayed());
        Assert.assertTrue(customerPage.storeMail.isDisplayed());
        ReusableMethods.wait(3);
        Assert.assertTrue(customerPage.CommissionButon.isDisplayed());
        Assert.assertTrue(customerPage.PrivacyButton.isDisplayed());
        Assert.assertTrue(customerPage.submitFormButton.isDisplayed());
        Assert.assertTrue(customerPage.termsAndConditions.isDisplayed());
        Assert.assertTrue(customerPage.privacyPolicyLink.isDisplayed());
        Assert.assertTrue(customerPage.loginHereLink.isDisplayed());
        Driver.quitDriver();


    }
    @Test
    public void TC1002(){
        customerPage = new CustomerPage();
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Assert.assertTrue(customerPage.joinButton.isDisplayed());
        customerPage.joinButton.click();
        ReusableMethods.windowaGec("https://qa.flavorfetch.com/merchant/signup",Driver.getDriver());
        customerPage.storeText.sendKeys(fakerFirstName + fakerLastName);
        customerPage.storeMail.sendKeys(fakeremailAdress);
        customerPage.storeAdress.sendKeys("New York");
        ReusableMethods.wait(3);
        customerPage.chooseAddressField.click();
        ReusableMethods.wait(3);
        customerPage.chooseAddressField.click();
        ReusableMethods.wait(3);
        customerPage.StorePhoneNumber.sendKeys("2222222222");
        Assert.assertTrue(customerPage.CommissionButon.isEnabled());
        ReusableMethods.wait(3);
        customerPage.CommissionButon.click();
        ReusableMethods.wait(8);
        Assert.assertTrue(customerPage.submitFormButton.isEnabled());
        ReusableMethods.wait(10);
        customerPage.privacyPolicyLink.click();
        String expectedUrl = "https://qa.flavorfetch.com/merchant/signup";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertNotEquals(expectedUrl,actualUrl);
        Driver.quitDriver();




    }
    @Test
    public void TC1003(){
        customerPage = new CustomerPage();
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Assert.assertTrue(customerPage.joinButton.isDisplayed());
        customerPage.joinButton.click();
        ReusableMethods.windowaGec("https://qa.flavorfetch.com/merchant/signup",Driver.getDriver());
        customerPage.storeText.sendKeys(fakerFirstName + fakerLastName);
        customerPage.storeMail.sendKeys(fakeremailAdress);
        customerPage.storeAdress.sendKeys("New York");
        ReusableMethods.wait(3);
        customerPage.chooseAddressField.click();
        ReusableMethods.wait(3);
        customerPage.chooseAddressField.click();
        ReusableMethods.wait(3);
        customerPage.StorePhoneNumber.sendKeys("2222222222");
        Assert.assertTrue(customerPage.CommissionButon.isEnabled());
        ReusableMethods.wait(3);
        customerPage.CommissionButon.click();
        ReusableMethods.wait(8);
        Assert.assertTrue(customerPage.submitFormButton.isEnabled());
        customerPage.submitFormButton.click();
        ReusableMethods.windowaGec("https://qa.flavorfetch.com/merchant/user-signup/?uuid=365157e9-4544-11ef-8af1-3a396e7b202d",Driver.getDriver());
        customerPage.registerFirstName.sendKeys(fakerFirstName);
        customerPage.registerLastName.sendKeys(fakerLastName);
        customerPage.registerEmail.sendKeys(fakeremailAdress);
        customerPage.StorePhoneNumber.sendKeys("222222222");
        customerPage.registerUsername.sendKeys(fakeUserName);
        customerPage.registerPassword.sendKeys(fakerPassword);
        customerPage.registerConfirmPassword.sendKeys(fakerPassword);
        customerPage.termsAndConditions.click();
        String expectedUrl = "https://qa.flavorfetch.com/merchant/user-signup/?uuid=365157e9-4544-11ef-8af1-3a396e7b202d";
        String actualUl = Driver.getDriver().getCurrentUrl();
        Assert.assertNotEquals(expectedUrl,actualUl);
        Driver.quitDriver();



    }
}
