package tests;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.CustomerPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_011 {

    CustomerPage customerPage = new CustomerPage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void TC_1101(){
        actions = new Actions(Driver.getDriver());
        customerPage = new CustomerPage();
        // Kullanıcı qa.flavorfetch.com'a gider
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));

        // Geçerli email ve şifre ile giriş yapar
        customerPage.signInButton.click();
        customerPage.emailBox.sendKeys(ConfigReader.getProperty("customeruser_hasan")+Keys.TAB+
                                                    ConfigReader.getProperty("customerpassword_hasan")+Keys.ENTER);
        // Cookie'yi kabul eder
        customerPage.cookieAccept.click();

        // Anasayfa'dan sandwich and wraps'i seçer

        actions.click(customerPage.sandwichAndWraps).perform(); // sandwich and wraps

        // Team2 Restaurant'ını seçer
        customerPage.team2Restaurant.click(); // team2 restaurant

    }
}
