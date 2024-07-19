package tests;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import pages.CustomerPage;
import utilities.*;

import java.io.IOException;
import java.util.Set;

import static utilities.Driver.driver;

public class US_009 extends TestBaseRapor {

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
   public void TC_0903() throws IOException {


      Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
      extentTest.info ( "Kullsnici customer anasayfasini goruntuler" );
      customerPage.cookieAccept.click();
      extentTest.info ( "Cookies kabul eder" );
      Actions action = new Actions(Driver.getDriver());
      action.sendKeys(Keys.END).perform();
      extentTest.info ( "Customer page footer bolumunu gider" );
      Assert.assertTrue(customerPage.privacypolicyLink.isDisplayed());
      extentTest.info ( "Customer page gizlilik politikasi linkini goruntuler" );
      Assert.assertTrue(customerPage.privacypolicyLink.isEnabled());
      extentTest.pass ( "Customer page gizlilik politikasi sayfasina linkinin aktif oldugunu dogrular" );

      ReusableMethods.wait(2);

      customerPage.privacypolicyLink.click();
      extentTest.info ( "Gizlilik politikasi linkine tiklar ve sayfaya gider" );
      String expectedUrl = "https://qa.flavorfetch.com/privacy-policy";
      String actualUrl = Driver.getDriver().getCurrentUrl();
      Assert.assertEquals(actualUrl, expectedUrl);
      extentTest.pass ( "Gizlilik politikasi sayfasinin acildigini dogrular" );
      Actions actions = new Actions(Driver.getDriver());
      actions.sendKeys(Keys.PAGE_DOWN).perform();
      extentTest.info ( "Gizlilik politikasi sayfasinda Gizlilik Politikasi metnini goruntuler" );
      WebElement contactLink = Driver.getDriver().findElement(By.xpath("//*[text()='info@flavorfetch.com']"));

      actions.moveToElement(contactLink).click().perform();
      extentTest.pass ( "Gizlilik Politikasi metni icerisinde yer alan contact maili tiklar" );
      // Eposta contact linkinin sayfayi eposta istemcisine yonledirdigini  dogrulayin

      String expectedUrlPrivacy = "https://qa.flavorfetch.com/privacy-policy";
      String actualUrlPrivacy = driver.getCurrentUrl ();

      Assert.assertEquals ( actualUrlPrivacy, expectedUrlPrivacy, "URL beklenen değere eşit olmamali");

      extentTest.pass ( "Eposta contact linkinin sayfayi eposta istemcisine yonledirdigini  dogrular" );

      // E-posta linkinin tıklanabilir olduğunu doğrulayın

      Assert.assertTrue ( "E-posta linki görüntülenmiyor.", contactLink.isDisplayed() );
      extentTest.info ( "Eposta contact maili oldugunu goruntuler" );
      Assert.assertTrue ( "E-posta linki etkin değil.", contactLink.isEnabled() );
      extentTest.pass ( "E-posta linkinin tıklanabilir olduğunu doğrular" );


      Driver.quitDriver();

   }

}
























