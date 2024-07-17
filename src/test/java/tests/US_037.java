package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_037 {

    AdminPage adminPage = new AdminPage();

    @Test
    public void TC_3701() {
        ReusableMethods.accessAdmin("adminuser_mehmet", "adminpassword_mehmet");
        Assert.assertTrue(adminPage.merchantSide.isDisplayed());
        Assert.assertTrue(adminPage.merchantSide.isEnabled());
        adminPage.merchantSide.click();
        ReusableMethods.wait(1);

        Assert.assertTrue(adminPage.listSide.isDisplayed());
        Assert.assertTrue(adminPage.listSide.isEnabled());
        adminPage.listSide.click();
        Driver.quitDriver();


    }

    @Test
    public void TC_3702() {

    }

    @Test
    public void TC_3703() {

    }

    @Test
    public void TC_3704() {

    }

    @Test
    public void TC_3705() {

    }
}
