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
import utilities.*;

import java.io.IOException;
import java.util.*;

public class US_023 extends TestBaseRapor {
    MerchantPage merchantPage = new MerchantPage();

    @Test
    public void test_2301() throws IOException {
        merchantPage = new MerchantPage();
        // check the visibility of Total Orders text and it's amount as integer.
        //  check the visibility of Total Orders graphic image.
        Driver.getDriver().get("about:blank");
        extentTest.info("The user opens the browser.");
        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
        extentTest.info("The user opens the url");
        ReusableMethods.accessToMerchant();
        extentTest.info("The user enters user name and password to login ");
        ReusableMethods.wait(3);

        for (int i = 0; i < 4; i++) {
            String actualAllText = merchantPage.listOfTopPictures.get(i).getText();
            String expectedText = merchantPage.topPicTextList.get(i + 4).getText();
            String expectedInt = merchantPage.topPicIntList.get(i + 4).getText().replaceAll("\\D", "");

        }

        for (int i = 0; i < 4; i++) {
            Assert.assertTrue(merchantPage.listOfTopPictures.get(i).isDisplayed());
        }

        Driver.quitDriver();
    }

    @Test
    public void test_2302() {
        merchantPage = new MerchantPage();

        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
        ReusableMethods.accessToMerchant();
        ReusableMethods.wait(5);

        for (int i = 0; i < 3; i++) {
            Assert.assertTrue(merchantPage.weeklyIncomeTextList.get(i).isDisplayed());  //text weekly
            Assert.assertTrue(merchantPage.weeklyIncomeIntList.get(i).isDisplayed());   //int weekly
            Assert.assertTrue(merchantPage.signalList.get(i).isDisplayed());            //icon pic
        }


        Driver.quitDriver();
    }

    @Test
    public void test_2303() {
        merchantPage = new MerchantPage();

        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
        ReusableMethods.accessToMerchant();
        ReusableMethods.wait(5);
        for (int i = 0; i < 4; i++) {
            Assert.assertTrue(merchantPage.fourHouseTextList.get(i).isDisplayed());  //page center 4-table
            Assert.assertTrue(merchantPage.fourHouseIntList.get(1).isDisplayed());   // int amount
        }


        Driver.quitDriver();
    }

    @Test
    public void test_2304() {
        merchantPage = new MerchantPage();

        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
        ReusableMethods.accessToMerchant();
        ReusableMethods.wait(5);

        for (int i = 19; i < 22; i++) {
            Assert.assertTrue(merchantPage.topPicTextList.get(i).isDisplayed());  //right side of page /vertical table -3
        }

        Driver.quitDriver();
    }

    @Test
    public void test_2305() {
        merchantPage = new MerchantPage();

        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
        ReusableMethods.accessToMerchant();
        ReusableMethods.wait(3);

        JSUtilities.scrollToElement(Driver.getDriver(), merchantPage.topPicTextList.get(21));
        ReusableMethods.wait(5);
        for (int i = 0; i < 6; i++) {
            Assert.assertTrue(merchantPage.sixRightColumnList.get(i).isDisplayed());
        }

        String expectedNumber = merchantPage.overViewNumber.getText();
        String actualInText = merchantPage.sixRightColumnList.get(5).getText();
        Assert.assertTrue(actualInText.contains(expectedNumber));
        merchantPage.buttonList.get(1).sendKeys(Keys.ENTER);
        ReusableMethods.wait(2);
        Assert.assertTrue(merchantPage.topPicTextList.get(4).isDisplayed());

        Driver.quitDriver();
    }

