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
    @Test
    public void TC_1302(){
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        customerPage.signInButton.click();
        customerPage.emailBox.sendKeys(ConfigReader.getProperty("customeruser_selahattin"));
        customerPage.passwordBox.sendKeys(ConfigReader.getProperty("customerpassword_selahattin"));
        customerPage.loginSigninButton.click();
        customerPage.enterDeliveryAddresstextBox.sendKeys("new york" );
        customerPage.newYorkAddressTextBox.click();
        ReusableMethods.wait2(1);
        customerPage.sandwichRAdioButton.isDisplayed();
        actions.click(customerPage.sandwichRAdioButton).perform();
        customerPage.cookieAccept.click();
        actions.click(customerPage.team2Page).perform();
        actions.click(customerPage.iskenderButton).perform();
        customerPage.checkoutButton.click();
        ReusableMethods.wait2(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait2(1);
        customerPage.stripeButton.click();
        customerPage.addStripeButton.click();
    }
    @Test
    public void TC_1303(){

        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        customerPage.signInButton.click();
        customerPage.emailBox.sendKeys(ConfigReader.getProperty("customeruser_selahattin"));
        customerPage.passwordBox.sendKeys(ConfigReader.getProperty("customerpassword_selahattin"));
        customerPage.loginSigninButton.click();
        customerPage.enterDeliveryAddresstextBox.sendKeys("new york" );
        customerPage.newYorkAddressTextBox.click();
        ReusableMethods.wait2(1);
        customerPage.sandwichRAdioButton.isDisplayed();
        actions.click(customerPage.sandwichRAdioButton).perform();
        customerPage.cookieAccept.click();
        actions.click(customerPage.team2Page).perform();
        actions.click(customerPage.iskenderButton).perform();
        customerPage.checkoutButton.click();
        ReusableMethods.wait2(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait2(1);
        customerPage.cashOnDeliveryButton.click();
        customerPage.addCashButton.click();
        String expectedYazi="Saved Payment Methods";
        String actualYazi = customerPage.savedPaymentMethodsText.getText();
        Assert.assertEquals(actualYazi,expectedYazi);
        Driver.quitDriver();
    }
    @Test
    public void TC_1304(){
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        customerPage.signInButton.click();
        customerPage.emailBox.sendKeys(ConfigReader.getProperty("customeruser_selahattin"));
        customerPage.passwordBox.sendKeys(ConfigReader.getProperty("customerpassword_selahattin"));
        customerPage.loginSigninButton.click();
        customerPage.enterDeliveryAddresstextBox.sendKeys("new york" );
        customerPage.newYorkAddressTextBox.click();
        ReusableMethods.wait2(1);
        customerPage.sandwichRAdioButton.isDisplayed();
        actions.click(customerPage.sandwichRAdioButton).perform();
        customerPage.cookieAccept.click();
        actions.click(customerPage.team2Page).perform();
        actions.click(customerPage.iskenderButton).perform();
        customerPage.checkoutButton.click();
        customerPage.orderTypeMenuText.isDisplayed();
        customerPage.orderTypeLink.click();
        customerPage.deliveryRadioButton.click();
        customerPage.orderTypeSaveButton.click();
        customerPage.addNewAddressLink.click();
        customerPage.addressPopupTextBox.sendKeys("new");
        customerPage.newYorkAddressTextBox.click();
        ReusableMethods.wait2(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        customerPage.saveButtonChangeAddress.click();
        ReusableMethods.wait2(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait2(1);
        customerPage.cashOnDeliveryButton.click();
        customerPage.addCashButton.click();
        customerPage.placeOrderButtonText.isDisplayed();
        customerPage.placeOrderButton.click();
        String expectedText= "Confirming your order";
        String actualText = customerPage.confirmingText.getText();
        Assert.assertEquals(actualText,expectedText);
        Driver.quitDriver();

    }
    @Test
    public void TC_1305(){
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        customerPage.signInButton.click();
        customerPage.emailBox.sendKeys(ConfigReader.getProperty("customeruser_selahattin"));
        customerPage.passwordBox.sendKeys(ConfigReader.getProperty("customerpassword_selahattin"));
        customerPage.loginSigninButton.click();
        customerPage.enterDeliveryAddresstextBox.sendKeys("new york" );
        customerPage.newYorkAddressTextBox.click();
        ReusableMethods.wait2(1);
        customerPage.sandwichRAdioButton.isDisplayed();
        actions.click(customerPage.sandwichRAdioButton).perform();
        customerPage.cookieAccept.click();
        actions.click(customerPage.team2Page).perform();
        actions.click(customerPage.iskenderButton).perform();
        customerPage.checkoutButton.click();
        customerPage.orderTypeMenuText.isDisplayed();
        customerPage.orderTypeLink.click();
        customerPage.dineinRadioButton.click();
        customerPage.orderTypeSaveButton.click();
        //customerPage.addNewAddressLink.click();
        //customerPage.addressPopupTextBox.sendKeys("new");
        //customerPage.newYorkAddressTextBox.click();
        //ReusableMethods.wait2(1);
        //actions.sendKeys(Keys.PAGE_DOWN).perform();
        //customerPage.saveButtonChangeAddress.click();
        ReusableMethods.wait2(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait2(1);
        customerPage.cashOnDeliveryButton.click();
        customerPage.addCashButton.click();
        customerPage.placeOrderButtonText.isDisplayed();
        actions.click(customerPage.placeOrderButton).perform();
        ReusableMethods.wait2(1);
        String expectedText= "Confirming your order";
        String actualText = customerPage.confirmingText.getText();
        Assert.assertEquals(actualText,expectedText);
        Driver.quitDriver();
    }

    @Test
    public void TC_1306(){
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        customerPage.signInButton.click();
        customerPage.emailBox.sendKeys(ConfigReader.getProperty("customeruser_selahattin"));
        customerPage.passwordBox.sendKeys(ConfigReader.getProperty("customerpassword_selahattin"));
        customerPage.loginSigninButton.click();
        customerPage.enterDeliveryAddresstextBox.sendKeys("new york" );
        customerPage.newYorkAddressTextBox.click();
        ReusableMethods.wait2(1);
        customerPage.sandwichRAdioButton.isDisplayed();
        actions.click(customerPage.sandwichRAdioButton).perform();
        customerPage.cookieAccept.click();
        actions.click(customerPage.team2Page).perform();
        actions.click(customerPage.iskenderButton).perform();
        customerPage.checkoutButton.click();
        customerPage.orderTypeMenuText.isDisplayed();
        customerPage.orderTypeLink.click();
        customerPage.pickUpRadioButton.click();
        customerPage.orderTypeSaveButton.click();
        //customerPage.addNewAddressLink.click();
        //customerPage.addressPopupTextBox.sendKeys("new");
        //customerPage.newYorkAddressTextBox.click();
        //ReusableMethods.wait2(1);
        //actions.sendKeys(Keys.PAGE_DOWN).perform();
        //customerPage.saveButtonChangeAddress.click();
        ReusableMethods.wait2(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait2(1);
        customerPage.cashOnDeliveryButton.click();
        customerPage.addCashButton.click();
        customerPage.placeOrderButtonText.isDisplayed();
        actions.click(customerPage.placeOrderButton).perform();
        ReusableMethods.wait2(2);
        String expectedText= "Confirming your order";
        String actualText = customerPage.confirmingText.getText();
        Assert.assertEquals(actualText,expectedText);
        Driver.quitDriver();

    }
}
