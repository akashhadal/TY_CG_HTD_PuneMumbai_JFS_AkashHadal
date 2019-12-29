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

public class AdminStepDefination {

	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	
	WebDriver driver;
	
	@Given("^the admin has loaded the application in the browser$")
	public void the_admin_has_loaded_the_application_in_the_browser() throws Throwable {
		driver = new ChromeDriver();
		driver.get("http://localhost:4200");
		driver.manage().window().maximize();
	}

	@When("^the admin clicks on sign in link$")
	public void the_admin_clicks_on_sign_in_link() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Sign in']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
	}

	@When("^the admin enters the valid email$")
	public void the_admin_enters_the_valid_email() throws Throwable {
		driver.findElement(By.name("userEmail")).sendKeys("admin@gmail.com");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^the admin enters the valid password$")
	public void the_admin_enters_the_valid_password() throws Throwable {
		driver.findElement(By.name("password")).sendKeys("Admin@123");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^the admin clicks on the sign in button$")
	public void the_admin_clicks_on_the_sign_in_button() throws Throwable {
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    Thread.sleep(2000);
	}

	@Then("^the admin page must be displayed$")
	public void the_admin_page_must_be_displayed() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Admin']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
	}
	
	@When("^the admin clicks on manager counter$")
	public void the_admin_clicks_on_manager_counter() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Manager Counter']")).click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    Thread.sleep(2000);
	}
	
	@When("^the admin clicks on select hotel$")
	public void the_admin_clicks_on_select_hotel() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Select Hotel']")).click();
		Thread.sleep(2000);
		}

	@When("^the admin click on add manager$")
	public void the_admin_click_on_add_manager() throws Throwable {
		driver.findElement(By.xpath("//button[text()=' Add Manager ']")).click();
		Thread.sleep(3000);
	}

	@When("^the admin enters manager name$")
	public void the_admin_enters_manager_name() throws Throwable {
		driver.findElement(By.name("userName")).sendKeys("Jony Depp");
	    Thread.sleep(2000);
	}

	@When("^the admin enters email$")
	public void the_admin_enters_email() throws Throwable {
		driver.findElement(By.name("userEmail")).sendKeys("johny@gmail.com");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^the admin enters password$")
	public void the_admin_enters_password() throws Throwable {
		driver.findElement(By.name("password")).sendKeys("Johny@123");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@When("^the admin selects nationality in nationality dropdown$")
	public void the_admin_selects_nationality_in_nationality_dropdown() throws Throwable {
		WebElement listBox= driver.findElement(By.name("nationality"));
		Select select=new Select(listBox);
		select.selectByVisibleText("Indian");
		
	}

	@When("^the admin enters address$")
	public void the_admin_enters_address() throws Throwable {
		driver.findElement(By.name("address")).sendKeys("Mumbai");
		
	}

	@When("^the admin enters phone number$")
	public void the_admin_enters_phone_number() throws Throwable {
		driver.findElement(By.name("phoneNumber")).sendKeys("9541202356");
		
	}

	@When("^the admin clicks on register manager button$")
	public void the_admin_clicks_on_register_manager_button() throws Throwable {
		driver.findElement(By.xpath("//button[text()='Register']")).click();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    Thread.sleep(2000);
	}
	
	@When("^the admin clicks on ok button$")
	public void the_admin_clicks_on_ok_button() throws Throwable {
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(000);
	}
	
	@When("^the admin clicks on Add Hotel$")
	public void the_admin_clicks_on_Add_Hotel() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Add Hotel']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
	}

	@When("^admin enters hotel name$")
	public void admin_enters_hotel_name() throws Throwable {
		driver.findElement(By.name("hotelName")).sendKeys("Bangtan");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^admin enters ac rooms$")
	public void admin_enters_ac_rooms() throws Throwable {
		driver.findElement(By.name("availableAcRoom")).sendKeys("40");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^admin enters non-ac room$")
	public void admin_enters_non_ac_room() throws Throwable {
		driver.findElement(By.name("availableNonAcRoom")).sendKeys("20");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^admin enters hotel location$")
	public void admin_enters_hotel_location() throws Throwable {
		driver.findElement(By.name("location")).sendKeys("Goa");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@When("^admin enters image url$")
	public void admin_enters_image_url() throws Throwable {
		driver.findElement(By.name("image")).sendKeys("https://cdn.pixabay.com/photo/2015/02/02/08/34/hotel-620641__340.jpg");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^admin clicks on add hotel$")
	public void admin_clicks_on_add_hotel() throws Throwable {
		driver.findElement(By.xpath("//button[text()='Add Hotel']")).click();
	    Thread.sleep(2000);
	    Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(2000);
	}

	@When("^the admin clicks on admin$")
	public void the_admin_clicks_on_admin() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Admin']")).click();
	    Thread.sleep(2000);
	}

	@When("^admin clicks on hotels counter$")
	public void admin_clicks_on_hotels_counter() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Hotels Counter']")).click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.close();
	}
}
