package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String driver="oracle.jdbc.OracleDriver";
		String jdbc_url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="system";
		String pwd="password";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(jdbc_url,user,pwd);
		Statement st = con.createStatement();
		String sqlQuery="select * from employees where empSalary in (select min(empSalary) from employees)";
		ResultSet rs =st.executeQuery(sqlQuery);
		if(rs.next())
		{
		System.out.println("Highest sal employee information");
		System.out.println("----------------------------------------");
		System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3)+"\t"+rs.getString(4));
		}
		con.close();

	}

}
