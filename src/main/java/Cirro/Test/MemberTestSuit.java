package Cirro.Test;


import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

public class MemberTestSuit  {
	
	WebDriver driver;
	MemLoginPage objLogin;
	MemDashboard objDashboard;
   
	@BeforeMethod
	@Parameters({"browser", "username", "password", "captcha"})
	public void setup( String browser, String username, String password, String captcha  ){
		System.out.println(browser);
		if ( browser != null && browser.equals("chrome") ) {
			String exePath = "/Users/annathan/Downloads/chromedriver";
			System.setProperty("webdriver.chrome.driver", exePath);
			driver = new ChromeDriver();
		} else {
			driver = new FirefoxDriver();
		}
		WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.pollingEvery(200, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
        driver.get("https://staging.cirrocapital.com/login");   
        objLogin = new MemLoginPage(driver);
	    objLogin.MemberLoginFunction(username, password, captcha);
        objDashboard = new MemDashboard(driver);
	    objDashboard.CheckLoginResult();
    }
	@AfterMethod
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
	
	@Test
	public void identityUpload () throws AWTException{
		objDashboard = new MemDashboard(driver);
		/*Assert.assertEquals(true, driver.getCurrentUrl().matches("https://staging.cirrocapital.com/profile"));*/
		objDashboard.goToMyAccount();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//native key strokes for CTRL, V and ENTER keys
		objDashboard.setClipboardData("/Users/annathan/Desktop/Pic#/128809335907.jpg");
	    System.out.println("abc");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_META);
	    robot.keyPress(KeyEvent.VK_TAB);
	    robot.keyRelease(KeyEvent.VK_META);
	    robot.keyRelease(KeyEvent.VK_TAB);
	    robot.delay(500);
	    robot.keyPress(KeyEvent.VK_META);
	    robot.keyPress(KeyEvent.VK_SHIFT);
	    robot.keyPress(KeyEvent.VK_G);
	    robot.keyRelease(KeyEvent.VK_META);
	    robot.keyRelease(KeyEvent.VK_SHIFT);
	    robot.keyRelease(KeyEvent.VK_G);
	    robot.keyPress(KeyEvent.VK_META);
	    robot.keyPress(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_META);
	    robot.keyRelease(KeyEvent.VK_V);
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    robot.delay(500);
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
		WebDriverWait wait2 = new WebDriverWait(driver, 3);
	    System.out.println("abc1");
	    WebElement confirmButton = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-primary margin-top-30 text-capitalize']")));
		confirmButton.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement uploadSatus = wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='status--pending']")));
	    System.out.println("abc2");
		Assert.assertEquals(true, uploadSatus.isDisplayed());
	}
}