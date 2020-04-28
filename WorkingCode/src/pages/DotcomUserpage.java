package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DotcomUserpage {

	private static WebElement element=null;
	private WebDriver driver;

	public static WebElement useridTextboxSearch(WebDriver driver)
	{

		element=driver.findElement(By.id("username"));
		return element;

	}

	public static WebElement userPasswdTextboxSearch(WebDriver driver)
	{

		element=driver.findElement(By.id("password"));
		return element;

	}

	public static WebElement loginButton(WebDriver driver)
	{

		element=driver.findElement(By.name("login"));
		return element;
	}

	public static WebElement Checkbox(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//*[@class='slick-cell l0 r0 slick-cell-checkboxsel']//*[@type='checkbox']"));
		return element;
	}
	
	public static WebElement getReportNumbers(WebDriver driver)
	{

		element=driver.findElement(By.name("login"));
		return element;
	}
	
	
}
