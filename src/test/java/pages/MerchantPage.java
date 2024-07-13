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

    @FindBy(xpath = "//*[@class='list-unstyled m-0 grey-list-chevron']//li")
    public List<WebElement> orderProcessingList;

    @FindBy(xpath = "//button[text()='Print']")
    public WebElement printButton;

    @FindBy(xpath = "//span[text()='Ready for pickup']")
    public WebElement readyForPickupButton;

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

    @FindBy(xpath = "//a[@type='button']")
    public WebElement couponAddLink;

    @FindBy(xpath = "//tbody/tr/td[2]/h6")
    public List<WebElement> couponNameList;

    @FindBy(xpath = "(//*[@role='group']//a)[1]")
    public WebElement updateCouponButton;

    @FindBy(xpath = "//input[@id='AR_voucher_voucher_name']")
    public WebElement updateCouponName;

    @FindBy(xpath = "//select[@id='AR_voucher_voucher_type']")
    public WebElement updateCouponTypeDropdown;

    @FindBy(xpath = "//*[@id='AR_voucher_amount']")
    public WebElement updateCouponAmount;

    @FindBy(xpath = "//*[@id='AR_voucher_min_order']")
    public WebElement updateMinOrder;

    @FindBy(xpath = "(//*[@class='select2-selection select2-selection--multiple'])[1]")
    public WebElement updateDaysAvailable;

    @FindBy(xpath = "//*[@name='AR_voucher[expiration]']")
    public WebElement updateExpiration;

    @FindBy(xpath = "//*[@name='AR_voucher[used_once]']")
    public WebElement updateCouponOptions;

    @FindBy(xpath = "//*[@name='AR_voucher[status]']")
    public WebElement updateStatus;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement updateSaveButton;

    @FindBy(xpath = "(//*[@role='group']//a)[2]")
    public WebElement deleteCuponButton;

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
    public WebElement pauseNewOrdersMinutes;
  
    @FindBy(xpath = "//span[text()='Next']")
    public  WebElement nextButton;//merchant_New order page
  
    @FindBy(xpath = "//a[text()='Store is too busy']")
    public  WebElement reasonForPausing;//merchant_New order page

    @FindBy(xpath = "(//span[text()='Confirm'])[2]")
    public  WebElement pausingConfirmButton;

    @FindBy(xpath = "//a[@class='btn btn-green small']")
    public  WebElement addButton;
  
    @FindBy(xpath = "(//img[@class='rounded lozad loaded'])[3]")
    public WebElement productTobBeAdded;
  
    @FindBy(xpath = "//span[text()='Add to order - '] ")
    public  WebElement addToOrderButton;
  
    @FindBy(xpath = "//div[text()='Item added to order']")
    public WebElement itemAddedToOrderMessage;

    @FindBy(xpath = "(//a[@id='dropdownMenuLink'])[1]")
    public  WebElement ellipsisIcon;
  
    @FindBy(xpath = "//a[text()='Contact customer']")
    public  WebElement contactCustomer;//merchant_New order page

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public  WebElement customerNumber;//merchant_New order page
  
    @FindBy(xpath = "//button[text()='Oka//merchant_New order pagey']")
    public  WebElement okeyButton;

    @FindBy(xpath = "//a[text()='Delay Order']")
    public  WebElement delayOrder;//merchant_New order page
  
    @FindBy(xpath = "(//button[@class='btn btn-light delay-btn'])[1]")
    public  WebElement pauseMinuteOptionDelay;//merchant_New order page

    @FindBy(xpath = "(//span[text()='Confirm'])[1]")
    public  WebElement confirmButtonDelay;//merchant_New order page
  
    @FindBy(xpath = "(//span[text()='new'])[1]")
    public  WebElement newIcon;//merchant_New order page

    @FindBy(xpath = "//div[@aria-live='polite']")
    public  WebElement delayOrderMesssage;;//merchant_New order page

    @FindBy(xpath = "//div[@class='ronded-green']")
    public  WebElement ordersQuantitty;;//merchant_New order page

    @FindBy(xpath = "//p[text()='No results']")
    public  WebElement noNewOrders;;//merchant_New order page

    @FindBy(xpath = "//*[@class='row align-items-start']")
    public List<WebElement> scheduledOrdersList; // scheduled order page

    @FindBy(xpath = "(//p[@class='m-0'])[5]")
    public WebElement customerNameInOrderDetails; // scheduled order page

    @FindBy(xpath = "(//p[@class='m-0'])[6]")
    public WebElement itemQuantitiyInOrderDetails; // scheduled order page

    @FindBy(xpath = "(//p[@class='m-0'])[7]")
    public WebElement orderNumberInOrderDetails; // scheduled order page

    @FindBy(xpath = "(//p[@class='m-0'])[8]")
    public WebElement orderDatenTimeInOrderDetails; // scheduled order page

    @FindBy(xpath = "//*[@class='form-control py-2 border-right-0 border']")
    public WebElement orderPagefilterBox; // scheduled order page

    @FindBy(xpath = "(//*[@class='filter-option-inner'])[1]")
    public WebElement orderTypeDropdownMenu; // scheduled order page

    @FindBy(xpath = "(//*[@class='filter-option-inner'])[2]")
    public WebElement paymentStatusDropdownMenu; // scheduled order page

    @FindBy(xpath = "(//*[@class='filter-option-inner'])[3]")
    public WebElement sortDropdownMenu; // scheduled order page
  
    @FindBy(xpath = "//a[text()='Cancel order']")
    public  WebElement cancelOrder;;//merchant_New order page

    @FindBy(xpath ="//a[text()='No ingredient.']")
    public WebElement reasonCancel;;//merchant_New order page

    @FindBy(xpath = "//span[text()='Reject order']")
    public  WebElement cancelRejectOrderButton;;//merchant_New order page

    @FindBy(xpath = "//div[@class='notyf-announcer']")
    public  WebElement cancelOrderMessage;;//merchant_New order page

    @FindBy(xpath = "//a[text()='Download PDF (A4)']")
    public  WebElement downloadPdf;;//merchant_New order page

    //@FindBy(xpath = "//input[@type='search']")
    //public  WebElement filterBox; //merchant_New order page

    @FindBy(xpath= "//*[@class='btn btn-black btn-circle']")
    public  WebElement itemsPageAddnewButton;

    @FindBy(id= "AR_item_item_name")
    public  WebElement itemNameTextBox; // Add item page

    @FindBy(id= "AR_item_category_selected")
    public  WebElement categoryDropdown; //Add item page

    @FindBy(xpath= "(//*[@type='submit'])[3]")
    public  WebElement saveButtonAddItem; //Add item page

    @FindBy(xpath= "(//*[@class='zmdi zmdi-delete'])[1]")
    public  WebElement deleteButtonAddItem; // item page

    @FindBy(xpath= "(//*[@class='zmdi zmdi-border-color'])[1]")
    public  WebElement uptadeButtonAddItem; // item page

    @FindBy(xpath= "(//*[text()='Update Item'])[2]")
    public  WebElement uptadeItemTextBox; // Uptade item page

    @FindBy(xpath= "(//*[@class='item-menu'])[1]")
    public  WebElement uptadeItemMenu ; // Uptade item page

    @FindBy(xpath= "//*[@class='zmdi zmdi-money-box']")
    public  WebElement itemPrice ; // Uptade item page

    @FindBy(xpath= "//*[@class='btn btn-light tool_tips']")
    public  WebElement uptadeItemPrice ; // Uptade item page

    @FindBy(xpath= "(//*[@class='form-control form-control-text'])[1]")
    public  WebElement uptadeItemPriceTextBox ; // Uptade item page

    @FindBy(xpath= "(//*[@class='form-control form-control-text'])[1]")
    public  WebElement saveUptadeItem ; // Uptade item page
  
    @FindBy(xpath = "(//div[@class='row align-items-start'])[1]")
    public  List<WebElement> filterResultElementleri;
  
    @FindBy(xpath = "//a[text()='Clear']")
    public  WebElement clearIcon;
  
@FindBy(xpath = "//*[text()='Total Orders']")
    public WebElement totalOrderText;


  
  
  
}
