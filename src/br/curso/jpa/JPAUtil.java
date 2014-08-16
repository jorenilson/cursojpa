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
public class JPAUtil {
 private static final EntityManagerFactory emf=Persistence.createEntityManagerFactory("controledefinancas");
 
 public static EntityManager getEM(){
	 return emf.createEntityManager();
 }
}
