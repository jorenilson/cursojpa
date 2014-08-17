package br.curso.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;



public class ContaDao {
	private EntityManager em;
	public ContaDao(EntityManager em) {
		this.em = em;
	}
	
	//metodo cadastrar
	public void Cadastrar(Conta conta){
		em.persist(conta);
	}
	
	//metodo excluir
	public void Excluir(Conta conta){
		em.remove(em.merge(conta));
	}
	
	//Metodo Consultar
	public Conta consultar(long id){
		return em.getReference(Conta.class, id);
	}
	
	public List<Conta> listar(){
		String jpql="Select c from Conta c";
		Query query=em.createQuery(jpql);
		return query.getResultList();
	}
}
