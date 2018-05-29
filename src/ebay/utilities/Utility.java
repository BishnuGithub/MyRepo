package ebay.utilities;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;

public class Utility {
	
	public void getlogfile( WebDriver driver)
	{
	
	LogEntries logEntries = driver.manage().logs().get("driver");

	}
	
	public void scrollscreen(WebElement element , WebDriver driver)
	{
		
		int x = element.getLocation().getX();
		int y = element.getLocation().getY();

		TouchAction action = new TouchAction((PerformsTouchActions) driver);
		action.press(x,y).moveTo(x+90,y).release().perform();
	}
	
	String appiumInstallationDir ="C:/Program Files (x86)";//"D:/"; //"C:/Program Files (x86)";
	String appiumNode = appiumInstallationDir + File.separator + "Appium" + File.separator + "node.exe";
	String appiumNodeModule = appiumInstallationDir + File.separator + "Appium" + File.separator + "node_modules"
	  + File.separator + "appium" + File.separator + "bin" + File.separator + "Appium.js";
	String appiumServicePort = "4723";
	
	
	private static String sdkPath = "D:/Androidsdk/adt-bundle-windows/adt-bundle-windows-x86_64-20140321/adt-bundle-windows-x86_64-20140321/sdk";
			//"D:/AndroidStudio/sdk/";
	private static String adbPath = sdkPath + "platform-tools" + File.separator + "adb";
	private static String emulatorPath = sdkPath + "tools" + File.separator + "emulator";
	
	public void startServer1() {
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4723 --session-override -dc \"{\"\"noReset\"\": \"\"false\"\"}\"\"");
			Thread.sleep(10000);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void stopServer1() {
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("taskkill /F /IM node.exe");
			runtime.exec("taskkill /F /IM cmd.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// To stsrt appium server
	public void startServer(){
		
		/*CommandLine command = new CommandLine("cmd");
		command.addArgument("/c");
		command.addArgument("C:/Program Files (x86)/Appium/node.exe");
		command.addArgument("C:/Program Files (x86)/Appium/node_modules/appium/bin/appium.js");*/
		CommandLine command = new CommandLine("C:\\Program Files (x86)\\Appium\\node.exe");
		command.addArgument("C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\Appium.js");
		command.addArgument("--address");
		command.addArgument("127.0.0.1");
		command.addArgument("--port");
		command.addArgument("4723");
		command.addArgument("--no-reset");
		command.addArgument("--log");
		command.addArgument("D:/appiumLogs.txt");
		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);


		try {
		executor.execute(command, resultHandler);
		} catch (IOException e) {
		e.printStackTrace();
		}
		}

	//To stop appium server	
	public void stopServer(){

		CommandLine command = new CommandLine("cmd");
		command.addArgument("/c");
		command.addArgument("taskkill");
		command.addArgument("/F");
		command.addArgument("/IM");
		command.addArgument("node.exe");

		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);

		try {
		executor.execute(command, resultHandler);
		} catch (IOException e) {
		e.printStackTrace();
		}
		}

	
	 /**
	  * Executes any command for Windows using ProcessBuilder of Java You can
	  * change the first input parameter of ProcessBuilder constructor if your OS
	  * is not windows operating system
	  * 
	  * @param aCommand
	  */
	 public void executeCommand(String aCommand) {
	  File currDir = new File(System.getProperty("user.dir"));
	  String line;
	  try {
	   ProcessBuilder probuilder = new ProcessBuilder("CMD", "/C", aCommand);
	   probuilder.directory(currDir);
	   Process process = probuilder.start();
	  
	   BufferedReader inputStream 
	        = new BufferedReader(new InputStreamReader(process.getInputStream()));
	   BufferedReader errorStream 
	        = new BufferedReader(new InputStreamReader(process.getErrorStream()));
	  
	   // reading output of the command
	   int inputLine = 0;
	   while ((line = inputStream.readLine()) != null) {
	    if (inputLine == 0) {
	     System.out.printf("Output of the running command is: \n");
	    }
	    System.out.println(line);
	    inputLine++;
	   }
	  
	   // reading errors from the command
	   int errLine = 0;
	   while ((line = errorStream.readLine()) != null) {
	    if (errLine == 0) {
	     System.out.println("Error of the command is: \n");
	    }
	    System.out.println(line);
	    errLine++;
	   }
	  
	  } catch (IOException e) {
	   System.err.println("Exception occured: \n");
	   System.err.println(e.getMessage());
	  }
	 }
	
	//Launching emulator programmatically - emulator -avd <avd_name>
	/**
	 * Starts an emulator for the provided AVD name
	 * 
	 * @param nameOfAVD
	 */
	public static void launchEmulator(String nameOfAVD) {
	 System.out.println("Starting emulator for '" + nameOfAVD + "' ...");
	 String[] aCommand = new String[] { emulatorPath, "-avd", nameOfAVD };
	 try {
	  Process process = new ProcessBuilder(aCommand).start();
	  process.waitFor(180, TimeUnit.SECONDS);
	  System.out.println("Emulator launched successfully!");
	 } catch (Exception e) {
	  e.printStackTrace();
	 }
	}
	
	//Stop emulator programmatically - adb emu kill
	/**
	 * Kills all running emulators
	 */
	/*public static void closeEmulator() {
	 System.out.println("Killing emulator...");
	 String[] aCommand = new String[] { adbPath, "emu", "kill" };
	 try {
	  Process process = new ProcessBuilder(aCommand).start();
	  process.waitFor(10, TimeUnit.SECONDS);
	  System.out.println("Emulator closed successfully!");
	 } catch (Exception e) {
	  e.printStackTrace();
	 }
	}*/

	
	public static void closeEmulator(){

		CommandLine command = new CommandLine("cmd");
		command.addArgument("/c");
		command.addArgument("taskkill");
		command.addArgument("/F");
		command.addArgument("/IM");
		command.addArgument("emulator-arm.exe");

		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);

		try {
		executor.execute(command, resultHandler);
		} catch (IOException e) {
		e.printStackTrace();
		}
		}

}
