package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomerPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_016 {

   CustomerPage customerPage =new CustomerPage();

    @Test
    public void TC_1601(){

        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));

        customerPage.signInButton.click();

        customerPage.emailBox.sendKeys(ConfigReader.getProperty("customeruser_cimen"));

        customerPage.passwordBox.sendKeys(ConfigReader.getProperty("customerpassword_cimen"));

        customerPage.loginSigninButton.click();

        ReusableMethods.waitFor(3);

        customerPage.profileDropdownMenu.click();
        ReusableMethods.waitFor(5);

        customerPage.addressInfo.click();

        ReusableMethods.waitFor(3);

//  String address=customerPage.addressType.getText();
//   System.out.println(address);

        Assert.assertTrue(customerPage.countryView.isDisplayed());

//    if (customerPage.addressType)
        Assert.assertTrue(customerPage.addressType.isDisplayed());

        int addressCountNumber = customerPage.addressCount.size();
        String adressHeadVount= customerPage.addressCountHead.getText();
        System.out.println(adressHeadVount);


        Driver.quitDriver();


    }
}
