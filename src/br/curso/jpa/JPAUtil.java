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
 private static final EntityManagerFactory emf=Persistence.createEntityManagerFactory("controladefinancas");
 
 public static EntityManager getEntityManager(){
	 return emf.createEntityManager();
 }
}
