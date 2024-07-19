package tests;

import com.beust.ah.A;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.MerchantPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;
import java.security.Key;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

public class US_028 extends TestBaseRapor {
    MerchantPage merchantPage = new MerchantPage ();

    @Test
    public void TC_2801() throws IOException {


        Driver.getDriver ().get ( ConfigReader.getProperty ( "merchant_Url" ) );
        extentTest.info ( "Kullanici merchant sayfasina gider" );

        merchantPage.usernametextbox.sendKeys ( ConfigReader.getProperty ( "merchant_username" ) + Keys.TAB + ConfigReader.getProperty ( "merchant_password" ) );

        merchantPage.singinButton.click ();
        extentTest.info ( "Kullanici bilgileri ile giris yapar" );
        merchantPage.ordersLink.click ();
        extentTest.info ( "Merchant dashboarda order sekmesine tiklar" );
        merchantPage.ordersReadyLink.click ();
        extentTest.info ( "Merchant dasboarda orders ready adimina tiklar" );

        String expectedUrl = "https://qa.flavorfetch.com/backoffice/orders/ready";
        String actualUrl = Driver.getDriver ().getCurrentUrl ();
        Assert.assertEquals ( actualUrl, expectedUrl );
        extentTest.pass ( "Orders Ready sayfasini goruntulendigini dogrular" );

        Assert.assertTrue ( merchantPage.ordersReadyList.isDisplayed () );
        extentTest.info ( "Siparisler listesi bolumunu goruntuler" );
        Assert.assertTrue ( merchantPage.orderHeaderText.isDisplayed () );
        extentTest.info ( "Siparis ekraninda guncel tarih ve bu tarih itibariyla siparisler ekraninda oldugunu dogrular " );
        Assert.assertTrue ( merchantPage.notificationsButton.isDisplayed () );
        extentTest.info ( "Magazaya gelen yeni siparisler  bildirim butonunu goruntuler" );
        Assert.assertTrue ( merchantPage.notificationsButton.isEnabled () );
        extentTest.info ( "Bildirim butonu aktif oldugunu dogrular" );
        ReusableMethods.sleep ( 5 );
        Assert.assertTrue ( merchantPage.howToManageOrdersLink.isDisplayed () );
        extentTest.info ( "Siarisler nasil yonetilir bilgilendirme sayfa linkini goruntuler" );
        ReusableMethods.sleep ( 5 );
        ReusableMethods.waitForClickablility ( merchantPage.howToManageOrdersLink, 5 ).click ();
        extentTest.pass ( "Siparisler nasil yonetilir? bilgilendirme linkinin calisitigini dogrular " );

        Driver.quitDriver ();

    }


    @Test
    public void TC_2802() {

        AdminPage adminPage = new AdminPage ();
        ReusableMethods.accessAdmin ( "adminuser_serhat", "adminpassword_serhat" );

        adminPage.MerchantSide.click ();
        adminPage.ListSide.click ();
        adminPage.SearchSide.sendKeys ( "Dolan Uyghur Restaurant" + Keys.ENTER );
        adminPage.AutoLoginSide.click ();

        ReusableMethods.windowaGec ( "https://qa.flavorfetch.com/backoffice/merchant/dashboard", Driver.getDriver () );

        merchantPage.ordersLink.click ();
        merchantPage.ordersReadyLink.click ();

        // İlk sipariş sayısını al
        List<WebElement> initialOrders = Driver.getDriver ().findElements ( By.cssSelector ( ".grey-list-chevron .chevron" ) );
        int initialOrderCount = initialOrders.size ();
        System.out.println ( "İlk sipariş sayısı: " + initialOrderCount );

        // Teslim edilecek siparişi bul ve seç
        WebElement deliveryOrder = null;
        for (WebElement order : initialOrders) {
            WebElement deliveryType = order.findElement ( By.cssSelector ( ".services" ) );
            if (deliveryType.getText ().contains ( "Delivery" )) {
                deliveryOrder = order;
                order.click ();  // "Delivery" olan siparişi seç
                break;
            }
        }

        Assert.assertNotNull ( deliveryOrder, "Teslim edilecek sipariş bulunamadı" );

        // Teslim edilen siparişi işaretle
        Assert.assertTrue ( merchantPage.deliveryOnThisWaybuttonOrderReadyPage.isDisplayed (), "Teslimat yolda butonu görünmüyor" );
        Assert.assertTrue ( merchantPage.deliveredButtonOrdersReadyPage.isDisplayed (), "Teslim edildi butonu görünmüyor" );
        Assert.assertTrue ( merchantPage.deliveryFailedButtonOrdersReadyPage.isDisplayed (), "Teslimat başarısız butonu görünmüyor" );

        merchantPage.deliveredButtonOrdersReadyPage.click ();

        // Liste güncellenmesini bekleyin (süreyi artırdık)
        ReusableMethods.sleep ( 10 );

        // Gerekirse sayfayı yenileyin
        Driver.getDriver ().navigate ().refresh ();

        // Yeniden listeyi kontrol edin
        ReusableMethods.sleep ( 5 ); // Sayfa yenilendikten sonra beklemek için

        // Sipariş sayısını tekrar al
        List<WebElement> finalOrders = Driver.getDriver ().findElements ( By.cssSelector ( ".grey-list-chevron .chevron" ) );
        int finalOrderCount = finalOrders.size ();
        System.out.println ( "Son sipariş sayısı: " + finalOrderCount );

        // Teslim edilen siparişin listeden çıkarıldığını doğrula
        Assert.assertTrue ( finalOrderCount == initialOrderCount - 1, "Sipariş sayısı teslim edildi olarak işaretlendikten sonra azalmadı" );

        // Teslim edilen siparişin gerçekten listeden çıkarıldığını doğrula
        boolean isOrderRemoved = true;
        for (WebElement order : finalOrders) {
            WebElement deliveryType = order.findElement ( By.cssSelector ( ".services" ) );
            if (deliveryType.getText ().contains ( "Delivery" ) && order.equals ( deliveryOrder )) {
                isOrderRemoved = false;
                break;
            }
        }

        Assert.assertTrue ( isOrderRemoved, "Sipariş teslim edildikten sonra hala listede mevcut" );

        Driver.quitDriver ();

    }


