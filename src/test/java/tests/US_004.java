package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomerPage;
import utilities.*;


public class US_004 extends TestBaseRapor {

    CustomerPage customerPage = new CustomerPage();

    @Test
    public void TC_0401(){

        customerPage = new CustomerPage();
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        JSUtilities.scrollToBottom(Driver.getDriver());
        Assert.assertTrue(customerPage.footerLogo.isDisplayed());
        customerPage.footerLogo.click();
        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = "https://qa.flavorfetch.com/";
        Assert.assertEquals(actualUrl,expectedUrl);
        Driver.quitDriver();
    }

    @Test
    public void TC_0402(){
        customerPage = new CustomerPage();
        extentTest=extentReports.createTest("TC_0402" , "Checking social media icons in customer footer test.");

        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        extentTest.info("Kullanici browseri acar , url ' i girer");

        JSUtilities.scrollToBottom(Driver.getDriver());
        extentTest.info("Sayfada footer bölümüne gider");


        Assert.assertTrue(customerPage.footerFacebookLogo.isDisplayed());
        extentTest.pass("Facebook logosunun gördündüğünü kontrol eder");
        Assert.assertTrue(customerPage.footerFacebookLogo.isEnabled());
        extentTest.pass("Facebook logosunun aktif olduğunu kontrol eder");

        //Facebook icon
        customerPage.footerFacebookLogo.click();
        extentTest.info("Facebook ikonuna tıklar");
        ReusableMethods.windowaGec("https://www.facebook.com/",Driver.getDriver());
        extentTest.info("Diğer sekmeye geçer");
        String expectedFacebookIconUrl = "https://www.facebook.com/";
        String actualFacebookIconUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualFacebookIconUrl,expectedFacebookIconUrl,"Facebook url'si eslesmiyor");
        extentTest.pass("Facebook ikonuna basınca doğru url ye yönlendirip yönlendirmediğini doğrular");
        ReusableMethods.switchToWindowWithTitle("Flavor Fetch");
        extentTest.info("Önceki sayfaya geri döner");


