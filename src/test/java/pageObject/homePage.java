package pageObject;
import base.BaseUtil;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestRunner.InvokeBrowser;

public class homePage extends InvokeBrowser{
    public WebDriver driver;
    BaseUtil BaseUtil;
    WebDriverWait wait;
    
	@FindBy(xpath="//a[text()[contains(.,'Sign in')]]")
	public WebElement Sign_in;
	
	@FindBy(xpath="//img[@alt='logo']")
	public WebElement logo;
	
	@FindBy(xpath="(//input[@class='input login-input'])[1]")
	public WebElement inputEmail;
	
	@FindBy(xpath="(//input[@class='input login-input'])[2]")
	public WebElement inputPassword;
	
	@FindBy(xpath="//button[@id='sTestLoginBtn']")
	public WebElement loginBtn;
	
	@FindBy(xpath="//img[@class='user-dropdown-link']")
	public WebElement clickOnprofileBtn;
	
	@FindBy(xpath="(//div[@class='content'])[1]/small")
	public WebElement validateProfile;
	
	@FindBy(xpath="//a[@id='sTest-addCandidateBtn']")
	public WebElement addCandidateBtn;
	@FindBy(xpath="//i[text()='people']/parent::a")
	public WebElement selectCandidate;
	@FindBy(xpath="//input[@id='sTest-candidateFirstName']")
	public WebElement FirstName;
	@FindBy(xpath="//input[@id='sTest-candidateLastName']")
	public WebElement LastName;
	@FindBy(xpath="//input[@id='sTest-candidateEmail']")
	public WebElement candiEmail;
	@FindBy(xpath="//button[text()='Submit']")
	public WebElement submitBtn;
	@FindBy(xpath="//h2[@id='sTest-candidateNameDetailPage']")
	public WebElement validateUser;
	@FindBy(xpath="(//input[@id='sTest-searchControl'])[1]")
	public WebElement searchControl;
	@FindBy(xpath="(//div[@class='content'])[1]/a/h2/span[1]")
	public WebElement validateSearch;
	@FindBy(xpath="(//input[@type='checkbox'])[2]/parent::label")
	public WebElement selectUserCheckBox;
	@FindBy(xpath="//a[@id='sTest-deleteBulkBtn']")
	public WebElement seletDeleteBtn;
	@FindBy(xpath="//input[@name='Records Count']")
	public WebElement recordCount;
	@FindBy(xpath="//button[text()='Delete']")
	public WebElement deleteBtn;
	@FindBy(xpath="//td[@class='deleted-table-row']/p")
	public WebElement validateDeleteRecord;
	@FindBy(xpath="//i[@id='sTest-companiesIcon']/parent::a")
	public WebElement selectCompanyTab;
	@FindBy(xpath="//a[@id='sTest-addCompanyBtn']")
	public WebElement addCompany;
	@FindBy(xpath="//input[@id='sTest-companyNameTxt']")
	public WebElement companyName;
	@FindBy(xpath="//input[@id='sTest-industryTxt']")
	public WebElement industryWork;
	@FindBy(xpath="//b[text()[contains(.,'Information Tech')]]")
	public WebElement industrySuggestion;
	@FindBy(xpath="//input[@id='sTest-companyWebsiteTxt']")
	public WebElement companyWebsite;
	@FindBy(xpath="//h2[@id='sTest-companyNameCompanyDpage']")
	public WebElement validateCompany;
	@FindBy(xpath="//p[text()='Import Candidates']")
	public WebElement selectImportCandidate;
	@FindBy(xpath="//span[text()[contains(.,'Upload file')]]")
	public WebElement selectUploadFileBtn;
	@FindBy(xpath="//i[@id='sTest-reportsIcon']")
	public WebElement selectReportsTab;
	//protacted WebDriver driver;
	
	public homePage(WebDriver driver) {
		//TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void validateLanding() {
		Boolean display= logo.isDisplayed();
		assertTrue(display);
	
	}
	public void Login(String email,String password) throws InterruptedException {
		//driver.get("https://recruitcrm.io/");
//		BaseUtil = new BaseUtil();
//		String lemail = BaseUtil.returnvaluefromexcel("3");
		Sign_in.click();
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	    wait = new WebDriverWait(driver,30);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='sTestLoginBtn']")));
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		inputEmail.click();
		inputEmail.sendKeys(email);
		inputPassword.click();
		inputPassword.sendKeys(password);
		loginBtn.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='user-dropdown-link']")));
		clickOnprofileBtn.click();
		String profileId = validateProfile.getText();
		assertEquals(email, profileId);
	}
	public void addCandidate(String FName, String LName, String CEmail) {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		selectCandidate.click();
		addCandidateBtn.click();
		FirstName.sendKeys(FName);
		LastName.sendKeys(LName);
		candiEmail.sendKeys(CEmail);
		submitBtn.click();
		String UserData = validateUser.getText();
		Boolean bool = UserData.contains(FName);
		assertTrue(bool);
	}
	public void searchCandidate(String CandidateDetails) {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		searchControl.click();
		searchControl.sendKeys(CandidateDetails);
		Boolean display= validateSearch.isDisplayed();
		assertTrue(display);
		validateSearch.click();
		String UserData = validateUser.getText();
		Boolean bool = UserData.contains(CandidateDetails);
		assertTrue(bool);
	}
	public void deleteUser() {
		selectCandidate.click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		selectUserCheckBox.click();
		seletDeleteBtn.click();
		recordCount.sendKeys("1");
		deleteBtn.click();
		String deleteMessage = validateDeleteRecord.getText();
		assertEquals(deleteMessage, "This Record Has Been Removed");
	}
	public void addCompany(String CName, String industry, String website) {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		selectCompanyTab.click();
		addCompany.click();
		companyName.sendKeys(CName);
		industryWork.sendKeys(industry);
		industrySuggestion.click();
		companyWebsite.sendKeys(website);
		submitBtn.click();
		String UserData = validateUser.getText();
		Boolean bool = UserData.contains(CName);
		assertTrue(bool);
	}
	public void deleteComp() {
		selectCompanyTab.click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		selectUserCheckBox.click();
		seletDeleteBtn.click();
		recordCount.sendKeys("1");
		deleteBtn.click();
		String deleteMessage = validateDeleteRecord.getText();
		assertEquals(deleteMessage, "This Record Has Been Removed");
	}
	public void candImport() {
		selectImportCandidate.click();
		selectUploadFileBtn.click();
	}
   public void viewReport() {
	   selectReportsTab.click();
	}
}
