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

public class Mind_valley_login {

	AppiumDriver<MobileElement> driver;
	By email_id = By.name("email");
	By password1 = By.name("password");
	By login_btn = By.className("auth0-lock-submit");
	By forgot_passwd_link = By.className("auth0-lock-alternative-link");
	
	public Mind_valley_login(AppiumDriver<MobileElement> driver) {
		this.driver = driver;	
	}
	
//set email in email text box
	public void set_email_id(String email) {
		driver.findElement(email_id).sendKeys(email);
	}
//clear email field	
	public void clear_email() {
		driver.findElement(email_id).clear();
	}

//wait for email field visibility	
	public void wait_email_visible() {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(email_id)));
	}
//set password in password text box	
	public void set_password(String passwd) {
		driver.findElement(password1).sendKeys(passwd);
	}

//click on login button to navigate to home page
	public void click_login_btn() {
		driver.findElement(login_btn).click();
	}

//click on forgot password link
	public void click_forgot_passwd() {
		driver.findElement(forgot_passwd_link).click();
	}
//This POM method will be exposed in test case to login in the application
	public void login(String strEmail,String strPasswd) {
//Fill in email id			
			this.set_email_id(strEmail);
//Fill in password			
			this.set_password(strPasswd);
//Click login Button			
			this.click_login_btn();
	}
	
}
