package exercicio2;

import java.util.Scanner;

public class Inicio {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int op;
		
		do {
			System.out.println("Escolha uma das seguintes opções:\n"
								+ "1 - Retângulo\n"
								+ "2 - Círculo\n"
								+ "0 - Fechar");
			op = scan.nextInt();
		
			switch (op) {
				case 1:
					System.out.println("\nInsira a base do retângulo: ");
					double base = scan.nextDouble();
					System.out.println("\nInsira a altura do retângulo: ");
					double altura = scan.nextDouble();
					scan.nextLine();
					System.out.println("\nInsira a cor do retângulo: ");
					String corR = scan.nextLine();
					
					Retangulo r = new Retangulo(base, altura, corR);
					
					System.out.println("\nÁrea: " + r.getArea() +
									   "\nCor: " + r.getCor());
					break;
				case 2:
					System.out.println("\nInsira o raio do círculo: ");
					double raio = scan.nextDouble();
					scan.nextLine();
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
