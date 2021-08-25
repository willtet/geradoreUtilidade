package api.geradorDev.model;

public class Endereco {
	private String cep;
	private String endereco;
	private String bairro;
	private String cidade;
	private String estado;
	
	
	public Endereco(String cep, String endereco, String bairro, String cidade, String estado) {
		super();
		this.cep = cep;
		this.endereco = endereco;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}
	
	
	public String getCep() {
		return cep;
	}
	public String getEndereco() {
		return endereco;
	}
	public String getBairro() {
		return bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public String getEstado() {
		return estado;
	}
	
	
	
}
