package Test_Scripts;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import Locators.Login_Locators;
import Test_Scripts.Main_Test_Script;

public class Login_Test_Script {

	public static void SignIn(WebDriver driver, XSSFSheet Sfile, XSSFCell cell, ExtentTest setup, String FilePath, XSSFWorkbook WBfile) throws InterruptedException, IOException {
		for(int i=0; i<= Sfile.getLastRowNum(); i++)
		{
			// Import data for Email.
			cell = Sfile.getRow(i).getCell(0);
			cell.setCellType(CellType.STRING);
			Login_Locators.UserName(driver).clear();
			Login_Locators.UserName(driver).sendKeys(cell.getStringCellValue());
			setup.info("Imported User Name");

			// Import data for password.
			cell = Sfile.getRow(i).getCell(1);
			cell.setCellType(CellType.STRING);
			Login_Locators.PassWord(driver).clear();
			Login_Locators.PassWord(driver).sendKeys(cell.getStringCellValue());
			setup.info("Imported Password");

			//Click submit
			Login_Locators.Submit(driver).click();
			Thread.sleep(5000);

			String ExpectedUrl = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
			String ActualUrl = driver.getCurrentUrl();
			System.out.println(ActualUrl);
			
			//Local VAriable
			String message;
			
			if (ExpectedUrl.equalsIgnoreCase(ActualUrl)) {
				// Specify the message needs to be written.
				message = "Pass";
			} else {
				// Specify the message needs to be written.
				message = "Fail";
			}

			// Create cell where data needs to be written.
			Sfile.getRow(i).createCell(2).setCellValue(message);

			// Specify the file in which data needs to be written.
			FileOutputStream fileOutput = new FileOutputStream(FilePath);

			// finally write content
			WBfile.write(fileOutput);

			// close the file
			fileOutput.close();
		}
	}

}
