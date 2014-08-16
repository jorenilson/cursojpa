package br.curso.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class GenericDAO<T> {
 private EntityManager em;
 private Class<T>classe;

 public GenericDAO(EntityManager em,Class <T> classe){
	 this.em=em;
	 this.classe=classe;
 }
 //metodo cadastrar generico
 public void cadastrar(T t){
  em.persist(t);
 }

 //Metodo excluir generico
 private void excluir(T t) {
	em.remove(em.merge(t));
}
 
 //metodo consultar generico
 public T consultar(long id){
	 return em.getReference(classe, id);
 }
 
 public List<T> listar(){
	 String jpql="Select o from "+classe.getName()+"o";
	 Query query=em.createQuery(jpql);
	 return query.getResultList();
 }

}
