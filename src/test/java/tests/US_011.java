package tests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomerPage;
import utilities.Driver;
import utilities.JSUtilities;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class US_011 {

    Actions actions = new Actions(Driver.getDriver());
    CustomerPage customerPage = new CustomerPage();

    @Test
    public void TC_1101(){
        customerPage = new CustomerPage();
        ReusableMethods.customerHasanAccesToTeam2Restaurent();

        //Check restaurant name and picture
        String expectedRestaurantName = "Team2";
        Assert.assertTrue(customerPage.restaurantName.isDisplayed());
        Assert.assertEquals(customerPage.restaurantName.getText(), expectedRestaurantName);
        Assert.assertTrue(customerPage.restaurantPicture.isDisplayed());

        //Check restaurant price  type
        String expectedRestaurantType = "$ - low cost restaurant";
        Assert.assertTrue(customerPage.restraurantPriceType.isDisplayed());
        Assert.assertEquals(customerPage.restraurantPriceType.getText(), expectedRestaurantType);

        //Check restaurant type
        Assert.assertEquals(customerPage.restraurantType.getText(), customerPage.sandwichAndWraps.getText());

        //Check restaurant score
        Assert.assertTrue(customerPage.restaurantScore.isDisplayed());
        Assert.assertTrue(0.0 <= Double.parseDouble(customerPage.restaurantScore.getText()) && 5.0 >= Double.parseDouble(customerPage.restaurantScore.getText()));

        //Click on the total number of reviews and check that it directs you to comments.
        customerPage.restaurantReviews.click();
        Assert.assertTrue(customerPage.sectionReviews.isDisplayed());
        JSUtilities.scrollToTop(Driver.getDriver());
        ReusableMethods.wait(1);

        //Check that "Save Store" appears and click on the favorite icon
        String expectedSaveStoreText = "Save store";
        Assert.assertEquals(customerPage.saveStoreText.getText(), expectedSaveStoreText);
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

    @Test
    public void TC_1102(){

        customerPage = new CustomerPage();
        ReusableMethods.customerHasanAccesToTeam2Restaurent();


        List<String> orderTypeText = new ArrayList<>();
        for (int i = 0; i < customerPage.customerOrderType.size(); i++) {
            customerPage.customerOrderType.get(i).click();
            ReusableMethods.wait(1);
            orderTypeText.add(customerPage.customerOrderType.get(i).getText());
            Assert.assertTrue(customerPage.customerOrderType.get(i).isDisplayed());
            Assert.assertTrue(customerPage.customerOrderType.get(i).isEnabled());
            Assert.assertEquals(customerPage.customerOrderType.get(i).getText(),orderTypeText.get(i));
        }
        Driver.quitDriver();

    }

    @Test
    public void TC_1103(){
        customerPage = new CustomerPage();
        ReusableMethods.customerHasanAccesToTeam2Restaurent();

        //Check that cart is empty
        Assert.assertTrue(customerPage.cartTitle.isDisplayed());

        //Check if there is a cart icon
        Assert.assertTrue(customerPage.cartIcon.isDisplayed());

        //"You don't have any orders here! let's change that!" check the text
        String expectedEmptyCartText = "You don't have any orders here!";
        String actualEmptyCartText = Driver.getDriver().findElement(By.xpath("//*[@class='m-0 mt-3']")).getText();
        Assert.assertTrue(actualEmptyCartText.contains(expectedEmptyCartText));

        //Closes the page
        Driver.quitDriver();
    }

    @Test
    public void TC_1104(){
        customerPage = new CustomerPage();
        ReusableMethods.customerHasanAccesToTeam2Restaurent();

        //Check product picture
        for (int i = 1; i < customerPage.merchantProductPictures.size(); i++) {
            Assert.assertTrue(customerPage.merchantProductPictures.get(i).isDisplayed());
        }

        //Check product price
        //Check product description
        //Check product name
        for (int i = 0; i < customerPage.productsInformation.size(); i++) {
            Assert.assertTrue(customerPage.productsInformation.get(i).isDisplayed());
            Assert.assertTrue(customerPage.productsInformation.get(i).getText().contains("$"));
        }

        //Closes the page
        Driver.quitDriver();

    }

    @Test
    public void TC_1105(){
        customerPage = new CustomerPage();
        ReusableMethods.customerHasanAccesToTeam2Restaurent();


        //Check if menu text and submenus are visible
        Assert.assertTrue(customerPage.menuText.isDisplayed());

        //Check if pressing the menu subheadings directs you to the correct section.
        for (int i = 0; i < customerPage.subMenus.size(); i++) {
            Assert.assertTrue(customerPage.customerOrderType.get(i).isDisplayed());
            Assert.assertTrue(customerPage.customerOrderType.get(i).isEnabled());
        }

        //kebab menu
        String expectedKebabMenuText = customerPage.subMenus.get(0).getText();
        ReusableMethods.wait(1);
        customerPage.subMenus.get(0).click();
        Assert.assertEquals(customerPage.kebabText.getText(),expectedKebabMenuText);

        //Dondurma menu
        customerPage.subMenus.get(1).click();
        String expectedDondurmaMenuText = customerPage.subMenus.get(1).getText();
        Assert.assertEquals(customerPage.dondurmaText.getText(),expectedDondurmaMenuText);


        //Closes the page
        Driver.quitDriver();

    }

    @Test
    public void TC_1106(){
        customerPage = new CustomerPage();
        actions = new Actions(Driver.getDriver());
        ReusableMethods.customerHasanAccesToTeam2Restaurent();

        //Check and click the "Add to cart" button
        for (int i = 0; i < customerPage.addToCartButton.size(); i++) {
            Assert.assertTrue(customerPage.addToCartButton.get(i).isDisplayed());
        }

        //Check that the product has been added to the cart and the product information exists
        customerPage.addToCartButton.get(0).click();
        String firstProductNameCart = Driver.getDriver().findElement(By.xpath("(//*[@class='mb-1'])")).getText();
        Assert.assertTrue(customerPage.productsInformation.get(0).getText().contains(firstProductNameCart));

        //Click the "+" button and add product
        customerPage.plusButton.click();
        ReusableMethods.wait(2);

        //Check if the number of products and price increases
        String expectedProductQuantity = "2";
        String expectedProductPrice = "30.00$";
        String actualProductQuantity = Driver.getDriver().findElement(By.xpath("//div[@class='col-6 p-0 d-flex justify-content-start flex-column']//div[@class='qty']")).getText();
        String actualProductPrice = Driver.getDriver().findElement(By.xpath("//div[@class='inner-wrapper-sticky']//div[1]//div[1]//div[3]//p[1]")).getText();
        Assert.assertEquals(actualProductQuantity, expectedProductQuantity);
        Assert.assertEquals(actualProductPrice,expectedProductPrice);

        //Click "-" button and add product
        customerPage.minusButton.click();
        ReusableMethods.wait(5);

        //Check if the number of products is decreasing
        expectedProductQuantity = "1";
        actualProductQuantity = Driver.getDriver().findElement(By.xpath("//div[@class='col-6 p-0 d-flex justify-content-start flex-column']//div[@class='qty']")).getText();
        expectedProductPrice = "15.00$";
        actualProductPrice = Driver.getDriver().findElement(By.xpath("//div[@class='inner-wrapper-sticky']//div[1]//div[1]//div[3]//p[1]")).getText();
        Assert.assertEquals(actualProductQuantity, expectedProductQuantity);
        Assert.assertEquals(actualProductPrice,expectedProductPrice);

        //Check and click on "Clear" button
        customerPage.clearButton.click();
        ReusableMethods.wait(2);

        //Check the cart is clear
        Assert.assertTrue(customerPage.cartIcon.isDisplayed());
        String expectedEmptyCartText = "You don't have any orders here!";
        String actualEmptyCartText = Driver.getDriver().findElement(By.xpath("//*[@class='m-0 mt-3']")).getText();
        Assert.assertTrue(actualEmptyCartText.contains(expectedEmptyCartText));

        //Closes the page
        Driver.quitDriver();
    }

    @Test
    public void TC_1107(){
        actions = new Actions(Driver.getDriver());
        customerPage = new CustomerPage();
        ReusableMethods.customerHasanAccesToTeam2Restaurent();
        customerPage.addToCartButton.get(1).click();

        //Check if the product knows that its image, name and price are displayed
        WebElement customizePageProductImage = Driver.getDriver().findElement(By.xpath("(//*[@class='el-image'])[8]"));
        Assert.assertTrue(customizePageProductImage.isDisplayed());

        String expectedCustomizePageProductName = "pide";
        String actualCustomizePageProductName = Driver.getDriver().findElement(By.xpath("//*[@id='item-details']/div/h4")).getText();
        Assert.assertEquals(actualCustomizePageProductName,expectedCustomizePageProductName);

        String expectedCustomizePageProductPrice = "25.00$";
        String actualCustomizePageProductPrice = Driver.getDriver().findElement(By.xpath("//*[@id='item-details']/div/div[2]/label")).getText();
        Assert.assertEquals(actualCustomizePageProductPrice,expectedCustomizePageProductPrice);

        //Check the "Special Instructions" heading and fill in the box
        Assert.assertTrue(customerPage.specialInstructionsText.isDisplayed());
        Faker faker = new Faker();
        Assert.assertTrue(customerPage.specialInstructionsTextArea.isDisplayed());
        actions.click(customerPage.specialInstructionsTextArea).sendKeys(faker.lorem().sentence()).perform();

        //Check the If sold out heading and select an option
        Assert.assertTrue(customerPage.ifSoldOutTitle.isDisplayed());
        JSUtilities.clickWithJS(Driver.getDriver(),customerPage.ifSoldOutSelect);
        ReusableMethods.wait(2);

        Random rand = new Random();
        Select select = new Select(customerPage.ifSoldOutSelect);
        List<WebElement> options = select.getOptions();
        int randomIndex = rand.nextInt(options.size());
        select.selectByIndex(randomIndex);
        ReusableMethods.wait(3);

        //Check if the number of products can be increased or decreased
        customerPage.customizePagePlusButton.click();
        ReusableMethods.wait(2);
        String expectedProductQuantity = "2";
        String actualProductQuantity = customerPage.customizePageQuantity.getText();
        Assert.assertEquals(actualProductQuantity,expectedProductQuantity);


        customerPage.customizePageMinusButton.click();
        ReusableMethods.wait(2);
        expectedProductQuantity = "1";
        actualProductQuantity = customerPage.customizePageQuantity.getText();
        Assert.assertEquals(actualProductQuantity,expectedProductQuantity);

        //Check the Add to cart button
        Assert.assertTrue(customerPage.customizePageAddToCartButton.isEnabled());
        Assert.assertTrue(customerPage.customizePageAddToCartButton.isDisplayed());
        Assert.assertTrue(customerPage.customizePageAddToCartButton.getText().contains("Add to cart - "));


        //Closes the page
        Driver.quitDriver();




    }

    @Test
    public void TC_1108(){
        customerPage = new CustomerPage();
        ReusableMethods.customerHasanAccesToTeam2Restaurent();
        customerPage.addToCartButton.get(0).click();

        //Check the presence of the "Check out" button
        Assert.assertTrue(customerPage.checkoutButton.isDisplayed());
        String expectedCheckoutText = "Checkout";
        String actualCheckoutText = customerPage.checkoutButton.getText();
        Assert.assertTrue(customerPage.checkoutButton.getText().contains(expectedCheckoutText));

        List<WebElement> priceListWebElement = Driver.getDriver().findElements(By.xpath("//p[@class='mb-0']"));
        List<String> priceListString = ReusableMethods.stringListesineDonustur(priceListWebElement);

        List<Integer> priceList = new ArrayList<>();
        for (int i = 0; i < priceListString.size(); i++) {
            priceList.add(Integer.parseInt(priceListString.get(i).replace("$", "").replace(".", "")));
        }
        int sum = 0;
        for (Integer number : priceList) {
            sum += number;
        }
        int actualPrice = Integer.parseInt(Driver.getDriver().findElement(By.xpath("//*[@id='vue-cart']/div/div[2]/a/div[2]")).
                getText().replace("$", "").replace(".", ""));
        Assert.assertEquals(actualPrice, sum);

        //Click the "Check out" button
        customerPage.checkoutButton.click();
        ReusableMethods.wait(2);

        //Check it redirects to checkout page
        String expectedUrl = "https://qa.flavorfetch.com/account/checkout";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
        Driver.getDriver().navigate().back();


            //Closes the page
            Driver.quitDriver();


    }

    @Test
    public void TC_1109(){
        customerPage = new CustomerPage();
        ReusableMethods.customerHasanAccesToTeam2Restaurent();

        //Check if the gallery and about section are displayed
        Assert.assertTrue(customerPage.aboutRestaurant.isDisplayed());
        Assert.assertTrue(customerPage.galleryText.isDisplayed());

        //Check Address and "Get Direction" link
        Assert.assertTrue(customerPage.restaurantAddress.isDisplayed());
        Assert.assertTrue(customerPage.restaurantGetDirectionLink.isEnabled());
        Assert.assertTrue(customerPage.restaurantGetDirectionLink.isDisplayed());

        //Check "Opening Hours"
        Assert.assertTrue(customerPage.restaurantOpeningHours.isDisplayed());
        Assert.assertTrue(customerPage.restaurantOpeningHours.getText().contains("Opening hours:"));


        //Check "Google Maps" link
        Assert.assertTrue(customerPage.restaurantGoogleMaps.isEnabled());
        Assert.assertTrue(customerPage.restaurantGoogleMaps.isDisplayed());

        Driver.quitDriver();

    }
}
