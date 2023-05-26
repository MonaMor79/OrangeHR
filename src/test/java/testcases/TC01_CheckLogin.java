package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.P01_LoginPage;
import pages.P02_AdminPage;
import pages.P03_DeletePage;
import utility.Utilities;

public class TC01_CheckLogin extends TestBase{
    // define pages
    P01_LoginPage loginPage;
    P02_AdminPage adminPage;
    P03_DeletePage deletePage;

    // check valid login
    @Test(priority = 1,description = "Check E2E test secnario")
    public void testCase01() throws InterruptedException {
        // declaration
        loginPage=new P01_LoginPage(driver);
        adminPage=new P02_AdminPage(driver);
        deletePage=new P03_DeletePage(driver);

        // login to app
        loginPage.loginMethod("Admin","admin123");
        // assert if login correctly
        Assert.assertTrue(loginPage.verifyLogin());
        // take screenshot
        Utilities.captureScreenshot(driver,"HomePage");
        // scroll down
        Utilities.scrollWithSpecificSize(driver,0,1000);
        adminPage.clickAdminPanel();
        adminPage.clickAddButton();
        adminPage.selectUserRole();
        adminPage.selectStatus();
        adminPage.selectEmployeeName();
        Thread.sleep(3000);

        adminPage.insertUserName("MonaK");
        adminPage.insertPassword();
        adminPage.confirmPassword();
        adminPage.clickSave();
        Thread.sleep(5000);

        deletePage.fillUserName("MonaK");
        deletePage.clickSearchButton();
        deletePage.clickDeleteButton();
        deletePage.confirmDelete();
        Thread.sleep(10000);
    }
}
