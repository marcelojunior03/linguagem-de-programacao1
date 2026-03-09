package exercicio2;

public class Testes {

	public static void main(String[] args) {
		Conta conta = new Conta();
		
		conta.setIdConta(2);
		conta.setAgencia(1);
		conta.setNumeroConta("35");
		conta.setCliente("Marcelo Jr", "11122233344", "Av. Paulista, 40", "heiffig.marcelo@aluno.ifsp.edu.br");
		
		System.out.println("Dados da conta:");
		System.out.println("\nCódigo: " + conta.getIdConta() +
						   "\nAgência: " + conta.getAgencia() +
						   "\nNúmero da conta: " + conta.getNumeroConta() +
						   "\nDados do cliente: " + conta.getCliente());
		
		conta = new Conta();
		
		System.out.println("\nDados da conta:");
		System.out.println("\nCódigo: " + conta.getIdConta() +
						   "\nAgência: " + conta.getAgencia() +
						   "\nNúmero da conta: " + conta.getNumeroConta() +
						   "\nDados do cliente: " + conta.getCliente());

	}

}
