package com.stepdefinition;

import java.time.Duration;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {
	
	static WebDriver driver;
	@Given("user is on the insurance login page")
	public void user_is_on_the_insurance_login_page() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		System.out.println("launch");
//		driver.get("https://www.helvetia.com/global/globalsolutions/en/home.html");
		driver.get("https://www.helvetia.com/ch/web/en/private-customers/contact/myhelvetia/customer-portal.html");
		System.out.println("login");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		WebElement close = driver.findElement(By.xpath("//button[@aria-label='Close']"));
		close.click();
		System.out.println("success");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement login = wait.until(
		    ExpectedConditions.elementToBeClickable(
		    		By.xpath("//div[@role='tablist'][1]")
		    )
		);

		login.click();
		System.out.println("login yes");
		String parentWindow = driver.getWindowHandle();
		WebElement ebank = driver.findElement(By.xpath("//a[text()='E-Banking'][1]"));
		ebank.click();
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait1.until(ExpectedConditions.numberOfWindowsToBe(2));

		for (String window : driver.getWindowHandles()) {
		    if (!window.equals(parentWindow)) {
		        driver.switchTo().window(window);
		        break;
		    }
		}

		System.out.println("Switched to E-Banking tab");
//		System.out.println("success");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//		WebElement lgn = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
//		lgn.click();
		
	}

	@When("user enters username {string}")
	public void user_enters_username(String string) {
		System.out.println("username");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		    WebElement username = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(
		            By.xpath("//input[@id='username']")
		        )
		    );

		    username.sendKeys(string);
		
//		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
//
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].value = arguments[1];", username, string);
		
//		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
//		username.sendKeys(string);
		
		
		
	}

	@When("user enters password {string}")
	public void user_enters_password(String string) {
		System.out.println("pass");
		WebElement pass = driver.findElement(By.xpath("//input[@name='password']"));
		pass.sendKeys(string);
	   
	}

	@When("user clicks the Login button")
	public void user_clicks_the_login_button() {
		WebElement click1 = driver.findElement(By.xpath("//button[contains(text(),'Anmelden')]"));
		click1.click();
		System.out.println("clicking success");
		
	}

	@Then("user should see the Dashboard")
	public void user_should_see_the_dashboard() {
		
	}
	
	@Then("login result should be displayed")
	public void login_result_should_be_displayed() {


}
}
