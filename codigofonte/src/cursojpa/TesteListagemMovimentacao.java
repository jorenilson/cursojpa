package cursojpa;

import javax.persistence.EntityManager;

import cursojpa.model.Conta;
import cursojpa.model.Movimentacao;
import cursojpa.model.TipoMovimentacao;
import cursojpa.model.dao.ContaDAO;
import cursojpa.model.dao.MovimentacaoDAO;

public class TesteListagemMovimentacao {
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		
		MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO(em);
//		Conta conta = new Conta();
//		conta.setId(1);
//		conta.setSaldo(100);
		
		ContaDAO contaDAO = new ContaDAO(em);
		Conta conta = contaDAO.buscar(1l);
		
//		for (Movimentacao movimentacao : movimentacaoDAO.filtrar(conta)) {
//			System.out.println(movimentacao.getId() + ". " + movimentacao.getDescricao() + " = " + conta.getSaldo());
//		}
		movimentacaoDAO.soma(conta, TipoMovimentacao.ENTRADA);
		
		em.close();
	}
	
}
