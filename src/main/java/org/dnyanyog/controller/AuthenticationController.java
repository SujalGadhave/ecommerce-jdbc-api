package org.dnyanyog.controller;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.dnyanyog.jdbc.Dbutils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController{
	
	@GetMapping("/getData")
	public String getData() throws SQLException {
		
		String selectQuery = "SELECT * FROM ecomlogin.user";
		
		ResultSet resultset = Dbutils.executeSelectQuery(selectQuery);
		
		String name = "";
		while(resultset.next()) {
			System.out.println("User ID: " + resultset.getString(1));
			name = resultset.getString(2);
			System.out.println("Email ID: "+ resultset.getString(3));
			System.out.println("Password: " +resultset.getString(4));
		}
		
		return name;
	}
}
