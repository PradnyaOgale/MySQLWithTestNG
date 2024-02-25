package com.MySQLWithTestNG.TestCases;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.Test;

import com.MySQLWithTestNG.base.BaseSetup;

public class Testcases extends BaseSetup {

	@Test
	public void databaseTestingWithTestNG() {

		try {
			String s = "select * from student_details";
			ResultSet rs = stmt.executeQuery(s);
			while (rs.next()) {
				int eid = rs.getInt("roll_no");
				String name = rs.getString("name");
				String adr = rs.getString("address");

				System.out.println(eid + " " + name + " " + adr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void verifyInsertCommand() throws SQLException {
		String s = "insert into student_details values(11,'Raju',78,'Mumbai')";
		stmt.execute(s);
	}
}
