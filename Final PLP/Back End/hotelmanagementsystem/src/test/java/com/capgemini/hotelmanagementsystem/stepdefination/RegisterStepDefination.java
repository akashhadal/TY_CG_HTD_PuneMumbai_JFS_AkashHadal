package com.capgemini.hotelmanagementsystem.stepdefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterStepDefination {

	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}

	WebDriver driver;

	@Given("^the online user has loaded the application in the browser$")
	public void the_online_user_has_loaded_the_application_in_the_browser() throws Throwable {
		driver = new ChromeDriver();
		driver.get("http://localhost:4200");
		driver.manage().window().maximize();
	}

	@When("^the user clicks on sign up link$")
	public void the_user_clicks_on_sign_up_link() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Sign up']")).click();

		Thread.sleep(2000);
	}

	@When("^the user enters the valid user name$")
	public void the_user_enters_the_valid_user_name() throws Throwable {
		driver.findElement(By.name("userName")).sendKeys("Taehyung Kim");
	}

	@When("^the user enters the valid user email$")
	public void the_user_enters_the_valid_user_email() throws Throwable {
		driver.findElement(By.name("userEmail")).sendKeys("taehyung@gmail.com");
	}

	@When("^the user enters the valid user password$")
	public void the_user_enters_the_valid_user_password() throws Throwable {
		driver.findElement(By.name("password")).sendKeys("Taetae@123");
	}

	@When("^the user selects the valid nationality from dropdown box$")
	public void the_user_selects_the_valid_nationality_from_dropdown_box() throws Throwable {
		WebElement listBox = driver.findElement(By.name("nationality"));
		Select select = new Select(listBox);
		select.selectByVisibleText("Indian");
	}

	@When("^the user enters the valid address$")
	public void the_user_enters_the_valid_address() throws Throwable {
		driver.findElement(By.name("address")).sendKeys("Seoul, South Korea");
	}

	@When("^the user enters the valid phone no$")
	public void the_user_enters_the_valid_phone_no() throws Throwable {
		driver.findElement(By.name("phoneNumber")).sendKeys("9876543210");
	}

	@When("^the user clicks on the sign up button$")
	public void the_user_clicks_on_the_sign_up_button() throws Throwable {
		driver.findElement(By.xpath("//button[text()='Register']")).click();
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(1000);
	}

	@Then("^the sign in page must be displayed$")
	public void the_sign_in_page_must_be_displayed() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Sign in']")).click();
		Thread.sleep(2000);
		driver.close();
	}

}
