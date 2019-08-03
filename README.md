# Framework_Structure

### Description
It is a DataDriven Framework made for Web Applications in Java Programming Language with Maven build automation tool and TestNG.

Demo Site: https://orangehrm-demo-6x.orangehrmlive.com/

This Framework and Code are written according to the above Website


### Dependencies, Packages, Jar's used in this Framework
1.  Selenium-Java 
2.  TestNG
3.  JUnit
4.  Webdrivermanager
5.  Extendreports
6.  poi-ooxml
7.  multiscreenshot

### Project Structure


```
	Root
    ├── src
    │   ├── config
    │   ├── Locators
    │   └── Test Scripts
    │── Excel Files
    │── Reports
    └── Screenshots
```


The Web Application URL and the Browser details are stored in config.properties file

Locators of input field are stored in a seperate class file in "Locators" Package

Input Field values are stored in Excle in "Excel_File" Floder

Test Script are stored in "Test_Script" Packages

### Project WorkFlow  
Main_Test_Script.java in Test_Script Packages is the main test script file which has to run

1.  First - Necessary configurations are made for generating Reports, Screenshot and getting Excel Data 
2.  Second - It get the information about Web Application and Browser from config.properties file 
3.  Third - It run the Test Case/Test Script file
	- First - It get/find the Input Field details from "Locators" file
	- Second - Input field value/user data is taken from Excel file
	- Third - Writing back Testcase result in Excel
4.  Closing the Web Application
5.  Generating the HTML Report of overall the Test







