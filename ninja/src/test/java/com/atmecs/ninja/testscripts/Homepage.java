package com.atmecs.ninja.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.atmecs.ninja.constants.ConstantPaths;
import com.atmecs.ninja.helpers.PageActions;
import com.atmecs.ninja.helpers.ValidateTestResult;
import com.atmecs.ninja.testbase.InvokeBrowser;

public class Homepage extends InvokeBrowser {
	String Xpath, exptd;

	WebElement Css, inputElement;

	@Test(priority = 2)
	public void clickSearchButton() {
		// Url validation
		Xpath = read.readPropertiesFile("loc.validate.title.xpath", ConstantPaths.LOCATORS_FILE);
		String actualtext = driver.findElement(By.xpath(Xpath)).getText();
		String exptext = read.readPropertiesFile("exptext", ConstantPaths.LOCATORS_FILE);
		ValidateTestResult.validateData(actualtext, exptext, "No match");
		log.info("Match found");

		// click on search button
		Xpath = read.readPropertiesFile("loc.search.xpath", ConstantPaths.LOCATORS_FILE);
		PageActions.clickOnElement(driver, Xpath);
		log.info("Clicked on the serach");
	}
}
