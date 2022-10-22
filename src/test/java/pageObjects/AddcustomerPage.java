package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import stepDefinations.BaseClass;

public class AddcustomerPage extends BaseClass{
	
	public AddcustomerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//div[@class=\"content-header\"]") private WebElement dashboard;
	@FindBy(xpath = "//a[@href=\"#\"]/i/following-sibling::p[contains(text(),'Customers')]") private WebElement Customers;
	@FindBy(xpath = "//li/a[@href=\"/Admin/Customer/List\"]") private WebElement customers;
	@FindBy(xpath = "//a[@class=\"btn btn-primary\"]") private WebElement addNewBtn;
	@FindBy(xpath = "//div[@class=\"content-header\"]") private WebElement addNewCustomerPage;
	@FindBy(id = "Email") private WebElement txtEmail;
	@FindBy(id = "Password") private WebElement txtPassword;
	@FindBy(id = "FirstName") private WebElement txtFirstname;
	@FindBy(id = "LastName") private WebElement txtLastname;
	@FindBy(id = "Gender_Male") private WebElement genderMale;
	@FindBy(xpath = "//span[@class=\"k-icon k-i-calendar\"]") private WebElement calender;
	@FindBy(xpath = "//a[@aria-live=\"assertive\"]") private WebElement currentMonth;
	@FindBy(xpath = "//a[@aria-label=\"Previous\"]") private WebElement previousBtn;
	@FindBy(id = "DateOfBirth") private WebElement DOB;
	@FindBy(id = "Company") private WebElement companyName;
	@FindBy(id = "IsTaxExempt") private WebElement taxExempt;
	@FindBy(xpath = "//div[@class=\"input-group-append\"]/div/div/div//input") private WebElement newsLetter;
	@FindBy(xpath = "//li[text()='Test store 2']") private WebElement newsName;
	@FindBy(id = "VendorId") private WebElement vendor;
	@FindBy(id = "AdminComment") private WebElement adminComment;
	@FindBy(xpath = "//div[@class=\"input-group-append input-group-required\"]/div/div/div") private WebElement customerRole;
	@FindBy(xpath = "//li[text()='Administrators']") private WebElement administrator;
	@FindBy(xpath = "//button[@name=\"save\"]" ) private WebElement saveBtn;
	
	String birthMonth="February 2021";
	
	//Business logic
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	public void viewDashboard() {
		boolean status = dashboard.isDisplayed();
		System.out.println(status);
	}
	
	public void clickOnCustomerMenu() {
		Customers.click();
	}
	
	public void clickOnCuctomersMenuItem() {
		customers.click();
	}
	
	public void clickOnAddNewBtn() {
		addNewBtn.click();
	}
	
	public void addcustomerPage() {
		boolean status = addNewCustomerPage.isDisplayed();
		System.out.println(status);
	}
	
	public void enterDetails(String email, String password,String dob,String company,String store, String vendorValue) throws InterruptedException {
		txtEmail.sendKeys(email);
		txtPassword.sendKeys(password);
		genderMale.click();
//		calender.click();
//		String currentMonthText = currentMonth.getText();
//		while(!currentMonthText.equals(birthMonth)) {
//			previousBtn.click();
//			currentMonthText = currentMonth.getText();
//			birthMonth="February 2021";
//			
//		}
		DOB.sendKeys(dob);
		companyName.sendKeys(company);
		taxExempt.click();
		newsLetter.sendKeys(store);
		
			
		Select vendorSelect = new Select(vendor);
		vendorSelect.selectByVisibleText(vendorValue);
		
		adminComment.sendKeys("Hi");
		
		
		
		
	}
	
	public void clickOnSaveBTn()  {
		
		saveBtn.click();
	}
	
	
	
}
