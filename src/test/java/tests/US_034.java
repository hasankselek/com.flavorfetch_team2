package tests;

import org.testng.annotations.Test;
import utilities.Driver;

public class US_034 {

    @Test
    public void TC_3401(){
        Driver.getDriver().get("customer_Url");
        Driver.quitDriver();
    }
}
