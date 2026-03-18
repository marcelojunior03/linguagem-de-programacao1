package aula3_ex1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Inicio {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Produto p = new Produto();
		int disponibilidade = 0;
		
		try {
			System.out.println("\nDigite o código do produto: ");
			p.setCodigo(scan.nextInt());
			System.out.println("\nO novo código do produto é: " + p.getCodigo());
		}catch(InputMismatchException e) {
			System.out.println("Ocorreu o segunti erro: " + e.getMessage());
		}
		
			System.out.println("\nDescreva o produto: ");
			p.setDescricao(scan.next());
			System.out.println("\nDescrição do produto: " + p.getDescricao());
		
		try {
			System.out.println("\nInforme o preço do produto: ");
			p.setPreco(scan.nextFloat());
			System.out.println("\nO novo valor do produto é: R$" + p.getPreco());
		}catch(InputMismatchException e) {
			System.out.println("Ocorreu o segunti erro: " + e.getMessage());
		}
		
		try {
			System.out.println("\nDigite 1 se o produto estiver disponível ou 0 se o produto estiver indisponível: ");
			disponibilidade = scan.nextInt();
			if(disponibilidade == 1) {
				p.setAtivo(true);
				System.out.println("O produto está disponível!");
			}
			else {
				p.setAtivo(false);
				System.out.println("O produto está indisponível!");
			}
		}catch(InputMismatchException e) {
			System.out.println("Ocorreu o segunti erro: " + e.getMessage());
		}

	}

}
