package principal;

import controllers.FuncionarioController;
import factories.ConnectionFactory;
import handlers.ErrorHandler;
import io.ConsoleReaderWriter;
import repositories.FuncionarioRepository;
import services.FuncionarioService;

public class Main {

	public static void main(String[] args) {

		var connectionFactory = new ConnectionFactory();
		var funcionarioRepository = new FuncionarioRepository(connectionFactory);
		var funcionarioService = new FuncionarioService(funcionarioRepository);
		var errorHandler = new ErrorHandler();
		var consoleReaderWriter = new ConsoleReaderWriter(new java.util.Scanner(System.in));
		var funcionarioController = new FuncionarioController(funcionarioService, errorHandler, consoleReaderWriter);

		funcionarioController.cadastrarFuncionario();
		consoleReaderWriter.fecharScanner();
	}
}