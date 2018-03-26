package Cirro.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WalletPage extends BasePage {
	public WalletPage( WebDriver driver ) {
		super(driver);
	}
	public boolean isDigicoinOpened() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement accordionItem = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".accordion-header.active")));
		if ( accordionItem == null ) {
			System.out.println( "No accordion" );
			return false;
		}
		WebElement title = accordionItem.findElement(By.cssSelector(".text-right") );
		if( title != null && title.getText().equalsIgnoreCase( "Digicoin" ) ) {
			return true;
		}
		return false;
	}
	
}
