package api.geradorDev.model;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import api.geradorDev.gerador.GeradorCpf;
import api.geradorDev.gerador.GeradorDDDTelefone;
import api.geradorDev.gerador.GeradorEndereco;
import api.geradorDev.gerador.GeradorNascimento;
import api.geradorDev.gerador.GeradorNomeESexo;
import api.geradorDev.utils.DateFormatter;

public class Pessoa {
	private String nome;
	private String sobrenome;
	private String idade;
	private String cpf;
	private LocalDate nascimento;
	private String sexo;
	private String estadoCivil;
	private String nomeMae;
	
	private String email;
	private String senha;
	private String ddd;
	private String telefone;
	
	private Endereco endereco;
	
	
	
	
	
	public Pessoa(String cep) {
		String[] auxiliar = new GeradorNomeESexo().gerar().split(";"); 
		LocalDate nascimento = LocalDate.parse(new GeradorNascimento().gerar());
		
		this.nome = auxiliar[0];
		this.sobrenome = auxiliar[1];
		this.cpf = new GeradorCpf().gerarCpf();
		this.nascimento = nascimento;
		this.idade = idadeCalculator(nascimento);
		this.sexo = auxiliar[2];
		this.estadoCivil = "solteiro";
		this.nomeMae = new GeradorNomeESexo().gerarMãe(auxiliar[1]);
		this.email = this.cpf.replaceAll("[^0-9]","")+"@emailteste.com";
		this.senha = "100100";
		this.ddd = new GeradorDDDTelefone().gerarDDD();
		this.telefone = new GeradorDDDTelefone().gerarTelefone();
		try {
			this.endereco = new GeradorEndereco().gerar(cep);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String idadeCalculator(LocalDate nascimentos) {
		LocalDate currentDate = LocalDate.now();
		int idadeReal = currentDate.getYear() - nascimentos.getYear();
		
		return String.valueOf(idadeReal);
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getIdade() {
		return idade;
	}

	public String getCpf() {
		return cpf;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public String getDdd() {
		return ddd;
	}

	public String getTelefone() {
		return telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}



	
	
	
	
	
}
