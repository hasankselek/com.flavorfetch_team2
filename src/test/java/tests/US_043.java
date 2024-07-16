package tests;
import java.util.Collections;
import java.util.List;
import com.google.common.base.Verify;
import org.bouncycastle.crypto.digests.Kangaroo;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtilities;
import utilities.ReusableMethods;

public class US_043 {
    AdminPage adminPage=new AdminPage();
@Test
    public void test_4301(){
    Driver.getDriver().get("about:blank");
    Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
    adminPage.userNameButton.sendKeys(ConfigReader.getProperty("adminuser_iqbal"));
    JSUtilities.clickWithJS(Driver.getDriver(),adminPage.passBox);
    adminPage.passBox.sendKeys(ConfigReader.getProperty("adminpassword_iqbal"));
    adminPage.signInButton.sendKeys(Keys.ENTER);
    adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
    adminPage.merchantRegestration.sendKeys(Keys.ENTER);
    ReusableMethods.wait(3);
    //Verify that the "Merchant Regestration" item is visible.
    Assert.assertTrue(adminPage.topDatas.get(1).isDisplayed());
    //Click on "Merchant Regestration" item.
    adminPage.topDatas.get(1).sendKeys(Keys.ENTER);
    //Verify the Url address contains "merchant registration".
    Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(ConfigReader.getProperty("urlContent5")));
    Driver.getDriver();
}
    @Test
    public void test_4302(){
        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        adminPage.userNameButton.sendKeys(ConfigReader.getProperty("adminuser_iqbal"));
        JSUtilities.clickWithJS(Driver.getDriver(),adminPage.passBox);
        adminPage.passBox.sendKeys(ConfigReader.getProperty("adminpassword_iqbal"));
        adminPage.signInButton.sendKeys(Keys.ENTER);
        adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
        adminPage.merchantRegestration.sendKeys(Keys.ENTER);
        ReusableMethods.wait(2);

        Assert.assertTrue(adminPage.columnPicOfMerchantRegestration.get(5).isDisplayed());
        //Verify visibility of logo in merchant list.
        Assert.assertTrue(adminPage.columnAddressOfMerchantRegestration.get(5).isDisplayed());
        //Verify visibility of name in merchant list.
        Assert.assertTrue(adminPage.columnNameOfMerchantRegestration.get(Integer.parseInt(ConfigReader.getProperty("ctrlNumMerReg"))).isDisplayed());
        //Verify visibility of status  in merchant list.
        Assert.assertTrue(adminPage.columnStatusOfMerchantRegistration.get(Integer.parseInt(ConfigReader.getProperty("ctrlNumMerReg"))).isDisplayed());
        //Verify visibility of  address in merchant list.
        Assert.assertTrue(adminPage.columnJustNameOfMerchantRegistration.get(Integer.parseInt(ConfigReader.getProperty("ctrlNumMerReg"))).isDisplayed());
        Assert.assertTrue(adminPage.columnAddressOfMerchantRegestration.get(Integer.parseInt(ConfigReader.getProperty("ctrlNumMerReg"))).isDisplayed());
        Assert.assertTrue(adminPage.columnMembershipOfMerchantRegestration.get(Integer.parseInt(ConfigReader.getProperty("ctrlNumMerReg"))).isDisplayed());
        //Verify visibility of Membership Program in merchant list.
        Driver.quitDriver();
    }
    @Test
    public void test_4303(){
        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        adminPage.userNameButton.sendKeys(ConfigReader.getProperty("adminuser_iqbal"));
        JSUtilities.clickWithJS(Driver.getDriver(),adminPage.passBox);
        adminPage.passBox.sendKeys(ConfigReader.getProperty("adminpassword_iqbal"));
        adminPage.signInButton.sendKeys(Keys.ENTER);
        adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
        adminPage.merchantRegestration.sendKeys(Keys.ENTER);
        ReusableMethods.wait(3);
        //Verify visibility of "Name"in the header of table.
        Assert.assertTrue(adminPage.nameHead.isDisplayed());
        //Verify visibility of "Address"in the header of table.
        Assert.assertTrue(adminPage.addressHead.isDisplayed());
        //Verify visibility of "Membership Program"in the header of table.
        Assert.assertTrue(adminPage.membershipHead.isDisplayed());
        List<String> expectedNameList=ReusableMethods.stringListesineDonustur(adminPage.columnJustNameOfMerchantRegistration);
        Collections.sort(expectedNameList);
        List<String> actualNameList=ReusableMethods.stringListesineDonustur(adminPage.columnJustNameOfMerchantRegistration);
        Assert.assertEquals(actualNameList,expectedNameList);
        Driver.quitDriver();
    }
