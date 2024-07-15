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

    @FindBy(xpath = "(//h5[@class='m-0 text-truncate'])[3]")
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

    @FindBy(xpath = "//*[text()=' Manage my account ']")
    public WebElement ManagemyAccount;  // customer  manage my account

    @FindBy(xpath = "//*[text()=' Payments Options ']")
    public WebElement paymentsOptions;  // customer payment page

    @FindBy(xpath = "//*[text()='Add new payment']")
    public WebElement addPayment;  // customer add payment

    @FindBy(xpath = "//*[text()='Cash On delivery']")
    public WebElement addCashOnDelivery;  // customer add cash on delivery payment

    @FindBy(xpath = "//*[text()='Stripe']")
    public WebElement stripe;  // customer add stripe payment

    @FindBy(xpath = "//*[text()='Add Cash']")
    public WebElement addCash;  // customer add cash

    @FindBy(xpath = "//*[text()='Delete']")
    public WebElement deletePayment;  // customer delete payment

    @FindBy(xpath = "//*[text()='Edit']")
    public WebElement editPayment;  // customer edit payment

    @FindBy(xpath = "//*[@id='first_name']")
    public WebElement FirstName;  // customer manage account

    @FindBy(xpath = "//*[@class='mt-3 btn btn-green w-100']")
    public WebElement SubmitButton;  // customer manage account submit

    @FindBy(xpath = "//*[@id='last_name']")
    public WebElement LastName;   // customer manage account

    @FindBy(xpath = "//*[@id='email_address']")
    public WebElement emailAddress;   // customer manage account

    @FindBy(xpath = "//*[@class='inputs-with-dropdown d-flex align-items-center mb-3']")
    public WebElement phone;       // customer manage account

    @FindBy(xpath = "//*[@class='alert alert-success']")
    public WebElement alertProfile;   // customer manage account

    @FindBy(xpath = "//*[@class='zmdi zmdi-cloud-upload']")   // //*[@class='zmdi zmdi-cloud-upload']   "//*[text()=' Update ']"
    public WebElement updateProfile;  // customer manage account

    @FindBy(xpath = "//*[text()='Drop files here to upload']")
    public WebElement updateClick;    // customer manage account

    @FindBy(xpath = "//*[@class='zmdi zmdi-lock-outline']")
    public WebElement changePassword;  //   customer manage account

    @FindBy(xpath = "//*[@id='old_password']")
    public WebElement oldPassword;  //customer manage account

    @FindBy(xpath = "//*[@id='new_password']")
    public WebElement newPassword;  // customer manage account

    @FindBy(xpath = "//*[@id='confirm_password']")
    public WebElement confirmPassword;  // customer manage account

    @FindBy(xpath = "//*[text()='Password change']")
    public WebElement passwordChangeText;  // customer manage account

    @FindBy(xpath = "//*[@class='alert alert-warning mb-2']")
    public WebElement passwordDifferentError;   // customer manage account

    @FindBy(xpath = "//*[text()='Code']")
    public WebElement codeView;  // customer manage account

    @FindBy(xpath = "//*[text()='Save Photo']")
    public WebElement savePhoto;

    @FindBy(xpath = "//*[text()=' Addresses ']")
    public WebElement addressInfo;  // customer  manage my account

    @FindBy(xpath = "//*[@class='module truncate-overflow']")
    public WebElement countryView;

    @FindBy(xpath = "//h5[text()='Home']")
    public WebElement addressType;

    @FindBy(xpath = "//*[@class='card p-3 fixed-height address-slot'")
    public List<WebElement> addressCount;

    @FindBy(xpath = "//*[@class='col-md-3']")
    public WebElement viewAddressCount;

    @FindBy (xpath= "//div[@id='vue-home-search']//input[@placeholder='Enter delivery address']")
    public  WebElement enterDeliveryAddresstextBox ; // customerpage

    @FindBy (xpath= "//h6[normalize-space()='New York']")
    public  WebElement newYorkAddressTextBox ; // customerpage

    @FindBy (xpath= "//*[text()='Show more']")
    public  WebElement showMoreButton ; // restaurants page

    @FindBy (xpath= "//*[@id='cuisine5']")
    public  WebElement sandwichRAdioButton ; // restaurants page

    @FindBy (xpath= "//h5[normalize-space()='Team2']")
    public  WebElement team2Page ; // restaurants page

    @FindBy (xpath= "(//*[text()=' Add to cart '])[1]")
    public  WebElement iskenderButton ; // team2 page

    @FindBy (xpath= "//a[@class='btn btn-green w-100 pointer d-flex justify-content-between']")
    public  WebElement checkoutButton ; // team2 page

    @FindBy (xpath= "//*[text()='Add new address']")
    public  WebElement addNewAddressLink ; // team2 page

    @FindBy (xpath= "(//*[@class='form-control form-control-text'])[4]")
    public  WebElement addressPopupTextBox ; // team2 page

    @FindBy (xpath= "(//*[text()='New York'])[3]")
    public  WebElement newYorkChangeAddress ; // team2 page

    @FindBy (xpath= "(//*[@class='btn btn-green w-100'])[8]")
    public  WebElement saveButtonChangeAddress ; // team2 page

    @FindBy (xpath= "(//*[text()='New York, NY, USA'])[2]")
    public  WebElement chooseDeliveryText ; // team2 page

    @FindBy (xpath= "//span[normalize-space()='Cash On delivery']")
    public  WebElement cashOnDeliveryButton ; // checkout page

    @FindBy (xpath= "//*[text()='Add Cash']")
    public  WebElement addCashButton ; // checkout page

    @FindBy (xpath= "//*[text()='Saved Payment Methods']")
    public  WebElement savedPaymentMethodsText ; // checkout page

    @FindBy (xpath= "//span[normalize-space()='Stripe']")
    public  WebElement stripeButton ; // checkout page

    @FindBy (xpath= "(//*[@class='btn btn-green w-100'])[10]")
    public  WebElement addStripeButton ; // checkout page

    @FindBy (xpath= "//h5[normalize-space()='Order type and time']")
    public  WebElement orderTypeMenuText ; // checkout page

    @FindBy (xpath= "//a[@class='d-block chevron-section transaction-section d-flex align-items-center rounded mb-2']")
    public  WebElement orderTypeLink ; // checkout page

    @FindBy (xpath= "(//*[@class='custom-control-label font14 bold'])[1]")
    public  WebElement deliveryRadioButton ; // checkout page

    @FindBy (xpath= "(//*[@class='custom-control-label font14 bold'])[2]")
    public  WebElement dineinRadioButton ; // checkout page

    @FindBy (xpath= "(//*[@class='custom-control-label font14 bold'])[3]")
    public  WebElement pickUpRadioButton ; // checkout page

    @FindBy (xpath= "(//*[@class='btn btn-green w-100'])[2]")
    public  WebElement orderTypeSaveButton ; // checkout page

    @FindBy (xpath= "(//*[text()='Cash On delivery'])[1]")
    public  WebElement paymentDefaultText ; // checkout page

    @FindBy (xpath= "(//*[@class='dropdown'])[2]")
    public  WebElement paymentDefaultThreeDat ; // checkout page

    @FindBy (xpath= "//*[@class='dropdown-item a-12']")
    public  WebElement deleteLinkThreeDat ; // checkout page

    @FindBy (xpath= "//span[normalize-space()='Place Order']")
    public  WebElement placeOrderButtonText ; // checkout page

    @FindBy (xpath= "//h5[@class='m-0 mb-1']")
    public  WebElement confirmingText ; // checkout page

    @FindBy (xpath= "//*[@class='btn btn-green w-100 pointer']")
    public  WebElement placeOrderButton ; // checkout page





}
