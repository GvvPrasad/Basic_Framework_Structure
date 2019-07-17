package Test_Scripts;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import Locators.Login_Locators;
import multiScreenShot.MultiScreenShot;

public class Login_Test_Script {

	public static void SignIn(WebDriver driver, XSSFSheet Sfile, XSSFCell cell, ExtentTest setup, String FilePath, XSSFWorkbook WBfile, MultiScreenShot multiScreens) throws InterruptedException, IOException {
		
		//Local VAriable
		String ExpectedUrl = "https://orangehrm-demo-6x.orangehrmlive.com/client/#/dashboard";
		String ActualUrl = driver.getCurrentUrl();
		String message;
		
		//Looping in the excel for data 
		for(int i=0; i<= Sfile.getLastRowNum(); i++)
		{
			// Import data for Email from Excel.
			cell = Sfile.getRow(i).getCell(0);
			cell.setCellType(CellType.STRING);
			
			//Send username data from Excel
			Login_Locators.UserName(driver).sendKeys(cell.getStringCellValue());

			// Import data for password from Excel.
			cell = Sfile.getRow(i).getCell(1);
			cell.setCellType(CellType.STRING);
						
			//Send password data from Excel
			Login_Locators.PassWord(driver).sendKeys(cell.getStringCellValue());

			//Click submit
			//Get submit web locators from locators file
			Login_Locators.Submit(driver).click();
			
			setup.info("Entered and Submitted login details");
			Thread.sleep(5000);			
			
			
			//Login verification
			if (ExpectedUrl.equalsIgnoreCase(ActualUrl)) {
				//message needs to be written in Excel.
				message = "Pass";
				setup.pass("Login Successed");
			} else {
				message = "Fail";
				setup.fail("Login Failed");
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
