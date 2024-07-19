package tests;

import org.testng.annotations.Test;
import pages.CustomerPage;
import pages.MerchantPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_024 {

    MerchantPage merchantPage=new MerchantPage();

    @Test
    public void TC_2401() {
        //merchant urlinin açılması
        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
        //oturum açmak için kullanıcı bilgilerinin girilmesi
        merchantPage.usernametextbox.sendKeys(ConfigReader.getProperty("merchant_username"));
        merchantPage.passwordtextbox.sendKeys(ConfigReader.getProperty("merchant_password"));
        //giriş yapabilmek için butana tıklanması
        merchantPage.singinButton.click();
        ReusableMethods.waitFor(3);
        //food dropdown menuye tıklanması
        merchantPage.foodDropdownMenu.click();
        ReusableMethods.waitFor(1);
        //category sayfasının listelenmesi
        merchantPage.category.click();
    }

    @Test
    public void TC_2402() {
        //merchant urlinin açılması
        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
        //oturum açmak için kullanıcı bilgilerinin girilmesi
        merchantPage.usernametextbox.sendKeys(ConfigReader.getProperty("merchant_username"));
        merchantPage.passwordtextbox.sendKeys(ConfigReader.getProperty("merchant_password"));
        //giriş yapabilmek için butana tıklanması
        merchantPage.singinButton.click();
        ReusableMethods.waitFor(3);
        //food dropdown menuye tıklanması
        merchantPage.foodDropdownMenu.click();
        ReusableMethods.waitFor(1);
        //category sayfasının listelenmesi
        merchantPage.category.click();
        ReusableMethods.waitFor(2);
        //category ekleme saysasının açılması
        merchantPage.categoryAddButton.click();
        ReusableMethods.waitFor(1);
        //category name textboxının doldurulması
        merchantPage.categoryNameTextbox.sendKeys("pide");
        //category description textboxının doldurulması
        merchantPage.descriptionTextbox.sendKeys("pide");
        ReusableMethods.waitFor(1);
        //resim seçmek için tıklanması
        merchantPage.imageButton.click();
        //resim seçimi yapılması
        merchantPage.imageSelect.click();
        //seçilen resmin eklenmesi
        ReusableMethods.waitFor(2);
        merchantPage.addImageButton.click();
        ReusableMethods.wait2(3);
        //kaydetme butonuna tıklanması
        merchantPage.settingSaveButton.click();

    }

    @Test
    public void TC_2403() {
        //merchant urlinin açılması
        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
        //oturum açmak için kullanıcı bilgilerinin girilmesi
        merchantPage.usernametextbox.sendKeys(ConfigReader.getProperty("merchant_username"));
        merchantPage.passwordtextbox.sendKeys(ConfigReader.getProperty("merchant_password"));
        //giriş yapabilmek için butana tıklanması
        merchantPage.singinButton.click();
        ReusableMethods.waitFor(3);
        //food dropdown menuye tıklanması
        merchantPage.foodDropdownMenu.click();
        ReusableMethods.waitFor(1);
        //category sayfasının listelenmesi
        merchantPage.category.click();
        ReusableMethods.waitFor(2);
        //düzenleme sayfasının açılması
        merchantPage.editButton.click();
        //category name textboxının doldurulması
        merchantPage.categoryNameTextbox.sendKeys(" kıymalı");
        ReusableMethods.wait2(1);
        //kaydetme butonuna tıklanması
        merchantPage.settingSaveButton.click();
    }

    @Test
    public void TC_2404() {
        //merchant urlinin açılması
        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
        //oturum açmak için kullanıcı bilgilerinin girilmesi
        merchantPage.usernametextbox.sendKeys(ConfigReader.getProperty("merchant_username"));
        merchantPage.passwordtextbox.sendKeys(ConfigReader.getProperty("merchant_password"));
        //giriş yapabilmek için butana tıklanması
        merchantPage.singinButton.click();
        ReusableMethods.waitFor(3);
        //food dropdown menuye tıklanması
        merchantPage.foodDropdownMenu.click();
        ReusableMethods.waitFor(1);
        //category sayfasının listelenmesi
        merchantPage.category.click();
        ReusableMethods.waitFor(2);
        //düzenleme sayfasının açılması
        merchantPage.deleteButton.click();
        ReusableMethods.waitFor(1);
        //silme butonunun seçilmesi
        merchantPage.selectDelete.click();
    }
}
