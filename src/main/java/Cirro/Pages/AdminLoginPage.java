package Cirro.Pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AdminLoginPage   {
    By login = By.xpath("//button[@class='btn btn-primary lg-btn text-capitalize']");
	WebDriver driver;
	WebDriverWait wait1;
	
	public AdminLoginPage(WebDriver driver)
	{	
		this.driver = driver;
		wait1= new WebDriverWait(driver, 10);
	}
	//Set client ID in ClientID textbox

	public void setUserID(String adminID){
		WebElement clientID = wait1.until(ExpectedConditions.elementToBeClickable(By.id("member_id")));
		clientID.sendKeys(adminID);
	}	
	
	//Set password in password textbox
    public void setPassword(String strPassword){
    	WebElement passWord = wait1.until(ExpectedConditions.elementToBeClickable(By.id("password")));
    	passWord.sendKeys(strPassword);
    }
  
    //Set captcha in captcha textbox
    public void setCaptcha(String strCaptcha){
    	WebElement captcha = wait1.until(ExpectedConditions.elementToBeClickable(By.id("captcha")));
    	captcha.sendKeys(strCaptcha);
    } 
    public void clickLogin(){
        driver.findElement(login).click();
    }
    
    public void adminLoginFunction (String adminID, String strPassword , String  strCaptcha){
	    this.setUserID(adminID);
	    this.setPassword(strPassword);
	    this.setCaptcha(strCaptcha);
	    this.clickLogin();   
    }
	
}