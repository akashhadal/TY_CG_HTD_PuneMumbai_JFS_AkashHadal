package com.capgemini.medicalshop.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import com.capgemini.medicalshop.bean.CartBean;
import com.capgemini.medicalshop.bean.OrderBean;

public class CartImpl implements CartDao {

	FileReader reader = null;
	Properties prop = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	Scanner sc = new Scanner(System.in);

	public CartImpl() {
		try {
			// Loading the Drivers
			Class.forName("com.mysql.jdbc.Driver");
			reader = new FileReader("db.properties");
			prop = new Properties();
			prop.load(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}// end of constructor

	@Override
	public CartBean addProduct(int uId) {
		String getuName = null;
		String pName = null;
		double getPrice = 0;
		int getpId = 0;
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt1 = conn.prepareStatement(prop.getProperty("queryc1"));
				PreparedStatement pstmt2 = conn.prepareStatement(prop.getProperty("queryc2"));
				PreparedStatement pstmt3 = conn.prepareStatement(prop.getProperty("queryc3"))) {


			pstmt1.setInt(1, uId);
			ResultSet rs = pstmt1.executeQuery();
			if (rs.next()) {
				System.out.println("iD" + uId);
				getuName = rs.getString(1);
				System.out.println("enter product name ");
				pName = sc.nextLine();
				pstmt2.setString(1, pName);
				ResultSet rs2 = pstmt2.executeQuery();
				if (rs2.next()) {
					System.out.println("pID" + rs2.getInt(1));
					System.out.println("price" + rs2.getDouble(2));
					getpId = rs2.getInt(1);
					getPrice = rs2.getDouble(2);
				}
				pstmt3.setInt(1, uId);
				pstmt3.setString(2, getuName);
				pstmt3.setString(3, pName);
				pstmt3.setDouble(4, getPrice);
				pstmt3.setInt(5, getpId);
				System.out.println("..................................");
				int count = pstmt3.executeUpdate();
				if (count > 0) {
					System.out.println("Product Added to Cart........");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}// end of addproduct()

	@Override
	public CartBean deleteProduct(String pName) {

		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("queryc4"))) {
			pstmt.setString(1, pName);

			int count = pstmt.executeUpdate();
			if (count > 0) {
				System.out.println("Product deleted from Cart........");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}// end of deleteproduct()

	@Override
	public CartBean payment(int uId,String address) {

		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("queryc5"));
				PreparedStatement pstmt1=conn.prepareStatement(prop.getProperty("queryc6"));
				PreparedStatement pstmt2=conn.prepareStatement(prop.getProperty("queryc8"))) {
			
			pstmt.setInt(1, uId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("total price =" + rs.getDouble(1));
				System.out.println("Proceed to pay"); 
				System.out.println("Press 'y' to proceed\nPress 'n' to exit");
				String button = sc.nextLine();
				
				if (button.equalsIgnoreCase("y")) {
					
						pstmt2.setInt(1, uId);
						ResultSet rs2=pstmt2.executeQuery();
						
						while (rs2.next()) {
							OrderBean orderBean=new OrderBean();
							orderBean.setOrderId(rs2.getInt(1));
							orderBean.setUserId(rs2.getInt(2));
							orderBean.setProductId(rs2.getInt(3));
							orderBean.setPrice(rs2.getDouble(4));
							orderBean.setUserName(rs2.getString(5));
							orderBean.setProductName(rs2.getString(6));
							orderBean.setAddress(address);
							if (addOrder(orderBean)) {
								System.out.println("Added");
							} else {
								System.out.println("Not added");
							}
						}
					
					
					//------------------
					pstmt1.setInt(1, uId);
					int rs1=pstmt1.executeUpdate();	
				 System.out.println("Transaction Completed");
				}else if (button.equalsIgnoreCase("n")) {
					System.out.println("Transaction Failed");
					System.exit(0);
				}			
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Payment Failed...");
		}

		return null;
	}// end of payment

	@Override
	public boolean addOrder(OrderBean orderBean) {
		int count=0;
		boolean isAdded=false;
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("queryc7"))) {
			
			
			
			try {
				pstmt.setInt(1, orderBean.getOrderId());
				pstmt.setInt(2, orderBean.getUserId());
				pstmt.setInt(3, orderBean.getProductId());
				pstmt.setString(4, orderBean.getUserName());
				pstmt.setString(5, orderBean.getProductName());
				pstmt.setDouble(6, orderBean.getPrice());
				pstmt.setString(7, orderBean.getAddress());
				count = pstmt.executeUpdate();
				isAdded=true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return isAdded;
	}

	@Override
	public List<OrderBean> list(int userId) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("queryc9"))) {

			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("..................................");
				System.out.println("Order ID =" + rs.getInt(1));
				System.out.println("product name = " + rs.getString(5));
				System.out.println("product price = " + rs.getDouble(6));
				System.out.println("Address = " + rs.getString(7));
				System.out.println("..................................");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CartBean> showCart(int userId) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("queryc10"))) {

			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("..................................");
				System.out.println("product ID =" + rs.getInt(3));
				System.out.println("product name = " + rs.getString(6));
				System.out.println("product price = " + rs.getDouble(4));
				System.out.println("..................................");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}// end of class
