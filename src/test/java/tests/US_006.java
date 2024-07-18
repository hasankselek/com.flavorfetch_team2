package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.CustomerPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_006 {

    CustomerPage customerPage=new CustomerPage();


    @Test
    public void TC_0601(){

        CustomerPage customerPage=new CustomerPage();
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        ReusableMethods.wait(1);
        customerPage.signInButton.click();
        ReusableMethods.wait(1);
        customerPage.signUpButton.click();
        Faker faker = new Faker();
        Actions actions = new Actions(Driver.getDriver());


        actions.click(customerPage.firstnamesignup)
                .sendKeys(faker.name().firstName()).perform();

        actions.click((customerPage.lastnamesignup))
                .sendKeys(faker.name().lastName()).perform();

        actions.click(customerPage.emailsignup)
                .sendKeys(faker.internet().emailAddress()).perform();


        actions.click(customerPage.phonesignup).sendKeys(faker.phoneNumber().phoneNumber()).perform();

        String fakePassword = faker.internet().password();

        actions.click(customerPage.passwordsignup).sendKeys(fakePassword).perform();
        actions.click(customerPage.cpasswordsignup).sendKeys(fakePassword).perform();
        customerPage.ssignup.click();



    }

    public void TC_0602(){

        CustomerPage customerPage=new CustomerPage();
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        ReusableMethods.wait(1);
        customerPage.signInButton.click();
        ReusableMethods.wait(1);
        customerPage.signUpButton.click();
        Faker faker = new Faker();
        Actions actions = new Actions(Driver.getDriver());


        actions.click(customerPage.firstnamesignup)
                .sendKeys(faker.name().firstName()).perform();

        actions.click((customerPage.lastnamesignup))
                .sendKeys(faker.name().lastName()).perform();

        actions.click(customerPage.emailsignup)
                .sendKeys(faker.name().lastName()).perform();


        actions.click(customerPage.phonesignup).sendKeys(faker.phoneNumber().phoneNumber()).perform();

        String fakePassword = faker.internet().password();

        actions.click(customerPage.passwordsignup).sendKeys(fakePassword).perform();
        actions.click(customerPage.cpasswordsignup).sendKeys(fakePassword).perform();
        customerPage.ssignup.click();


    }
}
