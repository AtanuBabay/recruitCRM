package pageObject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homePage {
	public WebDriver driver;
	
	@FindBy(xpath="//a[text()[contains(.,'Sign in')]]")
	public WebElement Sign_in;
	
	@FindBy(xpath="//img[@alt='logo']")
	public WebElement logo;
	
	@FindBy(xpath="//input[@type='email']")
	public WebElement inputEmail;
	
	@FindBy(xpath="//input[@type='password']")
	public WebElement inputPassword;
	
	@FindBy(xpath="//button[@id='sTestLoginBtn']")
	public WebElement loginBtn;
	
	@FindBy(xpath="//img[@class='user-dropdown-link']")
	public WebElement clickOnprofileBtn;
	
	@FindBy(xpath="(//div[@class='content'])[1]/small")
	public WebElement validateProfile;
			
	
	public void validateLanding() {
		Boolean display= logo.isDisplayed();
		assertTrue(display);
	}
	public void Login(String email,String password) {
		//driver.get("https://recruitcrm.io/");
		Sign_in.click();
		inputEmail.sendKeys(email);
		inputPassword.sendKeys(password);
		loginBtn.click();
		clickOnprofileBtn.click();
		String profileId = validateProfile.getText();
		assertEquals(email, profileId);
	}
}