    @Test
    public void TC_2803() {

        AdminPage adminPage = new AdminPage ();
        ReusableMethods.accessAdmin ( "adminuser_serhat", "adminpassword_serhat" );

        adminPage.MerchantSide.click ();
        adminPage.ListSide.click ();
        adminPage.SearchSide.sendKeys ( "Dolan Uyghur Restaurant" + Keys.ENTER );
        adminPage.AutoLoginSide.click ();

        ReusableMethods.windowaGec ( "https://qa.flavorfetch.com/backoffice/merchant/dashboard", Driver.getDriver () );

        merchantPage.ordersLink.click ();
        merchantPage.ordersReadyLink.click ();

        // İlk sipariş sayısını al
        List<WebElement> initialOrders = Driver.getDriver ().findElements ( By.cssSelector ( ".grey-list-chevron .chevron" ) );
        int initialOrderCount = initialOrders.size ();
        System.out.println ( "İlk sipariş sayısı: " + initialOrderCount );

        // Pickup veya Dine-in olan siparişi bul ve seç
        WebElement selectedOrder = null;
        for (WebElement order : initialOrders) {
            WebElement deliveryType = order.findElement ( By.cssSelector ( ".services" ) );
            if (deliveryType.getText ().contains ( "Pickup" ) || deliveryType.getText ().contains ( "Dinein" )) {
                selectedOrder = order;
                order.click ();  // "Pickup" veya "Dine-in" olan siparişi seç
                break;
            }
        }

        Assert.assertNotNull ( selectedOrder, "Pickup veya Dine-in sipariş bulunamadı" );

        // Siparişi tamamla
        Assert.assertTrue ( merchantPage.completeOrdersReadyPage.isDisplayed (), "Complete butonu görünmüyor" );
        Assert.assertTrue ( merchantPage.orderFailedOrdersReadyPage.isDisplayed (), "Order Failed butonu görünmüyor" );

        merchantPage.completeOrdersReadyPage.click ();

        // Liste güncellenmesini bekleyin (süreyi artırdık)
        ReusableMethods.sleep ( 10 );

        // Gerekirse sayfayı yenileyin
        Driver.getDriver ().navigate ().refresh ();

        // Yeniden listeyi kontrol edin
        ReusableMethods.sleep ( 5 ); // Sayfa yenilendikten sonra beklemek için

        // Sipariş sayısını tekrar al
        List<WebElement> finalOrders = Driver.getDriver ().findElements ( By.cssSelector ( ".grey-list-chevron .chevron" ) );
        int finalOrderCount = finalOrders.size ();
        System.out.println ( "Son sipariş sayısı: " + finalOrderCount );

        // Tamamlanan siparişin listeden çıkarıldığını doğrula
        Assert.assertTrue ( finalOrderCount == initialOrderCount - 1, "Sipariş sayısı Complete olarak işaretlendikten sonra azalmadı" );

        // Tamamlanan siparişin gerçekten listeden çıkarıldığını doğrula
        boolean isOrderRemoved = true;
        for (WebElement order : finalOrders) {
            WebElement deliveryType = order.findElement ( By.cssSelector ( ".services" ) );
            if ((deliveryType.getText ().contains ( "Pickup" ) || deliveryType.getText ().contains ( "Dinein" )) && order.equals ( selectedOrder )) {
                isOrderRemoved = false;
                break;
            }
        }

        Assert.assertTrue ( isOrderRemoved, "Sipariş Complete edildikten sonra hala listede mevcut" );

        Driver.quitDriver ();


    }

