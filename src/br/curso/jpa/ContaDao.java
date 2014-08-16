package br.curso.jpa;

import javax.persistence.EntityManager;

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
		em.remove(conta);
	}
}
