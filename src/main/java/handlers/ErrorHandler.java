package handlers;

import io.ConsoleReaderWriter;

public class ErrorHandler {

	private final ConsoleReaderWriter consoleReaderWriter;

	public ErrorHandler(ConsoleReaderWriter consoleReaderWriter) {
		this.consoleReaderWriter = consoleReaderWriter;
	}

	public void logError(String message, Exception exception) {

		consoleReaderWriter.exibirMensagemErro(message);
		consoleReaderWriter.exibirDetalhesErro(exception);
	}
}