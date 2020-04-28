package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class DotcomLoginObjects {

	By userName=By.id("username");
	By password=By.id("password");

	By login=By.name("login");

	WebDriver driver=null;


	public  DotcomLoginObjects (WebDriver driver)
	{
		this.driver=driver;
	}	
	public void inputValues(String text,String text2)
	{
		driver.findElement(userName).sendKeys(text);
		driver.findElement(password).sendKeys(text2);

	}

	public void clickLogin()
	{
		driver.findElement(login).sendKeys(Keys.RETURN);
	}


}
