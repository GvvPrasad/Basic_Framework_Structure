package Test_Scripts;

import org.openqa.selenium.WebDriver;
import Locators.All_Locators;

public class Apply_Leave {

	public static void ApplyLeave(WebDriver driver){

		All_Locators.LeaveTab(driver).click();
		All_Locators.ApplyTab(driver).click();
		Main_Test_Script.Wait();
		All_Locators.LeaveType(driver).click();
		Main_Test_Script.Wait();
		
	}
}