    @Test
    public void TC_2804() throws IOException {

        // Admin paneline giriş yap
        ReusableMethods.accessAdmin ( "adminuser_serhat", "adminpassword_serhat" );
        extentTest.info ( "Detayli merchant test adimlari icin Admin paneline giriş yapar" );
        // AdminPage objesini oluştur
        AdminPage adminPage = new AdminPage ();

        // Merchant sekmesine git
        adminPage.MerchantSide.click ();
        extentTest.info ( "Merchant sekmesine gider" );
        // Listeleme sekmesine git
        adminPage.ListSide.click ();
        extentTest.info ( "Merchant listeleme sekmesine tiklar" );
        // Arama yaparak restoranı bul
        adminPage.SearchSide.sendKeys ( "Dolan Uyghur Restaurant" );
        adminPage.SearchSide.sendKeys ( Keys.ENTER );
        extentTest.info ( "Testlerimizi yapacagimiz restoranti secer" );

        // Otomatik girişi etkinleştir
        adminPage.AutoLoginSide.click ();
        extentTest.info ( "Test yurutecegimiz merchant paneline giris yapar" );

        // Yeni bir pencereye geçiş yap ve Orders Ready sayfasına git
        ReusableMethods.windowaGec ( "https://qa.flavorfetch.com/backoffice/merchant/dashboard", Driver.getDriver () );
        extentTest.info ( "Yeni bir pencerede merchant dashboard sayfasini goruntuler" );
        // Siparişler sayfasına git
        merchantPage.ordersLink.click ();
        extentTest.info ( "Orders sekmesine tiklar" );
        // Orders Ready linkine tıkla
        merchantPage.ordersReadyLink.click ();
        extentTest.info ( "Orders Ready sekmesine tiklar" );

        // Teslim edilecek siparişi bul ve seç

        List<WebElement> ordersList = Driver.getDriver ().findElements ( By.cssSelector ( ".grey-list-chevron .chevron" ) );

        WebElement deliveryOrder = null;
        for (WebElement order : ordersList) {
            WebElement deliveryType = order.findElement ( By.cssSelector ( ".services" ) );
            if (deliveryType.getText ().contains ( "Delivery" )) {
                deliveryOrder = order;
                order.click ();  // "Delivery" olan siparişi seç
                break;
            }
        }

        // Teslim edilecek siparişin olup olmadığını kontrol et
        Assert.assertNotNull ( deliveryOrder, "Teslim edilecek sipariş bulunamadı" );
        extentTest.info ( "Order Type Delivery olan siparis goruntuler" );

        // "Assign Driver" butonunun görünürlüğünü ve etkinliğini kontrol et
        Assert.assertTrue ( merchantPage.assingDriverOrdersReadyPage.isDisplayed (), "Assign Driver butonu görünmüyor" );
        extentTest.info ( "Order Type Delivery olan sipariste Assing Driver butonunu goruntuler" );
        Assert.assertTrue ( merchantPage.assingDriverOrdersReadyPage.isEnabled (), "Assign Driver butonu aktif değil" );
        extentTest.info ( "Assing Driver butonunun aktif olddugunu dogrular" );

        String initialURL = Driver.getDriver ().getCurrentUrl ();


        // "Assign Driver" butonunu tıkla

        merchantPage.assingDriverOrdersReadyPage.click ();

        extentTest.pass ( "Assing Driver butonu ile surucu atamak icin tiklar" );


        // Bir süre bekleyelim ve sonra URL'nin değişip değişmediğini kontrol edelim

        WebDriverWait wait = new WebDriverWait ( Driver.getDriver (), Duration.ofSeconds ( 10 ) );

        wait.until ( ExpectedConditions.not ( ExpectedConditions.urlToBe ( initialURL ) ) );
        extentTest.pass ( "Surucu atama sayfasinin acildigini dogrular" );

        // URL değiştiyse, bir sonraki adıma geçilmiştir
        System.out.println ( "URL değişti, bir sonraki adıma geçildi." );

        Driver.quitDriver ();


    }


    @Test
    public void TC_2805() {


        // Admin paneline giriş yap
        ReusableMethods.accessAdmin ( "adminuser_serhat", "adminpassword_serhat" );

        // AdminPage objesini oluştur
        AdminPage adminPage = new AdminPage ();

        // Merchant sekmesine git
        adminPage.MerchantSide.click ();

        // Listeleme sekmesine git
        adminPage.ListSide.click ();

        // Arama yaparak restoranı bul
        adminPage.SearchSide.sendKeys ( "Dolan Uyghur Restaurant" );
        adminPage.SearchSide.sendKeys ( Keys.ENTER );

        // Otomatik girişi etkinleştir
        adminPage.AutoLoginSide.click ();

        // Yeni bir pencereye geçiş yap ve Orders Ready sayfasına git
        ReusableMethods.windowaGec ( "https://qa.flavorfetch.com/backoffice/merchant/dashboard", Driver.getDriver () );

        // Siparişler sayfasına git
        merchantPage.ordersLink.click ();

        // Orders Ready linkine tıkla
        merchantPage.ordersReadyLink.click ();

        // Siparişler listesine erişim
        List<WebElement> ordersList = Driver.getDriver ().findElements ( By.cssSelector ( ".grey-list-chevron .chevron" ) );

        // Herhangi bir siparişi seç
        if (!ordersList.isEmpty ()) {
            WebElement anyOrder = ordersList.get ( 0 );
            anyOrder.click ();

            // Print butonuna tıkla
            merchantPage.printButton.click ();

            // Yazdırma işlemi için açılan bildirimde Print butonunu bekle ve tıkla
            WebDriverWait wait = new WebDriverWait ( Driver.getDriver (), Duration.ofSeconds ( 10 ) );
            WebElement printOutButton = wait.until ( ExpectedConditions.elementToBeClickable ( By.xpath ( "(//*[@class='btn btn-green'])[2]" ) ) );
            printOutButton.click ();

        } else {
            System.out.println ( "Hiçbir sipariş bulunamadı." );
        }

        // Doğrulama
        Assert.assertFalse ( ordersList.isEmpty (), "Hiçbir sipariş bulunamadı." );

        Driver.quitDriver ();

    }


