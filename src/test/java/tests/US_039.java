package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import utilities.Driver;
import utilities.JSUtilities;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class US_039 extends TestBaseRapor {


    static AdminPage adminPage = new AdminPage();
    Actions actions = new Actions(Driver.getDriver());

    @Test // search box testing
    public void TC_3901() {
        actions = new Actions(Driver.getDriver());
        adminPage = new AdminPage();
        ReusableMethods.accessAdmin("adminuser_hasan", "adminpassword_hasan");
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
    public void TC_3902() throws IOException {

            adminPage = new AdminPage();
            actions = new Actions(Driver.getDriver());
            ReusableMethods.accessAdmin("adminuser_hasan", "adminpassword_hasan");
            extentTest.info("Kullanici browser'ı açar geçerli üyelikle giriş yapar");

            actions.click(adminPage.adminDashboardEarningsButton).moveToElement(adminPage.adminDashboardMerchantEarningsButton).click().perform();
            extentTest.info("Ekranın solundaki menüden Earrings'e tıklar ve Merchant Earrings' tıklar");

            Assert.assertTrue(adminPage.merchantEarringsTitle.isDisplayed());
            extentTest.pass("Merchant Earrings başlığının varlığını doğrular");
            Assert.assertTrue(adminPage.merchantEarringsTitle.getText().contains("Merchant Earnings"));
            extentTest.pass("Merchant Earrings başlığında 'Merchant Earrings' yazdığını doğrular");

            Assert.assertTrue(adminPage.merchantEarringTotalHeadings.get(0).isDisplayed());
            extentTest.pass("Total Commission kutucuğunu varlığını doğrular");
            Assert.assertTrue(adminPage.merchantEarringTotalHeadings.get(0).getText().contains("Total Commission"));
            extentTest.pass("Total Commission kutucuğunda 'Total Commission' yazdığını doğrular");
            Assert.assertTrue(adminPage.merchantEarringTotalHeadings.get(0).getText().contains("$"));
            extentTest.pass("Total Commission kutucuğunda '$' yazdığını doğrular");

            Assert.assertTrue(adminPage.merchantEarringTotalHeadings.get(1).isDisplayed());
            extentTest.pass("Total Balance kutucuğunu varlığını doğrular");
            Assert.assertTrue(adminPage.merchantEarringTotalHeadings.get(1).getText().contains("Total Balance"));
            extentTest.pass("Total Balance kutucuğunda 'Total Balance' yazdığını doğrular");
            Assert.assertTrue(adminPage.merchantEarringTotalHeadings.get(1).getText().contains("$"));
            extentTest.pass("Total Balance kutucuğunda '$' yazdığını doğrular");
            


            for (int i = 0; i < adminPage.merchantEarringTotalHeadings.size(); i++) {
                Assert.assertTrue(adminPage.merchantEarringTotalHeadings.get(i).isDisplayed());
                Assert.assertTrue(adminPage.merchantEarringTotalHeadings.get(i).getText().contains("Total Commission") ||
                        adminPage.merchantEarringTotalHeadings.get(i).getText().contains("Total Balance"));
                Assert.assertTrue(adminPage.merchantEarringTotalHeadings.get(i).getText().contains("$"));
            }
       
            Driver.quitDriver();
            extentTest.info("Sayfayi kapatir");

    }

    @Test
    public void TC_3903() {
        adminPage = new AdminPage();
        actions = new Actions(Driver.getDriver());
        ReusableMethods.accessAdmin("adminuser_hasan", "adminpassword_hasan");
        actions.click(adminPage.adminDashboardEarningsButton).moveToElement(adminPage.adminDashboardMerchantEarningsButton).click().perform();

        Assert.assertTrue(adminPage.merchantEarringMerchantTitle.isDisplayed());
        Assert.assertTrue(adminPage.merchantEarringBalanceTitle.isDisplayed());
        Assert.assertTrue(adminPage.merchantEarringActionTitle.isDisplayed());

        Driver.quitDriver();

        ReusableMethods.wait(1);
    }

    @Test
    public void TC_3904() throws IOException {

            adminPage = new AdminPage();
            actions = new Actions(Driver.getDriver());
            ReusableMethods.accessAdmin("adminuser_hasan", "adminpassword_hasan");
            extentTest.info("Kullanici browser'ı açar geçerli üyelikle giriş yapar");

            actions.click(adminPage.adminDashboardEarningsButton).moveToElement(adminPage.adminDashboardMerchantEarningsButton).click().perform();
            extentTest.info("Ekranın solundaki menüden Earrings'e tıklar ve Merchant Earrings' tıklar");

            JSUtilities.sayfaOlcegiDegistirme(Driver.getDriver(), 75);
            extentTest.info("Sayfa ölçeğini %75'e düşürür");

            JSUtilities.clickWithJS(Driver.getDriver(), adminPage.merchantEarringMerchantTitle);
            extentTest.info("Merchant başlığına basarak sıralar");
            ReusableMethods.wait(1);

            List<String> totalMerchantNames = new ArrayList<>();

            for (int page = 1; page <= adminPage.merchantEarringsSayfaNo.size()-1; page++) {
                ReusableMethods.wait(1);
                // Restoranların isimlerini alın
                List<WebElement> nameElements = adminPage.merchantEarringMerchantList;
                for (WebElement nameElement : nameElements) {
                    totalMerchantNames.add(nameElement.getText().toLowerCase().trim().replaceAll(" ",""));
                }

                if (page < adminPage.merchantEarringsSayfaNo.size()-1) {
                    WebElement nextPageButton = Driver.getDriver().findElement(By.xpath("//*[@data-dt-idx='4']")); // AdminPage sınıfında nextPageButton öğesini tanımladığınızdan emin olun
                    JSUtilities.clickWithJS(Driver.getDriver(), nextPageButton);
                    ReusableMethods.wait(1);
                }
            }
            extentTest.info("Sayfaları tek tek gezerek sıralama işlemine devame eder");

            // Sıralamayı kontrol et (alfabetik sırayla)
            boolean isSortedMerchant = true;
            for (int i = 1; i < totalMerchantNames.size(); i++) {
                if (totalMerchantNames.get(i).compareTo(totalMerchantNames.get(i - 1)) < 0) {
                    isSortedMerchant = false;
                    break;
                }
            }

            Assert.assertTrue(isSortedMerchant);
            extentTest.pass("Restaurant isimlerini alfabetik sıraya göre olup olmadığını kontrol eder");


            // "Balance" butonuna tıklayın
            JSUtilities.clickWithJS(Driver.getDriver(), adminPage.merchantEarringBalanceTitle);
            extentTest.info("Balance başlığına basarak sıralar");
            ReusableMethods.wait(3);

            List<Double> totalBalances = new ArrayList<>();

            for (int page = 1; page <= adminPage.merchantEarringsSayfaNo.size()-1; page++) {

                ReusableMethods.wait(1);
                // Restoranların bakiyelerini alın
                List<WebElement> balanceElements = adminPage.merchantEarringBalanceList;
                for (WebElement balanceElement : balanceElements) {
                    String balanceText = balanceElement.getText().replace("$", "").replace(".", "").replace(".", "");
                    totalBalances.add(Double.parseDouble(balanceText));
                }

                if (page < adminPage.merchantEarringsSayfaNo.size()-1) {
                    WebElement nextPageButton = Driver.getDriver().findElement(By.xpath("//*[@data-dt-idx='4']")); // next butonu
                    JSUtilities.clickWithJS(Driver.getDriver(), nextPageButton);
                    ReusableMethods.wait(1);
                }
            }
            extentTest.info("Sayfaları tek tek gezerek sıralama işlemine devame eder");

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
            extentTest.pass("Balance'ların doğru bir şekilde sıralanıp sıralanmadığını kontrol eder");

            Driver.quitDriver();
            extentTest.info("Sayfayi kapatir");



    }

    @Test
    public void TC_3905() {
        adminPage = new AdminPage();
        actions = new Actions(Driver.getDriver());
        ReusableMethods.accessAdmin("adminuser_hasan", "adminpassword_hasan");
        actions.click(adminPage.adminDashboardEarningsButton).moveToElement(adminPage.adminDashboardMerchantEarningsButton).click().perform();

        JSUtilities.clickWithJS(Driver.getDriver(),adminPage.createTransactionButton);
        JSUtilities.clickWithJS(Driver.getDriver(),adminPage.adjustmentButton);

        String expectedTitle = "Create adjustment";
        String actualTitle = Driver.getDriver().findElement(By.xpath("//form//h5[@id='exampleModalLabel']")).getText();
        Assert.assertEquals(actualTitle,expectedTitle);

        String expectedMerchantTitle = "Merchant";
        String actualMerchantTitle = Driver.getDriver().findElement(By.xpath("//b[normalize-space()='Merchant']")).getText();
        Assert.assertEquals(actualMerchantTitle,expectedMerchantTitle);

        // rastgele bir merchant seçme
        actions.moveToElement(adminPage.merchantFinder).click().perform();
        ReusableMethods.wait(1);
        Random rand = new Random();
        int randomIndex = rand.nextInt(adminPage.merchantList.size());
        WebElement randomElement = adminPage.merchantList.get(randomIndex);
        actions.moveToElement(randomElement).click().perform();
        ReusableMethods.wait(1);


        Assert.assertTrue(adminPage.transactionDescriptionText.getText().contains("Transaction Description"));
        Faker faker = new Faker();
        actions.click(adminPage.transactionDescriptionBox).sendKeys(faker.lorem().sentence()).perform();
        ReusableMethods.wait(3);

        Select select = new Select(adminPage.payType);
        List<WebElement> options = select.getOptions();
        int randomIndex2 = rand.nextInt(options.size());
        select.selectByIndex(randomIndex2);
        ReusableMethods.wait(3);

        Assert.assertTrue(adminPage.amountText.getText().contains("Amount"));
        int randomPrice = rand.nextInt(100);
        actions.click(adminPage.amountBox).sendKeys(String.valueOf(randomPrice)).perform();
        JSUtilities.clickWithJS(Driver.getDriver(),adminPage.submitButton);
        ReusableMethods.wait(2);

        Assert.assertTrue(adminPage.notfyMessage.isDisplayed());
        ReusableMethods.wait(1);

        Driver.quitDriver();

    }

    @Test
    public void TC_3906() {
        adminPage = new AdminPage();
        actions = new Actions(Driver.getDriver());
        ReusableMethods.accessAdmin("adminuser_hasan", "adminpassword_hasan");
        actions.click(adminPage.adminDashboardEarningsButton).moveToElement(adminPage.adminDashboardMerchantEarningsButton).click().perform();

        Assert.assertTrue(adminPage.firstActionButton.isDisplayed());
        Assert.assertTrue(adminPage.firstActionButton.isEnabled());

        JSUtilities.clickWithJS(Driver.getDriver(),adminPage.firstActionButton);
        ReusableMethods.wait(1);
        String expectedMerchantName = adminPage.firstMerchantName.getText();
        String actualMerchantName = Driver.getDriver().findElement(By.id("exampleModalLabel")).getText();
        Assert.assertEquals(actualMerchantName,expectedMerchantName);

        Driver.quitDriver();
    }

    @Test
    public void TC_3907() {
        adminPage = new AdminPage();
        actions = new Actions(Driver.getDriver());
        ReusableMethods.accessAdmin("adminuser_hasan", "adminpassword_hasan");
        actions.click(adminPage.adminDashboardEarningsButton).moveToElement(adminPage.adminDashboardMerchantEarningsButton).click().perform();

        JSUtilities.clickWithJS(Driver.getDriver(),adminPage.firstActionButton);
        ReusableMethods.wait(1);

        for (int i = 0; i < adminPage.customerPageAltBasliklar.size(); i++) {
            Assert.assertTrue(adminPage.customerPageAltBasliklar.get(i).isDisplayed());
        }

        Assert.assertTrue(adminPage.customerPageAltBasliklar.get(0).getText().contains("Orders"));

        Assert.assertTrue(adminPage.customerPageAltBasliklar.get(1).getText().contains("Cancel"));

        Assert.assertTrue(adminPage.customerPageAltBasliklar.get(2).getText().contains("Refund"));
        Assert.assertTrue(adminPage.customerPageAltBasliklar.get(2).getText().contains("$"));

        Assert.assertTrue(adminPage.customerPageAltBasliklar.get(3).getText().contains("Total"));
        Assert.assertTrue(adminPage.customerPageAltBasliklar.get(3).getText().contains("$"));

        Assert.assertTrue(adminPage.merchantInfoText.isDisplayed());
        Assert.assertTrue(adminPage.merchantInfoText.getText().contains("Merchant Info"));
        Assert.assertTrue(adminPage.merchantPicture.isDisplayed());
        Assert.assertTrue(adminPage.merchantInfoText.getText().contains("Name"));
        Assert.assertTrue(adminPage.merchantInfoText.getText().contains("Contact"));
        Assert.assertTrue(adminPage.merchantInfoText.getText().contains("Email"));
        Assert.assertTrue(adminPage.merchantInfoText.getText().contains("@"));
        Assert.assertTrue(adminPage.merchantInfoText.getText().contains("Member since"));
        Assert.assertTrue(adminPage.merchantInfoText.getText().contains("Membership History"));

        String expectedMerchantName = adminPage.merchantPageName.getText();
        String actualMerchantName = Driver.getDriver().findElement(By.xpath("(//*[@class='col-sm-7 text-secondary'])[1]")).getText();
        Assert.assertEquals(actualMerchantName,expectedMerchantName);


        Driver.quitDriver();


    }

    @Test
    public void TC_3908(){
        adminPage = new AdminPage();
        actions = new Actions(Driver.getDriver());
        ReusableMethods.accessAdmin("adminuser_hasan", "adminpassword_hasan");
        actions.click(adminPage.adminDashboardEarningsButton).moveToElement(adminPage.adminDashboardMerchantEarningsButton).click().perform();



        actions.moveToElement(adminPage.merchantEarringPageSearchBox).click().perform();
        adminPage.merchantEarringPageSearchBox.sendKeys("Team2" + Keys.ENTER);
        ReusableMethods.wait(1);

        JSUtilities.clickWithJS(Driver.getDriver(),adminPage.firstActionButton);
        ReusableMethods.wait(1);

        adminPage.dateRangeBox.click();
        ReusableMethods.wait(1);

        Assert.assertTrue(adminPage.dateRangeKey.get(0).getText().contains("Today"));
        Assert.assertTrue(adminPage.dateRangeKey.get(1).getText().contains("Yesterday"));
        Assert.assertTrue(adminPage.dateRangeKey.get(2).getText().contains("Last 7 Days"));
        Assert.assertTrue(adminPage.dateRangeKey.get(3).getText().contains("Last 30 Days"));
        Assert.assertTrue(adminPage.dateRangeKey.get(4).getText().contains("This Month"));
        Assert.assertTrue(adminPage.dateRangeKey.get(5).getText().contains("Last Month"));


        ReusableMethods.searchDateBeginFinish("31","May","2024","31","September","2024");
        ReusableMethods.wait(3);

        for (int i = 0; i < adminPage.merchantInfoTable.size(); i++) {
            Assert.assertTrue(adminPage.merchantInfoTable.get(i).isDisplayed());
        }
        Assert.assertTrue(adminPage.merchantInfoTable.get(0).getText().contains("Date"));
        Assert.assertTrue(adminPage.merchantInfoTable.get(1).getText().contains("Transaction"));
        Assert.assertTrue(adminPage.merchantInfoTable.get(2).getText().contains("Debit/Credit"));
        Assert.assertTrue(adminPage.merchantInfoTable.get(3).getText().contains("Running Balance"));

        ReusableMethods.wait(1);

        adminPage.allTransactionFilter.click();
        ReusableMethods.wait(1);

        for (int i = 0; i < adminPage.allTransaction.size(); i++) {
            Assert.assertTrue(adminPage.allTransaction.get(i).isEnabled());
        }

        Assert.assertTrue(adminPage.allTransaction.get(0).getText().contains("Credit"));
        Assert.assertTrue(adminPage.allTransaction.get(1).getText().contains("Debit"));
        Assert.assertTrue(adminPage.allTransaction.get(2).getText().contains("Payout"));
        Assert.assertTrue(adminPage.allTransaction.get(3).getText().contains("Cash In"));

        ReusableMethods.wait(1);
        adminPage.allTransaction.get(3).click();
        adminPage.allTransactionFilter.click();
        ReusableMethods.wait(1);

        for (int i = 0; i < adminPage.customRangeProductList.size(); i++) {
            Assert.assertTrue(adminPage.customRangeProductList.get(i).getText().contains("24 Jun 2024") );
        }


        String text = Driver.getDriver().findElement(By.xpath("//*[text()='Showing 1 to 2 of 2 entries']")).getText();
        String[] parts = text.split("Showing 1 to 2 of ");
        String entriesResult = parts[1];
        entriesResult = entriesResult.replace(" entries", "");

        Assert.assertEquals(adminPage.customRangeProductList.size(), Integer.parseInt(entriesResult));

        ReusableMethods.wait(1);


        Driver.quitDriver();
    }

    @Test
    public void TC_3909(){
        adminPage = new AdminPage();
        actions = new Actions(Driver.getDriver());
        ReusableMethods.accessAdmin("adminuser_hasan", "adminpassword_hasan");
        actions.click(adminPage.adminDashboardEarningsButton).moveToElement(adminPage.adminDashboardMerchantEarningsButton).click().perform();

        actions.moveToElement(adminPage.merchantEarringPageSearchBox).click().perform();
        adminPage.merchantEarringPageSearchBox.sendKeys("Team2" + Keys.ENTER);
        ReusableMethods.wait(1);

        JSUtilities.clickWithJS(Driver.getDriver(),adminPage.firstActionButton);
        ReusableMethods.wait(3);


        adminPage.deactiveMerchantButton.click();
        ReusableMethods.wait(1);


        String expectedInfo = "You are about to deactivate this merchant, click confirm to continue?";
        String actualInfo = adminPage.deactiveInformation.getText();
        Assert.assertTrue(actualInfo.contains(expectedInfo));
        adminPage.confirmButton.click();
        ReusableMethods.wait(2);

        Assert.assertTrue(adminPage.activateMerchantButton.isEnabled());
        adminPage.activateMerchantButton.click();
        ReusableMethods.wait(2);
        Assert.assertTrue(adminPage.deactiveMerchantButton.isEnabled());



        Driver.quitDriver();

    }




























}



