package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Mind_valley_home_page {

	AppiumDriver<MobileElement> driver;
	By open_menu_link = By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div[4]/ul/li/i");
	By menu_item_logout = By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div[4]/ul[2]/li[11]/a");
	By page_name_opened_after_login = By.tagName("h3");
			//By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div/div[1]/div/h3");
	
	
	public Mind_valley_home_page(AppiumDriver<MobileElement> driver) {
		this.driver = driver;	
	}
	
//Click menu link to see list of menu items
	public void list_of_menu_items() {
		driver.findElement(open_menu_link).click();
	}
	
//View the menu item name - Logout
	public String menu_item_name() {
		return driver.findElement(menu_item_logout).getText();
	}
//View the page name opened after login	
	public String display_page_name_after_login() {
		return driver.findElement(page_name_opened_after_login).getText();
	}
	
//Click logout menu item to get logged out from homepage	
	public void click_logout() {
		System.out.println(" Logging out..");
		WebElement el1 = driver.findElement(menu_item_logout);
		Actions action = new Actions(driver);
		action.moveToElement(el1).click().perform();
	}

	

	
}
