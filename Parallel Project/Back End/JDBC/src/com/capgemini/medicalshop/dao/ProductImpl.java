 package com.capgemini.medicalshop.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import com.capgemini.medicalshop.bean.ProductBean;
import com.capgemini.medicalshop.dao.ProductDao;

public class ProductImpl implements ProductDao {

	FileReader reader = null;
	Properties prop = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	Scanner sc = new Scanner(System.in);

	public ProductImpl() {
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
	public ProductBean addProduct(int pId, String name, String category, double price) {

		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("queryp1"))) {

			pstmt.setInt(1, pId);
			pstmt.setString(2, name);
			pstmt.setString(3, category);
			pstmt.setDouble(4, price);

			int count = pstmt.executeUpdate();
			if (count > 0) {
				System.out.println("product inserted........");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}// end of addProduct

	@Override
	public ProductBean updateProduct(int pId) {

		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"))) {
			System.out.println("enter 1 to update name");
			System.out.println("enter 2 to update price");
			System.out.println("enter 3 to update category");
			int updateButton = Integer.parseInt(sc.nextLine());
			if (updateButton == 1) {
				System.out.println("enter name");
				String name = sc.nextLine();
				String query = "update product set productName = ? where productId = ?";
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, name);
				pstmt.setInt(2, pId);
			} else if (updateButton == 2) {
				System.out.println("enter price");
				int price = Integer.parseInt(sc.nextLine());
				String query = "update product set price = ? where productId = ?";
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, price);
				pstmt.setInt(2, pId);
			} else if (updateButton == 3) {
				System.out.println("enter category");
				String category = sc.nextLine();
				String query = "update product set category = ? where productId = ?";
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, category);
				pstmt.setInt(2, pId);
			}
			int count = pstmt.executeUpdate();
			if (count > 0) {
				System.out.println("data updated........");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}// end of updateProduct

	@Override
	public ProductBean deleteProduct(int pId) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("queryp3"))) {

			pstmt.setInt(1, pId);

			int count = pstmt.executeUpdate();
			if (count > 0) {
				System.out.println("product deleted........");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}// end of delete Product

	@Override
	public ProductBean getAllProduct() {

		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(prop.getProperty("queryp4"))) {

			while (rs.next()) {
				System.out.println("..................................");
				System.out.println("product ID =" + rs.getInt(1));
				System.out.println("product name = " + rs.getString(2));
				System.out.println("product category = " + rs.getString(3));
				System.out.println("product price = " + rs.getDouble(4));
				System.out.println("..................................");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}// end of getAllProduct

}// end of class
