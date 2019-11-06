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
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class Test_Suit {

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
	public static void SetUp() throws IOException {

		// create ExtentReports and attach reporter(s)
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		extent = new ExtentReports();

		//Report file
		htmlReporter = new ExtentHtmlReporter(ProjectPath+"//Reports//report"+timeStamp+".html");
		extent.attachReporter(htmlReporter);

		// creates a toggle for the given test, adds all log events under it    
		setup = extent.createTest("SetUp");

		//Setting Multi Screenshot
		multiScreens = new MultiScreenShot(ProjectPath+"//Screenshots", timeStamp);

		//Setting Excel
		FileInputStream Rfile = new FileInputStream(FilePath);
		//Get xlsx Excel File (Workbook)
		WBfile = new XSSFWorkbook(Rfile);
		setup.info("Excel File Found");

		//Calling getproperties method in Properties file
		PropertiesFile.GetProperties();
		if (BrowserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
			driver = new ChromeDriver();
		} else if (BrowserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
			driver = new FirefoxDriver();
		}
		setup.pass("Browser Opened");

		driver.get(Url);
		driver.manage().window().maximize();
	}



	//Login 
	@Test(priority=1)
	public static void Login() throws InterruptedException, IOException {
		//Get Sheet
		Sfile = WBfile.getSheetAt(0);
		setup.info("Login Data Sheet Found");
		//Login  
		Login.SignIn(driver, Sfile, cell, setup, FilePath, WBfile, multiScreens);
	}


	//Adding Job 
	@Test(priority=2)
	public static void AddingJob() throws InterruptedException, IOException {
		//Get Sheet
		Sfile = WBfile.getSheetAt(1);
		setup.info("Job Data Sheet Found");
		//Add Job
		Add_Job.AddJob(driver, Sfile, cell, setup, FilePath, WBfile, multiScreens);
	}


	//Salary Comp
	@Test(priority = 3)
	public static void SalaryComponents() throws IOException, InterruptedException{
		//Get Sheet
		Sfile = WBfile.getSheetAt(2);
		setup.info("Salary Data Sheet Found");
		//Add Salary Comp
		Salary_Comp.SalaryComp(driver, Sfile, setup, multiScreens, cell, WBfile, FilePath);	
	}


	@AfterTest
	public static void TearDown() {
		driver.close();
		setup.info("Browser Closed");
		// calling flush writes everything to the log file
		extent.flush();
	}
}
