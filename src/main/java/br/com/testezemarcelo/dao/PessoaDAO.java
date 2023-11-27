package br.com.testezemarcelo.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.testezemarcelo.modelo.Endereco;
import br.com.testezemarcelo.modelo.Pessoa;


/**
 * Classe responsável por executar as
 * operações vinculas ao banco de dados
 */

@Repository
public class PessoaDAO implements Serializable {

	private static final long serialVersionUID = -5086207156924275163L;
	
	
	@PersistenceUnit
	private EntityManagerFactory emf;
	
	private EntityManager entityManager;
	


	public PessoaDAO() {
		super();
		this.emf = Persistence.createEntityManagerFactory("conexaoBD");
		this.entityManager= this.emf.createEntityManager();
		
	}
		
	/**
	 * Método responsável por listar o objeto pessoa
	 * @return {@link List}
 	 */
	
	public List<Pessoa> listar(){
		
		try {
			return this.entityManager.createQuery("SELECT p FROM Pessoa p", Pessoa.class).getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Pessoa>();
	}
	
	/**
	 * Método responsável por inserir dados vinculados
	 * ao objeto pessoa 
	 * 
	 * @param pessoa
	 */
	
	public void inserir(Pessoa pessoa){
		
		try {
			
			this.entityManager.getTransaction().begin();
			
			pessoa.setId(getSequenceValue().intValue() + 1 );
			pessoa.setListaEndereco(formatarListaEndereco(pessoa.getListaEndereco(), pessoa));
			
			this.entityManager.persist(pessoa);
			
			this.entityManager.getTransaction().commit();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Método responsável por obter a sequence da tabel pessoa
	 * 
	 * @return {@link Long}
	 */
	
	public Long getSequenceValue(){
		
		try {
	        Query query = this.entityManager.createNativeQuery("select nextval('mantem_pessoa.sequencial_pessoa')");
	        Object obj = query.getSingleResult();
	        return ( (java.math.BigInteger)obj ).longValue();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0l;
    }
	
	/**
	 * Método responsável por alterar dados vinculados ao objeto pessoa
	 * 
	 * @param pessoa
	 */
	
	public void alterar(Pessoa pessoa){
		
		try {
			
			this.entityManager.getTransaction().begin();
			this.entityManager.merge(pessoa);
			
			this.entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Método responsável por remover os dados vinculados ao objeto pessoa
	 * 
	 * @param pessoa
	 */
	
	public void  remover(Pessoa pessoa){
		
		try {
			
			this.entityManager.getTransaction().begin();
			
			this.entityManager.createNativeQuery("DELETE FROM mantem_pessoa.pessoa where id=" + pessoa.getId()).executeUpdate();
			
			this.entityManager.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	/**
	 * 
	 * Método criado para fazer a vinculação entre pessoa e seus respectivos endereços
	 * funcionou melhor desta forma
	 * 
	 * @param lista
	 * @param pessoa
	 * @return {@link List}
	 */
		
	public List<Endereco> formatarListaEndereco(List<Endereco> lista, Pessoa pessoa){
		
		List<Endereco>  listaRetorno = new ArrayList<Endereco>();
		
		for (Endereco endereco : lista) {
			endereco.setPessoa(pessoa);
			listaRetorno.add(endereco);
		}
		
		return listaRetorno;
				
	}
	
		
}
