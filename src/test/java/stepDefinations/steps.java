package stepDefinations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.AddcustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class steps extends BaseClass{
	
	
	@Given("User Launch Chrome Browser")
	public void user_launch_chrome_browser() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
	    loginPage= new LoginPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
	    driver.get(url);
	    driver.manage().window().maximize();
	}

	@When("User enters Email as {string} and Password {string}")
	public void user_enters_email_as_and_password(String email, String password) {
	   loginPage.setUserName(email);
	   loginPage.setPassword(password);
	}

	@When("Click on Login")
	public void click_on_login() throws InterruptedException {
	   loginPage.clicklogin();
	   Thread.sleep(3000);
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) throws InterruptedException {
		if(driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			Assert.assertTrue(false);
		}else {
			Assert.assertEquals(title, driver.getTitle());
		}
		Thread.sleep(3000);
	   
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() throws InterruptedException {
	    loginPage.clicklogout();
	    Thread.sleep(3000);
	}
	
	@When("Close browser")
	public void close_browser() {
	   driver.close();
	}

	// Customer feature step defination
	
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
	    addcustomerPage= new AddcustomerPage(driver);
	    Assert.assertEquals("Dashboard / nopCommerce administration", driver.getTitle());
	    
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_menu() {
	   addcustomerPage.clickOnCustomerMenu();
	}

	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() {
	    addcustomerPage.clickOnCuctomersMenuItem();
	}

	@When("click on Add new button")
	public void click_on_add_new_button() {
	   addcustomerPage.clickOnAddNewBtn();
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
	   Assert.assertEquals("Add a new customer / nopCommerce administration", driver.getTitle());
	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
	   String email=randomstring()+"@gmail.com";
	   addcustomerPage.enterDetails(email, "test123", "2/16/1992","No","Test Store", "Vendor 2");
	}

	@When("click on Save button")
	public void click_on_save_button()  {
	    addcustomerPage.clickOnSaveBTn();
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) {
	    Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
	    		.contains("The new customer has been added successfully"));
	}
	
	@When("Enter customer Email")
	public void enter_customer_email() {
		searchCustomerPage= new SearchCustomerPage(driver);
		searchCustomerPage.setEmail("IIFgr@gmail.com");
	  
	}

	@When("Click on search button")
	public void click_on_search_button() {
	   searchCustomerPage.searchBTN();
	}

	@Then("User should found Email in the Search table")
	public void user_should_found_email_in_the_search_table() {
	    
	}



}
