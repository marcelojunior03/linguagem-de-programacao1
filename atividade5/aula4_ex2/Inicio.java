package aula4_ex2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Inicio {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int op = 0;
		boolean repete = true;
		
		do {
			while(repete) {
				System.out.println("Escolha uma das seguintes opções:\n"
									+ "1 - Retângulo\n"
									+ "2 - Círculo\n"
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
					double base = 0;
					double altura = 0;
					
					while(repete) {
						System.out.println("\nInsira a base do retângulo: ");
						try {
							base = scan.nextDouble();
							scan.nextLine();
							repete = false;
						}catch(InputMismatchException e){
							System.out.println("Formato inválido!");
							scan.nextLine();
						}
					}
					
					repete = true;
					
					while(repete) {
						System.out.println("\nInsira a altura do retângulo: ");
						try {
							altura = scan.nextDouble();
							scan.nextLine();
							repete = false;
						}catch(InputMismatchException e){
							System.out.println("Formato inválido!");
							scan.nextLine();
						}
					}
					
					repete = true;
					
					System.out.println("\nInsira a cor do retângulo: ");
					String corR = scan.nextLine();
					
					Retangulo r = new Retangulo(base, altura, corR);
					
					System.out.println("\nÁrea: " + r.getArea() +
									   "\nCor: " + r.getCor());
					break;
				case 2:
					double raio = 0;
					
					while(repete) {
						System.out.println("\nInsira o raio do círculo: ");
						try {
							raio = scan.nextDouble();
							scan.nextLine();
							repete = false;
						}catch(InputMismatchException e){
							System.out.println("Formato inválido!");
							scan.nextLine();
						}
					}
					
					repete = true;
					
					System.out.println("\nInsira a cor do círculo: ");
					String corC = scan.nextLine();
					
					Circulo c = new Circulo(raio, corC);
					
					System.out.println("\nÁrea: " + c.getArea() +
									   "\nCor: " + c.getCor());
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
