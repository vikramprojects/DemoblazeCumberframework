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

public class Dbsignup {
	WebDriver driver;
	@Before
	public void beforehook() {
		System.out.println("open browser");
		
	}
	@After
	public void afterhook() {
		System.out.println("close browser");
	}
	
	@Given("user must be on homepage by clicking url {string}")
	public void user_must_be_on_homepage_by_clicking_url(String string) {
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

	@When("Click on signup element")
	public void click_on_signup_element() {
		driver.findElement(By.id("signin2")).click();
	}

	@When("Enter (.*) and (.*)$")
	public void enter_username_and_password(String username, String password) throws InterruptedException {
		driver.findElement(By.id("sign-username")).sendKeys(username);
	    Thread.sleep(2000);
	    driver.findElement(By.id("sign-password")).sendKeys(password);
	    Thread.sleep(2000);
	}

	@When("Click on signup button, also handle alert")
	public void click_on_signup_button_also_handle_alert() throws InterruptedException {
		 driver.findElement(By.xpath("//button[@onclick='register()']")).click();
		   Thread.sleep(2000);
		   Alert al=driver.switchTo().alert();	//one command we are using
			
			  String message=al.getText(); String expect= "Sign up successful.";
			if(message!=expect)
			{ System.out.println("Signup Fail with message "+ message);
			  }
			else { System.out.println("Signup succesful with message"+message ); }
			 
		  
			Thread.sleep(2000);	//hard wait: no matter what it will wait for 5000 millisec
			al.accept();
			 Assert.assertEquals(expect, message);
	}

	@Then("user must be on the website page")
	public void user_must_be_on_the_website_page() throws InterruptedException {
		String verify = driver.getCurrentUrl();
	    Assert.assertEquals("https://demoblaze.com/", verify);
	    Thread.sleep(2000);
	    driver.quit();
	}

}
