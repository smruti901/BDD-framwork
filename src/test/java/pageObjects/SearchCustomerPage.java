package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import stepDefinations.BaseClass;
import utilities.WaitHelper;

public class SearchCustomerPage extends BaseClass{

	WaitHelper waitHelper;
	public SearchCustomerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		waitHelper= new WaitHelper(driver);
	}
	
	@FindBy(how = How.ID, using = "SearchEmail") private WebElement txtEmail;
	@FindBy(how = How.ID, using = "search-customers") private WebElement searchBtn;

	public void setEmail(String email) {
		waitHelper.WaitForElement(txtEmail);
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	
	public void searchBTN() {
		searchBtn.click();
	}


}
