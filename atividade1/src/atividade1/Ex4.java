package atividade1;

import java.util.Scanner;

public class Ex4 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Digite a distância a ser percorrida (Km): ");
		double distancia = Double.parseDouble(s.nextLine());
		
		System.out.println("Digite o preço do combustível: ");
		double preco = Double.parseDouble(s.nextLine());
		
		System.out.println("Digite o consumo de combustível do veículo (Km/litro): ");
		double consumo = Double.parseDouble(s.nextLine());
		
		s.close();
		
		double valor = (distancia/consumo) * preco;
		
		System.out.println("O valor gasto na viagem será de: R$" + valor);

	}

}
