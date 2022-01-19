package DAO;

import java.sql.*;

public class SingletonConnection {
private static Connection connection;
private SingletonConnection() {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost/scolarite","root","");
		
	}
	catch(ClassNotFoundException e) {
		e.printStackTrace();
	}catch(SQLException e) {
		e.printStackTrace();
	}
}
public static Connection getInstance() {
	if(connection==null)
		new SingletonConnection();
	return connection;
}
}
