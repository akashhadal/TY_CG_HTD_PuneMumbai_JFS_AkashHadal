package com.capgemini.medicalshop.stepdefination;

import org.apache.commons.math3.analysis.function.Divide;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class AdminStepDefination {

	static {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
	}
	WebDriver driver;
	
	@Given("^the admin has loaded the application in the browser$")
	public void the_admin_has_loaded_the_application_in_the_browser() throws Throwable {
		driver=new ChromeDriver();
		driver.get("http://localhost:4200/");
		driver.manage().window().maximize();	    
	}

	@When("^the admin clicks on the login Button on navbar$")
	public void the_admin_clicks_on_the_login_Button_on_navbar() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Login']")).click();	    
	}

	@When("^the admin enters the useremail in the username textbox$")
	public void the_admin_enters_the_useremail_in_the_username_textbox() throws Throwable {
		driver.findElement(By.name("userEmail")).sendKeys("akash@gmail.com");	    
	}

	@When("^the admin enters the  password in the password textbox$")
	public void the_admin_enters_the_password_in_the_password_textbox() throws Throwable {
		driver.findElement(By.name("userPassword")).sendKeys("Akash@11");	    
	}

	@When("^the admin clicks on the login Button$")
	public void the_admin_clicks_on_the_login_Button() throws Throwable {
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(3000);	    
	}

	@When("^the admin clicks on add product on navbar$")
	public void the_admin_clicks_on_add_product_on_navbar() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Add Product']")).click();	    
	}

	@When("^the admin enters product id in product id textbox$")
	public void the_admin_enters_product_id_in_product_id_textbox() throws Throwable {
		driver.findElement(By.name("productId")).sendKeys("1");
	}

	@When("^the admin enters product name in product name textbox$")
	public void the_admin_enters_product_name_in_product_name_textbox() throws Throwable {
		driver.findElement(By.name("productName")).sendKeys("danxine");	    
	}

	@When("^the admin selects category in category dropdown of product category$")
	public void the_admin_selects_category_in_category_dropdown_of_product_category() throws Throwable {
		WebElement listBox= driver.findElement(By.name("category"));
		Select select=new Select(listBox);
		select.selectByVisibleText("Antibiotics");	    
	}

	@When("^the the admin enters product price in product price textbox$")
	public void the_the_admin_enters_product_price_in_product_price_textbox() throws Throwable {
		driver.findElement(By.name("price")).sendKeys("45.21");	    
	}

	@When("^the admin clicks on the submit button$")
	public void the_admin_clicks_on_the_submit_button() throws Throwable {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()=' Submit']")).click();
	}

	@When("^the admin clicks on product list on navbar$")
	public void the_admin_clicks_on_product_list_on_navbar() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Product List']")).click();
	}


	@When("^the admin clicks on delete button$")
	public void the_admin_clicks_on_delete_button() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()=' Delete ']")).click();
		Thread.sleep(1000);
	}

	@When("^the user clicks on user list button on navbar$")
	public void the_user_clicks_on_user_list_button_on_navbar() throws Throwable {
		driver.findElement(By.xpath("//a[text()='User List']")).click();
		Thread.sleep(1000);
	}

	@When("^the user clicks on logout button on navbar$")
	public void the_user_clicks_on_logout_button_on_navbar() throws Throwable {
		driver.findElement(By.xpath("//button[text()=' Logout ']")).click();
		Thread.sleep(2000);
		driver.close();
	}
}
