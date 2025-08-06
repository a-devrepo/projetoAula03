package services;

import entities.Funcionario;
import repositories.FuncionarioRepository;

public class FuncionarioServiceImpl implements IFuncionarioService {

	private final FuncionarioRepository repository;
	
	public FuncionarioServiceImpl(FuncionarioRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public void cadastrarFuncionario(Funcionario funcionario) {
		repository.inserir(funcionario);
	}
}