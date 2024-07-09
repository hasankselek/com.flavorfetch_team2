package tests;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.CustomerPage;
import pages.MerchantPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_011 {
    CustomerPage customerPage = new CustomerPage();

    @Test
    public void TC_1101(){

        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        customerPage.signInButton.click();
        customerPage.emailBox.sendKeys(ConfigReader.getProperty("customeruser_hasan")+Keys.TAB+
                                                    ConfigReader.getProperty("customerpassword_hasan")+Keys.ENTER);
        customerPage.sandwichAndWraps.click(); // sandwich and wraps
        customerPage.team2Restaurant.click(); // team2 restaurant

    }
}
