package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class MerchantPage {

    public MerchantPage(){ PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(id = "AR_merchant_login_username")
    public WebElement usernametextbox; // merchant login page

    @FindBy(id = "AR_merchant_login_password")
    public WebElement passwordtextbox; // merchant login page

    @FindBy(xpath ="//*[@class='btn btn-green btn-full']")
    public WebElement singinButton; // merchant login page

    @FindBy(xpath = "//a[text()='Dashboard']")
    public WebElement dashboardLink; // merchant sidebar page

    @FindBy(xpath = "//a[text()='Merchant']")
    public WebElement merchantLink; // merchant sidebar page

    @FindBy(xpath = "//a[text()='Information']")
    public WebElement informationLink;// merchant sidebar page
  
    @FindBy(xpath = "//a[text()='Setting']")
    public WebElement settingLink;// merchant sidebar page
  
    @FindBy(xpath = "//a[text()='Order Limit']")
    public WebElement orderLimitLink;// merchant sidebar page
  
    @FindBy(xpath = "//a[text()='Banner']")
    public WebElement bannerLink;// merchant sidebar page
  
    @FindBy(xpath = "//a[text()='Pages']")
    public WebElement pagesLink;// merchant sidebar page
  
    @FindBy(xpath = "//a[text()='Menu']")
    public WebElement menuLink;// merchant sidebar page

    @FindBy(xpath = "//a[text()='Orders']")
    public WebElement ordersLink;// merchant sidebar page

    @FindBy(xpath = "//a[text()='New Orders']")
    public WebElement newOrdersLink;// merchant sidebar page

    @FindBy(xpath = "//a[text()='Orders Processing']")
    public WebElement ordersProcessingLink;

    @FindBy(xpath = "//a[text()='Orders Ready']")
    public WebElement ordersReadyLink;// merchant sidebar page

    @FindBy(xpath = "//a[text()='Completed']")
    public WebElement completedLink;// merchant sidebar page

    @FindBy(xpath = "//a[text()='Scheduled']")
    public WebElement scheduledLink;// merchant sidebar page

    @FindBy(xpath = "//a[text()='All Orders']")
    public WebElement allOrdersLink;// merchant sidebar page

    @FindBy(xpath = "//a[text()='Attributes']")
    public WebElement attributesLink;// merchant sidebar page

    @FindBy(xpath = "//a[text()='Size']")
    public WebElement sizeLink;// merchant sidebar page

    @FindBy(xpath = "//a[text()='Ingredients']")
    public WebElement ingredientsLink;// merchant sidebar page

    @FindBy(xpath = "//a[text()='Cooking Reference']")
    public WebElement cookingReferenceLink;// merchant sidebar page

    @FindBy(xpath = "//a[text()='Food']")
    public WebElement foodLink;// merchant sidebar page

    @FindBy(xpath = "//a[text()='Category']")
    public WebElement categoryLink;// merchant sidebar page

    @FindBy(xpath = "//a[text()='Addon Category']")
    public WebElement addonCategoryLink;// merchant sidebar page

    @FindBy(xpath = "//a[text()='Addon Items']")
    public WebElement addonItemsLink;// merchant sidebar page

    @FindBy(xpath = "//a[text()='Items']")
    public WebElement itemsLink;// merchant sidebar page

    @FindBy(xpath = "//*[text()='Order Type']")
    public WebElement ordertypeLinki; // merchant sidebar page

    @FindBy(xpath = "//*[text()='Delivery']")
    public WebElement deliveryLinki; // merchant sidebar page

    @FindBy(xpath = "//*[text()='Pickup']")
    public WebElement pickupLink; // merchant sidebar page

    @FindBy(xpath = "//*[text()='Dinein']")
    public WebElement dineinLinki; // merchant sidebar page

    @FindBy(xpath = "(//*[text()='Settings'])[5]")
    public WebElement deliverySettingsLinki; // delivery setting page

    @FindBy(xpath = "(//*[text()='Dynamic Rates'])[1]")
    public WebElement dynamicRatesLinki; // delivery setting page

    @FindBy(xpath = "(//*[text()='Delivery Charges Rates'])[3]")
    public WebElement deliverychargesRatesTexti; // delivery setting page

    @FindBy(xpath = "(//*[@type='button'])[5]")
    public WebElement addnewButton; // delivery setting page

    @FindBy(xpath = "(//*[text()='Add Charges Rates'])[2]")
    public WebElement addChargesTexti; // delivery setting page

    @FindBy(xpath = "(//select[@class='form-control custom-select form-control-select'])[1]")
    public WebElement shippingTypeDropdown; // delivery setting page

    @FindBy(xpath = "(//*[@class='form-control form-control-text'])[1]")
    public WebElement fromTextBox; // delivery setting page

    @FindBy(xpath = "(//*[@class='form-control form-control-text'])[2]")
    public WebElement toTextBox; // delivery setting page

    @FindBy(xpath = "(//*[@class='form-control form-control-text'])[3]")
    public WebElement priceTextBox; // delivery setting page

    @FindBy(xpath = "(//*[@class='form-control form-control-text'])[4]")
    public WebElement minimumOrderTextBox; // delivery setting page

    @FindBy(xpath = "(//*[@class='form-control form-control-text'])[5]")
    public WebElement maximumOrderTextBox; // delivery setting page

    @FindBy(xpath = "//*[@class='form-control form-control-text estimation']")
    public WebElement deliveryEstimationTextBox; // delivery setting page

    @FindBy(xpath = "//*[@class='btn btn-green btn-full mt-3']")
    public WebElement settingSaveButton; // delivery setting page
  
    @FindBy(xpath = "//a[text()='Payment gateway']")
    public WebElement paymentGatewayLink;// merchant sidebar page

    @FindBy(xpath = "//*[text()='Bank Deposit']")
    public WebElement bankDepositLink; // merchant sidebar page

    @FindBy(xpath = "//*[text()='All payments']")
    public WebElement allpaymentsLink; // merchant sidebar page

    @FindBy(xpath = "//a[text()='Promo']")
    public WebElement promoLink;// merchant sidebar page

    @FindBy(xpath = "//a[text()='Coupon']")
    public WebElement couponLink;

    @FindBy(xpath = "//a[text()='Images']")
    public WebElement imagesLink;// merchant sidebar page

    @FindBy(xpath = "//a[text()='Gallery']")
    public WebElement galleryLink;// merchant sidebar page

    @FindBy(xpath = "//a[text()='Media Library']")
    public WebElement mediaLibraryLink;// merchant sidebar page

    @FindBy(xpath = "//a[text()='Account']")
    public WebElement accountLink;// merchant sidebar page

    @FindBy(xpath = "//a[text()='Statement']")
    public WebElement statementLink;// merchant sidebar page

    @FindBy(xpath = "//a[text()='Buyers']")
    public WebElement buyersLink;// merchant sidebar page

    @FindBy(xpath = "//a[text()='List']")
    public WebElement listLink;// merchant sidebar page

    @FindBy(xpath = "//a[text()='Reviews']")
    public WebElement reviewsLink;// merchant sidebar page

    @FindBy(xpath = "//a[text()='Users']")
    public WebElement usersLink;// merchant sidebar page

    @FindBy(xpath = "//a[text()='All User']")
    public WebElement allUserLink;// merchant sidebar page

    @FindBy(xpath = "//a[text()='All Roles']")
    public WebElement allRolesLink;// merchant sidebar page

    @FindBy(xpath = "//a[text()='Reports']")
    public WebElement reportsLink;// merchant sidebar page

    @FindBy(xpath = "//a[text()='Sales Report']")
    public WebElement salesReportLink;// merchant sidebar page

    @FindBy(xpath = "//a[text()='Sales Summary']")
    public WebElement salesSummaryLink;// merchant sidebar page

    @FindBy(xpath = "//a[text()='Refund Report']")
    public WebElement refudReporttLink;// merchant sidebar page

    @FindBy(xpath = "//a[text()='Inventory Management']")
    public WebElement inventoryManagementLink; // merchant sidebar page

    @FindBy(xpath = "//a[text()='Suppliers']")
    public WebElement suppliersLink;// merchant sidebar page

    @FindBy( xpath = "(//a[@id='dropdownMenuLink'])[1]")
    public WebElement merchantNamebutton;

    @FindBy(xpath=" (//*[text()=' Profile '])[1]")
    public WebElement profileSection;  // merchant profili
  
    @FindBy(xpath = "//*[@class='mb-4']")
    public WebElement titleOfLoginPage;

    @FindBy(xpath = "(//*[@class='required'])[1]")
    public WebElement backgroundUserBox;

    @FindBy(xpath = "(//*[@class='required'])[3]")
    public WebElement backgroundPassBox;

    @FindBy(xpath = ".//input[starts-with(@class,'form-label-group')]")
    public WebElement textEnteredUserBox;



    @FindBy(xpath = "//*[@type='text']")
    public WebElement passwordReveal;


    @FindBy(xpath = "//*[@type='password']")
    public WebElement passwordHidden;


    @FindBy(xpath = ".//input[starts-with(@class,'form-label-group change_field_password')]")
    public  WebElement passwordFieldPassBox;

    @FindBy(xpath = "//*[@src='/backoffice/themes/classic/assets/images/app-store@2x.png']")
    public WebElement appStoreIcon;

    @FindBy(xpath = "//*[@src='/backoffice/themes/classic/assets/images/google-play@2x.png']")
    public WebElement googlePlayIcon;

    @FindBy(xpath = "//*[@class='dim custom-control-label']")
    public WebElement rememberMeLable;

    @FindBy(xpath = "(//*[@id='dropdownMenuLink'])[1]")
    public WebElement merchantNameDropdown;

    @FindBy(xpath = "(//*[@class='dropdown-item'])[3]")
    public WebElement logoutMerchantDashboard;

    @FindBy(xpath = "//li[@class='merchant_orders']")
    public  WebElement dashboardOrdersIcon;//merhant Page

    @FindBy(xpath = "//a[text()='New Orders']")
    public  WebElement dasboardNewOrdersIcon;//merhant Page

    @FindBy(xpath = "(//p[@class='m-0'])[7]")
    public List<WebElement> orderId1;//merchant_New order page
  
    @FindBy (xpath ="(//p[@class='m-0'])[11]" )
    public List<WebElement> orderId2;

    @FindBy(xpath = " (//p[@class='m-0'])[5]")
    public  WebElement customerName;//merchant_New order page

    @FindBy(xpath = "(//table)[2]/tr[2]/td[1]")
    public  WebElement orderDateAndTime;//merchant_New order page
  
    @FindBy(xpath = "(//h6[@class='m-0'])[2]")
    public  WebElement totalOrderPrice;//merchant_New order page

    @FindBy(xpath = "//span[text()='Accepted']")
    public  WebElement acceptedButton;//merchant_New order page

    @FindBy(xpath = "//span[text()='Reject']")
    public  WebElement rejectButton;//merchant_New order page
  
    @FindBy(xpath = "//a[text()='Out of item(s)']")
    public WebElement outOfItems;//merchant_New order page

    @FindBy(xpath = "(//button[@class='btn btn-green pl-4 pr-4'])[5]")
    public WebElement pupupRejectButton;//merchant_New order page

    @FindBy(xpath = "//div[text()='Accepting Orders']")
    public  WebElement acceptingOrderButton;//merchant_New order page

    @FindBy(xpath = "(//button[text()='5 min(s)'])[2]")
    public  WebElement pauseMinuteOption;//merchant_New order page
  
    @FindBy(xpath = "//span[text()='Next']")
    public  WebElement nextButton;//merchant_New order page
  
    @FindBy(xpath = "//a[text()='Store is too busy']")
    public  WebElement reasonForPausing;//merchant_New order page

    @FindBy(xpath = "//a[@class='btn btn-green small']")
    public  WebElement addButton;
  
    @FindBy(xpath = "(//img[@class='rounded lozad loaded'])[3]")
    public WebElement productTobBeAdded;
  
    @FindBy(xpath = "//span[text()='Add to order - '] ")
    public  WebElement addToOrderButton;
  
    @FindBy(xpath = "//div[text()='Item added to order']")
    public List<WebElement> itemAddedToOrderMessage;

    @FindBy(xpath = "(//a[@id='dropdownMenuLink'])[1]")
    public  WebElement ellipsisIcon;
  
    @FindBy(xpath = "//a[text()='Contact customer']")
    public  WebElement contactCustomer;

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public  WebElement customerNumber;
  
    @FindBy(xpath = "//button[text()='Okay']")
    public  WebElement okeyButton;

    @FindBy(xpath = "//a[text()='Delay Order']")
    public  WebElement delayOrder;

    @FindBy(xpath = "(//span[text()='Confirm'])[2]")
    public  WebElement confirmButton;//merchant_New order page

    @FindBy(xpath = "//*[@class='dim underline']")
    public WebElement forgetMiLink;

    @FindBy(xpath = "//*[@value='Request E-mail']")
    public WebElement RequestEmail;


    @FindBy(xpath = "(//*[@class='errorMessage'])[1]")
    public WebElement user_ThisFieldIsRequired;

    @FindBy(xpath = "(//*[@class='errorMessage'])[1]")
    public WebElement pass_ThisFieldIsRequired;

    @FindBy(xpath = "//*[@class='zmdi-eye zmdi']")
    public WebElement eyeAsignFallDownPosition;

    @FindBy(xpath = "//*[@class='zmdi zmdi-eye']")
    public WebElement eyeAsignInPasswordBox;

    @FindBy(xpath = "//*[@class='zmdi zmdi-eye-off']")
    public  WebElement eyeAsignWithALine;

}
