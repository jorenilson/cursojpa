/**
 * 
 */
package br.curso.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Beah e Sergio
 *
 */
public class TesteCadastroConta {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//EntityManagerFactory emf=Persistence.createEntityManagerFactory("controledefinancas");
		//EntityManager em=emf.createEntityManager();
		
		EntityManager em=JPAUtil.getEM();
		
		//Conta conta = new Conta();
		Conta contaExcluir=new Conta();
		//conta.setTitular("jorenilson");
		//conta.setSaldo(500);
		ContaDao dao=new ContaDao(em);
		em.getTransaction().begin();
		
		
		//Cadastrar uma nova Conta.
		//dao.Cadastrar(conta); 
		
		//Excluir uma Conta
		contaExcluir.setId(1);
		dao.Excluir(contaExcluir);
		
		em.getTransaction().commit();
		em.close();
		//System.out.println("Codigo "+conta.getId());
		
	}

}
