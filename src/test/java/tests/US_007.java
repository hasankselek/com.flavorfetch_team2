package tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomerPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;


public class US_007 extends TestBaseRapor {

    // As a visitor, I would like to have a contact page on the site so that I can communicate with the site administrators that I shop with.

    static CustomerPage customerPage;
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void TC_0701 (){

        customerPage = new CustomerPage();
        actions = new Actions(Driver.getDriver());
        //Kullanici browseri acar
        //Url'I girer
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        //Anasayfa footer bolumune kadar page down yapar
        customerPage.cookieAccept.click();
        actions.moveToElement(customerPage.contactUsLink).perform();
        //Contact us' link baglantisina tiklar
        customerPage.contactUsLink.click();
        //Acilan sayfada sitenin telefon numarasinin gorundugunu dogrular
        Assert.assertTrue(customerPage.contactSiteNumber.isDisplayed());
        //Telefon numarasinin erisilebilir oldugunu dogrular
        Assert.assertTrue(customerPage.contactSiteNumber.isEnabled());
        //Sitenin emailinin gorundugunu dogrular
        Assert.assertTrue(customerPage.contactSiteMail.isDisplayed());
        //Emailin erisilebilir oldugunu dogrular
        Assert.assertTrue(customerPage.contactSiteMail.isEnabled());
        //Sayfayi kapatir
        Driver.quitDriver();

    } // Test of display on site's own Email and phone number information and redirect to related links --> PASSED

    @Test
    public void TC_0702 (){
        customerPage = new CustomerPage();
        actions = new Actions(Driver.getDriver());
        //extentTest=extentReports.createTest("TC_0702" , "Test of customer name, customer email, customer message fields and  image section.");
        //Kullanici browseri acar
        //Url'I girer
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        extentTest.info("Kullanici browseri acar , url ' i girer");
        //Anasayfa footer bolumune kadar page down yapar
        //customerPage.cookieAccept.click();
        actions.moveToElement(customerPage.contactUsLink).perform();
        ReusableMethods.wait(2);
        extentTest.info("Anasayfa footer bolumune kadar page down yapar");
        //Contact us' link baglantisina tiklar
        customerPage.contactUsLink.click();
        extentTest.info("Contact us' link baglantisina tiklar");
        //Acilan sayfada isim yazabilmek icin bir box oldugunu dogrular
        Assert.assertTrue(customerPage.contactNameBox.isDisplayed());
        extentTest.pass("Acilan sayfada isim yazabilmek icin bir box oldugunu dogrular");
        //Isim yazma alaninin zorunlu alan oldugunu dogrular
        Assert.assertTrue(customerPage.contactNameBox.getAccessibleName().contains("*"));
        extentTest.pass("Isim yazma alaninin zorunlu alan oldugunu dogrular");
        //Sayfada email yazabilmek icin bir box oldugunu dogrular
        Assert.assertTrue(customerPage.contactMailBox.isDisplayed());
        extentTest.pass("Sayfada email yazabilmek icin bir box oldugunu dogrular");
        //Email yazma alaninin zorunlu alan oldugunu dogrular
        Assert.assertTrue(customerPage.contactMailBox.getAccessibleName().contains("*"));
        extentTest.pass("Email yazma alaninin zorunlu alan oldugunu dogrular");
        //Mesaj yazabilmek icin bir box oldugunu dogrular
        Assert.assertTrue(customerPage.contactMessageBox.isDisplayed());
        extentTest.pass("Mesaj yazabilmek icin bir box oldugunu dogrular");
        //Mesaj alaninin zorunlu oldugunu dogrular
        Assert.assertTrue(customerPage.contactMessageBox.getAccessibleName().contains("*"));
        extentTest.pass("Mesaj alaninin zorunlu oldugunu dogrular");
        //Contact ile alakali bir resim gorundugunu dogrular
        Assert.assertTrue(customerPage.contactImage.isDisplayed());
        extentTest.pass("Contact ile alakali bir resim gorundugunu dogrular");
        //Sayfayi kapatir
        Driver.quitDriver();
        extentTest.info("Sayfayi kapatir");

    } // Test of customer name, customer email, customer message fields and  image section. --> FAILED

