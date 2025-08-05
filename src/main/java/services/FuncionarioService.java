package services;

import entities.Funcionario;
import repositories.FuncionarioRepository;

public class FuncionarioService {

	private final FuncionarioRepository repository;
	
	public FuncionarioService(FuncionarioRepository repository) {
		this.repository = repository;
	}
	
	public void cadastrarFuncionario(Funcionario funcionario) {
		repository.inserir(funcionario);
	}
}