package controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.UUID;

import entities.Funcionario;

public class FuncionarioController {

	public void cadastrarFuncionario() {
		
		var scanner = new Scanner(System.in);
		
		System.out.println("\nCADASTRO DE FUNCIONÁRIO:\n");
		
		var funcionario = new Funcionario();
		
		funcionario.setId(UUID.randomUUID());
		
		System.out.print("INFORME O NOME:............................: ");
		funcionario.setNome(scanner.nextLine());
		
		System.out.print("INFORME O CPF.:............................: ");
		funcionario.setCpf(scanner.nextLine());
		
		System.out.print("DATA DE ADMISSÃO (dd/MM/yyyy)..............: ");
		var dataAdmissaoInput = scanner.nextLine();
		var dataAdmissao = LocalDate.parse(dataAdmissaoInput,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		scanner.close();
	}
}