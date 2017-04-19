package org.geass.web;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnectionTest {

	//bad code 메인으로 만든거라 Junit테스트가 아님.
		public static void main(String[] args)throws Exception {
			
			// MySQL DRIVER 5.X com.mysql.jdbc.Driver
			
			// MySQL DRIVER 6.X com.mysql.cj.jdbc.Driver
			
			String className ="com.mysql.jdbc.Driver";
			String url="jdbc:mysql://192.168.0.17:3306/sample_db?useSSL=false";  //SSL connection 보안프로토콜 줘야함
			String user="bit92";
			String password = "bit92";
			
			Class.forName(className);
			Connection con = DriverManager.getConnection(url,user,password);
			
			System.out.println(con);
			
		}
	
	
	
}
