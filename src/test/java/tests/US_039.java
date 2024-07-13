package tests;

import org.bouncycastle.pqc.crypto.newhope.NHSecretKeyProcessor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtilities;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class US_039 {

    static AdminPage adminPage = new AdminPage();
    Actions actions = new Actions(Driver.getDriver());

    @Test // search box testing
    public void TC_3901() {
        actions = new Actions(Driver.getDriver());
        adminPage = new AdminPage();
        ReusableMethods.accessToAdmin("adminuser_hasan", "adminpassword_hasan");
        actions.click(adminPage.adminDashboardEarningsButton).moveToElement(adminPage.adminDashboardMerchantEarningsButton).click().perform();


        ReusableMethods.wait(2);
        Assert.assertTrue(adminPage.merchantEarringPageSearchText.isDisplayed());
        Assert.assertTrue(adminPage.merchantEarringPageSearchBox.isDisplayed());
        Assert.assertTrue(adminPage.merchantEarringPageSearchBox.isEnabled());

        actions.moveToElement(adminPage.merchantEarringPageSearchBox).click().perform();
        adminPage.merchantEarringPageSearchBox.sendKeys("Team" + Keys.ENTER);

        ReusableMethods.wait(3);

        boolean isTeam2Found = false;
        for (WebElement each : adminPage.merchantEarringProducts) {
            if (each.getText().contains("Team2")) {
                isTeam2Found = true;
                break;
            }
        }

        Driver.quitDriver();
    }

    @Test //Test of display and calculation of total commission and balance
    public void TC_3902() {
        adminPage = new AdminPage();
        actions = new Actions(Driver.getDriver());
        ReusableMethods.accessToAdmin("adminuser_hasan", "adminpassword_hasan");
        actions.click(adminPage.adminDashboardEarningsButton).moveToElement(adminPage.adminDashboardMerchantEarningsButton).click().perform();


        for (int i = 0; i < adminPage.merchantEarringTotalHeadings.size(); i++) {
            Assert.assertTrue(adminPage.merchantEarringTotalHeadings.get(i).isDisplayed());
            Assert.assertTrue(adminPage.merchantEarringTotalHeadings.get(i).getText().contains("Total Commission") ||
                    adminPage.merchantEarringTotalHeadings.get(i).getText().contains("Total Balance"));
            Assert.assertTrue(adminPage.merchantEarringTotalHeadings.get(i).getText().contains("$"));
        }

        Driver.quitDriver();

    }

    @Test
    public void TC_3903() {
        adminPage = new AdminPage();
        actions = new Actions(Driver.getDriver());
        ReusableMethods.accessToAdmin("adminuser_hasan", "adminpassword_hasan");
        actions.click(adminPage.adminDashboardEarningsButton).moveToElement(adminPage.adminDashboardMerchantEarningsButton).click().perform();

        Assert.assertTrue(adminPage.merchantEarringMerchantTitle.isDisplayed());
        Assert.assertTrue(adminPage.merchantEarringBalanceTitle.isDisplayed());
        Assert.assertTrue(adminPage.merchantEarringActionTitle.isDisplayed());

        Driver.quitDriver();
    }

    @Test
    public void TC_3904() {
        adminPage = new AdminPage();
        actions = new Actions(Driver.getDriver());
        ReusableMethods.accessToAdmin("adminuser_hasan", "adminpassword_hasan");
        actions.click(adminPage.adminDashboardEarningsButton).moveToElement(adminPage.adminDashboardMerchantEarningsButton).click().perform();

        JSUtilities.sayfaOlcegiDegistirme(Driver.getDriver(),75);

        JSUtilities.clickWithJS(Driver.getDriver(),adminPage.merchantEarringMerchantTitle);
        ReusableMethods.wait(1);

        List<String> totalMerchantNames = new ArrayList<>();

        for (int page = 1; page <= 3; page++) {
            ReusableMethods.wait(1);
            // Restoranların isimlerini alın
            List<WebElement> nameElements = adminPage.merchantEarringMerchantList;
            for (WebElement nameElement : nameElements) {
                totalMerchantNames.add(nameElement.getText().toLowerCase().trim());
            }

            if (page < 3) {
                WebElement nextPageButton = Driver.getDriver().findElement(By.xpath("//*[@data-dt-idx='4']")); // AdminPage sınıfında nextPageButton öğesini tanımladığınızdan emin olun
                JSUtilities.clickWithJS(Driver.getDriver(),nextPageButton);
                ReusableMethods.wait(1);
            }
        }

        // Sıralamayı kontrol et (alfabetik sırayla)
        boolean isSortedMerchant = true;
        for (int i = 1; i < totalMerchantNames.size(); i++) {
            if (totalMerchantNames.get(i).compareTo(totalMerchantNames.get(i - 1)) < 0) {
                isSortedMerchant = false;
                break;
            }
        }

        Assert.assertTrue(isSortedMerchant);


        // "Balance" butonuna tıklayın
        JSUtilities.clickWithJS(Driver.getDriver(),adminPage.merchantEarringBalanceTitle);
        ReusableMethods.wait(3);

        List<Double> totalBalances = new ArrayList<>();

        for (int page = 1; page <= 3; page++) {

            ReusableMethods.wait(1);
            // Restoranların bakiyelerini alın
            List<WebElement> balanceElements = adminPage.merchantEarringBalanceList;
            for (WebElement balanceElement : balanceElements) {
                String balanceText = balanceElement.getText().replace("$", "").replace(".", "").replace(".", "");
                totalBalances.add(Double.parseDouble(balanceText));
            }

            if (page < 3) {
                WebElement nextPageButton = Driver.getDriver().findElement(By.xpath("//*[@data-dt-idx='4']")); // next butonu
                JSUtilities.clickWithJS(Driver.getDriver(),nextPageButton);
                ReusableMethods.wait(1);
            }
        }

        // Tüm sayfalardaki restoran bakiyelerinin doğru sıralandığını kontrol edin

        // Sıralamayı kontrol et (büyükten küçüğe)
        boolean isSortedBalance = true;
        for (int i = 1; i < totalBalances.size(); i++) {
            if (totalBalances.get(i) > totalBalances.get(i - 1)) {
                isSortedBalance = false;
                break;
            }

        }

        Assert.assertTrue(isSortedBalance);

        Driver.quitDriver();
    }

    @Test
    public void TC_3905() {
        adminPage = new AdminPage();
        actions = new Actions(Driver.getDriver());
        ReusableMethods.accessToAdmin("adminuser_hasan", "adminpassword_hasan");
        actions.click(adminPage.adminDashboardEarningsButton).moveToElement(adminPage.adminDashboardMerchantEarningsButton).click().perform();


    }




























}



