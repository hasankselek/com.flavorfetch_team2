package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomerPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.FileNotFoundException;

public class US_014 extends TestBaseRapor {


    @Test
    public void TC_1401()  {

        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        CustomerPage customerPage=new CustomerPage();



        customerPage.signInButton.click();

        customerPage.emailBox.sendKeys(ConfigReader.getProperty("customeruser_cimen"));

        customerPage.passwordBox.sendKeys(ConfigReader.getProperty("customerpassword_cimen"));

        customerPage.loginSigninButton.click();

        ReusableMethods.waitFor(3);

        customerPage.profileDropdownMenu.click();
        ReusableMethods.waitFor(5);

        customerPage.ManagemyAccount.click();

        ReusableMethods.waitFor(3);

        Assert.assertTrue(customerPage.FirstName.isDisplayed());
        Assert.assertTrue(customerPage.LastName.isDisplayed());
        Assert.assertTrue(customerPage.emailAddress.isDisplayed());
        Assert.assertTrue(customerPage.phone.isDisplayed());

        Actions actions = new Actions(Driver.getDriver());
        actions.click(customerPage.FirstName)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE).perform();

        ReusableMethods.waitFor(6);


        Assert.assertFalse(customerPage.SubmitButton.isEnabled());

        ReusableMethods.waitFor(3);

        // Submit basılınca profil güncelleme yazısı geliyor.

        Driver.getDriver().navigate().refresh();

        customerPage.SubmitButton.click();

        String exceptedInfo="Profile updated";
        String actualInfo=customerPage.alertProfile.getText();

        Assert.assertEquals(actualInfo,exceptedInfo);

        /*
      //Profil resmi yüklenmesi yapılıyor mu?
//      String dosyaYolu=System.getProperty("user.home")+"/Downloads/profilresmi.png";

        String dosyaYolu="C:\\Users\\cimen\\IdeaProjects\\Team141_TestNG_POM\\src\\test\\java\\tests\\FlavorFetch\\profilresmi.png";

       ReusableMethods.bekle(5);

//       customerPage.updateProfile.click();
        customerPage.updateProfile.sendKeys(dosyaYolu);
        customerPage.savePhoto.click();
//
////      FileInputStream fileInputStream=new FileInputStream(dosyaYolu);

//        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

         */

        ReusableMethods.waitFor(6);
        Driver.quitDriver();

    }

    @Test
    public void TC_1402(){

        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));

        CustomerPage customerPage =new CustomerPage();

        customerPage.signInButton.click();

        customerPage.emailBox.sendKeys(ConfigReader.getProperty("customeruser_cimen"));

        customerPage.passwordBox.sendKeys(ConfigReader.getProperty("customerpassword_cimen"));

        customerPage.loginSigninButton.click();

        ReusableMethods.waitFor(3);

        customerPage.profileDropdownMenu.click();
        ReusableMethods.waitFor(5);

        customerPage.ManagemyAccount.click();

        ReusableMethods.waitFor(3);

        customerPage.changePassword.click();

        ReusableMethods.waitFor(4);

        // Sonrasında onaylanmış şifre ile yeni şifre farklı ise "Password change" yazısı çıkar.

        customerPage.oldPassword.sendKeys(ConfigReader.getProperty("customerpassword_cimen"));
        customerPage.newPassword.sendKeys(ConfigReader.getProperty("customerNewPasswordDif"));
        customerPage.confirmPassword.sendKeys(ConfigReader.getProperty("customerConfirmPassword"));

        customerPage.SubmitButton.click();
        ReusableMethods.waitFor(4);

        String exceptedText1="New Password must be repeated exactly";
        String actualText1= customerPage.passwordDifferentError.getText();

        Assert.assertEquals(exceptedText1,actualText1);

        ReusableMethods.waitFor(2);


        Driver.getDriver().navigate().refresh();

        ReusableMethods.waitFor(5);

        customerPage.oldPassword.sendKeys(ConfigReader.getProperty("customerpassword_cimen"));
        customerPage.newPassword.sendKeys(ConfigReader.getProperty("customerNewPassword"));
        customerPage.confirmPassword.sendKeys(ConfigReader.getProperty("customerConfirmPassword"));


        // Sonrasında onaylanmış şifre ile yeni şifre aynı ise "Password change" yazısı çıkar.

        customerPage.SubmitButton.click();

        ReusableMethods.waitFor(4);

        String exceptedText="Password change";
        String actualText= customerPage.passwordChangeText.getText();

        Assert.assertEquals(exceptedText,actualText);

        ReusableMethods.waitFor(6);

        customerPage.profileDropdownMenu.click();

        ReusableMethods.waitFor(5);

        customerPage.logoutButton.click();

        ReusableMethods.waitFor(5);

        customerPage.emailBox.sendKeys(ConfigReader.getProperty("customeruser_cimen"));

        customerPage.passwordBox.sendKeys(ConfigReader.getProperty("customerpassword_cimen"));

        customerPage.loginSigninButton.click();

        ReusableMethods.waitFor(5);

        Driver.quitDriver();

    }

    @Test
    public void TC_1403(){

        extentTest=extentReports.createTest("TC_1403","Verify code for mail address and/or mobile phone");

        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));

        extentTest.info("Kullanıcının hesabına erisebilmesi için linke giris yapar.");

        CustomerPage customerPage =new CustomerPage();


        customerPage.signInButton.click();

        extentTest.info("Sign in butonuna tıklar.");

        customerPage.emailBox.sendKeys(ConfigReader.getProperty("customeruser_cimen"));

        customerPage.passwordBox.sendKeys(ConfigReader.getProperty("customerpassword_cimen"));

        extentTest.info("Mail adresi veya şifre ile oturum açma işlemi yapar");

        customerPage.loginSigninButton.click();

        ReusableMethods.waitFor(3);

        customerPage.profileDropdownMenu.click();
        ReusableMethods.waitFor(5);

        customerPage.ManagemyAccount.click();

        ReusableMethods.waitFor(3);

        customerPage.emailAddress.sendKeys("cimen");

        customerPage.SubmitButton.click();

        extentTest.info("Basic details kısmında kullanıcı e-posta adresi ve/veya telefon numarası değişiklik yapar.");

        Assert.assertTrue(customerPage.codeView.isDisplayed());

        extentTest.pass("Codeview gözüktügünü dogrular");

        ReusableMethods.waitFor(3);

        Assert.assertTrue(customerPage.SubmitButton.isSelected());

        extentTest.pass("Submit Button secilebilir oldugunu dogrular");

        ReusableMethods.waitFor(5);


        Driver.quitDriver();

        extentTest.info("Sayfayı kapatir");
    }
}

