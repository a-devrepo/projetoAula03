package controllers;

import exceptions.PersistenceException;
import handlers.ErrorHandler;
import io.ConsoleReaderWriter;
import io.FuncionarioFormReader;
import services.IFuncionarioService;

public class FuncionarioController {
	
	private final ConsoleReaderWriter consoleReaderWriter;

	private final IFuncionarioService service;

	private final ErrorHandler errorHandler;
	
	private final FuncionarioFormReader funcionarioFormReader;

	public FuncionarioController(
			IFuncionarioService service, 
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

		} catch (PersistenceException persistenceException) {

			errorHandler.logError("Erro de persistência: ", persistenceException);
		
		} catch (Exception exception) {
			
			errorHandler.logError("Erro inesperado: ", exception);
		}
	}
}