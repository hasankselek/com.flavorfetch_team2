package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomerPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_005 {

    //As a user, I want to be able to login with my email and password information that I registered on the site.

    static CustomerPage customerPage = new CustomerPage();

    @Test
    public void TC_0501 (){

        customerPage = new CustomerPage();
        //Kullanici browseri acar
        //Url'I girer
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
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
        //Sayfayi kapatir
        Driver.quitDriver();


    } // Test of "Email","Password","Forgot password?", "Remember me"  and "Sign Up" fields --> PASSED

    @Test
    public void TC_0502 (){
        customerPage = new CustomerPage();
        //Kullanici browseri acar
        //Url'I girer
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        //Anasayfa header bolumundeki 'Sign in' butonuna tiklar
        customerPage.signInButton.click();
        //Email/telefon numarasi alanina dogru emaili girer
        customerPage.emailBox.sendKeys(ConfigReader.getProperty("customeruser_gulpembe"));
        //Password alanina dogru passwordu girer
        customerPage.passwordBox.sendKeys(ConfigReader.getProperty("customerpassword_gulpembe"));
        //Sign in butonuna tiklar ve basarili giris yapabildigini dogrular
        customerPage.loginSigninButton.click();
        Assert.assertTrue(customerPage.notificicationsButton.isDisplayed());
        //Hesaptan cikis yapar
        customerPage.profileDropdownMenu.click();
        customerPage.logoutButton.click();
        //Sayfayi kapatir
        Driver.quitDriver();



    } // Test of successful logging in with the correct email and correct password --> PASSED

    @Test
    public void TC_0503 (){
        customerPage = new CustomerPage();
        //Kullanici browseri acar
        //Url'I girer
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        //Anasayfa header bolumundeki 'Sign in' butonuna tiklar
        customerPage.signInButton.click();
        //Email/telefon numarasi alanina dogru telefon numarasini girer
        customerPage.emailBox.sendKeys(ConfigReader.getProperty("phoneNumber_gulpembe"));
        //Password alanina dogru passwordu girer
        customerPage.passwordBox.sendKeys(ConfigReader.getProperty("customerpassword_gulpembe"));
        //Sign in butonuna tiklar ve basarili giris yapabildigini dogrular
        customerPage.loginSigninButton.click();
        Assert.assertTrue(customerPage.notificicationsButton.isDisplayed());
        //Hesaptan cikis yapar
        customerPage.profileDropdownMenu.click();
        customerPage.logoutButton.click();
        //Sayfayi kapatir
        Driver.quitDriver();


    } // Test of successful logging in with the correct phone number and correct password --> PASSED

    @Test
    public void TC_0504 (){
        customerPage = new CustomerPage();

        //Kullanici browseri acar
        //Url'I girer
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        //Anasayfa header bolumundeki 'Sign in' butonuna tiklar
        customerPage.signInButton.click();
        //Email/telefon numarasi alanina hatali email girer
        customerPage.emailBox.sendKeys(ConfigReader.getProperty("incorrectCustomeruser_gulpembe"));
        //Password alanina dogru passwordu girer
        customerPage.passwordBox.sendKeys(ConfigReader.getProperty("customerpassword_gulpembe"));
        //Sign in butonuna tiklar ve basarili giris yapilamadigini dogrular
        customerPage.loginSigninButton.click();
        Assert.assertTrue(customerPage.loginAlert.isDisplayed());
        //Sayfayi kapatir
        Driver.quitDriver();


    } // Test of unsuccessful logging in with the incorrect email and correct password --> PASSED

    @Test
    public void TC_0505 (){
        customerPage = new CustomerPage();
        //Kullanici browseri acar
        //Url'I girer
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        //Anasayfa header bolumundeki 'Sign in' butonuna tiklar
        customerPage.signInButton.click();
        //Email/telefon numarasi alanina dogru emaili girer
        customerPage.emailBox.sendKeys(ConfigReader.getProperty("customeruser_gulpembe"));
        //Password alanina hatali password girer
        customerPage.passwordBox.sendKeys(ConfigReader.getProperty("incorrectCustomerpassword_gulpembe"));
        //Sign in butonuna tiklar ve basarili giris yapilamadigini dogrular
        customerPage.loginSigninButton.click();
        Assert.assertTrue(customerPage.loginAlert.isDisplayed());
        //Sayfayi kapatir
        Driver.quitDriver();



    } // Test of unsuccessful logging in with the correct email and incorrect password --> PASSED


}
