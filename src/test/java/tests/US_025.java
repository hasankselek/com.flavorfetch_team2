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
import utilities.TestBaseRapor;

import java.io.IOException;

public class US_025 extends TestBaseRapor {

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
    public void TC_2502()throws IOException {// bugli
        merchantPage = new MerchantPage();
        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
        extentTest.info("kullanici merchant anasayfasina gider");
        merchantPage.usernametextbox.sendKeys(ConfigReader.getProperty("merchant_username"));
        extentTest.info("kullanici mail bilgilerini girer");
        merchantPage.passwordtextbox.sendKeys(ConfigReader.getProperty("merchant_password"));
        extentTest.info("kullanici password bilgilerini girer");
        merchantPage.singinButton.click();
        extentTest.info("kullanci signIn butonuna tiklar");
        merchantPage.foodLink.click();
        extentTest.info("kullanici food linkine tiklar");
        merchantPage.itemsLink.isDisplayed();
        extentTest.info("kullanici item linkinin gorunurlugunu kontrol eder");
        merchantPage.itemsLink.click();
        extentTest.info("kullanucu item linkine tiklar");
        merchantPage.deleteButtonAddItem.isDisplayed();
        extentTest.info("kullanici delete butonunun gorunurlugunu kontrol eder");
        merchantPage.deleteButtonAddItem.click();
        extentTest.info("kullanici delete butonuna tiklar");
        Driver.quitDriver();
    }

    @Test
    public void TC_2503(){
        actions = new Actions(Driver.getDriver());
        merchantPage = new MerchantPage();
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
