package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CustomerPage {

    public CustomerPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
