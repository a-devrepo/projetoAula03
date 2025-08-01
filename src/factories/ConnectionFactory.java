package factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	private static final String URL = "jdbc:mysql://localhost:3306/funcionarios_db";
	private static final String USER = "appuser";
	private static final String PASSWORD = "apppassword";

	private ConnectionFactory() {
	}

	public Connection getConnection() throws Exception {
		var host = "jdbc:mysql://localhost:3306/funcionarios_db";
		var user = "appuser";
		var password = "apppassword";

		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		return DriverManager.getConnection(host, user, password);
	}
}
