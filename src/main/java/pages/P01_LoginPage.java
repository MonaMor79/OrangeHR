package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_LoginPage {
    // Define Locators
    private final By userNameLocator= new By.ByXPath("(//input)[@placeholder='Username']");
    private final By passwordLocator=new By.ByXPath("(//input)[@name='password']");

    private final By loginLocator=new By.ByXPath("(//button)[@type='submit']");

    private final By verifyLocator=new By.ByXPath("(//h6)[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");

    // Define driver
    private WebDriver driver;
    // Define Constructor
    public P01_LoginPage(WebDriver driver){
        this.driver= driver;
    }
    // Define public method
    public void loginMethod(String userNameLocator,String passwordLocator ){
        driver.findElement(this.userNameLocator).sendKeys(userNameLocator);
        driver.findElement(this.passwordLocator).sendKeys(passwordLocator);
        driver.findElement(loginLocator).click();
    }
    public boolean verifyLogin(){
        if(driver.findElement(this.verifyLocator).getText().equals("Dashboard"))
            return true;
        else return false;
    }

}
