package br.com.testezemarcelo.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import br.com.testezemarcelo.modelo.Endereco;
import br.com.testezemarcelo.modelo.Pessoa;

/**
 * Classe responsável por executar ações vinculados à base de dados
 * vinculada ao objeto endereço
 * 
 */

@Repository
public class EnderecoDAO implements Serializable {

	private static final long serialVersionUID = -4155573698404554447L;
	
	@PersistenceUnit
	private EntityManagerFactory emf;
	
	private EntityManager entityManager;
	
	
	public EnderecoDAO() {
		super();
		this.emf = Persistence.createEntityManagerFactory("conexaoBD");
		this.entityManager= this.emf.createEntityManager();
		
	}
	
	/**
	 * Método responsável por listar dados vinculados ao objeto endereço
	 * 
	 * @param idPessoa
	 * @return {@link List}
	 */
	
	public List<Endereco> listarEnderecoPorPessoa(int idPessoa){
		
		try {
			return this.entityManager.createQuery("SELECT e FROM Endereco e where e.pessoa.id="+idPessoa, Endereco.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ArrayList<Endereco>();
	}
	
	/**
	 * Método responsável por alterar dados vinculados ao objeto endereço
	 * 
	 * @param Endereço
	 */
	
	public void alterar(Endereco endereco){
		
		try {
			
			this.entityManager.getTransaction().begin();
			this.entityManager.merge(endereco);
			this.entityManager.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
	
	/**
	 * Método responsável por remover dados vinculados ao objeto endereço
	 * 
	 * @param Endereco
	 */
	
	public void  remover(Endereco endereco){
		
		try {
		
			this.entityManager.getTransaction().begin();
			this.entityManager.createNativeQuery("DELETE FROM mantem_pessoa.endereco where id=" + endereco.getId()).executeUpdate();
			this.entityManager.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	/**
	 * Método responsável por remover dados vinculados ao objeto endereço
	 * 
	 * @param pessoa
	 */
	
	public void  removerEndereco(Pessoa pessoa){
		
		try {
			
			this.entityManager.getTransaction().begin();
			this.entityManager.createNativeQuery("DELETE FROM mantem_pessoa.endereco where id_pessoa=" + pessoa.getId()).executeUpdate();
			this.entityManager.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
