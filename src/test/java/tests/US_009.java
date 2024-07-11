package tests;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import pages.CustomerPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtilities;
import utilities.ReusableMethods;

import java.util.Set;

import static utilities.Driver.driver;

public class US_009 {

           CustomerPage customerPage = new CustomerPage ();

   @Test
   public void TC_0901(){

      Driver.getDriver ().get ( ConfigReader.getProperty ( "customer_Url" ) );

      customerPage.cookieAccept.click ();

      Actions action = new Actions ( Driver.getDriver () );

      action.sendKeys (Keys.END ).perform ();

      Assert.assertTrue ( customerPage.privacypolicyLink.isDisplayed () );

      Assert.assertTrue ( customerPage.privacypolicyLink.isEnabled () );

      ReusableMethods.wait ( 2 );

      customerPage.privacypolicyLink.click ();

      String expectedUrl = "https://qa.flavorfetch.com/privacy-policy";

      String actualUrl = Driver.getDriver ().getCurrentUrl ();

      Assert.assertEquals ( actualUrl, expectedUrl );

      Assert.assertTrue ( customerPage.PrivacyPolicySayfabaslik.isDisplayed () );

      Driver.quitDriver ();


   }

   @Test
   public void TC_0902(){

      Driver.getDriver ().get ( ConfigReader.getProperty ( "customer_Url" ) );

      customerPage.cookieAccept.click ();

      Actions action = new Actions ( Driver.getDriver () );

      action.sendKeys ( Keys.END ).perform ();

      Assert.assertTrue ( customerPage.privacypolicyLink.isDisplayed () );

      Assert.assertTrue ( customerPage.privacypolicyLink.isEnabled () );

      ReusableMethods.wait ( 2 );

      customerPage.privacypolicyLink.click ();

      String expectedUrl = "https://qa.flavorfetch.com/privacy-policy";

      String actualUrl = Driver.getDriver ().getCurrentUrl ();

      Assert.assertEquals ( actualUrl, expectedUrl );

      Assert.assertTrue ( customerPage.PrivacyPolicySayfabaslik.isDisplayed () );

      String expectedGizlilikMetinIcerik = "Privacy Policy,How We Use Your Information,Disclosure of Your Information,Security of Your Information";
      WebElement privacyPolicyContent = customerPage.PrivacyPolicySayfametni; //
      String actualGizlilikMetni = privacyPolicyContent.getText ();

      for (String keyword : expectedGizlilikMetinIcerik.split ( "," )) {
         Assert.assertTrue ( actualGizlilikMetni.contains ( keyword ) );

      }

      Driver.quitDriver ();


   }

   @Test
   public void TC_0903() {


      Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));

      customerPage.cookieAccept.click();

      Actions action = new Actions(Driver.getDriver());
      action.sendKeys(Keys.END).perform();

      Assert.assertTrue(customerPage.privacypolicyLink.isDisplayed());
      Assert.assertTrue(customerPage.privacypolicyLink.isEnabled());

      ReusableMethods.wait(2);

      customerPage.privacypolicyLink.click();

      String expectedUrl = "https://qa.flavorfetch.com/privacy-policy";
      String actualUrl = Driver.getDriver().getCurrentUrl();
      Assert.assertEquals(actualUrl, expectedUrl);

      Actions actions = new Actions(Driver.getDriver());
      actions.sendKeys(Keys.PAGE_DOWN).perform();

      WebElement contactLink = Driver.getDriver().findElement(By.xpath("//*[text()='info@flavorfetch.com']"));

      actions.moveToElement(contactLink).click().perform();

      // Eposta contact linkinin sayfayi eposta istemcisine yonledirdigini  dogrulayin

      String actualUrlPrivacy = driver.getCurrentUrl ();
      String expectedUrlPrivacy = "https://qa.flavorfetch.com/privacy-policy";

      Assert.assertNotEquals ( actualUrlPrivacy, expectedUrlPrivacy, "URL beklenen değere eşit olmamali");


      // E-posta linkinin tıklanabilir olduğunu doğrulayın

      Assert.assertTrue ( "E-posta linki görüntülenmiyor.", contactLink.isDisplayed() );
      Assert.assertTrue ( "E-posta linki etkin değil.", contactLink.isEnabled() );


      Driver.quitDriver();

   }

}
























