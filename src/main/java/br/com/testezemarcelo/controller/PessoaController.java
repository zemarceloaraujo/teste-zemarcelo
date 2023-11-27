package br.com.testezemarcelo.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import br.com.testezemarcelo.bo.EnderecoBO;
import br.com.testezemarcelo.bo.PessoaBO;
import br.com.testezermarcelo.dto.EnderecoDTO;
import br.com.testezermarcelo.dto.PessoaDTO;

/**
 * Classe responsável por executar as 
 * operações de controle de requisições vinculados 
 * à página gerepessoa.xhmtl e operações vinculados 
 * ao objeto Pessoa e Endereço
 * 
 */

@Named("pessoaController")
@Scope("session")
public class PessoaController implements Serializable {

	private static final long serialVersionUID = -7903386034311214413L;
	
	
	@Autowired
	private PessoaBO pessoaBO;
	
	@Autowired
	private EnderecoBO enderecoBO;
	
	private PessoaDTO 	pessoaDTO 	= new PessoaDTO();
	
	private EnderecoDTO enderecoDTO	= new EnderecoDTO();
	
	private List<EnderecoDTO> listaEndereco = new ArrayList<EnderecoDTO>();
	
	private List<String> 	  listaSigla;
		
	/**
	 * Método responsável por lista siglas
	 *  
	 * @return {@link List}
	 */
	
	public List<String> listarSigla(){
		return pessoaBO.listarUnidadeFederativa();
	}
	
	
	/**
	 * Método responsável por listar dados vinculados ao
	 * objeto Pessoa
	 * 
	 * @return {@link List}
	 */
	
	public List<PessoaDTO> listarPessoa(){
		
		return pessoaBO.listar();
	}
	
	/**
	 * Método responsável por inserir dados
	 * vinculados aos objetos Pessoa e Endereço
	 * 
	 */
	
	public void inserir(){
		
		this.pessoaDTO.getListaEnderecoDTO().addAll(this.listaEndereco);
		
		pessoaBO.inserir(this.pessoaDTO);
	}
	
	/**
	 * Método responsável por disponibilizar dados
	 * do objeto Pessoa selecionado para ser editado
	 * 
	 * @param pessoaDTO
	 */
	
	public void alterarPessoa(PessoaDTO pessoaDTO){
		
		
		this.pessoaDTO = new PessoaDTO();		
		this.pessoaDTO.getListaEnderecoDTO().addAll(enderecoBO.listar(pessoaDTO.getId()));
		this.pessoaDTO.setIdade(pessoaDTO.getIdade());
		this.pessoaDTO.setNome(pessoaDTO.getNome());
		this.pessoaDTO.setSexo(pessoaDTO.getSexo());
	}
	
	/**
	 * Método responsável por remover os dados vinculados ao 
	 * objeto Pessoa
	 * 
	 * @param pessDTO
	 */
	
	public void  removerPessoa(PessoaDTO pessDTO){
			
		pessoaBO.remover(pessDTO);
	}
	
	/**
	 * Método responsável por adicionar os dados vinculados ao 
	 * objeto Endereço a lista de endereços vinculado ao objeto Pessoa
	 * 
	 * @param pessDTO
	 */
	
	public void adicionarEndereco() {
		
		if(!(this.enderecoDTO.getCidade() == null) && !this.enderecoDTO.getCidade().isEmpty()) {
		
			this.listaEndereco.add(this.enderecoDTO);
			this.enderecoDTO = new EnderecoDTO();
		}
	}
	
	/**
	 * Método responsável por alterar os dados 
	 * vinculados ao objeto Endereço
	 * 
	 * @param enderecoDTO
	 */
	
	public void alterarEndereco(EnderecoDTO enderecoDTO) {
		
		enderecoBO.alterar(enderecoDTO);
	}
	
	/**
	 * Método responsável por remover os dados 
	 * vinculados ao objeto Endereço
	 * 
	 * @param enderecoDTO
	 */
	
	public void removerEndereco(EnderecoDTO enderecoDTO) {
		
		enderecoBO.alterar(enderecoDTO);
	}
	
	
	
	public PessoaBO getPessoaBO() {
		return pessoaBO;
	}

	public void setPessoaBO(PessoaBO pessoaBO) {
		this.pessoaBO = pessoaBO;
	}

	public PessoaDTO getPessoaDTO() {
		return pessoaDTO;
	}

	public void setPessoaDTO(PessoaDTO pessoaDTO) {
		this.pessoaDTO = pessoaDTO;
	}

	public EnderecoDTO getEnderecoDTO() {
		return enderecoDTO;
	}

	public void setEnderecoDTO(EnderecoDTO enderecoDTO) {
		this.enderecoDTO = enderecoDTO;
	}

	public List<EnderecoDTO> getListaEndereco() {
		return listaEndereco;
	}

	public void setListaEndereco(List<EnderecoDTO> listaEndereco) {
		this.listaEndereco = listaEndereco;
	}

	public List<String> getListaSigla() {
		return listaSigla;
	}

	public void setListaSigla(List<String> listaSigla) {
		this.listaSigla = listaSigla;
	}
}
