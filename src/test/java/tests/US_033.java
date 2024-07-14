package tests;

import com.beust.ah.A;
import com.fasterxml.jackson.core.TreeNode;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MerchantPage;
import utilities.Driver;
import utilities.JSUtilities;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class US_033 {


    MerchantPage merchantPage=new MerchantPage();
    @Test
    public void TC_3301() {
        MerchantPage merchantPage = new MerchantPage();
        ReusableMethods.accessToMerchant();
        Assert.assertTrue(merchantPage.promoLink.isDisplayed());
        merchantPage.promoLink.click();
        ReusableMethods.wait(1);
        Assert.assertTrue(merchantPage.couponLink.isDisplayed());
        merchantPage.couponLink.click();
        ReusableMethods.wait(1);
        String expectedTitle = "Coupon list";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

        //Change Web Element List to String List
        List<String> couponStringList = ReusableMethods.stringListesineDonustur(merchantPage.couponNameList);

        Assert.assertTrue(merchantPage.updateCouponButton.isDisplayed());
        Assert.assertTrue(merchantPage.updateCouponButton.isEnabled());
        merchantPage.updateCouponButton.click();
        ReusableMethods.wait(1);

        merchantPage.couponLink.click();

        String beforeDeleteCoupon = couponStringList.get(0);

        Assert.assertTrue(merchantPage.deleteCouponButton.isDisplayed());
        Assert.assertTrue(merchantPage.deleteCouponButton.isEnabled());
        merchantPage.deleteCouponButton.click();
        ReusableMethods.wait(1);

        WebElement deletePopupPageButton = Driver.getDriver().findElement(By.xpath("//a[@class='btn btn-green item_delete']"));
        deletePopupPageButton.click();
        ReusableMethods.wait(1);


        String afterDeleteCoupon = couponStringList.get(0);

        Assert.assertNotEquals(beforeDeleteCoupon, afterDeleteCoupon);


        Driver.quitDriver();
    }

    @Test
    public void TC_3302() { //Update Coupon Information Test
        MerchantPage merchantPage=new MerchantPage();

        ReusableMethods.accessToMerchant();
        Assert.assertTrue(merchantPage.promoLink.isDisplayed());
        merchantPage.promoLink.click();
        ReusableMethods.wait(1);
        Assert.assertTrue(merchantPage.couponLink.isDisplayed());
        merchantPage.couponLink.click();
        ReusableMethods.wait(1);
        String expectedTitle = "Coupon list";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

        Assert.assertTrue(merchantPage.updateCouponButton.isDisplayed());
        Assert.assertTrue(merchantPage.updateCouponButton.isEnabled());
        merchantPage.updateCouponButton.click();
        ReusableMethods.wait(1);


        Faker faker = new Faker();
        String couponName = faker.commerce().promotionCode();
        ReusableMethods.fillTheCouponInformations(couponName);



        Driver.quitDriver();


    }

    @Test
    public void TC_3303() { //Add new Coupon Test
        MerchantPage merchantPage=new MerchantPage();
        ReusableMethods.wait(1);
        ReusableMethods.accessToMerchant();
        Assert.assertTrue(merchantPage.promoLink.isDisplayed());
        merchantPage.promoLink.click();
        ReusableMethods.wait(1);
        Assert.assertTrue(merchantPage.couponLink.isDisplayed());
        merchantPage.couponLink.click();
        ReusableMethods.wait(1);
        String expectedTitle = "Coupon list";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

        merchantPage.couponAddLink.click();

        Faker faker = new Faker();
        String couponName = faker.commerce().promotionCode();
        ReusableMethods.fillTheCouponInformations(couponName);


        Driver.quitDriver();


    }

    @Test
    public void TC_3304() { //Check Added Coupon Test

        ReusableMethods.accessToMerchant();
        Assert.assertTrue(merchantPage.promoLink.isDisplayed());
        merchantPage.promoLink.click();
        ReusableMethods.wait(1);
        Assert.assertTrue(merchantPage.couponLink.isDisplayed());
        merchantPage.couponLink.click();
        ReusableMethods.wait(1);
        String expectedTitle = "Coupon list";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

        merchantPage.couponAddLink.click();

        Faker faker = new Faker();
        String couponName = faker.commerce().promotionCode();
        ReusableMethods.fillTheCouponInformations(couponName);


        List<String> couponStringList = ReusableMethods.stringListesineDonustur(merchantPage.couponNameList);
        Assert.assertEquals(couponStringList.get(0).split(" ")[0].trim(), couponName);

        Driver.quitDriver();


    }

    @Test
    public void TC_3305() { //Sort Test With Number,Name And Used Tags

        ReusableMethods.accessToMerchant();
        Assert.assertTrue(merchantPage.promoLink.isDisplayed());
        merchantPage.promoLink.click();
        ReusableMethods.wait(1);
        Assert.assertTrue(merchantPage.couponLink.isDisplayed());
        merchantPage.couponLink.click();
        ReusableMethods.wait(1);

        //Coupon Number Sort
        merchantPage.couponNumberSortLink.click();
        ReusableMethods.wait(1);
        List<String> couponNumberStringList = ReusableMethods.stringListesineDonustur(merchantPage.couponNumberList);
        List<Integer> couponNumberIntegerList = new ArrayList<>();

        ReusableMethods.stringListToIntegerList(couponNumberStringList, couponNumberIntegerList);

        for (int i = 0; i < couponNumberIntegerList.size() - 1; i++) {
            Assert.assertTrue(couponNumberIntegerList.get(i) < couponNumberIntegerList.get(i + 1));
        }
        ReusableMethods.wait(1);

        //Coupon Name Sort
        merchantPage.couponNameSortLink.click();
        ReusableMethods.wait(1);
        List<String> couponNameStringList = ReusableMethods.stringListesineDonustur(merchantPage.couponNameList);
        for (int i = 0; i < couponNameStringList.size(); i++) {
            couponNameStringList.set(i, couponNameStringList.get(i).toUpperCase());
        }


        List<String> sortedCouponNameList = new ArrayList<>(couponNameStringList);
        Collections.sort(sortedCouponNameList);
        ReusableMethods.wait(1);
        for (int i = 0; i < sortedCouponNameList.size(); i++) {
            sortedCouponNameList.set(i, sortedCouponNameList.get(i).toUpperCase());
        }

        Assert.assertEquals(couponNameStringList, sortedCouponNameList);
        ReusableMethods.wait(1);

        //Coupon Used Sort
        merchantPage.couponUsedSortLink.click();
        ReusableMethods.wait(1);
        List<String> couponUsedStringList = ReusableMethods.stringListesineDonustur(merchantPage.couponUsedList);
        List<Integer> couponUsedIntegerList = new ArrayList<>();

        ReusableMethods.stringListToIntegerList(couponUsedStringList, couponUsedIntegerList);

        for (int i = 0; i < couponUsedIntegerList.size() - 1; i++) {
            Assert.assertTrue(couponUsedIntegerList.get(i) <= couponUsedIntegerList.get(i + 1));
        }
        ReusableMethods.wait(1);

        Driver.quitDriver();
    }


    @Test
    public void TC_3306() {
        MerchantPage merchantPage=new MerchantPage();
        ReusableMethods.accessToMerchant();
        Assert.assertTrue(merchantPage.promoLink.isDisplayed());
        merchantPage.promoLink.click();
        ReusableMethods.wait(1);
        Assert.assertTrue(merchantPage.couponLink.isDisplayed());
        merchantPage.couponLink.click();
        ReusableMethods.wait(1);
        String expectedTitle = "Coupon list";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

        List<String> couponStringList = ReusableMethods.stringListesineDonustur(merchantPage.couponNameList);

        if (couponStringList.size() >= 10) {
            Driver.getDriver().findElement(By.xpath("(//*[text()='Next'])[2]")).click();
            ReusableMethods.wait(1);
            List<String> nextPagecCouponStringList = ReusableMethods.stringListesineDonustur(merchantPage.couponNameList);
            String nextPageFirstCouponName = Driver.getDriver().findElement(By.xpath("(//tbody/tr/td[2]/h6)[1]")).getText();
            Assert.assertEquals(nextPagecCouponStringList.get(0), nextPageFirstCouponName);


        } else {
            Assert.assertTrue(false);
        }


        Driver.quitDriver();
    }

    @Test
    public void TC_3307() {
        MerchantPage merchantPage=new MerchantPage();
        ReusableMethods.accessToMerchant();
        Assert.assertTrue(merchantPage.promoLink.isDisplayed());
        merchantPage.promoLink.click();
        ReusableMethods.wait(1);
        Assert.assertTrue(merchantPage.couponLink.isDisplayed());
        merchantPage.couponLink.click();
        ReusableMethods.wait(1);
        String expectedTitle = "Coupon list";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);


        Assert.assertTrue(merchantPage.couponSearchBox.isEnabled());
        Assert.assertTrue(merchantPage.couponSearchBox.isDisplayed());
        merchantPage.couponSearchBox.sendKeys("Kil", Keys.ENTER);
        ReusableMethods.wait(1);
        List<String> couponStringList = ReusableMethods.stringListesineDonustur(merchantPage.couponNameList);


        for (int i = 0; i < couponStringList.size(); i++) {
            Assert.assertTrue(couponStringList.get(i).contains("Kil"));
        }

        Driver.quitDriver();


    }

}
