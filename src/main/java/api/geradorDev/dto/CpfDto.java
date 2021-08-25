package api.geradorDev.dto;

import api.geradorDev.gerador.GeradorCpf;

public class CpfDto {
	private String cpf;
	private String cpfFormatado;
	GeradorCpf gerador = new GeradorCpf();
	
	public CpfDto() {
		this.cpf = this.gerador.gerarCpf();
		
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCpfFormatado() {
		return cpfFormatado;
	}

	public void setCpfFormatado(String cpfFormatado) {
		this.cpfFormatado = cpfFormatado;
	}
	
	public boolean verificar(String cpfVerificar) {
		return this.gerador.validar(cpfVerificar);
	}
	
	
	
}
