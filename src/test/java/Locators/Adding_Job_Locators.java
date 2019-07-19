package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Adding Job
public class Adding_Job_Locators {
	//Admin Tab
	public static WebElement AdminTab(WebDriver driver) {
		WebElement admintab = driver.findElement(By.xpath("//li[@class='level1 admin no-padding parent']"));
		return admintab;
	}

	//job Tab
	public static WebElement JobTab(WebDriver driver) {
		WebElement jobtab = driver.findElement(By.xpath("//*[@id=\"menu_admin_Job\"]/a/span[2]"));
		return jobtab;
	}

	//Job Titles
	public static WebElement JobTitlesTab(WebDriver driver) {
		WebElement jobtitlestab = driver.findElement(By.xpath("//*[@id=\"menu_admin_viewJobTitleList\"]/span[2]"));
		return jobtitlestab;
	}

	//Add job
	public static WebElement AddJob(WebDriver driver) {
		WebElement addjob = driver.findElement(By.xpath("//*[@id=\"jobTitlesDiv\"]/div/a/i"));
		return addjob;
	}

	//Enter Job Title
	public static WebElement JobTitle(WebDriver driver) {
		WebElement jobtitle = driver.findElement(By.xpath("//*[@id=\"jobTitleName\"]"));
		return jobtitle;
	} 

	//Enter Job Description
	public static WebElement JobDescription(WebDriver driver) {
		WebElement jobdescription = driver.findElement(By.xpath("//*[@id=\"jobDescription\"]"));
		return jobdescription;
	}

	//Save/submit Job
	public static WebElement SaveJob(WebDriver driver) {
		WebElement savejob = driver.findElement(By.xpath("//*[@id=\"modal1\"]/form/div[2]/a[1]"));
		return savejob;
	}
}

