package TestRunner;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class InvokeBrowser {
	
	WebDriver driver;
	ExtentReports extent;
	 @BeforeMethod
	  public void beforeMethod() {
		 String path = System.getProperty("user.dir") + "\\Driver\\chromedriver.exe";
		 System.setProperty("webdriver.chrome.driver",path);
		 
		 driver = new ChromeDriver();
	  }
	
	 @Test
	 public void invoke() {
		ExtentTest test=extent.createTest("RecruitCRM Demo");
		driver.manage().window().maximize();
		driver.get("https://recruitcrm.io/");
		driver.findElement(By.xpath("//a[text()[contains(.,'Sign in')]]")).click();
		extent.flush();
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
