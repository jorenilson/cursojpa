package cursojpa.tests;

import java.util.List;

import javax.persistence.EntityManager;

import cursojpa.JPAUtil;
import cursojpa.model.Conta;
import cursojpa.model.Movimentacao;
import cursojpa.model.dao.ContaDAO;

public class TesteBidirecional {
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();

		ContaDAO contadao = new ContaDAO(em);
		
		Conta conta = contadao.buscar(12l);
		List<Movimentacao> litmvto = conta.getLisMovimentacaos();
		
		/*
		for (Movimentacao movimentacao : litmvto) {
			System.out.println(movimentacao.getValor());
		}*/

		

	}
}
