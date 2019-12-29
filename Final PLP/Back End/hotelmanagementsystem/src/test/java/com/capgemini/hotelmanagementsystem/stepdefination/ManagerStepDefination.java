package com.capgemini.hotelmanagementsystem.stepdefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ManagerStepDefination {

	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}

	WebDriver driver;

	@Given("^the manager has loaded the application in the browser$")
	public void the_manager_has_loaded_the_application_in_the_browser() throws Throwable {
		driver = new ChromeDriver();
		driver.get("http://localhost:4200");
		driver.manage().window().maximize();
	}

	@When("^the manager clicks on sign in link$")
	public void the_manager_clicks_on_sign_in_link() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Sign in']")).click();
		
		Thread.sleep(2000);
	}

	@When("^the manager enters the valid email$")
	public void the_manager_enters_the_valid_email() throws Throwable {
		driver.findElement(By.name("userEmail")).sendKeys("manager@gmail.com");
		
		Thread.sleep(2000);
	}

	@When("^the manager enters the valid password$")
	public void the_manager_enters_the_valid_password() throws Throwable {
		driver.findElement(By.name("password")).sendKeys("Manager@123");
		
		Thread.sleep(2000);
	}

	@When("^the manager clicks on the sign in button$")
	public void the_manager_clicks_on_the_sign_in_button() throws Throwable {
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		
		Thread.sleep(2000);
	}

	@Then("^the manager page must be displayed$")
	public void the_manager_page_must_be_displayed() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Manager']")).click();
		
		Thread.sleep(2000);
	}

	@When("^the manager clicks on employee counter$")
	public void the_manager_clicks_on_employee_counter() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Employee Counter']")).click();
		
		Thread.sleep(2000);
	}

	@When("^the manager clicks on register manager$")
	public void the_manager_clicks_on_register_manager() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Click here to Register Employee']")).click();
		
		Thread.sleep(2000);
	}

	@When("^the manager enters employee name$")
	public void the_manager_enters_employee_name() throws Throwable {
		driver.findElement(By.name("userName")).sendKeys("Zayn Malik");
		
		Thread.sleep(2000);
	}

	@When("^the manager enters email$")
	public void the_manager_enters_email() throws Throwable {
		driver.findElement(By.name("userEmail")).sendKeys("zayn@gmail.com");
		
		Thread.sleep(2000);
	}

	@When("^the manager enters password$")
	public void the_manager_enters_password() throws Throwable {
		driver.findElement(By.name("password")).sendKeys("Zayn@123");
		
		Thread.sleep(2000);
	}
	
	@When("^the manager selects nationality in nationality dropdown$")
	public void the_manager_selects_nationality_in_nationality_dropdown() throws Throwable {
		WebElement listBox= driver.findElement(By.name("nationality"));
		Select select=new Select(listBox);
		select.selectByVisibleText("Indian");
		
	}

	@When("^the manager enters address$")
	public void the_manager_enters_address() throws Throwable {
		driver.findElement(By.name("address")).sendKeys("Mumbai");
		
	}

	@When("^the manager enters phone number$")
	public void the_manager_enters_phone_number() throws Throwable {
		driver.findElement(By.name("phoneNumber")).sendKeys("9541202356");
		
	}

	@When("^the manager clicks on register employee button$")
	public void the_manager_clicks_on_register_employee_button() throws Throwable {
		driver.findElement(By.xpath("//button[text()='Register']")).click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(000);
	}

	@When("^the manager clicks on manager link$")
	public void the_manager_clicks_on_manager_link() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Manager']")).click();
		Thread.sleep(2000);
	}

	@When("^the manager clicks on customers counter$")
	public void the_manager_clicks_on_customers_counter() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Customers Counter']")).click();
		driver.close();
	}

}
