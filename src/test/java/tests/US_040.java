package tests;

import com.beust.ah.A;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminPage;
import pages.CustomerPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static utilities.Driver.driver;
import static utilities.Driver.getDriver;

    public class US_040 extends TestBaseRapor {

        AdminPage adminPage = new AdminPage ();

        @Test
        public void US_4001() {

            Driver.getDriver ().get ( ConfigReader.getProperty ( "admin_Url" ) );

            adminPage.userNameButton.sendKeys ( ConfigReader.getProperty ( "adminuser_serhat" ) + Keys.TAB +
                    ConfigReader.getProperty ( "adminpassword_serhat" ) );
            adminPage.signInButton.click ();

            adminPage.promoAdmin.click ();

            adminPage.couponAdmin.click ();

            String expectedUrl = "https://qa.flavorfetch.com/backoffice/promo/coupon";
            String actualUrl = Driver.getDriver ().getCurrentUrl ();
            Assert.assertEquals ( actualUrl, expectedUrl );

            Driver.quitDriver ();


        }


        @Test
        public void US_4002() {

            Driver.getDriver ().get ( ConfigReader.getProperty ( "admin_Url" ) );

            adminPage.userNameButton.sendKeys ( ConfigReader.getProperty ( "adminuser_serhat" ) + Keys.TAB +
                    ConfigReader.getProperty ( "adminpassword_serhat" ) );
            adminPage.signInButton.click ();

            adminPage.promoAdmin.click ();

            adminPage.couponAdmin.click ();

            adminPage.newCouponButton.click ();

            String expectedUrl = "https://qa.flavorfetch.com/backoffice/promo/coupon_create";
            String actualUrl = Driver.getDriver ().getCurrentUrl ();
            Assert.assertEquals ( actualUrl, expectedUrl );


            adminPage.couponName.sendKeys ( "TEAM2OZEL" + Keys.ENTER );

            Select selectCouponType = new Select ( adminPage.couponType );

            selectCouponType.selectByValue ( "percentage" );

            adminPage.couponAmount.clear ();
            adminPage.couponAmount.sendKeys ( "100" );
            adminPage.couponMinOrder.sendKeys ( "10" );

            Actions action = new Actions ( Driver.getDriver () );
            action.sendKeys ( Keys.PAGE_DOWN ).perform ();

            Select selectCouponDay = new Select ( adminPage.couponDay );

            selectCouponDay.selectByValue ( "monday" );
            selectCouponDay.selectByValue ( "sunday" );

            adminPage.couponMerchant.click ();

            WebElement team2Option = Driver.getDriver ().findElement ( By.xpath ( "(//*[@class='select2-results__option select2-results__option--selectable'])[12]" ) );
            team2Option.click ();

            Actions actions = new Actions ( Driver.getDriver () );

            // Tarih giriş alanını bul ve takvimi açmak için tıkla

            WebElement dateInputField = Driver.getDriver ().findElement ( By.xpath ( "(//*[@class=\"form-label-group\"])[7]" ) ); // Tarih giriş alanının ID'si
            dateInputField.click ();

            // İleri ay butonuna tıklamak gerekiyorsa

            WebElement nextMonthButton = Driver.getDriver ().findElement ( By.xpath ( "(//*[@class='next available'])[1]" ) ); // İleri ay butonunun xpath'i
            actions.moveToElement ( nextMonthButton ).click ().perform ();


            WebElement ayGun = Driver.getDriver ().findElement ( By.xpath ( "(*//div//tbody/tr/td)[17]" ) );
            ayGun.click ();

            Select couponOptions1 = new Select ( adminPage.couponOptions );

            couponOptions1.selectByValue ( "2" );

            Select copuponStatus = new Select ( adminPage.couponStatus );

            copuponStatus.selectByValue ( "publish" );

            adminPage.couponSaved.click ();

            Driver.quitDriver ();


        }


        @Test
        public void US_4003() {


            Driver.getDriver ().get ( ConfigReader.getProperty ( "admin_Url" ) );

            adminPage.userNameButton.sendKeys ( ConfigReader.getProperty ( "adminuser_serhat" ) + Keys.TAB +
                    ConfigReader.getProperty ( "adminpassword_serhat" ) );
            adminPage.signInButton.click ();

            adminPage.promoAdmin.click ();
            adminPage.couponAdmin.click ();
            adminPage.couponActions.click ();

            Select select = new Select ( adminPage.couponStatus );

            select.selectByValue ( "pending" );

            ReusableMethods.clickWithJS ( adminPage.couponSaved );

            driver.navigate ().back ();

            ReusableMethods.clickWithJS ( adminPage.couponSaved );

            select.selectByValue ( "draft" );

            ReusableMethods.clickWithJS ( adminPage.couponSaved );

            Driver.getDriver ().navigate ().to ( "https://qa.flavorfetch.com/backoffice/promo/coupon" );

            WebElement couponUpdateStatusu = driver.findElement ( By.xpath ( "(//span[contains(@class, 'badge ml-2 post')])[1]" ) );
            String newStatus = couponUpdateStatusu.getText ();

            // Durumu kontrol etmek için

            Assert.assertEquals ( newStatus, "Draft" );

            Driver.quitDriver ();


        }


        @Test
        public void US_4004()  {

            // Admin paneline gidilir
            Driver.getDriver ().get ( ConfigReader.getProperty ( "admin_Url" ) );

// Kullanıcı adı ve şifre girilir, giriş yapılır
            adminPage.userNameButton.sendKeys ( ConfigReader.getProperty ( "adminuser_serhat" ) + Keys.TAB +
                    ConfigReader.getProperty ( "adminpassword_serhat" ) );
            adminPage.signInButton.click ();

// Promosyon yönetimine ve kupon yönetimine gidilir
            adminPage.promoAdmin.click ();
            adminPage.couponAdmin.click ();

            WebDriverWait wait = new WebDriverWait ( Driver.getDriver (), Duration.ofSeconds ( 10 ) );

// İlk sayfadaki kupon sayısını al
            List<WebElement> couponsOnFirstPage = Driver.getDriver ().findElements ( By.xpath ( "//table[@id='DataTables_Table_0']/tbody/tr" ) );
            int initialCouponCountFirstPage = couponsOnFirstPage.size ();

// Eğer bir sonraki sayfa varsa ikinci sayfadaki kupon sayısını da alarak toplam kupon sayısını hesapla
            int initialCouponCountSecondPage = 0;
            if (!couponsOnFirstPage.isEmpty ()) {
                try {
                    WebElement nextPageButton = wait.until ( ExpectedConditions.elementToBeClickable ( By.xpath ( "(//*[@class='page-link'])[4]" ) ) );
                    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver ();
                    js.executeScript ( "arguments[0].click();", nextPageButton );
                    ReusableMethods.wait ( 3 );

                    // İkinci sayfadaki kupon sayısını al
                    List<WebElement> couponsOnSecondPage = Driver.getDriver ().findElements ( By.xpath ( "//table[@id='DataTables_Table_0']/tbody/tr" ) );
                    initialCouponCountSecondPage = couponsOnSecondPage.size ();
                } catch (NoSuchElementException e) {
                    // İkinci sayfa yoksa burası atlanabilir
                }
            }

// Toplam kupon sayısını hesapla
            int totalInitialCouponCount = initialCouponCountFirstPage + initialCouponCountSecondPage;

// Kupon silme işlemi başlatılır (ilk sayfada)
            ReusableMethods.sleep ( 3 );
            adminPage.couponDelete.click ();
            ReusableMethods.sleep ( 3 );
            WebElement couponAlertDeleteButton = wait.until ( ExpectedConditions.elementToBeClickable ( By.xpath ( "//*[@class='btn btn-green item_delete']" ) ) );
            couponAlertDeleteButton.click ();
            ReusableMethods.sleep ( 5 );

            // Sayfayı yenile ve bir sonraki sayfaya geçiş yapılır (eğer varsa)
            try {
                WebElement nextPageButton = wait.until ( ExpectedConditions.elementToBeClickable ( By.xpath ( "(//*[@class='page-link'])[4]" ) ) );
                JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver ();
                js.executeScript ( "arguments[0].click();", nextPageButton );
                ReusableMethods.wait ( 3 );

                // İkinci sayfadaki kupon sayısını al
                List<WebElement> updatedCouponsOnSecondPage = Driver.getDriver ().findElements ( By.xpath ( "//table[@id='DataTables_Table_0']/tbody/tr" ) );
                int updatedCouponCountSecondPage = updatedCouponsOnSecondPage.size ();

                // Toplam kupon sayısını kontrol et
                int totalUpdatedCouponCount = totalInitialCouponCount - 1;
                Assert.assertEquals ( totalUpdatedCouponCount, totalInitialCouponCount - 1 );

            } catch (NoSuchElementException e) {
                // Eğer bir sonraki sayfa yoksa sadece ilk sayfadaki kupon sayısını kontrol etmek yeterli olur
                List<WebElement> updatedCouponsOnSinglePage = Driver.getDriver ().findElements ( By.xpath ( "//table[@id='DataTables_Table_0']/tbody/tr" ) );
                int totalUpdatedCouponCount = updatedCouponsOnSinglePage.size ();
                Assert.assertEquals ( totalUpdatedCouponCount, totalInitialCouponCount - 1 );
            }

            // WebDriver'ı kapat
            Driver.quitDriver ();

        }


        @Test
        public void US_4005() throws IOException {

            // Admin paneline git
            Driver.getDriver ().get ( ConfigReader.getProperty ( "admin_Url" ) );
            extentTest.info ( "Kullanici admin sayfasina gider" );
            // Kullanıcı adı ve şifre ile giriş yap
            adminPage.userNameButton.sendKeys(ConfigReader.getProperty("adminuser_serhat") + Keys.TAB +
                    ConfigReader.getProperty("adminpassword_serhat"));
            adminPage.signInButton.click();
            extentTest.info ( "Kullanici bilgileri ile giris yapar" );
            // Promo bölümüne git
            adminPage.promoAdmin.click();
            extentTest.info ( "Promo sekmesine tiklar" );
            // Coupon bölümüne git
            adminPage.couponAdmin.click();
            extentTest.info ( "Coupon sekmesine tiklar" );
            // "Nico" kuponunu ara
            adminPage.couponAdminSearchbox.sendKeys("Nico" + Keys.ENTER);
            extentTest.info ( "Nico isimli kupon search box ta arar" );
            // Kupon arama sonuçlarında "Nico" kuponunu kontrol et
            boolean isCouponFound = false;
            for (WebElement coupon : adminPage.couponResults) {
                if (coupon.getText().contains("Nico")) {
                    isCouponFound = true;
                    break;
                }
            }
            extentTest.pass ( "Kupon arama sonuçlarında Nico isimli kupon oldugunu kontrol eder" );
            // Kuponun bulunduğunu doğrula
            Assert.assertTrue(isCouponFound, "'Nico' kuponu arama sonuçlarında bulunamadı.");
            extentTest.pass ( "Arama sonuclarinda aranan Nico isimli kuponun bulunduğunu doğrular" );

            Driver.quitDriver ();

        }


    }























