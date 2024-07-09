package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MerchantPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_022 {

    MerchantPage merchantPage=new MerchantPage();
    SoftAssert softAssert=new SoftAssert();

    @Test
    public void TC_2201(){
        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));


    }
}
