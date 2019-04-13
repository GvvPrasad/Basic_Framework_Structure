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

public class Login_Test_Script {

	public static void SignIn(WebDriver driver, XSSFSheet Sfile, XSSFCell cell, ExtentTest setup, String FilePath, XSSFWorkbook WBfile) throws InterruptedException, IOException {
		for(int i=0; i<= Sfile.getLastRowNum(); i++)
		{
			// Import data for Email.
			cell = Sfile.getRow(i).getCell(0);
			cell.setCellType(CellType.STRING);
			Login_Locators.UserName(driver).clear();
			Login_Locators.UserName(driver).sendKeys(cell.getStringCellValue());
			setup.info("Enter User Name");

			// Import data for password.
			cell = Sfile.getRow(i).getCell(1);
			cell.setCellType(CellType.STRING);
			Login_Locators.PassWord(driver).clear();
			Login_Locators.PassWord(driver).sendKeys(cell.getStringCellValue());
			setup.info("Enter Password");

			//Click submit
			Login_Locators.Submit(driver).click();
			setup.info("Click Submit");
			Thread.sleep(5000);

			String ExpectedUrl = "https://orangehrm-demo-6x.orangehrmlive.com/client/#/dashboard";
			String ActualUrl = driver.getCurrentUrl();
			
			//Local VAriable
			String message;
			
			if (ExpectedUrl.equalsIgnoreCase(ActualUrl)) {
				// Specify the message needs to be written.
				message = "Pass";
				setup.info("Login Success");
			} else {
				// Specify the message needs to be written.
				message = "Fail";
				setup.info("Login Failed");
			}

			// Create cell where data needs to be written.
			Sfile.getRow(i).createCell(2).setCellValue(message);

			// Specify the file in which data needs to be written.
			FileOutputStream fileOutput = new FileOutputStream(FilePath);

			// finally write content
			WBfile.write(fileOutput);
		}
	}

}
