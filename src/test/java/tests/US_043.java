package tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.google.common.base.Verify;
import org.bouncycastle.crypto.digests.Kangaroo;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import utilities.*;

public class US_043 extends TestBaseRapor {
    static AdminPage adminPage;
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void test_4301() throws IOException{
        adminPage = new AdminPage();


        Driver.getDriver().get("about:blank");
        extentTest.info("User open the browser");
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        extentTest.info("The user opens the URL");
        ReusableMethods.accessAdmin("adminuser_iqbal", "adminpassword_iqbal");
        extentTest.info("The user enters user name and password to login");
        adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
        extentTest.info("The user click on the Reports from menu");
        adminPage.merchantRegestration.sendKeys(Keys.ENTER);
        extentTest.info("The user click on the Merchant Registration .");
        ReusableMethods.wait(3);
        //Verify that the "Merchant Regestration" item is visible.
        Assert.assertTrue(adminPage.topDatas.get(1).isDisplayed());
        extentTest.pass("The user correctness the visibility of Merchant Registration item .");
        //Click on "Merchant Regestration" item.
        JSUtilities.clickWithJS(Driver.getDriver(), adminPage.topDatas.get(1));
        extentTest.info("The user clicks on Merchant Registration item .");
        //Verify the Url address contains "merchant registration".
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(ConfigReader.getProperty("urlContent5")));
        extentTest.pass("The user correctness the page is entered contains merchant registration .");
        Driver.getDriver();
        extentTest.info("The user closes the browser .");
    }

    @Test
    public void test_4302() {
        adminPage = new AdminPage();

        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        ReusableMethods.accessAdmin("adminuser_iqbal", "adminpassword_iqbal");
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
    public void test_4303() throws IOException{
        adminPage = new AdminPage();

        Driver.getDriver().get("about:blank");
        extentTest.info("User open the browser");
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        extentTest.info("The user opens the URL");
        ReusableMethods.accessAdmin("adminuser_iqbal", "adminpassword_iqbal");
        extentTest.info("The user enters user name and password to login");
        adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
        extentTest.info("The user click on the Reports from menu");
        adminPage.merchantRegestration.sendKeys(Keys.ENTER);
        extentTest.info("The user click on the Merchant Registration .");
        ReusableMethods.wait(3);
        //Verify visibility of "Name"in the header of table.
        Assert.assertTrue(adminPage.nameHead.isDisplayed());
        extentTest.pass("The user correctness visibility of Name item in table head.");
        //Verify visibility of "Address"in the header of table.
        Assert.assertTrue(adminPage.addressHead.isDisplayed());
        extentTest.pass("The user correctness visibility of Address item in table head.");
        //Verify visibility of "Membership Program"in the header of table.
        Assert.assertTrue(adminPage.membershipHead.isDisplayed());
        extentTest.pass("The user correctness visibility of Membership Program item in table head.");
        List<String> expectedNameList = ReusableMethods.stringListesineDonustur(adminPage.columnJustNameOfMerchantRegistration);
        extentTest.info("The user expect that the list of secound column of table according to alphabet.");
        Collections.sort(expectedNameList);

        List<String> actualNameList = ReusableMethods.stringListesineDonustur(adminPage.columnJustNameOfMerchantRegistration);

        Assert.assertEquals(actualNameList, expectedNameList);
        extentTest.pass("The user compares the column of table and the sorted one .");
        Driver.quitDriver();
        extentTest.info("Closes the browser . ");
    }

    @Test
    public void test_4304() {
        adminPage = new AdminPage();

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
        adminPage = new AdminPage();

        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        ReusableMethods.accessAdmin("adminuser_iqbal", "adminpassword_iqbal");
        adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
        adminPage.merchantRegestration.sendKeys(Keys.ENTER);
        ReusableMethods.wait(2);

        ReusableMethods.wait(2);
        JSUtilities.clickWithJS(Driver.getDriver(), adminPage.membershipHead);
        ReusableMethods.wait(2);
        //Verify that item's data changed order.
        List<String> expectedMembershipList = ReusableMethods.stringListesineDonustur(adminPage.columnMembershipOfMerchantRegestration);
        Collections.sort(expectedMembershipList);
        List<String> actualMembershipList = ReusableMethods.stringListesineDonustur(adminPage.columnMembershipOfMerchantRegestration);
        Assert.assertNotEquals(actualMembershipList, expectedMembershipList);

        Driver.quitDriver();
    }

    @Test
    public void test_4306() throws IOException{
        adminPage = new AdminPage();

        Driver.getDriver().get("about:blank");
        extentTest.info("User open the browser");

        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        extentTest.info("The user opens the URL");

        ReusableMethods.accessAdmin("adminuser_iqbal", "adminpassword_iqbal");
        extentTest.info("The user enters user name and password to login");

        adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
        extentTest.info("The user click on the Reports from menu");

        adminPage.merchantRegestration.sendKeys(Keys.ENTER);
        extentTest.info("The user click on the Merchant Registration .");

        Assert.assertTrue(adminPage.dateInputBox.isDisplayed());
        extentTest.pass("The user correctness the visibility of input box .");

        //Verify visibility of input box of calendar .
        Assert.assertTrue(adminPage.calendarIcone.isDisplayed());
        extentTest.pass("The user correctness the visibility of calendar box");

        //Verify visibility of calendar icon.

        JSUtilities.clickWithJS(Driver.getDriver(), adminPage.calendarIcone);
        extentTest.info("The user click on the calendar box .");

        Driver.quitDriver();
        extentTest.info("The user closes the browser .");
    }

    @Test
    public void test_4307() {
        adminPage = new AdminPage();

        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        ReusableMethods.accessAdmin("adminuser_iqbal", "adminpassword_iqbal");
        adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
        adminPage.merchantRegestration.sendKeys(Keys.ENTER);
        ReusableMethods.wait(2);

        //Verify number of eklement in dropdown
        JSUtilities.clickWithJS(Driver.getDriver(), adminPage.dateInputBox);
        int expectedDropDownNum = Integer.parseInt(ConfigReader.getProperty("numberOfDateRangeSize"));// =7
        List<String> dropdownList = ReusableMethods.stringListesineDonustur(adminPage.dateRange);
        int actualDropDownNum = dropdownList.size();
        ReusableMethods.wait(5);
        Assert.assertEquals(actualDropDownNum, expectedDropDownNum);
        //click on input box of calendar and verify visibility 7 data in drop
        ReusableMethods.wait(2);
        Random random = new Random();
        int digit = random.nextInt(7);
        Assert.assertTrue(adminPage.dateRange.get(digit).isDisplayed());
        ReusableMethods.wait(3);

        JSUtilities.clickWithJS(Driver.getDriver(), adminPage.dateRange.get(digit));

        Driver.quitDriver();
    }

    @Test
    public void test_4308() {
        adminPage = new AdminPage();

        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        ReusableMethods.accessAdmin("adminuser_iqbal", "adminpassword_iqbal");
        adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
        adminPage.merchantRegestration.sendKeys(Keys.ENTER);
        ReusableMethods.wait(2);

        JSUtilities.clickWithJS(Driver.getDriver(), adminPage.dateInputBox);
        ReusableMethods.wait(2);

        Random random = new Random();
        int number = random.nextInt(13);

        Assert.assertTrue(adminPage.weekCounter.get(number).isDisplayed());
        Assert.assertTrue(adminPage.calendarLefttMonth.isDisplayed());
        Assert.assertTrue(adminPage.calendarRightMonth.isDisplayed());
        Assert.assertTrue(adminPage.prevFlashCalendar.isDisplayed());

        Driver.quitDriver();
    }

    @Test
    public void test_4309() throws IOException{
        adminPage = new AdminPage();

        Driver.getDriver().get("about:blank");
        extentTest.info("User open the browser");
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        extentTest.info("The user opens the URL");
        ReusableMethods.accessAdmin("adminuser_iqbal", "adminpassword_iqbal");
        extentTest.info("The user enters user name and password to login");
        adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
        extentTest.info("The user click on the Reports from menu");
        adminPage.merchantRegestration.sendKeys(Keys.ENTER);
        extentTest.info("The user click on the Merchant Registration .");
        ReusableMethods.wait(3);
        adminPage.dateInputBox.click();
        JSUtilities.clickWithJS(Driver.getDriver(), adminPage.prevFlashCalendar);
        extentTest.info("The user click on the check mark .");
        //Click the "< "sign of calendar .
        ReusableMethods.wait(2);
        extentTest.info("The user wait .");
        //System.out.println("exp:" + ConfigReader.getProperty("monthName2"));
        //System.out.println("act:" + adminPage.calendarLefttMonth.getText());
        String expectedMonth = adminPage.calendarLefttMonth.getText();
        String actualMonth = adminPage.calendarRightMonth.getText();
        Assert.assertNotEquals(actualMonth, expectedMonth);
        extentTest.pass("The user ");
        //Verify single visibility of "July".
        Driver.quitDriver();
    }

    @Test
    public void test_4310() throws IOException {
        adminPage = new AdminPage();

        Driver.getDriver().get("about:blank");
        extentTest.info("User open the browser");
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        extentTest.info("The user opens the URL");
        ReusableMethods.accessAdmin("adminuser_iqbal", "adminpassword_iqbal");
        extentTest.info("The user enters user name and password to login");
        adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
        extentTest.info("The user click on the Reports from menu");
        adminPage.merchantRegestration.sendKeys(Keys.ENTER);
        extentTest.info("The user click on the Merchant Registration .");
        ReusableMethods.wait(3);
        adminPage.dateInputBox.sendKeys(Keys.ENTER);
        JSUtilities.clickWithJS(Driver.getDriver(), adminPage.prevFlashCalendar);
        JSUtilities.clickWithJS(Driver.getDriver(), adminPage.prevFlashCalendar);
        JSUtilities.clickWithJS(Driver.getDriver(), adminPage.prevFlashCalendar);
        //Click the "< "sign of calendar .
        ReusableMethods.wait(3);

        JSUtilities.getTextWithJS(Driver.getDriver(), adminPage.calendarLefttMonth);
        String expectedMonth = adminPage.calendarLefttMonth.getText();
        extentTest.info("The user confirm the text of left calendar .");

        JSUtilities.getTextWithJS(Driver.getDriver(), adminPage.calendarRightMonth);
        String actualMonth = adminPage.calendarRightMonth.getText();
        extentTest.info("The user confirm the text of Right calendar .");

        Assert.assertNotEquals(actualMonth, expectedMonth);
        extentTest.pass("The user expected the month name of per calendar not to be equal .");
        //Verify single visibility of "May".
        Driver.quitDriver();
        extentTest.info("The user closes the browser .");
    }

    @Test
    public void test_4311() throws IOException{
        adminPage = new AdminPage();

        Driver.getDriver().get("about:blank");
        extentTest.info("User open the browser");
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        extentTest.info("The user opens the URL");
        ReusableMethods.accessAdmin("adminuser_iqbal", "adminpassword_iqbal");
        extentTest.info("The user enters user name and password to login");
        adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
        extentTest.info("The user click on the Reports from menu");
        adminPage.merchantRegestration.sendKeys(Keys.ENTER);
        extentTest.info("The user click on the Merchant Registration .");
        ReusableMethods.wait(3);
        extentTest.info("The user wait .");

        JSUtilities.clickWithJS(Driver.getDriver(), adminPage.dateInputBox);
        extentTest.info("The user click on input box and dropdown displayed .");

        JSUtilities.clickWithJS(Driver.getDriver(), adminPage.prevFlashCalendar);
        JSUtilities.clickWithJS(Driver.getDriver(), adminPage.prevFlashCalendar);
        extentTest.info("The user double click on check mark to change month name .");

        String expectedMonth = ConfigReader.getProperty("monthName1");
        extentTest.info("The user look for the month name Jun .");

        JSUtilities.getTextWithJS(Driver.getDriver(), adminPage.calendarLefttMonth);
        String actual1Month = adminPage.calendarLefttMonth.getText();
        extentTest.info("The user confirm the text of left calendar .");

        JSUtilities.getTextWithJS(Driver.getDriver(), adminPage.calendarRightMonth);
        String actual2Month = adminPage.calendarRightMonth.getText();
        extentTest.info("The user confirm the text of right calendar .");

        Assert.assertEquals(actual1Month, expectedMonth);
        extentTest.pass("The user expect one calendar month name equal to Jun .");

        Assert.assertEquals(actual2Month, expectedMonth);
        extentTest.pass("The user expect one calendar month name equal to Jun .");

        Driver.quitDriver();
        extentTest.info("The user closes the browser .");
    }

    @Test
    public void test_4312() {
        adminPage = new AdminPage();

        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        ReusableMethods.accessAdmin("adminuser_iqbal", "adminpassword_iqbal");
        adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
        adminPage.merchantRegestration.sendKeys(Keys.ENTER);
        ReusableMethods.wait(2);
        //Click on Status Box
        Assert.assertTrue(adminPage.statusBoxFilter.isDisplayed());
        JSUtilities.clickWithJS(Driver.getDriver(), adminPage.statusBoxFilter);

        Random random = new Random();
        int digit = random.nextInt(Integer.parseInt(ConfigReader.getProperty("numberOfCalendarDropDownElement")));

        Assert.assertTrue(adminPage.statusDropDown.get(digit).isDisplayed());

        int expectednumberOfElement = Integer.parseInt(ConfigReader.getProperty("numberOfCalendarDropDownElement"));
        int actualnumberOfDropDownElement = adminPage.statusDropDown.size();
        //Verify dropdown has 5 element
        Assert.assertEquals(actualnumberOfDropDownElement, expectednumberOfElement);
        Assert.assertTrue(adminPage.statusDropDown.get(digit).isEnabled());

        JSUtilities.clickWithJS(Driver.getDriver(), adminPage.statusDropDown.get(digit));
        //Verify dropdown is clickable
        Assert.assertTrue(adminPage.checkMark.get(digit).isDisplayed());

        Driver.quitDriver();
    }

    @Test
    public void test_4313() {
        adminPage = new AdminPage();

        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        ReusableMethods.accessAdmin("adminuser_iqbal", "adminpassword_iqbal");
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
        if (adminPage.noDataAvailableInTable.getText().contains(ConfigReader.getProperty("bottomOfMerchantPage"))) {
            Assert.assertTrue(adminPage.noDataAvailableInTable.isDisplayed());
        } else {
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
        adminPage = new AdminPage();

        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        ReusableMethods.accessAdmin("adminuser_iqbal", "adminpassword_iqbal");
        adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
        adminPage.merchantRegestration.sendKeys(Keys.ENTER);
        ReusableMethods.wait(2);

        JSUtilities.clickWithJS(Driver.getDriver(), adminPage.statusBoxFilter);
        Random random = new Random();
        int digit1 = random.nextInt(5);
        int digit2 = random.nextInt(4);
        if (digit1 == digit2) {
            digit2 = digit2 + 1;
        }
        JSUtilities.clickWithJS(Driver.getDriver(), adminPage.statusDropDown.get(digit1));
        JSUtilities.clickWithJS(Driver.getDriver(), adminPage.statusDropDown.get(digit2));
        //Click randomly on one element of dropdown.

        JSUtilities.getTextWithJS(Driver.getDriver(), adminPage.statusDropDown.get(digit1));
        String expectedFiltered1 = adminPage.statusDropDown.get(digit1).getText();


        JSUtilities.getTextWithJS(Driver.getDriver(), adminPage.statusDropDown.get(digit2));
        String expectedFiltered2 = adminPage.statusDropDown.get(digit2).getText();


        ReusableMethods.wait(2);
        if (adminPage.noDataAvailableInTable.getText().contains(ConfigReader.getProperty("bottomOfMerchantPage"))) {
            Assert.assertTrue(adminPage.noDataAvailableInTable.isDisplayed());
        } else {
            JSUtilities.getTextWithJS(Driver.getDriver(), adminPage.filteredByStatusBoxDropDown.get(0));
            String actualFiltered = adminPage.filteredByStatusBoxDropDown.get(0).getText();

            ReusableMethods.wait(2);
            Assert.assertTrue(actualFiltered.contains(expectedFiltered1));
            Assert.assertTrue(actualFiltered.contains(expectedFiltered2));
        }

        Driver.quitDriver();
    }

    @Test
    public void test_4315()throws IOException{
        adminPage = new AdminPage();

        Driver.getDriver().get("about:blank");
        extentTest.info("User open the browser");
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        extentTest.info("The user opens the URL");
        ReusableMethods.accessAdmin("adminuser_iqbal", "adminpassword_iqbal");
        extentTest.info("The user enters user name and password to login");
        adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
        extentTest.info("The user click on the Reports from menu");
        adminPage.merchantRegestration.sendKeys(Keys.ENTER);
        extentTest.info("The user click on the Merchant Registration .");
        ReusableMethods.wait(3);
        extentTest.info("The user wait .");

        Assert.assertTrue(adminPage.yellowFilterButton.isDisplayed());
        extentTest.pass("The user correctness the visibility of yellow filter button .");

        Assert.assertTrue(adminPage.yellowFilterButton.getText().contains(ConfigReader.getProperty("filterBoxText")));
        extentTest.pass("The user correctness visibility of the the bottun name .");

        //Verify visibility of icon name.
        Driver.quitDriver();
        extentTest.info("The user closes the browser .");
    }

    @Test
    public void test_4316() {
        adminPage = new AdminPage();

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
        adminPage = new AdminPage();

        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        ReusableMethods.accessAdmin("adminuser_iqbal", "adminpassword_iqbal");
        adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
        adminPage.merchantRegestration.sendKeys(Keys.ENTER);
        ReusableMethods.wait(2);
        //Click the input box.
        adminPage.yellowFilterButton.sendKeys(Keys.ENTER);

        ReusableMethods.wait(2);

      //(adminPage.inputBoxYellowFilter).click();
        ReusableMethods.wait(2);

        for (WebElement each : adminPage.itemsInfilterBox) {
            Assert.assertTrue(each.isDisplayed());
        }
        Random random = new Random();
        int digit1 = random.nextInt(8);
        actions.contextClick(adminPage.itemsInfilterBox.get(digit1)).perform();
        //Verify the visibility of dropdown with some merchant name.
        actions.moveToElement(adminPage.applyFilters).sendKeys(Keys.ENTER).perform();

        String expectedfoodFilter = adminPage.itemsInfilterBox.get(digit1).getText();
        for (WebElement each : adminPage.columnJustNameOfMerchantRegistration) {
            Assert.assertEquals(each.getText(), expectedfoodFilter);
        }

        Driver.quitDriver();
    }


    @Test
    public void test_4318() {
        adminPage=new AdminPage();
        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        ReusableMethods.accessAdmin("adminuser_iqbal", "adminpassword_iqbal");
        adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
        adminPage.merchantRegestration.sendKeys(Keys.ENTER);
        ReusableMethods.wait(2);
        //Verify visibility of "Total Registered" and the opposite number.
        for (int i = 0; i < 5; i++) {
            Assert.assertTrue(adminPage.topRow.get(i).isDisplayed());
        }
        for (int i = 1; i < 6; i++) {
            Assert.assertTrue(adminPage.valueOfTopRow.get(i).isDisplayed());
        }

        Driver.getDriver();
    }

    @Test
    public void test_4319() {
        adminPage=new AdminPage();
        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        ReusableMethods.accessAdmin("adminuser_iqbal", "adminpassword_iqbal");
        adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
        adminPage.merchantRegestration.sendKeys(Keys.ENTER);
        ReusableMethods.wait(2);
        //Check that the sum of "Total Active" and "Total Inactive" is equalls to "Total Registered"
        int totalActive = Integer.parseInt(adminPage.valueOfTopRow.get(4).getText());
        int totalInactive = Integer.parseInt(adminPage.valueOfTopRow.get(5).getText());
        ReusableMethods.wait(3);

        int expectedValue = totalInactive + totalActive;
        //System.out.println("exo:"+expectedValue);
        int actualValue = Integer.parseInt(adminPage.valueOfTopRow.get(1).getText());
        //System.out.println("act:"+actualValue);
        Assert.assertEquals(actualValue, expectedValue);// sum of "Total Active" and "Total Inactive
        Driver.quitDriver();
    }

    @Test
    public void test_4320() {
        adminPage=new AdminPage();
        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        ReusableMethods.accessAdmin("adminuser_iqbal", "adminpassword_iqbal");
        adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
        adminPage.merchantRegestration.sendKeys(Keys.ENTER);
        ReusableMethods.wait(2);
        //Check that the sum of "Commission Total" and "Membership Total" is equalls to "Total Active"
        Driver.quitDriver();
    }

    @Test
    public void test_4321() {
        adminPage=new AdminPage();
        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        ReusableMethods.accessAdmin("adminuser_iqbal", "adminpassword_iqbal");
        adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
        adminPage.merchantRegestration.sendKeys(Keys.ENTER);
        ReusableMethods.wait(2);
        ///(adminPage.pagesNevigate.size()-2)
        JSUtilities.scrollToBottom(Driver.getDriver());
        List<String> logoList = ReusableMethods.stringListesineDonustur(adminPage.logoMerchant);

        String expectedNum = adminPage.valueOfTopRow.get(1).getText();
        String actualNum = adminPage.showingEntryInfo.getText();
        //System.out.println("exp:"+expectedNum);
        Assert.assertTrue(actualNum.contains(expectedNum));

        //Check that the number in "Showing 1 to 10 of 38D entries" is equals to "Total Registered"
        Driver.quitDriver();
    }

    @Test
    public void test_4322()throws IOException {
        adminPage=new AdminPage();
        Driver.getDriver().get("about:blank");
        extentTest.info("User open the browser");
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        extentTest.info("The user opens the URL");
        ReusableMethods.accessAdmin("adminuser_iqbal", "adminpassword_iqbal");
        extentTest.info("The user enters user name and password to login");
        adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
        extentTest.info("The user click on the Reports from menu");
        adminPage.merchantRegestration.sendKeys(Keys.ENTER);
        extentTest.info("The user click on the Merchant Registration .");
        ReusableMethods.wait(3);
        extentTest.info("The user wait .");
        //The notification asign is visible and active.
        Assert.assertTrue(adminPage.notificationsIcon.isDisplayed());
        extentTest.pass("The user correctness visibility of notification icon .");
        Assert.assertTrue(adminPage.notificationsIcon.isEnabled());
        extentTest.pass("The user correctness activity of notification icon .");
        JSUtilities.clickWithJS(Driver.getDriver(), adminPage.notificationsIcon);
        extentTest.info("The user click the notification icon .");
        Assert.assertTrue(adminPage.notificationsText.isEnabled());
        extentTest.pass("The user correctness existence of text of notification icon .");
        List<String> sortedOrderList = new ArrayList<>();


        List<String> strOrderList = ReusableMethods.stringListesineDonustur(adminPage.orderOfNotification);
        for (String each : strOrderList) {
            sortedOrderList.add(each.replaceAll("\\D", ""));
        }

        //System.out.println("orderNUM :"+orderNum);
        Collections.sort(sortedOrderList);
        //System.out.println("orderNumSorted :"+orderNumSorted);
     
        for (String each1 : strOrderList){
            for (String each2 : sortedOrderList){
               Assert.assertTrue(each1.contains(each2));
            }
        }
        extentTest.pass("The user correctness that number of orders orderly.");
        //viewAll bottun
        Assert.assertTrue(adminPage.viewAllButton.isDisplayed());
        extentTest.pass("The user correctness visibility of the view all button .");
        Assert.assertTrue(adminPage.viewAllButton.isEnabled());
        extentTest.pass("The user correctness activity of the view all button .");
        JSUtilities.clickWithJS(Driver.getDriver(), adminPage.viewAllButton);
        extentTest.info("The user click the viewAll button .");
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().equalsIgnoreCase(ConfigReader.getProperty("viewAllNewPage")));
        extentTest.pass("The user correctness viewAll button linked to page about orders");

        //Click the notification asign.
        //The notification asign dropdown is active and shows the orders

        Driver.quitDriver();
        extentTest.info("The user closes the browser .");
    }

    @Test
    public void test_4323 () throws IOException {
        adminPage=new AdminPage();

        Driver.getDriver().get("about:blank");
        extentTest.info("User open the browser");
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        extentTest.info("The user opens the URL");
        ReusableMethods.accessAdmin("adminuser_iqbal", "adminpassword_iqbal");
        extentTest.info("The user enters user name and password to login");
        adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
        extentTest.info("The user click on the Reports from menu");
        adminPage.merchantRegestration.sendKeys(Keys.ENTER);
        extentTest.info("The user click on the Merchant Registration .");
        ReusableMethods.wait(3);
        extentTest.info("The user wait .");
        Assert.assertTrue(adminPage.profileIcon.isDisplayed());
        extentTest.pass("The user correctness visibility of the profil icon .");
        //The icon of profile is visible.

        Assert.assertTrue(adminPage.profileIcon.isSelected());
        extentTest.pass("The user correctness clicability of the profil icon .");

        Driver.quitDriver();
        extentTest.info("The user closes the browser .");
    }

    @Test
    public void test_4324() {
        adminPage=new AdminPage();
        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        ReusableMethods.accessAdmin("adminuser_iqbal", "adminpassword_iqbal");
        adminPage.itemsAndNames.get(5).sendKeys(Keys.ENTER);
        adminPage.merchantRegestration.sendKeys(Keys.ENTER);
        ReusableMethods.wait(2);
        //The admin name  and profile asign is visible
        Assert.assertTrue(adminPage.testAdmin.isDisplayed());
        JSUtilities.clickWithJS(Driver.getDriver(), adminPage.testAdmin);
        //Click  on admin name and drop down is visible and acrive
        Assert.assertTrue(adminPage.testAdminDropDown.get(0).isDisplayed());
        Assert.assertTrue(adminPage.testAdminDropDown.get(1).isDisplayed());
        //Click on the first item of profile.
        JSUtilities.clickWithJS(Driver.getDriver(), adminPage.testAdminDropDown.get(0));
        //Check the firstname is visible.
        Assert.assertTrue(adminPage.profilFirstName.isDisplayed());
        //Click on Reports first then on Merchant Registration.
        JSUtilities.clickWithJS(Driver.getDriver(), adminPage.testAdmin);
        JSUtilities.clickWithJS(Driver.getDriver(), adminPage.testAdminDropDown.get(1));
        //Click on the secound item of profile.
        Assert.assertTrue(adminPage.adminstrationLogin.isDisplayed());
        //Check the Administrator Login is visible
        Driver.quitDriver();
    }
}
