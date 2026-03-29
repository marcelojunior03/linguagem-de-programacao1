package exercicio4;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		HashMap<String, Double> mapa = new HashMap<>();
		Mapa chamar = new Mapa(mapa);
		
		int op = 0;
		boolean repete = true;
		
		do {
			while(repete) {
				System.out.println("Escolha uma das seguintes opções:\n"
									+ "1 - Inserir produto\n"
									+ "2 - Consultar nomes e preços dos produtos\n"
									+ "3 - Consultar somente os nomes dos produtos\n"
									+ "4 - Consultar somente os preços dos produtos\n"
									+ "5 - Consultar preço de produto (pelo nome)\n"
									+ "6 - Consultar se produto existe (pelo nome)\n"
									+ "7 - Consultar produtos com um determinado preço\n"
									+ "8 - Alterar preço do produto\n"
									+ "9 - Remover produto\n"
									+ "0 - Fechar");
				try {
					op = scan.nextInt();
					scan.nextLine();
					repete = false;
				}catch(InputMismatchException e){
					System.out.println("Formato inválido!");
					scan.nextLine();
				}
			}
			
			repete = true;
		
			switch (op) {
				case 1:
					System.out.println("\nDigite o nome do produto que deseja inserir: ");
					String nome = scan.nextLine();
					
					System.out.println("\nDigite o preço do produto: ");
					double preco = scan.nextDouble();
					scan.nextLine();
					
					chamar.inserir(nome, preco);
					break;
				case 2:
					chamar.consultarTudo();
					break;
				case 3:
					chamar.consultarNomes();
					break;
				case 4:
					chamar.consultarPrecos();
					break;
				case 5:
					System.out.println("\nDigite o nome do produto que deseja saber o preço: ");
					String nomeConsultaPreco = scan.nextLine();
					
					chamar.consultarPrecoNome(nomeConsultaPreco);
					break;
				case 6:
					System.out.println("\nDigite o nome do produto que deseja conferir: ");
					String nomeConsulta = scan.nextLine();
					
					chamar.consultarSeExiste(nomeConsulta);
					break;
				case 7:
					System.out.println("\nDigite o preço dos produtos que deseja conferir: ");
					double precoConsulta = scan.nextDouble();
					scan.nextLine();
					
					chamar.consultarProdutosPrecos(precoConsulta);
					break;
				case 8:
					System.out.println("\nDigite o nome do produto que deseja alterar o preço: ");
					String nomeParaAlterar = scan.nextLine();
					
					System.out.println("\nDigite o novo preço do produto: ");
					double precoAlterado = scan.nextDouble();
					
					chamar.alterarPreco(nomeParaAlterar, precoAlterado);
					break;
				case 9:
					System.out.println("\nDigite o nome do produto que remover: ");
					String nomeParaRemover = scan.nextLine();
					
					chamar.remover(nomeParaRemover);
					break;
				case 0:
					System.out.println("Obrigado!");
					break;
				default:
					System.out.println("Opção inválida!");
					break;
			}
		} while (op != 0);

	}

}
