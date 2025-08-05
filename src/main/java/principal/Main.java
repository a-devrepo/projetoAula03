package principal;

import controllers.FuncionarioController;
import factories.ConnectionFactory;
import repositories.FuncionarioRepository;
import services.FuncionarioService;
import utils.ErrorHandler;

public class Main {

	public static void main(String[] args) {
		
		var connectionFactory = new ConnectionFactory();
		var funcionarioRepository = new FuncionarioRepository(connectionFactory);
		var funcionarioService = new FuncionarioService(funcionarioRepository);
		var errorHandler = new ErrorHandler();
		var funcionarioController = new FuncionarioController(funcionarioService,errorHandler);
		
		funcionarioController.cadastrarFuncionario();
		funcionarioController.fecharScanner();
	}
}