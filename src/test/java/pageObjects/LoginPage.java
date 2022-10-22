package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="Email") private WebElement emailTxt;
	@FindBy(id="Password") private WebElement passTxt;
	@FindBy(xpath = "//button[@type=\"submit\"]") private WebElement loginBtn;
	@FindBy(xpath = "//a[text()='Logout']") private WebElement logoutBtn;
	
	
	public void setUserName(String uname) {
		emailTxt.clear();
		emailTxt.sendKeys(uname);
	}
	
	public void setPassword(String pwd) {
		passTxt.clear();
		passTxt.sendKeys(pwd);
	}
	
	public void clicklogin() {
		loginBtn.click();
	}
	
	public void clicklogout() {
		logoutBtn.click();
	}
	
}
