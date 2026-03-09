package exercicio2;

public class Conta {
	private int idConta, agencia;
	private String numeroConta;
	private Cliente titular;
	
	public Conta() {
		titular = new Cliente();
	}
	
	
	public int getIdConta() { 
		return idConta; 
	}
	public int getAgencia() { 
		return agencia; 
	}
	public String getNumeroConta() { 
		return numeroConta; 
	}
	public String getCliente() { 
		return titular.getCliente(); 
	}
	
	
	public void setIdConta(int idConta) { 
		this.idConta = idConta; 
	}
	public void setAgencia(int agencia) { 
		this.agencia = agencia; 
	}
	public void setNumeroConta(String numeroConta) { 
		this.numeroConta = numeroConta; 
	}
	public void setCliente(String nome, String cpf, String endereco, String email) { 
		titular.setCliente(nome, cpf, endereco, email);
	}
}
