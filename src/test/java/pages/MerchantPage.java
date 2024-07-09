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





}
