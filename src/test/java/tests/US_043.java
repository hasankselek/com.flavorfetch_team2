package tests;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.google.common.base.Verify;
import org.bouncycastle.crypto.digests.Kangaroo;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtilities;
import utilities.ReusableMethods;

public class US_043 {
    static AdminPage adminPage = new AdminPage();

    @Test
    public void test_4301() {
        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        ReusableMethods.accessAdmin("adminuser_iqbal","adminpassword_iqbal");
        adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
        adminPage.merchantRegestration.sendKeys(Keys.ENTER);
        ReusableMethods.wait(3);
        //Verify that the "Merchant Regestration" item is visible.
        Assert.assertTrue(adminPage.topDatas.get(1).isDisplayed());
        //Click on "Merchant Regestration" item.
        JSUtilities.clickWithJS(Driver.getDriver(), adminPage.topDatas.get(1));
        //Verify the Url address contains "merchant registration".
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(ConfigReader.getProperty("urlContent5")));
        Driver.getDriver();
    }

    @Test
    public void test_4302() {
        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        ReusableMethods.accessAdmin("adminuser_iqbal","adminpassword_iqbal");
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
    public void test_4303() {
        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        ReusableMethods.accessAdmin("adminuser_iqbal","adminpassword_iqbal");
        adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
        adminPage.merchantRegestration.sendKeys(Keys.ENTER);
        ReusableMethods.wait(3);
        //Verify visibility of "Name"in the header of table.
        Assert.assertTrue(adminPage.nameHead.isDisplayed());
        //Verify visibility of "Address"in the header of table.
        Assert.assertTrue(adminPage.addressHead.isDisplayed());
        //Verify visibility of "Membership Program"in the header of table.
        Assert.assertTrue(adminPage.membershipHead.isDisplayed());
        List<String> expectedNameList = ReusableMethods.stringListesineDonustur(adminPage.columnJustNameOfMerchantRegistration);
        Collections.sort(expectedNameList);
        List<String> actualNameList = ReusableMethods.stringListesineDonustur(adminPage.columnJustNameOfMerchantRegistration);
        Assert.assertEquals(actualNameList, expectedNameList);
        Driver.quitDriver();
    }
  
    @Test
    public void test_4304() {
        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        ReusableMethods.accessAdmin("adminuser_iqbal", "adminpassword_iqbal");
        adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
        adminPage.merchantRegestration.sendKeys(Keys.ENTER);
        ReusableMethods.wait(2);
        //Click on "Address" item.
        adminPage.addressHead.sendKeys(Keys.ENTER);
        //Verify that Address's data sorted by alphabetic order
        ReusableMethods.wait(2);
        List<String> expectedAddressList = ReusableMethods.stringListesineDonustur(adminPage.columnAddressOfMerchantRegestration);
        Collections.sort(expectedAddressList);
        List<String> actualAddressList = ReusableMethods.stringListesineDonustur(adminPage.columnAddressOfMerchantRegestration);
        Assert.assertEquals(actualAddressList, expectedAddressList);

        Driver.quitDriver();
    }
      @Test
    public void test_4305() {
        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        ReusableMethods.accessAdmin("adminuser_iqbal","adminpassword_iqbal");
        adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
        adminPage.merchantRegestration.sendKeys(Keys.ENTER);
        ReusableMethods.wait(2);

        List<String> acutualNameList = ReusableMethods.stringListesineDonustur(adminPage.columnJustNameOfMerchantRegistration);
        //Click on "Name" item.
        adminPage.nameHead.sendKeys(Keys.ENTER);
        ReusableMethods.wait(2);
        List<String> expectedNameList = ReusableMethods.stringListesineDonustur(adminPage.columnJustNameOfMerchantRegistration);
        Assert.assertNotEquals(acutualNameList, expectedNameList);
        ReusableMethods.wait(2);
        JSUtilities.clickWithJS(Driver.getDriver(),adminPage.membershipHead);
        //Verify that item's data changed order.
        List<String> expectedMembershipList = ReusableMethods.stringListesineDonustur(adminPage.columnMembershipOfMerchantRegestration);
        Collections.sort(expectedMembershipList);
        List<String> actualMembershipList = ReusableMethods.stringListesineDonustur(adminPage.columnMembershipOfMerchantRegestration);
        Assert.assertEquals(actualMembershipList, expectedMembershipList);

        Driver.quitDriver();
    }

    @Test
    public void test_4306() {
        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        ReusableMethods.accessAdmin("adminuser_iqbal","adminpassword_iqbal");
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
    public void test_4307() {
        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        ReusableMethods.accessAdmin("adminuser_iqbal","adminpassword_iqbal");
        adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
        adminPage.merchantRegestration.sendKeys(Keys.ENTER);
        ReusableMethods.wait(2);
        adminPage.dateInputBox.sendKeys(Keys.ENTER);
        int expectedDropDownNum = Integer.parseInt(ConfigReader.getProperty("numberOfDateRangeSize"));// =7
        List<String> dropdownList = ReusableMethods.stringListesineDonustur(adminPage.dateRange);
        int actualDropDownNum = dropdownList.size();
        ReusableMethods.wait(5);
        Assert.assertEquals(actualDropDownNum, expectedDropDownNum);
        //click on input box of calendar and verify visibility 7 data in drop
        ReusableMethods.wait(2);
        Random random=new Random();
        int digit=random.nextInt(7);
       // Assert.assertTrue(adminPage.dateRange.get(digit).isDisplayed());
        ReusableMethods.wait(3);

        JSUtilities.clickWithJS(Driver.getDriver(),adminPage.dateRange.get(digit));

        Driver.quitDriver();
    }

    @Test
    public void test_4308() {
        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        ReusableMethods.accessAdmin("adminuser_iqbal","adminpassword_iqbal");
        adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
        adminPage.merchantRegestration.sendKeys(Keys.ENTER);
        ReusableMethods.wait(2);
        adminPage.dateInputBox.sendKeys(Keys.ENTER);
        //click on input box of calendar and enter a renge of date in dropdown.
        ReusableMethods.wait(2);
        int number1 = Integer.parseInt((ConfigReader.getProperty("numberOfDateDropDown")));
        System.out.println(adminPage.weekList.get(number1));
        ReusableMethods.wait(2);
        Assert.assertTrue(adminPage.weekList.get(number1).isEnabled());
        ReusableMethods.wait(2);
        adminPage.weekList.get(number1).sendKeys(Keys.ENTER);
        ReusableMethods.wait(2);
        int number2 = Integer.parseInt((ConfigReader.getProperty("number_2_OfDateDropDown")));
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
    public void test_4309() {
        Driver.getDriver().get("about:blank");
        ReusableMethods.accessAdmin("adminuser_iqbal","adminpassword_iqbal");
        adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
        adminPage.merchantRegestration.sendKeys(Keys.ENTER);
        ReusableMethods.wait(2);
        adminPage.dateInputBox.sendKeys(Keys.ENTER);
        ReusableMethods.wait(5);

        JSUtilities.clickWithJS(Driver.getDriver(), adminPage.prevFlashCalendar);
        //Click the "< "sign of calendar .
        ReusableMethods.wait(2);
        System.out.println("exp:" + ConfigReader.getProperty("monthName2"));
        System.out.println("act:" + adminPage.calendarLefttMonth.getText());
        String expectedMonth = adminPage.calendarLefttMonth.getText();
        String actualMonth = adminPage.calendarRightMonth.getText();
        Assert.assertNotEquals(actualMonth, expectedMonth);
        //Verify single visibility of "July".
        Driver.quitDriver();
    }

    @Test
    public void test_4310() {
        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        ReusableMethods.accessAdmin("adminuser_iqbal","adminpassword_iqbal");
        adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
        adminPage.merchantRegestration.sendKeys(Keys.ENTER);
        ReusableMethods.wait(2);
        adminPage.dateInputBox.sendKeys(Keys.ENTER);
        JSUtilities.clickWithJS(Driver.getDriver(), adminPage.prevFlashCalendar);
        JSUtilities.clickWithJS(Driver.getDriver(), adminPage.prevFlashCalendar);
        JSUtilities.clickWithJS(Driver.getDriver(), adminPage.prevFlashCalendar);
        //Click the "< "sign of calendar .
        ReusableMethods.wait(2);

        JSUtilities.getTextWithJS(Driver.getDriver(), adminPage.calendarLefttMonth);
        String expectedMonth = adminPage.calendarLefttMonth.getText();
        JSUtilities.getTextWithJS(Driver.getDriver(), adminPage.calendarRightMonth);
        String actualMonth = adminPage.calendarRightMonth.getText();
        System.out.println("exp:" + adminPage.calendarRightMonth.getText());
        System.out.println("act:" + adminPage.calendarLefttMonth.getText());
        Assert.assertNotEquals(actualMonth, expectedMonth);
        //Verify single visibility of "May".
        Driver.quitDriver();
    }

    @Test
    public void test_4311() {
        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        ReusableMethods.accessAdmin("adminuser_iqbal","adminpassword_iqbal");
        adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
        adminPage.merchantRegestration.sendKeys(Keys.ENTER);
        ReusableMethods.wait(2);
        adminPage.dateInputBox.sendKeys(Keys.ENTER);
        JSUtilities.clickWithJS(Driver.getDriver(), adminPage.prevFlashCalendar);
        JSUtilities.clickWithJS(Driver.getDriver(), adminPage.prevFlashCalendar);

        String expectedMonth = ConfigReader.getProperty("monthName1");
        JSUtilities.getTextWithJS(Driver.getDriver(), adminPage.calendarLefttMonth);
        String actual1Month = adminPage.calendarLefttMonth.getText();
        JSUtilities.getTextWithJS(Driver.getDriver(), adminPage.calendarRightMonth);
        String actual2Month = adminPage.calendarRightMonth.getText();

        Assert.assertEquals(actual1Month, expectedMonth);
        Assert.assertEquals(actual2Month, expectedMonth);

        //Verify  the  "< "sign of calendar  is visible.
        //Click the "< "sign of calendar .
        //Verify single visibility of "Jun".
        Driver.quitDriver();
    }

    @Test
    public void test_4312() {
        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        ReusableMethods.accessAdmin("adminuser_iqbal","adminpassword_iqbal");
        adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
        adminPage.merchantRegestration.sendKeys(Keys.ENTER);
        ReusableMethods.wait(2);
        //Click on Status Box
        Assert.assertTrue(adminPage.statusBoxFilter.isDisplayed());
        JSUtilities.clickWithJS(Driver.getDriver(), adminPage.statusBoxFilter);
        Random random=new Random();
        int digit=random.nextInt(Integer.parseInt(ConfigReader.getProperty("numberOfCalendarDropDownElement")));
        Assert.assertTrue(adminPage.statusDropDown.get(digit).isDisplayed());

        int expectednumberOfElement = Integer.parseInt(ConfigReader.getProperty("numberOfCalendarDropDownElement"));
        int actualnumberOfDropDownElement = adminPage.statusDropDown.size();
        //Verify dropdown has 5 element
        Assert.assertEquals(actualnumberOfDropDownElement, expectednumberOfElement);
        Assert.assertTrue(adminPage.statusDropDown.get(digit).isEnabled());
        JSUtilities.clickWithJS(Driver.getDriver(),adminPage.statusDropDown.get(digit));
        //Verify dropdown is clickable
        Assert.assertTrue(adminPage.checkMark.get(digit).isDisplayed());

        Driver.quitDriver();
    }

    @Test
    public void test_4313() {
        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        ReusableMethods.accessAdmin("adminuser_iqbal","adminpassword_iqbal");
        adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
        adminPage.merchantRegestration.sendKeys(Keys.ENTER);
        ReusableMethods.wait(2);

        JSUtilities.clickWithJS(Driver.getDriver(), adminPage.statusBoxFilter);
        Random random = new Random();
        int digit = random.nextInt(5);
        JSUtilities.clickWithJS(Driver.getDriver(), adminPage.statusDropDown.get(digit));
        //Click randomly on one element of dropdown.
        JSUtilities.getTextWithJS(Driver.getDriver(), adminPage.statusDropDown.get(digit));
        String expectedFiltered = adminPage.statusDropDown.get(digit).getText();
        System.out.println("exp:" + expectedFiltered);

        ReusableMethods.wait(2);
        if(adminPage.noDataAvailableInTable.getText().contains(ConfigReader.getProperty("bottomOfMerchantPage"))){
          Assert.assertTrue(adminPage.noDataAvailableInTable.isDisplayed());
        }else {
            JSUtilities.getTextWithJS(Driver.getDriver(), adminPage.filteredByStatusBoxDropDown.get(0));
            String actualFiltered = adminPage.filteredByStatusBoxDropDown.get(0).getText();
            System.out.println("act:" + actualFiltered);
            ReusableMethods.wait(2);
            Assert.assertTrue(actualFiltered.contains(expectedFiltered));
        }
        Driver.quitDriver();
    }
    @Test
    public void test_4314() {
        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        ReusableMethods.accessAdmin("adminuser_iqbal","adminpassword_iqbal");
        adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
        adminPage.merchantRegestration.sendKeys(Keys.ENTER);
        ReusableMethods.wait(2);

        JSUtilities.clickWithJS(Driver.getDriver(), adminPage.statusBoxFilter);
        Random random = new Random();
        int digit1 = random.nextInt(5);
        int digit2 = random.nextInt(4);
       if(digit1==digit2){
          digit2= digit2+1;
       }
        JSUtilities.clickWithJS(Driver.getDriver(), adminPage.statusDropDown.get(digit1));
        JSUtilities.clickWithJS(Driver.getDriver(), adminPage.statusDropDown.get(digit2));
        //Click randomly on one element of dropdown.

        JSUtilities.getTextWithJS(Driver.getDriver(), adminPage.statusDropDown.get(digit1));
        String expectedFiltered1 = adminPage.statusDropDown.get(digit1).getText();


        JSUtilities.getTextWithJS(Driver.getDriver(), adminPage.statusDropDown.get(digit2));
        String expectedFiltered2 = adminPage.statusDropDown.get(digit2).getText();
      

        ReusableMethods.wait(2);
        if(adminPage.noDataAvailableInTable.getText().contains(ConfigReader.getProperty("bottomOfMerchantPage"))){
            Assert.assertTrue(adminPage.noDataAvailableInTable.isDisplayed());
        }else {
            JSUtilities.getTextWithJS(Driver.getDriver(), adminPage.filteredByStatusBoxDropDown.get(0));
            String actualFiltered = adminPage.filteredByStatusBoxDropDown.get(0).getText();

            ReusableMethods.wait(2);
            Assert.assertTrue(actualFiltered.contains(expectedFiltered1));
            Assert.assertTrue(actualFiltered.contains(expectedFiltered2));
        }

        Driver.quitDriver();
    }
    @Test
    public void test_4315() {
        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        ReusableMethods.accessAdmin("adminuser_iqbal","adminpassword_iqbal");
        adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
        adminPage.merchantRegestration.sendKeys(Keys.ENTER);
        ReusableMethods.wait(2);
        Assert.assertTrue(adminPage.yellowFilterButton.isDisplayed());
        Assert.assertTrue(adminPage.yellowFilterButton.getText().contains(ConfigReader.getProperty("filterBoxText")));
        //Verify visibility of icon name.
        Driver.quitDriver();
    }

    @Test
    public void test_4316() {
        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        ReusableMethods.accessAdmin("adminuser_iqbal", "adminpassword_iqbal");
        adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
        adminPage.merchantRegestration.sendKeys(Keys.ENTER);
        ReusableMethods.wait(2);
        //Click on anonymus icon.
        adminPage.yellowFilterButton.sendKeys(Keys.ENTER);
        //Verify the visibility of "Filters"
        ReusableMethods.wait(2);
        Assert.assertTrue(adminPage.topDatas.get(7).isDisplayed());
        //Verify the visibility of "By Merchant"
        Assert.assertTrue(adminPage.byMerchant.isDisplayed());
        //Verify the visibility of input box.
        ReusableMethods.wait(2);
        Assert.assertTrue(adminPage.filterInputBoxFlash.isDisplayed());
        Assert.assertTrue(adminPage.applyFilters.isDisplayed());
        Assert.assertTrue(adminPage.clearFilters.isDisplayed());

        Driver.quitDriver();
    }
    @Test
    public void test_4317() {
        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        ReusableMethods.accessAdmin("adminuser_iqbal", "adminpassword_iqbal");
        adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
        adminPage.merchantRegestration.sendKeys(Keys.ENTER);
        ReusableMethods.wait(2);
        //Click the input box.
        //JSUtilities.clickWithJS(Driver.getDriver(),adminPage.yellowFilterInputBox);
        adminPage.yellowFilterInputBox.sendKeys(Keys.ENTER);
       // JSUtilities.clickWithJS(Driver.getDriver(),adminPage.filterInputBoxFlash);
        adminPage.filterInputBoxFlash.click();
        ReusableMethods.wait(2);
        System.out.println("title:"+adminPage.titleOfYellowFilterBox);
        JSUtilities.clickWithJS(Driver.getDriver(),adminPage.titleOfYellowFilterBox);
        //Verify the visibility of dropdown with some merchant name.

        JSUtilities.clickWithJS(Driver.getDriver(),adminPage.applyFilters);
         String expectedfoodFilter=adminPage.titleOfYellowFilterBox.getText();
         for(WebElement   each:adminPage.columnJustNameOfMerchantRegistration){
             Assert.assertEquals(each.getText(),expectedfoodFilter);
         }
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
    public void test_4318() {
        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        ReusableMethods.accessAdmin("adminuser_iqbal", "adminpassword_iqbal");
        adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
        adminPage.merchantRegestration.sendKeys(Keys.ENTER);
        ReusableMethods.wait(2);
        //Verify visibility of "Total Registered" and the opposite number.
        for(int i=0;i<5;i++){
            Assert.assertTrue(adminPage.topRow.get(i).isDisplayed());
        }
        for(int i=1;i<6;i++){
            Assert.assertTrue(adminPage.valueOfTopRow.get(i).isDisplayed());
        }

        Driver.getDriver();
    }
    @Test
    public void test_4319() {
        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        ReusableMethods.accessAdmin("adminuser_iqbal", "adminpassword_iqbal");
        adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
        adminPage.merchantRegestration.sendKeys(Keys.ENTER);
        ReusableMethods.wait(2);
        //Check that the sum of "Total Active" and "Total Inactive" is equalls to "Total Registered"
      int totalActive=Integer.parseInt(adminPage.valueOfTopRow.get(4).getText());
      int totalInactive=Integer.parseInt(adminPage.valueOfTopRow.get(5).getText());
        ReusableMethods.wait(3);

        int expectedValue=totalInactive+totalActive;
        //System.out.println("exo:"+expectedValue);
        int actualValue=Integer.parseInt(adminPage.valueOfTopRow.get(1).getText());
        //System.out.println("act:"+actualValue);
        Assert.assertEquals(actualValue,expectedValue);// sum of "Total Active" and "Total Inactive
        Driver.quitDriver();
    }

    @Test
    public void test_4320() {
        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        ReusableMethods.accessAdmin("adminuser_iqbal","adminpassword_iqbal");
        adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
        adminPage.merchantRegestration.sendKeys(Keys.ENTER);
        ReusableMethods.wait(2);
        //Check that the sum of "Commission Total" and "Membership Total" is equalls to "Total Active"
        Driver.quitDriver();
    }

    @Test
    public void test_4321() {
        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        ReusableMethods.accessAdmin("adminuser_iqbal","adminpassword_iqbal");
        adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
        adminPage.merchantRegestration.sendKeys(Keys.ENTER);
        ReusableMethods.wait(2);
        //Check that the number written before the entries in "Showing 1 to 10 of 38 entries"at the bottom of page is equals to "Total Registered"
        Driver.quitDriver();
    }

    @Test
    public void test_4322() {
        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        ReusableMethods.accessAdmin("adminuser_iqbal","adminpassword_iqbal");
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
    public void test_4323() {
        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        ReusableMethods.accessAdmin("adminuser_iqbal","adminpassword_iqbal");
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
    public void test_4324() {
        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        ReusableMethods.accessAdmin("adminuser_iqbal","adminpassword_iqbal");
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
