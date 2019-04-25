package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Add_Job_Locators {

	//Admin Tab
	public static WebElement AdminTab(WebDriver driver) {
		WebElement admintab = driver.findElement(By.xpath("//li[@class='level1 admin no-padding parent']"));
		return admintab;
	}

	//job
	public static WebElement Job(WebDriver driver) {
		WebElement job = driver.findElement(By.xpath("//*[@id=\"menu_admin_Job\"]/a/span[2]"));
		return job;
	}

	//Job Titles
	public static WebElement JobTitle(WebDriver driver) {
		WebElement jobtitle = driver.findElement(By.xpath("//*[@id=\"menu_admin_viewJobTitleList\"]/span[2]"));
		return jobtitle;
	}

	//Add job
	public static WebElement AddJob(WebDriver driver) {
		WebElement addjob = driver.findElement(By.xpath("//*[@id=\"jobTitlesDiv\"]/div/a/i"));
		return addjob;
	}

	//Enter Job Title
	public static WebElement EnterJobTitle(WebDriver driver) {
		WebElement enterjobtitle = driver.findElement(By.xpath("//*[@id=\"jobTitleName\"]"));
		return enterjobtitle;
	} 

	//Enter Job Description
	public static WebElement EnterJobDescription(WebDriver driver) {
		WebElement enterjobdescription = driver.findElement(By.xpath("//*[@id=\"jobDescription\"]"));
		return enterjobdescription;
	}

	//Save Job
	public static WebElement SaveJob(WebDriver driver) {
		WebElement savejob = driver.findElement(By.xpath("//*[@id=\"modal1\"]/form/div[2]/a[1]"));
		return savejob;
	}
}
