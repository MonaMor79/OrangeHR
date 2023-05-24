package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P03_DeletePage {
    // Define Locators
    private final By userNameLocator= new By.ByXPath("(//input)[2]");
    private final By searchButtonLocator= new By.ByXPath("//button[@type='submit']");
    private final By deleteButtonLocator= new By.ByXPath("(//button)[7]");
    private final By confirmDeleteLocator= new By.ByXPath("//button[normalize-space()='Yes, Delete']");

    // Define driver
    private WebDriver driver;
    // Define Constructor
    public P03_DeletePage(WebDriver driver){
        this.driver= driver;
    }
    // Define public method
    public void fillUserName(String userName){driver.findElement(userNameLocator).sendKeys(userName);}
    public void clickSearchButton(){driver.findElement(searchButtonLocator).click();}
    public void clickDeleteButton(){driver.findElement(deleteButtonLocator).click();}
    public void confirmDelete(){driver.findElement(confirmDeleteLocator).click();}

}