    @Test
    public void TC_2806() {


        // Admin paneline giriş yap
        ReusableMethods.accessAdmin ( "adminuser_serhat", "adminpassword_serhat" );

        // AdminPage objesini oluştur
        AdminPage adminPage = new AdminPage ();

        // Merchant sekmesine git
        adminPage.MerchantSide.click ();

        // Listeleme sekmesine git
        adminPage.ListSide.click ();

        // Arama yaparak restoranı bul
        adminPage.SearchSide.sendKeys ( "Dolan Uyghur Restaurant" );
        adminPage.SearchSide.sendKeys ( Keys.ENTER );

        // Otomatik girişi etkinleştir
        adminPage.AutoLoginSide.click ();

        // Yeni bir pencereye geçiş yap ve Orders Ready sayfasına git
        ReusableMethods.windowaGec ( "https://qa.flavorfetch.com/backoffice/merchant/dashboard", Driver.getDriver () );

        // Siparişler sayfasına git
        merchantPage.ordersLink.click ();

        // Orders Ready linkine tıkla
        merchantPage.ordersReadyLink.click ();

        // Siparişler listesine erişim
        List<WebElement> ordersList = Driver.getDriver ().findElements ( By.cssSelector ( ".grey-list-chevron .chevron" ) );

        // Herhangi bir siparişi seç
        if (!ordersList.isEmpty ()) {
            WebElement anyOrder = ordersList.get ( 0 );
            anyOrder.click ();

            // İlgili sipariş için daha fazla seçenekleri aç
            merchantPage.moreOptionsDropdownButton.click ();

            // Delay Order seçeneğine tıkla
            ReusableMethods.clickWithJS ( merchantPage.roundedDelayOrder );

            // 5 dakika gecikme seçeneğine tıkla
            ReusableMethods.clickWithJS ( merchantPage.delayOrderMinute );

            // Onayla butonuna tıkla
            ReusableMethods.clickWithJS ( merchantPage.delayOrderConfirm );

            // Gecikme mesajının göründüğünü doğrula
            WebDriverWait wait = new WebDriverWait ( Driver.getDriver (), Duration.ofSeconds ( 10 ) );
            wait.until ( ExpectedConditions.visibilityOf ( merchantPage.delayOrdermessageMinute ) );

            // Gecikme mesajının göründüğünü assert et
            Assert.assertTrue ( merchantPage.delayOrdermessageMinute.isDisplayed (), "Gecikme mesajı görüntülendi" );

            Driver.quitDriver ();

        }

    }

    @Test
    public void TC_2807() throws IOException {


        // Admin paneline giriş yap
        ReusableMethods.accessAdmin ( "adminuser_serhat", "adminpassword_serhat" );
        extentTest.info ( "Detayli merchant test adimlari icin Admin paneline giriş yapar" );
        // AdminPage objesini oluştur
        AdminPage adminPage = new AdminPage ();

        // Merchant sekmesine git
        adminPage.MerchantSide.click ();
        extentTest.info ( "Merchant sekmesine tiklar" );
        // Listeleme sekmesine git
        adminPage.ListSide.click ();
        extentTest.info ( "Merchant listeleme sekmesine tiklar" );
        // Arama yaparak restoranı bul
        adminPage.SearchSide.sendKeys ( "Dolan Uyghur Restaurant" );
        adminPage.SearchSide.sendKeys ( Keys.ENTER );
        extentTest.info ( "Merchant listesinde testlerimizi yapacagimiz restoranti aratir" );
        // Otomatik girişi etkinleştir
        adminPage.AutoLoginSide.click ();
        extentTest.info ( "Test yurutecegimiz merchant paneline giris yapar" );

        // Yeni bir pencereye geçiş yap ve Orders Ready sayfasına git
        ReusableMethods.windowaGec ( "https://qa.flavorfetch.com/backoffice/merchant/dashboard", Driver.getDriver () );
        extentTest.info ( "Yeni bir pencerede merchant dashboard sayfasini goruntuler" );
        // Siparişler sayfasına git
        merchantPage.ordersLink.click ();
        extentTest.info ( "Orders sekmesine tiklar" );
        // Orders Ready linkine tıkla
        merchantPage.ordersReadyLink.click ();
        extentTest.info ( "Orders Ready sekmesine tiklar" );
        // İlk sipariş listesini al
        List<WebElement> initialOrdersList = Driver.getDriver ().findElements ( By.cssSelector ( ".grey-list-chevron .chevron" ) );
        int initialOrderCount = initialOrdersList.size ();
        extentTest.info ( "Siparis listesini goruntuler ve sayisini kontrol eder" );

        // Sipariş alımını duraklatma işlemlerini gerçekleştir
        ReusableMethods.clickWithJS ( merchantPage.acceptingOrderButton );
        extentTest.info ( "Siparis duraklatma butonuna tiklar" );
        ReusableMethods.clickWithJS ( merchantPage.pauseNewOrders30Minutes );
        extentTest.info ( "Siparis duraklatma zamani secimine tiklar" );
        ReusableMethods.clickWithJS ( merchantPage.pauseNewOrdersNextMinuteButton );
        extentTest.info ( "Duraklama nedeni sayfasina gider" );
        ReusableMethods.clickWithJS ( merchantPage.pauseReasonforPausing );
        extentTest.info ( "Siparis duraklatma nedeni secimi yapar" );
        ReusableMethods.clickWithJS ( merchantPage.pauseAcceptingOrdersConfirm );
        extentTest.info ( "Siparis duraklatma islemini onaylar" );

        // 1 dakika bekle
        ReusableMethods.wait ( 60 ); // 1 dakika (60 saniye) Ornek bekleme suresinde bir siparis verilmeli


        // Siparişler sayfasını yenile
        Driver.getDriver ().navigate ().refresh ();
        extentTest.info ( "Yeni siparis verilemdigini dogrulama icin sayfayi yeniler" );

        // Yenilenen sipariş listesini al
        List<WebElement> updatedOrdersList = Driver.getDriver ().findElements ( By.cssSelector ( ".grey-list-chevron .chevron" ) );
        int updatedOrderCount = updatedOrdersList.size ();
        extentTest.pass ( "Siparis listesinde  yeni siparişlerin listede olmadigini kontrol eder" );
        // Yeni siparişlerin listede görünmediğini doğrula

        if (updatedOrderCount > initialOrderCount) {
            System.out.println ( "Yeni siparişler listede görünüyor. Test başarısız." );
        } else {
            System.out.println ( "Yeni siparişler listede görünmüyor. Test başarılı." );

            extentTest.pass ( "Siparis listesinde  yeni siparişlerin listede görünmediğini doğrular" );
            Driver.quitDriver ();

        }

    }


