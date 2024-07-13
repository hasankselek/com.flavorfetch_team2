package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MerchantPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Arrays;
import java.util.List;

public class US_033 {
    MerchantPage merchantPage = new MerchantPage();


    @Test
    public void TC_3301() {
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

        Assert.assertTrue(merchantPage.deleteCuponButton.isDisplayed());
        Assert.assertTrue(merchantPage.deleteCuponButton.isEnabled());
        merchantPage.deleteCuponButton.click();
        ReusableMethods.wait(1);

        WebElement deletePopupPageButton = Driver.getDriver().findElement(By.xpath("//a[@class='btn btn-green item_delete']"));
        deletePopupPageButton.click();
        ReusableMethods.wait(1);


        String afterDeleteCoupon = couponStringList.get(0);

        Assert.assertEquals(beforeDeleteCoupon, afterDeleteCoupon);


        Driver.quitDriver();
    }

    @Test
    public void TC_3302() {
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


        fillTheCouponInformations();


        Driver.quitDriver();


    }

    @Test
    public void TC_3303() {
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
        fillTheCouponInformations();


    }
    @Test
    public void TC_3304(){

    }

    public void fillTheCouponInformations() {
        //Coupon Name Test
        Assert.assertTrue(merchantPage.updateCouponName.isEnabled());
        merchantPage.updateCouponName.clear();
        merchantPage.updateCouponName.sendKeys("Discount $10");

        //Coupon Type Test
        WebElement couponTypeDropdownElement = merchantPage.updateCouponTypeDropdown;
        Assert.assertTrue(couponTypeDropdownElement.isEnabled());
        Select couponType = new Select(couponTypeDropdownElement);
        couponType.selectByIndex(0);


        //Amount Test
        Assert.assertTrue(merchantPage.updateCouponAmount.isDisplayed());
        Assert.assertTrue(merchantPage.updateCouponAmount.isEnabled());
        merchantPage.updateCouponAmount.clear();
        String discountAmount = "10";
        merchantPage.updateCouponAmount.sendKeys(discountAmount);

        //Min Order
        Assert.assertTrue(merchantPage.updateMinOrder.isEnabled());
        Assert.assertTrue(merchantPage.updateMinOrder.isDisplayed());
        merchantPage.updateMinOrder.clear();
        String minOrder = "120";
        merchantPage.updateMinOrder.sendKeys(minOrder);
        ReusableMethods.wait(1);

        //Days Available

        merchantPage.updateDaysAvailable.sendKeys("Monday", Keys.ENTER);


        //Expiration


        //Coupon Options
        WebElement couponOptionsElement = merchantPage.updateCouponOptions;
        Assert.assertTrue(couponOptionsElement.isEnabled());
        Select couponOptions = new Select(couponOptionsElement);
        couponOptions.selectByIndex(3);


        //Coupon Options
        WebElement statusElement = merchantPage.updateStatus;
        Assert.assertTrue(statusElement.isEnabled());
        Select status = new Select(statusElement);
        status.selectByVisibleText("Draft");

        Assert.assertTrue(merchantPage.updateSaveButton.isDisplayed());
        Assert.assertTrue(merchantPage.updateSaveButton.isEnabled());
        merchantPage.updateSaveButton.click();
    }
}
