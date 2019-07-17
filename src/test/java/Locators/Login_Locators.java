package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_Locators {

	//User Name
	public static WebElement UserName(WebDriver driver) {
		WebElement userid = driver.findElement(By.id("txtUsername"));
		userid.clear();
		return userid;
	}

	//Password
	public static WebElement PassWord(WebDriver driver) {
		WebElement password = driver.findElement(By.id("txtPassword"));
		password.clear();
		return password;
	}

	//Submit
	public static WebElement Submit(WebDriver driver) {
		WebElement submit = driver.findElement(By.id("btnLogin"));
		return submit;
	}
}
