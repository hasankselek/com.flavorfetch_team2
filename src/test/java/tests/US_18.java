package tests;

import com.sun.jna.StringArray;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomerPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class US_18 {

    CustomerPage customerPage=new CustomerPage();
    Actions actions=new Actions(Driver.getDriver());
    @Test

    public  void TC_1801(){
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        customerPage.signInButton.click();
        actions.click(customerPage.emailBox)
                .sendKeys(ConfigReader.getProperty("customer_kübra")).sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("customerpassword_kübra")).perform();
        customerPage.loginSigninButton.click();
        customerPage.cookieAccept.click();
        ReusableMethods.wait(3);
        customerPage.profileDropdownMenu.click();
        Assert.assertTrue(customerPage.savedStoreIcon.isDisplayed());
        Driver.quitDriver();

    }
    @Test
    public  void  TC_1802(){
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        customerPage.signInButton.click();
        actions.click(customerPage.emailBox)
                .sendKeys(ConfigReader.getProperty("customer_kübra")).sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("customerpassword_kübra")).perform();
        customerPage.loginSigninButton.click();
        customerPage.cookieAccept.click();
        ReusableMethods.wait(3);
        customerPage.profileDropdownMenu.click();
        customerPage.savedStoreIcon.click();
        Assert.assertTrue(customerPage.savedStoreRestaurants.size()>0);

    }
    @Test
    public  void  TC_1803(){
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        customerPage.signInButton.click();
        actions.click(customerPage.emailBox)
                .sendKeys(ConfigReader.getProperty("customer_kübra")).sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("customerpassword_kübra")).perform();
        customerPage.loginSigninButton.click();
        customerPage.cookieAccept.click();
        ReusableMethods.wait(3);
        customerPage.profileDropdownMenu.click();
        customerPage.savedStoreIcon.click();

        List<WebElement> savedStoreRestaurants=customerPage.savedStoreRestaurants;
        String expectedRestaurantsName=savedStoreRestaurants.get(0).getText();
        System.out.println(expectedRestaurantsName);
        customerPage.heartIcon.click();
        Driver.getDriver().navigate().refresh();
        String actualRestaurantsName=savedStoreRestaurants.get(0).getText();
        System.out.println(actualRestaurantsName);

        Assert.assertNotEquals(actualRestaurantsName,expectedRestaurantsName);
        Driver.quitDriver();
    }
  
    @Test
    public  void  TC_1804(){

        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        customerPage.signInButton.click();
        actions.click(customerPage.emailBox)
                .sendKeys(ConfigReader.getProperty("customer_kübra")).sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("customerpassword_kübra")).perform();
        customerPage.loginSigninButton.click();
        customerPage.cookieAccept.click();
        ReusableMethods.wait(3);
        customerPage.profileDropdownMenu.click();
        customerPage.savedStoreIcon.click();
        customerPage.orderNowButton.click();
        ReusableMethods.windowaGec("https://qa.flavorfetch.com/restaurants",Driver.getDriver());
        String expectedUrlIcerik="restaurants";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        Driver.quitDriver();


    }


}