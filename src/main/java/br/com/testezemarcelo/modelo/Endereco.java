package br.com.testezemarcelo.modelo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name =  "endereco", schema = "mantem_pessoa")
public class Endereco implements Serializable {

	private static final long serialVersionUID = -4800918952913190274L;
			
	@Id
	@SequenceGenerator(name="SEQ_ENDERECO", sequenceName = "mantem_pessoa.sequencial_endereco", allocationSize = 1)
	@GeneratedValue(generator = "SEQ_ENDERECO", strategy = GenerationType.SEQUENCE)
	private int id;
	
	@Column(name = "estado")
	private String estado;
	
	@Column(name = "cidade")
	private String cidade;
	
	@Column(name = "logradouro")
	private String logradouro;
	
	@Column(name = "numero")
	private int numero;
	
	@Column(name = "cep")
	private String cep;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_pessoa", nullable = false, referencedColumnName = "id")
	private Pessoa pessoa;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
}
