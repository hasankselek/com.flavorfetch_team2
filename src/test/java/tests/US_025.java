package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MerchantPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_025 {

    MerchantPage merchantPage = new MerchantPage();
    Actions actions = new Actions(Driver.getDriver());
    @Test
    public void TC_2501(){

        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));

        merchantPage.usernametextbox.sendKeys(ConfigReader.getProperty("merchant_username"));
        merchantPage.passwordtextbox.sendKeys(ConfigReader.getProperty("merchant_password"));
        merchantPage.singinButton.click();

        merchantPage.foodLink.click();
        merchantPage.itemsLink.isDisplayed();
        merchantPage.itemsLink.click();

        merchantPage.itemsPageAddnewButton.click();

        merchantPage.itemNameTextBox.sendKeys("Tavuk Sis");


        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Select select = new Select(merchantPage.categoryDropdown);
        select.selectByValue("414");
        //actions.sendKeys(Keys.PAGE_DOWN).perform();
        merchantPage.saveButtonAddItem.submit();

        Driver.quitDriver();
    }

    @Test
    public void TC_2502(){

        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));

        merchantPage.usernametextbox.sendKeys(ConfigReader.getProperty("merchant_username"));
        merchantPage.passwordtextbox.sendKeys(ConfigReader.getProperty("merchant_password"));
        merchantPage.singinButton.click();

        merchantPage.foodLink.click();
        merchantPage.itemsLink.isDisplayed();
        merchantPage.itemsLink.click();
        merchantPage.deleteButtonAddItem.isDisplayed();
        merchantPage.deleteButtonAddItem.click();
        Driver.quitDriver();
    }

    @Test
    public void TC_2503(){

        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));

        merchantPage.usernametextbox.sendKeys(ConfigReader.getProperty("merchant_username"));
        merchantPage.passwordtextbox.sendKeys(ConfigReader.getProperty("merchant_password"));
        merchantPage.singinButton.click();

        merchantPage.foodLink.click();
        merchantPage.itemsLink.isDisplayed();
        merchantPage.itemsLink.click();

        merchantPage.uptadeButtonAddItem.click();

        String expectedYazi = "Update Item";
        String actualYazi= merchantPage.uptadeItemTextBox.getText();
        Assert.assertEquals(actualYazi,expectedYazi);

        merchantPage.uptadeItemMenu.isDisplayed();
        merchantPage.itemPrice.click();
        merchantPage.uptadeItemPrice.isDisplayed();
        merchantPage.uptadeItemPrice.click();
        merchantPage.uptadeItemPriceTextBox.isDisplayed();
        merchantPage.uptadeItemPriceTextBox.sendKeys("25.00");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        merchantPage.saveUptadeItem.click();

        ReusableMethods.wait2(1);
        Driver.quitDriver();
    }

}