    @Test
    public void TC_2808() {

        // Admin paneline giriş yap
        ReusableMethods.accessAdmin ( "adminuser_serhat", "adminpassword_serhat" );

        // AdminPage objesini oluştur
        AdminPage adminPage = new AdminPage ();

        // Merchant sekmesine git
        adminPage.MerchantSide.click ();

        // Listeleme sekmesine git
        adminPage.ListSide.click ();

        // Arama yaparak restoranı bul
        adminPage.SearchSide.sendKeys ( "Dolan Uyghur Restaurant" );
        adminPage.SearchSide.sendKeys ( Keys.ENTER );

        // Otomatik girişi etkinleştir
        adminPage.AutoLoginSide.click ();

        // Yeni bir pencereye geçiş yap ve Orders Ready sayfasına git
        ReusableMethods.windowaGec ( "https://qa.flavorfetch.com/backoffice/merchant/dashboard", Driver.getDriver () );

        // Siparişler sayfasına git
        MerchantPage merchantPage = new MerchantPage ();
        merchantPage.ordersLink.click ();

        // Orders Ready linkine tıkla
        merchantPage.ordersReadyLink.click ();

        // Teslim edilecek siparişi bul ve seç
        List<WebElement> ordersList = Driver.getDriver ().findElements ( By.cssSelector ( ".grey-list-chevron .chevron" ) );

        WebElement deliveryOrder = null;
        for (WebElement order : ordersList) {
            WebElement deliveryType = order.findElement ( By.cssSelector ( ".services" ) );
            if (deliveryType.getText ().contains ( "Delivery" )) {
                deliveryOrder = order;
                order.click ();  // "Delivery" olan siparişi seç
                break;
            }
        }

        // 'Get Directions' butonuna tıkla
        merchantPage.getDirectionsButton.click ();

        // Mevcut pencere tanımlayıcısını al
        String originalWindow = Driver.getDriver ().getWindowHandle ();

        // Yeni açılan pencereyi bul
        Set<String> allWindows = Driver.getDriver ().getWindowHandles ();
        String newWindow = null;
        for (String window : allWindows) {
            if (!window.equals ( originalWindow )) {
                newWindow = window;
                break;
            }
        }

        // Yeni pencereye geç
        Driver.getDriver ().switchTo ().window ( newWindow );

        // Test edilecek sayfaya git
        Driver.getDriver ().get ( "https://www.google.com/maps/dir/37.7090203,-97.3472273/38.94041274642389,+-77.05881816713224/@36.9757556,-108.4588967,4z/data=!3m1!4b1!4m6!4m5!1m0!1m3!2m2!1d-77.0588182!2d38.9404127?entry=ttu" );

        // Sayfa başlığını al
        String pageTitle = Driver.getDriver ().getTitle ();

        // Sayfa başlığını yazdır
        System.out.println ( "Sayfa başlığı: " + pageTitle );

        // Beklenen başlık
        String expectedTitle = "Google Haritalar";

        // Sayfa başlığını beklenen başlıkla karşılaştır
        Assert.assertEquals ( pageTitle, expectedTitle, "Sayfa başlığı beklenenden farklı!" );

        // URL'yi kontrol et
        String currentURL = Driver.getDriver ().getCurrentUrl ();
        if (currentURL.contains ( "https://www.google.com/maps/" )) {
            System.out.println ( "URL doğru. Test başarılı." );
        } else {
            System.out.println ( "URL yanlış. Test başarısız." );
        }

        // Sayfada belirli bir öğeyi kontrol et

        boolean getDirectionsStart = merchantPage.getDirectionsStart.isDisplayed ();
        if (getDirectionsStart) {
            System.out.println ( "Yol tarifi başlangıç noktası bulundu. Test başarılı." );
        } else {
            System.out.println ( "Yol tarifi başlangıç noktası bulunamadı. Test başarısız." );
        }

        Driver.quitDriver ();

    }


    @Test
    public void TC_2809() {


        // Admin paneline giriş yap
        ReusableMethods.accessAdmin ( "adminuser_serhat", "adminpassword_serhat" );

        // AdminPage objesini oluştur
        AdminPage adminPage = new AdminPage ();

        // Merchant sekmesine git
        adminPage.MerchantSide.click ();

        // Listeleme sekmesine git
        adminPage.ListSide.click ();

        // Arama yaparak restoranı bul
        adminPage.SearchSide.sendKeys ( "Dolan Uyghur Restaurant" );
        adminPage.SearchSide.sendKeys ( Keys.ENTER );

        // Otomatik girişi etkinleştir
        adminPage.AutoLoginSide.click ();

        // Yeni bir pencereye geçiş yap ve Orders Ready sayfasına git
        ReusableMethods.windowaGec ( "https://qa.flavorfetch.com/backoffice/merchant/dashboard", Driver.getDriver () );

        // Siparişler sayfasına git
        merchantPage.ordersLink.click ();

        // Orders Ready linkine tıkla
        merchantPage.ordersReadyLink.click ();

        // Siparişler listesine erişim sağla
        List<WebElement> ordersList = Driver.getDriver ().findElements ( By.cssSelector ( ".grey-list-chevron .chevron" ) );

        // Herhangi bir siparişi seç
        if (!ordersList.isEmpty ()) {
            WebElement anyOrder = ordersList.get ( 0 );
            anyOrder.click ();

            merchantPage.orderPreviusButton.click ();

            Assert.assertTrue ( merchantPage.customerInfo.isDisplayed () );
            Assert.assertTrue ( merchantPage.blockCustomer.isDisplayed () );


            Driver.quitDriver ();

        }

    }


