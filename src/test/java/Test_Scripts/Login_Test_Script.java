package Test_Scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_Test_Script {

	public static void main(String[] args) {
		//setting Chrome Driver from WebDriverManager  
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		//Open Browser
		driver.get("https://orangehrm-demo-6x.orangehrmlive.com/");
		
	}

}
