package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomerPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

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


        Assert.assertTrue(customerPage.addressType.isDisplayed());

        Assert.assertTrue(customerPage.addressInfoTable.isDisplayed());

        Assert.assertTrue((customerPage.viewAddressCount.isDisplayed()));

        //How many addresses the user has added and deleted should be seen in the address section.
        String addressCountNum=customerPage.viewAddressCount.getText();
        addressCountNum=addressCountNum.replaceAll("\\D","");
        int AddressNum=Integer.parseInt(addressCountNum);
        // System.out.println(addressCountNum);

        int ViewAdressCount=customerPage.addressCount.size();

        Assert.assertEquals(AddressNum,ViewAdressCount);

        Driver.quitDriver();

    }

    @Test
    public void TC_1602(){

        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));

        CustomerPage customerPage=new CustomerPage();

        customerPage.signInButton.click();

        customerPage.emailBox.sendKeys(ConfigReader.getProperty("customeruser_cimen"));

        customerPage.passwordBox.sendKeys(ConfigReader.getProperty("customerpassword_cimen"));

        customerPage.loginSigninButton.click();

        ReusableMethods.waitFor(3);

        customerPage.profileDropdownMenu.click();

        ReusableMethods.waitFor(5);

        customerPage.addressInfo.click();

        ReusableMethods.waitFor(3);

        Actions actions=new Actions(Driver.getDriver());

        actions.click(customerPage.addressEdit).perform();

        ReusableMethods.waitFor(3);

        Assert.assertTrue(customerPage.viewGoogleMaps.isDisplayed());

        Assert.assertTrue(customerPage.adddeliveryInstructions.isDisplayed());

        Assert.assertTrue(customerPage.addressLabel.isDisplayed());

        Assert.assertTrue(customerPage.apartmentTextView.isDisplayed());

        Assert.assertTrue(customerPage.deliveryOptionsType.isEnabled());

        Assert.assertTrue(customerPage.addressLabelType.isEnabled());

        Select deliveryType=new Select(customerPage.deliveryOptionsType);

        List<WebElement> deliveryOptionTypeElementList=deliveryType.getOptions();

        System.out.println(ReusableMethods.stringListesineDonustur(deliveryOptionTypeElementList));

        int expectedOptionSayisi=3;
        int actualOptionSayisi=deliveryOptionTypeElementList.size();

        Assert.assertEquals(expectedOptionSayisi,actualOptionSayisi);

        String addresslist=customerPage.addressLabelType.getText();

        System.out.println(addresslist);

        customerPage.addressEdit2.click();

        Assert.assertTrue(customerPage.completeAddressField.isDisplayed());

        Assert.assertTrue(customerPage.saveButtonField.isDisplayed());

        Assert.assertTrue(customerPage.cancelButtonField.isDisplayed());

        customerPage.completeAddressField.click();

        customerPage.completeAddressText.sendKeys(Keys.CLEAR);

        customerPage.saveButtonField.click();

        ReusableMethods.waitFor(4);

        customerPage.addressEdit2.click();

        String exceptedValue="";
        String actualValue=customerPage.completeAddressText.getText();
        System.out.println(actualValue);

        ReusableMethods.waitFor(3);

        Assert.assertEquals(actualValue,exceptedValue);

        customerPage.addressDetailsCloseButton.click();

        customerPage.addressEdit.click();

        deliveryType.selectByIndex(2);

        customerPage.saveAddressButton.click();

        Assert.assertTrue(customerPage.addressInfoTable.getText().contains("School"));  // When clicking save button,you should see school.

        //Cancel button Test

        customerPage.addressEdit.click();

        deliveryType.selectByIndex(1);   //  choose other and then save button.

        customerPage.cancelAdressButton.click();

        Assert.assertFalse(customerPage.addressInfoTable.getText().contains("Other"));

        Driver.quitDriver();

    }

    @Test
    public void TC_1603(){

        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));

        CustomerPage customerPage=new CustomerPage();

        customerPage.signInButton.click();

        customerPage.emailBox.sendKeys(ConfigReader.getProperty("customeruser_cimen"));

        customerPage.passwordBox.sendKeys(ConfigReader.getProperty("customerpassword_cimen"));

        customerPage.loginSigninButton.click();

        ReusableMethods.waitFor(3);

        customerPage.profileDropdownMenu.click();
        ReusableMethods.waitFor(5);

        customerPage.addressInfo.click();

        ReusableMethods.waitFor(3);

        customerPage.addAddressButton.click();

        customerPage.enterAddressField.click();
        customerPage.enterAddressField.sendKeys("Holbrook");

//        String deger=customer.chooseAddressField.getText();
//        System.out.println(deger);

        customerPage.chooseAddressField.click();

        ReusableMethods.waitFor(3);

//        String x=customer.v.getText();
//        System.out.println(x);

//        customer.cancelButtonField.click();
//
//        Assert.assertFalse(customer.addressNameNew.getText().contains("Holbrook"));

        ReusableMethods.waitFor(3);

        Actions actions=new Actions(Driver.getDriver());
        actions.click(customerPage.addressLabelSchool).perform();

        customerPage.saveAddressButton.click();

        ReusableMethods.waitFor(5);

//        String a=customer.addressInfoTable.getText();
//        System.out.println(a);

        Assert.assertTrue(customerPage.addressInfoTable.getText().contains("School"));

        Assert.assertTrue(customerPage.addressInfoTable.getText().contains("Holbrook"));

        customerPage.addAddressButton.click();

        customerPage.enterAddressField.click();
        customerPage.enterAddressField.sendKeys("Holbrook");

        customerPage.chooseAddressField.click();

        ReusableMethods.waitFor(3);

        customerPage.saveAddressButton.click();

        Assert.assertTrue(customerPage.addressSameAlert.isDisplayed());

        Driver.quitDriver();

    }

    @Test
    public void TC_1604(){

        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));

        CustomerPage customerPage=new CustomerPage();

        customerPage.signInButton.click();

        customerPage.emailBox.sendKeys(ConfigReader.getProperty("customeruser_cimen"));

        customerPage.passwordBox.sendKeys(ConfigReader.getProperty("customerpassword_cimen"));

        customerPage.loginSigninButton.click();

        ReusableMethods.waitFor(3);

        customerPage.profileDropdownMenu.click();
        ReusableMethods.waitFor(5);

        customerPage.addressInfo.click();

        ReusableMethods.waitFor(3);

        customerPage.addressDelete.click();

        Assert.assertTrue(customerPage.addressDeleteAlert.isDisplayed());

        customerPage.addressDeleteAlertCancel.click();

        Assert.assertTrue(customerPage.addressInfoTable.isDisplayed());

        customerPage.addressDelete.click();

        customerPage.addressDeleteAlertAccept.click();

        Assert.assertTrue(customerPage.addressInfoTable.isDisplayed());

        Driver.quitDriver();

    }
}