package com.capgemini.springrest.medicalshop.stepdefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class StepDefination {

	static {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
	}
	WebDriver driver;
	
	@Given("^the user has loaded the application in the browser$")
	public void the_user_has_loaded_the_application_in_the_browser() throws Throwable {
		driver=new ChromeDriver();
		driver.get("http://localhost:4200/");
		//Thread.sleep(2000);
	}
	
	@When("^the user clicks on the login Button on navbar$")
	public void the_user_clicks_on_the_login_Button_on_navbar() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Login']")).click();
	}

	@When("^the user enters the useremail in the username textbox$")
	public void the_user_enters_the_useremail_in_the_username_textbox() throws Throwable {
		driver.findElement(By.name("userEmail")).sendKeys("pooja@gmail.com");
	}

	@When("^the user enters the  password in the password textbox$")
	public void the_user_enters_the_password_in_the_password_textbox() throws Throwable {
		driver.findElement(By.name("userPassword")).sendKeys("pooja@123");
	}

	@When("^the user clicks on the login Button$")
	public void the_user_clicks_on_the_login_Button() throws Throwable {
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(10000);

	}

	@Then("^the dashboard pages must be loaded$")
	public void the_dashboard_pages_must_be_loaded() throws Throwable {
//		String expected="actiTIME - Enter Time-Track";
//		String actual= driver.getTitle();
//		Assert.assertEquals(actual, expected);
		Thread.sleep(2000);
		driver.close();
	}
	
	@When("^the user clicks on register Button on Navbar$")
	public void the_user_clicks_on_register_Button_on_Navbar() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Register']")).click();	    
	}

	@When("^the user enters the userid in the username textbox$")
	public void the_user_enters_the_userid_in_the_username_textbox() throws Throwable {
		driver.findElement(By.name("userId")).sendKeys("101");	    
	}

	@When("^the user enters the username in the username textbox$")
	public void the_user_enters_the_username_in_the_username_textbox() throws Throwable {
		driver.findElement(By.name("userName")).sendKeys("Ashish");	    
	}

	@When("^the user enters the useremail in the useremail textbox$")
	public void the_user_enters_the_useremail_in_the_useremail_textbox() throws Throwable {
		driver.findElement(By.name("userEmail")).sendKeys("ashish@gmail.com");
	}

	@When("^the user selects the  role in the role dropdown$")
	public void the_user_selects_the_role_in_the_role_dropdown() throws Throwable {
		//driver.findElement(By.name("userEmail")).sendKeys("pooja@gmail.com");
		WebElement listBox= driver.findElement(By.name("role"));
		Select select=new Select(listBox);
		select.selectByVisibleText("User");
	}

	@When("^the user clicks on the register Button$")
	public void the_user_clicks_on_the_register_Button() throws Throwable {
		driver.findElement(By.xpath("//button[text()='Register']")).click();
		Thread.sleep(10000);
	}
	
}
