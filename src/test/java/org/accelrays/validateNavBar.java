package org.accelrays;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePageObjects;
import pageObjects.LandingPage;
import resources.base;

public class validateNavBar extends base{

	private static Logger log = LogManager.getLogger(validateNavBar.class.getName());

	@BeforeTest
	public void initilizer() throws IOException {
		driver = initializeDriver();
		log.info("driver is initialized");

	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
		driver=null;
	}

	@Test
	public void basePageNavigation() throws IOException, InterruptedException {
		driver.get(prop.getProperty("url"));
		LandingPage lp = new LandingPage(driver);
		lp.getUsername().sendKeys("admin");
		lp.getPassword().sendKeys("admin123");
		lp.btnLogin().click();
		Thread.sleep(2000);
		log.info("navigated to home page");
		HomePageObjects hpo = new HomePageObjects(driver);
		Assert.assertTrue(hpo.getNavBar().isDisplayed());
		Assert.assertTrue(hpo.getNavBar().isEnabled());
		log.info("navigation bar displayed and enabled");
}
}