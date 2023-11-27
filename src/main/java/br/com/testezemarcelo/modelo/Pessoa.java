package br.com.testezemarcelo.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.Query;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name =  "pessoa", schema = "mantem_pessoa")


public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1186953348388872275L;
	
	
	@Id
	//@SequenceGenerator(name="SEQ_PESSOA", sequenceName = "mantem_pessoa.sequencial_pessoa", allocationSize = 1)
	//@GeneratedValue(generator = "SEQ_PESSOA", strategy = GenerationType.SEQUENCE)
	private int id;
	
	@Column(name = "nome")
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "idade")
	private Date idade;
	
	@Column(name = "sexo")
	private String sexo;
	
	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)	
	private List<Endereco> listaEndereco;
		

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<Endereco> getListaEndereco() {
		return listaEndereco;
	}

	public void setListaEndereco(List<Endereco> listaEndereco) {
		this.listaEndereco = listaEndereco;
	}

	public Date getIdade() {
		return idade;
	}

	public void setIdade(Date idade) {
		this.idade = idade;
	}
	

	
}
