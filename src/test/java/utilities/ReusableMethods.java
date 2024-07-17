package utilities;
import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import pages.AdminPage;
import pages.CustomerPage;
import pages.MerchantPage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.*;
import java.util.function.Function;



public class ReusableMethods {
    private static int timeout = 5;
    static AdminPage adminPage = new AdminPage();
    static MerchantPage merchantPage = new MerchantPage();
    static CustomerPage customerPage = new CustomerPage();
    static Actions actions = new Actions(Driver.getDriver());


    public static String getScreenshot(String directoryPath, String testName,String browser) throws IOException {
        try {
            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            File source = ts.getScreenshotAs(OutputType.FILE);
            String target = directoryPath + "/" + testName + "_" + browser + ".png";
            File finalDestination = new File(target);
            FileUtils.copyFile(source, finalDestination);
            return target;
        } catch (Exception e) {
            System.out.println("Ekran görüntüsü alınamadı: " + e.getMessage());
            return "";
        }
    }


    //========Switching Window=====//
    public static void switchToWindowWithTitle(String targetTitle) {
        String origin = Driver.getDriver().getWindowHandle();
        for (String handle : Driver.getDriver().getWindowHandles()) {

            Driver.getDriver().switchTo().window(handle);
            if (Driver.getDriver().getTitle().equals(targetTitle)) {
                return;
            }
        }
        Driver.getDriver().switchTo().window(origin);
    }

    public static List<String> stringListesineDonustur(List<WebElement> webelementListesi) {// bir web elemnt geliyor

        List<String> istenenStringList = new ArrayList<>();//bos bir string  listesi olusturdum

        for (WebElement eachElement : webelementListesi
        ) {
            istenenStringList.add(eachElement.getText());//her bir web wlwmnti alip ustundeki yaziyi string listesine ekledik
        }

        return istenenStringList;
    }


   public static void windowaGec(String hedefUrl, WebDriver driver){
        Set<String> tumWindowlarWHDleriSeti = driver.getWindowHandles();

        for (String eachWhd : tumWindowlarWHDleriSeti
        ) {
            driver.switchTo().window(eachWhd);

            if (driver.getCurrentUrl().equals(hedefUrl)){
                break;
            }
        }
    }
  
