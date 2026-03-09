package exercicio2;

public class Cliente {
	private String nome, cpf, endereco, email;
	
	public String getCliente() {
		return ("\n\tNome: " + nome +
				"\n\tCPF: " + cpf +
				"\n\tEndereço: " + endereco +
				"\n\tE-mail: " + email);
	}
	
	public void setCliente(String nome, String cpf, String endereco, String email) {
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.email = email;
	}
}
