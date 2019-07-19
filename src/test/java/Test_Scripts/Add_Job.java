package Test_Scripts;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import Locators.Adding_Job_Locators;
import multiScreenShot.MultiScreenShot;

public class Add_Job {

	public static void AddJob(WebDriver driver, XSSFSheet Sfile, XSSFCell cell, ExtentTest setup, String FilePath, XSSFWorkbook WBfile, MultiScreenShot multiScreens) throws InterruptedException, IOException {


		//Select admin Tab
		Adding_Job_Locators.AdminTab(driver).click();
		setup.info("Admin Tab Selected");


		//Select Job Tab
		Adding_Job_Locators.JobTab(driver).click();
		setup.info("Job Tab Selected");


		//Select Title Tab
		Adding_Job_Locators.JobTitlesTab(driver).click();
		setup.info("Job Title Tab Selected");

		Main_Test_Script.Wait();


		//Looping in the excel for data 
		for (int i=0; i<=Sfile.getLastRowNum(); i++) {

			try {
				//Get addjob web locators from locators file
				Adding_Job_Locators.AddJob(driver).click();
				setup.pass("Adding Job");
				Main_Test_Script.Wait();
			} catch (Exception e) {
				//If an error occur take screenshot 
				multiScreens.multiScreenShot(driver);
			}


			//Import data for job title from excel
			cell = Sfile.getRow(i).getCell(0);
			cell.setCellType(CellType.STRING);

			//Send data 
			Adding_Job_Locators.JobTitle(driver).sendKeys(cell.getStringCellValue());
			setup.info("Entered Job Title");


			//Verifying for duplicate job title
			String AlertMessagBlock = driver.findElement(By.className("help-block")).getText();
			String AlertMessg = "Already exists";
			String message;
			

			if (AlertMessagBlock.equalsIgnoreCase(AlertMessg)) {

				setup.fail("Job Title Already exit");
				multiScreens.multiScreenShot(driver);
				message = "Fail";

			}else {

				//Import data for job description from excel
				cell = Sfile.getRow(i).getCell(1);
				cell.setCellType(CellType.STRING);

				//Send data 
				Adding_Job_Locators.JobDescription(driver).sendKeys(cell.getStringCellValue());
				setup.info("Entered Job Description");

				//Submit job
				Adding_Job_Locators.SaveJob(driver).click();
				setup.pass("Job Submitted");
				message = "Success";
				Thread.sleep(5000);
			}

			// Create cell in excel where message needs to be written.
			Sfile.getRow(i).createCell(2).setCellValue(message);

			// Specify the file in which message needs to be written.
			FileOutputStream fileOutput = new FileOutputStream(FilePath);

			//write message into excel
			WBfile.write(fileOutput);

		}	
	}
}