    @Test
    public void test_2306() {
        merchantPage = new MerchantPage();
        Actions actions = new Actions(Driver.getDriver());

        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
        ReusableMethods.accessToMerchant();
        ReusableMethods.wait(2);

        JSUtilities.scrollToElement(Driver.getDriver(), merchantPage.topPicTextList.get(12));
        //page down to access "Last Orders".
        Assert.assertTrue(merchantPage.topPicTextList.get(12).isDisplayed());
        //Check the visibility of "Last Orders" text .

        String expectedRowSize = ConfigReader.getProperty("lastOrdersRowSize");
        String actualRowSize = merchantPage.lastOrdersRowNumber.size() + "";
        Assert.assertEquals(actualRowSize, expectedRowSize);
        //Check the visibility of number of the top order is bigger than number of previous row. .

        for (int i = 0; i < 5; i++) {
            Assert.assertTrue(merchantPage.lastOrdersRowNumber.get(i).isDisplayed());
        }

        List<Integer> actualOrders = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            actualOrders.add(Integer.parseInt(merchantPage.ordersAndNamesList.get(i).getText().replaceAll("\\D", "")));
        }
        List<Integer> sortedOrders = new ArrayList<>();
        Collections.sort(sortedOrders);

        for (int each1 : actualOrders) {
            for (int each2 : sortedOrders) {
                Assert.assertEquals(each1, each2);
            }
        }
        Driver.quitDriver();
    }

    @Test
    public void test_2307() {
        merchantPage = new MerchantPage();

        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
        ReusableMethods.accessToMerchant();
        ReusableMethods.wait(3);

//All
        JSUtilities.scrollToElement(Driver.getDriver(), merchantPage.topItemsList.get(0));
        Assert.assertTrue(merchantPage.topItemsList.get(0).isDisplayed());
        ReusableMethods.wait(3);
        JSUtilities.scrollToElement(Driver.getDriver(), merchantPage.topItemsList.get(0));
        JSUtilities.clickWithJS(Driver.getDriver(), merchantPage.topItemsList.get(0));
        //last orders / click the order number
        Random random = new Random();
        int digit = random.nextInt(5);
        String actualOrderNumber = merchantPage.firstOrderNumber.get(digit).getText();
        merchantPage.firstOrderNumber.get(digit).sendKeys(Keys.ENTER);

        String expectedOrderNumber = merchantPage.listOfLastOrders_30Days.get(0).getText().replaceAll("\\D", "");
        Assert.assertTrue(actualOrderNumber.contains(expectedOrderNumber));

        Driver.getDriver();
    }

    @Test
    public void test_2308() {
        merchantPage = new MerchantPage();

        Driver.getDriver().get("about:blank");
        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
        ReusableMethods.accessToMerchant();
        ReusableMethods.wait(3);

        JSUtilities.scrollToElement(Driver.getDriver(), merchantPage.topItemsList.get(0));
        Assert.assertTrue(merchantPage.topItemsList.get(0).isDisplayed());
        ReusableMethods.wait(3);
        JSUtilities.scrollToElement(Driver.getDriver(), merchantPage.topItemsList.get(0));
        JSUtilities.clickWithJS(Driver.getDriver(), merchantPage.topItemsList.get(0));
        //first column/last orders
        for (int i = 0; i < 5; i++) {
            Assert.assertTrue(merchantPage.firstColumnOfAll.get(i).isDisplayed());
        }
        //secound column/last orders

        Assert.assertTrue(merchantPage.sc_Th_FrColumnForAll.get(0).isDisplayed());

        //third column/last orders

        Assert.assertTrue(merchantPage.sc_Th_FrColumnForAll.get(1).isDisplayed());
        //forth column/last orders

        Assert.assertTrue(merchantPage.sc_Th_FrColumnForAll.get(2).isDisplayed());
        //fifth column/last orders
        for (int i = 0; i < 5; i++) {
            Assert.assertTrue(merchantPage.firstColumnOfAll.get(i).isDisplayed());
        }//sixth column/last orders
        for (int i = 0; i < 5; i++) {
            Assert.assertTrue(merchantPage.sixthColumnOfAll.get(i).isDisplayed());

        }
   Driver.quitDriver();  }
    }
