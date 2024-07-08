package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminPage {

    public AdminPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }
}
