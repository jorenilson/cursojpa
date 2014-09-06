package cursojpa.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import cursojpa.model.Conta;
import cursojpa.model.Movimentacao;
import cursojpa.model.TipoMovimentacao;

@SuppressWarnings("unchecked")
public class MovimentacaoDAO {
	private final GenericDAO<Movimentacao> dao;
	private final EntityManager em;
	
	public MovimentacaoDAO(EntityManager em) {
		this.dao = new GenericDAO<Movimentacao>(em, Movimentacao.class);
		this.em = em;
	}

	public void adicionar(Movimentacao t) {
		dao.adicionar(t);
	}

	public Movimentacao buscar(long id) {
		return dao.buscar(id);
	}

	public boolean equals(Object obj) {
		return dao.equals(obj);
	}

	public void excluir(Movimentacao t) {
		dao.excluir(t);
	}

	public List<Movimentacao> listar() {
		return dao.listar();
	}
	
	
	public List<Movimentacao> filtrar(Conta conta) {
		String jpql = "SELECT t1 FROM Movimentacao t1 WHERE t1.conta = :pConta";
		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);
		return query.getResultList();
	}
	
	public List<Movimentacao> filtrar(Conta conta, TipoMovimentacao tipo) {
		String jpql = "SELECT t1 from Movimentacao t1 WHERE t1.conta = :pConta AND t1.tipo = :pTipo";
		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", tipo);
		
		return query.getResultList();
	}
	
	public double soma(Conta conta, TipoMovimentacao tipo) {
		String jpql = "SELECT SUM(t1.valor) FROM Movimentacao"
				+ " WHERE t1.conta = :pConta AND t1.tipo = :pTipo";
//		Query query = em.createQuery(jpql);
		TypedQuery<Double> query = em.createQuery(jpql, Double.class);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", tipo);
				
		return query.getSingleResult();
	}

}