@Test
    public void test_4304(){
    Driver.getDriver().get("about:blank");
    Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
    adminPage.userNameButton.sendKeys(ConfigReader.getProperty("adminuser_iqbal"));
    JSUtilities.clickWithJS(Driver.getDriver(),adminPage.passBox);
    adminPage.passBox.sendKeys(ConfigReader.getProperty("adminpassword_iqbal"));
    adminPage.signInButton.sendKeys(Keys.ENTER);
    adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
    adminPage.merchantRegestration.sendKeys(Keys.ENTER);
    ReusableMethods.wait(2);
    //Click on "Address" item.
    adminPage.addressHead.sendKeys(Keys.ENTER);
    //Verify that Address's data sorted by alphabetic order
    ReusableMethods.wait(2);
    List<String> expectedAddressList=ReusableMethods.stringListesineDonustur(adminPage.columnAddressOfMerchantRegestration);
    Collections.sort(expectedAddressList);
    List<String> actualAddressList=ReusableMethods.stringListesineDonustur(adminPage.columnAddressOfMerchantRegestration);
    Assert.assertEquals(actualAddressList,expectedAddressList);
    ReusableMethods.wait(2);

    List<String> acutualNameList=ReusableMethods.stringListesineDonustur(adminPage.columnJustNameOfMerchantRegistration);
    //Click on "Name" item.
    adminPage.nameHead.sendKeys(Keys.ENTER);
    ReusableMethods.wait(2);
    List<String> expectedNameList=ReusableMethods.stringListesineDonustur(adminPage.columnJustNameOfMerchantRegistration);
    Assert.assertNotEquals(acutualNameList,expectedNameList);
    ReusableMethods.wait(2);

    adminPage.membershipHead.sendKeys(Keys.ENTER);
    //Verify that item's data changed order.
    List<String> expectedMembershipList=ReusableMethods.stringListesineDonustur(adminPage.columnMembershipOfMerchantRegestration);
    Collections.sort(expectedMembershipList);
    List<String> actualMembershipList=ReusableMethods.stringListesineDonustur(adminPage.columnMembershipOfMerchantRegestration);
    Assert.assertEquals(actualMembershipList,expectedMembershipList);

    Driver.quitDriver();
}

