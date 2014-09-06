package cursojpa.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import cursojpa.model.Conta;

public class ContaDAO {
	private GenericDAO<Conta> dao;

	public ContaDAO(EntityManager em) {
		this.dao = new GenericDAO<Conta>(em, Conta.class);
	}
	
	public void adicionar(Conta t) {
		dao.adicionar(t);
	}

	public void excluir(Conta t) {
		dao.excluir(t);
	}

	public Conta buscar(Long id) {
		return dao.buscar(id);
	}

	public List<Conta> listar() {
		return dao.listar();
	}
	
}
