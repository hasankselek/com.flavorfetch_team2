package tests;

import com.github.javafaker.Faker;
import org.bouncycastle.crypto.digests.Kangaroo;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MerchantPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_019 {

        MerchantPage merchantPage=new MerchantPage();
      //  WebDriverWait wait= (WebDriverWait) Driver.getDriver();
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
Driver.quitDriver();
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
    Driver.quitDriver();
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
    Driver.quitDriver();
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
    Assert.assertTrue(merchantPage.eyeAsignInPasswordBox.isDisplayed());
merchantPage.passwordtextbox.sendKeys(fakerPassword);
Assert.assertTrue(merchantPage.eyeAsignInPasswordBox.isDisplayed());
Assert.assertTrue(merchantPage.passwordHidden.isDisplayed());
merchantPage.eyeAsignInPasswordBox.click();
Assert.assertTrue(merchantPage.eyeAsignWithALine.isDisplayed());
Assert.assertTrue(merchantPage.passwordReveal.isDisplayed());

    String expectedPass=fakerPassword;
    String actualPass=merchantPage.passwordtextbox.getText();

    System.out.println("facker pass: "+expectedPass);
    System.out.println("The pass box content is :"+actualPass);

    Assert.assertEquals(actualPass,expectedPass);
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
        String exeptenceUrl=ConfigReader.getProperty("merchant_Url");
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl,exeptenceUrl);
        Assert.assertTrue(merchantPage.titleOfLoginPage.isDisplayed());
        merchantPage.usernametextbox.sendKeys(ConfigReader.getProperty("merchant_username"));
        merchantPage.passwordtextbox.sendKeys(Keys.ENTER);
        String expectedRememberPass=ConfigReader.getProperty("merchant_password");
        String actualRememberPass=merchantPage.passwordtextbox.getText();
        Assert.assertEquals(actualRememberPass,expectedRememberPass);
Driver.quitDriver();
}
@Test
    public void test_1908(){
/*The user opens the browser.
enters the Url.
Verify the presence of the "forget password?" text .
click the link of 'forget password?".
Verify the presence of the  "Request E-mail"button.
The user closes the page.*/
    Driver.getDriver().get("about:blank");
    Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
    Assert.assertTrue(merchantPage.forgetMiLink.isDisplayed());
    merchantPage.forgetMiLink.click();
    Assert.assertTrue(merchantPage.RequestEmail.isDisplayed());
    Driver.quitDriver();
}
@Test
    public void test_1909(){
/*The user opens the browser.
enters the Url.
click the signin button.
Verify the presence of the"This field is required" text under username box.

Verify the presence of the "This field is required" text under password box.

Verify position stability of the eye sign .
The user closes the page.*/
    Driver.getDriver().get("about:blank");
    Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
    Assert.assertTrue(merchantPage.eyeAsignInPasswordBox.isDisplayed());
    ReusableMethods.wait(2);
    merchantPage.singinButton.click();
    Assert.assertTrue(merchantPage.user_ThisFieldIsRequired.isDisplayed());
    Assert.assertTrue(merchantPage.pass_ThisFieldIsRequired.isDisplayed());
    ReusableMethods.wait(2);
    WebElement expectedEyePosition= merchantPage.eyeAsignInPasswordBox;
    WebElement actualEyePosition= merchantPage.eyeAsignFallDownPosition;
    ReusableMethods.wait(2);
    Assert.assertNotEquals(actualEyePosition,expectedEyePosition);
    Driver.quitDriver();
}
}