package io;

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
	
	public void fecharScanner() {
			scanner.close();
	}
}
