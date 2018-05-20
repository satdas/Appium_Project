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


public class Forgot_password_page {
	
	AppiumDriver<MobileElement> driver;
	By forgot_password_label = By.xpath("/html/body/div/div/div/div/div/div/div/form/div/div/div[1]/div[2]/div");
	By email_field = By.name("email");
	By send_email_btn = By.className("auth0-lock-submit");
	By back_to_loginscreen_btn = By.className("auth0-lock-back-button");
	
	public Forgot_password_page(AppiumDriver<MobileElement> driver) {
		this.driver = driver;	
	}
	
	public String display_forgot_password_label() {
		return driver.findElement(forgot_password_label).getText();
	}
	
	public String display_email_placeholder() {
		return driver.findElement(email_field).getAttribute("placeholder");
	}
	public String display_label_name_on_button() {
		WebElement btn_lbl = driver.findElement(send_email_btn); 
		return btn_lbl.getText();
	}
//Click back button to go back to login screen	
	public void goback_login_screen() {
		driver.findElement(back_to_loginscreen_btn).click();
	}

}
