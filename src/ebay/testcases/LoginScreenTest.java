package ebay.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import ebay.pages.LoginScreen;

public class LoginScreenTest extends Base {
	
	
	//public static LoginScreen login;

	@Test
	public void toVerifyLoginScreen() throws IOException {
		System.out.println("test");
		LoginScreen login = new LoginScreen();
		login.login(driver);
		
		//driver.findElement(By.id("com.vector.guru99:id/action_quiz")).click();
	}

}
