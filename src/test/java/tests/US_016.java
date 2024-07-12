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


        Assert.assertTrue(customerPage.countryView.isDisplayed());

//    if (customerPage.addressType)
        Assert.assertTrue(customerPage.addressType.isDisplayed());

//       // int addressCountNumber = customerPage.addressCount.size();
//        String adressHeadVount= customerPage.addressCountHead.getText();
//        System.out.println(adressHeadVount);


        //How many addresses the user has added and deleted should be seen in the address section.
        String addressCountNum=customerPage.viewAddressCount.getText();
        addressCountNum=addressCountNum.replaceAll("\\D","");
        int AddressNum=Integer.parseInt(addressCountNum);


        int ViewAdressCount=customerPage.addressCount.size();


        Assert.assertEquals(AddressNum,ViewAdressCount);



        Driver.quitDriver();

    }

    @Test
    public void TC_1602(){



    }


}
