package tests;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.CustomerPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

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
   public void TC_0903(){


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

      Actions actions = new Actions ( Driver.getDriver () );

      action.sendKeys ( Keys.PAGE_DOWN).perform ();








      Driver.quitDriver ();


   }


   }

















