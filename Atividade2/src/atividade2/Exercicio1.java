package atividade2;

import java.util.Scanner;

public class Exercicio1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int op;
		
		do {
			System.out.println("Escolha uma das seguintes opções:\n"
								+ "1 - Arredondar número\n"
								+ "2 - Calcular raíz quadrada\n"
								+ "3 - Calcular a potência\n"
								+ "0 - Fechar");
			op = scan.nextInt();
		
			switch (op) {
				case 1:
					System.out.println("Digite o valor decimal a ser arredondado: ");
					double numero1 = scan.nextDouble();
					System.out.println("Valor arredondado: " + Math.round(numero1));
					break;
				case 2:
					System.out.println("Digite um número maior ou igual a 0: ");
					double numero2 = scan.nextDouble();
					if(numero2 < 0) {
						System.out.println("O número digitado não é válido!");
					}
					else {
						System.out.println("A raíz quadrada é: " + Math.sqrt(numero2));
					}
					break;
				case 3:
					System.out.println("Digite a base: ");
					double base = scan.nextDouble();
					System.out.println("Digite o expoente: ");
					double expo = scan.nextDouble();
					System.out.println("O resultado da potência é: " + Math.pow(base, expo));
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
