package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomerPage;
import utilities.*;

public class US_004 {
    CustomerPage customerPage = new CustomerPage();

    @Test
    public void TC_0401(){
        JSUtilities.scrollToBottom(Driver.getDriver());
        Assert.assertTrue(customerPage.footerLogo.isDisplayed());
        customerPage.footerLogo.click();
        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = "https://qa.flavorfetch.com/";
        Assert.assertEquals(actualUrl,expectedUrl);
    }

    @Test
    public void TC0402(){

        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        JSUtilities.scrollToBottom(Driver.getDriver());

        Assert.assertTrue(customerPage.footerFacebookLogo.isDisplayed());
        Assert.assertTrue(customerPage.footerFacebookLogo.isEnabled());

        //Facebook icon
        customerPage.footerFacebookLogo.click();
        ReusableMethods.switchToWindowsWithUrl("https://www.facebook.com/",Driver.getDriver());
        String expectedFacebookIconUrl = "https://www.facebook.com/";
        String actualFacebookIconUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualFacebookIconUrl,expectedFacebookIconUrl,"Facebook url'si eslesmiyor");
        ReusableMethods.switchToWindowWithTitle("Flavor Fetch");

        //Instagram icon
        customerPage.footerInstagramLogo.click();
        ReusableMethods.switchToWindowsWithUrl("https://qa.flavorfetch.com/www.instagram.com",Driver.getDriver());
        String expectedInstagramIconUrl = "https://www.instagram.com/";
        String actualInstagramIconUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualInstagramIconUrl,expectedInstagramIconUrl,"Instagram url'si eslesmiyor");
        ReusableMethods.switchToWindowWithTitle("Flavor Fetch");

        //LınkedIn icon
        customerPage.footerLinkedInLogo.click();
        ReusableMethods.switchToWindowsWithUrl("https://qa.flavorfetch.com/www.linkedin.com",Driver.getDriver());
        String expectedLinkedInIconUrl = "https://www.linkedin.com/";
        String actualLinkedInIconUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualLinkedInIconUrl, expectedLinkedInIconUrl,"LinkedIn url'si eslesmiyor");
        ReusableMethods.switchToWindowWithTitle("Flavor Fetch");

        //X icon
        customerPage.footerXLogo.click();
        ReusableMethods.switchToWindowsWithUrl("https://x.com/",Driver.getDriver());
        String expectedXIconUrl = "https://x.com/";
        String actualXIconUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualXIconUrl, expectedXIconUrl,"X url'si eslesmiyor");
        ReusableMethods.switchToWindowWithTitle("Flavor Fetch");

        //Youtube icon
        customerPage.footerYoutubeLogo.click();
        ReusableMethods.switchToWindowsWithUrl("https://www.facebook.com/",Driver.getDriver());
        String expectedYoutubeIconUrl = "https://www.youtube.com/";
        String actualYoutubeIconUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualYoutubeIconUrl, expectedYoutubeIconUrl,"Youtube url'si eslesmiyor");

        Driver.quitDriver();
    }

}
