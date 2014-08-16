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

		EntityManagerFactory emf=Persistence.createEntityManagerFactory("controledefinancas");
		EntityManager em=emf.createEntityManager();
		Conta conta = new Conta();
		conta.setTitular("Maria");
		conta.setSaldo(500);
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		em.close();
		System.out.println("Codigo "+conta.getId());
		
	}

}
