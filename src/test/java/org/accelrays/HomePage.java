package org.accelrays;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class HomePage extends base {

	private static Logger log = LogManager.getLogger(HomePage.class.getName());

	@BeforeTest
	public void initilizer() throws IOException {
		driver = initializeDriver();
		log.info("driver initiated");
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
		driver=null;
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String un, String pwd, String text) throws IOException {
		driver.get(prop.getProperty("url"));
		LandingPage l = new LandingPage(driver);
		l.getUsername().sendKeys(un);
		l.getPassword().sendKeys(pwd);
		System.out.println(text);
		l.btnLogin().click();
		log.info("navigated to home page");
		//Assert.assertFalse(true);
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][3];
		data[0][0]="admin";
		data[0][1]="admin123";
		data[0][2]="valid user";
		
		data[1][0]="ad";
		data[1][1]="a123";
		data[1][2]="invalid user";

		return data;
	}
}
