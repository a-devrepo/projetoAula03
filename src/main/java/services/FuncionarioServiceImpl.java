package services;

import entities.Funcionario;
import repositories.IFuncionarioRepository;

public class FuncionarioServiceImpl implements IFuncionarioService {

	private final IFuncionarioRepository repository;
	
	public FuncionarioServiceImpl(IFuncionarioRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public void cadastrarFuncionario(Funcionario funcionario) {
		repository.inserir(funcionario);
	}
}