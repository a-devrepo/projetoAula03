package factories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import exceptions.RepositoryException;

public class ConnectionFactory {

	private static final String URL = "jdbc:mysql://localhost:3306/funcionarios_db";
	private static final String USER = "appuser";
	private static final String PASSWORD = "apppassword";

	public ConnectionFactory() {
	}

	public Connection getConnection() {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException sqlException) {
			throw new RepositoryException("Erro ao estabelecer conexão com o banco de dados: ", sqlException);
		}
	}
}