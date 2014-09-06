package cursojpa.tests;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;

import cursojpa.JPAUtil;
import cursojpa.model.Conta;
import cursojpa.model.dao.ContaDAO;

public class TesteConta {
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();

		ContaDAO contaDAO = new ContaDAO(em);
		Conta conta = new Conta();
		conta.setTitular("Juliane");
		conta.setAgencia("1549");
		conta.setSaldo(500);

		contaDAO.adicionar(conta);

		Assert.assertNotNull(conta.getId());

		em.getTransaction().commit();
		em.close();
	}
}
