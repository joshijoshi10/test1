package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class HomePageObjects extends base{

	public WebDriver driver;
	
	By title = By.xpath("//b[contains(text(),'Dashboard')]");
	By navBar = By.xpath("//div[@class='menu']//b");
	
	public HomePageObjects(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement getTitle() {
		return driver.findElement(title);
	}
	public WebElement getNavBar() {
		return driver.findElement(navBar);
	}

}
