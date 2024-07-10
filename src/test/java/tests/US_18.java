package tests;

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

   Actions actions =new Actions(Driver.getDriver());
    @Test
    public  void  TC1801(){

        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));

        CustomerPage customerPage=new CustomerPage();

        customerPage.signInButton.click();

        actions.click(customerPage.emailBox).
                sendKeys(ConfigReader.getProperty("customeruser_kübra")).sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("customerpassword_kübra")).perform();


        customerPage.loginSigninButton.click();

        customerPage.cookieAccept.click();

        customerPage.profileDropdownMenu.click();

        Assert.assertTrue(customerPage.savedStoreIcon.isDisplayed());

        Driver.quitDriver();




    }

    @Test
    public  void  TC1802(){
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));

        CustomerPage customerPage=new CustomerPage();

        customerPage.signInButton.click();

        actions.click(customerPage.emailBox).
                sendKeys(ConfigReader.getProperty("customeruser_kübra")).sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("customerpassword_kübra")).perform();


        customerPage.loginSigninButton.click();

        ReusableMethods.wait(3);
        customerPage.cookieAccept.click();
        ReusableMethods.wait(3);
        customerPage.profileDropdownMenu.click();
        customerPage.savedStoreIcon.click();

       Assert.assertTrue(customerPage.savedStoreRestaurants.size()>0);
       Driver.quitDriver();



    }

    @Test
    public  void  TC1803(){
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));

        CustomerPage customerPage=new CustomerPage();

        customerPage.signInButton.click();

        actions.click(customerPage.emailBox).
                sendKeys(ConfigReader.getProperty("customeruser_kübra")).sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("customerpassword_kübra")).perform();


        customerPage.loginSigninButton.click();

        ReusableMethods.wait(3);
        customerPage.cookieAccept.click();
        ReusableMethods.wait(3);
        customerPage.profileDropdownMenu.click();
        customerPage.savedStoreIcon.click();

        List<WebElement> savedStoreRestaurants=Driver.getDriver().findElements(By.xpath("//h5[@class='m-0 text-truncate']"));

        System.out.println(customerPage.savedStoreRestaurants.size());
        customerPage.heartIcon.click();
        Driver.driver.navigate().refresh();
        List<WebElement> bulunanSonucElementleriList=Driver.getDriver().findElements(By.xpath("//h5[@class='m-0 text-truncate']"));

        System.out.println(bulunanSonucElementleriList.size());
     Assert.assertTrue(savedStoreRestaurants.size()>bulunanSonucElementleriList.size());


     Driver.quitDriver();
    }

    @Test
    public  void  TC1804(){
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));

        CustomerPage customerPage=new CustomerPage();

        customerPage.signInButton.click();

        actions.click(customerPage.emailBox).
                sendKeys(ConfigReader.getProperty("customeruser_kübra")).sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("customerpassword_kübra")).perform();


        customerPage.loginSigninButton.click();

        ReusableMethods.wait(3);
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