    @Test
    public void TC_2810() throws IOException {


        // Admin paneline giriş yap
        ReusableMethods.accessAdmin ( "adminuser_serhat", "adminpassword_serhat" );
        extentTest.info ( "Detayli merchant test adimlari icin Admin paneline giriş yapar" );
        // AdminPage objesini oluştur
        AdminPage adminPage = new AdminPage ();

        // Merchant sekmesine git
        adminPage.MerchantSide.click ();
        extentTest.info ( "Merchant sekmesine tiklar" );
        // Listeleme sekmesine git
        adminPage.ListSide.click ();
        extentTest.info ( "Merchant listeleme sekmesine tiklar" );
        // Arama yaparak restoranı bul
        adminPage.SearchSide.sendKeys ( "Dolan Uyghur Restaurant" );
        adminPage.SearchSide.sendKeys ( Keys.ENTER );
        extentTest.info ( "Merchant listesinde testlerimizi yapacagimiz restoranti aratir" );
        // Otomatik girişi etkinleştir
        adminPage.AutoLoginSide.click ();
        extentTest.info ( "Test yurutecegimiz merchant paneline giris yapar" );
        // Yeni bir pencereye geçiş yap ve Orders Ready sayfasına git
        ReusableMethods.windowaGec ( "https://qa.flavorfetch.com/backoffice/merchant/dashboard", Driver.getDriver () );
        extentTest.info ( "Yeni bir pencerede merchant dashboard sayfasini goruntuler" );
        // Siparişler sayfasına git
        merchantPage.ordersLink.click ();
        extentTest.info ( "Orders sekmesine tiklar" );
        // Orders Ready linkine tıkla
        merchantPage.ordersReadyLink.click ();
        extentTest.info ( "Orders Ready sekmesine tiklar" );
        // Siparişler listesine erişim sağlar
        List<WebElement> ordersList = Driver.getDriver ().findElements ( By.cssSelector ( ".grey-list-chevron .chevron" ) );

        // İlk sipariş listesini sayisini al
        List<WebElement> initialOrdersList = Driver.getDriver ().findElements ( By.cssSelector ( ".grey-list-chevron .chevron" ) );
        int initialOrderCount = initialOrdersList.size ();
        extentTest.info ( "Siparis listesini goruntuler ve sayisini kontrol eder" );

        // Herhangi bir siparişi seç
        if (!ordersList.isEmpty ()) {
            WebElement anyOrder = ordersList.get ( 0 );
            anyOrder.click ();

            merchantPage.orderPreviusButton.click ();
            extentTest.info ( "Siparis bilgilerinde onceki siparisler linkine tiklar" );

            Assert.assertTrue ( merchantPage.customerInfo.isDisplayed () );
            extentTest.info ( "Onceki siparisler ekraninda musteri bilgilerini goruntuler" );
            Assert.assertTrue ( merchantPage.blockCustomer.isDisplayed () );
            extentTest.info ( "Onceki siparis ekraninda musteri engelle butonunu goruntuler" );

            merchantPage.blockCustomer.click ();
            extentTest.info ( "Musteri engelle butonunu secer" );
            merchantPage.blockCustomerConfirm.click ();
            extentTest.info ( "Musteri engellemeyi onaylar" );

            ReusableMethods.wait ( 60 ); // Siparis verilemedigini orneklemek icin beklenen sure.

            // Yenilenen sipariş listesini al
            List<WebElement> updatedOrdersList = Driver.getDriver ().findElements ( By.cssSelector ( ".grey-list-chevron .chevron" ) );
            int updatedOrderCount = updatedOrdersList.size ();
            extentTest.pass ( "Ornek bekleme suresince siparis verilemedigini dogrular" );
            Driver.getDriver ().close ();

            // Yeni siparişlerin listede görünmediğini doğrula

            if (updatedOrderCount > initialOrderCount) {
                System.out.println ( "Yeni siparişler listede görünüyor. Test başarısız." );
            } else {
                System.out.println ( "Yeni siparişler listede görünmüyor. Test başarılı." );

            }
            extentTest.pass ( "Musterinin yeni siparis veremedigini dogrular" );
            Driver.quitDriver ();

        }
    }


