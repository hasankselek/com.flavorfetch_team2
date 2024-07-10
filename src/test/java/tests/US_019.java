package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MerchantPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_019 {

        MerchantPage merchantPage=new MerchantPage();
        WebDriverWait wait= (WebDriverWait) Driver.getDriver();
        Faker faker=new Faker();
        String fakerName=faker.name().fullName();
        String fakerPassword=faker.internet().password();

        @Test
        public void test_1901() {
    /*
    The user opens the browser.
    enters the Url.
    Verify correctness the url of page.
    Verify the presence of the "Merchant Login" text.
    The user closes the page.

     */
        Driver.getDriver().get("about:blank");
Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
    String exeptedUrl=ConfigReader.getProperty("merchant_Url");
    String actualUrl=Driver.getDriver().getCurrentUrl();
Assert.assertEquals(actualUrl,exeptedUrl);
Assert.assertTrue(merchantPage.titleOfLoginPage.isDisplayed());
}
@Test
public void test_1902(){
/*
        The user opens the browser.
        Enters the URL.
        Verify the presence of the username box.
        Verify the presence of the password box.
        Verify the presence of the signin button.
        The user closes the page.

 */

    Driver.getDriver().get("about:blank");
    Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
    Assert.assertTrue(merchantPage.usernametextbox.isDisplayed());
    Assert.assertTrue(merchantPage.passwordtextbox.isDisplayed());
    Assert.assertTrue(merchantPage.singinButton.isDisplayed());
}
@Test
    public void test_1903() {
/*The user opens the browser.
Enters the URL.
Verify the presence of the "Username" text in the username box background.

enter a text in the username box.
Verify the presence of the "Username" text in the username box background.

Delete the written letters from the username box.
Verify absence the written lettrs from the username box.
Verify the presence of the "Passweord" text in the password box in the background.

enter a text in the password box
Verify the presence of the "Password" text in the password box in the background.

Delete the written letters from the password box.
Verify absence the written lettrs from the password box.
The user closes the page.*/
    Driver.getDriver().get("about:blank");
    Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
    Assert.assertTrue(merchantPage.backgroundUserBox.isDisplayed());
    merchantPage.usernametextbox.sendKeys(fakerName);
    Assert.assertTrue(merchantPage.backgroundUserBox.isDisplayed());
    merchantPage.usernametextbox.sendKeys(fakerName+Keys.CLEAR);
    String expectedUserBoxInvolve="";
    String actualUserBoxInvolve= merchantPage.usernametextbox.getText();
    Assert.assertEquals(actualUserBoxInvolve,expectedUserBoxInvolve);

    Assert.assertTrue(merchantPage.backgroundPassBox.isDisplayed());
    merchantPage.passwordtextbox.sendKeys(fakerPassword);
    Assert.assertTrue(merchantPage.backgroundPassBox.isDisplayed());
    merchantPage.passwordtextbox.sendKeys(fakerPassword+Keys.CLEAR);
    String expectedPassBoxInvolve="";
    String actualPassBoxInvolve= merchantPage.passwordtextbox.getText();
    Assert.assertEquals(actualPassBoxInvolve,expectedPassBoxInvolve);

}
@Test
    public void test_1904(){
            /*
    The user opens the browser.
    enters the Url.
    Verify the presence of the  "eye sign" in the password box.
    Enter a word inside the password box.
    Verify the presence of the  "eye sign" in the password box.
    Verify the letters are shown by dotes.
    Click on the "eye sign".
    Verify the presence of the "Eye Sign With a Line On It" in the password box.
    Verify visibility of the written letters .
    The user closes the page.
             */
    Driver.getDriver().get("about:blank");
    Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
    wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("merchant_Url")));
    Assert.assertTrue(merchantPage.eyeAsignInPasswordBox.isDisplayed());
    wait.until(ExpectedConditions.visibilityOf(merchantPage.passwordFieldPassBox));
merchantPage.textEnteredUserBox.sendKeys(fakerPassword);

Assert.assertTrue(merchantPage.eyeAsignInPasswordBox.isDisplayed());
Assert.assertTrue(merchantPage.passwordReveal.isDisplayed());
Driver.quitDriver();
}
@Test
    public void test_1905(){
            /*
    The user opens the browser.
            Enters the URL.
    Verify the presence of the "App Store" icon.
            Click on the "App Store" icon.
            Verify the Url address contains "App Store" .
            The user closes the page.
             */
    Driver.getDriver().get("about:blank");
    Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
    Assert.assertTrue(merchantPage.appStoreIcon.isDisplayed());
    merchantPage.appStoreIcon.click();
    Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(ConfigReader.getProperty("urlContent1")));
    Driver.quitDriver();
}
@Test
    public void test_1906(){
    Driver.getDriver().get("about:blank");
    Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
    Assert.assertTrue(merchantPage.googlePlayIcon.isDisplayed());
    merchantPage.googlePlayIcon.click();
    Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(ConfigReader.getProperty("urlContent2")));
    Driver.quitDriver();
}
@Test
    public void test_1907(){/*
    The user opens the browser.
            Enters the Url.
    Verify the presence of the "Remember me" text .
            enter the correct username in usename box
    enter the correct pssword in password box
    click the radio box of "Remember me".
            click the "sign in" button.
            Verify the url of entrance page contains "merchant/dashboard".
            Click merchant name dropdown .
            Click the "log out" item the secound index from this dropdown.
            Verify the url is equal to first url.
            Verify the presence of the "Merchant Login" text.
            enter the correct username in usename box
    Verify the presence of the  correct password in the box.
    The user closes the page.*/
        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
        Assert.assertTrue(merchantPage.rememberMeLable.isDisplayed());
        merchantPage.usernametextbox.sendKeys(ConfigReader.getProperty("merchant_username"));
        merchantPage.passwordtextbox.sendKeys(ConfigReader.getProperty("merchant_password"));
        merchantPage.rememberMeLable.click();
        merchantPage.singinButton.click();
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(ConfigReader.getProperty("urlContent3")));
        merchantPage.merchantNameDropdown.click();
        merchantPage.logoutMerchantDashboard.click();

}
}