@Test
    public void test_4305(){
    Driver.getDriver().get("about:blank");
    Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
    adminPage.userNameButton.sendKeys(ConfigReader.getProperty("adminuser_iqbal"));
    JSUtilities.clickWithJS(Driver.getDriver(),adminPage.passBox);
    adminPage.passBox.sendKeys(ConfigReader.getProperty("adminpassword_iqbal"));
    adminPage.signInButton.sendKeys(Keys.ENTER);
    adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
    adminPage.merchantRegestration.sendKeys(Keys.ENTER);
    ReusableMethods.wait(2);
    Assert.assertTrue(adminPage.dateInputBox.isDisplayed());
    //Verify visibility of input box of calendar .
    Assert.assertTrue(adminPage.calendarIcone.isDisplayed());
    //Verify visibility of calendar icon.
    adminPage.calendarIcone.sendKeys(Keys.ENTER);
    //click on calendar icon and Verify visibility of date.
  Driver.quitDriver();
}
@Test
    public void test_4306(){
    Driver.getDriver().get("about:blank");
    Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
    adminPage.userNameButton.sendKeys(ConfigReader.getProperty("adminuser_iqbal"));
    JSUtilities.clickWithJS(Driver.getDriver(),adminPage.passBox);
    adminPage.passBox.sendKeys(ConfigReader.getProperty("adminpassword_iqbal"));
    adminPage.signInButton.sendKeys(Keys.ENTER);
    adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
    adminPage.merchantRegestration.sendKeys(Keys.ENTER);
    ReusableMethods.wait(2);
    adminPage.dateInputBox.sendKeys(Keys.ENTER);
    int expectedDropDownNum=Integer.parseInt(ConfigReader.getProperty("numberOfDateRangeSize"));// =7
    List<String> dropdownList=ReusableMethods.stringListesineDonustur(adminPage.dateRange);
    int actualDropDownNum=dropdownList.size();
    ReusableMethods.wait(5);
    Assert.assertEquals(actualDropDownNum,expectedDropDownNum);
    //click on input box of calendar and verify visibility 7 data in drop
    ReusableMethods.wait(2);
    int number=Integer.parseInt(ConfigReader.getProperty("controlNumber"));//Random 0 - 6
    Assert.assertTrue(adminPage.dateRange.get(number).isDisplayed());
    ReusableMethods.wait(3);
    System.out.println( "test:"+adminPage.dateRange.get(number).getText());
    adminPage.dateRange.get(number).click();
    //click on one data from dropdown.



    //Verify merchant list sorted via date.
   Driver.quitDriver();
}
@Test
    public void test_4307(){
    Driver.getDriver().get("about:blank");
    Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
    adminPage.userNameButton.sendKeys(ConfigReader.getProperty("adminuser_iqbal"));
    JSUtilities.clickWithJS(Driver.getDriver(),adminPage.passBox);
    adminPage.passBox.sendKeys(ConfigReader.getProperty("adminpassword_iqbal"));
    adminPage.signInButton.sendKeys(Keys.ENTER);
    adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
    adminPage.merchantRegestration.sendKeys(Keys.ENTER);
    ReusableMethods.wait(2);
    adminPage.dateInputBox.sendKeys(Keys.ENTER);
    //click on input box of calendar and enter a renge of date in dropdown.
    ReusableMethods.wait(2);
      int number1=Integer.parseInt((ConfigReader.getProperty("numberOfDateDropDown")));
    System.out.println(adminPage.weekList.get(number1));
    ReusableMethods.wait(2);
    Assert.assertTrue(adminPage.weekList.get(number1).isEnabled());
    ReusableMethods.wait(2);
    adminPage.weekList.get(number1).sendKeys(Keys.ENTER);
    ReusableMethods.wait(2);
      int number2=Integer.parseInt((ConfigReader.getProperty("number_2_OfDateDropDown")));
    Assert.assertTrue(adminPage.weekList.get(number2).isEnabled());
    adminPage.weekList.get(number2).sendKeys(Keys.ENTER);
    //Verify the numbers of calendar active and selectable
    ReusableMethods.wait(2);
    Assert.assertTrue(adminPage.dateInputBox.getText().contains(ConfigReader.getProperty("numberOfDateDropDown")));
    Assert.assertTrue(adminPage.dateInputBox.getText().contains(ConfigReader.getProperty("number_2_OfDateDropDown")));
    //Verify merchant list sorted in date renge.
   Driver.quitDriver();
}
@Test
    public void test_4308(){
    Driver.getDriver().get("about:blank");
    Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
    adminPage.userNameButton.sendKeys(ConfigReader.getProperty("adminuser_iqbal"));
    JSUtilities.clickWithJS(Driver.getDriver(),adminPage.passBox);
    adminPage.passBox.sendKeys(ConfigReader.getProperty("adminpassword_iqbal"));
    adminPage.signInButton.sendKeys(Keys.ENTER);
    adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
    adminPage.merchantRegestration.sendKeys(Keys.ENTER);
    ReusableMethods.wait(2);
    adminPage.dateInputBox.sendKeys(Keys.ENTER);
    ReusableMethods.wait(5);

    JSUtilities.clickWithJS(Driver.getDriver(),adminPage.prevFlashCalendar);
    //Click the "< "sign of calendar .
    ReusableMethods.wait(2);
    System.out.println("exp:"+ConfigReader.getProperty("monthName2"));
    System.out.println("act:"+adminPage.calendarLefttMonth.getText());
   String expectedMonth=adminPage.calendarLefttMonth.getText();
   String actualMonth=adminPage.calendarRightMonth.getText();
   Assert.assertNotEquals(actualMonth,expectedMonth);
    //Verify single visibility of "July".
  Driver.quitDriver();
}
@Test
    public void test_4309(){
    Driver.getDriver().get("about:blank");
    Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
    adminPage.userNameButton.sendKeys(ConfigReader.getProperty("adminuser_iqbal"));
    JSUtilities.clickWithJS(Driver.getDriver(),adminPage.passBox);
    adminPage.passBox.sendKeys(ConfigReader.getProperty("adminpassword_iqbal"));
    adminPage.signInButton.sendKeys(Keys.ENTER);
    adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
    adminPage.merchantRegestration.sendKeys(Keys.ENTER);
    ReusableMethods.wait(2);
    adminPage.dateInputBox.sendKeys(Keys.ENTER);
    JSUtilities.clickWithJS(Driver.getDriver(),adminPage.prevFlashCalendar);
    JSUtilities.clickWithJS(Driver.getDriver(),adminPage.prevFlashCalendar);
    JSUtilities.clickWithJS(Driver.getDriver(),adminPage.prevFlashCalendar);
    //Click the "< "sign of calendar .
    ReusableMethods.wait(2);
    System.out.println("exp:"+adminPage.calendarRightMonth.getText());
    System.out.println("act:"+adminPage.calendarLefttMonth.getText());
    JSUtilities.getTextWithJS(Driver.getDriver(),adminPage.calendarLefttMonth)
    String expectedMonth=adminPage.calendarLefttMonth.getText();
    String actualMonth=adminPage.calendarRightMonth.getText();
    Assert.assertNotEquals(actualMonth,expectedMonth);
    //Verify single visibility of "May".
   Driver.quitDriver();
}
@Test
    public void test_4310(){
    Driver.getDriver().get("about:blank");
    Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
    adminPage.userNameButton.sendKeys(ConfigReader.getProperty("adminuser_iqbal"));
    JSUtilities.clickWithJS(Driver.getDriver(),adminPage.passBox);
    adminPage.passBox.sendKeys(ConfigReader.getProperty("adminpassword_iqbal"));
    adminPage.signInButton.sendKeys(Keys.ENTER);
    adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
    adminPage.merchantRegestration.sendKeys(Keys.ENTER);
    ReusableMethods.wait(2);
    adminPage.dateInputBox.sendKeys(Keys.ENTER);
    JSUtilities.clickWithJS(Driver.getDriver(),adminPage.prevFlashCalendar);
    JSUtilities.clickWithJS(Driver.getDriver(),adminPage.prevFlashCalendar);

    String expectedMonth=ConfigReader.getProperty("monthName1");
    JSUtilities.getTextWithJS(Driver.getDriver(),adminPage.calendarLefttMonth);
    String actual1Month=adminPage.calendarLefttMonth.getText();
    JSUtilities.getTextWithJS(Driver.getDriver(),adminPage.calendarRightMonth);
    String actual2Month=adminPage.calendarRightMonth.getText();

        Assert.assertEquals(actual1Month,expectedMonth);
        Assert.assertEquals(actual2Month,expectedMonth);

    //Verify  the  "< "sign of calendar  is visible.
    //Click the "< "sign of calendar .
    //Verify single visibility of "Jun".
  Driver.quitDriver();
}
@Test
    public void test_4311(){
    Driver.getDriver().get("about:blank");
    Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
    adminPage.userNameButton.sendKeys(ConfigReader.getProperty("adminuser_iqbal"));
    JSUtilities.clickWithJS(Driver.getDriver(),adminPage.passBox);
    adminPage.passBox.sendKeys(ConfigReader.getProperty("adminpassword_iqbal"));
    adminPage.signInButton.sendKeys(Keys.ENTER);
    adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
    adminPage.merchantRegestration.sendKeys(Keys.ENTER);
    ReusableMethods.wait(2);
    //Verify visibility of  "All Status" input box.
    //Verify visibility of "All Status" in background of status box.
    //Verify visibility of All Status box dropdown.
    //Click on AllStatus box
    //Click randomly on one element of dropdown.
    //Verify the list of merchant sorted by selected item
   Driver.quitDriver();
}
@Test
    public void test_4312(){
    Driver.getDriver().get("about:blank");
    Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
    adminPage.userNameButton.sendKeys(ConfigReader.getProperty("adminuser_iqbal"));
    JSUtilities.clickWithJS(Driver.getDriver(),adminPage.passBox);
    adminPage.passBox.sendKeys(ConfigReader.getProperty("adminpassword_iqbal"));
    adminPage.signInButton.sendKeys(Keys.ENTER);
    adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
    adminPage.merchantRegestration.sendKeys(Keys.ENTER);
    ReusableMethods.wait(2);
    //Verify visibility of icon name.
 Driver.quitDriver();
}
@Test
    public void test_4313(){
    Driver.getDriver().get("about:blank");
    Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
    adminPage.userNameButton.sendKeys(ConfigReader.getProperty("adminuser_iqbal"));
    JSUtilities.clickWithJS(Driver.getDriver(),adminPage.passBox);
    adminPage.passBox.sendKeys(ConfigReader.getProperty("adminpassword_iqbal"));
    adminPage.signInButton.sendKeys(Keys.ENTER);
    adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
    adminPage.merchantRegestration.sendKeys(Keys.ENTER);
    ReusableMethods.wait(2);
    //Click on anonymus icon.
    //Verify the visibility of "Filters"
    //Verify the visibility of "By Merchant"
    //Verify the visibility of input box.
    //Click the input box.
    //Verify the visibility of dropdown with some merchant name.
    //Click on one of the merchant name from dropdown.
    //Verify the visibility of "Apply Filters".
    //Click the "Apply Filters".
    //Verify visibility the just selected merchant in merchant list
    //Click on the icon.
    //Verify the visibility of "Clear Filters".
    //Click the "Clear Filters".
    //Click the "Apply Filters".
    //Verify the merchant list orderd as default by alphabetic.
   Driver.quitDriver();
}
@Test
    public void test_4314(){
    Driver.getDriver().get("about:blank");
    Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
    adminPage.userNameButton.sendKeys(ConfigReader.getProperty("adminuser_iqbal"));
    JSUtilities.clickWithJS(Driver.getDriver(),adminPage.passBox);
    adminPage.passBox.sendKeys(ConfigReader.getProperty("adminpassword_iqbal"));
    adminPage.signInButton.sendKeys(Keys.ENTER);
    adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
    adminPage.merchantRegestration.sendKeys(Keys.ENTER);
    ReusableMethods.wait(2);
    //Click on All Status box and select two item
    //Verify visibility of sign mark in dropdown next to selected item.
    //Verify visibility of Merchant list sorted alphabetically order.
    //Verify the merchant list status contains one or two of selected items.
    //Verify the merchant list status does not contain other than the two selected items.
    //Verify unvisibility of mark sign when reclick on it.
    //Verify visibility of all types of status in merchant list after deselected status items.
    //The user closes the page.
    Driver.quitDriver();
}
@Test
    public void test_4315(){
    Driver.getDriver().get("about:blank");
    Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
    adminPage.userNameButton.sendKeys(ConfigReader.getProperty("adminuser_iqbal"));
    JSUtilities.clickWithJS(Driver.getDriver(),adminPage.passBox);
    adminPage.passBox.sendKeys(ConfigReader.getProperty("adminpassword_iqbal"));
    adminPage.signInButton.sendKeys(Keys.ENTER);
    adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
    adminPage.merchantRegestration.sendKeys(Keys.ENTER);
    ReusableMethods.wait(2);
    //Verify visibility of "Total Registered" and the opposite number.
    //Verify visibility of "Commission Total" and the opposite number.
    //Verify visibility of "Membership Total" and the opposite number.
    //Verify visibility of "Total Active" and the opposite number.
    //Verify visibility of "Total Inactive" and the opposite number.
    //Check that the sum of "Total Active" and "Total Inactive" is equalls to "Total Registered"
    Driver.quitDriver();
}
@Test
    public void test_4316(){
    Driver.getDriver().get("about:blank");
    Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
    adminPage.userNameButton.sendKeys(ConfigReader.getProperty("adminuser_iqbal"));
    JSUtilities.clickWithJS(Driver.getDriver(),adminPage.passBox);
    adminPage.passBox.sendKeys(ConfigReader.getProperty("adminpassword_iqbal"));
    adminPage.signInButton.sendKeys(Keys.ENTER);
    adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
    adminPage.merchantRegestration.sendKeys(Keys.ENTER);
    ReusableMethods.wait(2);
    //Check that the sum of "Commission Total" and "Membership Total" is equalls to "Total Active"
Driver.quitDriver();
}
@Test
    public void test_4317(){
    Driver.getDriver().get("about:blank");
    Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
    adminPage.userNameButton.sendKeys(ConfigReader.getProperty("adminuser_iqbal"));
    JSUtilities.clickWithJS(Driver.getDriver(),adminPage.passBox);
    adminPage.passBox.sendKeys(ConfigReader.getProperty("adminpassword_iqbal"));
    adminPage.signInButton.sendKeys(Keys.ENTER);
    adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
    adminPage.merchantRegestration.sendKeys(Keys.ENTER);
    ReusableMethods.wait(2);
    //Check that the number written before the entries in "Showing 1 to 10 of 38 entries"at the bottom of page is equals to "Total Registered"
 Driver.quitDriver();
}
@Test
    public void test_4318(){
    Driver.getDriver().get("about:blank");
    Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
    adminPage.userNameButton.sendKeys(ConfigReader.getProperty("adminuser_iqbal"));
    JSUtilities.clickWithJS(Driver.getDriver(),adminPage.passBox);
    adminPage.passBox.sendKeys(ConfigReader.getProperty("adminpassword_iqbal"));
    adminPage.signInButton.sendKeys(Keys.ENTER);
    adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
    adminPage.merchantRegestration.sendKeys(Keys.ENTER);
    ReusableMethods.wait(2);
    //The notification asign is visible and active.
    //Click the notification asign.
    //The notification asign dropdown is active and shows the orders

    //Numbers of orders is shown on notification.
    //Verify the number of last order is equal tothe number of order in upper row of Last Orders
Driver.quitDriver();
}
@Test
    public void test_4319(){
    Driver.getDriver().get("about:blank");
    Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
    adminPage.userNameButton.sendKeys(ConfigReader.getProperty("adminuser_iqbal"));
    JSUtilities.clickWithJS(Driver.getDriver(),adminPage.passBox);
    adminPage.passBox.sendKeys(ConfigReader.getProperty("adminpassword_iqbal"));
    adminPage.signInButton.sendKeys(Keys.ENTER);
    adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
    adminPage.merchantRegestration.sendKeys(Keys.ENTER);
    ReusableMethods.wait(2);
    //The icon of profile is visible.
    //Click on the profile asign.
    //Verify the profile asign is active.
    //The user closes the page.
    Driver.quitDriver();
}
@Test
    public void test_4320(){
    Driver.getDriver().get("about:blank");
    Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
    adminPage.userNameButton.sendKeys(ConfigReader.getProperty("adminuser_iqbal"));
    JSUtilities.clickWithJS(Driver.getDriver(),adminPage.passBox);
    adminPage.passBox.sendKeys(ConfigReader.getProperty("adminpassword_iqbal"));
    adminPage.signInButton.sendKeys(Keys.ENTER);
    adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
    adminPage.merchantRegestration.sendKeys(Keys.ENTER);
    ReusableMethods.wait(2);
    //The admin name  and profile asign is visible .
    //Click  on admin name and drop down is visible and acrive
    //Click on the first item of profile.
    //Check the firstname is visible.
    //Click on Reports first then on Merchant Registration.
    //Click  on admin name and drop down is visible and acrive
    //Click on the secound item of profile.
    //Check the Administrator Login is visible
   Driver.quitDriver();
}
}
