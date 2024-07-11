package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminPage;
import pages.CustomerPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_040 {

    AdminPage adminPage = new AdminPage();
    @Test
    public void US_4001 (){

        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));

        adminPage.userNameButton.sendKeys(ConfigReader.getProperty("adminuser_serhat")+ Keys.TAB+
                ConfigReader.getProperty("adminpassword_serhat"));
        adminPage.signInButton.click();





       // Driver.quitDriver();


        }









    @Test
    public void US_4002 (){

    }




    @Test
    public void US_4003 (){

    }




    @Test
    public void US_4004 (){

    }




    @Test
    public void US_4005 (){

    }


















}
