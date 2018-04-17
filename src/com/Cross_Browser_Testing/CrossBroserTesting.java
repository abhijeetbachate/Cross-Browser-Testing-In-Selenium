package com.Cross_Browser_Testing;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBroserTesting {

	WebDriver driver;
	@Test
	@Parameters("browser")
	public void verifythetitle(String browserName) throws Throwable
	{
		if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.firefox.marionette", "geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		String s = new Exception().getStackTrace()[0].getMethodName();
		//System.out.println(s);
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("src\\com\\Cross_Browser_Testing\\"+s+".PNG"));
		//FileUtils.copyFile(src,new File( "src\\com\\Cross_Browser_Testing\\"+s+".PNG"),True);
		System.out.println("The title is: "+driver.getTitle());
		driver.quit();
	}
	
	
}
