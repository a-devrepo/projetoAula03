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
		var sql = "INSERT INTO funcionario (id_funcionario, nome, cpf, data_admissao) values (?,?,?,?)";

		try (var connection = connectionFactory.getConnection(); 
				var statement = connection.prepareStatement(sql)) {

			statement.setString(1, funcionario.getId().toString());
			statement.setString(2, funcionario.getNome());
			statement.setString(3, funcionario.getCpf());
			statement.setDate(4, java.sql.Date.valueOf(funcionario.getDataAdmissao()));
			statement.executeUpdate();
		} catch (SQLException sqlException) {
			throw new RepositoryException("Erro ao inserir Funcionário: ",sqlException);
		}
	}
}