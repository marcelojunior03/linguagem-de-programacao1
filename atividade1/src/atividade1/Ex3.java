package atividade1;

import java.util.Scanner;

public class Ex3 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Digite o valor do produto: ");
		double valor = Double.parseDouble(s.nextLine());
		
		System.out.println("Qual a porcentagem de desconto? ");
		double desconto = Double.parseDouble(s.nextLine());
		
		s.close();
		
		double valorFinal = valor - (valor * (desconto/100));
		
		System.out.println("O valor final do produto é: R$" + valorFinal);

	}

}
