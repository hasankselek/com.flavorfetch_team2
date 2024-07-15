package tests;

import com.github.javafaker.Faker;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MerchantPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtilities;
import utilities.ReusableMethods;

import java.util.*;

public class US_023 {
    MerchantPage merchantPage = new MerchantPage();

    @Test
    public void test_2301() {
        // check the visibility of Total Orders text and it's amount as integer.
        //  check the visibility of Total Orders graphic image.
        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
        merchantPage.usernametextbox.sendKeys(ConfigReader.getProperty("merchant_username"));
        merchantPage.passwordtextbox.sendKeys(ConfigReader.getProperty("merchant_password"));
        merchantPage.singinButton.click();

        ReusableMethods.wait(10);

        String expectedText1 = merchantPage.topPicTextList.get(3).getText();     //text
        String expectedInt1 = merchantPage.topPicIntList.get(3).getText();      // int
        String actualAllText1 = merchantPage.listOfTopPictures.get(0).getText();// text+int
        String expectedText2 = merchantPage.topPicTextList.get(4).getText();
        String expectedInt2 = merchantPage.topPicIntList.get(4).getText();
        String actualAllText2 = merchantPage.listOfTopPictures.get(1).getText();
        String expectedText3 = merchantPage.topPicTextList.get(5).getText();
        String expectedInt3 = merchantPage.topPicIntList.get(5).getText();
        String actualAllText3 = merchantPage.listOfTopPictures.get(2).getText();
        String expectedText4 = merchantPage.topPicTextList.get(6).getText();
        String expectedInt4 = merchantPage.topPicIntList.get(6).getText();
        String actualAllText4 = merchantPage.listOfTopPictures.get(3).getText();

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
    public void test_2302() {
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
    public void test_2303() {
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
    public void test_2304() {
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
    public void test_2305() {
        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
        merchantPage.usernametextbox.sendKeys(ConfigReader.getProperty("merchant_username"));
        merchantPage.passwordtextbox.sendKeys(ConfigReader.getProperty("merchant_password"));
        merchantPage.singinButton.click();
        ReusableMethods.wait(3);
        JSUtilities.scrollToElement(Driver.getDriver(), merchantPage.topPicTextList.get(21));
        ReusableMethods.wait(5);
        Assert.assertTrue(merchantPage.sixRightColumnList.get(5).isDisplayed());
        String expectedNumber = merchantPage.overViewNumber.getText();
        String actualInText = merchantPage.sixRightColumnList.get(5).getText();
        Assert.assertTrue(actualInText.contains(expectedNumber));
        merchantPage.buttonList.get(1).click();
        ReusableMethods.wait(5);
        Assert.assertTrue(merchantPage.topPicTextList.get(3).isDisplayed());

        Driver.quitDriver();
    }

    @Test
    public void test_2306() {
        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
        merchantPage.usernametextbox.sendKeys(ConfigReader.getProperty("merchant_username"));
        merchantPage.passwordtextbox.sendKeys(ConfigReader.getProperty("merchant_password"));
        merchantPage.singinButton.click();
        ReusableMethods.wait(3);
        JSUtilities.scrollToElement(Driver.getDriver(), merchantPage.topPicTextList.get(11));
        //page down to access "Last Orders".
        Assert.assertTrue(merchantPage.topPicTextList.get(11).isDisplayed());
        //Check the visibility of "Last Orders" text .
        List<WebElement> rowsNum = new ArrayList<>();
        rowsNum.add(merchantPage.rowNumberOfTable.get(0));
        rowsNum.add(merchantPage.rowNumberOfTable.get(1));
        rowsNum.add(merchantPage.rowNumberOfTable.get(2));
        rowsNum.add(merchantPage.rowNumberOfTable.get(3));
        rowsNum.add(merchantPage.rowNumberOfTable.get(4));
        String expectedRowSize = ConfigReader.getProperty("lastOrdersRowSize");
        String actualRowSize = rowsNum.size() + "";
        System.out.println(ConfigReader.getProperty("lastOrdersRowSize"));
        System.out.println(rowsNum.size() + "");
        ReusableMethods.wait(2);
        Assert.assertEquals(actualRowSize, expectedRowSize);
        //Check the visibility of number of the top order is bigger than number of previous row. .
        Assert.assertTrue(merchantPage.ordersAndNamesList.get(0).isDisplayed());
        Assert.assertTrue(merchantPage.ordersAndNamesList.get(1).isDisplayed());
        Assert.assertTrue(merchantPage.ordersAndNamesList.get(2).isDisplayed());
        Assert.assertTrue(merchantPage.ordersAndNamesList.get(3).isDisplayed());
        Assert.assertTrue(merchantPage.ordersAndNamesList.get(4).isDisplayed());

        Integer actual1RowText = Integer.parseInt(merchantPage.ordersAndNamesList.get(0).getText().replaceAll("\\D", ""));
        Integer actual2RowText = Integer.parseInt(merchantPage.ordersAndNamesList.get(1).getText().replaceAll("\\D", ""));
        Integer actual3RowText = Integer.parseInt(merchantPage.ordersAndNamesList.get(2).getText().replaceAll("\\D", ""));
        Integer actual4RowText = Integer.parseInt(merchantPage.ordersAndNamesList.get(3).getText().replaceAll("\\D", ""));
        Integer actual5RowText = Integer.parseInt(merchantPage.ordersAndNamesList.get(4).getText().replaceAll("\\D", ""));

/*
    List<Integer> arrangeOrders=new ArrayList<>();
    arrangeOrders.add(Integer.parseInt(merchantPage.ordersAndNamesList.get(0).getText().replaceAll("\\D","")));
    arrangeOrders.add(Integer.parseInt(merchantPage.ordersAndNamesList.get(1).getText().replaceAll("\\D","")));
    arrangeOrders.add(Integer.parseInt(merchantPage.ordersAndNamesList.get(2).getText().replaceAll("\\D","")));
    arrangeOrders.add(Integer.parseInt(merchantPage.ordersAndNamesList.get(3).getText().replaceAll("\\D","")));
    arrangeOrders.add(Integer.parseInt(merchantPage.ordersAndNamesList.get(4).getText().replaceAll("\\D","")));
*/
//arrangeOrders.sort();

        //Check the visibility of 5 signal of active progress are shown .
        Assert.assertTrue(merchantPage.signalList.get(7).isDisplayed());
        Assert.assertTrue(merchantPage.signalList.get(6).isDisplayed());
        Assert.assertTrue(merchantPage.signalList.get(5).isDisplayed());
        Assert.assertTrue(merchantPage.signalList.get(4).isDisplayed());
        Assert.assertTrue(merchantPage.signalList.get(3).isDisplayed());
        Driver.quitDriver();
    }

    @Test
    public void test_2307() {
        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
        merchantPage.usernametextbox.sendKeys(ConfigReader.getProperty("merchant_username"));
        merchantPage.passwordtextbox.sendKeys(ConfigReader.getProperty("merchant_password"));
        merchantPage.singinButton.click();
        ReusableMethods.wait(3);

        JSUtilities.scrollToElement(Driver.getDriver(), merchantPage.topItemsList.get(0));
        Assert.assertTrue(merchantPage.topItemsList.get(0).isDisplayed());
        ReusableMethods.wait(3);
        JSUtilities.scrollToElement(Driver.getDriver(), merchantPage.topItemsList.get(0));
        JSUtilities.clickWithJS(Driver.getDriver(), merchantPage.topItemsList.get(0));
        //last orders / click the order number
        Assert.assertTrue(merchantPage.orderNumberList.get(0).isDisplayed());
        merchantPage.ordersAndNamesList.get(0).click();
        ReusableMethods.wait(3);
        String expectedOrdersNumbers=merchantPage.orderNumberList.get(0).getText();
        String actualOrderNumber=merchantPage.listOfLastOrders_30Days.get(0).getText();

        Assert.assertTrue(actualOrderNumber.contains(expectedOrdersNumbers));

        Driver.getDriver();
    }
    @Test
    public void test_2308() {
        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
        merchantPage.usernametextbox.sendKeys(ConfigReader.getProperty("merchant_username"));
        merchantPage.passwordtextbox.sendKeys(ConfigReader.getProperty("merchant_password"));
        merchantPage.singinButton.click();
        ReusableMethods.wait(3);

        JSUtilities.scrollToElement(Driver.getDriver(), merchantPage.topItemsList.get(0));
        Assert.assertTrue(merchantPage.topItemsList.get(0).isDisplayed());
        ReusableMethods.wait(3);
        JSUtilities.scrollToElement(Driver.getDriver(), merchantPage.topItemsList.get(0));
        JSUtilities.clickWithJS(Driver.getDriver(), merchantPage.topItemsList.get(0));
        //first column
        Assert.assertTrue(merchantPage.firstColumnOfAll.get(2).isDisplayed());
        //secound column
        Assert.assertTrue(merchantPage.sc_Th_FrColumnForAll.get(4).isDisplayed());//4-8
        //third column
        Assert.assertTrue(merchantPage.sc_Th_FrColumnForAll.get(5).isDisplayed());
        //forth column
        Assert.assertTrue(merchantPage.sc_Th_FrColumnForAll.get(6).isDisplayed());
        Assert.assertTrue(merchantPage.fifthColumnOfAll.get(3).isDisplayed());
        Assert.assertTrue(merchantPage.sixthColumnOfAll.get(3).isDisplayed());
        Driver.getDriver();
    }

    @Test
    public void test_2309() {
        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
        merchantPage.usernametextbox.sendKeys(ConfigReader.getProperty("merchant_username"));
        merchantPage.passwordtextbox.sendKeys(ConfigReader.getProperty("merchant_password"));
        merchantPage.singinButton.click();
        ReusableMethods.wait(3);

        Assert.assertTrue(merchantPage.topItemsList.get(1).isDisplayed());
        ReusableMethods.wait(3);
        JSUtilities.scrollToElement(Driver.getDriver(), merchantPage.topItemsList.get(1));
        JSUtilities.clickWithJS(Driver.getDriver(), merchantPage.topItemsList.get(1));
        //Check the visibility of "Processing" text and click on it.
        ReusableMethods.wait(2);
        Assert.assertTrue(merchantPage.firstColumnOfAll.get(2).isDisplayed());
        Assert.assertTrue(merchantPage.sc_Th_FrColumnForAll.get(4).isDisplayed());//4-8
        Assert.assertTrue(merchantPage.sc_Th_FrColumnForAll.get(5).isDisplayed());
        Assert.assertTrue(merchantPage.sc_Th_FrColumnForAll.get(6).isDisplayed());
        Assert.assertTrue(merchantPage.secoundIntReady.get(2).isDisplayed());
        Assert.assertTrue(merchantPage.secoundStringReady.get(2).isDisplayed());
        Assert.assertTrue(merchantPage.fifthColumnOfAll.get(3).isDisplayed());
        Assert.assertTrue(merchantPage.sixthColumnOfAll.get(3).isDisplayed());
        Driver.getDriver();
    }

    @Test
    public void test_2310() {
        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
        merchantPage.usernametextbox.sendKeys(ConfigReader.getProperty("merchant_username"));
        merchantPage.passwordtextbox.sendKeys(ConfigReader.getProperty("merchant_password"));
        merchantPage.singinButton.click();
        ReusableMethods.wait(3);
        //Click on "Ready" button.
        Assert.assertTrue(merchantPage.topItemsList.get(2).isDisplayed());
        ReusableMethods.wait(3);
        JSUtilities.scrollToElement(Driver.getDriver(), merchantPage.topItemsList.get(2));
        JSUtilities.clickWithJS(Driver.getDriver(), merchantPage.topItemsList.get(2));
        //Verify visibility of "ready to pick up"or "delivery on its way" item in fifth column of table.
        Assert.assertTrue(merchantPage.firstColumnOfAll.get(2).isDisplayed());
        Assert.assertTrue(merchantPage.sc_Th_FrColumnForAll.get(4).isDisplayed());//4-8
        Assert.assertTrue(merchantPage.sc_Th_FrColumnForAll.get(5).isDisplayed());
        Assert.assertTrue(merchantPage.sc_Th_FrColumnForAll.get(6).isDisplayed());
        Assert.assertTrue(merchantPage.secoundIntReady.get(2).isDisplayed());
        Assert.assertTrue(merchantPage.secoundStringReady.get(2).isDisplayed());
        Assert.assertTrue(merchantPage.fifthColumnOfAll.get(3).isDisplayed());
        Assert.assertTrue(merchantPage.sixthColumnOfAll.get(3).isDisplayed());
        Driver.quitDriver();
    }
    @Test
    public void test_2311() {
        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
        merchantPage.usernametextbox.sendKeys(ConfigReader.getProperty("merchant_username"));
        merchantPage.passwordtextbox.sendKeys(ConfigReader.getProperty("merchant_password"));
        merchantPage.singinButton.click();
        ReusableMethods.wait(3);
        //Click on "Ready" button.
        Assert.assertTrue(merchantPage.topItemsList.get(3).isDisplayed());
        ReusableMethods.wait(3);
        JSUtilities.scrollToElement(Driver.getDriver(), merchantPage.topItemsList.get(3));
        JSUtilities.clickWithJS(Driver.getDriver(), merchantPage.topItemsList.get(3));
        //Verify visibility of "ready to pick up"or "delivery on its way" item in fifth column of table.
        Assert.assertTrue(merchantPage.firstColumnOfAll.get(2).isDisplayed());
        Assert.assertTrue(merchantPage.sc_Th_FrColumnForAll.get(4).isDisplayed());//4-8
        Assert.assertTrue(merchantPage.sc_Th_FrColumnForAll.get(5).isDisplayed());
        Assert.assertTrue(merchantPage.sc_Th_FrColumnForAll.get(6).isDisplayed());
        Assert.assertTrue(merchantPage.secoundIntReady.get(2).isDisplayed());
        Assert.assertTrue(merchantPage.secoundStringReady.get(2).isDisplayed());
        Assert.assertTrue(merchantPage.fifthColumnOfAll.get(3).isDisplayed());
        Assert.assertTrue(merchantPage.sixthColumnOfAll.get(3).isDisplayed());


        Driver.quitDriver();
    }

    @Test
    public void test_2312() {
        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
        merchantPage.usernametextbox.sendKeys(ConfigReader.getProperty("merchant_username"));
        merchantPage.passwordtextbox.sendKeys(ConfigReader.getProperty("merchant_password"));
        merchantPage.singinButton.click();
        ReusableMethods.wait(3);
        JSUtilities.scrollToBottom(Driver.getDriver());
        Assert.assertTrue(merchantPage.topItemsList.get(4).isDisplayed());
        ReusableMethods.wait(3);
        JSUtilities.scrollToElement(Driver.getDriver(), merchantPage.topItemsList.get(4));
        JSUtilities.clickWithJS(Driver.getDriver(), merchantPage.topItemsList.get(4));

        Assert.assertTrue(merchantPage.topPicIntList.get(4).isDisplayed());
        //Check the visibility of "Popular items" text and click on it.
        //Check the visibility of "latest popular items" text .
        Assert.assertTrue(merchantPage.topPicIntList.get(12).isDisplayed());
        Assert.assertTrue(merchantPage.topPicIntList.get(13).isDisplayed());//13-22
        Assert.assertTrue(merchantPage.topPicIntList.get(14).isDisplayed());
     Driver.quitDriver();
    }
    @Test
    public void test_2313() {
        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
        merchantPage.usernametextbox.sendKeys(ConfigReader.getProperty("merchant_username"));
        merchantPage.passwordtextbox.sendKeys(ConfigReader.getProperty("merchant_password"));
        merchantPage.singinButton.click();
        ReusableMethods.wait(3);
        JSUtilities.scrollToBottom(Driver.getDriver());
        Assert.assertTrue(merchantPage.topItemsList.get(5).isDisplayed());
        ReusableMethods.wait(3);
        JSUtilities.scrollToElement(Driver.getDriver(), merchantPage.topItemsList.get(5));
        JSUtilities.clickWithJS(Driver.getDriver(), merchantPage.topItemsList.get(5));

        Assert.assertTrue(merchantPage.topPicIntList.get(4).isDisplayed());
        //Check the visibility of "Popular items" text and click on it.
        //Check the visibility of "latest popular items" text .
        Assert.assertTrue(merchantPage.topPicIntList.get(12).isDisplayed());
        Assert.assertTrue(merchantPage.topPicIntList.get(13).isDisplayed());//13-22
        Assert.assertTrue(merchantPage.topPicIntList.get(14).isDisplayed());
        Driver.quitDriver();
    }
    @Test
    public void test_2314() {
        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
        merchantPage.usernametextbox.sendKeys(ConfigReader.getProperty("merchant_username"));
        merchantPage.passwordtextbox.sendKeys(ConfigReader.getProperty("merchant_password"));
        merchantPage.singinButton.click();
        ReusableMethods.wait(3);
        JSUtilities.scrollToBottom(Driver.getDriver());
        Assert.assertTrue(merchantPage.topItemsList.get(6).isDisplayed());
        ReusableMethods.wait(3);
        JSUtilities.scrollToElement(Driver.getDriver(), merchantPage.topItemsList.get(6));
        JSUtilities.clickWithJS(Driver.getDriver(), merchantPage.topItemsList.get(6));
        Assert.assertTrue(merchantPage.listOfLastOrders_30Days.get(1).isDisplayed());
        Assert.assertTrue(merchantPage.dataOf30Days.get(0).isDisplayed());
        Assert.assertTrue(merchantPage.foodsNameOf30Days.get(33).isDisplayed());

        Driver.getDriver();
    }
    @Test
    public void test_2315() {
        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
        merchantPage.usernametextbox.sendKeys(ConfigReader.getProperty("merchant_username"));
        merchantPage.passwordtextbox.sendKeys(ConfigReader.getProperty("merchant_password"));
        merchantPage.singinButton.click();
        ReusableMethods.wait(3);
        JSUtilities.scrollToElement(Driver.getDriver(),merchantPage.topPicTextList.get(20));
        Assert.assertTrue(merchantPage.topPicTextList.get(20).isDisplayed());
        Assert.assertTrue(merchantPage.topPicIntList.get(14).isDisplayed());
        Assert.assertTrue(merchantPage.picturesOfTopCostumers.get(3).isDisplayed());
        //    Assert.assertTrue(merchantPage.descriptionOfTopCustumers.get(3).isDisplayed());
        Assert.assertTrue(merchantPage.checkout_AllCostumers.get(0).isDisplayed());
        JSUtilities.scrollToElement(Driver.getDriver(), merchantPage.checkout_AllCostumers.get(0));
        JSUtilities.clickWithJS(Driver.getDriver(),merchantPage.checkout_AllCostumers.get(0));
        Assert.assertTrue(merchantPage.custumerList.get(1).isDisplayed());

        Driver.getDriver();
    }
}
