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
  
    @FindBy(xpath = "(//a[text()='Settings'])[1]")
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

    @FindBy(xpath = "//tr//td[2]")
    public  List<WebElement> allOrdersIdList;

    @FindBy(xpath = "(//*[@class='zmdi zmdi-eye'])[1]")
    public WebElement allOrdersPageFirstViewButton;

    @FindBy(xpath = "(//*[@class='zmdi zmdi-download'])[1]")
    public WebElement allOrdersPageFirstDownloadButton;

    @FindBy(xpath = "//*[@class='input-group fixed-width-field mr-2']")
    public WebElement allOrdersPageDateBanner;

    @FindBy(xpath = "//a[text()='Attributes']")
    public WebElement attributesLink;// merchant sidebar page

    @FindBy(xpath = "//a[text()='Size']")
    public WebElement sizeLink;// merchant sidebar page

    @FindBy(xpath = "//a[text()='Ingredients']")
    public WebElement ingredientsLink;// merchant sidebar page

    @FindBy(xpath = "//a[text()='Cooking Reference ']")
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

    @FindBy(xpath = "//*[@type='search']")
    public WebElement couponSearchBox;

    @FindBy(xpath = "//tbody/tr/td[1]")
    public List<WebElement> couponNumberList;

    @FindBy(xpath = "//tbody/tr/td[3]")
    public List<WebElement> couponUsedList;

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

    @FindBy(xpath = "//*[@id='AR_voucher_expiration']")
    public WebElement updateExpiration;

    @FindBy(xpath = "//*[@name='AR_voucher[used_once]']")
    public WebElement updateCouponOptions;

    @FindBy(xpath = "//*[@name='AR_voucher[status]']")
    public WebElement updateStatus;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement updateSaveButton;

    @FindBy(xpath = "(//*[@role='group']//a)[2]")
    public WebElement deleteCouponButton;

    @FindBy (xpath = "(//th[@aria-controls='DataTables_Table_0'])[1]")
    public WebElement couponNumberSortLink;

    @FindBy (xpath = "(//th[@aria-controls='DataTables_Table_0'])[2]")
    public WebElement couponNameSortLink;

    @FindBy (xpath = "(//th[@aria-controls='DataTables_Table_0'])[3]")
    public WebElement couponUsedSortLink;

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

    @FindBy(xpath = "(//a[text()='List'])[3]")
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

    @FindBy(xpath = "//input[@type='search']")
    public  WebElement filterBox; //merchant_New order page

    @FindBy(xpath= "//*[@class='btn btn-black btn-circle']")
    public  WebElement itemsPageAddnewButton;

    @FindBy(id= "AR_item_item_name")
    public  WebElement itemNameTextBox; // Add item page

    @FindBy(xpath = "//h6[@class='m-0 position-relative']")
    public List<WebElement> weeklyIncomeIntList;

    @FindBy(xpath = "//*[@class='m-0 text-muted font-weight-normal']")
    public List<WebElement>  weeklyIncomeTextList;

    @FindBy(xpath = "//*[@class='zmdi zmdi-money']")
    public WebElement weeklyIconeYourBalance;

    @FindBy(xpath = "//*[@class='zmdi zmdi-money-box']")
    public List<WebElement>  weeklyIncomeIconeList;
    @FindBy(xpath = "//*[@class='col p-0 col-lg-3 col-md-3 col-sm-6 col-6 mb-3 mb-xl-0']") //index = 0-3  pictures up the merchantPage
    public List<WebElement> listOfTopPictures;

    @FindBy(xpath = "//*[@class='text-muted font-weight-500']")
    public  List<WebElement>    lastOrdersRowNumber;
    @FindBy(xpath = "//h5")
    public List<WebElement> topPicTextList;


    @FindBy(xpath = "//*[@class='text-muted']")
    public List<WebElement> sixRightColumnList;
    @FindBy(xpath = "//*[@class='font-weight-bold hover-text-primary mb-1']")
    public List<WebElement> orderNumberList;        //order numbers in last orders ( index = 0 - 4  )
                                               //Top Costomers / Name of customers  (index = 10 - 14 )
                                                  // Popular Items / name Of foods  ( index = 5 - 9 )
    @FindBy(xpath = "//*[@class='w-100 btn btn-lg btn-info waves-effect waves-light mb-3']")
    public List<WebElement> buttonList;
    @FindBy(xpath = "//p")   //index = 13-17  TopCostomers/numberOfOrders
    public List<WebElement> topPicIntList;
    @FindBy(xpath = "//*[@class='text-right align-middle']")
    public List<WebElement> sc_Th_FrColumnForAll;
    @FindBy(xpath = "//*[@class='flex-col']")  //index = 36-40 TopCustumers/pictures
    public List<WebElement> descriptionOfTopCustumers;
    @FindBy(xpath = "//*[text()='Customer list']")
    public List<WebElement> custumerList;

    @FindBy(xpath = "//*[@class='w-100 btn btn-lg btn-info waves-effect waves-light mb-3']")
    public List<WebElement> checkout_AllCostumers;
    @FindBy(xpath = "//*[@class='mr-3']")
    public List<WebElement> picturesOfTopCostumers;
    @FindBy(xpath = "//*[@class='mr-2']")
    public List<WebElement> signalList;
    @FindBy(xpath = "//*[@class='pl-0 align-middle']")
    public List<WebElement> firstColumnOfAll;
    @FindBy(xpath = "//*[@class='badge payment unpaid']")
    public List<WebElement> secoundColumnOfProgress;
    @FindBy(xpath = "//*[@class='text-muted font-weight-500']")
    public List<WebElement> thirdColumnOfProgress;
    @FindBy(xpath = "//*[@class='badge order_status accepted']")
    public List<WebElement> forthColumnOfProgress;
    @FindBy(xpath = "//*[@class='nav-item']")//0-5
    public List<WebElement> topItemsList;
    @FindBy(xpath = "//*[@class='font-weight-bold d-block']")
    public List<WebElement> secoundIntReady;
    @FindBy(xpath = "//*[@class='badge payment unpaid']")
    public List<WebElement> secoundStringReady;
    @FindBy(xpath = "//*[@class=\"active nav-link py-1 px-3']")
    public List<WebElement> pLinks;
    @FindBy(xpath = "//*[@class='zmdi zmdi-eye']")
    public List<WebElement> fifthColumnOfAll;

    @FindBy(xpath = "//*[@class='d-flex']") // index= 30-38
    public List<WebElement> foodsNameOf30Days;

    @FindBy(xpath = "//*[@class='zmdi zmdi-download']")
    public List<WebElement> sixthColumnOfAll;
    @FindBy(xpath = "//*[@class='font-weight-bold hover-text-primary mb-1']")
    public List<WebElement> ordersAndNamesList;

   @FindBy(xpath = "//*[@class='mr-1 w-25']")// index = 0 - 8
   public List<WebElement> dataOf30Days;

    @FindBy(xpath = "//tbody/tr")
    public List<WebElement> rowNumberOfTable;

    @FindBy(xpath = "//*[@class='m-0 text-secondary']")
    public List<WebElement> fourHouseTextList;

    @FindBy(xpath = "//h2")
    public WebElement overViewNumber;
