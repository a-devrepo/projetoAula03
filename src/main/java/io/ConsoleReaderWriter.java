package io;

import java.util.Objects;
import java.util.Scanner;

public class ConsoleReaderWriter {

	private final Scanner scanner;

	public ConsoleReaderWriter(Scanner scanner) {
		this.scanner = scanner;
	}

	public String lerLinha(String mensagem) {
		System.out.print(mensagem);
		return scanner.nextLine();
	}

	public void exibirMensagem(String mensagem) {
		System.out.println(mensagem);
	}

	public void exibirMensagemErro(String mensagem) {
		System.err.println("\nERRO: " + mensagem);
	}
	
	public void exibirDetalhesErro(Exception exception) {
		
		System.err.println("Detalhes: " + exception.getMessage());
		
		if (Objects.nonNull(exception.getCause())) {
			System.err.println("Causa original: " + exception.getCause().getMessage());
		}
	}

	public void fecharScanner() {
		scanner.close();
	}
}
