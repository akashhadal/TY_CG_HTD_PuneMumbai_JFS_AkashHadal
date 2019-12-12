package com.capgemini.medicalshop.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import com.capgemini.medicalshop.bean.MessageBean;
import com.capgemini.medicalshop.dao.MessageDao;

public class MessageImpl implements MessageDao {

	FileReader reader = null;
	Properties prop = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	Scanner sc = new Scanner(System.in);

	public MessageImpl() {
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
	public MessageBean sendMessage(String message, String type, int userId) {

		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("querym1"))) {
			System.out.println(message);
			System.out.println(type);
			System.out.println(userId);

			pstmt.setString(1, message);
			pstmt.setString(2, type);
			pstmt.setInt(3, userId);

			int count = pstmt.executeUpdate();
			if (count > 0) {
				System.out.println("data inserted........");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}// end of send message

	@Override
	public MessageBean getMessage() {
		String type = "Question";
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("querym2"))) {

			pstmt.setString(1, type);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("..................................");

				System.out.println("User Id = " + rs.getInt(1));
				System.out.println("Message    =" + rs.getString(2));

				System.out.println("..................................");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public MessageBean sendResponse(String message, String type, int uId) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("querym3"))) {
			System.out.println(message);
			System.out.println(type);
			System.out.println(uId);

			pstmt.setString(1, message);
			pstmt.setString(2, type);
			pstmt.setInt(3, uId);

			int count = pstmt.executeUpdate();
			if (count > 0) {
				System.out.println("dsta inserted........");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public MessageBean getResponse(int uId) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("querym4"))) {
			System.out.println("Reply to  " + uId);
			String type = "Answer";

			pstmt.setInt(1, uId);
			pstmt.setString(2, type);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("hiiiiii");
			/*
			 * if (rs.next()) { while (rs.next()) {
			 * System.out.println("..................................");
			 * System.out.println("message ID =" + rs.getInt(1));
			 * System.out.println("message = " + rs.getString(2));
			 * System.out.println(".................................."); } } else {
			 * System.out.println("no response"); }
			 */
			while (rs.next()) {
				System.out.println("..................................");

				System.out.println("message Id = " + rs.getInt(1));
				System.out.println("Message    =" + rs.getString(2));

				System.out.println("..................................");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

}// end of class
