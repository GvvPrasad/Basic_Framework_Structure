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
	
	//Signout
	public static WebElement SignOutTab(WebDriver driver) {WebElement SignOutTab = driver.findElement(By.id("account-job"));
	return SignOutTab;}
	public static WebElement SignOutbtn(WebDriver driver) {WebElement SignOutbtn = driver.findElement(By.id("logoutLink"));
	return SignOutbtn;}

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
	public static WebElement SalaryComp(WebDriver driver) {WebElement salarycomp = driver.findElement(By.xpath("//*[@id=\"menu_admin_viewSalaryComponentList\"]/span[2]"));
	return salarycomp;}
	public static WebElement SalaryAdd(WebDriver driver) {WebElement salaryadd = driver.findElement(By.xpath("//*[@id=\"salaryComponentDiv\"]/div/a/i"));
	return salaryadd;}
	public static WebElement CompName(WebDriver driver) {WebElement compname = driver.findElement(By.xpath("//*[@id=\"name\"]"));
	return compname;}
	public static WebElement ErrorBox(WebDriver driver) {WebElement errorbox = driver.findElement(By.xpath("//*[@id=\"editSalaryComponentModal\"]/form/div[1]/div/materializecss-decorator[1]/div/sf-decorator/div/span")); 
	return errorbox;}
	public static WebElement Earning(WebDriver driver) {WebElement earning = driver.findElement(By.xpath("//*[@id=\"editSalaryComponentModal\"]/form/div[1]/div/materializecss-decorator[2]/div/sf-decorator/div/ul/li[1]/label"));
	return earning;}
	public static WebElement CTC(WebDriver driver) {WebElement ctc = driver.findElement(By.xpath("//*[@id=\"editSalaryComponentModal\"]/form/div[1]/div/materializecss-decorator[4]/div/sf-decorator[2]/div/label"));
	return ctc;}
	public static WebElement Amount(WebDriver driver) {WebElement amount = driver.findElement(By.xpath("//*[@id=\"editSalaryComponentModal\"]/form/div[1]/div/materializecss-decorator[6]/div/sf-decorator[1]/div/label"));
	return amount;}
	public static WebElement SaveSal(WebDriver driver) {WebElement savesal = driver.findElement(By.xpath("//*[@id=\"editSalaryComponentModal\"]/form/div[2]/a[1]"));
	return savesal;}
	public static WebElement CancelSal(WebDriver driver) {WebElement cancelsal = driver.findElement(By.xpath("//*[@id=\"editSalaryComponentModal\"]/form/div[2]/a[2]"));
	return cancelsal;}
	

}





