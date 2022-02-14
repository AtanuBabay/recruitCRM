package TestRunner;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pageObject.homePage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class InvokeBrowser {
	
	public WebDriver driver;
	ExtentReports extent;
	homePage home ;
	 @BeforeMethod
	  public void beforeMethod() {
		 String path = System.getProperty("user.dir") + "\\Driver\\chromedriver.exe";
		 System.setProperty("webdriver.chrome.driver",path);
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://recruitcrm.io/");
	  }
	
	 @Test
	 public void validateLandingPage() {
		ExtentTest test=extent.createTest("Uase can vallidate Landing Page");
		home.validateLanding();
		extent.flush();
	  }
	 @Test
	 public void loginPage() {
		 extent.createTest("User able to login sucessfully");
		 home.Login("testaccount@mailinator.com","Passowrd@123");
		 extent.flush();
	 }
	 @Test
	 public void tcs() {
		 
	 }
 
	 @BeforeTest
		public void config() {
			String path=System.getProperty("user.dir")+"\\reports\\index.html";
			  ExtentSparkReporter reporter= new ExtentSparkReporter(path);
			  reporter.config().setReportName("Web Automation Result");
			  reporter.config().setDocumentTitle("Test Result");
			  
			  extent = new ExtentReports();
			  extent.attachReporter(reporter);
			  extent.setSystemInfo("Tester", "Atanu Sarkar");
		}
	 
	  @AfterMethod
	  public void afterMethod() {
		  
	  }

}
