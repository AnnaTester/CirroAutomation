package Cirro.Pages;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;




public class MemDashboard {

	WebDriver driver;
	By accounStatus = By.xpath("//span[@class='label label-warning']");
	 
	public MemDashboard (WebDriver driver){
		this.driver = driver;
	}
	
	public void CheckLoginResult (){
	    WebDriverWait wait1 = new WebDriverWait(driver, 3);
	   try{
	        wait1.until(ExpectedConditions.urlMatches("https://staging.cirrocapital.com/dashboard"));
	        System.out.println(" Login Successful - Passed");
	        }catch(TimeoutException ex)
	        {
	        	List <WebElement> errorMessage = driver.findElements(By.xpath("//span[contains(text(),'Invalid Credentials')]"));
	        	if (errorMessage.isEmpty()==false)
	        		if(errorMessage.get(0).isDisplayed()== true)
	        			System.out.println(" Login Unsuccessful - Invalid Credentials");
	        	errorMessage = driver.findElements(By.xpath("//span[contains(text(),'Invalid Captcha')]"));
	        	if (errorMessage.isEmpty()==false)
	        		if (errorMessage.get(0).isDisplayed()== true)
	        			System.out.println(" Login Unsuccessful - Invalid Captcha");
	        }
	}
	
/*public String getAccountStatus (){
		By accounStatus = By.xpath("//span[@class='label label-warning']");
		return driver.findElement(accounStatus).getText();
	}*/
	
	/**
	 * Click on a link on the page
	 * @param string linkText The link text
	 */
	public void clickLink( String linkText ) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.urlMatches("https://staging.cirrocapital.com/dashboard"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("page-header")));
		WebElement box = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("app-body-vue")));
		
		if ( box == null ) {
			return;
		}
		List<WebElement> links = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#app-body-vue header.text-capitalize a")));
		if ( null == links || links.size() == 0 ) {
			System.out.println("There is no link in this page");
			return;
		}
		for (WebElement webElement : links) {
			if ( webElement.getText().equalsIgnoreCase(linkText) ) {
				wait.until(ExpectedConditions.elementToBeClickable(webElement));
				webElement.click();
				wait.until(ExpectedConditions.stalenessOf(webElement));
				return;
			}
		}
		System.out.println("Cannot find link: " + linkText);
	}
	
	public boolean elementIsStale( WebElement element ) {
		try {
            element.findElement(By.id("doesnt-matter")); 
            return false;
		} catch ( StaleElementReferenceException e) {
            return true;
		} catch( Exception e ) {
			return false;
		}
	}
	
	public void goToMyWallet() {
		WebDriverWait wait2 = new WebDriverWait(driver, 3);
		WebElement myWallet = wait2.until(ExpectedConditions.elementToBeClickable(By.linkText("My Wallet")));
		myWallet.click();
	}
	
	public void goToMyAccount(){
		WebDriverWait wait2 = new WebDriverWait(driver, 3);
		WebElement myAccount = wait2.until(ExpectedConditions.elementToBeClickable(By.linkText("My Account")));
		myAccount.click();
		WebElement identityVeri = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[contains(text(),'Identity Verification')]")));
		identityVeri.click();
		WebElement uploadPP = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'upload passport')]")));
		uploadPP.click();
		//driver.findElement(By.xpath("//input[@id='passport_document']")).sendKeys("/Users/annathan/Desktop/Pic#/128809335907.jpg");
		
	}
	
	public static void setClipboardData(String string) {
		   StringSelection stringSelection = new StringSelection(string);
		   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		}
	
}
