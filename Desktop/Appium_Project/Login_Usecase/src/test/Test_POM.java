package test;

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
import pages.Forgot_password_page;
import pages.Mind_valley_home_page;
import pages.Mind_valley_login;


public class Test_POM  {
	 private static AppiumDriver<MobileElement> driver = null;
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		cap.setCapability("deviceName","Samsung GT-I8262");
		cap.setCapability("platformVersion", "4.1.2");
		cap.setCapability("platformName","Android");
		
		driver =  new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap); 
		driver.get("https://mindvalley.auth0.com/login?state=-3CKUR1h7oFDXX6SzI4dJyHEK48Lv6-g&client=KRaFmCektAtXR6sd2gumWVFQa6AnXnwF&protocol=oauth2&auth0Client=eyJuYW1lIjoib21uaWF1dGgtYXV0aDAiLCJ2ZXJzaW9uIjoiMS40LjEifQ%3D%3D&redirect_uri=https%3A%2F%2Fhome.mindvalley.com%2Fauth%2Fmindvalley%2Fcallback%3Forigin%3Dhttps%253A%252F%252Fhome.mindvalley.com%252F&response_type=code&scope=openid%20email");
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		
//Use of POM	
		Mind_valley_login objMind_valley_login = new Mind_valley_login(driver);
		Mind_valley_home_page objMind_valley_home_page = new Mind_valley_home_page(driver);
		Forgot_password_page objForgot_password_page = new Forgot_password_page(driver);
/*Test Case -1
 To check if no values are provided in text box - Email & Password
but submit button was clicked, then the two text box should be highlighted in red
 */

		String Email_Expected_border_color_red_hex = "#ff0000";
		String Password_Expected_border_color_red_hex = "#ff0000";
		objMind_valley_login.click_login_btn();
		
		WebElement email_color = driver.findElement(By.xpath("//*[@id=\"widget-container\"]/div/div/form/div/div/div[3]/span/div/div/div/div/div/div/div/div/div[3]/div[1]/div[1]"));
		WebElement pwd_color =  driver.findElement(By.xpath("//*[@id=\"widget-container\"]/div/div/form/div/div/div[3]/span/div/div/div/div/div/div/div/div/div[3]/div[2]/div/div[1]"));

		System.out.println("Border Color displayed for Email :"+ email_color.getCssValue("border-color"));
		System.out.println("Border Color displayed for Password :"+ pwd_color.getCssValue("border-color"));

		String Email_Actual_border_color_hex = Color.fromString(email_color.getCssValue("border-color")).asHex();
		String Password_Actual_border_color_hex = Color.fromString(pwd_color.getCssValue("border-color")).asHex();
		
		if(Email_Expected_border_color_red_hex.equals(Email_Actual_border_color_hex) && Password_Expected_border_color_red_hex.equals(Password_Actual_border_color_hex)) {
			System.out.println("Border Color displayed for Email & Password is red as expected- Test Case-1 Passed");
		}else {
			System.out.println("Border Color displayed for Email/Password is not red - Test Case -1 failed");
		}
		
		
/*Test Case -2
 *  To check if wrong values are provided in text box - Email & Password
and submit button was clicked, then the message- "Wrong email or password." should be displayed
*/		
		String Expected_error_msg = "Wrong email or password.";
		
		objMind_valley_login.login("satyabrataster@gmail.com", "123456");
		
//Capturing the message displayed by system after login attempt was made with wrong details		
				WebElement msg = driver.findElement(By.xpath("//span[@class='animated fadeInUp']//span"));
				String Actual_msg = msg.getText();
				
				if(Expected_error_msg.equals(Actual_msg)) {
				System.out.println("Test case -2 passed with Proper message displaying -Wrong email or password. ");

				}
				else {
					System.out.println("Test case -2 failed");		
				}
/*Test Case -3
 To check if forgot password link is clicked then 
Forgot password page with Email and Submit button should be displayed
*/

				String Expected_label_forgot_password_page = "Forgot Password";
				String Expected_field_name_forgot_password_page = "Email";
				String Expected_button_label_forgot_password_page = "Send email";
				objMind_valley_login.click_forgot_passwd();
				driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		
		System.out.println("Forgot password page contains label :"+objForgot_password_page.display_forgot_password_label());
		System.out.println("Placeholder present in Field :"+objForgot_password_page.display_email_placeholder());
		System.out.println("Label on Button :"+objForgot_password_page.display_label_name_on_button());
		if(Expected_label_forgot_password_page.equals(objForgot_password_page.display_forgot_password_label()) 
				&& Expected_field_name_forgot_password_page.equals(objForgot_password_page.display_email_placeholder())
				&& Expected_button_label_forgot_password_page.equals(objForgot_password_page.display_label_name_on_button()) ) {
			System.out.println("Test Case -3 - Passed");	
		}else {
			System.out.println("Test Case -3 - Failed");
		}
		
/*Test Case -4
To check if Correct email & password link is provided and Login button was clicked 
then page with Library page with Main Menu  should be displayed	
*/		
//Navigate to login screen from forgot password page
		objForgot_password_page.goback_login_screen();
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

//Wait for email id field to be visible		
		objMind_valley_login.wait_email_visible();
		objMind_valley_login.clear_email();
		objMind_valley_login.login("satya_p232@yahoo.com", "satya_1234");	
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
//To verify the Library page and Main menu is displayed after successful log in
				String Expected_Page_Name = "Welcome to Your Mindvalley Library";
				String Expected_Menu_Item = "Logout";
				
//To check that My Library page appears after successful login				
				String Actual_Page_Name = objMind_valley_home_page.display_page_name_after_login();
				
//Click the top right corner symbol with horizontal lines to display list of menu Item			
				objMind_valley_home_page.list_of_menu_items();
//To check the Main Menu is displayed  				
				String Actual_Menu_Item = objMind_valley_home_page.menu_item_name();
				
				if((Expected_Page_Name.equals(Actual_Page_Name) || "My Courses".equals(Actual_Page_Name)) &&  Expected_Menu_Item.equals(Actual_Menu_Item)) {
					System.out.println(" Test Case-4 is passed");
				}
				else {
					System.out.println(" Test Case-4 is failed");
				}
				
//Logout from Home page
				objMind_valley_home_page.click_logout();
				
				Thread.sleep(10000);
				driver.quit();
				
	}

}
