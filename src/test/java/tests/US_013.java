package tests;

import org.testng.annotations.Test;
import pages.CustomerPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_013 {
    CustomerPage customerPage=new CustomerPage();
    @Test
    public void TC_1301(){

        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));

        customerPage.signInButton.isDisplayed();
        //customerPage.emailBox.sendKeys(ConfigReader.getProperty("customeruser_selahattin"));
       // customerPage.passwordBox.sendKeys(ConfigReader.getProperty("customerpassword_selahattin"));
       // customerPage.loginSigninButton.click();

        Driver.quitDriver();
    }
}
