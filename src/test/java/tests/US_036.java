package tests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_036 {

    AdminPage adminPage = new AdminPage();


    @Test
    public void TC_3601(){

        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));

        adminPage.usernametextbox.sendKeys(ConfigReader.getProperty("adminuser_hasan")+ Keys.TAB);
        adminPage.passwordtextbox.sendKeys(ConfigReader.getProperty("adminpassword_hasan"));
        adminPage.singinButton.click();

        Assert.assertTrue(adminPage.previewStoreButton.isDisplayed());
        Assert.assertTrue(adminPage.previewStoreButton.isEnabled());

        Assert.assertTrue(adminPage.adminPicture.isDisplayed());

        Assert.assertTrue(adminPage.userprofileName.isDisplayed());
        Assert.assertTrue(adminPage.userprofileName.isEnabled());
        adminPage.userprofileName.click();

        ReusableMethods.wait(2);

        Assert.assertTrue(adminPage.profileText.isDisplayed());
        Assert.assertTrue(adminPage.profileText.isEnabled());

        Assert.assertTrue(adminPage.logoutText.isDisplayed());
        Assert.assertTrue(adminPage.logoutText.isEnabled());

        Assert.assertTrue(adminPage.notificationsIcon.isDisplayed());
        Assert.assertTrue(adminPage.notificationsIcon.isEnabled());

        Driver.quitDriver();

    }

    @Test
    public void TC_3602(){

        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));

        adminPage.usernametextbox.sendKeys(ConfigReader.getProperty("adminuser_hasan")+ Keys.TAB);
        adminPage.passwordtextbox.sendKeys(ConfigReader.getProperty("adminpassword_hasan"));
        adminPage.singinButton.click();

        Assert.assertTrue(adminPage.notificationsIcon.isDisplayed());
        adminPage.notificationsIcon.click();

        ReusableMethods.wait(2);

        Assert.assertTrue(adminPage.notificationsText.isDisplayed());
        Assert.assertTrue(adminPage.notificationsQuantityText.isDisplayed());

        if(adminPage.notificationsQuantity.isEmpty()){
            Assert.assertTrue(adminPage.emptyNotifications.isDisplayed());
        }
        else{
            Assert.assertTrue(adminPage.clearAllButton.isDisplayed());
            Assert.assertTrue(adminPage.clearAllButton.isEnabled());
            adminPage.clearAllButton.click();

            int expectedNotificationQuantity = 0;
            int actualNotificationsQuantity = adminPage.notificationsQuantity.size();

            Assert.assertEquals(actualNotificationsQuantity,expectedNotificationQuantity);

            Assert.assertTrue(adminPage.viewAllButton.isDisplayed());
            Assert.assertTrue(adminPage.viewAllButton.isEnabled());
        }

        Driver.quitDriver();







    }

    @Test
    public void TC_3603(){
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));

        adminPage.usernametextbox.sendKeys(ConfigReader.getProperty("adminuser_hasan")+ Keys.TAB);
        adminPage.passwordtextbox.sendKeys(ConfigReader.getProperty("adminpassword_hasan"));
        adminPage.singinButton.click();

        for (int i = 0; i < adminPage.dashboardTotalHeadings.size(); i++) {
            Assert.assertTrue(adminPage.dashboardTotalHeadings.get(i).isDisplayed());

        }



    }
}
