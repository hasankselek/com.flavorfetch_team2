package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_035 {
    AdminPage adminPage = new AdminPage();

    @Test
    public void TC_3501(){
        adminPage = new AdminPage();
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        String expectedUrl = "https://qa.flavorfetch.com/backoffice/login" ;
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
        Assert.assertTrue(adminPage.userNameButton.isDisplayed());
        Assert.assertTrue(adminPage.passwordButton.isDisplayed());
        Assert.assertTrue(adminPage.signInButton.isDisplayed());
        Driver.quitDriver();
    }
}
