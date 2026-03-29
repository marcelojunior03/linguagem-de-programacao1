package exercicio3;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		TreeSet<String> conjunto1 = new TreeSet<>();
		TreeSet<String> conjunto2 = new TreeSet<>();
		Conjunto chamar = new Conjunto();
		
		int op = 0;
		boolean repete = true;
		
		do {
			while(repete) {
				System.out.println("Escolha uma das seguintes opções:\n"
									+ "1 - Inserir produtos no 1º conjunto\n"
									+ "2 - Inserir produto no 2º conjunto\n"
									+ "3 - Consultar todos produtos dos dois conjuntos\n"
									+ "4 - Consultar apenas produtos em comum nos dois conjuntos\n"
									+ "5 - Consultar produtos do 1º conjunto que não existem no 2º conjunto\n"
									+ "6 - Consultar se o 1º conjunto está contido no 2º conjunto\n"
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
					System.out.println("\nQuantos produtos deseja inserir no conjunto 1? : ");
					int quantos1 = scan.nextInt();
					scan.nextLine();
					
					String[] p1 = new String[quantos1];
					for(int i = 0; i < quantos1; i++) {
						System.out.println("\nDigite o nome do produto " + (i+1) + ": ");
						p1[i] = scan.nextLine();
					}
					
					chamar.inserir(conjunto1, p1);
					break;
				case 2:
					System.out.println("\nQuantos produtos deseja inserir no conjunto 2? : ");
					int quantos2 = scan.nextInt();
					scan.nextLine();
					
					String[] p2 = new String[quantos2];
					for(int i = 0; i < quantos2; i++) {
						System.out.println("\nDigite o nome do produto " + (i+1) + ": ");
						p2[i] = scan.nextLine();
					}
					
					chamar.inserir(conjunto2, p2);
					break;
				case 3:
					System.out.println("\nUnião dos produtos: " + chamar.uniao(conjunto1, conjunto2));
					break;
				case 4:
					System.out.println("\nProdutos em comum: " + chamar.interseccao(conjunto1, conjunto2));
					break;
				case 5:
					System.out.println("\nDiferença nos conjuntos: " + chamar.diferenca(conjunto1, conjunto2));
					break;
				case 6:
					if(chamar.comum(conjunto1, conjunto2)) {
						System.out.println("\nO conjunto 1 existe no conjunto 2!");
					}
					else {
						System.out.println("\nO conjunto 1 não existe no conjunto 2!");
					}
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
