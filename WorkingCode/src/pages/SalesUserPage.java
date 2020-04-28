package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SalesUserPage {

	private static WebElement element=null;
	
	public static WebElement useridTextboxSearch(WebDriver driver)
	{
			
	 element=driver.findElement(By.id("username"));
 		return element;
		
	}

	public static WebElement userPsswdTextboxSearch(WebDriver driver)
	{
			
	 element=driver.findElement(By.id("username"));
 		return element;
		
	}
	
}
