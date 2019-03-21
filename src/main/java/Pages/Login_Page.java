package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_Page {

	//Login
	public static WebElement Login(WebDriver driver) {
		WebElement email = driver.findElement(By.name("txtUsername"));
		WebElement password = driver.findElement(By.name("txtPassword"));
		WebElement submit = driver.findElement(By.name("Submit"));
		return email;
	}
}
