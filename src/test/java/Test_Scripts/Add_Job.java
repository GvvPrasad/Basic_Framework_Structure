package Test_Scripts;

import java.io.IOException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import Locators.Add_Job_Locators;
import multiScreenShot.MultiScreenShot;

public class Add_Job {

	public static void AddJob(WebDriver driver, XSSFSheet Sfile, XSSFCell cell, ExtentTest setup, String FilePath, XSSFWorkbook WBfile, MultiScreenShot multiScreens) throws InterruptedException, IOException {
		
		
		//Select admin Tab
		Add_Job_Locators.AdminTab(driver).click();
		setup.info("Admin Tab Selected");
		
		//Select Job Tab
		Add_Job_Locators.Job(driver).click();
		setup.info("Job Tab Selected");
		
		//Select Title Tab
		Add_Job_Locators.JobTitle(driver).click();
		setup.info("Job Title Tab Selected");
		
		Main_Test_Script.Wait();
		
		//Looping in the excel for data 
		for (int i=0; i<=Sfile.getLastRowNum(); i++) {
			
			try {
				//Get addjob web locators from locators file
				Add_Job_Locators.AddJob(driver).click();
			} catch (Exception e) {
				//If an error occur take screenshot 
				multiScreens.multiScreenShot(driver);
			}
			
			setup.info("Add Job clicked");
			Main_Test_Script.Wait();
						
			//Import data for job title from excel
			cell = Sfile.getRow(i).getCell(0);
			cell.setCellType(CellType.STRING);
			
			//Send data from Excel for job title
			Add_Job_Locators.EnterJobTitle(driver).sendKeys(cell.getStringCellValue());
			setup.info("Entered Job Title");

			//Import data for job description from excel
			cell = Sfile.getRow(i).getCell(1);
			cell.setCellType(CellType.STRING);
			
			//Send data from Excel for job description
			Add_Job_Locators.EnterJobDescription(driver).sendKeys(cell.getStringCellValue());
			setup.info("Entered Job Description");
			
			//Submit job
			Add_Job_Locators.SaveJob(driver).click();
			
			
			//Verifying add job is success or not
			
		}	
	}
}
