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

import Cirro.Pages.MemLoginPage;
import Cirro.Pages.WalletPage;
import junit.framework.Assert;
import Cirro.Pages.BasePage;
import Cirro.Pages.MemDashboard;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

public class AdminTestSuit  {
	
	WebDriver driver;
	MemLoginPage objLogin;
	MemDashboard objDashboard;
   
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
        objLogin = new MemLoginPage(driver);
	    objLogin.MemberLoginFunction(username, password, captcha);
        objDashboard = new MemDashboard(driver);
	   // objDashboard.CheckLoginResult();
    }
	/*public void setup () {	
		System.setProperty("webdriver.gecko.driver", "/Users/annathan/Downloads/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.toolsqa.com");
	}*/
	/*@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void checkUserAccountStatus(){
		objDashboard = new MemDashboard(driver);
		By accounStatus = By.xpath("//span[@class='label label-warning']");
		System.out.println(driver.findElement(accounStatus).getText());
		Assert.assertEquals(true,driver.findElement(accounStatus).getText().contentEquals("Account Status: Active (5 Days Left)"));
	}
	
	@Test
	public Boolean checkMyWalletMenu(){
		objDashboard = new MemDashboard(driver);
		objDashboard.goToMyWallet();
		if (driver.getCurrentUrl().matches("https://staging.cirrocapital.com/wallet"))
			return true;
		else 
			return false;
	}
	
	@Test
	public void goToDigicoin() {
		objDashboard = new MemDashboard(driver);
		objDashboard.clickLink("Digicoin");
		
		WalletPage wallet = new WalletPage( driver );
		Assert.assertEquals(true, wallet.isDigicoinOpened());
	}
	
	@Test
	public void goToCirroCredits() {
		objDashboard = new MemDashboard(driver);
		objDashboard.clickLink( "cirro credits" );
		BasePage page = new BasePage( driver );
		Assert.assertEquals(true, page.isPermissionDenied());
		
	}
	
	@Test
	public void goToUSDCredit() {
		objDashboard = new MemDashboard(driver);
		objDashboard.clickLink( "USD Credits" );
		BasePage page = new BasePage( driver );
		Assert.assertEquals(true, page.isPermissionDenied());
	}
	
	@Test
	public void goToShoppingCredits() {
		objDashboard = new MemDashboard(driver);
		objDashboard.clickLink("Shopping Credits");
		BasePage page = new BasePage( driver );
		Assert.assertEquals(true, page.isPermissionDenied());
	}
	
	@Test
	public void goToMyWallet(){
		objDashboard = new MemDashboard(driver);
		objDashboard.goToMyWallet();
		Assert.assertEquals(true, driver.getCurrentUrl().matches("https://staging.cirrocapital.com/wallet"));
	}
*/
}