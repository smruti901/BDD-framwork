package stepDefinations;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;


public class FlipkartSteps {
	
	WebDriver driver;
	@Given("I launch chrome browser")
	public void i_launch_chrome_browser() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@When("I open orange hrm homepage")
	public void i_open_orange_hrm_homepage() {
	    driver.get("https://www.flipkart.com/");
	    driver.findElement(By.xpath("//button[text()='✕']")).click();
	}

	@Then("I verify that the logo present on page")
	public void i_verify_that_the_logo_present_on_page() {
	    boolean status = driver.findElement(By.xpath("//a[@href=\"/\"]")).isDisplayed();
	    System.out.println(status);
	    Assert.assertEquals(true, status);
	}

	@Then("close browser")
	public void close_browser() {
	    driver.quit();
	}
}