    //========Hover Over=====//
    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }



    //==========Return a list of string given a list of Web Element====////
    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            if (!el.getText().isEmpty()) {
                elemTexts.add(el.getText());
            }
        }
        return elemTexts;
    }


    //========Returns the Text of the element given an element locator==//
    public static List<String> getElementsText(By locator) {
        List<WebElement> elems = Driver.getDriver().findElements(locator);
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : elems) {
            if (!el.getText().isEmpty()) {
                elemTexts.add(el.getText());
            }
        }
        return elemTexts;
    }


    //===============Thread.sleep Wait==============//
    public static void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    //===============Explicit Wait==============//
    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }


    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println(
                    "Timeout waiting for Page Load Request to complete after " + timeOutInSeconds + " seconds");
        }
    }


    //======Fluent Wait====//
    public static WebElement fluentWait(final WebElement webElement, int timeinsec) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(Driver.getDriver())
                .withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofSeconds(15))
                .ignoring(NoSuchElementException.class);
        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return webElement;
            }
        });
        return element;
    }



    /**
     * Performs double click action on an element
     * @param element
     */
    public static void doubleClick(WebElement element) {
        new Actions(Driver.getDriver()).doubleClick(element).build().perform();
    }



    /**
     * @param element
     * @param check
     */
    public static void selectCheckBox(WebElement element, boolean check) {
        if (check) {
            if (!element.isSelected()) {
                element.click();
            }
        } else {
            if (element.isSelected()) {
                element.click();
            }
        }
    }


    /**
     * Selects a random value from a dropdown list and returns the selected Web Element
     * @param select
     * @return
     */
    public static WebElement selectRandomTextFromDropdown(Select select) {
        Random random = new Random();
        List<WebElement> weblist = select.getOptions();
        int optionIndex = 1 + random.nextInt(weblist.size() - 1);
        select.selectByIndex(optionIndex);
        return select.getFirstSelectedOption();
    }

    public static void waitAndClick(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
    }


    public static void waitAndClick(WebElement element) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
    }


    public static void waitAndSendText(WebElement element, String text, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.sendKeys(text);
                return;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
    }


    public static void waitAndSendText(WebElement element, String text) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.sendKeys(text);
                return;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
    }


    public static void waitAndSendTextWithDefaultTime(WebElement element, String text) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.sendKeys(text);
                return;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
    }

    public static String waitAndGetText(WebElement element, int timeout) {
        String text = "";
        for (int i = 0; i < timeout; i++) {
            try {
                text = element.getText();
                return text;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
        return null;
    }


    public static void wait2(int sec) {
        try {
            Thread.sleep(1000 * sec);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
        } catch (ElementClickInterceptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //5 seconds
    public static void waitAndClickElement(WebElement element, int seconds) {
        for (int i = 0; i < seconds; i++) {

            try {
                element.click();
                break;
            } catch (Exception e) {
                wait2(1);
            }
        }
    }

    public static void wait(int secs) {

        try {
            Thread.sleep(1000 * secs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static Boolean waitForInVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


    public static void executeJScommand(WebElement element, String command) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript(command, element);
    }


    public static void selectAnItemFromDropdown(WebElement item, String selectableItem) {
        wait(5);
        Select select = new Select(item);
        for (int i = 0; i < select.getOptions().size(); i++) {
            if (select.getOptions().get(i).getText().equalsIgnoreCase(selectableItem)) {
                select.getOptions().get(i).click();
                break;
            }
        }
    }


    /**
     * Clicks on an element using JavaScript
     *
     * @param element
     */
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }


    /**
     * Clicks on an element using JavaScript
     *
     * @param elements
     */
    public static void clickWithJSAsList(List<WebElement> elements) {
        for (WebElement each : elements) {
            ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", waitForVisibility(each, 5));
            ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", each);
        }
    }


    public static void selectByVisibleText(WebElement element, String text) {
        Select objSelect = new Select(element);
        objSelect.selectByVisibleText(text);
    }


    public static void selectByIndex(WebElement element, int index) {
        Select objSelect = new Select(element);
        objSelect.selectByIndex(index);
    }


    public static void selectByValue(WebElement element, String value) {
        Select objSelect = new Select(element);
        List<WebElement> elementCount = objSelect.getOptions();
        objSelect.selectByValue(value);
        System.out.println("number of elements: " + elementCount.size());
    }


    public static void sleep(int timeOut) {
        try {
            Thread.sleep(timeOut);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void waitAndClickLocationText(WebElement element, String value) {
        Driver.getDriver().findElement(By.xpath("//*[text()='" + value + "']")).click();
    }


    public static void accessToMerchant(){
        MerchantPage merchantPage = new MerchantPage();
        Driver.getDriver().get(ConfigReader.getProperty("merchant_Url"));
        merchantPage.usernametextbox.sendKeys(ConfigReader.getProperty("merchant_username"));
        merchantPage.passwordtextbox.sendKeys(ConfigReader.getProperty("merchant_password"));
        merchantPage.singinButton.click();
    }

    public static void accessAdmin(String adminUsername , String adminPassword){
        AdminPage adminPage = new AdminPage();
        Driver.getDriver().get(ConfigReader.getProperty("admin_Url"));
        adminPage.userNameButton.sendKeys(ConfigReader.getProperty(adminUsername)+Keys.TAB+ConfigReader.getProperty(adminPassword));
        adminPage.signInButton.click();
    }


    public static void accessToCustomer(String costumerUsername , String customerPassword){
        CustomerPage customerPage=new CustomerPage();
        Driver.getDriver().get(ConfigReader.getProperty("customer_Url"));
        ReusableMethods.wait(1);
        customerPage.signInButton.click();
        customerPage.emailBox.sendKeys(ConfigReader.getProperty(costumerUsername)+Keys.TAB+ConfigReader.getProperty(customerPassword));
        customerPage.loginSigninButton.click();
    }


    public static void fillTheCouponInformations(String couponName) {
        //Coupon Name Test
        Assert.assertTrue(merchantPage.updateCouponName.isEnabled());
        merchantPage.updateCouponName.clear();
        ReusableMethods.wait(1);

        merchantPage.updateCouponName.sendKeys(couponName);

        //Coupon Type Test
        WebElement couponTypeDropdownElement = merchantPage.updateCouponTypeDropdown;
        Assert.assertTrue(couponTypeDropdownElement.isEnabled());
        Select couponType = new Select(couponTypeDropdownElement);
        couponType.selectByIndex(0);


        //Amount Test
        Assert.assertTrue(merchantPage.updateCouponAmount.isDisplayed());
        Assert.assertTrue(merchantPage.updateCouponAmount.isEnabled());
        merchantPage.updateCouponAmount.clear();
        String discountAmount = "10";
        merchantPage.updateCouponAmount.sendKeys(discountAmount);

        //Min Order
        Assert.assertTrue(merchantPage.updateMinOrder.isEnabled());
        Assert.assertTrue(merchantPage.updateMinOrder.isDisplayed());
        merchantPage.updateMinOrder.clear();
        String minOrder = "120";
        merchantPage.updateMinOrder.sendKeys(minOrder);
        ReusableMethods.wait(1);

        //Days Available

        merchantPage.updateDaysAvailable.sendKeys("Monday", Keys.ENTER, "Sunday", Keys.ENTER);
        ReusableMethods.wait(2);


        //Expiration
        Actions actions = new Actions(Driver.getDriver());
        actions.click(merchantPage.updateExpiration).perform();

        searchDate("25","Apr","2027");


        //Coupon Options
        WebElement couponOptionsElement = merchantPage.updateCouponOptions;
        Assert.assertTrue(couponOptionsElement.isEnabled());
        Select couponOptions = new Select(couponOptionsElement);
        couponOptions.selectByIndex(0);


        //Coupon Status
        WebElement statusElement = merchantPage.updateStatus;
        Assert.assertTrue(statusElement.isEnabled());
        Select status = new Select(statusElement);
        status.selectByVisibleText("Publish");

        Assert.assertTrue(merchantPage.updateSaveButton.isDisplayed());
        Assert.assertTrue(merchantPage.updateSaveButton.isEnabled());
        merchantPage.updateSaveButton.click();
    }
    public static void searchDate(String beginDay,String beginMonth,String beginYear){

        String monthYearValue = Driver.getDriver().findElement(By.xpath("(//*//th[@class='month'])[1]")).getText();

        String month = monthYearValue.split(" ")[0].trim();
        String year = monthYearValue.split(" ")[1].trim();



        while (!(month.equals(beginMonth) && year.equals(beginYear))) {
            Driver.getDriver().findElement(By.xpath("(//tr//th[@class='next available'])[1]")).click();
            monthYearValue = Driver.getDriver().findElement(By.xpath("(//*//th[@class='month'])[1]")).getText();
            month = monthYearValue.split(" ")[0].trim();
            year = monthYearValue.split(" ")[1].trim();

        }
        Driver.getDriver().findElement(By.xpath("(//tr//td[text()='"+beginDay+"'])[1]")).click();
    }

    public static void stringListToIntegerList(List<String > stringList,List<Integer> integerList){

        for (String s : stringList) {
            try {
                integerList.add(Integer.parseInt(s));
            } catch (NumberFormatException e) {
                Assert.assertTrue(false);
            }
        }
    }

    public static void searchDateBeginFinish(String beginDay, String beginMonth, String beginYear, String finishDay, String finishMonth, String finishYear) {
        String monthYearValue = Driver.getDriver().findElement(By.xpath("(//th[@class='month'])[1]")).getText();

        String month = monthYearValue.split(" ")[0].trim();
        String year = monthYearValue.split(" ")[1].trim();


        while (!(month.equals(beginMonth) && year.equals(beginYear))) {
            Driver.getDriver().findElement(By.xpath("(//tr//th[@class='prev available'])[1]")).click();
            monthYearValue = Driver.getDriver().findElement(By.xpath("(//*//th[@class='month'])[1]")).getText();
            month = monthYearValue.split(" ")[0].trim();
            year = monthYearValue.split(" ")[1].trim();
        }
        Driver.getDriver().findElement(By.xpath("(//tr//td[text()='" + beginDay + "'])[1]")).click();
        ReusableMethods.wait(1);

        while (!(month.equals(finishMonth) && year.equals(finishYear))) {
            Driver.getDriver().findElement(By.xpath("(//tr//th[@class='next available'])[1]")).click();
            monthYearValue = Driver.getDriver().findElement(By.xpath("(//*//th[@class='month'])[1]")).getText();
            month = monthYearValue.split(" ")[0].trim();
            year = monthYearValue.split(" ")[1].trim();
        }
        Driver.getDriver().findElement(By.xpath("(//tr//td[text()='" + finishDay + "'])[1]")).click();
        ReusableMethods.wait(2);

    }
    public static void customerHasanAccesToTeam2Restaurent(){
        actions = new Actions(Driver.getDriver());
        customerPage=new CustomerPage();
        ReusableMethods.accessToCustomer("customeruser_hasan","customerpassword_hasan");
        customerPage.enterDeliveryAddresstextBox.sendKeys("Seattle");
        ReusableMethods.wait(1);
        customerPage.seattleCity.click();
        ReusableMethods.wait(1);
        Driver.getDriver().navigate().back();
        ReusableMethods.wait(4);
        actions.click(customerPage.sandwichAndWraps).perform();
        customerPage.team2Restaurant.click();
}

    public static void addCustomer(String DosyaYolu) {
        adminPage = new AdminPage();
        adminPage.addNewCustomerButton.click();
        adminPage.firstNamebutton.sendKeys("Ayse");
        Faker faker = new Faker();
        Actions actions = new Actions(Driver.getDriver());
        actions.click(adminPage.firstNamebutton)
                .sendKeys(faker.name().firstName()).perform();

        actions.click((adminPage.lastNamebutton))
                .sendKeys(faker.name().lastName()).perform();

        actions.click(adminPage.emailNameButton)
                .sendKeys(faker.internet().emailAddress()).perform();

        // actions.click(adminPage.contactPhone).sendKeys((CharSequence) faker.phoneNumber()).perform();
        actions.click(adminPage.contactPhone).sendKeys(faker.phoneNumber().phoneNumber()).perform();
        String fakePassword = faker.internet().password();
        actions.click(adminPage.passwordButton).sendKeys(fakePassword).perform();
        actions.click(adminPage.confirmPasswordButton).sendKeys(fakePassword).perform();

        adminPage.browseButton.click();
        adminPage.uploadNewButton.click();


        String yuklenecekDosyaninDosyaYolu = "C:\\Users\\Meltem\\IdeaProjects\\com.flavorfetch_team2\\src\\test\\java\\tests\\upload.png";
        adminPage.selectFilesButton.sendKeys(yuklenecekDosyaninDosyaYolu);

        adminPage.addFilesButton.click();

        adminPage.addMoreFileButton.click();

        adminPage.selectFilesButton.sendKeys(yuklenecekDosyaninDosyaYolu);

        adminPage.addFilesButton.click();

        adminPage.closeProfileWindow.click();

        adminPage.statusCustomer.click();

        // status barinda dropdown secilmesi yazilacaktir
        //dropdown olmasi icin select tagıyla olusmasi lazim, altindaki seceneklerde option tagiyla olusturulmasi lazim.
        // statu active secilir
        Select select=new Select(adminPage.statusDropdownMenu);
        select.selectByVisibleText("active");
        adminPage.saveCustomerButton.click();
    }
    }

    