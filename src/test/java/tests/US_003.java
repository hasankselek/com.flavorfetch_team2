package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomerPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_003 {
        CustomerPage customerPage = new CustomerPage();
        Actions actions = new Actions(Driver.getDriver());
    @Test
    public void TC_0301(){
        try {
            customerPage = new CustomerPage();
            Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
            customerPage.enterDeliveryAddresstextBox.sendKeys("new york");
            customerPage.newYorkAddressTextBox.click();
            customerPage.avoSaladsMarket.click();
        } finally { Driver.quitDriver();
        }

    }
    @Test
    public void TC_0302(){
        try {
            customerPage= new CustomerPage();
            Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
            customerPage.enterDeliveryAddresstextBox.sendKeys("new york" );
            customerPage.newYorkAddressTextBox.click();
            actions.click(customerPage.sandwichRAdioButton).perform();
               } finally {Driver.quitDriver();
        }

    }
    @Test
    public void TC_0303(){
        try {
            customerPage= new CustomerPage();
            Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
            customerPage.enterDeliveryAddresstextBox.sendKeys("new york" );
            customerPage.newYorkAddressTextBox.click();
            customerPage.avoSaladsMarket.click();

        } finally { Driver.quitDriver();
        }

    }
    @Test
    public void TC_0304(){
        customerPage= new CustomerPage();
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        customerPage.informationBox.isDisplayed();
        Driver.quitDriver();
    }
    @Test
    public void TC_0305(){
        customerPage= new CustomerPage();
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView({block: 'center'});",customerPage.joinButton);
        actions.click(customerPage.joinButton).perform();
        String expectedText = "Become Restaurant partner";
        String actualText = customerPage.becomeRestaurantText.getText();
        Assert.assertEquals(actualText,expectedText);
        Driver.quitDriver();
    }
}
