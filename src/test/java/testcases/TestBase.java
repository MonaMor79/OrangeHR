package testcases;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestBase {

    protected Faker faker;
    protected ChromeOptions options;
    protected Map<String, Object> prefs;
    protected WebDriver driver;
    protected JavascriptExecutor js;
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
    public void tearDown(){
        driver.quit();
    }
}