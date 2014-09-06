package cursojpa.tests;

import javax.persistence.EntityManager;

import cursojpa.JPAUtil;
import cursojpa.model.Tag;
import cursojpa.model.dao.TagDao;

public class TesteTagDao {
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		TagDao dao = new TagDao(em);
		
		Tag tag = dao.adicionarOuBuscarTag("Salario3");
		System.out.println(tag.getId()+" - "+tag.getNome());
		em.getTransaction().commit();
		em.close();
	}
}
