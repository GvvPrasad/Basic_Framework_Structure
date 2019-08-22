package Test_Scripts;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import Locators.All_Locators;

public class Apply_Leave {

	public static void ApplyLeave(WebDriver driver, ExtentTest setup) throws InterruptedException{

		All_Locators.LeaveTab(driver).click();
		setup.info("Leave Tab Selected");
		All_Locators.ApplyTab(driver).click();
		setup.info("Apply Atb Selected");
		Thread.sleep(5000);
		
		
		
	}
}
