package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;


public class  US_001{

    @Test
    public void TC_0101() {
        //customer url access test
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        String expectedUrl = "https://qa.flavorfetch.com/" ;
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
        Driver.quitDriver();

    }

}
