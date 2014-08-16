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
		
		Conta conta = new Conta();
		conta.setTitular("jorenilson");
		conta.setSaldo(500);
		ContaDao dao=new ContaDao(em);
		em.getTransaction().begin();
		dao.Cadastrar(conta); //Cadastrar nova Conta.
		em.getTransaction().commit();
		em.close();
		System.out.println("Codigo "+conta.getId());
		
	}

}
