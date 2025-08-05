package factories;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;

import exceptions.RepositoryException;

public class ConnectionFactory {

	private static final String PROPERTIES_FILE = "database.properties";
	private static final String URL;
	private static final String USER;
	private static final String PASSWORD;
	private static final String DB_URL_KEY = "db.url";
	private static final String DB_USERNAME_KEY = "db.username";
	private static final String DB_PASSWORD_KEY = "db.password";

	static {

		try (InputStream connectionPropertiesInput = ConnectionFactory.class.getClassLoader()
				.getResourceAsStream(PROPERTIES_FILE)) {

			if (Objects.isNull(connectionPropertiesInput)) {
				throw new RepositoryException("Arquivo de propriedades não encontrado: " + PROPERTIES_FILE);
			}

			Properties connectionProperties = new Properties();

			connectionProperties.load(connectionPropertiesInput);
			URL = connectionProperties.getProperty(DB_URL_KEY);
			USER = connectionProperties.getProperty(DB_USERNAME_KEY);
			PASSWORD = connectionProperties.getProperty(DB_PASSWORD_KEY);

			if (URL == null || USER == null || PASSWORD == null) {
				throw new RepositoryException("Parâmetros de conexão ausentes no arquivo de propriedades.");
			}
		} catch (IOException ioException) {
			throw new RepositoryException("Erro ao carregar arquivo de propriedades: " + PROPERTIES_FILE, ioException);
		}
	}

	public Connection getConnection() {
		try {

			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException sqlException) {
			throw new RepositoryException("Erro ao estabelecer conexão com o banco de dados: ", sqlException);
		}
	}
}