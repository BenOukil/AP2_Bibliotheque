package Model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class ConnectionFactory {

	private static String BDD="ap3";
	private static String URL="jdbc:mysql://localhost/" + BDD + "?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC";
	private static String USER = "root";
	private static String PASSWORD = "root";
	
	public static Connection get() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(URL, USER, PASSWORD);
		
	}
	
	
}
