package cursojpa.tests;

import javax.persistence.EntityManager;

import cursojpa.JPAUtil;
import cursojpa.model.Movimentacao;
import cursojpa.model.dao.MovimentacaoDAO;

public class TesteBuscarIdMovimentacao {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		MovimentacaoDAO dao = new MovimentacaoDAO(em);
		em.getTransaction().begin();
		
		Movimentacao movimentacao = dao.buscar(new Long(1));
		System.out.println(movimentacao.getDescricao());
		
		em.getTransaction().commit();
		em.close();
	}

}
