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
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class US_41 {
    AdminPage adminPage=new AdminPage();

    @Test
    public void TC_4101(){
        adminPage=new AdminPage();
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        adminPage.userNameButton.sendKeys(ConfigReader.getProperty("adminuser_meltem"));
        Driver.getDriver().findElement(By.xpath("//*[@for='LoginForm_password']")).sendKeys("Flavor.2106");
        //adminPage.passwordButton.sendKeys(ConfigReader.getProperty("adminpassword_meltem"));
        adminPage.signInButton.click();
        adminPage.buyersButton.click();
        Assert.assertTrue(adminPage.customersButton.isDisplayed());
        Assert.assertTrue(adminPage.reviewsButton.isDisplayed());
        adminPage.customersButton.click();
        Assert.assertTrue(adminPage.customerListPage.isDisplayed());
        adminPage.sortingCustomerName.click();
        List<WebElement> sortingCustomerName =  Driver.getDriver().findElements(By.xpath("//tbody//tr//td//h6"));
        System.out.println("Customer isimleri: "+ ReusableMethods.stringListesineDonustur(sortingCustomerName));
    }
    @Test
    public void TC_4102(){
        adminPage=new AdminPage();
          adminPage.addNewCustomerButton.click();
          adminPage.firstNamebutton.sendKeys("Ayse");
        Faker faker=new Faker();
        Actions actions=new Actions(Driver.getDriver());
        actions.click(adminPage.firstNamebutton)
                .sendKeys(faker.name().firstName()).perform();

         actions.click((adminPage.lastNamebutton))
                 .sendKeys(faker.name().lastName())        .perform();

         actions.click(adminPage.emailNameButton)
                 .sendKeys(faker.internet().emailAddress()).perform();

         actions.click(adminPage.contactPhone).sendKeys((CharSequence) faker.phoneNumber()).perform();


         String fakePassword=faker.internet().password();
        actions.click(adminPage.passwordButton).sendKeys(fakePassword).perform();
        actions.click(adminPage.confirmPasswordButton).sendKeys(fakePassword).perform();


        adminPage.browseButton.click();
        String yuklenecekDosyaninDosyaYolu="C:\\Users\\Meltem\\IdeaProjects\\com.flavorfetch_team2\\src\\test\\java\\tests\\upload.png";
        adminPage.selectFilesButton.sendKeys(yuklenecekDosyaninDosyaYolu);







    }

}
