package Test_Scripts;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Config.PropertiesFile;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
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


	@BeforeTest
	public static void SetUp() {
		//start reporters
		htmlReporter = new ExtentHtmlReporter(ProjectPath+"//Reports//report.html");

		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		// creates a toggle for the given test, adds all log events under it    
		setup = extent.createTest("SetUp");

		//Calling getproperties method in Properties file
		PropertiesFile.GetProperties();

		//setting drivers
		if (BrowserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
			driver = new ChromeDriver();
		} else if (BrowserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
			driver = new FirefoxDriver();
		}else if (BrowserName.equalsIgnoreCase("edge")) {
			WebDriverManager.getInstance(DriverManagerType.EDGE).setup();
			driver = new EdgeDriver();
		}
		setup.info("Browser Opened");

		//Opening the page
		driver.get(Url);
		driver.manage().window().maximize();
		setup.info("Website Opened");
	}

	@Test(priority=1)
	public static void Set_Excel() throws IOException {
		//Go To  Excel file
		FileInputStream Rfile = new FileInputStream(ProjectPath+"//Excel_File//TestData.xlsx");
		//Get xlsx Excel File (Workbook)
		WBfile = new XSSFWorkbook(Rfile);
	}

	@Test(priority=2)
	public static void Login() throws InterruptedException, IOException {
		//Get Sheet
		Sfile = WBfile.getSheetAt(0);
		setup.info("Excel file found");
		setup.info("Login Data Found");
		Login_Test_Script.SignIn(driver, Sfile, cell, setup, FilePath, WBfile);
	}
	
	@Test(priority=3)
	public static void AddEmploye() throws InterruptedException, IOException {
		//Get Sheet
		Sfile = WBfile.getSheetAt(1);
		setup.info("Admin Data Found");
		Add_Employe.AddEmploye(driver, Sfile, cell, setup, FilePath, WBfile);
	}

	@AfterTest
	public static void TearDown() {
		driver.close();
		setup.info("Browser Closed");

		// calling flush writes everything to the log file
		extent.flush();
	}
}
