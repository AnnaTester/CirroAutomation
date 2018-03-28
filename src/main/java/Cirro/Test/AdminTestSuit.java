package Cirro.Test;


import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Cirro.Pages.AdminLoginPage;
import Cirro.Pages.WalletPage;
import junit.framework.Assert;
import Cirro.Pages.AdminDashboard;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

public class AdminTestSuit  {
	
	WebDriver driver;
	AdminLoginPage objAdLogin;
	AdminDashboard objADashboard;
   
	@BeforeMethod
	@Parameters({"browser", "username", "password", "captcha"})
	public void setup( String browser, String username, String password, String captcha  ){
		System.out.println(browser);
		if ( browser != null && browser.equals("firefox") ) {
			String exePath = "/Users/annathan/Downloads/geckodriver";
			System.setProperty("webdriver.gecko.driver", exePath);
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.pollingEvery(200, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
        driver.get("https://astaging.cirrocapital.com/login");   
        objAdLogin = new AdminLoginPage(driver);
	    objAdLogin.adminLoginFunction(username, password, captcha);
        objADashboard = new AdminDashboard(driver);
        objADashboard.CheckLoginResult();
    }
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void checkUserAccountStatus(){
		objADashboard = new AdminDashboard (driver);
		//System.out.println(objADashboard.getAccountStatus());
		Assert.assertEquals(true,objADashboard.getAccountStatus().contentEquals("Aadmin, Administrator: Aadmin"));
	}
	
	@Test
	public void goToClientManagement() {
		objADashboard = new AdminDashboard(driver);
		objADashboard.goToClientManagement();
		Assert.assertEquals(true, driver.getCurrentUrl().matches("https://astaging.cirrocapital.com/user/mgmt"));
	}
	
	@Test
	public void goToPlanManagement() {
		objADashboard = new AdminDashboard(driver);
		objADashboard.goToPlanManagement();
		Assert.assertEquals(true, driver.getCurrentUrl().matches("https://astaging.cirrocapital.com/subscription"));
	}
	
	@Test
	public void goToWalletManagement() {
		objADashboard = new AdminDashboard(driver);
		objADashboard.goToWalletManagement();
		Assert.assertEquals(true, driver.getCurrentUrl().matches("https://astaging.cirrocapital.com/wallet"));
	}
	
	/*@Test
	public void goToCredit() {
		objADashboard = new AdminDashboard(driver);
		objADashboard.goToCredit();
		System.out.println("abc" + driver.getCurrentUrl());
		
		//Assert.assertEquals(true, driver.getCurrentUrl().matches("https://astaging.cirrocapital.com/credit"));
	}
	
	@Test
	public void goToReward() {
		objADashboard = new AdminDashboard(driver);
		objADashboard.goToCredit();
		System.out.println("abc" + driver.getCurrentUrl());
		Assert.assertEquals(true, driver.getCurrentUrl().matches("https://astaging.cirrocapital.com/reward"));
	}
	*/
	@Test
	public void goToNetworks() {
		objADashboard = new AdminDashboard(driver);
		objADashboard.goToNetwork();
		Assert.assertEquals(true, driver.getCurrentUrl().matches("https://astaging.cirrocapital.com/network"));
	}
	
	@Test
	public void placementViewAll() {
		objADashboard = new AdminDashboard(driver);
		objADashboard.goToNetwork();
		Assert.assertEquals(true, driver.getCurrentUrl().matches("https://astaging.cirrocapital.com/network"));
	}
	
	@Test
	public void goToSupportTicket() {
		objADashboard = new AdminDashboard(driver);
		objADashboard.goToSupportTicket();
		Assert.assertEquals(true, driver.getCurrentUrl().matches("https://astaging.cirrocapital.com/support"));
	}
	
	@Test
	public void goToReport() {
		objADashboard = new AdminDashboard(driver);
		objADashboard.goToReport();
		Assert.assertEquals(true, driver.getCurrentUrl().matches("https://astaging.cirrocapital.com/report"));
	}
	
	@Test
	public void goToSystemConfig() {
		objADashboard = new AdminDashboard(driver);
		objADashboard.goToSystemConfig();
		Assert.assertEquals(true, driver.getCurrentUrl().matches("https://astaging.cirrocapital.com/config"));
	}
	
	@Test
	public void goToMyAccount() {
		objADashboard = new AdminDashboard(driver);
		objADashboard.goToMyAccount();
		Assert.assertEquals(true, driver.getCurrentUrl().matches("https://astaging.cirrocapital.com/profile"));
	}
	

	/*@Test
	public void goToCirroCredits() {
		objADashboard = new AdminDashboard(driver);
		objADashboard.clickLink( "cirro credits" );
		BasePage page = new BasePage( driver );
		Assert.assertEquals(true, page.isPermissionDenied());
		
	}
	
	@Test
	public void goToUSDCredit() {
		objADashboard = new AdminDashboard(driver);
		objADashboard.clickLink( "USD Credits" );
		BasePage page = new BasePage( driver );
		Assert.assertEquals(true, page.isPermissionDenied());
	}
	
	@Test
	public void goToShoppingCredits() {
		objADashboard = new AdminDashboard(driver);
		objADashboard.clickLink("Shopping Credits");
		BasePage page = new BasePage( driver );
		Assert.assertEquals(true, page.isPermissionDenied());
	}
	
	@Test
	public void goToMyWallet(){
		objADashboard = new AdminDashboard(driver);
		objADashboard.goToMyWallet();
		Assert.assertEquals(true, driver.getCurrentUrl().matches("https://staging.cirrocapital.com/wallet"));
	}
*/
}