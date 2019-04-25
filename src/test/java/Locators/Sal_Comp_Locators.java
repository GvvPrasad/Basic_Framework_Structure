package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Sal_Comp_Locators {

	//Salary Components Tab
	public static WebElement SalCompTab(WebDriver driver) {
		WebElement salcomptab = driver.findElement(By.xpath("//*[@id=\"menu_admin_viewSalaryComponentList\"]/span[2]"));
		return salcomptab;
	}

	//Add Salary Components
	public static WebElement AddComp(WebDriver driver) {
		WebElement AddComp = driver.findElement(By.xpath("//*[@id=\"salaryComponentDiv\"]/div/a/i"));
		return AddComp;
	}

	//Add Components Name
	public static WebElement CompName(WebDriver driver) {
		WebElement CompName = driver.findElement(By.xpath("//*[@id=\"name\"]"));
		return CompName;
	}

	//Add Components Type
	public static WebElement CompType(WebDriver driver) {
		WebElement CompType = driver.findElement(By.xpath("//*[@id=\"editSalaryComponentModal\"]/form/div[1]/div/materializecss-decorator[2]/div/sf-decorator/div/ul/li[2]/label"));
		return CompType;
	}

	//Add Components Add To
	public static WebElement CompAddTo(WebDriver driver) {
		WebElement CompAddTo = driver.findElement(By.xpath("//*[@id=\"editSalaryComponentModal\"]/form/div[1]/div/materializecss-decorator[4]/div/sf-decorator[2]/div/label"));
		return CompAddTo;
	}

	//Add Components Value Type
	public static WebElement CompValType(WebDriver driver) {
		WebElement CompValType = driver.findElement(By.xpath("//*[@id=\"editSalaryComponentModal\"]/form/div[1]/div/materializecss-decorator[6]/div/sf-decorator[2]/div/label"));
		return CompValType;
	}
	
	//Add Button
		public static WebElement SaveButton(WebDriver driver) {
			WebElement SaveButton = driver.findElement(By.xpath("//*[@id=\"editSalaryComponentModal\"]/form/div[2]/a[1]"));
			return SaveButton;
		}
}
