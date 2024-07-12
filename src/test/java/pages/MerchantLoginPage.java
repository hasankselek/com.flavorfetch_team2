package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MerchantLoginPage {
public MerchantLoginPage(){
    PageFactory.initElements(Driver.getDriver(),this);
}

    @FindBy(xpath = "//*[@class='zmdi-eye zmdi']")
    public WebElement eyeAsignFallDownPosition;

    @FindBy(xpath = "//*[@class='zmdi zmdi-eye']")
    public WebElement eyeAsignInPasswordBox;

    @FindBy(xpath = "//*[@class='zmdi zmdi-eye-off']")
    public  WebElement eyeAsignWithALine;

    @FindBy(xpath = "//*[@value='Request E-mail']")
    public WebElement RequestEmail;

    @FindBy(xpath = "//*[@class='dim underline']")
    public WebElement forgetMiLink;

    @FindBy(xpath = "(//*[@id='dropdownMenuLink'])[1]")
    public WebElement merchantNameDropdown;

    @FindBy(xpath = "(//*[@class='dropdown-item'])[3]")
    public WebElement logoutMerchantDashboard;

    @FindBy(xpath = "//*[@src='/backoffice/themes/classic/assets/images/app-store@2x.png']")
    public WebElement appStoreIcon;

    @FindBy(xpath = "//*[@src='/backoffice/themes/classic/assets/images/google-play@2x.png']")
    public WebElement googlePlayIcon;

    @FindBy(xpath = "//*[@class='dim custom-control-label']")
    public WebElement rememberMeLable;

    @FindBy(xpath = "(//*[@class='errorMessage'])[1]")
    public WebElement user_ThisFieldIsRequired;

    @FindBy(xpath = "(//*[@class='errorMessage'])[1]")
    public WebElement pass_ThisFieldIsRequired;
    @FindBy(xpath = "//*[@class='mb-4']")
    public WebElement titleOfLoginPage;

    @FindBy(xpath = "(//*[@class='required'])[1]")
    public WebElement backgroundUserBox;

    @FindBy(xpath = "(//*[@class='required'])[3]")
    public WebElement backgroundPassBox;

    @FindBy(xpath = ".//input[starts-with(@class,'form-label-group')]")
    public WebElement textEnteredUserBox;

    @FindBy(xpath = "//*[@type='text']")
    public WebElement passwordReveal;

    @FindBy(xpath = "//*[@type='password']")
    public WebElement passwordHidden;

    @FindBy(xpath = ".//input[starts-with(@class,'form-label-group change_field_password')]")
    public  WebElement passwordFieldPassBox;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement signInButtonMerchantLogin;

    @FindBy(id = "AR_merchant_login_username")
    public WebElement userBoxMerchantLogin;

    @FindBy(id = "AR_merchant_login_password")

    public WebElement passwordBoxMerchantLogin;


}
