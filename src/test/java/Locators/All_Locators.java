package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class All_Locators{
	//Login
	public static WebElement UserId(WebDriver driver) {WebElement userid = driver.findElement(By.id("txtUsername"));
	return userid;}
	public static WebElement PassWord(WebDriver driver) {WebElement password = driver.findElement(By.id("txtPassword"));
	return password;}
	public static WebElement LoginSubmit(WebDriver driver) {WebElement loginsubmit = driver.findElement(By.id("btnLogin"));
	return loginsubmit;}


	//Adding Job 
	public static WebElement AdminTab(WebDriver driver) {WebElement admintab = driver.findElement(By.xpath("//*[@id=\"menu_admin_viewAdminModule\"]/a"));
	return admintab;}
	public static WebElement JobTab(WebDriver driver) {WebElement jobtab = driver.findElement(By.xpath("//*[@id=\"menu_admin_Job\"]/a/span[2]"));
	return jobtab;}
	public static WebElement JobTitlesTab(WebDriver driver) {WebElement jobtitlestab = driver.findElement(By.xpath("//*[@id=\"menu_admin_viewJobTitleList\"]/span[2]"));
	return jobtitlestab;}
	public static WebElement AddJob(WebDriver driver) {WebElement addjob = driver.findElement(By.xpath("//*[@id=\"jobTitlesDiv\"]/div/a/i"));
	return addjob;}
	public static WebElement JobTitle(WebDriver driver) {WebElement jobtitle = driver.findElement(By.xpath("//*[@id=\"jobTitleName\"]"));
	return jobtitle;} 
	public static WebElement JobDescription(WebDriver driver) {WebElement jobdescription = driver.findElement(By.xpath("//*[@id=\"jobDescription\"]"));
	return jobdescription;}
	public static WebElement SaveJob(WebDriver driver) {WebElement savejob = driver.findElement(By.xpath("//*[@id=\"modal1\"]/form/div[2]/a[1]"));
	return savejob;}
	public static WebElement CancelJob(WebDriver driver) {WebElement canceljob = driver.findElement(By.xpath("//*[@id=\"modal1\"]/form/div[2]/a[2]"));
	return canceljob;}


	//Salary Components
	
	

}





