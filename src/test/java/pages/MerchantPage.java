package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MerchantPage {

    public MerchantPage(){ PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(id = "AR_merchant_login_username")
    public WebElement usernametextbox; // merchant login page

    @FindBy(id = "AR_merchant_login_password")
    public WebElement passwordtextbox; // merchant login page

    @FindBy(xpath ="//*[@class='btn btn-green btn-full']")
    public WebElement singinButton; // merchant login page

    @FindBy(xpath = "//*[text()='Order Type']")
    public WebElement ordertypeLinki; // merchant sidebar page

    @FindBy(xpath = "//*[text()='Delivery']")
    public WebElement deliveryLinki; // merchant sidebar page

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

    @FindBy(xpath = "//*[@class='mb-4']")
    public WebElement titleOfLoginPage;

    @FindBy(xpath = "(//*[@class='required'])[1]")
    public WebElement backgroundUserBox;

    @FindBy(xpath = "(//*[@class='required'])[3]")
    public WebElement backgroundPassBox;

    @FindBy(xpath = "//*[@type='text']")
    public WebElement textEnteredUserBox;

    @FindBy(xpath = "//*[@type='password']")
    public WebElement passwordEnteredPassBox;

    @FindBy(xpath = "//*[@class='zmdi zmdi-eye']")
    public WebElement eyeAsignInPasswordBox;

  
}
