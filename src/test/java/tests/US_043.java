package tests;

import com.google.common.base.Verify;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class US_043 {
@Test
    public void test_4301(){
    //The user opens the browser.
    Driver.getDriver().get("about:blank");
    //Enters the Url of admin dashboard.
    Driver.getDriver().get(ConfigReader.getProperty("adminDashboard_Url"));
    //Click on "Reports" first then on "Merchant Registration".
    //Verify that the "Merchant Regestration" item is visible.
    //Click on "Merchant Regestration" item.
    //Verify the Url address contains "merchant registration".
    //The user closes the page.
}
@Test
    public void test_4302(){
    //The user opens the browser.
    //Enters the Url of admin dashboard.
    //Click on Reports first then on Merchant Registration.
    //Verify visibility of "Name"in the header of table.
    //Verify visibility of "Address"in the header of table.
    //Verify visibility of "Membership Program"in the header of table.
    //Verify that names data sorted by alphabetic order.
    //The user opens the browser.
}
@Test
    public void test_4303(){
    //The user opens the browser.
    //Enters the Url of admin dashboard.
    //Click on Reports first then on Merchant Registration.
    //Click on "Membership Program" item.
    //Verify that item's data changed order.
    //Click on "Address" item.
    //Verify that item's data sorted by alphabetic order
    //Click on "Name" item.
    //Verify that item's data sorted by alphabetic order.
    //The user opens the browser.
}
@Test
    public void test_4304(){
    //The user opens the browser.
    //Enters the Url of admin dashboard.
    //Click on Reports first then on Merchant Registration.
    //Verify visibility of logo in merchant list.
    //Verify visibility of name in merchant list.
    //Verify visibility of status  in merchant list.
    //Verify visibility of  address in merchant list.
    //Verify visibility of Membership Program in merchant list.
    //The user closes the page.
}
@Test
    public void test_4305(){
    //The user opens the browser.
    //Enters the Url of admin dashboard.
    //Click on Reports first then on Merchant Registration.
    //Verify visibility of input box of calendar .
    //Verify visibility of  start date- end date in background of input box of calendar .
    //Verify visibility of calendar icon.
    //click on calendar icon and Verify visibility of date.
    //The user closes the page.
}
@Test
    public void test_4306(){
    //The user opens the browser.
    //Enters the Url of admin dashboard.
    //Click on Reports first then on Merchant Registration.
    //click on input box of calendar and verify visibility 7 data in dropdown.

    //click on one data from dropdown.
    //Verify merchant list sorted via date.
    //The user closes the page.

}
@Test
    public void test_4307(){
    //The user opens the browser.
    //Enters the Url of admin dashboard.
    //Click on Reports first then on Merchant Registration.
    //click on input box of calendar and enter a renge of date in dropdown.
    //Verify the numbers of calendar active and selectable
    //Verify merchant list sorted in date renge.
    //The user closes the page.
}
@Test
    public void test_4308(){
    //The user opens the browser.
    //Enters the Url of admin dashboard.
    //Click on Reports first then on Merchant Registration.
    //Verify  the  "< "sign of calendar  is visible.
    //Click the "< "sign of calendar .
    //Verify single visibility of "July".
    //The user closes the page.
}
@Test
    public void test_4309(){
    //The user opens the browser.
    //Enters the Url of admin dashboard.
    //Click on Reports first then on Merchant Registration.
    //Verify  the  "< "sign of calendar  is visible.
    //Click the "< "sign of calendar .
    //Verify single visibility of "May".
    //The user closes the page.
}
@Test
    public void test_4310(){
    //The user opens the browser.
    //Enters the Url of admin dashboard.
    //Click on Reports first then on Merchant Registration.
    //Verify  the  "< "sign of calendar  is visible.
    //Click the "< "sign of calendar .
    //Verify single visibility of "Jun".
    //The user closes the page.
}
@Test
    public void test_4311(){
    //The user opens the browser.
    //Enters the Url of admin dashboard.
    //Click on Reports first then on Merchant Registration.
    //Verify visibility of  "All Status" input box.
    //Verify visibility of "All Status" in background of status box.
    //Verify visibility of All Status box dropdown.
    //Click on AllStatus box
    //Click randomly on one element of dropdown.
    //Verify the list of merchant sorted by selected item
    //The user closes the page.
}
@Test
    public void test_4312(){
    //The user opens the browser.
    //Enters the Url of admin dashboard.
    //Click on Reports first then on Merchant Registration.
    //Verify visibility of icon name.
    //The user closes the page.
}
@Test
    public void test_4313(){
    //The user opens the browser.
    //Enters the Url of admin dashboard.
    //Click on Reports first then on Merchant Registration.
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
    //The user closes the page.
}
@Test
    public void test_4314(){
    //The user opens the browser.
    //Enters the Url of admin dashboard.
    //Click on Reports first then on Merchant Registration.
    //Click on All Status box and select two item
    //Verify visibility of sign mark in dropdown next to selected item.
    //Verify visibility of Merchant list sorted alphabetically order.
    //Verify the merchant list status contains one or two of selected items.
    //Verify the merchant list status does not contain other than the two selected items.
    //Verify unvisibility of mark sign when reclick on it.
    //Verify visibility of all types of status in merchant list after deselected status items.
    //The user closes the page.
}
@Test
    public void test_4315(){
    //The user opens the browser.
    //Enters the Url of admin dashboard.
    //Click on Reports first then on Merchant Registration.
    //Verify visibility of "Total Registered" and the opposite number.
    //Verify visibility of "Commission Total" and the opposite number.
    //Verify visibility of "Membership Total" and the opposite number.
    //Verify visibility of "Total Active" and the opposite number.
    //Verify visibility of "Total Inactive" and the opposite number.
    //Check that the sum of "Total Active" and "Total Inactive" is equalls to "Total Registered"
    //The user closes the page.
}
@Test
    public void test_4316(){
    //The user opens the browser.
    //Enters the Url of admin dashboard.
    //Click on Reports first then on Merchant Registration.
    //Check that the sum of "Commission Total" and "Membership Total" is equalls to "Total Active"
    //The user closes the page.
}
@Test
    public void test_4317(){
    //The user opens the browser.
    //Enters the Url of admin dashboard.
    //Click on Reports first then on Merchant Registration.
    //Check that the number written before the entries in "Showing 1 to 10 of 38 entries"at the bottom of page is equals to "Total Registered"
    //The user closes the page.
}
@Test
    public void test_4318(){
    //The user opens the browser.
    //Enters the Url of admin dashboard.
    //Click on Reports first then on Merchant Registration.
    //The notification asign is visible and active.
    //Click the notification asign.
    //The notification asign dropdown is active and shows the orders

    //Numbers of orders is shown on notification.
    //Verify the number of last order is equal tothe number of order in upper row of Last Orders

    //The user closes the page.
}
@Test
    public void test_4319(){
    //The user opens the browser.
    //Enters the Url of admin dashboard.
    //Click on Reports first then on Merchant Registration.
    //The icon of profile is visible.
    //Click on the profile asign.
    //Verify the profile asign is active.
    //The user closes the page.
}
@Test
    public void test_4320(){
    //The user opens the browser.
    //Enters the Url of admin dashboard.
    //Click on Reports first then on Merchant Registration.
    //The admin name  and profile asign is visible .
    //Click  on admin name and drop down is visible and acrive
    //Click on the first item of profile.
    //Check the firstname is visible.
    //Click on Reports first then on Merchant Registration.
    //Click  on admin name and drop down is visible and acrive
    //Click on the secound item of profile.
    //Check the Administrator Login is visible
    //The user closes the page.
}
}
