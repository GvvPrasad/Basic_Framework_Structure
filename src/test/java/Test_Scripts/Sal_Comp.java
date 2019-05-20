package Test_Scripts;

import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import Locators.Sal_Comp_Locators;
import multiScreenShot.MultiScreenShot;

public class Sal_Comp {
	public static void SalComp(WebDriver driver, XSSFSheet Sfile, XSSFCell cell, ExtentTest setup, String FilePath, XSSFWorkbook WBfile, MultiScreenShot multiScreens) throws InterruptedException, IOException {

		Sal_Comp_Locators.SalCompTab(driver).click();
		setup.info("Salary Components Tab Selected");
			
		for (int i=0; i <=Sfile.getLastRowNum(); i++) {
			Main_Test_Script.Wait();
			System.out.println("for loop");
			try {
				System.out.println("for loop - try block");
				Sal_Comp_Locators.AddComp(driver).click();
				setup.info("Salary Add Button Selected");
			} catch (Exception e) {
				multiScreens.multiScreenShot(driver);
			}			
			Main_Test_Script.Wait();

			//Add Salary Comp Title
			cell = Sfile.getRow(i).getCell(0);
			cell.setCellType(CellType.STRING);
			Sal_Comp_Locators.CompName(driver).sendKeys(cell.getStringCellValue());
			setup.info("Entered Salary Comp Title");

		}

	}
}
