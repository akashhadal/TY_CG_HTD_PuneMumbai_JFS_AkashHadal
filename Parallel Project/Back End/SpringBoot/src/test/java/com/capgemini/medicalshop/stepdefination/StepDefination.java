package com.capgemini.medicalshop.stepdefination;

import org.junit.Assert;
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
		driver.manage().window().maximize();
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
		WebElement listBox= driver.findElement(By.name("role"));
		Select select=new Select(listBox);
		select.selectByVisibleText("User");
	}

	@When("^the user clicks on the register Button$")
	public void the_user_clicks_on_the_register_Button() throws Throwable {
		driver.findElement(By.xpath("//button[text()='Register']")).click();
		Thread.sleep(10000);
	}
	
	@When("^the user clicks on product list on navbar$")
	public void the_user_clicks_on_product_list_on_navbar() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Product List']")).click();
		Thread.sleep(1000);
	}

	@When("^the user clicks on add button$")
	public void the_user_clicks_on_add_button() throws Throwable {
		driver.findElement(By.xpath("//button[text()=' Add ']")).click();
		Thread.sleep(1000);
	}

	@When("^the user clicks on cart button on navbar$")
	public void the_user_clicks_on_cart_button_on_navbar() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Cart']")).click();	 
		Thread.sleep(1000);
	}

	@When("^the user clicks on payment button$")
	public void the_user_clicks_on_payment_button() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Payment']")).click();
	}

	@Then("^the payment page must be loaded$")
	public void the_payment_page_must_be_loaded() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String expected="Medicalshop";
		String actual= driver.getTitle();
		Assert.assertEquals(actual, expected);
	}

	@When("^the user enters the name in the card Holder's Name textbox$")
	public void the_user_enters_the_name_in_the_card_Holder_s_Name_textbox() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("userName")).sendKeys("Akash Ramesh Hadal");
	}

	@When("^the user enters the card number in card nubmer textbox$")
	public void the_user_enters_the_card_number_in_card_nubmer_textbox() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("userCard")).sendKeys("5421658474512365");
	}

	@When("^the user selects the expiry date in the month dropdown of card expiry date$")
	public void the_user_selects_the_expiry_date_in_the_month_dropdown_of_card_expiry_date() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebElement listBox= driver.findElement(By.name("userCardExpiry"));
		Select select=new Select(listBox);
		select.selectByVisibleText("February");
	}

	@When("^the user enters the year in the year textbox of card expiry date$")
	public void the_user_enters_the_year_in_the_year_textbox_of_card_expiry_date() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("year")).sendKeys("2024");
	}

	@When("^the user enters the cvv in the cvv textbox$")
	public void the_user_enters_the_cvv_in_the_cvv_textbox() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("cvv")).sendKeys("123");
	}

	@When("^the user enters the address in the address textbox$")
	public void the_user_enters_the_address_in_the_address_textbox() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("address")).sendKeys("Boisar");
		Thread.sleep(2000);
	}

	@When("^the user clicks on the submit button$")
	public void the_user_clicks_on_the_submit_button() throws Throwable {
		driver.findElement(By.xpath("//button[text()='Submit']")).click();	
		Thread.sleep(2000);
	}

	@Then("^the order history page must be loaded$")
	public void the_order_history_page_must_be_loaded() throws Throwable {
		driver.close();
	}
	
}
