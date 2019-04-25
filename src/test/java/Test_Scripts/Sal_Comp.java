package Test_Scripts;

import java.io.IOException;

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
		
		Sal_Comp_Locators.AddComp(driver).click();
		setup.info("Add Button Selected");
		
		
	}
}
