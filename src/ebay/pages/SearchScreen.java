package ebay.pages;

import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ebay.objects.SearchObjects;
import ebay.utilities.Utility;

public class SearchScreen {
	
	public void login(AndroidDriver<WebElement> driver) throws IOException
	{
		SearchObjects obj=new SearchObjects(driver);
		WebElement searchbox = (new WebDriverWait(driver, 10))
				  .until(ExpectedConditions.elementToBeClickable(obj.searchbox));
		
		searchbox.click();
		obj.search.sendKeys("test item");
		obj.search.sendKeys(Keys.ENTER);
		
		Utility um=new Utility();
		um.scrollscreen(obj.searchbox, driver);

	}
}
