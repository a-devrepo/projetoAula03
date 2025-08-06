package controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.UUID;

import entities.Endereco;
import entities.Funcionario;
import exceptions.RepositoryException;
import handlers.ErrorHandler;
import io.ConsoleReaderWriter;
import services.FuncionarioService;

public class FuncionarioController {
	
	private final ConsoleReaderWriter consoleReaderWriter;

	private final FuncionarioService service;

	private final ErrorHandler errorHandler;

	public FuncionarioController(FuncionarioService service, ErrorHandler errorHandler, ConsoleReaderWriter consoleReaderWriter) {
		this.service = service;
		this.errorHandler = errorHandler;
		this.consoleReaderWriter = consoleReaderWriter;
	}

	public void cadastrarFuncionario() {

		try {
			consoleReaderWriter.exibirMensagem("\nCADASTRO DE FUNCIONÁRIO:\n");

			var funcionario = preencherDadosFuncionario();
			funcionario.setEndereco(preencherDadosEndereco());

			service.cadastrarFuncionario(funcionario);
			consoleReaderWriter.exibirMensagem("\nCADASTRO REALIZADO COM SUCESSO!\n");

		} catch (RepositoryException repositoryException) {

			errorHandler.logError("Erro de repositório: ", repositoryException);
		
		} catch (Exception exception) {
			
			errorHandler.logError("Erro inesperado: ", exception);
		}
	}

	private Funcionario preencherDadosFuncionario() {

		var funcionario = new Funcionario();

		funcionario.setId(UUID.randomUUID());

		funcionario.setNome(consoleReaderWriter.lerLinha("INFORME O NOME.............................: "));

		funcionario.setCpf(consoleReaderWriter.lerLinha("INFORME O CPF:.............................: "));

		var dataAdmissaoInput = consoleReaderWriter.lerLinha("DATA DE ADMISSÃO (dd/MM/yyyy)..............:");
		var dataAdmissao = LocalDate.parse(dataAdmissaoInput, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		funcionario.setDataAdmissao(dataAdmissao);

		return funcionario;
	}

	private Endereco preencherDadosEndereco() {

		var endereco = new Endereco();

		endereco.setId(UUID.randomUUID());

		endereco.setLogradouro(consoleReaderWriter.lerLinha("INFORME O LOGRADOURO.......................: "));

		endereco.setNumero(consoleReaderWriter.lerLinha("INFORME O NÚMERO...........................: "));

		endereco.setComplemento(consoleReaderWriter.lerLinha("INFORME O COMPLEMENTO......................: "));

		endereco.setBairro(consoleReaderWriter.lerLinha("INFORME O BAIRRO............................: "));

		endereco.setCidade(consoleReaderWriter.lerLinha("INFORME A CIDADE............................: "));

		endereco.setEstado(consoleReaderWriter.lerLinha("INFORME O ESTADO............................: "));

		endereco.setCep(consoleReaderWriter.lerLinha("INFORME O CEP...............................: "));

		return endereco;
	}
}