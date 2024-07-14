package tests;

import org.testng.annotations.Test;
import pages.CustomerPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_017 {

    CustomerPage customerPage = new CustomerPage();

    @Test
    public void TC_1701() {

        //kullanıcı urlinin açılması
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        //oturum açma sayfasının açılması için butona tıklanması
        customerPage.signInButton.click();
        //kullanıcı bilgilerinin girilmesi
        customerPage.emailBox.sendKeys(ConfigReader.getProperty("customeruser_ali"));
        customerPage.passwordBox.sendKeys(ConfigReader.getProperty("customerpassword_ali"));
        //giriş yapmak için butona tıklanması
        customerPage.loginSigninButton.click();
        ReusableMethods.waitFor(3);
        //profil dropdownının açılması
        customerPage.profileDropdownMenu.click();
        ReusableMethods.waitFor(3);
        //ödeme sayfasının görüntülenmesi için ödemeye tıklanması
        customerPage.paymentsOptions.click();
        ReusableMethods.waitFor(3);
    }

    @Test
    public void TC_1702() {

        //kullanıcı urlinin açılması
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        //oturum açma sayfasının açılması için butona tıklanması
        customerPage.signInButton.click();
        //kullanıcı bilgilerinin girilmesi
        customerPage.emailBox.sendKeys(ConfigReader.getProperty("customeruser_ali"));
        customerPage.passwordBox.sendKeys(ConfigReader.getProperty("customerpassword_ali"));
        //giriş yapmak için butona tıklanması
        customerPage.loginSigninButton.click();
        ReusableMethods.waitFor(3);
        //profil dropdownının açılması
        customerPage.profileDropdownMenu.click();
        ReusableMethods.waitFor(3);
        //ödeme sayfasının görüntülenmesi için ödemeye tıklanması
        customerPage.paymentsOptions.click();
        ReusableMethods.waitFor(3);
        //ödeme eklemek için add butonuna tıklanması
        customerPage.addPayment.click();
        ReusableMethods.waitFor(3);
        //cash on delivery seçeneğiyle ekleme yapmak için butona tıklanır
        customerPage.addCashOnDelivery.click();
        ReusableMethods.waitFor(3);
        //add cash seçeneğine tıklanır
        customerPage.addCash.click();
    }

    @Test
    public void TC_1703() {

        //kullanıcı urlinin açılması
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        //oturum açma sayfasının açılması için butona tıklanması
        customerPage.signInButton.click();
        //kullanıcı bilgilerinin girilmesi
        customerPage.emailBox.sendKeys(ConfigReader.getProperty("customeruser_ali"));
        customerPage.passwordBox.sendKeys(ConfigReader.getProperty("customerpassword_ali"));
        //giriş yapmak için butona tıklanması
        customerPage.loginSigninButton.click();
        ReusableMethods.waitFor(3);
        //profil dropdownının açılması
        customerPage.profileDropdownMenu.click();
        ReusableMethods.waitFor(3);
        //ödeme sayfasının görüntülenmesi için ödemeye tıklanması
        customerPage.paymentsOptions.click();
        ReusableMethods.waitFor(3);
        //ödemenin silinmesi için delete butonuna tıklanması
        customerPage.deletePayment.click();
    }

    @Test
    public void TC_1704() {

        //kullanıcı urlinin açılması
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        //oturum açma sayfasının açılması için butona tıklanması
        customerPage.signInButton.click();
        //kullanıcı bilgilerinin girilmesi
        customerPage.emailBox.sendKeys(ConfigReader.getProperty("customeruser_ali"));
        customerPage.passwordBox.sendKeys(ConfigReader.getProperty("customerpassword_ali"));
        //giriş yapmak için butona tıklanması
        customerPage.loginSigninButton.click();
        ReusableMethods.waitFor(3);
        //profil dropdownının açılması
        customerPage.profileDropdownMenu.click();
        ReusableMethods.waitFor(3);
        //ödeme sayfasının görüntülenmesi için ödemeye tıklanması
        customerPage.paymentsOptions.click();
        ReusableMethods.waitFor(3);
        //ödemenin düzenlenmesi için edit butonuna tıklanması
        customerPage.editPayment.click();
    }
}
