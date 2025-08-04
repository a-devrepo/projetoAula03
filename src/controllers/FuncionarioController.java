package controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;

import entities.Endereco;
import entities.Funcionario;
import exceptions.RepositoryException;
import services.FuncionarioService;
import utils.ErrorHandler;

public class FuncionarioController {

	private final Scanner scanner = new Scanner(System.in);

	private final FuncionarioService service;

	private final ErrorHandler errorHandler;

	public FuncionarioController(FuncionarioService service, ErrorHandler errorHandler) {
		this.service = service;
		this.errorHandler = errorHandler;
	}

	public void cadastrarFuncionario() {

		try {
			System.out.println("\nCADASTRO DE FUNCIONÁRIO:\n");

			var funcionario = preencherDadosFuncionario();
			funcionario.setEndereco(preencherDadosEndereco());

			service.cadastrarFuncionario(funcionario);
			System.out.println("\nCADASTRO REALIZADO COM SUCESSO!\n");

		} catch (RepositoryException repositoryException) {

			errorHandler.logError("Erro de repositório: ", repositoryException);
		
		} catch (Exception exception) {
			
			errorHandler.logError("Erro inesperado: ", exception);
		}
	}

	private Funcionario preencherDadosFuncionario() {

		var funcionario = new Funcionario();

		funcionario.setId(UUID.randomUUID());

		funcionario.setNome(lerLinha("INFORME O NOME.............................: "));

		funcionario.setCpf(lerLinha("INFORME O CPF:.............................: "));

		var dataAdmissaoInput = lerLinha("DATA DE ADMISSÃO (dd/MM/yyyy)..............:");
		var dataAdmissao = LocalDate.parse(dataAdmissaoInput, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		funcionario.setDataAdmissao(dataAdmissao);

		return funcionario;
	}

	private Endereco preencherDadosEndereco() {

		var endereco = new Endereco();

		endereco.setId(UUID.randomUUID());

		endereco.setLogradouro(lerLinha("INFORME O LOGRADOURO.......................: "));

		endereco.setNumero(lerLinha("INFORME O NÚMERO...........................: "));

		endereco.setComplemento(lerLinha("INFORME O COMPLEMENTO......................: "));

		endereco.setBairro(lerLinha("INFORME O BAIRRO............................: "));

		endereco.setCidade(lerLinha("INFORME A CIDADE............................: "));

		endereco.setEstado(lerLinha("INFORME O ESTADO............................: "));

		endereco.setCep(lerLinha("INFORME O CEP...............................: "));

		return endereco;
	}

	private String lerLinha(String mensagem) {
		System.out.print(mensagem);
		return scanner.nextLine();
	}

	public void fecharScanner() {
		scanner.close();
	}
}