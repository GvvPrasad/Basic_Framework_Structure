package Test_Scripts;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Config.PropertiesFile;
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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class Main_Test_Script {

	//Global Variables
	WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest setup;
	public static String BrowserName;
	public static String Url;
	String ProjectPath = System.getProperty("user.dir");
	String FilePath = ProjectPath+"//Excel_File//TestData.xlsx";
	XSSFWorkbook WBfile;
	XSSFSheet Sfile;
	XSSFCell cell;


	@BeforeTest
	public void SetUp() {
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

	@Test(priority=1)
	public void Set_Excel() throws IOException {
		//Go To  Excel file
		FileInputStream Rfile = new FileInputStream(ProjectPath+"//Excel_File//TestData.xlsx");
		//Get xlsx Excel File (Workbook)
		WBfile = new XSSFWorkbook(Rfile);
		//Get Sheet
		Sfile = WBfile.getSheetAt(0);
		setup.info("Excel file found");
	}

	@Test(priority=2)
	public void Login() throws InterruptedException, IOException {
		for(int i=0; i<= Sfile.getLastRowNum(); i++)
		{
			// Import data for Email.
			cell = Sfile.getRow(i).getCell(0);
			cell.setCellType(CellType.STRING);
			WebElement email = driver.findElement(By.id("txtUsername"));
			email.clear();
			email.sendKeys(cell.getStringCellValue());
			setup.info("Imported User Name");

			// Import data for password.
			cell = Sfile.getRow(i).getCell(1);
			cell.setCellType(CellType.STRING);
			WebElement password = driver.findElement(By.id("txtPassword"));
			password.clear();
			password.sendKeys(cell.getStringCellValue());
			setup.info("Imported Password");

			Thread.sleep(3000);
			//clear data
			email.clear();
			password.clear();

			// Specify the message needs to be written.
			String message = "Pass";
			// Specify the file in which data needs to be written.
			FileOutputStream fileOutput = new FileOutputStream(FilePath);
			// Create cell where data needs to be written.
			Sfile.getRow(i).createCell(2).setCellValue(message);
			setup.info("Result wrote into Excel Sheet");
			// finally write content
			WBfile.write(fileOutput);
			// close the file
			fileOutput.close();
		}
	}


	@AfterTest
	public void TearDown() {
		driver.close();
		setup.info("Browser Closed");

		// calling flush writes everything to the log file
		extent.flush();
	}
}
