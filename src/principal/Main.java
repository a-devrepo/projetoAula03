package principal;

import controllers.FuncionarioController;
import factories.ConnectionFactory;
import repositories.FuncionarioRepository;
import services.FuncionarioService;

public class Main {

	public static void main(String[] args) {
		
		var connectionFactory = new ConnectionFactory();
		var funcionarioRepository = new FuncionarioRepository(connectionFactory);
		var funcionarioService = new FuncionarioService(funcionarioRepository);
		var funcionarioController = new FuncionarioController(funcionarioService);
		
		funcionarioController.cadastrarFuncionario();
		funcionarioController.fecharScanner();
	}
}