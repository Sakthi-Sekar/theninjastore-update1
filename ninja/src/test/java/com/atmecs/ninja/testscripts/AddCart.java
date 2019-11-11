package com.atmecs.ninja.testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.atmecs.ninja.constants.ConstantPaths;
import com.atmecs.ninja.helpers.PageActions;
import com.atmecs.ninja.helpers.ReadExcelData;
import com.atmecs.ninja.helpers.ValidateTestResult;
import com.atmecs.ninja.testbase.InvokeBrowser;

public class AddCart extends Homepage {
	String Xpath, exptd;
	String Css;
	WebElement inputElement;

	@Test(priority = 3, dataProvider = "data", dataProviderClass = ReadExcelData.class)
	public void enterData(String[] in) {

		// clear the search field
		Css = read.readPropertiesFile("loc.clearsearch.css", ConstantPaths.LOCATORS_FILE);
		inputElement = driver.findElement(By.cssSelector(Css));
		inputElement.clear();

		// pass value through data provider
		Xpath = read.readPropertiesFile("loc.search.xpath", ConstantPaths.DATA_FILE);
		driver.findElement(By.xpath(Xpath)).sendKeys(in[0]);

		// hit search
		Xpath = read.readPropertiesFile("loc.button.search.xpath", ConstantPaths.LOCATORS_FILE);
		PageActions.clickOnElement(driver, Xpath);

		// click on iphone link

		Css = read.readPropertiesFile("loc.clickimg.css", ConstantPaths.LOCATORS_FILE);
		PageActions.clickElement(driver, Css);

		// validate availability

		Css = read.readPropertiesFile("loc.iphone.availability.css", ConstantPaths.LOCATORS_FILE);
		String actavailabilty = driver.findElement(By.cssSelector(Css)).getText();
		validate.validateData(actavailabilty, in[1], "No match");
		log.info("Availability:In stock");

		// validate price
		Css = read.readPropertiesFile("loc.iphone.price.css", ConstantPaths.LOCATORS_FILE);
		String actprice = driver.findElement(By.cssSelector(Css)).getText();
		validate.validateData(actprice, in[2], "No match");
		log.info("Product price");

		// validate Ex.Tax
		Css = read.readPropertiesFile("loc.iphone.extax.css", ConstantPaths.LOCATORS_FILE);
		String acttax = driver.findElement(By.cssSelector(Css)).getText();
		validate.validateData(acttax, in[3], "No match");
		log.info("Ex Tax");

//		// validate description
//		Xpath = read.readPropertiesFile("loc.iphone.intro.xpath", ConstantPaths.LOCATORS_FILE);
//		String actintro = driver.findElement(By.xpath(Xpath)).getText();
//		validate.validateData(actintro, in[4], "No match");
//		log.info("iphone Description");

		// increase QTY
		Xpath = read.readPropertiesFile("loc.click.qty.xpath", ConstantPaths.LOCATORS_FILE);
		PageActions.ClickElement(driver, Xpath);
		driver.findElement(By.xpath(Xpath)).clear();
		driver.findElement(By.xpath(Xpath)).sendKeys(in[5]);
		Xpath = read.readPropertiesFile("loc.button.click.addtocart.xpath", ConstantPaths.LOCATORS_FILE);
		PageActions.clickOnElement(driver, Xpath);

	}

	@Test(priority = 4)
	public void validateCartAfterAdd() {
		// click on cart symbol
		Css = read.readPropertiesFile("loc.validate.clickoncart.afteradd.css", ConstantPaths.LOCATORS_FILE);
		PageActions.clickElement(driver, Css);
		// click view cart
		Css = read.readPropertiesFile("loc.viewcartbtn.click.css", ConstantPaths.LOCATORS_FILE);
		PageActions.clickElement(driver, Css);
		// validate each cart items
	}

	@Test(priority = 5)
	public void validateAfterRemove() {
		Css = read.readPropertiesFile("removebutton", ConstantPaths.LOCATORS_FILE);
		PageActions.clickElement(driver, Css);
	}

}
