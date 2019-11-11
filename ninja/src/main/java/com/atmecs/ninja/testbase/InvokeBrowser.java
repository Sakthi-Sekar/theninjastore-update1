package com.atmecs.ninja.testbase;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.atmecs.ninja.constants.ConstantPaths;
import com.atmecs.ninja.helpers.ReadPropertiesFile;
import com.atmecs.ninja.helpers.ValidateTestResult;
import com.atmecs.ninja.reports.LogReports;


public class InvokeBrowser {

	public static WebDriver driver;
	Properties config = new Properties();
	protected ReadPropertiesFile read = new ReadPropertiesFile();
	public static LogReports log=new LogReports();
	public static ValidateTestResult validate=new ValidateTestResult();
	

//Invoke IE browser
	@Test(priority = 1)
	public void setup() throws IOException {
		System.setProperty("webdriver.chrome.driver", ConstantPaths.CHROME_FILE);
		//driver = new InternetExplorerDriver();
		driver = new ChromeDriver();
		driver.get(read.readPropertiesFile("url", ConstantPaths.CONFIG_FILE));
		driver.manage().window().maximize();
		log.info("Browser opened");
		
	}
}