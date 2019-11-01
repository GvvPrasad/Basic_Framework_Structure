package Test_Scripts;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import Locators.All_Locators;
import multiScreenShot.MultiScreenShot;

public class Salary_Comp {

	public static void SalaryComp(WebDriver driver, XSSFSheet Sfile, ExtentTest setup, MultiScreenShot multiScreens, XSSFCell cell, XSSFWorkbook WBfile, String FilePath) throws IOException, InterruptedException {
		//
		All_Locators.AdminTab(driver).click();
		All_Locators.JobTab(driver).click();
		//
		All_Locators.SalaryComp(driver).click();
		Thread.sleep(10000);
		
		//Looping in the excel for data 
		for (int i=0; i<=Sfile.getLastRowNum(); i++) {
			try {
				All_Locators.SalaryAdd(driver).click();
				setup.info("Adding Salary Comp");
				Thread.sleep(5000);
			} catch (Exception e) {
				multiScreens.multiScreenShot(driver);
			}
			

			//Import & send data for job title from excel
			All_Locators.CompName(driver).clear();
			cell = Sfile.getRow(i).getCell(0);
			cell.setCellType(CellType.STRING);
			All_Locators.CompName(driver).sendKeys(cell.getStringCellValue());

			
			//Verifying for duplicate job title
			String AlertMessagBlock = All_Locators.ErrorBox(driver).getText();
			String AlertMessg = "Already exists";
			String message;

			if (AlertMessagBlock.equalsIgnoreCase(AlertMessg)) {
				message = "Already exit";
				multiScreens.multiScreenShot(driver);
				setup.fail("Salary Comp Already exit");			
				All_Locators.CancelSal(driver).click();
				Thread.sleep(5000);
			}else {
				
				if (All_Locators.Earning(driver).isEnabled()) {}
				else {All_Locators.Earning(driver).click();}
				
				if (All_Locators.CTC(driver).isEnabled()) {} 
				else {All_Locators.CTC(driver).click();}
				
				if (All_Locators.Amount(driver).isEnabled()) {} 
				else {All_Locators.Amount(driver).click();}
				
				//Submit Salary Comp
				All_Locators.SaveSal(driver).click();
				message = "Salary Comp Added";
				setup.pass("Salary Comp Added");
				Thread.sleep(5000);
			}
			
			// Create cell in excel where message needs to be written.
			Sfile.getRow(i).createCell(1).setCellValue(message);

			// Specify the file in which message needs to be written.
			FileOutputStream fileOutput = new FileOutputStream(FilePath);

			//write message into excel
			WBfile.write(fileOutput);
			Thread.sleep(5000);
		}
		//End For Loop

	}
}
