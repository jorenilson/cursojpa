package cursojpa.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import cursojpa.model.Tag;

public class TagDao {
	private final EntityManager em;
	public TagDao(EntityManager em){
		this.em=em;
	}
	
	public Tag adicionarOuBuscarTag(String nome){
		String jpql = "select t from Tag t "+
				"where t.nome =:pNome ";
		TypedQuery<Tag> query = em.createQuery(jpql, Tag.class);
		query.setParameter("pNome", nome);
		Tag tag = null;
		try{
			//Consulta a tag
			tag = query.getSingleResult();
		}catch(NoResultException exception){
			//Cadastra a tag
			tag = new Tag();
			tag.setNome(nome);
			em.persist(tag);
		}
		return tag;
	}
}
