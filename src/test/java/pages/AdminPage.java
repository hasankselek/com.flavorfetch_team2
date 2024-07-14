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

    @FindBy(xpath = "//*[@class='col p-0 col-lg-3 col-md-3 col-sm-6 col-6 mb-3 mb-xl-0']")
    public List<WebElement> dashboardTotalHeadings; // admin dashboard total headings

    @FindBy(xpath = "//*[text()=\"Buyers\"]")
    public WebElement buyersButton; //admin dashboard menu buyers

    @FindBy(xpath = "//*[text()='Customers']")
    public WebElement customersButton; // admin dashboard menu customers

   @FindBy(xpath = "//*[text()='Reviews']")
    public WebElement reviewsButton; // dashboard menu under buyers

    //Custormer list page
    @FindBy(xpath = "(//*[text()=\"Customer list\"])[1]")
    public WebElement customerListPage;  //Custormer list page

    //sorting desc customername
   @FindBy(xpath = "//tbody//tr//td//h6")
    public WebElement sortingCustomerName; //sorting desc customername

    @FindBy(className = "zmdi zmdi-plus")
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

    @FindBy(className = "btn btn-green fileinput-button dz-clickable")
    public WebElement selectFilesButton;  // in browse button on add customer page
}
