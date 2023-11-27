package br.com.testezermarcelo.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class PessoaDTO implements Serializable {

	private static final long serialVersionUID = -7879238788044404622L;
	
	private int id;
	
	private String nome;
	
	private Date idade;
	
	private String sexo;
	
	private List<EnderecoDTO> listaEnderecoDTO = new ArrayList<EnderecoDTO>();


	public PessoaDTO() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public List<EnderecoDTO> getListaEnderecoDTO() {
		return listaEnderecoDTO;
	}

	public void setListaEnderecoDTO(List<EnderecoDTO> listaEnderecoDTO) {
		this.listaEnderecoDTO = listaEnderecoDTO;
	}

	public Date getIdade() {
		return idade;
	}

	public void setIdade(Date idade) {
		this.idade = idade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
