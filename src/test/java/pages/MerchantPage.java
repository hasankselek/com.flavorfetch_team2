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








  
}
