package testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utility.Utilities;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestBase {

    protected Faker faker;
    protected ChromeOptions options;
    protected Map<String, Object> prefs;
    protected WebDriver driver;
    protected JavascriptExecutor js;
    // define extent report
    protected static ExtentSparkReporter htmlReporter;
    protected static ExtentReports extent;
    protected static ExtentTest test;
    @BeforeSuite
    public void defineSuiteElements() {
        // initialize the HtmlReporter
        htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/testReport.html");

        //initialize ExtentReports and attach the HtmlReporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        // initialize test
        test = extent.createTest("Orange HR"+" Test Automation Project");

        //configuration items to change the look and fee add content, manage tests etc
        htmlReporter.config().setDocumentTitle("Orange HR"+" Test Automation Report");
        htmlReporter.config().setReportName("Orange HR"+" Test Report");
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
    }
    @BeforeTest
    public void setupDriver(){
        //ToDo define java faker object
        faker=new Faker();
        //ToDo define new object
        options=new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-web-security");
        options.addArguments("--no-proxy-server");
        options.addArguments("--ignore-certificate-errors");
        prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver(options);

        js = (JavascriptExecutor) driver;

        // TODO: Open url
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        //TODO: manage window maximization
        driver.manage().window().maximize();

        // TODO: mnage implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterTest
    public void quit(){
        driver.quit();
    }
    @AfterSuite
    public void tearDown() throws IOException {
        extent.flush();
        //start html report after test end
        Utilities.startHtmlReport(System.getProperty("user.dir"), "testReport.html");
    }

    @AfterMethod
    public void getResult(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, result.getName()+" failed with the following error: "+result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, result.getName());
        } else
            test.log(Status.SKIP, result.getName());
    }

}