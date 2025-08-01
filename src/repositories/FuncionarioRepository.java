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
		try (var connection = connectionFactory.getConnection()) {
			var statement = connection.prepareStatement(
					"INSERT INTO funcionario (id_funcionario, nome, cpf, data_admissao) values (?,?,?,?)");
			statement.setString(1, funcionario.getId().toString());
			statement.setString(2, funcionario.getNome());
			statement.setString(3, funcionario.getCpf());
			statement.setDate(4, java.sql.Date.valueOf(funcionario.getDataAdmissao()));
			statement.execute();
		} catch (SQLException exception) {
			throw new RepositoryException("Erro ao inserir Funcionário: " + exception.getMessage());
		} catch (Exception e) {
			throw new RepositoryException("Erro: " + e.getMessage());
		}
	}
}
