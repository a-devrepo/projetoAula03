package factories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import config.DatabaseConfig;
import exceptions.RepositoryException;

public class ConnectionFactory {

	private final DatabaseConfig databaseConfig;

	public ConnectionFactory(DatabaseConfig databaseConfig) {
		this.databaseConfig = databaseConfig;
	}

	public Connection getConnection() {
		try {

			return DriverManager.getConnection(databaseConfig.getUrl(), 
					databaseConfig.getUser(),
					databaseConfig.getPassword());
			
		} catch (SQLException sqlException) {
			throw new RepositoryException("Erro ao estabelecer conexão com o banco de dados: ", sqlException);
		}
	}
}