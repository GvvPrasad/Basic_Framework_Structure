package Test_Scripts;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import Locators.Login_Locators;
import Test_Scripts.Main_Test_Script;

public class Login_Test_Script {

	public static void SignIn(WebDriver driver, XSSFSheet Sfile, XSSFCell cell) throws InterruptedException {
		for(int i=0; i<= Sfile.getLastRowNum(); i++)
		{
			// Import data for Email.
			cell = Sfile.getRow(i).getCell(0);
			cell.setCellType(CellType.STRING);
			Login_Locators.UserName(driver).clear();
			Login_Locators.UserName(driver).sendKeys(cell.getStringCellValue());
			//setup.info("Imported User Name");

			// Import data for password.
			cell = Sfile.getRow(i).getCell(1);
			cell.setCellType(CellType.STRING);
			Login_Locators.PassWord(driver).clear();
			Login_Locators.PassWord(driver).sendKeys(cell.getStringCellValue());
			//setup.info("Imported Password");
			
			//Click submit
			Login_Locators.Submit(driver).click();
			Thread.sleep(3000);
		}
	}
	}