        //Instagram icon
        customerPage.footerInstagramLogo.click();
        extentTest.info("Instagram ikonuna tıklar");
        ReusableMethods.windowaGec("https://qa.flavorfetch.com/www.instagram.com",Driver.getDriver());
        extentTest.info("Diğer sekmeye geçer");
        String expectedInstagramIconUrl = "https://www.instagram.com/";
        String actualInstagramIconUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualInstagramIconUrl,expectedInstagramIconUrl,"Instagram url'si eslesmiyor");
        ReusableMethods.wait(2);
        extentTest.pass("Instagram ikonuna basınca doğru url ye yönlendirip yönlendirmediğini doğrular");
        ReusableMethods.switchToWindowWithTitle("Flavor Fetch");
        extentTest.info("Önceki sayfaya geri döner");

        //LınkedIn icon
        customerPage.footerLinkedInLogo.click();
        extentTest.info("LinkedIn ikonuna tıklar");
        ReusableMethods.windowaGec("https://qa.flavorfetch.com/www.linkedin.com",Driver.getDriver());
        extentTest.info("Diğer sekmeye geçer");
        String expectedLinkedInIconUrl = "https://www.linkedin.com/";
        String actualLinkedInIconUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualLinkedInIconUrl, expectedLinkedInIconUrl,"LinkedIn url'si eslesmiyor");
        extentTest.pass("LinkedIn ikonuna basınca doğru url ye yönlendirip yönlendirmediğini doğrular");
        ReusableMethods.switchToWindowWithTitle("Flavor Fetch");
        extentTest.info("Önceki sayfaya geri döner");

        //X icon
        customerPage.footerXLogo.click();
        extentTest.info("X ikonuna tıklar");
        ReusableMethods.windowaGec("https://x.com/",Driver.getDriver());
        extentTest.info("Diğer sekmeye geçer");
        String expectedXIconUrl = "https://x.com/";
        String actualXIconUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualXIconUrl, expectedXIconUrl,"X url'si eslesmiyor");
        extentTest.pass("X ikonuna basınca doğru url ye yönlendirip yönlendirmediğini doğrular");
        ReusableMethods.switchToWindowWithTitle("Flavor Fetch");
        extentTest.info("Önceki sayfaya geri döner");

        //Youtube icon
        customerPage.footerYoutubeLogo.click();
        extentTest.info("Youtube ikonuna tıklar");
        ReusableMethods.windowaGec("https://www.facebook.com/",Driver.getDriver());
        extentTest.info("Diğer sekmeye geçer");
        String expectedYoutubeIconUrl = "https://www.youtube.com/";
        String actualYoutubeIconUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualYoutubeIconUrl, expectedYoutubeIconUrl,"Youtube url'si eslesmiyor");
        extentTest.pass("Youtube ikonuna basınca doğru url ye yönlendirip yönlendirmediğini doğrular");
        ReusableMethods.switchToWindowWithTitle("Flavor Fetch");
        extentTest.info("Önceki sayfaya geri döner");


        Driver.quitDriver();
        extentTest.info("Sayfayi kapatir");

        //Driver.getDriver().switchTo().window("https://www.facebook.com/").close();
    }

    @Test
    public void TC_0403(){
        customerPage = new CustomerPage();
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        JSUtilities.scrollToBottom(Driver.getDriver());

        //App store checking
        Assert.assertTrue(customerPage.appStoreLogo.isDisplayed());
        Assert.assertTrue(customerPage.appStoreLogo.isEnabled());
        customerPage.appStoreLogo.click();
        String expectedUrl = "https://www.apple.com/app-store/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
        Driver.getDriver().navigate().back();

        // Google Play checking
        Assert.assertTrue(customerPage.googlePlayLogo.isDisplayed());
        Assert.assertTrue(customerPage.googlePlayLogo.isEnabled());
        customerPage.googlePlayLogo.click();
        String expectedTitleIcerik = "Google Play";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));

        Driver.quitDriver();
    }

    @Test
    public void TC_0404(){
        customerPage = new CustomerPage();
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        JSUtilities.scrollToBottom(Driver.getDriver());

        Assert.assertTrue(customerPage.flavorFetchCorpBasligi.isDisplayed());

        //Contact Us Link
        Assert.assertTrue(customerPage.contactUsLink.isDisplayed());
        Assert.assertTrue(customerPage.contactUsLink.isEnabled());
        customerPage.contactUsLink.click();
        String expectedUrl = "https://qa.flavorfetch.com/contactus";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
        Driver.getDriver().navigate().back();
        ReusableMethods.wait(1);

        //Terms and Conditions Link
        Assert.assertTrue(customerPage.termsandconditionsLink.isDisplayed());
        Assert.assertTrue(customerPage.termsandconditionsLink.isEnabled());
        customerPage.termsandconditionsLink.click();
        expectedUrl = "https://qa.flavorfetch.com/terms-and-conditions";
        actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
        Driver.getDriver().navigate().back();
        ReusableMethods.wait(1);

        //Privacy policy Link
        Assert.assertTrue(customerPage.privacypolicyLink.isDisplayed());
        Assert.assertTrue(customerPage.privacypolicyLink.isEnabled());
        customerPage.privacypolicyLink.click();
        expectedUrl = "https://qa.flavorfetch.com/privacy-policy";
        actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
        Driver.getDriver().navigate().back();

        Driver.quitDriver();
    }

    @Test
    public void TC_0405(){
        customerPage = new CustomerPage();
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        JSUtilities.scrollToBottom(Driver.getDriver());

        Assert.assertTrue(customerPage.businessTitle.isDisplayed());

        //Become a Partner Link
        Assert.assertTrue(customerPage.becomeaPartnerLink.isDisplayed());
        Assert.assertTrue(customerPage.becomeaPartnerLink.isEnabled());

        customerPage.becomeaPartnerLink.click();

        String expectedUrl = "https://qa.flavorfetch.com/merchant/signup";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);

        Driver.quitDriver();
    }

    @Test
    public void TC_0406(){
        customerPage = new CustomerPage();
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        JSUtilities.scrollToBottom(Driver.getDriver());

        // Flavor Fetch Corp. 2023 Text
        Assert.assertTrue(customerPage.flavorFetchCorp2023Text.isDisplayed());

        // flavorfetch.com link
        Assert.assertTrue(customerPage.flavorFatchLink.isDisplayed());
        Assert.assertTrue(customerPage.flavorFatchLink.isEnabled());
        customerPage.flavorFatchLink.click();

        String expectedUrl = "https://qa.flavorfetch.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);

        Driver.quitDriver();
    }

    @Test
    public void TC_0407(){

        customerPage = new CustomerPage();
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        JSUtilities.scrollToBottom(Driver.getDriver());

        Assert.assertTrue(customerPage.blogTitleText.isDisplayed());

        // 1. blog link
        Assert.assertTrue(customerPage.firstBlogLink.isDisplayed());
        Assert.assertTrue(customerPage.firstBlogLink.isEnabled());
        customerPage.firstBlogLink.click();
        String expectedUrl = "https://qa.flavorfetch.com/the-social-side-of-online-food-ordering-connecting-communities-through-cuisine";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
        Driver.getDriver().navigate().back();
        ReusableMethods.wait(1);

        // 2. blog link
        Assert.assertTrue(customerPage.secondBlogLink.isDisplayed());
        Assert.assertTrue(customerPage.secondBlogLink.isEnabled());
        customerPage.secondBlogLink.click();
        expectedUrl = "https://qa.flavorfetch.com/exploring-the-delights-of-home-cooking-a-guide-to-meal-kit-delivery-services";
        actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
        Driver.getDriver().navigate().back();
        ReusableMethods.wait(1);

        // 3. blog link
        Assert.assertTrue(customerPage.thirdBlogLink.isDisplayed());
        Assert.assertTrue(customerPage.thirdBlogLink.isEnabled());
        customerPage.thirdBlogLink.click();
        expectedUrl = "https://qa.flavorfetch.com/embrace-the-convenience-ordering-food-online";
        actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
        Driver.getDriver().navigate().back();
        ReusableMethods.wait(1);

        // 4. blog link
        Assert.assertTrue(customerPage.fourthBlogLink.isDisplayed());
        Assert.assertTrue(customerPage.fourthBlogLink.isEnabled());
        customerPage.fourthBlogLink.click();
        expectedUrl = "https://qa.flavorfetch.com/nourishing-the-body-and-mind-the-healing-power-of-food";
        actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
        Driver.getDriver().navigate().back();

        Driver.quitDriver();

    }


}
