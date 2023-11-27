package br.com.testezemarcelo.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.testezemarcelo.dao.EnderecoDAO;
import br.com.testezemarcelo.modelo.Endereco;
import br.com.testezermarcelo.dto.EnderecoDTO;


/**
 * Classe responsável por executar operações 
 * com regras negociais vinculados ao objeto Endereço
 * 
 */


@Service
public class EnderecoBO implements Serializable {

	private static final long serialVersionUID = 2377531151421761119L;

	
	@Autowired
	private EnderecoDAO enderecoDAO;
	
	/*
	 * Método responsável por listar e conter as regras negociais
	 * vinculados ao objeto endereço
	 * 
	 */
		
	public List<EnderecoDTO> listar(int idPessoa){
		return converteEnderecoEnderecoDTO(enderecoDAO.listarEnderecoPorPessoa(idPessoa));
	}
	
	/*
	 * Método responsável por altear e conter as regras negociais
	 * vinculados ao objeto endereço
	 * 
	 */
	
	public void alterar(EnderecoDTO endereco){
		
		enderecoDAO.alterar(converteEnderecoDTOEndereco(endereco));
	}
	
	/*
	 * Método responsável por remover e conter as regras negociais
	 * vinculados ao objeto endereço
	 * 
	 */
	
	public void  remover(EnderecoDTO endereco){
	
		enderecoDAO.remover(converteEnderecoDTOEndereco(endereco));
	}	
	
	
	/*
	 * Método responsável por converter o objeto Endereço para EndereçoDTO
	 * 
	 */
	
    private List<EnderecoDTO> converteEnderecoEnderecoDTO(List<Endereco> listaEndereco) {
		
		ModelMapper 		modelMapper 	= new ModelMapper();
		List<EnderecoDTO> 	listaConvertida	= new ArrayList<EnderecoDTO>(); 
		
		for (Endereco endereco : listaEndereco) {
			listaConvertida.add(modelMapper.map(endereco, EnderecoDTO.class));
		}
		
		return listaConvertida;
	}
    
	/*
	 * Método responsável por converter o objeto EndereçoDTO para Endereço
	 * 
	 */
    
    private Endereco converteEnderecoDTOEndereco(EnderecoDTO enderecoDTO) {
		
		ModelMapper 		modelMapper 	= new ModelMapper();

		return modelMapper.map(enderecoDTO, Endereco.class);
		
	}
}
