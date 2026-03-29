package exercicio1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		ArrayList<String> lista = new ArrayList<>();
		Lista chamar = new Lista(lista);
		
		int op = 0;
		boolean repete = true;
		
		do {
			while(repete) {
				System.out.println("Escolha uma das seguintes opções:\n"
									+ "1 - Inserir produto\n"
									+ "2 - Inserir produto em posição específica\n"
									+ "3 - Consultar produto (pelo nome)\n"
									+ "4 - Consultar produto (pela posição)\n"
									+ "5 - Substituir produto\n"
									+ "6 - Remover produto (pelo nome)\n"
									+ "7 - Remover produto (pela posição)\n"
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
					System.out.println("\nDigite o nome do produto: ");
					chamar.Inserir(scan.nextLine());
					scan.nextLine();
					break;
				case 2:
					System.out.println("\nEm qual posição deseja inserir o produto? ");
					int posicao = scan.nextInt();
					scan.nextLine();
					System.out.println("\nDigite o nome do produto: ");
					String nome = scan.nextLine();
					scan.nextLine();
					chamar.InserirEspecifico(posicao, nome);
					break;
				case 3:
					System.out.println("\nDigite o nome do produto que procura: ");
					chamar.ConsultaNome(scan.nextLine());
					scan.nextLine();
					break;
				case 4:
					System.out.println("\nDigite a posição do produto que procura: ");
					chamar.ConsultaPosicao(scan.nextInt());
					scan.nextLine();
					break;
				case 5:
					System.out.println("\nDeseja substituir o produto de qual posição? ");
					int posicaoSub = scan.nextInt();
					scan.nextLine();
					System.out.println("\nDigite o nome do produto novo: ");
					String nomeNovo = scan.nextLine();
					scan.nextLine();
					chamar.Substituir(posicaoSub, nomeNovo);
					break;
				case 6:
					System.out.println("\nDigite o nome do produto que deseja remover: ");
					chamar.RemoverNome(scan.nextLine());
					scan.nextLine();
					break;
				case 7:
					System.out.println("\nDigite a posição do produto que deseja remover: ");
					chamar.RemoverPosicao(scan.nextInt());
					scan.nextLine();
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
