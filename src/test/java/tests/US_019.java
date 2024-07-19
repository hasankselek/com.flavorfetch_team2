package tests;

import com.github.javafaker.Faker;
import org.bouncycastle.crypto.digests.Kangaroo;
import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MerchantLoginPage;
import pages.MerchantPage;
import utilities.*;

import java.io.IOException;

public class US_019 extends TestBaseRapor {

    MerchantLoginPage merchantLoginPage;
    //  WebDriverWait wait= (WebDriverWait) Driver.getDriver();
    Faker faker =new Faker();
    String fakerName = faker.name().fullName();
    String fakerPassword =faker.internet().password();

    @Test
    public void test_1901() {
        merchantLoginPage = new MerchantLoginPage();
    /*
    The user opens the browser.
    enters the Url.
    Verify correctness the url of page.
    Verify the presence of the "Merchant Login" text.
    The user closes the page.

     */
        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
        String exeptedUrl = ConfigReader.getProperty("merchant_Url");
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, exeptedUrl);
        Assert.assertTrue(merchantLoginPage.titleOfLoginPage.isDisplayed());
        Driver.quitDriver();
    }

    @Test
    public void test_1902() {
        merchantLoginPage = new MerchantLoginPage();
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
        Assert.assertTrue(merchantLoginPage.userBoxMerchantLogin.isDisplayed());
        Assert.assertTrue(merchantLoginPage.passwordBoxMerchantLogin.isDisplayed());
        Assert.assertTrue(merchantLoginPage.signInButtonMerchantLogin.isDisplayed());
        Driver.quitDriver();
    }

    @Test
    public void test_1903() {
        merchantLoginPage = new MerchantLoginPage();
        faker=new Faker();
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
        Assert.assertTrue(merchantLoginPage.backgroundUserBox.isDisplayed());
        merchantLoginPage.userBoxMerchantLogin.sendKeys(fakerName);

        Assert.assertTrue(merchantLoginPage.backgroundUserBox.isDisplayed());
        merchantLoginPage.userBoxMerchantLogin.sendKeys(Keys.CLEAR);

        String actualUserBoxInvolve = merchantLoginPage.userBoxMerchantLogin.getText();
        Assert.assertTrue(actualUserBoxInvolve.isEmpty());

        Assert.assertTrue(merchantLoginPage.backgroundPassBox.isDisplayed());
        merchantLoginPage.passwordBoxMerchantLogin.sendKeys(fakerPassword);
        System.out.println(merchantLoginPage.passwordBoxMerchantLogin.getText());
        Assert.assertTrue(merchantLoginPage.backgroundPassBox.isDisplayed());
        merchantLoginPage.passwordBoxMerchantLogin.sendKeys(Keys.CLEAR);

        String actualPassBoxInvolve = merchantLoginPage.passwordBoxMerchantLogin.getText();
        Assert.assertTrue(actualPassBoxInvolve.isEmpty());
        Driver.quitDriver();
    }

    @Test
    public void test_1904() throws IOException {
        merchantLoginPage = new MerchantLoginPage();
        faker=new Faker();
        fakerName=faker.name().fullName();
        fakerPassword=faker.internet().password();

        Driver.getDriver().get("about:blank");
        extentTest.info("The user opens the browser .");
        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
        extentTest.info("The user opens the URL");
        //  Verify the presence of the  "eye sign" in the password box.
        Assert.assertTrue(merchantLoginPage.eyeAsignInPasswordBox.isDisplayed());
        extentTest.pass("The user correctness visibility of the eye asign in password box .");
        // Enter a word inside the password box.
        merchantLoginPage.passwordBoxMerchantLogin.sendKeys(fakerPassword);
        extentTest.info("The user enters the faker password in password box .");
        // Verify the presence of the  "eye sign" in the password box.
        String expectedContent=fakerPassword;
        String actualContent=merchantLoginPage.passwordPlaceHolder.getText();
        Assert.assertEquals(actualContent,expectedContent);
        extentTest.pass("The user correctness equality of content of password box with entered password . ");
        // Verify the letters are shown by dotes.
        Assert.assertTrue(merchantLoginPage.passwordHidden.isDisplayed());
        extentTest.pass("The user correctness the password is hidden .");
        //  Click on the "eye sign".
        merchantLoginPage.eyeAsignInPasswordBox.click();
        extentTest.info("The user click the eye asign .");
        //  Verify the presence of the "Eye Sign With a Line On It" in the password box.
        Assert.assertTrue(merchantLoginPage.eyeAsignWithALine.isDisplayed());
        extentTest.pass("The user correctness the eye asign with a line on it is displayed.");
        // Verify visibility of the written letters .
        Assert.assertTrue(merchantLoginPage.passwordReveal.isDisplayed());
        extentTest.pass("The user correctness the password is reveal.");

        String expectedPass = fakerPassword;
        String actualPass =  JSUtilities.getTextWithJS(Driver.getDriver(),merchantLoginPage.passwordReveal);

       // System.out.println("facker pass: " + expectedPass);
        //System.out.println("The pass box content is :" + actualPass);

        Assert.assertEquals(actualPass, expectedPass);
        extentTest.pass("The user correctness equality of content of password box with entered password . ");
        Driver.quitDriver();
        extentTest.info("The user closes the browser .");
    }

    @Test
    public void test_1905() {
        merchantLoginPage = new MerchantLoginPage();
            /*
    The user opens the browser.
            Enters the URL.
    Verify the presence of the "App Store" icon.
            Click on the "App Store" icon.
            Verify the Url address contains "App Store" .
            The user closes the page.
             */
        Driver.getDriver().get("about:blank");
        extentTest.info("The user opens the browser .");

        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
        extentTest.info("The user opens the URL");

        Assert.assertTrue(merchantLoginPage.appStoreIcon.isDisplayed());
        extentTest.pass("The user correctness visibility of the AppStore icon.");

        merchantLoginPage.appStoreIcon.click();
        extentTest.info("The user click on the app store icon");

        String expectedUrlContent = ConfigReader.getProperty("urlContent1");
        String actualUrlContent = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrlContent.contains(expectedUrlContent));
        extentTest.pass("The user correctness existence of url content in current url .");
        Driver.quitDriver();
        extentTest.info("The user closes the browser .");
    }

    @Test
    public void test_1906() {
        merchantLoginPage = new MerchantLoginPage();

        Driver.getDriver().get("about:blank");
        extentTest.info("The user opens the browser .");

        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
        extentTest.info("The user opens the URL");

        Assert.assertTrue(merchantLoginPage.googlePlayIcon.isDisplayed());
        extentTest.pass("The user correctness visibility of googlePlay Icon .");

        merchantLoginPage.googlePlayIcon.click();
        extentTest.info("The user click on the googlePlayIcon .");

        String expectedUrlContent = ConfigReader.getProperty("urlContent2");
        String actualUrlContent = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrlContent.contains(expectedUrlContent));
        extentTest.pass("The user correctness existence of url content in current url .");

        Driver.quitDriver();
        extentTest.info("The user closes the browser .");
    }

    @Test
    public void test_1907() {
        merchantLoginPage = new MerchantLoginPage();

        Driver.getDriver().get("about:blank");
        extentTest.info("The user opens the browser .");

        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
        extentTest.info("The user opens the URL");

        Assert.assertTrue(merchantLoginPage.rememberMeLable.isDisplayed());
        extentTest.pass("The user correctness visibility of the rememberMeLable .");

        merchantLoginPage.userBoxMerchantLogin.sendKeys(ConfigReader.getProperty("merchant_username"));
        extentTest.info("The user enters the valid user name .");

        merchantLoginPage.passwordBoxMerchantLogin.sendKeys(ConfigReader.getProperty("merchant_password"));
        extentTest.info("The user enters the valid password.");

        merchantLoginPage.rememberMeLable.click();
        extentTest.info("The user click on the rememberMeLable");

        merchantLoginPage.signInButtonMerchantLogin.click();
        extentTest.info("The user click on the signIn ButtonMerchant Login");

        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(ConfigReader.getProperty("urlContent3")));
        extentTest.pass("The user correctness existence of url content in current url. ");

        merchantLoginPage.merchantNameDropdown.click();
        extentTest.info("The user click on the merchantNameDropdown");

        merchantLoginPage.logoutMerchantDashboard.click();
        extentTest.info("The user click on the logout button .");

        String exeptenceUrl = ConfigReader.getProperty("merchant_Url");
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, exeptenceUrl);
        extentTest.pass("The user correctness equality of url content by current url. ");

        Assert.assertTrue(merchantLoginPage.titleOfLoginPage.isDisplayed());
        extentTest.pass("The user correctness visibility of loginPage title .");

        merchantLoginPage.userBoxMerchantLogin.sendKeys(ConfigReader.getProperty("merchant_username"));
        extentTest.info("The user enters the valid user name in user box .");

        merchantLoginPage.passwordBoxMerchantLogin.sendKeys(Keys.ENTER);
        extentTest.info("The user enters into password box.");

        String expectedRememberPass = ConfigReader.getProperty("merchant_password");
        String actualRememberPass = merchantLoginPage.passwordBoxMerchantLogin.getText();
        Assert.assertEquals(actualRememberPass, expectedRememberPass);
        extentTest.pass("The user correctness equality of entered password and content of password box .");

        Driver.quitDriver();
        extentTest.info("The user closes the browser .");
    }

    @Test
    public void test_1908() {
        merchantLoginPage = new MerchantLoginPage();

        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
        Assert.assertTrue(merchantLoginPage.forgetMiLink.isDisplayed());
        merchantLoginPage.forgetMiLink.click();
        Assert.assertTrue(merchantLoginPage.RequestEmail.isDisplayed());
        Driver.quitDriver();
    }

    @Test
    public void test_1909() {
        merchantLoginPage = new MerchantLoginPage();


        Driver.getDriver().get("about:blank");
        extentTest.info("The user opens the browser .");

        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
        extentTest.info("The user opens the URL");

        Assert.assertTrue(merchantLoginPage.eyeAsignInPasswordBox.isDisplayed());
        extentTest.pass("The user correctness visibility of eye asig in password box");

        merchantLoginPage.signInButtonMerchantLogin.click();
        extentTest.info("The user click on the signIn Button");

        Assert.assertTrue(merchantLoginPage.user_ThisFieldIsRequired.isDisplayed());
        extentTest.pass("The user correctness visibility of ThisFieldIsRequired under the user name box .");

        Assert.assertTrue(merchantLoginPage.pass_ThisFieldIsRequired.isDisplayed());
        extentTest.pass("The user correctness visibility of ThisFieldIsRequired under the password box .");

        WebElement expectedEyePosition = merchantLoginPage.eyeAsignInPasswordBox;
        WebElement actualEyePosition = merchantLoginPage.eyeAsignFallDownPosition;
        Assert.assertEquals(actualEyePosition, expectedEyePosition);
        extentTest.pass("The user correctness equality of eye asign in first and end asign .");

        Driver.quitDriver();
        extentTest.info("The user closes the browser .");
    }

    @Test
    public void test_1910() {
        merchantLoginPage = new MerchantLoginPage();
        faker=new Faker();
        fakerName=faker.name().fullName();
        fakerPassword=faker.internet().password();

        Driver.getDriver().get("about:blank");
        extentTest.info("The user opens the browser .");

        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
        extentTest.info("The user opens the URL");

        merchantLoginPage.userBoxMerchantLogin.sendKeys(fakerName);
        extentTest.info("The user enteres a faker user name into username box .");

        merchantLoginPage.passwordBoxMerchantLogin.sendKeys(fakerPassword);
        extentTest.info("The user enteres a faker password into password box .");

        merchantLoginPage.signInButtonMerchantLogin.click();
        extentTest.info("The user click on the sign in button .");

        String expectedUrl = ConfigReader.getProperty("merchant_Url");
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertNotEquals(actualUrl, expectedUrl);
        extentTest.pass("The user correctness unequality of enterd url and current url .");

        Driver.quitDriver();
        extentTest.info("The user closes the browser .");

    }

    @Test
    public void test_1911() {
        merchantLoginPage = new MerchantLoginPage();
        faker=new Faker();
        fakerName=faker.name().fullName();
        fakerPassword=faker.internet().password();

        Driver.getDriver().get("about:blank");
        extentTest.info("The user opens the browser .");

        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
        extentTest.info("The user opens the URL");

        merchantLoginPage.userBoxMerchantLogin.sendKeys(fakerName);
        extentTest.info("The user enters a faker username into user box .");

        merchantLoginPage.passwordBoxMerchantLogin.sendKeys(ConfigReader.getProperty("merchant_password"));
        extentTest.info("The user enters the valid password .");

        merchantLoginPage.signInButtonMerchantLogin.click();
        extentTest.info("The user click on the sign in button .");

        String expectedUrlContains = ConfigReader.getProperty("urlContent4");
        String actualUrlContains = Driver.getDriver().getCurrentUrl();
        Assert.assertFalse(actualUrlContains.contains(expectedUrlContains));
        extentTest.pass("The user uncorrectness the enterd url with current url .");

        String expectedUserName = fakerName;
        String actualUserName = merchantLoginPage.userBoxMerchantLogin.getText();
        Assert.assertEquals(actualUserName, expectedUserName);
        extentTest.pass("The user correctness the equality of faker name and content of user name box .");

        String expectedPassword = ConfigReader.getProperty("merchant_password");
        String actualPassword = merchantLoginPage.passwordBoxMerchantLogin.getText();
        Assert.assertEquals(actualPassword, expectedPassword);
        extentTest.pass("The user correctness the equality of faker password and content of password box .");

        Driver.quitDriver();
        extentTest.info("The user closes the browser .");

    }

    @Test
    public void test_1912() {
        merchantLoginPage = new MerchantLoginPage();
        faker=new Faker();
        fakerName=faker.name().fullName();
        fakerPassword=faker.internet().password();

        Driver.getDriver().get("about:blank");
        extentTest.info("The user opens the browser .");

        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
        extentTest.info("The user opens the URL");

        merchantLoginPage.userBoxMerchantLogin.sendKeys(ConfigReader.getProperty("merchant_username"));
        extentTest.info("The user enteres the valid user name into username box .");

        merchantLoginPage.passwordBoxMerchantLogin.sendKeys(fakerPassword);
        extentTest.info("The user enteres a faker password into password box .");

        merchantLoginPage.signInButtonMerchantLogin.click();
        extentTest.info("The user click on the sign in button .");

        String expectedUrlContains = ConfigReader.getProperty("urlContent4");
        String actualUrlContains = Driver.getDriver().getCurrentUrl();
        Assert.assertFalse(actualUrlContains.contains(expectedUrlContains));
        extentTest.pass("The user uncorrectness the enterd url with current url .");

        String expectedUserName = ConfigReader.getProperty("merchant_username");
        String actualUserName = merchantLoginPage.userBoxMerchantLogin.getText();
        Assert.assertEquals(actualUserName, expectedUserName);
        extentTest.pass("The user correctness the equality of valid username and content of username box .");

        String expectedPassword = fakerPassword;
        String actualPassword = merchantLoginPage.passwordBoxMerchantLogin.getText();
        Assert.assertEquals(actualPassword, expectedPassword);
        extentTest.pass("The user correctness the equality of invalid password and content of password box .");

        Driver.quitDriver();
        extentTest.info("The user closes the browser .");
    }

    @Test
    public void test_1913() {
        merchantLoginPage = new MerchantLoginPage();
            /*
    The user opens the browser.
            enters the Url.
    enter the correct username in usename box
    enter the correct pssword in password box
    click the sign in button.
            Verify the url of entrance page contains "merchant/dashboard".
            The user closes the page.*/
        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
        merchantLoginPage.userBoxMerchantLogin.sendKeys(ConfigReader.getProperty("merchant_username"));
        merchantLoginPage.passwordBoxMerchantLogin.sendKeys(ConfigReader.getProperty("merchant_password"));
        merchantLoginPage.signInButtonMerchantLogin.click();
        String expectedUrlContain = ConfigReader.getProperty("urlContent3");
        String actualUrlContain = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrlContain.contains(expectedUrlContain));
        Driver.quitDriver();

    }
}
