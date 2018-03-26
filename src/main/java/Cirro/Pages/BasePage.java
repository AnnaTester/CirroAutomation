package Cirro.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Element;

public class BasePage {
	public WebDriver driver;
	public BasePage( WebDriver driver ) {
		this.driver = driver;
		System.out.println( "Current URL: " + driver.getCurrentUrl() );
	}
	public boolean isPermissionDenied() {
		WebDriverWait wait = new WebDriverWait( driver, 3 );
		WebElement header = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".error-page.centered.text-center > h1")));
		if ( header != null && header.getText().equals("permission denied") ) {
			return true;
		}
		return false;
	}
}