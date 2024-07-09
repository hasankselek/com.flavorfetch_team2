package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

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

}
