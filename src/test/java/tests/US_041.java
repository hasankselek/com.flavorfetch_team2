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
import utilities.JSUtilities;
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
        //Assert.assertTrue(adminPage.reviewsButton.isDisplayed());
        adminPage.customersButton.click();
        //ReusableMethods.wait(5);

        adminPage.buyersButton.click();
        ReusableMethods.wait(2);
        Assert.assertTrue(adminPage.iconvisible.isDisplayed());
        ReusableMethods.wait(2);

        adminPage.nameSortingButton.click();
        JSUtilities.sayfaOlcegiDegistirme(Driver.getDriver(),30);

        ReusableMethods.wait(1);

        List<String> sortedCustomer = new ArrayList<>();
        // for döngusu yazilacaktir
        for (int page = 1; page <= 10; page++) {
            ReusableMethods.wait(1);
            // Customer isimleri alinir
            // List<String> CustomerList = ReusableMethods.stringListesineDonustur(sortingCustomerName);
            List<WebElement> sortingCustomerNames = Driver.getDriver().findElements(By.xpath("//tbody//tr//td//h6"));
            for (WebElement sortingCustomerName : sortingCustomerNames) {
                sortedCustomer.add(sortingCustomerName.getText().toLowerCase().trim());
            }
           if (page<10){
               WebElement nextPageButton = Driver.getDriver().findElement(By.xpath("//*[@class='page-link']")); // AdminPage sınıfında nextPageButton öğesini tanımladığınızdan emin olun
               JSUtilities.clickWithJS(Driver.getDriver(), nextPageButton);
               ReusableMethods.wait(1);
           }
            // Alfabetik Sıralamayı kontrol et (alfabetik sırayla)
            boolean issortedCustomer = true;
            for (int i = 1; i < sortedCustomer.size(); i++) {
                if (sortedCustomer.get(i).compareTo(sortedCustomer.get(i - 1)) < 0) {
                    issortedCustomer = false;
                    break;
                }

        }
            Assert.assertTrue(issortedCustomer);

            List<WebElement> sortingCustomerName = Driver.getDriver().findElements(By.xpath("//tbody//tr//td//h6"));
            for (WebElement each : sortingCustomerName) {
                // sortedCustomer.add(sortingCustomerName.get(each).getText().toLowerCase().trim());
            }

        }
        }
        @Test
        public void TC_4102 () {
            adminPage = new AdminPage();
            ReusableMethods.accessAdmin("adminuser_meltem", "adminpassword_meltem");
            adminPage.buyersButton.click();
            adminPage.customersButton.click();

            ReusableMethods.wait(3);
            Faker faker = new Faker();
            Actions actions = new Actions(Driver.getDriver());
            adminPage.addNewCustomerButton.click();

            actions.click(adminPage.firstNamebutton)
                    .sendKeys(faker.name().firstName()).perform();

            actions.click((adminPage.lastNamebutton))
                    .sendKeys(faker.name().lastName()).perform();

            actions.click(adminPage.emailNameButton)
                    .sendKeys(faker.internet().emailAddress()).perform();

            // actions.click(adminPage.contactPhone).sendKeys((CharSequence) faker.phoneNumber()).perform();
            actions.click(adminPage.contactPhone).sendKeys(faker.phoneNumber().phoneNumber()).perform();

            String fakePassword = faker.internet().password();

            actions.click(adminPage.buyersPassword).sendKeys(fakePassword).perform();
            actions.click(adminPage.confirmPasswordButton).sendKeys(fakePassword).perform();


            adminPage.browseButton.click();
            ReusableMethods.wait(3);
            adminPage.uploadNewButton.click();
            ReusableMethods.wait(2);
            adminPage.selectFilesButton.click();

            String yuklenecekDosyaninDosyaYolu = "C:\\Users\\Meltem\\IdeaProjects\\com.flavorfetch_team2\\src\\test\\java\\tests\\upload.png";
            adminPage.selectFilesButton.sendKeys(yuklenecekDosyaninDosyaYolu);

            adminPage.addFilesButton.click();

            adminPage.addMoreFileButton.click();

            adminPage.selectFilesButton.sendKeys(yuklenecekDosyaninDosyaYolu);

            adminPage.addFilesButton.click();

            adminPage.closeProfileWindow.click();

            adminPage.statusCustomer.click();

            // status barinda dropdown secilmesi yazilacaktir
            //dropdown olmasi icin select tagıyla olusmasi lazim, altindaki seceneklerde option tagiyla olusturulmasi lazim.
            // statu active secilir
            Select select = new Select(adminPage.statusDropdownMenu);
            select.selectByVisibleText("active");
            adminPage.saveCustomerButton.click();


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
            actions.click(adminPage.firstNamebutton)
                    .sendKeys(faker.name().firstName()).perform();

            actions.click((adminPage.lastNamebutton))
                    .sendKeys(faker.name().lastName()).perform();

            actions.click(adminPage.emailNameButton)
                    .sendKeys(faker.internet().emailAddress()).perform();

            // actions.click(adminPage.contactPhone).sendKeys((CharSequence) faker.phoneNumber()).perform();
            actions.click(adminPage.contactPhone).sendKeys(faker.phoneNumber().phoneNumber()).perform();

            String fake2Password = faker.internet().password();

            actions.click(adminPage.buyersPassword).sendKeys(fakePassword).perform();
            actions.click(adminPage.confirmPasswordButton).sendKeys(fakePassword).perform();


            adminPage.browseButton.click();
            ReusableMethods.wait(3);
            adminPage.uploadNewButton.click();


            String yuklenecekDosyaninDosyaYolu2 = "C:\\Users\\Meltem\\IdeaProjects\\com.flavorfetch_team2\\src\\test\\java\\tests\\upload.png";
            adminPage.selectFilesButton.sendKeys(yuklenecekDosyaninDosyaYolu);

            adminPage.addFilesButton.click();

            adminPage.addMoreFileButton.click();

            adminPage.selectFilesButton.sendKeys(yuklenecekDosyaninDosyaYolu);

            adminPage.addFilesButton.click();

            adminPage.closeProfileWindow.click();

            adminPage.statusCustomer.click();

            // status barinda dropdown secilmesi yazilacaktir
            //dropdown olmasi icin select tagıyla olusmasi lazim, altindaki seceneklerde option tagiyla olusturulmasi lazim.
            // statu active secilir
            //Select select = new Select(adminPage.statusDropdownMenu);
            select.selectByVisibleText("active");
            adminPage.saveCustomerButton.click();
            ReusableMethods.wait(3);

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
            adminPage.namesearchicon.click();
            Assert.assertFalse(adminPage.assertSearchedPage.isDisplayed());
            Driver.getDriver().quit();
        }

        @Test
        public void TC_4104 () {
            adminPage = new AdminPage();
            ReusableMethods.accessAdmin("adminuser_meltem", "adminpassword_meltem");
            adminPage.buyersButton.click();
            Assert.assertTrue(adminPage.customersButton.isDisplayed());

            adminPage.customersButton.click();
            Assert.assertTrue(adminPage.iconvisible.isDisplayed());
            Driver.getDriver().quit();
        }

    }

