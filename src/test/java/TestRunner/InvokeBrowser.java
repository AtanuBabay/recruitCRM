package TestRunner;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pageObject.homePage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;

public class InvokeBrowser{
//	public WebDriver driver;
	ExtentReports extent;
	public RemoteWebDriver driver = null;
	homePage homePage;
	
//	public InvokeBrowser(WebDriver driver) {
//		this.driver = driver;
//		}
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
		homePage = new homePage(driver);
		homePage.validateLanding();
		extent.flush();
	  }
	 
	 @Test
	 public void loginPage() throws InterruptedException {
		 extent.createTest("User able to login sucessfully");
		 homePage = new homePage(driver);
		 homePage.Login("testaccount@mailinator.com","Passowrd@123");
		 extent.flush();
	 }
	 @Test
	 public void validateLoginPage() throws InterruptedException {
		 extent.createTest("User able to login sucessfully");
		 homePage = new homePage(driver);
		 homePage.Login("testaccount@mailinator.com","Passowrd@123");
		 extent.flush();
	 }
	 
	 @Test
	 public void addCandidate() throws InterruptedException {
		 extent.createTest("User able to login sucessfully");
		 homePage = new homePage(driver);
		 homePage.Login("testaccount@mailinator.com","Passowrd@123");
		 extent.flush();
	 }
	 
	 @Test
	 public void deleteCandidate() throws InterruptedException {
		 extent.createTest("User able to login sucessfully");
		 homePage = new homePage(driver);
		 homePage.Login("testaccount@mailinator.com","Passowrd@123");
		 extent.flush();
	 }
	 @Test
	 public void addCompany() throws InterruptedException {
		 extent.createTest("User able to login sucessfully");
		 homePage = new homePage(driver);
		 homePage.Login("testaccount@mailinator.com","Passowrd@123");
		 extent.flush();
	 }
	 @Test
	 public void deleteCompany() throws InterruptedException {
		 extent.createTest("User able to login sucessfully");
		 homePage = new homePage(driver);
		 homePage.Login("testaccount@mailinator.com","Passowrd@123");
		 extent.flush();
	 }
	 
	 @Test
	 public void importCandidate() throws InterruptedException {
		 extent.createTest("User able to login sucessfully");
		 homePage = new homePage(driver);
		 homePage.Login("testaccount@mailinator.com","Passowrd@123");
		 extent.flush();
	 }
	 @Test
	 public void viewReport() throws InterruptedException {
		 extent.createTest("User able to login sucessfully");
		 homePage = new homePage(driver);
		 homePage.Login("testaccount@mailinator.com","Passowrd@123");
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
