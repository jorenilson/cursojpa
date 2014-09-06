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

public class TestePersistencia {
	public static void main(String[] args) {
		// Configura��o do EntityManager
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		// Configura��o do DAO
		MovimentacaoDAO movDAO = new MovimentacaoDAO(em);
		// Configura��o do Objeto a ser persistido
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Conta de �gua maio/2012");
		movimentacao.setTipo(TipoMovimentacao.SAIDA);
		movimentacao.setValor(BigDecimal.valueOf(53.40));
		
		
		Conta conta = new Conta();
		conta.setAgencia("2112");
		conta.setBanco("Santander");
		conta.setNumero(0100212231);
		conta.setTitular("Maria da Silva");

		ContaDAO contaDao = new ContaDAO(em);
		contaDao.adicionar(conta);
		
		
		
		// Invocando a persist�ncia
		movDAO.adicionar(movimentacao);
		movimentacao.setConta(conta);
		em.getTransaction().commit();
		em.close();

	}
}
