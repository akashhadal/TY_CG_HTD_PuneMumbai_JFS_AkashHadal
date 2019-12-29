package com.capgemini.hotelmanagementsystem.stepdefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserStepDefination {

	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	
	WebDriver driver;
	
	@Given("^the user has loaded the application in the browser$")
	public void the_user_has_loaded_the_application_in_the_browser() throws Throwable {
		driver = new ChromeDriver();
		driver.get("http://localhost:4200");
		driver.manage().window().maximize();
	}

	@When("^the user clicks on sign in link$")
	public void the_user_clicks_on_sign_in_link() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Sign in']")).click();
		
		Thread.sleep(2000);
	}

	@When("^the user enters the valid email$")
	public void the_user_enters_the_valid_email() throws Throwable {
		driver.findElement(By.name("userEmail")).sendKeys("user@gmail.com");
	    
	    Thread.sleep(2000);
	}

	@When("^the user enters the valid password$")
	public void the_user_enters_the_valid_password() throws Throwable {
		driver.findElement(By.name("password")).sendKeys("User@123");
	    
	    Thread.sleep(2000);
	}

	@When("^the user clicks on the sign in button$")
	public void the_user_clicks_on_the_sign_in_button() throws Throwable {
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
	    
	    Thread.sleep(2000);
	}
	
	@Then("^the booking page must be displayed$")
	public void the_booking_page_must_be_displayed() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Hotel Booking']")).click();
		
		Thread.sleep(2000);
	}
	
	@When("^the user selects location from location dropdown box$")
	public void the_user_selects_location_from_location_dropdown_box() throws Throwable {
		WebElement listBox= driver.findElement(By.name("location"));
		Select select=new Select(listBox);
		select.selectByVisibleText("Pune");	    
	}

	@When("^the user selects checkin date$")
	public void the_user_selects_checkin_date() throws Throwable {
		driver.findElement(By.name("checkInDate")).sendKeys("30-12-2019");
	}

	@When("^the user selects checkout date$")
	public void the_user_selects_checkout_date() throws Throwable {
		driver.findElement(By.name("checkOutDate")).sendKeys("31-12-2019");	    
	}

	@When("^the user clicks on search button$")
	public void the_user_clicks_on_search_button() throws Throwable {
		driver.findElement(By.xpath("//button[text()='Search']")).click();
		Thread.sleep(1000);
	}
	
	@When("^user clicks on book room in particular hotel$")
	public void user_clicks_on_book_room_in_particular_hotel() throws Throwable {
		driver.findElement(By.xpath("//button[text()='Book Room']")).click();
		Thread.sleep(1000);
	}

	@When("^user click on book now for selecting room type$")
	public void user_click_on_book_now_for_selecting_room_type() throws Throwable {
		driver.findElement(By.xpath("//button[text()=' Book Now ']")).click();
		Thread.sleep(1000);
	}

	@When("^user clicks on cash in payment mode$")
	public void user_clicks_on_cash_in_payment_mode() throws Throwable {
		driver.findElement(By.xpath("//button[text()=' Cash ']")).click();	
		Thread.sleep(2000);
	}

	@When("^user clicks on home button on booking done page$")
	public void user_clicks_on_home_button_on_booking_done_page() throws Throwable {
		driver.findElement(By.xpath("//button[text()=' home ']")).click();	   
	}
	
	@When("^the user clicks on view bookings$")
	public void the_user_clicks_on_view_bookings() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Booking History']")).click();
		Thread.sleep(2000);
	}

	@When("^the user clicks on profile$")
	public void the_user_clicks_on_profile() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Profile']")).click();
		
		driver.close();
	}

}
