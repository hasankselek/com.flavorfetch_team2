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

    @FindBy(xpath = "//*[@id='vue-dashboard']/div[2]/div[1]/div[6]/div/div/div[2]/table/tbody/tr/td[2]/p")
    public List<WebElement> popularMerchantsQuantity;

    @FindBy(xpath = "//*[@id='vue-dashboard']/div[2]/div[1]/div[6]/div/div/div[2]/table/tbody/tr/td[1]/div/div[2]/a")
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

    @FindBy(xpath = "//*[@name='AR_voucher[min_order]']")
    public WebElement couponMinOrder;  // Minimum Order

    @FindBy(xpath = "//select[@name=\"AR_voucher[days_available][]\"]")
    public WebElement couponDay; // Coupon Days

    @FindBy (xpath = "(//*[@class='selection'])[2]")
    public WebElement couponMerchant;    // merchant where the coupon applies

    @FindBy(xpath = "//*[@id='AR_voucher_used_once']")
    public WebElement couponOptions;   // coupon options

    @FindBy(xpath = "//*[@id='AR_voucher_status']")
    public WebElement couponStatus;    // coupon status

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
    public WebElement filtersByCustomerBox;//admin_allOrders

    @FindBy(xpath = "(//li[@role='option'])[2]")
    public WebElement customerNameOption;//admin_allOrders
  
    @FindBy(xpath = "//button[text()='Apply Filters']")
    public WebElement applyFiltersButton;//admin_allOrders
  
    @FindBy(xpath = "//tbody/tr/td[5]")
    public List<WebElement> elementsOfTheThirdColumn;//admin_allOrders
  
    @FindBy(xpath = "(//span[@role='combobox'])[3]")
    public WebElement filtersByStatusBox;//admin_allOrders
  
    @FindBy(xpath = "//li[text()='complete']")
    public WebElement byStatusOption;//admin_allOrders
  
    @FindBy(xpath = "//tbody/tr/td[2]/span[text()='complete']")
    public List<WebElement> elementsOfTheSecondColumnByStatus;//By status//admin_allOrders
  
    @FindBy(xpath = "(//span[@role='combobox'])[4]")
    public  WebElement filtersByOrderTypeBox;//admin_allOrders
  
    @FindBy(xpath = "//li[text()='Delivery']")
    public WebElement byOrderTypeOption;//admin_allOrders
  
    @FindBy(xpath = "//tbody/tr/td[2]//span[@class='ml-2 services badge delivery']")
    public List<WebElement> elementsOfTheSecondColumnByOrderType;

    @FindBy(xpath = "(//span[@role='combobox'])[1]")
    public  WebElement filtersByMerchantBox;//admin_allOrders
  
    @FindBy(xpath = "//input[@role='searchbox']")
    public WebElement nameBoxBelowByMerchant;//admin_allOrders
  
    @FindBy(xpath = "//li[text()='Olio E Più']")
    public  WebElement byMerchantOption;//admin_allOrders
  
    @FindBy(xpath = "//tbody/tr/td[4]")
    public List<WebElement>elementsOfTheFourthColumnByMerchant;//admin_allOrders
  
    @FindBy(xpath = "//p[text()='Orders']")
    public WebElement ordersIcon;//admin_allOrders
  
    @FindBy(xpath = "(//h5[@class='m-0'])[1]")
    public  WebElement ordersNumber;//admin_allOrders
  
    @FindBy(xpath = "//p[text()='Cancel']")
    public WebElement cancelIcon;//admin_allOrders

    @FindBy(xpath = "(//h5[@class='m-0'])[2]")
    public  WebElement cancelNumber;//admin_allOrders
  
    @FindBy(xpath = "//p[text()='Total refund']")
    public WebElement totalRefundIcon;//admin_allOrders
  
    @FindBy(xpath = "(//h5[@class='m-0'])[3]")
    public WebElement totalRefunQuantity;//admin_allOrders
  
    @FindBy(xpath = "//p[text()='Total Orders']")
    public  WebElement totalOrdersIcon;//admin_allOrders
  
    @FindBy(xpath = "(//h5[@class='m-0'])[4]")
    public  WebElement totalOrdersQuantity;//admin_allOrders
  
    @FindBy(xpath = "//input[@placeholder='Start date -- End date']")
    public WebElement dateRangeBox;//admin_allOrders
  
   @FindBy(xpath = "(//tbody)[2]//tr[3]/td[2]")
   public WebElement selectedDate;//admin_allOrders
  
    @FindBy(xpath = "//table/thead/tr/th[3]")
    public WebElement orderIdIcon;//admin_allOrders
  
    @FindBy(xpath = "//tbody/tr/td[3]")
    public List<WebElement> orderIdColumn;//admin_allOrders

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

    @FindBy(xpath = "//*[@class='zmdi zmdi-desktop-mac']")
    public WebElement iconvisible;  //Custormer list page
  
    @FindBy(xpath = "(//*[@class='sorting'])[2]")
    public WebElement nameSortingButton;  //sorting desc customername

    @FindBy(xpath = "(//*[text()='Customer list'])[1]")
    public WebElement customerListPage;  //Custormer list page

    @FindBy(xpath = "//tbody//tr//td//h6")
    public  List<WebElement> sortingCustomerName; //sorting desc customername

    @FindBy(xpath = "//*[@class='zmdi zmdi-plus']")
    public WebElement addNewCustomerButton;  // Add customer button on customer list

    @FindBy(xpath = "//*[@for='AR_client_first_name']")
    public WebElement firstNamebutton; // on add customer page

    @FindBy(xpath = "//*[@placeholder='Password']")
    public WebElement passBox;
  
    @FindBy(xpath = "//*[@href='javascript:;']")  // index ( 0 - 6) dashboard Items
    public List<WebElement> itemsAndNames;        //  index ( 7 - 16) names in admin page

    @FindBy(xpath = "//*[@href='/backoffice/reports/merchant_registration']")
    public WebElement merchantRegestration;
    @FindBy(xpath = "//*[@class='m-0 mr-2 text-muted text-truncate']")
    public List<WebElement> topNameMerchantRegistration;

    @FindBy(xpath = "//h5")   //Merchant Registration/pageItem + page top data
    public List<WebElement> topDatas;

    @FindBy(xpath = "//ul[@class='pagination']/li") //Merchant Registrtion
    public List<WebElement> pagesNevigate;

    @FindBy(xpath = "(//thead/tr/th)[19]")  // Merchant Registration /calendar DropDown
    public  WebElement calendarRightMonth;

    @FindBy(xpath = "(//thead/tr/th)[7]")  // Merchant Registration /calendar DropDown
    public  WebElement calendarLefttMonth;

    @FindBy(xpath = "//table/thead/tr/th[@class='prev available']")//Merchant Registration/calendarDropDown
    public  WebElement prevFlashCalendar;
    @FindBy(xpath = "//*[@class='filter-option']")
    public WebElement statusBoxFilter;

    @FindBy(xpath = "//*[@title='Krispy Kreme']")//MerchantRegistration/yellowBox filter
    public WebElement titleOfYellowFilterBox;
   @FindBy(xpath = "//*[@class='btn btn-black w-100']")//MerchantRegistration/yellowBox filter
   public  WebElement clearFilters;

   @FindBy(xpath = "//*[@class='btn btn-green w-100']")//MerchantRegistration/yellowBox filter
   public  WebElement applyFilters;
    @FindBy(xpath = "//*[@role='status']")  //Merchant Registration/bottom of page
    public WebElement noDataAvailableInTable;

    @FindBy(xpath = "//*[@class=' bs-ok-default check-mark']")//Merchant Registration/statusBox/Dropdown
    public List<WebElement>  checkMark;
    @FindBy(xpath = "//tbody/tr/td/div")
    public List<WebElement> filteredByStatusBoxDropDown;
    @FindBy(xpath ="//*[@class='mb-2']")//Merchant Registration/anonymus Box filter
    public WebElement byMerchant;

    @FindBy(xpath = "(//span[@class='select2-selection select2-selection--single'])[1]")//Merchant Registration/anonymus Box filter
    public   WebElement  filterInputBoxFlash;
    @FindBy(xpath = "//*[@role='option']")//Merchant Registration/statusBox/Dropdown
    public List<WebElement> statusDropDown;
    @FindBy(xpath = "//*[@type='search']")
    public WebElement dateInputBox; //Start Date - End Date
    @FindBy(xpath = "//*[@class='ranges']/ul/li")// calendarInputBox / DropDown
    public List<WebElement>  dateRange;

    @FindBy(xpath = "//*[@class='selection']")//MerchantRegistration/anonymusBox
    public WebElement yellowFilterInputBox;
   @FindBy(xpath = "//*[@class='m-0']")//MerchantRegistration
   public  List<WebElement> valueOfTopRow;
    @FindBy(xpath = "//*[@class='m-0 mr-2 text-muted text-truncate']")//MerchantRegistration
    public List<WebElement>  topRow;
    @FindBy(xpath = "//*[@class='week']")//MerchantRegistration /dropdown calendar(index = 0-13)
    public List<WebElement> weekList;

    @FindBy(xpath = "//*[@class='input-group-text bg-transparent']")
    public WebElement calendarIcone;

    @FindBy(xpath = "//thead/tr/th[2]")
    public WebElement nameHead;//MerchantRegistration/Table Head
    @FindBy(xpath = "//thead/tr/th[3]")
    public WebElement addressHead;//MerchantRegistration/Table Head
    @FindBy(xpath = "//thead/tr/th[4]")
    public WebElement membershipHead;//MerchantRegistration/Table Head
    @FindBy(xpath = "//tbody//td[1]")
    public List<WebElement> columnPicOfMerchantRegestration;

    @FindBy(xpath = "//tbody//td[2]")
    public List<WebElement> columnNameOfMerchantRegestration;
    @FindBy(xpath = "//tbody//td/p[1]")
    public List<WebElement>  columnJustNameOfMerchantRegistration;

    @FindBy(xpath = "//tbody//td/div")
    public List<WebElement> columnStatusOfMerchantRegistration;
    @FindBy(xpath = "//tbody//td[3]")
    public List<WebElement> columnAddressOfMerchantRegestration;

    @FindBy(xpath = "//tbody//td[4]")
    public List<WebElement> columnMembershipOfMerchantRegestration;

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

    @FindBy(xpath = "//*[@class='nav-link active']")
    public WebElement uploadNewButton; // in browse button on add customer page
  
    @FindBy(xpath = "//*[@class='btn btn-green fileinput-button dz-clickable']")
    public WebElement selectFilesButton;  // in browse button on add customer page

    @FindBy (xpath = "//*[@class='btn btn-green']")
    public WebElement addFilesButton; // in browse button on add customer page

    @FindBy (xpath = "//*[@class='btn']")
    public WebElement addMoreFileButton; // in browse button on add customer page

    @FindBy (xpath = "//*[@aria-hidden='true']")
    public WebElement closeProfileWindow; // in browse button on add customer page

    @FindBy (xpath = "//*[@name='AR_client[status]']")
    public WebElement statusCustomer; // on add customer page

    @FindBy( xpath = "//*[@type='search']")
    public WebElement nameSearchButton; // on customer list

    @FindBy (xpath = "(//*[text()='John Doe '])[1]")
    public WebElement searchedName;

    @FindBy ( xpath = "//*[@class='dataTables_empty']")
    public WebElement assertSearchedPage;

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

    @FindBy(xpath = "//*[@id='DataTables_Table_0']/tbody/tr[1]/td[4]/div/a")
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
  
    @FindBy(xpath = "(//*[text()='Merchant'])[1]")
    public WebElement merchantSide;

    @FindBy(xpath = "(//*[@class='sidebar-nav-sub-menu'])[1]")
    public WebElement listSide;

    @FindBy(xpath = "//*[@placeholder='Search']")
    public WebElement SearchSide;

    @FindBy(xpath = "(//*[@class='btn btn-light tool_tips'])[2]")
    public WebElement AutoLoginSide;
    
    @FindBy(xpath = "//*[@class='table-responsive-md']")
    public WebElement allOrdersWebTable; // orders > all orders page

    @FindBy(xpath = "(//*[@class='row'])[1]")
    public WebElement allOrdersHeaderSection; // orders > all orders page

    @FindBy(xpath = "//*[@class='form-control py-2 border-right-0 border']")
    public WebElement dateFilterBox; // orders > all orders page

    @FindBy(xpath = "(//*[@class='weekend available'])[3]")
    public WebElement sampleDateData; //  orders > all orders page

    @FindBy(xpath = "(//p[@class='dim m-0'])[4]")
    public WebElement orderDateInfo; //  orders > all orders page

    @FindBy(xpath = "//*[@class='ml-2 btn btn-yellow normal']")
    public WebElement yellowFilterButton; //  orders > all orders page

    @FindBy(xpath = "//*[@class='odd']")
    public WebElement orderInfo;  //  orders > all orders page

    @FindBy(xpath = "//*[@class='sorting sorting_desc']")
    public WebElement orderIdFilter; //   orders > all orders page

    @FindBy(xpath = "//*[@class='dataTables_info']")
    public WebElement showingEntryInfo; // orders > all orders page

    @FindBy(xpath = "//*[@class='dataTables_paginate paging_simple_numbers']")
    public WebElement paginationBox; // orders > all orders page

    @FindBy(xpath = "(//*[@class='page-link'])[3]")
    public WebElement samplePageNumber;

    @FindBy(xpath = "(//p[@class='dim m-0'])[1]")
    public WebElement paymentType;//admin_allOrders
  
    @FindBy(xpath = "(//p[@class='dim m-0'])[2]")
    public  WebElement orderType;//admin_allOrders
  
    @FindBy(xpath = "(//p[@class='dim m-0'])[3]")
    public  WebElement totalPrice;//admin_allOrders

    @FindBy(xpath = "//a[@class='ref_view_order normal btn btn-light tool_tips']")
    public  WebElement eyeSignUnderActions;
  
    @FindBy(xpath = "(//h5[@class='m-0'])[1]")
    public  WebElement orderIdOrderDetailPage;
  
    @FindBy(xpath = "(//p[@class='m-0'])[3]")
    public  WebElement restaurantNameOrderDetailPage;

    @FindBy(xpath = "(//table)[1]/tr[5]/td[1]")
    public  WebElement paymentStatusOrderDetailPage;
  
    @FindBy(xpath = "//button[text()='Print']")
    public WebElement printButtonOrderDetailPage;
  
    @FindBy(xpath = "(//p[@class='m-0'])[2]")
    public WebElement orderDateOrderDetailPage;
  
    @FindBy(xpath = "(//a[@class='ref_pdf_order normal btn btn-light tool_tips'])[1]")
    public  WebElement downloadIcon;

    @FindBy(xpath = "//*[@data-range-key='Custom Range'")
    public WebElement customRange;

    @FindBy(xpath = "(//tbody)[2]//tr")
    public List<WebElement> customRangeProductList;

    @FindBy(xpath = "//li//a[@role='option']")
    public List<WebElement> allTransaction;

    @FindBy(xpath = "//*[@class='filter-option-inner-inner']")
    public WebElement allTransactionFilter;

    @FindBy(xpath = "(//table)[2]//th")
    public List<WebElement> merchantInfoTable;

    @FindBy(xpath = "//div//ul//li[@data-range-key]")
    public List<WebElement> dateRangeKey;

    @FindBy(xpath = "(//*[text()='Deactivate Merchant'])")
    public WebElement deactiveMerchantButton;

    @FindBy(xpath = "//*[@class='bootbox-body']")
    public WebElement deactiveInformation;

    @FindBy(xpath = "(//*[@type='button'])[11]")
    public WebElement confirmButton;

    @FindBy(xpath = "(//*[text()='Activate Merchant'])")
    public WebElement activateMerchantButton;
  
    @FindBy(xpath = "(//*[@class=\"btn btn-light tool_tips\"])[1]")
    public WebElement couponActions;

    @FindBy(xpath = "//*[@id='AR_voucher_status']")
    public WebElement couponUpdateStatus;

    @FindBy(xpath = "(//*[@class='zmdi zmdi-delete'])[1]")
    public WebElement couponDelete;

    @FindBy(xpath = "//*[@class='btn btn-green item_delete']")
    public WebElement couponAlertDelete;

    @FindBy(xpath = "//select[@class='form-control custom-select form-control-select']")
    public WebElement statusDropdownMenu; // add customer page

    @FindBy(xpath = "//*[@class='btn btn-green btn-full mt-3']")
    public WebElement saveCustomerButton;  // add customer page

    @FindBy(xpath = "(//*[@class='zmdi zmdi-delete'])[1]")
    public WebElement deleteCustomerButton; // on customer list page

    @FindBy(xpath = " //*[@class='btn btn-green item_delete']")
    public WebElement cDeleteButton;

    @FindBy( xpath = "(//*[@class='zmdi zmdi-border-color'])[1]")
    public WebElement updateButton;

    @FindBy(xpath = "//*[@id='AR_merchant_restaurant_name']")
    public WebElement updatePageRestaurantName;

    @FindBy(xpath = "//*[@id='AR_merchant_restaurant_slug']")
    public WebElement updatePageRestaurantSlug;

    @FindBy(xpath = "//*[@id='AR_merchant_contact_name']")
    public WebElement updatePageContactName;

    @FindBy(xpath = "//*[@id='AR_merchant_contact_phone']")
    public WebElement updatePageContactPhone;

    @FindBy(xpath = "//*[@id='AR_merchant_contact_email']")
    public WebElement updatePageContactEmail;

    @FindBy(xpath = "(//*[@class='zmdi zmdi-delete'])[1]")
    public WebElement listPageDeleteButton;

    @FindBy(xpath = "//li[@class='admin_dashboard active']")
    public WebElement adminDashboardmenu;

    @FindBy(xpath = "//a[@class='navbar-brand']")
    public WebElement reviewView;

    @FindBy(xpath = "//table/thead[1]")
    public List<WebElement> headDashboard;

    @FindBy(xpath = "//thead//th[2]")
    public WebElement headMerchant;

    @FindBy(xpath = "//thead//th[3]")
    public WebElement headReview;

    @FindBy(xpath = "//thead//th[4]")
    public WebElement headActions;

    @FindBy(xpath = "//*[@class='zmdi zmdi-delete']")
    public WebElement deleteButtonDashboard; //

    @FindBy(xpath = "(//*[@class='zmdi zmdi-border-color'])[2]")
    public WebElement updateButtonDashboard; //

    @FindBy(xpath = "//*[@class='page-link']")
    public WebElement dashboardPageNumbers;

    @FindBy(xpath = "(//tbody)[1]//tr")
    public List<WebElement> all5Orders;

    @FindBy(xpath = "(//tbody)[1]//tr//td[6]/*[@class='btn btn-sm text-muted btn-light hover-bg-primary hover-text-secondary py-1 px-3 mr-2']")
    public List<WebElement> viewIconAdminDashboard;

    @FindBy(xpath = "(//tbody)[1]//tr//td[6]/*[@class='btn btn-sm text-muted btn-light hover-bg-primary hover-text-secondary py-1 px-3']")
    public List<WebElement> downloadIconAdminDashboard;

    @FindBy(xpath = "//*[@id='vue-dashboard']/div[2]/div[1]/div[1]/div/div")
    public List<WebElement> commissionAndSubscriptionsAdminDashboard;

    @FindBy(xpath = "//*[@id='vue-dashboard']/div[2]/div[1]/div[2]/div[1]/div[1]/div/div/div/div[2]")
    public WebElement orderReceivedBox;

    @FindBy(xpath = "//*[@id='vue-dashboard']/div[2]/div[1]/div[2]/div[1]/div[2]/div/div/div/div[2]")
    public WebElement totalDeliveredBox;

    @FindBy(xpath = "//*[@id='vue-dashboard']/div[2]/div[1]/div[2]/div[2]/div/div[1]/div/div/div/div[2]")
    public WebElement newCustomerBox;

    @FindBy(xpath = "//*[@id='vue-dashboard']/div[2]/div[1]/div[2]/div[2]/div/div[2]/div/div/div/div[2]")
    public WebElement totalRefundBox;

    @FindBy(xpath = "//h5[normalize-space()='Merchant Earnings']")
    public WebElement merchantEarringsTitle;

    @FindBy(xpath = "//a[@aria-controls='DataTables_Table_0']")
    public List<WebElement> merchantEarringsSayfaNo;
  
    @FindBy(xpath = "//*[@for='AR_client_npassword']")
    public WebElement buyersPassword; //update customer page password

    @FindBy(xpath = "//*[@class='zmdi zmdi-search']")
    public WebElement namesearchicon;


    @FindBy(xpath = "//*[text()='All Review']")
    public WebElement allReviewClick;











































































































































  









}
