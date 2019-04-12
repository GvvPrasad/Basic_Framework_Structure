package Test_Scripts;

import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import Locators.Add_Employe_Locators;

public class Add_Employe {

	public static void AddEmploye(WebDriver driver, XSSFSheet Sfile, XSSFCell cell, ExtentTest setup, String FilePath, XSSFWorkbook WBfile) throws InterruptedException, IOException {

		//Move to Admin Tab
		Add_Employe_Locators.AdminTab(driver).click();

		// Add Employee
		Add_Employe_Locators.AddButton(driver).click();
		
		//Fill Form
		for (int i = 0; i < Sfile.getLastRowNum(); i++) {
			//Select Role
			cell = Sfile.getRow(i).getCell(0);
			cell.setCellType(CellType.STRING);
			Add_Employe_Locators.SelectRole(driver);
			
			
			//Enter Employer Name
			//Enter User Name
			//Select Status
			//Enter Passowrd
			//Enter Confirm Password
		}
		Thread.sleep(5000);
	}
}
