package Config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.testng.annotations.Test;

import Test_Scripts.Main_Test_Script;

public class PropertiesFile {

	//Properties Object
	static Properties Prop = new Properties();
	static String ProjectPath = System.getProperty("user.dir");

	@Test(priority=1)
	public static void Call() {
		GetProperties();
	}

	//Get Data from properties file
	public static void GetProperties() {
		try {
			InputStream Input = new FileInputStream(ProjectPath+"//src//test//java//Config//Config.properties");
			Prop.load(Input);
			String Browser = Prop.getProperty("Browser");
			String Url = Prop.getProperty("Url");
			Main_Test_Script.BrowserName = Browser;
			Main_Test_Script.Url = Url;
			System.out.println(Browser);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}

	}
	// End of getting data from properties file
}
