package br.com.testezemarcelo.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.testezemarcelo.dao.EnderecoDAO;
import br.com.testezemarcelo.dao.PessoaDAO;
import br.com.testezemarcelo.enums.UnidadeFederativaEnum;
import br.com.testezemarcelo.modelo.Endereco;
import br.com.testezemarcelo.modelo.Pessoa;
import br.com.testezermarcelo.dto.EnderecoDTO;
import br.com.testezermarcelo.dto.PessoaDTO;

/**
 * Classe responsável por executar operações 
 * com regras negociais vinculados ao objeto Pessoa
 * 
 */

@Service
public class PessoaBO implements Serializable {

	private static final long serialVersionUID = -1348723228427418062L;
	
	
	@Autowired
	private PessoaDAO pessoaDAO;
	
	@Autowired
	private EnderecoDAO enderecoDAO;
	
	/*
	 * Método responsável por listar os dados vinculados ao objeto Pesssoa 
	 * 
	 */
		
	public List<PessoaDTO> listar(){
		return convertePessoaPessoaDTO(pessoaDAO.listar());
	}
	
	/*
	 * Método responsável por inserir e conter as regras negociais
	 * vinculados ao objeto pessoa
	 * 
	 */
	
	
	public void inserir(PessoaDTO pessoaDTO){
		
		Pessoa pessoa = convertePessoaDTOPessoa(pessoaDTO);
		
		List<Endereco> listaEndereco = converteListaEnderecoDTOEndereco(pessoaDTO.getListaEnderecoDTO());
		
		pessoa.setListaEndereco(listaEndereco);
		
		pessoaDAO.inserir(pessoa);
	}
	
	/*
	 * Método responsável por alterar e conter as regras negociais
	 * vinculados ao objeto pessoa
	 * 
	 */
	
	public void alterar(PessoaDTO pessoaDTO){
		
		Pessoa pessoa = convertePessoaDTOPessoa(pessoaDTO);
		
		List<Endereco> listaEndereco = converteListaEnderecoDTOEndereco(pessoaDTO.getListaEnderecoDTO());
		
		pessoa.setListaEndereco(listaEndereco);
		
		pessoaDAO.alterar(pessoa);
	}
	
	
	/*
	 * Método responsável por remover e conter as regras negociais
	 * vinculados ao objeto pessoa
	 * 
	 */
	
	public void  remover(PessoaDTO pessoaDTO){
		
		Pessoa pessoa = convertePessoaDTOPessoa(pessoaDTO);
		enderecoDAO.removerEndereco(pessoa);
		pessoaDAO.remover(pessoa);
	}
	
	
	/*
	 * Método responsável por listar as unidades federativas
	 * 
	 */
	
	public List<String> listarUnidadeFederativa() {
		
		UnidadeFederativaEnum[] arrayUnidade 		= UnidadeFederativaEnum.values();		
		List<String> 			listaRetornoSigla 	= new ArrayList<String>();
		
		for (UnidadeFederativaEnum unidadeFederativaEnum : arrayUnidade) {
			listaRetornoSigla.add(unidadeFederativaEnum.getSigla());
		}
		
		return listaRetornoSigla;
		
	}
	
	/*
	 * Método responsável por converter o objeto PessoaDTO para Pessoa
	 * 
	 */
	
	private Pessoa convertePessoaDTOPessoa(PessoaDTO pessoaDTO) {
		
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(pessoaDTO, Pessoa.class);
	}

	
	/*
	 * Método responsável por converter o objeto Endereço para EndereçoDTO
	 * 
	 */
	
	private List<Endereco> converteListaEnderecoDTOEndereco(List<EnderecoDTO> listaEnderecoDTO) {
		
		ModelMapper 	modelMapper 			= new ModelMapper();
		List<Endereco>	listaEnderecoConvertido = new ArrayList<Endereco>();
		
		for (EnderecoDTO endDTO : listaEnderecoDTO) {
			
			listaEnderecoConvertido.add(modelMapper.map(endDTO, Endereco.class));
		}
		
		return listaEnderecoConvertido;
	}
	
	/*
	 * Método responsável por converter o objeto Pessoa para PessoaDTO
	 * 
	 */
	
	private List<PessoaDTO> convertePessoaPessoaDTO(List<Pessoa> listaPessoa) {
		
		ModelMapper 	modelMapper 	= new ModelMapper();
		List<PessoaDTO> listaConvertida	= new ArrayList<PessoaDTO>(); 
		
		for (Pessoa pessoa : listaPessoa) {
			listaConvertida.add(modelMapper.map(pessoa, PessoaDTO.class));
		}
		
		return listaConvertida;
	}



	public PessoaDAO getPessoaDAO() {
		return pessoaDAO;
	}

	public void setPessoaDAO(PessoaDAO pessoaDAO) {
		this.pessoaDAO = pessoaDAO;
	}

}
