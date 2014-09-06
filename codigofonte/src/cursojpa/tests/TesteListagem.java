package cursojpa.tests;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import cursojpa.JPAUtil;
import cursojpa.model.Conta;
import cursojpa.model.Movimentacao;
import cursojpa.model.TipoMovimentacao;
import cursojpa.model.dao.ContaDAO;
import cursojpa.model.dao.MovimentacaoDAO;

@SuppressWarnings("unchecked")
public class TesteListagem {
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();

		Conta conta = new Conta();
		Movimentacao movimentacao = new Movimentacao();
		ContaDAO contaDao = new ContaDAO(em);

		em.getTransaction().begin();

		conta = contaDao.buscar(13l);
		if (conta.getId()==null) {
			conta.setAgencia("2626");
			conta.setBanco("Santander");
			conta.setNumero(0100212231);
			conta.setTitular("Pablo da Silva");
			contaDao.adicionar(conta);
		} else {
			movimentacao.setData(Calendar.getInstance());
			movimentacao.setDescricao("Conta de Água maio/2012");
			movimentacao.setTipo(TipoMovimentacao.SAIDA);
			movimentacao.setValor(BigDecimal.valueOf(53.40));
			movimentacao.setConta(conta);
			MovimentacaoDAO mvtoDao = new MovimentacaoDAO(em);
			mvtoDao.adicionar(movimentacao);
		}
		em.getTransaction().commit();
		em.close();

	}
}
