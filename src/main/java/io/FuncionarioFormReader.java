package io;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import entities.Endereco;
import entities.Funcionario;

public class FuncionarioFormReader {

	private final ConsoleReaderWriter consoleReaderWriter;
	
	public FuncionarioFormReader(ConsoleReaderWriter consoleReaderWriter) {
		this.consoleReaderWriter = consoleReaderWriter;
	}
	
	public Funcionario preencherDadosFuncionario() {

		var funcionario = new Funcionario();

		funcionario.setId(UUID.randomUUID());

		funcionario.setNome(consoleReaderWriter.lerLinha("INFORME O NOME..............................: "));

		funcionario.setCpf(consoleReaderWriter.lerLinha("INFORME O CPF:..............................: "));

		var dataAdmissaoInput = consoleReaderWriter.lerLinha("DATA DE ADMISSÃO (dd/MM/yyyy)...............:");
		var dataAdmissao = LocalDate.parse(dataAdmissaoInput, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		funcionario.setDataAdmissao(dataAdmissao);
		funcionario.setEndereco(preencherDadosEndereco());
		return funcionario;
	}
	
	private Endereco preencherDadosEndereco() {

		var endereco = new Endereco();

		endereco.setId(UUID.randomUUID());

		endereco.setLogradouro(consoleReaderWriter.lerLinha("INFORME O LOGRADOURO........................: "));

		endereco.setNumero(consoleReaderWriter.lerLinha("INFORME O NÚMERO............................: "));

		endereco.setComplemento(consoleReaderWriter.lerLinha("INFORME O COMPLEMENTO.......................: "));

		endereco.setBairro(consoleReaderWriter.lerLinha("INFORME O BAIRRO............................: "));

		endereco.setCidade(consoleReaderWriter.lerLinha("INFORME A CIDADE............................: "));

		endereco.setEstado(consoleReaderWriter.lerLinha("INFORME O ESTADO............................: "));

		endereco.setCep(consoleReaderWriter.lerLinha("INFORME O CEP...............................: "));

		return endereco;
	}
}
