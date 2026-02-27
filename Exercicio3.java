package atividade;

import java.util.Calendar;
import java.util.Scanner;

public class Exercicio3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Calendar data = Calendar.getInstance();
		
		int dia, mes, ano;
		int somaDia, somaMes, somaAno, subDia, subMes, subAno;
		int op;
		
		System.out.println("Informe o dia: ");
		dia = scan.nextInt();
		System.out.println("Informe o mês: ");
		mes = scan.nextInt();
		System.out.println("Informe o ano: ");
		ano = scan.nextInt();
		
		data.set(ano, mes, dia);
		
		do {
			System.out.println("\nEscolha uma das seguintes opções:\n"
								+ "1 - Adicionar dias\n"
								+ "2 - Adicionar meses\n"
								+ "3 - Adicionar anos\n"
								+ "4 - Subtrair dias\n"
								+ "5 - Subtrair meses\n"
								+ "6 - Subtrair anos\n"
								+ "0 - Fechar");
			op = scan.nextInt();
		
			switch (op) {
				case 1:
					System.out.println("Quantos dias deseja adicionar? ");
					somaDia = scan.nextInt();
					dia += somaDia;
					break;
				case 2:
					System.out.println("Quantos meses deseja adicionar? ");
					somaMes = scan.nextInt();
					mes += somaMes;
					break;
				case 3:
					System.out.println("Quantos anos deseja adicionar? ");
					somaAno = scan.nextInt();
					ano += somaAno;
					break;
				case 4:
					System.out.println("Quantos dias deseja subtrairr? ");
					subDia = scan.nextInt();
					dia -= subDia;
					break;
				case 5:
					System.out.println("Quantos meses deseja subtrair? ");
					subMes = scan.nextInt();
					mes -= subMes;
					break;
				case 6:
					System.out.println("Quantos anos deseja subtrair? ");
					subAno = scan.nextInt();
					ano -= subAno;
					break;
				case 0:
					data.set(ano, mes, dia);
					System.out.println("Data final: " + data.get(Calendar.DAY_OF_MONTH) + "/"
													  + data.get(Calendar.MONTH) + "/"
													  + data.get(Calendar.YEAR));
					System.out.println("\nObrigado!");
					break;
				default:
					System.out.println("Opção inválida!");
					break;
			}
		} while (op != 0);

	}

}
