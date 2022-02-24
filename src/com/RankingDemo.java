package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class RankingDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
		String driver="oracle.jdbc.OracleDriver";
		String jdbc_url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="system";
		String pwd="password";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(jdbc_url,user,pwd);
		Statement st = con.createStatement();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number:");
		
		int n = sc.nextInt();
		String sqlQuery="select * from ( select empId,empName,empSalary,empAddress, rank() over (order by empSalary DESC) ranking from employees) where ranking="+n;
		 ResultSet rs =st.executeQuery(sqlQuery);
		 while(rs.next())
		 {
		 System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3)+"\t"+rs.getString(4));
		 }
		con.close();

	}

}
