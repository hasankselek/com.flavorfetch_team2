package tests;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminPage;
import pages.CustomerPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

import static utilities.Driver.driver;
import static utilities.Driver.getDriver;

    public class US_040 {

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


            adminPage.couponName.sendKeys ( "Team2OZEL" + Keys.ENTER );

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

            Select couponOptions1 = new Select (adminPage.couponOptions);

            couponOptions1.selectByValue ( "2" );

            Select copuponStatus = new Select ( adminPage.copuponStatus );

            copuponStatus.selectByValue ( "publish" );

            adminPage.couponSaved.click ();




        }


        @Test
        public void US_4003() {
















        }


        @Test
        public void US_4004() {

        }


        @Test
        public void US_4005() {

        }


    }





