package com.capgemini.medicalshop.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import com.capgemini.medicalshop.bean.AdminBean;
import com.capgemini.medicalshop.bean.UserBean;

public class medicalShopDAOImpli implements medicalShopDAO {

	FileReader reader = null;
	Properties prop = null;
	AdminBean adminBean = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	Connection conn = null;
	Scanner sc=new Scanner(System.in);

	public medicalShopDAOImpli() {
		try {
			// Loading the Drivers
			Class.forName("com.mysql.jdbc.Driver");
			reader = new FileReader("db.properties");
			prop = new Properties();
			prop.load(reader);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to Load Drivers");
		}
	}// End Of Constructor

	@Override
	public UserBean registerUser(int uId, String name, String email, String password) {
		
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("query2"))) {

			pstmt.setInt(1, uId);
			pstmt.setString(2, name);
			pstmt.setString(3, email);
			pstmt.setString(4, password);
			int count = pstmt.executeUpdate();
			if (count > 0) {
				System.out.println("data inserted........");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int loginUser(String name, String password) {
		int uID = 0;
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("query1"))) {

			pstmt.setString(1, name);

			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("login successfully");
				System.out.println("User Id =" + rs.getInt(1));
				System.out.println("User name="+rs.getString(2));
				uID = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("login error");
		}

		return uID;
	}

	@Override
	public UserBean getAllUser() {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(prop.getProperty("query3"))) {
			//String query = "select * from user";
			
			//stmt = conn.createStatement();
			
			//ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				System.out.println("..................................");
				System.out.println("User ID =" + rs.getInt(1));
				System.out.println("User name = " + rs.getString(2));
				System.out.println("User Email = " + rs.getString(3));
				System.out.println("User Password = " + rs.getString(4));
				System.out.println("..................................");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserBean updateUserProfile(int uId) {
		try {
			System.out.println("enter 1 to update User name");
			System.out.println("enter 2 to update email"); 
			System.out.println("enter 3 to update password");
			int updateButton = Integer.parseInt(sc.nextLine());
			if(updateButton == 1) {
				System.out.println("enter user name");
				String name=sc.nextLine();
			String query = "update user set name = ? where uId = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setInt(2, uId);
			}
			else
				if(updateButton == 2) {
					System.out.println("enter email");
					String email = sc.nextLine();
				String query = "update user set email = ? where uId = ?";
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, email);
				pstmt.setInt(2, uId);
				}
				else
					if(updateButton == 3) {
						System.out.println("enter password");
						String password=sc.nextLine();
					String query = "update user set password = ? where uId = ?";
					pstmt = conn.prepareStatement(query);
					pstmt.setString(1, password);
					pstmt.setInt(2, uId);
					}
			int count = pstmt.executeUpdate();
			if (count > 0) {
				System.out.println("data updated........");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public int loginAdmin(String email, String password) {
		int uID = 0;
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("querya1"))) {

			pstmt.setString(1, email);

			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("login successfully");
				System.out.println("User Id =" + rs.getInt(1));
				System.out.println("User name="+rs.getString(2));
				uID = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("login error");
		}

		return uID;
	}

	@Override
	public boolean removeUser(int userId) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("querya2"))) {
			pstmt.setInt(1, userId);
		
			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}// End of Class
