package ebay.objects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchObjects {
public AndroidDriver<WebElement> driver;
	
	public SearchObjects(AndroidDriver<WebElement> driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@AndroidFindBy(id="com.ebay.mobile:id/search_box")
	public WebElement searchbox;
	
	@AndroidFindBy(id="com.ebay.mobile:id/search_src_text")
	public WebElement search;
	
	/*
	@FindBy(id="")
	public WebElement ;
	
	@FindBy(id="")
	public WebElement ;
	
	@FindBy(id="")
	public WebElement ;
	
	@FindBy(id="")
	public WebElement ;
	
	@FindBy(id="")
	public WebElement ;
	
	@FindBy(id="")
	public WebElement ;
	
	@FindBy(id="")
	public WebElement ;
	
	@FindBy(id="")
	public WebElement ;
	
	@FindBy(id="")
	public WebElement ;
	
	@FindBy(id="")
	public WebElement ;
	*/
		

}
