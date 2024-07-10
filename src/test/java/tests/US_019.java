package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MerchantPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_019 {

        MerchantPage merchantPage=new MerchantPage();
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
Assert.assertTrue(merchantPage.eyeAsignInPasswordBox.isDisplayed());
merchantPage.textEnteredUserBox.sendKeys(fakerPassword);
Assert.assertTrue(merchantPage.eyeAsignInPasswordBox.isDisplayed());

}
}