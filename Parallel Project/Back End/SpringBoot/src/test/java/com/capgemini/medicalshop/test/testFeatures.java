package com.capgemini.medicalshop.test;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.medicalshop.beans.CartBean;
import com.capgemini.medicalshop.beans.LoginBean;
import com.capgemini.medicalshop.beans.ProductBean;
import com.capgemini.medicalshop.service.CartService;
import com.capgemini.medicalshop.service.MedicalShopService;
import com.capgemini.medicalshop.service.ProductService;

@SpringBootTest
public class testFeatures {

	public LoginBean loginBean;
	public ProductBean productBean;
	public CartBean cartBean;

	@Autowired
	private MedicalShopService medicalService;

	@Autowired
	private ProductService productService;

	@Autowired
	private CartService cartService;

	@BeforeEach
	public void createObject() {
		loginBean = new LoginBean();
		productBean = new ProductBean();
		cartBean = new CartBean();
	}

	@Test
	public void testValidLogin() {
		String email = "pooja@gmail.com";
		String password = "pooja@123";

		LoginBean loginBean = medicalService.login(email, password);
		String expected = "User";
		String actual = loginBean.getRole();

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testValidUserRegistration() {
		loginBean.setUserId(1999);
		loginBean.setUserName("aaaa");
		loginBean.setUserEmail("aaaa@gmail.com");
		loginBean.setUserPassword("aaaa@123");
		loginBean.setRole("User");

		boolean expected = true;
		boolean actual = medicalService.registerUser(loginBean);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testUserRegistrationWithInvalidPassword() {
		loginBean.setUserId(2000);
		loginBean.setUserName("avc");
		loginBean.setUserEmail("abc@gmail.com");
		loginBean.setUserPassword("abd");
		loginBean.setRole("User");

		boolean expected = false;
		boolean actual = medicalService.registerUser(loginBean);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testUserRegistrationWithInvalidEmail() {
		loginBean.setUserId(2000);
		loginBean.setUserName("avc");
		loginBean.setUserEmail("abc@gmail");
		loginBean.setUserPassword("abda@123");
		loginBean.setRole("User");

		boolean expected = false;
		boolean actual = medicalService.registerUser(loginBean);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testUpdateUserProfile() {
		loginBean.setUserId(1997);
		loginBean.setUserName("bbbb");
		loginBean.setUserEmail("bbbb@gmail.com");
		loginBean.setUserPassword("bbbb@123");
		loginBean.setRole("User");

		boolean expected = true;
		boolean actual = medicalService.updateUserProfile(loginBean);

		Assert.assertEquals(expected, actual);

	}

	@Test
	public void testRemoveUser() {
		boolean expected = true;
		boolean actual = medicalService.removeUser(101);

		Assert.assertEquals(expected, actual);
	}

	/********************** Product **********************/

	@Test
	public void testAddProduct() {
		productBean.setProductId(99);
		productBean.setProductName("Seribuxx");
		productBean.setCategory("Antibiotic");
		productBean.setPrice(24.12);

		boolean expected = true;
		boolean actual = productService.addProduct(productBean);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testUpdateProduct() {
		productBean.setProductId(1001);
		productBean.setProductName("Qwdsc");
		productBean.setCategory("Antibiotic");
		productBean.setPrice(24.24);

		boolean expected = true;
		boolean actual = productService.addProduct(productBean);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testDeleteProduct() {

		boolean expected = true;
		boolean actual = productService.deleteProduct(1001);

		Assert.assertEquals(expected, actual);
	}

	/***************************** Message *************************/

	@Test
	public void testAddProductToCart() {
		boolean expected = true;
		boolean actual = cartService.addProduct(3, "crosin");

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testPayment() {
		boolean expected = true;
		boolean actual = cartService.addProduct(3, "Boisar");

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testTotalBill() {
		double expected = 45.15;
		double actual = cartService.totalBill(3);

		Assert.assertEquals(expected, actual);
	}

	@Test
	void testDeleteProductFromCart() {
		boolean expected = true;
		boolean actual = cartService.deleteProduct(23, 22);

		Assert.assertEquals(expected, actual);
	}

}
