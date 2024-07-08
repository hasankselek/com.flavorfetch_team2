package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

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
}
