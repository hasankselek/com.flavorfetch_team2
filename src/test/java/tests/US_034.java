package tests;

import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_034 {

    @Test
    public void TC_3401(){
        Driver.getDriver().get("customer_Url");
        ReusableMethods.wait2(2);
        Driver.quitDriver();
    }
}
