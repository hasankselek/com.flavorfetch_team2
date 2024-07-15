package tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomerPage;
import utilities.Driver;
import utilities.JSUtilities;
import utilities.ReusableMethods;

public class US_011 {

    static CustomerPage customerPage = new CustomerPage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void TC_1101(){
        actions = new Actions(Driver.getDriver());
        customerPage = new CustomerPage();
        ReusableMethods.accessToCustomer("customeruser_hasan","customerpassword_hasan");


        // Cookie'yi kabul eder
        customerPage.cookieAccept.click();

        customerPage.enterDeliveryAddresstextBox.sendKeys("Seattle");
        ReusableMethods.wait(1);

        customerPage.seattleCity.click();
        ReusableMethods.wait(1);

        Driver.getDriver().navigate().back();
        ReusableMethods.wait(1);

        // Anasayfa'dan sandwich and wraps'i seçer

        actions.click(customerPage.sandwichAndWraps).perform(); // sandwich and wraps

        // Team2 Restaurant'ını seçer
        customerPage.team2Restaurant.click(); // team2 restaurant

        //Check restaurant name and picture
        String expectedRestaurantName = "Team2";
        Assert.assertTrue(customerPage.restaurantName.isDisplayed());
        Assert.assertEquals(customerPage.restaurantName.getText(),expectedRestaurantName);
        Assert.assertTrue(customerPage.restaurantPicture.isDisplayed());

        //Check restaurant price  type
        String expectedRestaurantType = "$ - low cost restaurant";
        Assert.assertTrue(customerPage.restraurantPriceType.isDisplayed());
        Assert.assertEquals(customerPage.restraurantPriceType.getText(),expectedRestaurantType);

        //Check restaurant type
        Assert.assertEquals(customerPage.restraurantType.getText(),customerPage.sandwichAndWraps.getText());

        //Check restaurant score
        Assert.assertTrue(customerPage.restaurantScore.isDisplayed());
        Assert.assertTrue(0.0<=Double.parseDouble(customerPage.restaurantScore.getText()) && 5.0>=Double.parseDouble(customerPage.restaurantScore.getText()));

        //Click on the total number of reviews and check that it directs you to comments.
        customerPage.restaurantReviews.click();
        Assert.assertTrue(customerPage.sectionReviews.isDisplayed());
        JSUtilities.scrollToTop(Driver.getDriver());
        ReusableMethods.wait(1);

        //Check that "Save Store" appears and click on the favorite icon
        String expectedSaveStoreText = "Save store";
        Assert.assertEquals(customerPage.saveStoreText.getText(),expectedSaveStoreText);
        Assert.assertTrue(customerPage.favSaveStoreButton.isEnabled());
        ReusableMethods.wait(3);
        customerPage.favSaveStoreButton.click();
        ReusableMethods.wait(2);
        customerPage.favSavedButton.click();
        expectedSaveStoreText = "Saved";
        Assert.assertTrue(customerPage.saveStoreText.getText().contains(expectedSaveStoreText));
        ReusableMethods.wait(3);

        //Closes the page
        Driver.quitDriver();


    }
}