@FindBy(xpath = "//*[@class='font-weight-bold hover-text-primary mb-1']")
public  List<WebElement>  firstOrderNumber;
    @FindBy(xpath = "//h3")
    public List<WebElement> fourHouseIntList;
    @FindBy(xpath = "//h5[@class='m-0']")
    public List<WebElement> listOfLastOrders_30Days;
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

    @FindBy(xpath = "//*[@class='flex-col d-none d-lg-block']")
    public WebElement scheduledOrdersLeftHeader; // scheduled order page

    @FindBy(xpath = "(//*[text()='How to manage orders'])[1]")
    public WebElement howToManageOrdersLink;  // scheduled order page

    @FindBy(xpath = "(//*[@class='btn btn-green'])[1]")
    public WebElement acceptingOrdersButton; // scheduled order page

    @FindBy(xpath = "//*[@class='zmdi zmdi-notifications-none']")
    public WebElement notificationsButton; // scheduled order page

    @FindBy(xpath = "//*[@class='font13 m-0 badge']")
    public WebElement orderStatus; // scheduled order page

    @FindBy(xpath = "//textarea[@class='form-control form-control-text']")
    public WebElement rejectReasonTextBox; // scheduled order reject page

    @FindBy(xpath = "(//*[@class='list-group list-group-flush'])[1]")
    public WebElement rejectReasonPickArea; //  scheduled order reject page

    @FindBy(xpath = "//*[text()='Out of item(s)']")
    public WebElement rejectReason; // scheduled order reject page

    @FindBy(xpath = "//*[text()='Reject order']")
    public WebElement rejectOrderButton; //  scheduled order reject page

    @FindBy(xpath = "//*[@class='mb-1']")
    public WebElement productNameOrderSummary; //  scheduled order page

    @FindBy(xpath = "//*[@class='m-0 font11']")
    public WebElement productPriceOrderSummary; //  scheduled order page

    @FindBy(xpath = "(//*[@class='col-6 d-flex justify-content-start flex-column'])[2]")
    public WebElement subTotalQuantityOrderSummary; // scheduled order page

    @FindBy(xpath = "(//*[@class='col-3 d-flex justify-content-start flex-column text-right'])[2]")
    public WebElement subTotalPriceOrderSummary; // scheduled order page

    @FindBy(xpath = "//*[@class='rounded-pill rounded-button-icon d-inline-block']")
    public WebElement moreOptionsDropdownButton; //  scheduled order page

    @FindBy(xpath = "//*[@class='dropdown-menu show']")
    public WebElement moreOptionsDropdownMenu; //  scheduled order page



    @FindBy(xpath = "//a[text()='Completed']")
    public WebElement ordersCompletedLink;

    @FindBy(xpath = "//*[@class='flex-col d-none d-lg-block']")
    public WebElement orderHeaderText;    //   Orders completed as of today ..

    @FindBy(xpath = "//*[@class='ronded-green']")
    public WebElement orderCount;

    @FindBy(xpath = "//*[@class='ml-2 badge services']")
    public WebElement deliveryType;

    @FindBy(xpath = "//*[@class='ml-2 badge']")
    public WebElement typeCompleted;

    @FindBy(xpath = " //*[@class='row align-items-start']")
    public WebElement leftOrderTable;

    @FindBy(xpath = " //*[@class='m-0 link font12']")
    public WebElement orderClearButton;


    @FindBy(xpath = "(//*[@class='text'])[1]")
    public WebElement orderDeliveryTypeList;


    @FindBy(xpath = "(//*[@class='text'])[4]")
    public WebElement orderPaidTypeList;

    @FindBy(xpath = "//*[@class='card-body']")
    public WebElement orderSummaryBody;

    @FindBy(xpath = "//*[@class='col-md-5']")
    public WebElement orderView;

    @FindBy (xpath = "//*[@class='make-sticky d-flex align-items-center justify-content-between bg-white']")
    public  WebElement ordersReadyList;

    @FindBy(xpath = "//*[@class='btn-green btn normal mr-2 font13 mb-3 mb-xl-0']")
    public WebElement deliveryOnThisWaybuttonOrderReadyPage;

    @FindBy(xpath = "//*[@class='btn-yellow btn normal mr-2 font13 mb-3 mb-xl-0']")
    public WebElement deliveredButtonOrdersReadyPage;

    @FindBy(xpath = "//*[@class='btn-black btn normal mr-2 font13 mb-3 mb-xl-0']")
    public WebElement deliveryFailedButtonOrdersReadyPage;

    @FindBy(xpath = "//*[@class='btn-green btn normal mr-2 font13 mb-3 mb-xl-0']")
    public WebElement completeOrdersReadyPage;

    @FindBy(xpath = "//*[@class='btn-black btn normal mr-2 font13 mb-3 mb-xl-0']")
    public WebElement orderFailedOrdersReadyPage;

    @FindBy(xpath = "//*[@class='btn btn-primary']")
    public WebElement assingDriverOrdersReadyPage;

    @FindBy(xpath="(//*[@class='dropdown-item'])[14]")
    public WebElement roundedDelayOrder;   // Orders Ready Rounded Button (... button)

    @FindBy(xpath = "(//*[text()='5 min(s)'])[1]")
    public WebElement delayOrderMinute;

    @FindBy(xpath = "(//*[@class=\"btn btn-green pl-4 pr-4\"])[1]")
    public  WebElement delayOrderConfirm;

    @FindBy (xpath = "//*[text()='Customer is notified about the delayed.']")
    public WebElement delayOrdermessageMinute;

    @FindBy (xpath = "(//*[text()='30 min(s)'])[2]")
    public WebElement pauseNewOrders30Minutes;

    @FindBy(xpath = "(//button[@class='btn btn-green pl-4 pr-4'])[3]")
    public WebElement pauseNewOrdersNextMinuteButton;

    @FindBy(xpath = "//*[text()='Store closed']")
    public WebElement pauseReasonforPausing;

    @FindBy(xpath = "(//*[text()='Confirm'])[2]")
    public WebElement pauseAcceptingOrdersConfirm;


    @FindBy(xpath = "//*[text()='Get direction']")
    public WebElement getDirectionsButton;


    @FindBy(xpath = "(//*[@class=\"tactile-searchbox-input\"])[1]")
    public WebElement getDirectionsStart;


    @FindBy (xpath = "//*[@class=\"link\"]")
    public WebElement orderPreviusButton;

    @FindBy (xpath = "(//*[text()='Inci Lale Basbostanci'])[3]")
    public WebElement customerInfo;

    @FindBy(xpath = "//*[@class='table table-sm w-100 order_table dataTable no-footer']")
    public List<WebElement> previusOrderPage;

    @FindBy(xpath = "(//*[text()='Next'])[3]")
    public WebElement previusOrderPageNextButton;

    @FindBy(xpath = "(//*[text()='Previous'])[2]")
    public WebElement previusOrderPagePreviousButton;


    @FindBy(xpath = "(//*[@class=\"d-flex align-items-center\"])[16]")
    public  WebElement blockCustomer;

    @FindBy(xpath = "//*[text()='Block Customer']")
    public  WebElement unBlockCustomer;

    @FindBy(xpath = "(//*[text()='Confirm'])[5]")
    public WebElement blockCustomerConfirm;

    @FindBy(xpath = "//*[@class=\"form-control form-control-sm\"]")
    public WebElement previousOrderPageSearchBox;




    @FindBy(xpath = "//*[@class='chevron selected']")
    public WebElement siparisListesi;

    @FindBy(xpath = "(//*[text()='Dinein'])[3]")
    public WebElement orderTypeDineinButton;

    @FindBy(xpath = "(//*[text()='Paid'])[2]")
    public WebElement paymentStatusPaidButton;

    @FindBy(xpath = "(//*[text()='Order ID - Ascending'])[2]")
    public WebElement sortIDArtanAscending;

    @FindBy(xpath = "//*[text()='View all']")
    public WebElement notificationList;


    @FindBy(xpath = "//*[text()='Date']")
    public WebElement allNotificationsList;

    @FindBy(xpath = "//*[@class=\"badge rounded-circle badge-danger count\"]")
    public WebElement notificationListCount;

    @FindBy(xpath = "//*[@class='row align-items-start']")
    public List<WebElement>  newOrdersList;




    @FindBy(xpath = " //*[@class='m-0 pb-2']")
    public WebElement assignDriverField;

    @FindBy(xpath = "  (//*[@class='col-6 d-flex justify-content-start flex-column'])[4]")
    public WebElement serviceFeeField;

    @FindBy(xpath = "  (//*[@class='col-6 d-flex justify-content-start flex-column'])[5]")
    public WebElement deliveryFeeField;

    @FindBy(xpath = "//*[@class='table table-bordered']")
    public WebElement tableOrderPayment;

    @FindBy(xpath = "//*[@class='table table-bordered']/tr")
    public List<WebElement>  tableOrderPaymentCount;

    @FindBy(xpath = "(//*[@class='btn btn-green'])[2]")
    public WebElement printOrdersAccept;

    @FindBy(xpath = "(//*[@class='btn btn-black'])[4]")
    public WebElement printOrdersCancel;

    @FindBy(xpath = " (//*[@class='close'])[13]")
    public WebElement printOrdersClose;


    @FindBy(xpath = "//*[@class='font13 m-0 badge'] ")  //     //*[@class='row mt-3']
    public WebElement checkOrderType;

    @FindBy(xpath = "//*[@class='ml-2 badge services']")
    public List<WebElement> deliveryType2;
    @FindBy(xpath = "//p[text()='No results']")
    public WebElement noResultText;

    @FindBy(xpath = "//*[@id=\"yw2\"]/li[2]/ul/li/a")
    public List<WebElement> merchantMenuList;

    @FindBy(xpath = "//*[@id=\"vue-merchant-signup\"]/div[1]/h3")
    public WebElement merchantBecameYazi ;

    @FindBy(id = "AR_category_category_description")
    public WebElement descriptionTextbox; //category name textbox

    @FindBy(xpath ="//*[@class='btn btn-info']")
    public WebElement imageButton; //image select button

    @FindBy(xpath ="//*[@src='https://qa.flavorfetch.com/backoffice/../upload/289/f17cb65b-381f-11ef-82f4-6daf2ac24f44.jpg']")
    public WebElement imageSelect; //image select button

    @FindBy(xpath ="//span[text()='Add Files']")
    public WebElement addImageButton; //image add button

    @FindBy(xpath = "//*[@class='food']")
    public WebElement foodDropdownMenu; //food dropdown menu

    @FindBy(xpath = "//*[@class='position-relative food_category']")
    public WebElement category; //category page

    @FindBy(xpath = "//*[@class='btn btn-black btn-circle']")
    public WebElement categoryAddButton; //category add button

    @FindBy(id = "AR_category_category_name")
    public WebElement categoryNameTextbox; //category name textbox

    @FindBy(xpath ="//*[@class='zmdi zmdi-border-color']")
    public WebElement editButton; //category edit button

    @FindBy(xpath ="//*[@class='zmdi zmdi-delete']")
    public WebElement deleteButton; //category delete button

    @FindBy(xpath ="//a[text()='\n" +
            "         Delete         ']")
    public WebElement selectDelete; //select category delete

    @FindBy(xpath = "//*[@class='attributes']")
    public WebElement attributesDropdownMenu; //attributes dropdown menu

    @FindBy(xpath = "//*[@class='position-relative attrmerchant_size_list']")
    public WebElement sizePage; //size page

    @FindBy(xpath = "//*[@class='btn btn-black btn-circle']")
    public WebElement sizeAddButton; //size add button

    @FindBy(id = "AR_size_size_name")
    public WebElement sizeNameTextbox; //size name textbox

}
