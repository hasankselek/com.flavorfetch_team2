package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;
import java.util.List;

public class US_037 extends TestBaseRapor {

    AdminPage adminPage = new AdminPage();

    @Test
    public void TC_3701() {
        adminPage = new AdminPage();
        accessToListPage();
        Driver.quitDriver();


    }

    @Test
    public void TC_3702() {

        adminPage = new AdminPage();
        accessToListPage();

        Assert.assertTrue(adminPage.SearchSide.isEnabled());
        Assert.assertTrue(adminPage.SearchSide.isDisplayed());
        adminPage.SearchSide.sendKeys("Happy", Keys.ENTER);
        ReusableMethods.wait(1);

        List<String> merchantStringList = ReusableMethods.stringListesineDonustur(adminPage.merchantList);
        for (String s : merchantStringList) {
            Assert.assertTrue(s.contains("Happy"));
        }
        Driver.quitDriver();

    }

    @Test
    public void TC_3703() {
        adminPage =new AdminPage();
        accessToListPage();

        Assert.assertTrue(adminPage.updateButton.isDisplayed());
        Assert.assertTrue(adminPage.updateButton.isEnabled());
        adminPage.updateButton.click();


        Driver.quitDriver();

    }

    @Test
    public void TC_3704() throws IOException {
        adminPage = new AdminPage();
        accessToListPage();
        Assert.assertTrue(adminPage.updateButton.isDisplayed());
        Assert.assertTrue(adminPage.updateButton.isEnabled());
        adminPage.updateButton.click();


        Assert.assertTrue(adminPage.updatePageRestaurantName.isDisplayed());
        adminPage.updatePageRestaurantName.clear();
        adminPage.updatePageRestaurantName.sendKeys("Ahmet");
        ReusableMethods.wait(1);

        Assert.assertTrue(adminPage.updatePageRestaurantSlug.isDisplayed());
        adminPage.updatePageRestaurantSlug.clear();
        adminPage.updatePageRestaurantSlug.sendKeys("Mehmet");
        ReusableMethods.wait(1);

        Assert.assertTrue(adminPage.updatePageContactName.isDisplayed());
        adminPage.updatePageContactName.clear();
        adminPage.updatePageContactName.sendKeys("Ali uysal");
        ReusableMethods.wait(1);

        Assert.assertTrue(adminPage.updatePageContactPhone.isDisplayed());
        adminPage.updatePageContactPhone.clear();
        adminPage.updatePageContactPhone.sendKeys("+65466465654");

        Assert.assertTrue(adminPage.updatePageContactEmail.isDisplayed());
        adminPage.updatePageContactEmail.clear();
        adminPage.updatePageContactEmail.sendKeys("mehmet.ozzdemir@hotmail.com");
        ReusableMethods.wait(1);

        WebElement firstBrowseButton = Driver.getDriver().findElement(By.xpath("(//div/button[@class='btn btn-info'])[1]"));
        Assert.assertTrue(firstBrowseButton.isDisplayed());
        Assert.assertTrue(firstBrowseButton.isEnabled());
        firstBrowseButton.click();
        ReusableMethods.wait(2);


        WebElement uploadNew = Driver.getDriver().findElement(By.xpath("(//a[@class='nav-link active'])[1]"));
        Actions actions = new Actions(Driver.getDriver());
        actions.click(uploadNew).perform();
        ReusableMethods.wait(1);
        WebElement selectFiles = Driver.getDriver().findElement(By.xpath("(//a[@class='nav-link active'])[2]"));

        actions.click(selectFiles).sendKeys("/Users/mehmetozdemir/Downloads/dji_fly_20230807_130024_98_1691406064348_photo_optimized");

        WebElement addFiles = Driver.getDriver().findElement(By.xpath("(//*[text()='Add Files'])[1]"));
        Assert.assertTrue(selectFiles.isSelected());




        ReusableMethods.wait(1);


        Driver.quitDriver();

    }

    @Test
    public void TC_3705() {
        adminPage = new AdminPage();
        accessToListPage();
        Assert.assertTrue(adminPage.listPageDeleteButton.isDisplayed());
        Assert.assertTrue(adminPage.listPageDeleteButton.isEnabled());

        try {
            adminPage.listPageDeleteButton.click();
            Assert.assertTrue(true);
        } catch (Exception e) {
            Assert.assertTrue(false);
        }

        Driver.quitDriver();

    }

    public void accessToListPage() {
        ReusableMethods.accessAdmin("adminuser_mehmet", "adminpassword_mehmet");
        Assert.assertTrue(adminPage.MerchantSide.isDisplayed());
        Assert.assertTrue(adminPage.MerchantSide.isEnabled());
        adminPage.MerchantSide.click();
        ReusableMethods.wait(1);

        Assert.assertTrue(adminPage.ListSide.isDisplayed());
        Assert.assertTrue(adminPage.ListSide.isEnabled());
        adminPage.ListSide.click();
        ReusableMethods.wait(1);
    }
}
