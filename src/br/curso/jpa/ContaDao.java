package br.curso.jpa;

import javax.management.Query;
import javax.persistence.*;

import antlr.collections.List;

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
	
	public java.util.List<Conta> listar(){
		String jpql="Select c from Conta c";
		Query query=(Query) em.createQuery(jpql);
		return ((javax.persistence.Query) query).getResultList();
	}
}
