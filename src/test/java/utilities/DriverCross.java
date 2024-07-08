package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverCross {

    private static WebDriver driver;
    private DriverCross(){

    }

    public static WebDriver getDriver(String kullanilacakBrowser){


        kullanilacakBrowser =   kullanilacakBrowser==null ? ConfigReader.getProperty("browser") : kullanilacakBrowser ;

        // bu satir bizim emniyet subabimiz
        // eger parametre olarak null gonderilirse
        // configuration.properties'deki browser degerini alacak

        if(driver == null){

            switch (kullanilacakBrowser){
                case "firefox" :
                    driver= new FirefoxDriver();
                    break;
                case "safari" :
                    driver= new SafariDriver();
                    break;

                case "edge" :
                    driver = new EdgeDriver();
                    break;
                default:
                    driver = new ChromeDriver();

            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

        return driver;
    }


    public static void closeDriver(){

        if (driver != null){
            driver.close();
            driver=null;
        }
    }

    public static void quitDriver(){

        if (driver != null){
            driver.quit();
            driver=null;
        }
    }
}
