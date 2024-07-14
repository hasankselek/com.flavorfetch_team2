package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AdminPage {

    public AdminPage(){

        PageFactory.initElements(Driver.getDriver(),this);


    }

    @FindBy (xpath = "//*[@id='LoginForm_username']")
    public WebElement userNameButton;

    @FindBy (xpath = "//*[@for='LoginForm_password']")
    public WebElement passwordButton;

    @FindBy (xpath= "//*[text()='Remember me']")
    public WebElement remembermeBox;
  
    @FindBy( xpath = "//*[@class=\"btn btn-green btn-full\"]")
    public WebElement signInButton;

    @FindBy(xpath = "//*[@class='dim underline']")
    public WebElement forgotPassword;

    @FindBy(xpath = "//*[@title='Preview store']")
    public WebElement previewStoreButton; // admin dashboard computer icon

    @FindBy(xpath = "//*[@class='img-40 rounded-circle']")
    public WebElement adminPicture; // admin dashboard admin profile picture

    @FindBy(xpath = "//*[@class='dropdown userprofile']")
    public WebElement userprofileName; // admin dashboard admin profile name

    @FindBy(xpath = "//*[@class='zmdi zmdi-notifications-none']")
    public WebElement notificationsIcon; // admin dashboard notifications icon

    @FindBy(xpath = "(//*[@class='dropdown-item'])[1]")
    public WebElement profileText; // admin dashboard dropdown menü profile text

    @FindBy(xpath = "(//*[@class='dropdown-item'])[2]")
    public WebElement logoutText; // admin dashboard dropdown menü logout text

    @FindBy(xpath = "//*[text()='Notification']")
    public WebElement notificationsText; // admin dashboard notifications text

    @FindBy(xpath = "//*[@class='badge rounded-circle badge-green badge-25']")
    public WebElement notificationsQuantityText; // admin dashboard notificationsQuantity text

    @FindBy(xpath = "//a[@class='']")
    public List<WebElement> notificationsQuantity; // admin dashboard all notifications

    @FindBy(xpath = "//*[text()='Clear all']")
    public WebElement clearAllButton; // admin dashboard notifications clear all button

    @FindBy(xpath = "//*[@class='text-primary']")
    public WebElement viewAllButton; // admin dashboard view all button

    @FindBy(xpath = "//*[@class='none-notification text-center']")
    public WebElement emptyNotifications; // admin dashboard empty notifications text

    @FindBy(xpath = "//*[@class='report-inner']")
    public List<WebElement> dashboardTotalHeadings; // admin dashboard total headings

    @FindBy(xpath = "//*[@class='m-0 text-muted font-weight-normal']")
    public List<WebElement> weeklyAndMonthlyInformations; // admin dashboard weekly and monthly information

    @FindBy(xpath = "//*[@class='nav-item']")
    public List<WebElement> orderStatus; // admin dashboard order information

    @FindBy(xpath = "//*[@class='badge order_status accepted']")
    public List<WebElement> acceptedStatus;

    @FindBy(xpath = "//*[@class='badge order_status ready_for_pickup']")
    public List<WebElement> readyForPickupStatus;

    @FindBy(xpath = "//*[@class='badge order_status delivered']")
    public List<WebElement> deliveredStatus;

    @FindBy(xpath = "(//*[@class='col'])[2]")
    public WebElement popularItemsTitle;

    @FindBy(xpath = "//*[text()='Popular items']")
    public WebElement popularItemsButton;

    @FindBy(xpath = "(//li[@class='nav-item'])[6]")
    public WebElement Last30daysSalesButton;

    @FindBy(xpath = "(//tbody)[3]//tr")
    public List<WebElement> popularItemsInformation;

    @FindBy(xpath ="(//*[@class='card-body'])[9]")
    public WebElement last30DaysSalesChartandProducts;

    @FindBy(xpath = "//*[@class='highcharts-background']")
    public WebElement salesOverviewGraph;

    @FindBy(xpath = "(//*[@class='col'])[4]")
    public WebElement popularMerchantsAndReviewTitle;

    @FindBy(xpath = "//*[text()='Popular merchants']")
    public WebElement popularMerchantsButton;

    @FindBy(xpath = "//*[text()='Popular by review']")
    public WebElement popularByReviewButton;

    @FindBy(xpath = "//*[@class='flex-col w-70 text-truncate cuisine-truncate']")
    public List<WebElement> popularMerchantsInformation;

    @FindBy(xpath = "//*[@class='text-right align-middle']")
    public List<WebElement> popularMerchantsQuantity;

    @FindBy(xpath = "(//tbody)[4]//tr")
    public List<WebElement> merchantName;

    @FindBy(xpath = "(//tbody)[4]")
    public WebElement popularByReviewTable;

    @FindBy(xpath = "//*[text()='Top Customers']")
    public WebElement topCustomersText;

    @FindBy(xpath = "(//a[@href='javascript:;'])[13]")
    public WebElement firstCustomerButton;

    @FindBy(xpath = "(//*[@class='modal-header'])[1]")
    public WebElement customerIDText;

    @FindBy(xpath = "(//*[@class='col-2 pr-1'])")
    public List<WebElement> customerPageAltBasliklar;

    @FindBy(xpath = "//*[@class='card rounded p-2 mb-3']")
    public WebElement adminCustomerInfo; // admin dashboard customer info

    @FindBy(xpath = "//h6[text()='Addresses']")
    public WebElement AddresesText; // admin dashboard customer adresses text

    @FindBy(xpath = "//*[@class='card rounded p-2 fixed-height40 scrollable']")
    public WebElement addressesBox; // admin dashboard customer adresses

    @FindBy(xpath = "//thead//tr//td")
    public List<WebElement> sortingTitles; // admin dashboard sorting titles

    @FindBy(xpath = "(//*[@class='zmdi zmdi-eye'])[6]")
    public WebElement eyeSignAdmin; // admin dashboard eye sign

    @FindBy(xpath = "(//*[@class='zmdi zmdi-download'])[6]")
    public WebElement downloadButtonAdmin; // admin dashboard download button

    @FindBy(xpath = "(//tbody)[2]//tr[1]//td[1]")
    public WebElement orderFirstID; // admin dashboard orderFirstID

    @FindBy(xpath = "//*[@class='sorting_1']")
    public List<WebElement> firstPageOrderQuantity; // admin dashboard customer page first page order quantity

    @FindBy(xpath = "//*[@class='dataTables_info']")
    public WebElement entriesInformation; // admin dashboard customer page entries information number

    @FindBy(xpath = "//*[@class='page-link']")
    public List<WebElement> customerPagePageNumbers;

    @FindBy(xpath = "//*[text()='Search:']")
    public WebElement customerPageSearchText;

    @FindBy(xpath = "//*[@class='form-control form-control-sm']")
    public WebElement customerPageSearchBox;
  
    @FindBy(xpath = "//*[@class='promo']")
    public  WebElement promoAdmin; // admin dashboard promo

    @FindBy(xpath = "//*[text()='Coupon']")
    public WebElement couponAdmin; // admin dashboard  coupon

    @FindBy(xpath = "//*[@class=\"btn btn-black btn-circle\"]")
    public WebElement newCouponButton;

    @FindBy (xpath = "//*[@id=\"AR_voucher_voucher_name\"]")
    public WebElement couponName;  // coupon name

    @FindBy(xpath = "(//select[@class=\"form-control custom-select form-control-select\"])[1]")
    public WebElement couponType; // coupon type

    @FindBy (xpath = "//*[@id=\"AR_voucher_amount\"]")
    public WebElement couponAmount;  // admin coupon discount amount

    @FindBy(xpath = "//*[@id=\"AR_voucher_min_order\"]")
    public WebElement couponMinOrder;  // Minimum Order

    @FindBy(xpath = "//select[@name=\"AR_voucher[days_available][]\"]")
    public WebElement couponDay; // Coupon Days

    @FindBy (xpath = "(//*[@class='selection'])[2]")
    public WebElement couponMerchant;    // merchant where the coupon applies

    @FindBy(xpath = "//*[@id='AR_voucher_used_once']")
    public WebElement couponOptions;   // coupon options

    @FindBy(xpath = "//*[@id='AR_voucher_status']")
    public WebElement copuponStatus;    // coupon status

    @FindBy(xpath = "//*[@class='btn btn-green btn-full mt-3']")
    public WebElement couponSaved;      // coupon saved

    @FindBy(xpath = "//*[@class='promo']")
    public  WebElement adminPromo;
  
    @FindBy(xpath = "//a[text()='Orders']")
    public  WebElement dasboardOrders;
  
    @FindBy(xpath = "//a[text()='All order']")
    public  WebElement dashboardAllOrders;

    @FindBy(xpath = "//i[@class='zmdi zmdi-desktop-mac']")
    public WebElement desktopImages;//admin_allOrders
  
    @FindBy(xpath = "//button[@class='ml-2 btn btn-yellow normal']")
    public  WebElement filterButton;//admin_allOrders

    @FindBy(xpath = "(//span[@class='select2-selection select2-selection--single'])[2]")
    public WebElement filtersByCustomerBox;

    @FindBy(xpath = "(//li[@role='option'])[2]")
    public WebElement customerNameOption;
  
    @FindBy(xpath = "//button[text()='Apply Filters']")
    public WebElement applyFiltersButton;
  
    @FindBy(xpath = "//tbody/tr/td[5]")
    public List<WebElement> elementsOfTheThirdColumn;
  
    @FindBy(xpath = "(//span[@role='combobox'])[3]")
    public WebElement filtersByStatusBox;
  
    @FindBy(xpath = "//li[text()='complete']")
    public WebElement byStatusOption;
  
    @FindBy(xpath = "//tbody/tr/td[2]/span[text()='complete']")
    public List<WebElement> elementsOfTheSecondColumnByStatus;//By status
  
    @FindBy(xpath = "(//span[@role='combobox'])[4]")
    public  WebElement filtersByOrderTypeBox;
  
    @FindBy(xpath = "//li[text()='Delivery']")
    public WebElement byOrderTypeOption;
  
    @FindBy(xpath = "//tbody/tr/td[2]//span[@class='ml-2 services badge delivery']")
    public List<WebElement> elementsOfTheSecondColumnByOrderType;

    @FindBy(xpath = "(//span[@role='combobox'])[1]")
    public  WebElement filtersByMerchantBox;
  
    @FindBy(xpath = "//input[@role='searchbox']")
    public WebElement nameBoxBelowByMerchant;
  
    @FindBy(xpath = "//li[text()='Dolan Uyghur Restaurant']")
    public  WebElement byMerchantOption;
  
    @FindBy(xpath = "//tbody/tr/td[4]")
    public List<WebElement>elementsOfTheFourthColumnByMerchant;
  
    @FindBy(xpath = "//p[text()='Orders']")
    public WebElement ordersIcon;
  
    @FindBy(xpath = "//h5[text()='496']")
    public  WebElement ordersNumber;
  
    @FindBy(xpath = "//p[text()='Cancel']")
    public WebElement cancelIcon;

    @FindBy(xpath = "//h5[text()='43']")
    public  WebElement cancelNumber;
  
    @FindBy(xpath = "//p[text()='Total refund']")
    public WebElement totalRefundIcon;
  
    @FindBy(xpath = "//h5[text()='$2340.75']")
    public WebElement totalRefunQuantity;
  
    @FindBy(xpath = "//p[text()='Total Orders']")
    public  WebElement totalOrdersIcon;
  
    @FindBy(xpath = "//h5[text()='$12619.34']")
    public  WebElement totalOrdersQuantity;
  
    @FindBy(xpath = "//input[@placeholder='Start date -- End date']")
    public WebElement dateRangeBox;
  
    @FindBy(xpath = "(//thead)[2]/tr/th[2]")
    public WebElement dateRangeBoxBackIcon;
  
    @FindBy(xpath = "(//tbody)[2]//tr[4]/td[5]")
    public WebElement startDateOption;
  
    @FindBy(xpath = "(//tbody)[2]//tr[4]/td[6]")
    public  WebElement endDateOption;

    @FindBy(xpath = "//tbody/tr/td[2]/p[@class='dim m-0'][4]")
    public  List<WebElement> dateRangeResult;
  
    @FindBy(xpath = "//table/thead/tr/th[3]")
    public WebElement orderIdIcon;
  
    @FindBy(xpath = "//tbody/tr/td[3]")
    public List<WebElement> orderIdColumn;

    @FindBy(xpath = "(//*[text()='Block Customer'])")
    public WebElement blockCustomerButton; // admin dashboard customer special page block customer button

    @FindBy(xpath = "//a[contains(@class,'w-100 btn')]")
    public WebElement checkoutAllReviewsButton; // admin dashboard Checout All Reviews button

    @FindBy(xpath = "(//*[text()='Confirm'])")
    public WebElement alertConfirmButton; // admin dashboard customer special page block customer confirm button

    @FindBy(xpath = "//div[text()='Unblock Customer']")
    public WebElement unBlockCustomerButton; // admin dashboard customer special page unblock customer button

    @FindBy(xpath = "(//div[@class='card-body'])[13]")
    public WebElement overviewOfReviewTable; // admin dashboard overview of review table

    @FindBy(xpath = "(//div[@class='card-body'])[14]")
    public WebElement recentPayoutTable; // admin dashboard recent payout table

    @FindBy(xpath = "//a[normalize-space()='Earnings']")
    public WebElement adminDashboardEarningsButton;

    @FindBy(xpath = "//a[normalize-space()='Merchant Earnings']")
    public WebElement adminDashboardMerchantEarningsButton;

    @FindBy(xpath = "//*[text()='Search:']")
    public WebElement merchantEarringPageSearchText;

    @FindBy(xpath = "//*[@class='form-control form-control-sm']")
    public WebElement merchantEarringPageSearchBox;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> merchantEarringProducts;

    @FindBy(xpath = "//*[@class='bg-light p-4 mb-3 rounded']")
    public List<WebElement> merchantEarringTotalHeadings;

    @FindBy(xpath = "//th[@aria-label='Merchant: activate to sort column ascending']")
    public WebElement merchantEarringMerchantTitle;

    @FindBy(xpath = "//th[@aria-label='Balance: activate to sort column ascending']")
    public WebElement merchantEarringBalanceTitle;

    @FindBy(xpath = "//th[@aria-label='Actions']")
    public WebElement merchantEarringActionTitle;

    @FindBy(xpath = "//tbody//tr//td[2]")
    public List<WebElement> merchantEarringMerchantList;

    @FindBy(xpath = "(//tr//th[2])[1]")
    public WebElement merchantSortingButton;

    @FindBy(xpath = "//*[@class='page-link']")
    public List<WebElement> pageLinks;

    @FindBy(xpath = "//tbody//tr//td[3]")
    public List<WebElement> merchantEarringBalanceList;

    @FindBy(xpath = "(//tr//th[3])[1]")
    public WebElement balanceSortingButton;
  
    @FindBy(xpath = "//*[text()=\"Buyers\"]")
    public WebElement buyersButton; //admin dashboard menu buyers
 
    @FindBy(xpath = "//*[text()='Customers']")
    public WebElement customersButton; // admin dashboard menu customers

    @FindBy(xpath = "//*[text()='Reviews']")
    public WebElement reviewsButton; // dashboard menu under buyers

    @FindBy(xpath = "(//*[text()='Customer list'])[1]")
    public WebElement customerListPage;  //Custormer list page

    @FindBy(xpath = "//tbody//tr//td//h6")
    public WebElement sortingCustomerName; //sorting desc customername

    @FindBy(xpath = "//*[@class='zmdi zmdi-plus']")
    public WebElement addNewCustomerButton;  // Add customer button on customer list

    @FindBy(xpath = "//*[@for='AR_client_first_name']")
    public WebElement firstNamebutton; // on add customer page

    @FindBy(xpath = "//*[@for='AR_client_last_name']")
    public WebElement lastNamebutton; // on add customer page

    @FindBy(xpath = "//*[@for='AR_client_email_address']")
    public WebElement emailNameButton; // on add customer page

    @FindBy(xpath = "//*[@for='AR_client_npassword']")
    public WebElement clientPasswordButton; // on add customer page

    @FindBy(xpath = "//*[@for='AR_client_cpassword']")
    public WebElement confirmPasswordButton; // on add customer page

    @FindBy(xpath = "//*[@for='AR_client_contact_phone']")
    public WebElement contactPhone; // on add customer page

    @FindBy(xpath = "//*[@class='btn btn-info']")
    public WebElement browseButton; // on add customer page

    @FindBy(xpath = "//*[@class='nav-link']")
    public WebElement uploadNew; // in browse button on add customer page

    @FindBy(xpath = "//*[@class='btn btn-green fileinput-button dz-clickable']")
    public WebElement selectFilesButton;  // in browse button on add customer page

    @FindBy(xpath = "//button[@id='dropdownMenuButton']")
    public WebElement createTransactionButton; // admin merchant earrings create a transaction button

    @FindBy(xpath = "//a[normalize-space()='Adjustment']")
    public WebElement adjustmentButton; // admin merchant earrings create a transaction-adjustment button

    @FindBy(xpath = "//span[@role='combobox']")
    public WebElement merchantFinder; // admin merchant earrings create a transaction-adjustment-merchants

    @FindBy(xpath = "//li[@class='select2-results__option select2-results__option--selectable']")
    public List<WebElement> merchantList;

    @FindBy(xpath = "//label[@for='transaction_description']")
    public WebElement transactionDescriptionText;

    @FindBy(id = "transaction_description")
    public WebElement transactionDescriptionBox;

    @FindBy(xpath = "//select[@class='form-control custom-select form-control-select mb-3']")
    public WebElement payType;

    @FindBy(xpath = "//*[text()='Amount']")
    public WebElement amountText;

    @FindBy(id = "transaction_amount")
    public WebElement amountBox;

    @FindBy(xpath = "//span[normalize-space()='Submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//*[@class='notyf__message']")
    public WebElement notfyMessage;

    @FindBy(xpath = "(//*[@class='zmdi zmdi-eye'])[1]")
    public WebElement firstActionButton;

    @FindBy(xpath = "(//tbody//tr[1]//td[2])[1]")
    public WebElement firstMerchantName;

    @FindBy(xpath = "//*[@class='col-md-4 position-relative']")
    public WebElement merchantInfoText;

    @FindBy(xpath = "//*[@class='rounded-pill img-50 mb-2 lozad loaded']")
    public WebElement merchantPicture;

    @FindBy(id="exampleModalLabel")
    public WebElement merchantPageName;

    @FindBy(xpath = "//*[@class='form-control py-2 border-right-0 border']")
    public WebElement adminPageDate;

    @FindBy(xpath = "//*[@class='zmdi zmdi-calendar-alt']")
    public WebElement calenderIcon;























































































































































}
