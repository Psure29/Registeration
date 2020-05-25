 package net.javaguides.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import net.javaguides.registration.model.Employee;

public class EmployeeDao {
	
	public int registerEmployee(Employee employee) throws ClassNotFoundException{
		
		String INSERT_USER_SQL ="INSERT INTO employee" + 
		"(id, firstname, lastname, username, password, address, contact) VALUES" +
				"(?,?,?,?,?,?,?);";
		
		int result = 0;
		
		Class.forName("com.mysql.jdbc.Driver");
		try(Connection con = DriverManager.getConnection
				("jdbc:mysql://localhost/school","root","Podpod123@");
				PreparedStatement preparedStatement = con.prepareStatement(INSERT_USER_SQL)){
				preparedStatement.setInt(1, 1); 
				preparedStatement.setString(2, employee.getFirstname());
				preparedStatement.setString(3, employee.getLastname());
				preparedStatement.setString(4, employee.getUsername());
				preparedStatement.setString(5, employee.getPassword());
				preparedStatement.setString(6, employee.getAddress());
				preparedStatement.setString(7, employee.getContact());
				
				System.out.println(preparedStatement);
				
				result = preparedStatement.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;	
	}

}
