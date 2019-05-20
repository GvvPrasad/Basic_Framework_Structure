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

		Add_Job_Locators.AdminTab(driver).click();
		setup.info("Admin Tab Selected");

		Add_Job_Locators.Job(driver).click();
		setup.info("Job Tab Selected");

		Add_Job_Locators.JobTitle(driver).click();
		setup.info("Job Title Tab Selected");

		for (int i=0; i<=Sfile.getLastRowNum(); i++) {

			Main_Test_Script.Wait();
			try {
				Add_Job_Locators.AddJob(driver).click();
			} catch (Exception e) {
				multiScreens.multiScreenShot(driver);
			}			
			setup.info("Add Job");
			Main_Test_Script.Wait();

			//Add Job Title
			cell = Sfile.getRow(i).getCell(0);
			cell.setCellType(CellType.STRING);
			Add_Job_Locators.EnterJobTitle(driver).sendKeys(cell.getStringCellValue());
			setup.info("Entered Job Title");

			//Add Job Description
			cell = Sfile.getRow(i).getCell(1);
			cell.setCellType(CellType.STRING);
			Add_Job_Locators.EnterJobDescription(driver).sendKeys(cell.getStringCellValue());
			setup.info("Entered Job Description");
			Add_Job_Locators.SaveJob(driver).click();
			setup.info("Saved");
			Thread.sleep(10000);
		}
	}

}
