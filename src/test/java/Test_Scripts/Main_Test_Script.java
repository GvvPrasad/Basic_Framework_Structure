package Test_Scripts;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Config.PropertiesFile;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import multiScreenShot.MultiScreenShot;

import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class Main_Test_Script {

	//Global Variables
	static WebDriver driver;
	static ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;
	static ExtentTest setup;
	public static String BrowserName;
	public static String Url;
	static String ProjectPath = System.getProperty("user.dir");
	static String FilePath = ProjectPath+"//Excel_File//TestData.xlsx";
	static XSSFWorkbook WBfile;
	static XSSFSheet Sfile;
	static XSSFCell cell;
	static FileOutputStream fileOutput;
	static MultiScreenShot multiScreens;


	@BeforeTest
	public static void SetUp() {
		//start reporters
		htmlReporter = new ExtentHtmlReporter(ProjectPath+"//Reports//report.html");

		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		// creates a toggle for the given test, adds all log events under it    
		setup = extent.createTest("SetUp");

		//Setting Multi Screenshot
		multiScreens = new MultiScreenShot(ProjectPath+"//", "ScreenShots");

		//Calling getproperties method in Properties file
		PropertiesFile.GetProperties();

		//setting drivers
		if (BrowserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
			driver = new ChromeDriver();
		} else if (BrowserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
			driver = new FirefoxDriver();
		}
		setup.info("Browser Opened");

		//Opening the page
		driver.get(Url);
		driver.manage().window().maximize();
	}

	@Test(priority=0)
	public static void Wait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority=1)
	public static void Set_Excel() throws IOException {
		//Go To  Excel file
		FileInputStream Rfile = new FileInputStream(ProjectPath+"//Excel_File//TestData.xlsx");
		//Get xlsx Excel File (Workbook)
		WBfile = new XSSFWorkbook(Rfile);
		setup.info("Excel File Found");
	}

	@Test(priority=2)
	public static void Login() throws InterruptedException, IOException {
		//Get Sheet
		Sfile = WBfile.getSheetAt(0);		
		setup.info("Login Data Found");
		Login_Test_Script.SignIn(driver, Sfile, cell, setup, FilePath, WBfile, multiScreens);
	}

	@Test(priority=3)
	public static void AddVacency() throws InterruptedException, IOException {
		//Get Sheet
		Sfile = WBfile.getSheetAt(1);
		setup.info("Job Data Found");
		Add_Job.AddJob(driver, Sfile, cell, setup, FilePath, WBfile, multiScreens);
	}

	@AfterTest
	public static void TearDown() {
		driver.close();
		setup.info("Browser Closed");

		// calling flush writes everything to the log file
		extent.flush();
	}
}
