package com.capgemini.medicalshopcollection.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.medicalshopcollection.beans.UserBean;
import com.capgemini.medicalshopcollection.exception.ExceptionsMethods;
import com.capgemini.medicalshopcollection.exception.OMSException;
import com.capgemini.medicalshopcollection.service.MedicalServices;
import com.capgemini.medicalshopcollection.service.MedicalservicesImpl;
import com.capgemini.medicalshopcollection.service.ProductServices;
import com.capgemini.medicalshopcollection.service.ProductServicesImpl;


public class AdminTest {
	Scanner scanner = new Scanner(System.in);
	static MedicalServices medicalServices = new MedicalservicesImpl();
	static ProductServices productServices = new ProductServicesImpl();
	static ExceptionsMethods exceptionsMethods = new ExceptionsMethods();
	static boolean validation = false;
	static String character;

	public void adminLogin() {	
		System.out.println(
				"\nEnter 'a' to see user Operations\nEnter 'b' to perform product operations\nEnter 'c' to See Discussion Board\nEnter 'd' to Logout");
		char adminChoice = scanner.next().charAt(0); 
		if (adminChoice == 'a') {
			//Operations perform on users
			while (true) {
				System.out.println("Enter 1 to Show All Users\nEnter 2 to Remove User\nEnter 3 to go back to menu");
				String selectedOperation1 = scanner.next();
				int selectedOperation = 0;
				try {
					selectedOperation = ExceptionsMethods.numberValidation(selectedOperation1);
				} catch (OMSException e1) {
					e1.getMessage();
				}

				switch (selectedOperation) {
				case 1:// Show all users
					String userType = "User";
					List<UserBean> userBean = medicalServices.getAllUsers(userType);
					for (UserBean userList : userBean) {
						System.out.println("--------------------------------------------------");
						System.out.println("User Id = "+userList.getUserId());
						System.out.println("User Name = "+userList.getUserName());
						System.out.println("Email = "+userList.getEmail());
						System.out.println("Mobile No. = "+userList.getMobileNumber());
						System.out.println("--------------------------------------------------");
					}
					break;

				case 2:// Remove user
					System.out.println("Enter User Id you want to remove: ");
					int userId = scanner.nextInt();
					boolean state = medicalServices.removeUser(userId);
					if (state == true) {
						System.out.println("Successfully Deleted");
					} else {
						System.out.println("Unable to delete");
					}
					break;

				case 3:// Go back to menu
					adminLogin();
					break;

				default:
					break;
				}// End of switch()
			} // End of while()

		} else if (adminChoice == 'b') {
			//Operations perform on product
			while (true) {
				System.out.println(
						"\nPress 1 to Add Product\nPress 2 to Update Product\nPress 3 to Remove Product\nPress 4 to show Products\nPress 5 to Go Back");
				int selectedOperation = scanner.nextInt();
				switch (selectedOperation) {
				case 1:// To Add new Product by Admin
					new ProductsTest().addProducts();
					break;
				case 2://Update Product
					new ProductsTest().updateProducts();
					break;
				case 3://Remove Products
					new ProductsTest().deleteProduct();
					break;
				case 4://Show Products
					new ProductsTest().showProducts();
					break;
				case 5://go back to menu
					adminLogin();
					break;
				default:
					System.out.println("Enter Valid Choice");
					break;
				}//End of switch
				
			} // End of while()
		} else if(adminChoice == 'c') {
			//To show discussion board
			
		}

	}// End of afterAdminLogin()

}// End of Class
