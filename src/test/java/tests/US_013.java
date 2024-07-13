package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomerPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_013 {
    CustomerPage customerPage=new CustomerPage();
    Actions actions = new Actions(Driver.getDriver());
    @Test
    public void TC_1301(){

        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));

        customerPage.signInButton.click();
        customerPage.emailBox.sendKeys(ConfigReader.getProperty("customeruser_selahattin"));
        customerPage.passwordBox.sendKeys(ConfigReader.getProperty("customerpassword_selahattin"));
        customerPage.loginSigninButton.click();
        customerPage.enterDeliveryAddresstextBox.sendKeys("new york" );
        customerPage.newYorkAddressTextBox.click();
        ReusableMethods.wait2(1);
       //JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
       //jse.executeScript("arguments[0].scrollIntoView({block: 'center'});",customerPage.showMoreButton);
       //actions.click(customerPage.showMoreButton).perform();
        customerPage.sandwichRAdioButton.isDisplayed();
        actions.click(customerPage.sandwichRAdioButton).perform();
        customerPage.cookieAccept.click();
        actions.click(customerPage.team2Page).perform();
        actions.click(customerPage.iskenderButton).perform();
        customerPage.checkoutButton.click();
        customerPage.addNewAddressLink.click();
        customerPage.addressPopupTextBox.sendKeys("new");
        customerPage.newYorkAddressTextBox.click();
        ReusableMethods.wait2(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        customerPage.saveButtonChangeAddress.click();

        String expectedYazi = "New York, NY, USA";
        String actualYazi = customerPage.chooseDeliveryText.getText();
        Assert.assertEquals(actualYazi,expectedYazi);

        Driver.quitDriver();
    }
}
