package controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.UUID;

import entities.Endereco;
import entities.Funcionario;

public class FuncionarioController {

	public void cadastrarFuncionario() {
		
		var scanner = new Scanner(System.in);
		
		System.out.println("\nCADASTRO DE FUNCIONÁRIO:\n");
		
		var funcionario = new Funcionario();
		
		funcionario.setId(UUID.randomUUID());
		
		System.out.print("INFORME O NOME.............................: ");
		funcionario.setNome(scanner.nextLine());
		
		System.out.print("INFORME O CPF:.............................: ");
		funcionario.setCpf(scanner.nextLine());
		
		System.out.print("DATA DE ADMISSÃO (dd/MM/yyyy)..............: ");
		var dataAdmissaoInput = scanner.nextLine();
		var dataAdmissao = LocalDate.parse(dataAdmissaoInput,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		funcionario.setDataAdmissao(dataAdmissao);
		
		var endereco = new Endereco();
		
		endereco.setId(UUID.randomUUID());
		
		System.out.print("INFORME O LOGRADOURO.......................: ");
		endereco.setLogradouro(scanner.nextLine());
		
		System.out.print("INFORME O NÚMERO...........................: ");
		endereco.setNumero(scanner.nextLine());
		
		System.out.print("INFORME O COMPLEMENTO......................: ");
		endereco.setComplemento(scanner.nextLine());
		
		System.out.print("INFORME O BAIRRO............................: ");
		endereco.setBairro(scanner.nextLine());
		
		System.out.print("INFORME A CIDADE............................: ");
		endereco.setCidade(scanner.nextLine());
		
		System.out.print("INFORME O ESTADO............................: ");
		endereco.setEstado(scanner.nextLine());
		
		System.out.print("INFORME O CEP...............................: ");
		endereco.setCep(scanner.nextLine());
		
		
		
		scanner.close();
		
		System.out.println("\nCADASTRO REALIZADO COM SUCESSO!\n");
	}
}