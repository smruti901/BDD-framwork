package stepDefinations;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageObjects.AddcustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class BaseClass {
	public WebDriver driver;
	public LoginPage loginPage;
	public AddcustomerPage addcustomerPage;
	public SearchCustomerPage searchCustomerPage;
	
	//Created for generating random string for Unique email
	public static String randomstring() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return(generatedString1);
	}
}
