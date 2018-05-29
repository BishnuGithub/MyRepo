package ebay.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ebay.objects.LoginObjects;



public class LoginScreen {

	Properties prop;
	InputStream input = null;
	

	
	public void login(WebDriver driver) throws IOException
	{
		try
		{
		//FluentWait wait = new FluentWait(driver).withTimeout(30, TimeUnit.SECONDS) .pollingEvery(5, TimeUnit.SECONDS) .ignoring(NoSuchElementException.class);
		// ((WebElement) wait.until(ExpectedConditions.elementToBeClickable(firstfrnd))).click();
		System.out.println("method");
		prop = new Properties();
		input = new FileInputStream("file.properties");
		prop.load(input);
		
		
		//driver.switchTo().frame("com.ebay.mobile:id/fragment_container");
		LoginObjects obj=new LoginObjects(driver);
		//driver.findElement(By.id("com.ebay.mobile:id/button_sign_in"));
		System.out.println("method2");
		
/*
		WebElement signin = (new WebDriverWait(driver, 10))
				  .until(ExpectedConditions.elementToBeClickable(signinButton));
		System.out.println("method3");
		signinButton.click();
		System.out.println("method4");
		username.sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("password"));
		signinButton.click();
		nothanks.click();*/
		
		
		
		WebElement signin = (new WebDriverWait(driver, 10))
				  .until(ExpectedConditions.elementToBeClickable(obj.signinButton));
		System.out.println("method3");
		obj.signinButton.click();
		System.out.println("method4");
		obj.username.sendKeys(prop.getProperty("username"));
		obj.password.sendKeys(prop.getProperty("password"));
		obj.signinButton.click();
		obj.nothanks.click();
		
		
	}
	
		catch(Exception ex){
			System.err.println("Error Message : " + ex.getMessage());
		}
	}
	
}