    @Test
    public void TC_0703 (){
        customerPage = new CustomerPage();
        actions = new Actions(Driver.getDriver());
        //Kullanici browseri acar
        //Url'I girer
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        //Anasayfa footer bolumune kadar page down yapar
        //customerPage.cookieAccept.click();
        actions.moveToElement(customerPage.contactUsLink).perform();
        ReusableMethods.wait(2);
        //Contact us' link baglantisina tiklar
        customerPage.contactUsLink.click();
        //Acilan sayfada isim alanini dogru ve eksiksiz bilgilerle doldurur
        customerPage.contactNameBox.sendKeys(ConfigReader.getProperty("contactName_gulpembe"));
        //Email alanini dogru ve eksiksiz bilgilerle doldurur
        customerPage.contactMailBox.sendKeys(ConfigReader.getProperty("customeruser_gulpembe"));
        //Mesaj alanini doldurur
        customerPage.contactMessageBox.sendKeys(ConfigReader.getProperty("contactMessage"));
        //Formu submit eder
        customerPage.submitFormButton.click();
        //Basarili bir sekilde submit edebildigini dogrular
        Assert.assertTrue(customerPage.requestSentText.isDisplayed());
        //Sayfayi kapatir
        Driver.quitDriver();

    } // Test of successful submit with correct name and correct formatted email --> PASSED

    @Test
    public void TC_0704 (){
        customerPage = new CustomerPage();
        actions = new Actions(Driver.getDriver());
        //Kullanici browseri acar
        //Url'I girer
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        //Anasayfa footer bolumune kadar page down yapar
        //customerPage.cookieAccept.click()
        actions.moveToElement(customerPage.contactUsLink).perform();
        ReusableMethods.wait(2);
        //Contact us' link baglantisina tiklar
        customerPage.contactUsLink.click();
        //Acilan sayfada isim alanini dogru ve eksiksiz bilgilerle doldurur
        customerPage.contactNameBox.sendKeys(ConfigReader.getProperty("contactName_gulpembe"));
        //Email alanini hatali bilgilerle doldurur
        customerPage.contactMailBox.sendKeys(ConfigReader.getProperty("incorrectCustomeruser_gulpembe"));
        //Mesaj alanini doldurur
        customerPage.contactMessageBox.sendKeys(ConfigReader.getProperty("contactMessage"));
        //Formu submit eder
        customerPage.submitFormButton.click();
        //Basarili bir sekilde submit edemedigini dogrular
        Assert.assertTrue(customerPage.invalidEmailText.isDisplayed());
        //Sayfayi kapatir
        Driver.quitDriver();

    } // Test of unsuccessful submit with correct name and incorrect formatted email --> PASSED

    @Test
    public void TC_0705 (){
        customerPage = new CustomerPage();
        actions = new Actions(Driver.getDriver());
        //extentTest=extentReports.createTest("TC_0705","Test of unsuccessful submit with empty message");
        //Kullanici browseri acar
        //Url'I girer
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        extentTest.info("Kullanici browseri acar , url ' i girer");
        //Anasayfa footer bolumune kadar page down yapar
        actions.moveToElement(customerPage.contactUsLink).perform();
        ReusableMethods.wait(2);
        extentTest.info("Anasayfa footer bolumune kadar page down yapar");
        //Contact us' link baglantisina tiklar
        customerPage.contactUsLink.click();
        extentTest.info("Contact us' link baglantisina tiklar");
        //Acilan sayfada isim alanini dogru ve eksiksiz bilgilerle doldurur
        customerPage.contactNameBox.sendKeys(ConfigReader.getProperty("contactName_gulpembe"));
        extentTest.info("Acilan sayfada isim alanini dogru ve eksiksiz bilgilerle doldurur");
        //Email alanini dogru ve eksiksiz bilgilerle doldurur
        customerPage.contactMailBox.sendKeys(ConfigReader.getProperty("customeruser_gulpembe"));
        extentTest.info("Email alanini dogru ve eksiksiz bilgilerle doldurur");
        //Formu submit eder
        customerPage.submitFormButton.click();
        extentTest.info("Formu submit eder");
        //Basarili bir sekilde submit edemedigini dogrular
        Assert.assertFalse(customerPage.requestSentText.isDisplayed());
        extentTest.pass("Basarili bir sekilde submit edemedigini dogrular");
        //Sayfayi kapatir
        Driver.quitDriver();
        extentTest.info("Sayfayi kapatir");

    } // Test of unsuccessful submit with empty message --> FAILED













}












