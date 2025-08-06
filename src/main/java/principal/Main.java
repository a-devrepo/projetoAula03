package principal;

import java.util.Scanner;

import config.PropertiesDataBaseConfigLoader;
import controllers.FuncionarioController;
import factories.ConnectionFactory;
import handlers.ErrorHandler;
import io.ConsoleReaderWriter;
import io.FuncionarioFormReader;
import repositories.FuncionarioRepository;
import services.FuncionarioService;

public class Main {

	public static void main(String[] args) {

		var dataBaseConfig = new PropertiesDataBaseConfigLoader().loadDatabaseConfig();
		var connectionFactory = new ConnectionFactory(dataBaseConfig);
		var funcionarioRepository = new FuncionarioRepository(connectionFactory);
		var funcionarioService = new FuncionarioService(funcionarioRepository);
		var errorHandler = new ErrorHandler();
		var consoleReaderWriter = new ConsoleReaderWriter(new Scanner(System.in));
		var funcionarioFormReader = new FuncionarioFormReader(consoleReaderWriter);
		var funcionarioController = new FuncionarioController(funcionarioService, errorHandler,consoleReaderWriter, funcionarioFormReader);

		funcionarioController.cadastrarFuncionario();
		consoleReaderWriter.fecharScanner();
	}
}