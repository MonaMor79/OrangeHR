package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class P02_AdminPage {
    // Define Locators
    private final By adminLocator= new By.ByXPath("//span[text()='Admin']");
    private final By addLocator= new By.ByXPath("//button[text()=' Add ']");
    private final By employeeNameLocator= new By.ByXPath("(//input)[2]");
    private final By userNameLocator= new By.ByXPath("(//input)[3]");
    private final By passwordLocator= new By.ByXPath("(//input)[4]");
    private final By confirmPasswordLocator= new By.ByXPath("(//input)[5]");
    private final By userRoleLocator= new By.ByXPath("(//div[@class=\"oxd-select-text-input\"])[1]");
    private final By statusLocator= new By.ByXPath("(//div[@class=\"oxd-select-text-input\"])[2]");
    private final By saveLocator=new By.ByXPath("(//button)[@type='submit']");
    // Define driver
    private WebDriver driver;
    // Define Constructor
    public P02_AdminPage(WebDriver driver){
        this.driver= driver;
    }
    // Define public method
    public void clickAdminPanel(){driver.findElement(adminLocator).click();}
    public void clickAddButton(){driver.findElement(addLocator).click();}
    public void selectUserRole(){
        driver.findElement(userRoleLocator).click();
        driver.findElement(userRoleLocator).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(userRoleLocator).sendKeys(Keys.ENTER);
    }
    public void selectStatus(){
        driver.findElement(statusLocator).click();
        driver.findElement(statusLocator).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(statusLocator).sendKeys(Keys.ENTER);
    }
    public void selectEmployeeName() throws InterruptedException {
        driver.findElement(employeeNameLocator).sendKeys("o");
        Thread.sleep(3000);
        driver.findElement(employeeNameLocator).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(employeeNameLocator).sendKeys(Keys.ENTER);
    }
    public void insertUserName(String userName ){
        driver.findElement(userNameLocator).sendKeys(userName);
    }
    public void insertPassword( ){
        driver.findElement(passwordLocator).sendKeys("Aa@1234#");
    }
    public void confirmPassword( ){
        driver.findElement(confirmPasswordLocator).sendKeys("Aa@1234#");
    }
    public void clickSave( ){
        driver.findElement(saveLocator).click();
    }




}
