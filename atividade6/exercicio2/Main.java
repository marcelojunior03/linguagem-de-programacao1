package exercicio2;

import java.util.LinkedList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		LinkedList<String> fila = new LinkedList<>();
		Fila chamar = new Fila(fila);
		
		int op = 0;
		boolean repete = true;
		
		do {
			while(repete) {
				System.out.println("\nEscolha uma das seguintes opções:\n"
									+ "1 - Inserir pessoa\n"
									+ "2 - Remover pessoa\n"
									+ "3 - Imprimir fila\n"
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
					System.out.println("\nDigite o nome da pessoa que deseja inserir: ");
					chamar.Inserir(scan.nextLine());
					scan.nextLine();
					break;
				case 2:
					chamar.Remover();
					break;
				case 3:
					chamar.ImprimirFila();
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
