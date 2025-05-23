package com.mysql.ReadANdWrite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
//		String name = "angad";
//		String gender = "male";
//		String city = "Raipur";

		// String city = "pune";
		// String name = "alok";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "root", "root");
		// PreparedStatement statement = con.prepareStatement("insert into student
		// values('"+name+"','"+gender+"','"+city+"')");
		// PreparedStatement statement = con.prepareStatement("insert into student
		// values(?,?,?)");
		// PreparedStatement ps = con.prepareStatement("update student set city=? where
		// name=?");
//        statement.setString(1, name);
//        statement.setString(2, gender);
//        statement.setString(3, city);

//		ps.setString(1, city);
//		ps.setString(2, name);

		PreparedStatement ps = con.prepareStatement("select * from student");
		// ps.setString(1, name);

//		int i = ps.executeUpdate();
//		if (i > 0) {
//			System.out.println("success");
//		} else {
//			System.out.println("fails");
//		}

		ResultSet set = ps.executeQuery();
		while (set.next()) {

			System.out.println("Name is : " + set.getString("name"));
			System.out.println("Gender is : " + set.getString("gender"));
			System.out.println("City is : " + set.getString("city"));
			System.out.println("*******************************");
		}

		ps.close();
	}
}
