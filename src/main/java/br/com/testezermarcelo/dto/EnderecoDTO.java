package br.com.testezermarcelo.dto;

import java.io.Serializable;



public class EnderecoDTO implements Serializable {

	private static final long serialVersionUID = -1178282081626379335L;
	
	private String estado;
	
	private String cidade;
	
	private String logradouro;
	
	private int numero;
	
	private String cep;
	
	
	public EnderecoDTO() {
		super();
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
