package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;

public abstract class TestBaseRapor {
    protected static ExtentReports extentReports; // extent report'a ilk atamayı yapar
    protected static ExtentTest extentTest; // test pass veya failed gibi bilgileri kaydeder. Ayrıca ekran resmi için de kullanılır
    protected static ExtentHtmlReporter extentHtmlReporter; // Html raporu düzenler
    protected static String filePath;

    @BeforeMethod(alwaysRun = true)
    public void setUpMethod(ITestResult result) {
        // extentReports ve extentHtmlReporter nesnelerini başlatmak için gerekli değişiklikler
        String testName = result.getMethod().getMethodName();
        extentReports = new ExtentReports();
        extentTest = extentReports.createTest(testName);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownMethod(ITestResult result) throws Exception {
        String className = result.getTestClass().getRealClass().getSimpleName();
        String testName = result.getMethod().getMethodName();
        String browser = ConfigReader.getProperty("browser");

        if (result.getStatus() == ITestResult.FAILURE) {
            // FailedTests klasörü ve alt klasörü oluşturulur
            String directoryPath = System.getProperty("user.dir") + "/test-output/FailedTests/" + className + "/" + testName;
            File directory = new File(directoryPath);
            if (!directory.exists()) {
                directory.mkdirs(); // Klasörler oluşturulur
            }

            // Dosya yolunu güncelle
            String failedTestFilePath = directoryPath + "/" + testName + "_" + browser + ".html";

            extentHtmlReporter = new ExtentHtmlReporter(failedTestFilePath);
            extentHtmlReporter.config().setDocumentTitle("TestNG Test");
            extentHtmlReporter.config().setReportName(testName + " Report");
            extentHtmlReporter.config().setTheme(Theme.STANDARD);
            extentReports.attachReporter(extentHtmlReporter);

            // Ekran görüntüsünü belirtilen klasöre kaydet
            String screenshotLocation = ReusableMethods.getScreenshot(directoryPath, testName, browser);
            extentTest.fail(result.getName());
            extentTest.addScreenCaptureFromPath(screenshotLocation);
            extentTest.fail(result.getThrowable());

            extentReports.flush();
        } else if (result.getStatus() == ITestResult.SKIP) {
            extentTest.skip(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            extentTest.pass(result.getName());
        }

        // Genel rapor yerine her test için ayrı raporları flush yapıyoruz
        System.out.println("Driver kapatılıyor...");
        Driver.quitDriver();
        System.out.println("Driver başarıyla kapatıldı.");
    }
}
