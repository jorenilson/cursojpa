package cursojpa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Conta {

	@Id
	@GeneratedValue
	private Long id;
	private String agencia;
	private String banco;
	private String titular;
	private double saldo;
	private int numero;
	@OneToMany(mappedBy="conta")
	private List<Movimentacao> lisMovimentacaos = new ArrayList<Movimentacao>();
	

	public List<Movimentacao> getLisMovimentacaos() {
		return lisMovimentacaos;
	}

	public void setLisMovimentacaos(List<Movimentacao> lisMovimentacaos) {
		this.lisMovimentacaos = lisMovimentacaos;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	
}
