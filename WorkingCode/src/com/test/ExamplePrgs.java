package com.test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pages.DotcomUserpage;
public class ExamplePrgs {

	static int num=0;
	static WebDriver driver;
	static String url;
	static String Uname;
	static String password;

	static String projectLocation=System.getProperty("user.dir");
	public static void main(String[] args) throws InterruptedException
	{
		// TODO Auto-generated method stub		
		System.out.println("start");
		setBrowserConfig();
		loginTest();
		navigateToViewReportstatus();
		deleteReports();
	}

	/**
	 * this functions sets browser configuration to firefox as default
	 */
	public static void setBrowserConfig()
	{
		System.setProperty("webdriver.gecko.driver",projectLocation+"\\GekoDriver\\geckodriver.exe");
		driver= new FirefoxDriver();
	}
	public static void loginTest()
	{
		url="https://www.fedex.com/ibi_apps";
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(url);
		DotcomUserpage.useridTextboxSearch(driver).clear();
		DotcomUserpage.useridTextboxSearch(driver).sendKeys("LPGTMFCRUSER2");
		DotcomUserpage.userPasswdTextboxSearch(driver).clear();
		DotcomUserpage.userPasswdTextboxSearch(driver).sendKeys("Test12345");
		DotcomUserpage.loginButton(driver).click();
	}

	public static void navigateToViewReportstatus() throws InterruptedException
	{
		driver.navigate().to("https://www.fedex.com/ibi_apps/WFServlet.ibfs?IBFS1_action=RUNFEX&IBFS_path=/WFC/Repository/FCR/User_Interface/view-report-status/view-report-status.htm");
		Thread.sleep(10000);
		driver.findElement(By.id("refreshIcon")).click();
		System.out.println("clicked refresh:");


		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		System.out.println("scrolled down:"); 

	}

	public static void deleteReports() throws InterruptedException 
	{
		String num1=driver.findElement(By.xpath("/html/body/div[6]/div/div[2]/div[2]/label/span")).getText();
		//DotcomUserpage.getReportNumbers(driver).getText();
		int number = Integer.parseInt(num1);
		System.out.println("num of reports"+number);
		for(int j=0;j<number;j++)
		{
			driver.findElement(By.xpath("//*[@class='slick-cell l0 r0 slick-cell-checkboxsel']//*[@type='checkbox']")).click();
			//DotcomUserpage.Checkbox(driver).click();
		}
		//Thread.sleep(10000);

		driver.findElement(By.cssSelector("#deleteButton")).click();

		//	Thread.sleep(10000);

		//	driver.findElement(By.cssSelector("#yes-btn")).click();
		System.out.println("Deleting reports");
		driver.findElement(By.id("refreshIcon")).click();
		System.out.println("refreshing view report status grid");
		driver.close();
		System.out.println("please recheck the after 5-10 minutes for results sometimes");
	}	

}