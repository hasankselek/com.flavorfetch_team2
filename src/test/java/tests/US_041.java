package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import pages.AdminPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import java.util.ArrayList;
import java.util.List;

public class US_041 {
    AdminPage adminPage = new AdminPage();

    @Test
    public void TC_4101() {
        adminPage = new AdminPage();
        ReusableMethods.accessAdmin("adminuser_meltem", "adminpassword_meltem");
        //Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        // adminPage.userNameButton.sendKeys(ConfigReader.getProperty("adminuser_meltem"));
        //Driver.getDriver().findElement(By.xpath("//*[@for='LoginForm_password']")).sendKeys("Flavor.2106");
        //adminPage.passwordButton.sendKeys(ConfigReader.getProperty("adminpassword_meltem"));
        // adminPage.signInButton.click();
        adminPage.buyersButton.click();
        Assert.assertTrue(adminPage.customersButton.isDisplayed());
        Assert.assertTrue(adminPage.reviewsButton.isDisplayed());
        adminPage.customersButton.click();

        ReusableMethods.wait(5);
        Assert.assertTrue(adminPage.iconvisible.isDisplayed());
        adminPage.nameSortingButton.click();


        List<WebElement> sortedCustomer = new ArrayList<>();
        // for döngusu yazilacaktir
        for (int page = 1; page <= 3; page++) {
            ReusableMethods.wait(1);
            // Customer isimleri alinir
            // List<String> CustomerList = ReusableMethods.stringListesineDonustur(sortingCustomerName);
            List<WebElement> sortingCustomerName = Driver.getDriver().findElements(By.xpath("//tbody//tr//td//h6"));
            for (WebElement each : sortingCustomerName) {
                // sortedCustomer.add(sortingCustomerName.getText().toLowerCase().trim());
            }

        }
    }
        @Test
        public void TC_4102 () {
            adminPage = new AdminPage();
            adminPage.addNewCustomerButton.click();
            adminPage.firstNamebutton.sendKeys("Ayse");
            Faker faker = new Faker();
            Actions actions = new Actions(Driver.getDriver());
            actions.click(adminPage.firstNamebutton)
                    .sendKeys(faker.name().firstName()).perform();

            actions.click((adminPage.lastNamebutton))
                    .sendKeys(faker.name().lastName()).perform();

            actions.click(adminPage.emailNameButton)
                    .sendKeys(faker.internet().emailAddress()).perform();

            // actions.click(adminPage.contactPhone).sendKeys((CharSequence) faker.phoneNumber()).perform();
            actions.click(adminPage.contactPhone).sendKeys(faker.phoneNumber().phoneNumber()).perform();
            String fakePassword = faker.internet().password();
            actions.click(adminPage.passwordButton).sendKeys(fakePassword).perform();
            actions.click(adminPage.confirmPasswordButton).sendKeys(fakePassword).perform();

            adminPage.browseButton.click();
            adminPage.uploadNewButton.click();


            String yuklenecekDosyaninDosyaYolu = "C:\\Users\\Meltem\\IdeaProjects\\com.flavorfetch_team2\\src\\test\\java\\tests\\upload.png";
            adminPage.selectFilesButton.sendKeys(yuklenecekDosyaninDosyaYolu);

            adminPage.addFilesButton.click();

            adminPage.addMoreFileButton.click();

            adminPage.selectFilesButton.sendKeys(yuklenecekDosyaninDosyaYolu);

            adminPage.addFilesButton.click();

            adminPage.closeProfileWindow.click();

            adminPage.statusCustomer.click();

            // status barinda dropdown secilmesi yazilacaktir

            Driver.getDriver().quit();

        }

        @Test
        public void TC_4103 () {
            adminPage = new AdminPage();
            ReusableMethods.accessAdmin("adminuser_meltem", "adminpassword_meltem");
            adminPage.buyersButton.click();
            adminPage.customersButton.click();
            String name = adminPage.searchedName.getText();
            adminPage.nameSearchButton.sendKeys(name);
            Assert.assertFalse(adminPage.assertSearchedPage.isDisplayed());
            Driver.getDriver().quit();
        }

        @Test
        public void TC_4104 () {
            adminPage = new AdminPage();
            ReusableMethods.accessAdmin("adminuser_meltem", "adminpassword_meltem");
            adminPage.buyersButton.click();
            Assert.assertTrue(adminPage.customersButton.isDisplayed());
            Assert.assertTrue(adminPage.reviewsButton.isDisplayed());
            adminPage.customersButton.click();
            Assert.assertTrue(adminPage.iconvisible.isDisplayed());
            Driver.getDriver().quit();
        }

    }

