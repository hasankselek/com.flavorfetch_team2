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


        // Kullanıcı qa.flavorfetch.com'a gider
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));

        // Geçerli email ve şifre ile giriş yapar
        customerPage.signInButton.click();
        customerPage.emailBox.sendKeys(ConfigReader.getProperty("customeruser_hasan")+Keys.TAB+
                                                    ConfigReader.getProperty("customerpassword_hasan")+Keys.ENTER);
        // Cookie'yi kabul eder
        customerPage.cookieAccept.click();

        // Anasayfa'dan sandwich and wraps'i seçer
        customerPage.sandwichAndWraps.click(); // sandwich and wraps

        // Team2 Restaurant'ını seçer
        customerPage.team2Restaurant.click(); // team2 restaurant

    }
}
