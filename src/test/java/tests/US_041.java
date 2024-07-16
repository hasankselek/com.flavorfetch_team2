package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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
               // sortedCustomer.add(sortingCustomerName.get(each).getText().toLowerCase().trim());
            }

        }
    }
        @Test
        public void TC_4102 () {
            ReusableMethods.addCustomer("C:\\Users\\Meltem\\IdeaProjects\\com.flavorfetch_team2\\src\\test\\java\\tests\\upload.png");
            ReusableMethods.wait(3);

            // eklenen customer silinir
             adminPage.deleteCustomerButton.click();
             ReusableMethods.wait(3);
             // çıkan popup delete butonuna tıklanır
             adminPage.cDeleteButton.click();

             ReusableMethods.wait(3);
             //customer düzenlenir
             adminPage.updateButton.click();
             ReusableMethods.addCustomer("C:\\Users\\Meltem\\IdeaProjects\\com.flavorfetch_team2\\src\\test\\java\\tests\\upload.png");

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

