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

    @FindBy(xpath = "//*[text()='View All']")
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

    @FindBy(xpath = "//*[text()='Last 30 days sales']")
    public WebElement Last30daysSalesButton;

    @FindBy(xpath = "//*[@class='flex-col']")
    public List<WebElement> popularItemsInformation;

    @FindBy(xpath = "//*[@class='text-right align-middle']")
    public List<WebElement> popularItemsQuantity;

    @FindBy(xpath = "//*[@class='img-60 rounded-circle']")
    public List<WebElement> popularItemsPictures;

    @FindBy(xpath ="//*[@class='highcharts-plot-border']")
    public WebElement last30DaysSalesChart;

    @FindBy(xpath = "//*[@class='row ml-2 mt-4']")
    public List<WebElement> last30DaysProducts;

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

    @FindBy(xpath = "//*[@class='img-60 rounded']")
    public List<WebElement> popularMerchantsPictures;

    @FindBy(xpath = "//*[@class='font-weight-bold hover-text-primary mb-1 text-green']")
    public List<WebElement> merchantName;

    @FindBy(xpath = "(//tbody)[4]")
    public WebElement popularByReviewTable;

    @FindBy(xpath = "//*[@class='font-weight-bold hover-text-primary mb-1 text-green']")
    public List<WebElement> merchantReviewPage;

    @FindBy(xpath = "//*[text()='Top Customers']")
    public WebElement topCustomersText;

    @FindBy(xpath = "(//a[@class='font-weight-bold hover-text-primary mb-1'])[6]")
    public WebElement firstCustomerButton;

    @FindBy(xpath = "(//*[@class='modal-header'])[1]")
    public WebElement customerIDText;

    @FindBy(xpath = "(//*[@class='col-2 pr-1'])")
    public List<WebElement> customerPageAltBasliklar;
  
    @FindBy(xpath = "//*[@class='promo']")
    public  WebElement adminPromo;


}
