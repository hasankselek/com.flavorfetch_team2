package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MerchantPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class US_023 {
 MerchantPage merchantPage=new MerchantPage();
@Test
public void test_2301(){
   // check the visibility of Total Orders text and it's amount as integer.
  //  check the visibility of Total Orders graphic image.
    Driver.getDriver().get("about:blank");
    Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
    merchantPage.usernametextbox.sendKeys(ConfigReader.getProperty("merchant_username"));
    merchantPage.passwordtextbox.sendKeys(ConfigReader.getProperty("merchant_password"));
    merchantPage.singinButton.click();

    ReusableMethods.wait(10);

String expectedText1=merchantPage.topPicTextList.get(3).getText();     //text
String expectedInt1=merchantPage.topPicIntList.get(3).getText();      // int
String actualAllText1=merchantPage.listOfTopPictures.get(0).getText();// text+int
String expectedText2=merchantPage.topPicTextList.get(4).getText();
String expectedInt2=merchantPage.topPicIntList.get(4).getText();
String actualAllText2=merchantPage.listOfTopPictures.get(1).getText();
String expectedText3=merchantPage.topPicTextList.get(5).getText();
String expectedInt3=merchantPage.topPicIntList.get(5).getText();
String actualAllText3=merchantPage.listOfTopPictures.get(2).getText();
String expectedText4=merchantPage.topPicTextList.get(6).getText();
String expectedInt4=merchantPage.topPicIntList.get(6).getText();
String actualAllText4=merchantPage.listOfTopPictures.get(3).getText();

Assert.assertTrue(actualAllText1.contains(expectedText1));    // text
Assert.assertTrue(actualAllText2.contains(expectedText2));
Assert.assertTrue(actualAllText3.contains(expectedText3));
Assert.assertTrue(actualAllText4.contains(expectedText4));

Assert.assertTrue(actualAllText1.contains(expectedInt1));    //  int
Assert.assertTrue(actualAllText2.contains(expectedInt2));
Assert.assertTrue(actualAllText3.contains(expectedInt3));
Assert.assertTrue(actualAllText4.contains(expectedInt4));

Assert.assertTrue(merchantPage.listOfTopPictures.get(0).isDisplayed());   //  topPictures
Assert.assertTrue(merchantPage.listOfTopPictures.get(1).isDisplayed());
Assert.assertTrue(merchantPage.listOfTopPictures.get(2).isDisplayed());
Assert.assertTrue(merchantPage.listOfTopPictures.get(3).isDisplayed());

Driver.quitDriver();
}
@Test
    public void test_2302(){
    Driver.getDriver().get("about:blank");
    Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
    merchantPage.usernametextbox.sendKeys(ConfigReader.getProperty("merchant_username"));
    merchantPage.passwordtextbox.sendKeys(ConfigReader.getProperty("merchant_password"));
    merchantPage.singinButton.click();
    ReusableMethods.wait(5);


    Assert.assertTrue(merchantPage.weeklyIncomeTextList.get(0).isDisplayed());
    Assert.assertTrue(merchantPage.weeklyIncomeTextList.get(1).isDisplayed());
    Assert.assertTrue(merchantPage.weeklyIncomeTextList.get(2).isDisplayed());

    Assert.assertTrue(merchantPage.weeklyIncomeIntList.get(0).isDisplayed());
    Assert.assertTrue(merchantPage.weeklyIncomeIntList.get(1).isDisplayed());
    Assert.assertTrue(merchantPage.weeklyIncomeIntList.get(2).isDisplayed());

    Assert.assertTrue(merchantPage.weeklyIncomeIconeList.get(0).isDisplayed());
    Assert.assertTrue(merchantPage.weeklyIncomeIconeList.get(1).isDisplayed());
    Assert.assertTrue(merchantPage.weeklyIconeYourBalance.isDisplayed());
    Driver.quitDriver();
}
@Test
    public void test_2303(){
    Driver.getDriver().get("about:blank");
    Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
    merchantPage.usernametextbox.sendKeys(ConfigReader.getProperty("merchant_username"));
    merchantPage.passwordtextbox.sendKeys(ConfigReader.getProperty("merchant_password"));
    merchantPage.singinButton.click();
    ReusableMethods.wait(5);
    Assert.assertTrue(merchantPage.fourHouseTextList.get(0).isDisplayed());
    Assert.assertTrue(merchantPage.fourHouseTextList.get(1).isDisplayed());
    Assert.assertTrue(merchantPage.fourHouseTextList.get(2).isDisplayed());
    Assert.assertTrue(merchantPage.fourHouseTextList.get(3).isDisplayed());

    Assert.assertTrue(merchantPage.fourHouseIntList.get(0).isDisplayed());
    Assert.assertTrue(merchantPage.fourHouseIntList.get(1).isDisplayed());
    Assert.assertTrue(merchantPage.fourHouseIntList.get(2).isDisplayed());
    Assert.assertTrue(merchantPage.fourHouseIntList.get(3).isDisplayed());

    Driver.quitDriver();
}
@Test
    public void test_2304(){
    Driver.getDriver().get("about:blank");
    Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
    merchantPage.usernametextbox.sendKeys(ConfigReader.getProperty("merchant_username"));
    merchantPage.passwordtextbox.sendKeys(ConfigReader.getProperty("merchant_password"));
    merchantPage.singinButton.click();
    ReusableMethods.wait(5);
    Assert.assertTrue(merchantPage.topPicTextList.get(21).isDisplayed());
    Assert.assertTrue(merchantPage.topPicTextList.get(20).isDisplayed());
    Assert.assertTrue(merchantPage.topPicTextList.get(19).isDisplayed());

    Driver.quitDriver();
}
@Test
    public void test_2305(){
    Driver.getDriver().get("about:blank");
    Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
    merchantPage.usernametextbox.sendKeys(ConfigReader.getProperty("merchant_username"));
    merchantPage.passwordtextbox.sendKeys(ConfigReader.getProperty("merchant_password"));
    merchantPage.singinButton.click();
    ReusableMethods.wait(5);
    JavascriptExecutor  jse= (JavascriptExecutor) Driver.getDriver();
    jse.executeScript("arguments[0].scrollIntoView(true);",merchantPage.topPicTextList.get(21));
    //Page down to access "Overview of Review" text.
    Assert.assertTrue(merchantPage.textRightColumnList.get(5).isDisplayed());
    //Check the visibility of "This month you got 0 New Reviews" text
    String expectedNumber=merchantPage.overViewNumber.getText();
    // and verify that the number shown in it is equal to number on upper row.

    //Verify that the number shown in it is equal to number on upper row is equal to sum of all stars numbers rows.

    //Check the visibility of "Overview of Review" text.
    //Click on the "Checkout All Reviews".
    //Verify the presence of the  "Customer reviews" text.
    //The user closes the page.
    Driver.quitDriver();
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
