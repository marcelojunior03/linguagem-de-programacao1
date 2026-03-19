package aula4_ex1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Inicio {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Pesquisa t = new Pesquisa();
		PesquisaInicio i = new PesquisaInicio();
        PesquisaFim f = new PesquisaFim();
		
		int op = 0;
		boolean repete = true;
		
		do {
			while(repete) {
				System.out.println("Escolha uma das seguintes opções:\n"
									+ "1 - Informar texto\n"
									+ "2 - Buscar string\n"
									+ "3 - Buscar string no início\n"
									+ "4 - Buscar string no fim\n"
									+ "0 - Fechar");
				try {
					op = scan.nextInt();
					scan.nextLine();
					repete = false;
				}catch(InputMismatchException e){
					System.out.println("Formato inválido!");
					scan.nextLine();
				}finally {
			        System.out.println("Leitura do menu concluída.");
			    }
			}
			
			repete = true;
		
			switch (op) {
				case 1:
					System.out.println("\nInforme o texto desejado: ");
					String texto = scan.nextLine();
					t.setTexto(texto);
					i.setTexto(texto);
					f.setTexto(texto);
					break;
				case 2:
					System.out.println("\nQual string deseja procurar? ");
					boolean existe = t.buscarString(scan.nextLine());
					if(existe) {
						System.out.println("\nA string existe no texto.");
					}
					else {
						System.out.println("\nA string não existe no texto.");
					}
					break;
				case 3:
					System.out.println("\nQual string deseja procurar? ");
					boolean existeInicio = i.buscarString(scan.nextLine());
					if(existeInicio) {
						System.out.println("\nA string existe no início do texto.");
					}
					else {
						System.out.println("\nA string não existe no início do texto.");
					}
					break;
				case 4:
					System.out.println("\nQual string deseja procurar? ");
					boolean existeFim = f.buscarString(scan.nextLine());
					if(existeFim) {
						System.out.println("\nA string existe no fim do texto.");
					}
					else {
						System.out.println("\nA string não existe no fim do texto.");
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
