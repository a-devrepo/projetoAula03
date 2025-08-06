package controllers;

import exceptions.RepositoryException;
import handlers.ErrorHandler;
import io.ConsoleReaderWriter;
import io.FuncionarioFormReader;
import services.FuncionarioService;

public class FuncionarioController {
	
	private final ConsoleReaderWriter consoleReaderWriter;

	private final FuncionarioService service;

	private final ErrorHandler errorHandler;
	
	private final FuncionarioFormReader funcionarioFormReader;

	public FuncionarioController(
			FuncionarioService service, 
			ErrorHandler errorHandler, 
			ConsoleReaderWriter consoleReaderWriter,
			FuncionarioFormReader funcionarioFormReader) {
		this.service = service;
		this.errorHandler = errorHandler;
		this.consoleReaderWriter = consoleReaderWriter;
		this.funcionarioFormReader = funcionarioFormReader;
	}

	public void cadastrarFuncionario() {

		try {
			consoleReaderWriter.exibirMensagem("\nCADASTRO DE FUNCIONÁRIO:\n");

			var funcionario = funcionarioFormReader.preencherDadosFuncionario();

			service.cadastrarFuncionario(funcionario);
			consoleReaderWriter.exibirMensagem("\nCADASTRO REALIZADO COM SUCESSO!\n");

		} catch (RepositoryException repositoryException) {

			errorHandler.logError("Erro de repositório: ", repositoryException);
		
		} catch (Exception exception) {
			
			errorHandler.logError("Erro inesperado: ", exception);
		}
	}
}