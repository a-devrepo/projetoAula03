package repositories;

import java.sql.SQLException;

import entities.Funcionario;
import exceptions.RepositoryException;
import factories.ConnectionFactory;

public class FuncionarioRepository {

	private ConnectionFactory connectionFactory;

	public FuncionarioRepository(ConnectionFactory connectionFactory) {
		this.connectionFactory = connectionFactory;
	}

	public void inserir(Funcionario funcionario) {
		
		var sqlFuncionario = "INSERT INTO funcionario (id_funcionario, nome, cpf, data_admissao) values (?,?,?,?)";
		var sqlEndereco = """
			    INSERT INTO endereco 
			    (id_endereco, logradouro, numero, complemento, bairro, cidade, estado, cep, id_funcionario) 
			    VALUES (?,?,?,?,?,?,?,?,?)
			    """;
		try (var connection = connectionFactory.getConnection(); 
				var statementFuncionario = connection.prepareStatement(sqlFuncionario);
				var statementEndereco = connection.prepareStatement(sqlEndereco)) {
			

			statementFuncionario.setString(1, funcionario.getId().toString());
			statementFuncionario.setString(2, funcionario.getNome());
			statementFuncionario.setString(3, funcionario.getCpf());
			statementFuncionario.setDate(4, java.sql.Date.valueOf(funcionario.getDataAdmissao()));
			statementFuncionario.executeUpdate();
			
			statementEndereco.setString(1, funcionario.getEndereco().getId().toString());
			statementEndereco.setString(2, funcionario.getEndereco().getLogradouro());
			statementEndereco.setString(3, funcionario.getEndereco().getNumero());
			statementEndereco.setString(4, funcionario.getEndereco().getComplemento());
			statementEndereco.setString(5, funcionario.getEndereco().getBairro());
			statementEndereco.setString(6, funcionario.getEndereco().getCidade());
			statementEndereco.setString(7, funcionario.getEndereco().getEstado());
			statementEndereco.setString(8, funcionario.getEndereco().getCep());
			statementEndereco.setString(9, funcionario.getId().toString());
			statementEndereco.executeUpdate();
			

		} catch (SQLException sqlException) {
			throw new RepositoryException("Erro ao inserir Funcionário: ",sqlException);
		}
	}
}