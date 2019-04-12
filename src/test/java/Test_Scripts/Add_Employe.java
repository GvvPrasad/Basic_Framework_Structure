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
			/*cell = Sfile.getRow(i).getCell(0);
			cell.setCellType(CellType.STRING);
			Add_Employe_Locators.SelectRole(driver);
			*/
			
			//Enter Employer Name
			cell = Sfile.getRow(i).getCell(0);
			cell.setCellType(CellType.STRING);
			Add_Employe_Locators.EmpName(driver).sendKeys(cell.getStringCellValue());
			
			//Enter User Name
			cell = Sfile.getRow(i).getCell(1);
			cell.setCellType(CellType.STRING);
			Add_Employe_Locators.UserName(driver).sendKeys(cell.getStringCellValue());
			
			//Select Status
			
			//Enter Passowrd
			cell = Sfile.getRow(i).getCell(2);
			cell.setCellType(CellType.STRING);
			Add_Employe_Locators.PassWord(driver).sendKeys(cell.getStringCellValue());
			
			//Enter Confirm Password
			cell = Sfile.getRow(i).getCell(3);
			cell.setCellType(CellType.STRING);
			Add_Employe_Locators.ConfPassWord(driver).sendKeys(cell.getStringCellValue());
			
			//Save
			Add_Employe_Locators.Save(driver).click();
		}
		Thread.sleep(5000);
	}
}
