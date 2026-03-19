package aula3_ex3;

public class PessoaFisica extends Cliente {
	private String nome, cpf;
	
	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
