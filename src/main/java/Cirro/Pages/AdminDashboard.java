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




public class AdminDashboard {

	WebDriver driver;
	By accounStatus = By.xpath("//span[@class='label label-warning']");
	 
	public AdminDashboard(WebDriver driver){
		this.driver = driver;
	}
	
	public void CheckLoginResult (){
	    WebDriverWait wait1 = new WebDriverWait(driver, 3);
	   try{
	        wait1.until(ExpectedConditions.urlMatches("https://astaging.cirrocapital.com/dashboard"));
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
	
public String getAccountStatus (){
		By accounStatus = By.xpath("//span[@class='label-info']");
		return driver.findElement(accounStatus).getText();
	}
	
	/**
	 * Click on a link on the page
	 * @param string linkText The link text
	 */
/*	public void clickLink( String linkText ) {
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
	*/
	public void goToMyWallet() {
		WebDriverWait wait2 = new WebDriverWait(driver, 3);
		WebElement myWallet = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'wallet management')]")));
		myWallet.click();
	}
	
	public void goToClientManagement() {
		WebDriverWait wait2 = new WebDriverWait(driver, 3);
		WebElement clientMgt = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Client management')]")));
		clientMgt.click();
	}
	
	public void goToPlanManagement() {
		WebDriverWait wait2 = new WebDriverWait(driver, 3);
		WebElement planMgt = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Plan Management')]")));
		planMgt.click();
	}
	
	public void goToWalletManagement() {
		WebDriverWait wait2 = new WebDriverWait(driver, 3);
		WebElement walletMgt = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'wallet management')]")));
		walletMgt.click();
	}
	
	public void goToCreditReward() {
		WebDriverWait wait2 = new WebDriverWait(driver, 3);
		WebElement creditReward = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'credit rewards')]")));
		creditReward.click();
	}
	
	public void goToCredit() {
		WebDriverWait wait2 = new WebDriverWait(driver, 3);
		WebElement credit = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'credit')]")));
		credit.click();
	}
	
	public void goToReward() {
		WebDriverWait wait2 = new WebDriverWait(driver, 3);
		WebElement credit = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'reward')]")));
		credit.click();
	}
	
	public void goToPlanManagement1() {
		WebDriverWait wait2 = new WebDriverWait(driver, 3);
		WebElement planMgt = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Plan Management')]")));
		planMgt.click();
	}
	
	public void goToNetwork() {
		WebDriverWait wait2 = new WebDriverWait(driver, 3);
		WebElement network = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'networks')]")));
		network.click();
	}
	

	public void goToSupportTicket() {
		WebDriverWait wait2 = new WebDriverWait(driver, 3);
		WebElement supportTick = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'support ticket')]")));
		supportTick.click();
	}
	

	public void goToReport() {
		WebDriverWait wait2 = new WebDriverWait(driver, 3);
		WebElement report = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'reports')]")));
		report.click();
	}
	
	public void goToSystemConfig() {
		WebDriverWait wait2 = new WebDriverWait(driver, 3);
		WebElement sysConfig = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'system config')]")));
		sysConfig.click();
	}
	
	public void goToMyAccount(){
		WebDriverWait wait2 = new WebDriverWait(driver, 3);
		WebElement myAccount = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'my account')]")));
		myAccount.click();
	}
	
	public void placementView(){
		WebDriverWait wait2 = new WebDriverWait(driver, 3);
		WebElement placementView = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[contains(text(),'Placement View')]")));
		placementView.click();
		WebElement expandAll = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-package text-capitalize')]")));
		expandAll.click();
	}
	
	public static void setClipboardData(String string) {
		   StringSelection stringSelection = new StringSelection(string);
		   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		}
	
}
