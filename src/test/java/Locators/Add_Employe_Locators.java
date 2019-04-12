package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Add_Employe_Locators {

	//Admin Tab
	public static WebElement AdminTab(WebDriver driver) {
		WebElement admintab = driver.findElement(By.xpath("//b[contains(text(),'Admin')]"));
		return admintab;
	}

	//Click Add
	public static WebElement AddButton(WebDriver driver) {
		WebElement addbutton = driver.findElement(By.xpath("//input[@id='btnAdd']"));
		return addbutton;
	}

	//Select Roal
	public static WebElement SelectRole(WebDriver driver) {
		Select role = new Select(driver.findElement(By.id("systemUser_userType")));
		return (WebElement) role;
	}

	//Click Employee Name
	public static WebElement EmpName(WebDriver driver) {
		WebElement empname = driver.findElement(By.xpath("//input[@id='systemUser_employeeName_empName']"));
		return empname;
	}

	//Click User Name
	public static WebElement UserName(WebDriver driver) {
		WebElement username = driver.findElement(By.xpath("//input[@id='systemUser_userName']"));
		return username;
	}

	//Select Status
	public static WebElement SelectStatus(WebDriver driver) {
		Select status = new Select(driver.findElement(By.id("systemUser_status")));
		return (WebElement) status;
	}

	//Click Password
	public static WebElement PassWord(WebDriver driver) {
		WebElement password = driver.findElement(By.xpath("//input[@id='systemUser_password']"));
		return password;
	}

	//Click Confirm Password
	public static WebElement ConfPassWord(WebDriver driver) {
		WebElement confpassword = driver.findElement(By.xpath("//input[@id='systemUser_confirmPassword']"));
		return confpassword;
	}

	//Click Save
	public static WebElement Save(WebDriver driver) {
		WebElement save = driver.findElement(By.xpath("//input[@id='btnSave']"));
		return save;
	}
}
