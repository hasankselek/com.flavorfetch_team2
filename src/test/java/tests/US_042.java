package tests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import javax.swing.*;
import java.util.List;

public class US_042 {

    AdminPage adminPage = new AdminPage();

    @Test
    public void TC_4201() {

        adminPage = new AdminPage();
        ReusableMethods.accessAdmin("adminuser_cimen","adminpassword_cimen");

        adminPage.adminDashboardmenu.click();

        adminPage.buyersButton.click();

        adminPage.reviewsButton.click();

        Assert.assertTrue(adminPage.reviewView.isDisplayed());

        Driver.quitDriver();



    }

    @Test
    public void TC_4202() {

        adminPage = new AdminPage();
        ReusableMethods.accessAdmin("adminuser_cimen","adminpassword_cimen");

        adminPage.adminDashboardmenu.click();

        adminPage.buyersButton.click();

        adminPage.reviewsButton.click();

        Assert.assertTrue(adminPage.desktopImages.isEnabled());

        adminPage.desktopImages.click();

        ReusableMethods.windowaGec("https://qa.flavorfetch.com/",Driver.getDriver());

        String expectedUrl= ConfigReader.getProperty("customer_Url");
        String actualUrl=Driver.getDriver().getCurrentUrl();
        System.out.println(actualUrl);
        Assert.assertEquals(actualUrl,expectedUrl);

        Driver.quitDriver();
    }

    @Test
    public void TC_4203() {

        adminPage = new AdminPage();
        ReusableMethods.accessAdmin("adminuser_cimen","adminpassword_cimen");

        adminPage.adminDashboardmenu.click();

        adminPage.buyersButton.click();

        adminPage.reviewsButton.click();

//        Assert.assertTrue(adminPage.headDashboard.get(0).getText().contains("Merchant"));
//
//        Assert.assertTrue(adminPage.headDashboard.get(0).getText().contains("Reviews"));
//
//        Assert.assertTrue(adminPage.headDashboard.get(0).getText().contains("Actions"));

        Assert.assertTrue(adminPage.headMerchant.isDisplayed());

        Assert.assertTrue(adminPage.headReview.isDisplayed());

        Assert.assertTrue(adminPage.headActions.isDisplayed());

        Driver.quitDriver();
    }

    @Test
    public void TC_4204() {

        adminPage = new AdminPage();
        ReusableMethods.accessAdmin("adminuser_cimen","adminpassword_cimen");

        adminPage.adminDashboardmenu.click();

        adminPage.buyersButton.click();

        adminPage.reviewsButton.click();

        Assert.assertTrue(adminPage.SearchSide.isEnabled());

        Driver.quitDriver();

    }

    @Test
    public void TC_4205() {

        adminPage = new AdminPage();
        ReusableMethods.accessAdmin("adminuser_cimen","adminpassword_cimen");

        adminPage.adminDashboardmenu.click();

        adminPage.buyersButton.click();

        adminPage.reviewsButton.click();

        Assert.assertTrue(adminPage.deleteButtonDashboard.isEnabled());

        Assert.assertTrue(adminPage.updateButtonDashboard.isEnabled());

        Driver.quitDriver();
}

    @Test
    public void TC_4206() {

        adminPage = new AdminPage();
        ReusableMethods.accessAdmin("adminuser_cimen","adminpassword_cimen");

        adminPage.adminDashboardmenu.click();

        adminPage.buyersButton.click();

        adminPage.reviewsButton.click();

        Assert.assertTrue(adminPage.dashboardPageNumbers.isDisplayed());

        Driver.quitDriver();

}

    @Test
    public void TC_4207() {

        adminPage = new AdminPage();
        ReusableMethods.accessAdmin("adminuser_cimen","adminpassword_cimen");

        adminPage.adminDashboardmenu.click();

        adminPage.buyersButton.click();

        adminPage.reviewsButton.click();

        adminPage.deleteButtonDashboard.click();

        ReusableMethods.waitFor(4);

        Assert.assertTrue(adminPage.cDeleteButton.isEnabled());

        adminPage.cDeleteButton.click();

        Driver.quitDriver();

    }

    @Test
    public void TC_4208() {

        adminPage = new AdminPage();
        ReusableMethods.accessAdmin("adminuser_cimen","adminpassword_cimen");

        adminPage.adminDashboardmenu.click();

        adminPage.buyersButton.click();

        adminPage.reviewsButton.click();

        adminPage.updateButtonDashboard.click();

        ReusableMethods.waitFor(3);

        //        Click save button
        adminPage.saveCustomerButton.click();

        //        Click All Review

        adminPage.allReviewClick.click();

        Driver.quitDriver();










    }
}