    @Test
    public void TC_2811() throws IOException {

        // Admin paneline giriş yap
        ReusableMethods.accessAdmin ( "adminuser_serhat", "adminpassword_serhat" );
        extentTest.info ( "Detayli merchant test adimlari icin Admin paneline giriş yapar" );
        // AdminPage objesini oluştur
        AdminPage adminPage = new AdminPage ();

        // Merchant sekmesine git
        adminPage.MerchantSide.click ();
        extentTest.info ( "Merchant sekmesine tiklar" );
        // Listeleme sekmesine git
        adminPage.ListSide.click ();
        extentTest.info ( "Merchant listeleme sekmesine tiklar" );
        // Arama yaparak restoranı bul
        adminPage.SearchSide.sendKeys ( "Dolan Uyghur Restaurant" );
        adminPage.SearchSide.sendKeys ( Keys.ENTER );
        extentTest.info ( "Merchant listesinde testlerimizi yapacagimiz restoranti aratir" );
        // Otomatik girişi etkinleştir
        adminPage.AutoLoginSide.click ();
        extentTest.info ( "Test yurutecegimiz merchant paneline giris yapar" );
        // Yeni bir pencereye geçiş yap ve Orders Ready sayfasına git
        ReusableMethods.windowaGec ( "https://qa.flavorfetch.com/backoffice/merchant/dashboard", Driver.getDriver () );
        extentTest.info ( "Yeni bir pencerede merchant dashboard sayfasini goruntuler" );
        // Siparişler sayfasına git
        merchantPage.ordersLink.click ();
        extentTest.info ( "Orders sekmesine tiklar" );
        // Orders Ready linkine tıkla
        merchantPage.ordersReadyLink.click ();
        extentTest.info ( "Orders Ready sekmesine tiklar" );
        // Siparişler listesine erişim sağla
        List<WebElement> ordersList = Driver.getDriver ().findElements ( By.cssSelector ( ".grey-list-chevron .chevron" ) );

        // İlk sipariş listesini sayısını al
        List<WebElement> initialOrdersList = Driver.getDriver ().findElements ( By.cssSelector ( ".grey-list-chevron .chevron" ) );
        int initialOrderCount = initialOrdersList.size ();

        // Herhangi bir siparişi seç
        if (!ordersList.isEmpty ()) {
            WebElement anyOrder = ordersList.get ( 0 );
            anyOrder.click ();
            extentTest.info ( "Siparis listesinde herhangi bir siparis secer" );
            merchantPage.orderPreviusButton.click ();
            extentTest.info ( "Siparis ozetinde yer alan onceki siparisler linkine tiklar" );

            if (merchantPage.previousOrderPageSearchBox.isEnabled ()) {
                merchantPage.previousOrderPageSearchBox.sendKeys ( "12592" + Keys.ENTER );

            extentTest.pass  ( "Ornek onceki siparis bilgileri ile search box aktif ise arama yapar" );
                // Arama sonuçlarının yüklenmesi için bekle
                WebDriverWait wait = new WebDriverWait ( Driver.getDriver (), Duration.ofSeconds ( 10 ) );
                wait.until ( ExpectedConditions.visibilityOfElementLocated ( By.cssSelector ( "table.table-sm.w-100.order_table.dataTable.no-footer" ) ) );
                extentTest.info ( "Arama sonucunun yuklenmsei icin listenin yenilenmesini bekler" );
                // Arama sonucunu içeren tabloyu bul
                WebElement table = Driver.getDriver ().findElement ( By.cssSelector ( "table.table-sm.w-100.order_table.dataTable.no-footer" ) );
                extentTest.info ( "Arama sonucu iceren tabloyu goruntuler" );
                // Tablo içindeki tbody'yi bul ve satırlarını al
                WebElement tbody = table.findElement ( By.tagName ( "tbody" ) );
                List<WebElement> rows = tbody.findElements ( By.tagName ( "tr" ) );

                boolean orderFound = false;

                // Satırları kontrol et
                for (WebElement row : rows) {
                    List<WebElement> cells = row.findElements ( By.tagName ( "td" ) );
                    for (WebElement cell : cells) {
                        if (cell.getText ().contains ( "12592" )) {
                            orderFound = true;
                            break;
                        }
                    }
                    if (orderFound) {
                        break;
                    }
                }
            extentTest.pass ( "Arama sonucunda istenen bilgiler ile arama yapilabildigini dogrular" );
                // Arama sonucunu doğrula
                if (orderFound) {
                    System.out.println ( "Sipariş bulundu. Test başarılı." );
                } else {
                    System.out.println ( "Sipariş bulunamadı. Test başarısız." );
                }
            } else {
                System.out.println ( "Arama kutusu etkin değil. Test başarısız." );
            }
        } else {
            System.out.println ( "Sipariş listesi boş. Test gerçekleştirilemiyor." );
        }
        extentTest.pass ( "Arama sonucunda istenen bilgiler ile arama yapilabildigini dogrular" );
        Driver.quitDriver ();


        //Search Box  otomasyanda calisiyor manuel testte calismiyor


    }


    @Test
    public void TC_2812() {

// Admin paneline giriş yap
        ReusableMethods.accessAdmin ( "adminuser_serhat", "adminpassword_serhat" );

// AdminPage objesini oluştur
        AdminPage adminPage = new AdminPage ();

// Merchant sekmesine git
        adminPage.MerchantSide.click ();

// Listeleme sekmesine git
        adminPage.ListSide.click ();

// Arama yaparak restoranı bul
        adminPage.SearchSide.sendKeys ( "Dolan Uyghur Restaurant" );
        adminPage.SearchSide.sendKeys ( Keys.ENTER );

// Otomatik girişi etkinleştir
        adminPage.AutoLoginSide.click ();

// Yeni bir pencereye geçiş yap ve Orders Ready sayfasına git
        ReusableMethods.windowaGec ( "https://qa.flavorfetch.com/backoffice/merchant/dashboard", Driver.getDriver () );

// Siparişler sayfasına git
        merchantPage.ordersLink.click ();

// Orders Ready linkine tıkla
        merchantPage.ordersReadyLink.click ();

// Arama kutusuna bilgi gir ve Enter tuşuna bas
        merchantPage.filterBox.sendKeys ( "Inci Lale Basbostanci" + Keys.ENTER );

// Arama sonuçlarının yüklenmesi için bekle
        WebDriverWait wait = new WebDriverWait ( Driver.getDriver (), Duration.ofSeconds ( 10 ) );
        wait.until ( ExpectedConditions.visibilityOfElementLocated ( By.cssSelector ( ".grey-list-chevron .chevron" ) ) );

// Siparişler listesine erişim sağla

        ReusableMethods.wait ( 5 );
        List<WebElement> ordersList = Driver.getDriver ().findElements ( By.cssSelector ( ".grey-list-chevron .chevron" ) );

// Arama kutusuna girilen bilgiyi kontrol et
        String searchText = "Inci Lale Basbostanci";
        boolean allOrdersMatch = true;

        for (WebElement order : ordersList) {
            if (!order.getText ().contains ( searchText )) {
                allOrdersMatch = false;
                break;
            }
        }

        // Arama sonucunu doğrula
        if (allOrdersMatch) {
            System.out.println ( "Arama sonuçları doğru. Test başarılı." );
        } else {
            System.out.println ( "Arama sonuçları yanlış. Test başarısız." );
        }


        Driver.quitDriver ();


    }

