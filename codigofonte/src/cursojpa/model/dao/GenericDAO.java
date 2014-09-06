package cursojpa.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@SuppressWarnings("unchecked")
public class GenericDAO<T> {
	private EntityManager em;
	private Class<T> classe;
	
	public GenericDAO(EntityManager em, Class<T> classe) {
		super();
		this.em = em;
		this.classe = classe;
	}

	public void adicionar(T t) {
		em.persist(t);
	}
	
	public void excluir (T t) {
		em.remove(t);
	}

	public T buscar(Long id) {
		return em.getReference(classe, id);
	}
	
	public List<T> listar() {
		String jpql = "SELECT o FROM " + classe.getName() + " o";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}

}
