package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MerchantPage {

    public MerchantPage(){

        PageFactory.initElements(Driver.getDriver(),this);


    }
}
