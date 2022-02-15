package pageObject;
import base.BaseUtil;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import TestRunner.InvokeBrowser;

public class homePage extends InvokeBrowser{
    public WebDriver driver;
    BaseUtil BaseUtil;
    
	@FindBy(xpath="//a[text()[contains(.,'Sign in')]]")
	public WebElement Sign_in;
	
	@FindBy(xpath="//img[@alt='logo']")
	public WebElement logo;
	
	@FindBy(xpath="(//input[@class='input login-input'])[1]")
	public WebElement inputEmail;
	
	@FindBy(xpath="//div[@class='field']/input)[2]")
	public WebElement inputPassword;
	
	@FindBy(xpath="//button[@id='sTestLoginBtn']")
	public WebElement loginBtn;
	
	@FindBy(xpath="//img[@class='user-dropdown-link']")
	public WebElement clickOnprofileBtn;
	
	@FindBy(xpath="(//div[@class='content'])[1]/small")
	public WebElement validateProfile;

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
		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		System.out.println(handles);
		driver.switchTo().window(handles);
		
//		WebDriverWait wait = new WebDriverWait(driver,30);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='sTestLoginBtn']")));
		//thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		inputEmail.click();
		inputEmail.sendKeys(email);
		inputPassword.sendKeys(password);
		loginBtn.click();
		clickOnprofileBtn.click();
		String profileId = validateProfile.getText();
		assertEquals(email, profileId);
	}
}
