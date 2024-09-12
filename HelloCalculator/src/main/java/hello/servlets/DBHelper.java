package hello.servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
	
	public static Connection connectBookShop(String url,String user,String key) throws SQLException {
		return DriverManager.getConnection(url, user, key);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