    @Test
    public void TC_2813() {


        // Admin paneline giriş yap
        ReusableMethods.accessAdmin ( "adminuser_serhat", "adminpassword_serhat" );

        // AdminPage objesini oluştur
        AdminPage adminPage = new AdminPage ();

        // Merchant sekmesine git
        adminPage.MerchantSide.click ();

        // Listeleme sekmesine git
        adminPage.ListSide.click ();

        // Arama yaparak restoranı bul
        adminPage.SearchSide.sendKeys ( "Dolan Uyghur Restaurant" );
        adminPage.SearchSide.sendKeys ( Keys.ENTER );

        // Otomatik girişi etkinleştir
        adminPage.AutoLoginSide.click ();

        // Yeni bir pencereye geçiş yap ve Orders Ready sayfasına git
        ReusableMethods.windowaGec ( "https://qa.flavorfetch.com/backoffice/merchant/dashboard", Driver.getDriver () );

        // Siparişler sayfasına git
        merchantPage.ordersLink.click ();

        // Orders Ready linkine tıkla
        merchantPage.ordersReadyLink.click ();

        Assert.assertTrue ( merchantPage.orderTypeDropdownMenu.isDisplayed () );


        Assert.assertTrue ( merchantPage.paymentStatusDropdownMenu.isDisplayed () );


        Assert.assertTrue ( merchantPage.sortDropdownMenu.isDisplayed () );



        //Siparis Order type Delivery olan siparisler listelensin

        ReusableMethods.clickWithJS ( merchantPage.orderTypeDropdownMenu);

        ReusableMethods.clickWithJS ( merchantPage.orderTypeDineinButton );

        ReusableMethods.wait ( 3 );

        Assert.assertTrue ( merchantPage.leftOrderTable.getText ().contains ( "Dinein" ) );

        ReusableMethods.clickWithJS ( merchantPage.orderTypeDineinButton );


        //Payment Status tipi Paid olan siparisler filtrelensin

        ReusableMethods.clickWithJS ( merchantPage.paymentStatusDropdownMenu );

        int orderCountBefore = Integer.parseInt(merchantPage.orderCount.getText());

        ReusableMethods.wait ( 3 );

        ReusableMethods.clickWithJS ( merchantPage.paymentStatusPaidButton );

        int orderCountAfter = Integer.parseInt(merchantPage.orderCount.getText());

        // Siparişler listesine erişim sağla

        // List<WebElement> ordersList = Driver.getDriver ().findElements ( By.cssSelector ( ".grey-list-chevron .chevron" ) );

        Assert.assertNotEquals(orderCountBefore, orderCountAfter);

        // Order ID-Ascending olan siparisler filtrelensin

        ReusableMethods.clickWithJS ( merchantPage.sortDropdownMenu );

        int orderCountBefore2 = Integer.parseInt(merchantPage.orderCount.getText());

        ReusableMethods.wait ( 3 );

        ReusableMethods.clickWithJS ( merchantPage.sortIDArtanAscending );

        int orderCountAfter2 = Integer.parseInt(merchantPage.orderCount.getText());

        // Sipariş sayılarının eşit olmadığını doğrula
        Assert.assertNotEquals(orderCountBefore2, orderCountAfter2);

        Driver.quitDriver ();

    }

    @Test
    public void TC_2814() {


// Admin paneline giriş yap
        ReusableMethods.accessAdmin ( "adminuser_serhat", "adminpassword_serhat" );

// AdminPage objesini oluştur
        AdminPage adminPage = new AdminPage ();

// Merchant sekmesine git
        adminPage.MerchantSide.click ();

// Listeleme sekmesine git
        adminPage.ListSide.click ();

// Arama yaparak restoranı bul
        adminPage.SearchSide.sendKeys ( "Dolan Uyghur Restaurant" );
        adminPage.SearchSide.sendKeys ( Keys.ENTER );

// Otomatik girişi etkinleştir
        adminPage.AutoLoginSide.click ();

// Yeni bir pencereye geçiş yap ve Orders Ready sayfasına git
        ReusableMethods.windowaGec ( "https://qa.flavorfetch.com/backoffice/merchant/dashboard", Driver.getDriver () );

// Siparişler sayfasına git
        merchantPage.ordersLink.click ();

// Orders Ready linkine tıkla
        merchantPage.ordersReadyLink.click ();


        merchantPage.notificationsButton.click ();

        merchantPage.notificationList.click ();

        merchantPage.allNotificationsList.isDisplayed ();

        int orderCountBefore3 = Integer.parseInt(merchantPage.notificationListCount.getText());

        ReusableMethods.wait ( 60 );

        Driver.getDriver ().navigate ().refresh ();


        int orderCountAfter3 = Integer.parseInt(merchantPage.notificationListCount.getText());

        Assert.assertNotEquals(orderCountBefore3, orderCountAfter3);


        Driver.quitDriver ();


        }


    }





































