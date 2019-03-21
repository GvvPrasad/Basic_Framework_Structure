package Test_Scripts;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Config.PropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class Main_Test_Script {

	//Global Variables
	WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	public static String BrowserName;
	public static String Url;
	String ProjectPath = System.getProperty("user.dir");

	@BeforeTest
	public void SetUp() {
		//start reporters
		htmlReporter = new ExtentHtmlReporter(ProjectPath+"//Reports//report.html");

		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		// creates a toggle for the given test, adds all log events under it    
		ExtentTest setup = extent.createTest("SetUp");

		//Calling getproperties method in Properties file
		PropertiesFile.GetProperties();

		//setting drivers
		if (BrowserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (BrowserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		setup.info("Browser Opened");
		
		//Opening the page
		driver.get(Url);
		driver.manage().window().maximize();
		setup.info("Website Opened");
	}

	@Test
	public void Login() {
		
	}


	@AfterTest
	public void TearDown() {
		driver.close();

		// calling flush writes everything to the log file
		extent.flush();
	}

}
