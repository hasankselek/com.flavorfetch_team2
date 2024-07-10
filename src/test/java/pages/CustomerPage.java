package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CustomerPage {

    public CustomerPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()='Sign in']")
    public WebElement signInButton; // customer page

    @FindBy(id = "username")
    public WebElement emailBox; // customer login page

    @FindBy(id = "password")
    public WebElement passwordBox; // customer login page

    @FindBy(xpath = "//*[@class='custom-control-label']")
    public WebElement rememberMeCheckBox; // customer login page

    @FindBy(xpath = "//*[@class='zmdi zmdi-eye']")
    public WebElement passworrdHideShowEye; // customer login page

    @FindBy(xpath = "//*[text()='Forgot password?']")
    public WebElement forgotPasswordLink; // customer login page

    @FindBy(xpath = "//span[text()='Sign in']")
    public WebElement loginSigninButton; // customer login page

    @FindBy(xpath = "//*[text()='Sign Up']")
    public WebElement signUpButton; // customer login page

    @FindBy(xpath = "//*[@class='dropdown userprofile']")
    public WebElement profileDropdownMenu; // customer page

    @FindBy(xpath = "//*[@class='btn-group pull-right notification-dropdown']")
    public WebElement notificicationsButton; // customer page

    @FindBy(xpath = "//*[text()=' Logout ' ]")
    public WebElement logoutButton; // customer page

    @FindBy(xpath = "//*[@class='alert alert-warning']")
    public WebElement loginAlert; // customer login page

    @FindBy(xpath = "//*[text()='Contact us']")
    public WebElement contactUsLink; // customer page

    @FindBy(xpath = "//*[text()='1-800-123-4567']")
    public WebElement contactSiteNumber; // customer contact page

    @FindBy(xpath = "//*[text()='info@flavorfetch.com']")
    public WebElement contactSiteMail; // customer contact page

    @FindBy(xpath = "//*[text()='Accept']")
    public WebElement cookieAccept; // customer page

    @FindBy (id = "AR_contact_fullname")
    public WebElement contactNameBox; // customer contact page

    @FindBy (id = "AR_contact_email_address")
    public WebElement contactMailBox; // customer contact page

    @FindBy (id = "AR_contact_message")
    public WebElement contactMessageBox; // customer contact page

    @FindBy (xpath = "//*[@class='blogContactPhoto']")
    public WebElement contactImage; // customer contact page

    @FindBy(xpath = "//*[@class='btn btn-green w-100 mt-3']")
    public WebElement submitFormButton; // customer contact page

    @FindBy(xpath = "//*[@class='alert alert-success']")
    public WebElement requestSentText; // customer contact page

    @FindBy(xpath = "//*[@class='alert alert-danger']")
    public WebElement invalidEmailText; // customer contact page

    @FindBy(xpath = "//*[@class='footer-logo']")
    public WebElement footerLogo; // customer page footer logo

    @FindBy(xpath = "//*[@class='zmdi zmdi-facebook']")
    public WebElement footerFacebookLogo; // customer page footer facebook logo

    @FindBy(xpath = "//*[@class='zmdi zmdi-instagram']")
    public WebElement footerInstagramLogo; // // customer page footer Instagram logo

    @FindBy(xpath = "//*[@class='zmdi zmdi-linkedin']")
    public WebElement footerLinkedInLogo; // // customer page footer Linkedin logo

    @FindBy(xpath = "//*[@class='zmdi zmdi-twitter']")
    public WebElement footerXLogo; // // customer page footer X logo

    @FindBy(xpath = "//*[@class='zmdi zmdi-youtube-play']")
    public WebElement footerYoutubeLogo;
  
    @FindBy(xpath = "//*[@class=\"row no-gutters list-inline\"]")
    public WebElement localCuisine;

    @FindBy(xpath = "(//*[@class='p-2'])[1]")
    public WebElement appStoreLogo; // customer page footer AppStore logo

    @FindBy(xpath = "(//*[@class='p-2'])[2]")
    public WebElement googlePlayLogo; // customer page footer Google Play logo

    @FindBy(xpath = "//*[text()='Flavor Fetch Corp.']")
    public WebElement flavorFetchCorpBasligi; // customer page footer Flavor Fetch Corp. basligi

    @FindBy(xpath = "//*[text()='Privacy policy']")
    public WebElement privacypolicyLink; // customer page footer Privacy policy link

    @FindBy(xpath = "//*[text()='Terms and conditions']")
    public WebElement termsandconditionsLink; // customer page footer Termsandconditions link

    @FindBy(xpath = "//*[text()='Business']")
    public WebElement businessTitle; // customer page footer Business title

    @FindBy(xpath = "//*[text()='Become a Partner']")
    public WebElement becomeaPartnerLink; // customer page footer Become a Partner link

    @FindBy(xpath = "//*[text()='  © Flavor Fetch Corp. 2023']")
    public WebElement flavorFetchCorp2023Text; // customer page footer Flavor Fetch Corp. Text

    @FindBy(xpath = "//*[text()='flavorfetch.com']")
    public WebElement flavorFatchLink; // customer page footer flavorfetch.com link

    @FindBy(xpath = "//*[text()='Blog']")
    public WebElement blogTitleText; // customer page footer Blog Title text

    @FindBy(xpath = "(//*[@class='position-relative '])[5]")
    public WebElement firstBlogLink; // customer page footer 1.blog link

    @FindBy(xpath = "(//*[@class='position-relative '])[6]")
    public WebElement secondBlogLink;  // customer page footer 2.blog link

    @FindBy(xpath = "(//*[@class='position-relative '])[7]")
    public WebElement thirdBlogLink; // customer page footer 4.blog link

    @FindBy(xpath = "(//*[@class='position-relative '])[8]")
    public WebElement fourthBlogLink; // // customer page footer 4.blog link

    @FindBy(xpath = "//*[text()='Sandwiches and Wraps']")
    public WebElement sandwichAndWraps; // customer page sandwich and wraps

    @FindBy(xpath = "(//*[@class='col-lg-3 mb-3 col-md-6 list-items'])")
    public WebElement team2Restaurant; // customer page team2 restaurant page

    @FindBy(xpath = "(//*[@class='el-image__inner'])")
    public List<WebElement> restaurantAllPhoto; // customer page restaurant page all photo

    @FindBy(xpath = "//a[text()=' Saved Stores ']")
    public WebElement savedStoreIcon;//customer page

    @FindBy(xpath = "//h5[@class='m-0 text-truncate']")
    public List<WebElement> savedStoreRestaurants;//Saved Store Page

    @FindBy(xpath = "(//a[@class='btn btn-green'])[1]")
    public WebElement orderNowButton;//Saved Store Page

    @FindBy(xpath = "//div[@class='d-none d-lg-block']")
    public  WebElement heartIcon; //Saved Store Page

    @FindBy(xpath = "(//*[text()='Privacy policy'])[1]"  )
    public WebElement PrivacyPolicySayfabaslik; // privacy policy text title

    @FindBy(xpath = "(//*[@class='text-left'])[2]"  )
    public WebElement PrivacyPolicySayfametni; // privacy policy text

    @FindBy(xpath = "//*[text()='info@flavorfetch.com']"  )
    public WebElement PrivacyPolicyIletisimAdresi; // privacy policy contact us

    @FindBy(xpath = "(//*[text()='Italian'])[1]")
    public WebElement italianRestaurants; // customer page italian Restaurants Page



}
