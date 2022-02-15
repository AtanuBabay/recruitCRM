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
		 extent.createTest("User Login");
		 homePage = new homePage(driver);
		 homePage.Login("testaccount@mailinator.com","Passowrd@123");
		 extent.flush();
	 }
	 
	 @Test
	 public void addCandidate() throws InterruptedException {
		 extent.createTest("Add Candidate");
		 homePage = new homePage(driver);
		 homePage.Login("testaccount@mailinator.com","Passowrd@123");
		 homePage.addCandidate("Atanu", "Sarkar", "candidate1@mailinator.com");
		 extent.flush();
	 }
	 
	 @Test
	 public void searchUser() throws InterruptedException {
		 extent.createTest("Search User");
		 homePage = new homePage(driver);
		 homePage.Login("testaccount@mailinator.com","Passowrd@123");
		 homePage.searchCandidate("Atanu");
		 extent.flush();
	 }
	 
	 @Test
	 public void deleteCandidate() throws InterruptedException {
		 extent.createTest("Delete User");
		 homePage = new homePage(driver);
		 homePage.Login("testaccount@mailinator.com","Passowrd@123");
		 homePage.deleteUser();
		 extent.flush();
	 }
	 @Test
	 public void addCompany() throws InterruptedException {
		 extent.createTest("Add Company");
		 homePage = new homePage(driver);
		 homePage.Login("testaccount@mailinator.com","Passowrd@123");
		 homePage.addCompany("Recruit Technology", "Information technology", "xyz.com");
		 extent.flush();
	 }
	 @Test
	 public void deleteCompany() throws InterruptedException {
		 extent.createTest("Delete Company");
		 homePage = new homePage(driver);
		 homePage.Login("testaccount@mailinator.com","Passowrd@123");
		 homePage.deleteComp();
		 extent.flush();
	 }
	 
	 @Test
	 public void importCandidate() throws InterruptedException {
		 extent.createTest("import Candidate");
		 homePage = new homePage(driver);
		 homePage.Login("testaccount@mailinator.com","Passowrd@123");
		 homePage.candImport();
		 extent.flush();
	 }
	 @Test
	 public void viewReport() throws InterruptedException {
		 extent.createTest("View Report");
		 homePage = new homePage(driver);
		 homePage.Login("testaccount@mailinator.com","Passowrd@123");
		 homePage.viewReport();
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
