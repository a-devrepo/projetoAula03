package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

import exceptions.ConnectionException;
import exceptions.RepositoryException;
import factories.ConnectionFactory;

public class PropertiesDataBaseConfigLoader implements DatabaseConfigLoader {

	private static final String PROPERTIES_FILE = "database.properties";
	private static final String DB_URL_KEY = "db.url";
	private static final String DB_USERNAME_KEY = "db.username";
	private static final String DB_PASSWORD_KEY = "db.password";
	
	public DatabaseConfig loadDatabaseConfig() {
		
		try (InputStream connectionPropertiesInput = ConnectionFactory.class.getClassLoader()
				.getResourceAsStream(PROPERTIES_FILE)) {

			if (Objects.isNull(connectionPropertiesInput)) {
				throw new RepositoryException("Arquivo de propriedades não encontrado: " + PROPERTIES_FILE);
			}

			Properties connectionProperties = new Properties();

			connectionProperties.load(connectionPropertiesInput);
			var url = connectionProperties.getProperty(DB_URL_KEY);
			var user = connectionProperties.getProperty(DB_USERNAME_KEY);
			var password = connectionProperties.getProperty(DB_PASSWORD_KEY);

			if (url == null || user == null || password == null) {
				throw new ConnectionException("Parâmetros de conexão ausentes no arquivo de propriedades.");
			}
			
			return new DatabaseConfig(url, user, password);
			
		} catch (IOException ioException) {
			throw new ConnectionException("Erro ao carregar arquivo de propriedades: " + PROPERTIES_FILE, ioException);
		}
	}
}
