package ebay.objects;

import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginObjects {
	public WebDriver driver;
	
	public LoginObjects(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(id="com.ebay.mobile:id/button_sign_in")
	public WebElement signinButton;
	
	@FindBy(id="com.ebay.mobile:id/edit_text_username")
	public WebElement username;
	
	@FindBy(id="com.ebay.mobile:id/edit_text_password")
	public WebElement password;
	
	@FindBy(id="com.ebay.mobile:id/button_google_deny")
	public WebElement nothanks;
	
	@FindBy(id="com.ebay.mobile:id/home")
	public WebElement home;
	
	
}
