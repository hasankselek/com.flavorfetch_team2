package tests;

import org.testng.annotations.Test;
import pages.MerchantPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_032 {

    MerchantPage merchantPage=new MerchantPage();

    @Test
    public void TC_3201() {
        //merchant urlinin açılması
        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
        //oturum açmak için kullanıcı bilgilerinin girilmesi
        merchantPage.usernametextbox.sendKeys(ConfigReader.getProperty("merchant_username"));
        merchantPage.passwordtextbox.sendKeys(ConfigReader.getProperty("merchant_password"));
        //giriş yapabilmek için butana tıklanması
        merchantPage.singinButton.click();
        ReusableMethods.waitFor(3);
        //attributes dropdown menuye tıklanması
        merchantPage.attributesDropdownMenu.click();
        //size sayfasının açılması
        merchantPage.sizePage.click();
    }

    @Test
    public void TC_3202() {
        //merchant urlinin açılması
        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
        //oturum açmak için kullanıcı bilgilerinin girilmesi
        merchantPage.usernametextbox.sendKeys(ConfigReader.getProperty("merchant_username"));
        merchantPage.passwordtextbox.sendKeys(ConfigReader.getProperty("merchant_password"));
        //giriş yapabilmek için butana tıklanması
        merchantPage.singinButton.click();
        ReusableMethods.waitFor(3);
        //attributes dropdown menuye tıklanması
        merchantPage.attributesDropdownMenu.click();
        ReusableMethods.wait2(2);
        //size sayfasının açılması
        merchantPage.sizePage.click();
        ReusableMethods.wait2(2);
        //size ekleme saysasının açılması
        merchantPage.sizeAddButton.click();
        ReusableMethods.wait2(1);
        //size name textboxının doldurulması
        merchantPage.sizeNameTextbox.sendKeys("ice cream small");
        ReusableMethods.wait2(1);
        //kaydetme butonuna tıklanması
        merchantPage.settingSaveButton.click();
    }

    @Test
    public void TC_3203() {
        //merchant urlinin açılması
        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
        //oturum açmak için kullanıcı bilgilerinin girilmesi
        merchantPage.usernametextbox.sendKeys(ConfigReader.getProperty("merchant_username"));
        merchantPage.passwordtextbox.sendKeys(ConfigReader.getProperty("merchant_password"));
        //giriş yapabilmek için butana tıklanması
        merchantPage.singinButton.click();
        ReusableMethods.waitFor(3);
        //attributes dropdown menuye tıklanması
        merchantPage.attributesDropdownMenu.click();
        //size sayfasının açılması
        merchantPage.sizePage.click();
        ReusableMethods.waitFor(2);
        //düzenleme sayfasının açılması
        merchantPage.editButton.click();
        ReusableMethods.waitFor(1);
        //size name textboxının doldurulması
        merchantPage.sizeNameTextbox.sendKeys(" -medium");
        ReusableMethods.waitFor(1);
        //kaydetme butonuna tıklanması
        merchantPage.settingSaveButton.click();
    }

    @Test
    public void TC_3204() {
        //merchant urlinin açılması
        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
        //oturum açmak için kullanıcı bilgilerinin girilmesi
        merchantPage.usernametextbox.sendKeys(ConfigReader.getProperty("merchant_username"));
        merchantPage.passwordtextbox.sendKeys(ConfigReader.getProperty("merchant_password"));
        //giriş yapabilmek için butana tıklanması
        merchantPage.singinButton.click();
        ReusableMethods.waitFor(3);
        //attributes dropdown menuye tıklanması
        merchantPage.attributesDropdownMenu.click();
        //size sayfasının açılması
        merchantPage.sizePage.click();
        ReusableMethods.waitFor(2);
        //silme sayfasının açılması
        merchantPage.deleteButton.click();
        ReusableMethods.waitFor(1);
        //silme butonunun seçilmesi
        merchantPage.selectDelete.click();
    }
}
