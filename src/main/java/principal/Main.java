package principal;

import java.util.Scanner;

import config.PropertiesDataBaseConfigLoader;
import controllers.FuncionarioController;
import factories.ConnectionFactory;
import handlers.ErrorHandler;
import io.ConsoleReaderWriter;
import io.FuncionarioFormReader;
import repositories.FuncionarioRepositoryImpl;
import services.FuncionarioServiceImpl;

public class Main {

	public static void main(String[] args) {

		var dataBaseConfig = new PropertiesDataBaseConfigLoader().loadDatabaseConfig();
		var connectionFactory = new ConnectionFactory(dataBaseConfig);
		var funcionarioRepository = new FuncionarioRepositoryImpl(connectionFactory);
		var funcionarioService = new FuncionarioServiceImpl(funcionarioRepository);
		var consoleReaderWriter = new ConsoleReaderWriter(new Scanner(System.in));
		var errorHandler = new ErrorHandler(consoleReaderWriter);
		var funcionarioFormReader = new FuncionarioFormReader(consoleReaderWriter);
		var funcionarioController = new FuncionarioController(funcionarioService, errorHandler, consoleReaderWriter,
				funcionarioFormReader);

		funcionarioController.cadastrarFuncionario();
		consoleReaderWriter.fecharScanner();
	}
}