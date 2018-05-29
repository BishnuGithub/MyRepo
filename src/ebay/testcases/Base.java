package ebay.testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import ebay.utilities.Utility;

public class Base {

	WebDriver driver;
	Utility appiumserver = new Utility();
	
	Properties prop;
	InputStream input = null;
	

	@BeforeSuite
	public void setup() throws InterruptedException, IOException {

		prop = new Properties();
		input = new FileInputStream("file.properties");
		prop.load(input);

		// Starts appium server
		//appiumserver.startServer();
		/*AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
		service.start();*/
		
		//Thread.sleep(10000L);

		System.out.println("Appium server started...");

		/*
		Utility.launchEmulator("Nexus"); Thread.sleep(40000L);
		 System.out.println("Emulator opening..");*/
		 

		DesiredCapabilities capabilities = new DesiredCapabilities();

		// -------already installed app ------------
		// ---- For Real Device
		capabilities.setCapability("deviceName", prop.getProperty("deviceName"));
		// ----For Emulator
		// capabilities.setCapability("deviceName", "Android Emulator");

		capabilities.setCapability("browserName", "Android");

		// capabilities.setCapability("platformVersion", "5.1.1");
		//capabilities.setCapability("platformVersion", "5.0.2");
		// capabilities.setCapability("platformVersion", "4.4.2");
		 capabilities.setCapability("platformVersion", prop.getProperty("platformVersion"));

		capabilities.setCapability("platformName", prop.getProperty("platformName"));
		//capabilities.setCapability("autoAcceptAlerts", true);

		// capabilities.setCapability("autoDismissAlerts", true);
		//Thread.sleep(10000L);
		/*
		 * capabilities.setCapability("appPackage", "com.mindtree.approvals");
		 * capabilities.setCapability("appActivity",
		 * "com.mindtree.approvals.MainActivity");
		 */
		
		
		capabilities.setCapability("appPackage", prop.getProperty("appPackage"));
		capabilities.setCapability("appActivity", prop.getProperty("appActivity"));

		
		// ------- to install app ---------
		
		 /* File appDir = new
		  File("D:\\MobileAppsAutomation\\Ebay"); 
		  File app = new File(appDir, "Guru99.apk");
		 
		 capabilities.setCapability("app", app.getAbsolutePath());*/
		 

		Thread.sleep(20000L);

		driver = new RemoteWebDriver(new URL(prop.getProperty("url")),
				capabilities);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		//Thread.sleep(30000L);
		

	}
	
	
	@BeforeTest
	public void at()
	{
		System.out.println("before test");
		/*
		//To get the current screen orientation value by this code
		ScreenOrientation orientation= driver.getOrientation();
		System.out.println(orientation.value());
		//To rotate the screen to Portrait and Landscape by the following code
		driver.rotate(ScreenOrientation.PORTRAIT);
		//driver.rotate(ScreenOrientation.LANDSCAPE);
*/		
		//To get screen dimention		
		Dimension dimensions = driver.manage().window().getSize();
		  int screenWidth = dimensions.getWidth();
		  int screenHeight = dimensions.getHeight();
		  System.out.println("Screen height: "+screenHeight);
		  System.out.println("Screen width: "+screenWidth);
		  
		
	}
	@AfterTest
	public void bt()
	{
		
	}
	
	@AfterSuite
	public void atlast()
	{
		//Stop server
	}

}
