package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MerchantPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_023 {
 MerchantPage merchantPage=new MerchantPage();
@Test
public void test_2301(){
    Driver.getDriver().get("about:blank");
    Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
    merchantPage.usernametextbox.sendKeys(ConfigReader.getProperty("merchant_username"));
    merchantPage.passwordtextbox.sendKeys(ConfigReader.getProperty("merchant_password"));
    merchantPage.singinButton.click();
    // check the visibility of Total Orders text and it's amount as integer.
    Assert.assertTrue(merchantPage.totalOrderText.isDisplayed());
    System.out.println(merchantPage.totalOrderPrice.getText());

    // check the visibility of Total Orders graphic image.
   // check the visibility of "Total Cancel" text and it's amount as integer.
   // check the visibility of "Total Cancel"  graplic image.
   // check the visibility of "Total Refund" text and it's amount as float.
   // check the visibility of "Total Refund" graphic image.
  //  check the visibility of "Total Sales"text and it's amount as float.
  //  check the visibility of "Total Sales" graphic image.
  //  The user closes the page.

Driver.quitDriver();
}
@Test
    public void test_2302(){
    //The user opens the browser.
    Driver.getDriver().get("about:blanck");
    //enters the Url.
    Driver.getDriver().get(ConfigReader.getProperty("merchantDashboard_Url"));
    //check the visibility of "Sales this week" text and it's amount as float.
    //check the visibility of "Sales this week" graphic image.
    //check the visibility of "Earning this week" text and it's amount as float.
    //check the visibility of "Earning this week" graplic image.
    //check the visibility of "Your balance" text and it's amount as float.
    //check the visibility of  "Your balance" graphic image.
    //The user closes the page.
}
@Test
    public void test_2303(){
    //The user opens the browser.
    //enters the Url.
    //check the visibility of "Orders received" text and it's amount as integer.
    //check the visibility of Orders received graphic image.
    //check the visibility of Totaly delivered text and it's amount as integer.
    //check the visibility of Totaly delivered graplic image.
    //check the visibility of Today sales text and it's amount as float.
    //check the visibility of Today sales graplic image.
    //check the visibility of Today refund text and it's amount as float.
    //check the visibility of Today refund graplic image.
    //The user closes the page.
}
@Test
    public void test_2304(){
    //The user opens the browser.
    //enters the Url.
    //check the visibility of "Sales Overview" text.
    //check the visibility of "Top customers" text.
    //check the visibility of "Overview of Review" text.
    //The user closes the page.
}
@Test
    public void test_2305(){
    //The user opens the browser.
    //Enters the Url.
    //Page down to access "Overview of Review" text.
    //Check the visibility of "This month you got 0 New Reviews" text
    // and verify that the number shown in it is equal to number on upper row.

    //Verify that the number shown in it is equal to number on upper row is equal to sum of all stars numbers rows.

    //Check the visibility of "Overview of Review" text.
    //Click on the "Checkout All Reviews".
    //Verify the presence of the  "Customer reviews" text.
    //The user closes the page.
}
@Test
    public  void test_2306(){
    //The user opens the browser.
    //Enters the Url.
    //page down to access "Last Orders".
    //Check the visibility of "Last Orders" text .
    //Check the visibility of 5 items of foods shown .
    //Check the visibility of number of the top order is bigger than number of previous row. .

    //The user closes the page.
}
@Test
    public void test_2307(){
    //Enters the Url.
    //page down to access "Last Orders".
    //Check the visibility of "All" text and click on it.
    //Verify the "order#number" are in regular order.
    //Check the visibility of "Processing" text and click on it.
    //Verify visibility of "accepted" item in fifth column of table.
    //Verify visibility of "Cash on delivery" item in forth column next to"unpaid" in third column

    //Verify visibility of "Strip" item in fifth column next to "paid"in third column

    //Click on "Ready" button.
    //Verify visibility of "ready to pick up"or "delivery on its way" item in fifth column of table.
    //Click on "Compeleted" button.
    //Verify visibility of "delivered" or "complete"item in fifth column of table.
    //Verify visibility of "paied" item in third column of table.
    //Verify of the "eye sign" in sixth column of table.
    //Click on "eye sign".
    //Verify visibility of the "Summery" word .
    //Verify of the "download sign" in seventh column of table.
    //Click on"download sign" .
    //Verify loadability of purchace invoice in download folder in private com.

    //The user closes the page.
}
@Test
    public void test_2308(){
    //The user opens the browser.
    //Enters the Url.
    //page down to access "Popular items".
    //Check the visibility of "Popular items" text and click on it.
    //Check the visibility of "latest popular items" text .
    //Verify the number of latest item is bigger than the number of row before the last.

    //Check the visibility of "Last 30 days sales" text and click on it.
    //Verify visibility of "sales for last 30 days".
    //Verify contain of "6" in numbers of horizontal axis..
    //The user closes the page.
}
}
