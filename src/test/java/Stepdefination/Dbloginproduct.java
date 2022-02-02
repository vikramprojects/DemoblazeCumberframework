package Stepdefination;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Dbloginproduct {
WebDriver driver;
	
	@Before
	public void beforehook() {
		System.out.println("open browser");
		
	}
	@After
	public void afterhook() {
		System.out.println("close browser");
	}
	
	@Given("user must be on homepage clicking url {string}")
	public void user_must_be_on_homepage_clicking_url(String string) {
		//System.setProperty("webdriver.gecko.driver","geckodriver.exe");
		  // driver=new FirefoxDriver();
		    System.setProperty("webdriver.Chrome.driver","Chromedriver.exe");
		    driver=new ChromeDriver();
		    driver.get(string);
		    driver.manage().window().maximize();
		    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		    driver.manage().deleteAllCookies();
	}

	@When("Click on login element")
	public void click_on_login_element() {
	   driver.findElement(By.id("login2")).click();
	}

	@When("user should login with the same (.*) and (.*) as signup account$")
	public void user_should_login_with_the_same_username_and_password_as_signup_account(String username, String password) throws InterruptedException {
	    driver.findElement(By.id("loginusername")).sendKeys(username);
	    Thread.sleep(2000);
	    driver.findElement(By.id("loginpassword")).sendKeys(password);
	    Thread.sleep(2000);
	    
	}

	@When("click on login button")
	public void click_on_login_button() {
	   driver.findElement(By.xpath("//button[@onclick='logIn()']")).click();
	}

	@When("user must be on his or her account")
	public void user_must_be_on_his_or_her_account() throws InterruptedException {
		String verify = driver.getCurrentUrl();
	    Assert.assertEquals("https://demoblaze.com/", verify);
	    Thread.sleep(2000);
	    System.out.println(verify);
	    
	}
	@When("Click on Laptops tab element")
	public void click_on_laptops_tab_element() throws InterruptedException {
	    driver.findElement(By.linkText("Laptops")).click();
	    Thread.sleep(2000);
	}

	@When("Click on any product")
	public void click_on_any_product() {
		driver.findElement(By.xpath("//img[@src='imgs/macbook_air.jpg']")).click();
	}

	@When("Click on Add to Cart and handle the alert")
	public void click_on_add_to_cart_and_handle_the_alert() throws InterruptedException {
		driver.findElement(By.xpath("//a[@class='btn btn-success btn-lg']")).click();
		Thread.sleep(2000);
		   Alert alert = driver.switchTo().alert();
		   alert.accept();
		   Thread.sleep(2000);

	}

	@Then("Navigate to on Cart page")
	public void navigate_to_on_cart_page() throws InterruptedException {
		driver.findElement(By.id("cartur")).click();
	    Thread.sleep(2000);

	}

	@Then("Verify if the produdct is added to cart")
	public void verify_if_the_produdct_is_added_to_cart() {
		boolean verify= driver.findElement(By.xpath("//tr[@class='success']")).isDisplayed();	
		  System.out.println(verify);
		  driver.quit();

	}

}
