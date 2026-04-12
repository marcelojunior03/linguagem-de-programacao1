package exercicio1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		ArrayList<String> lista = new ArrayList<>();
		Localizacao loc = null;
		
		int op = 0;
		int idioma = 0;
		boolean repete = true;
		
		while(repete) {
			System.out.println("Escolha o idioma:\n"
							   + "1 - Português\n"
							   + "2 - Inglês");
			
			try {
				idioma = scan.nextInt();
				scan.nextLine();
				repete = false;
			}catch(InputMismatchException e){
				System.out.println("Formato inválido!");
				scan.nextLine();
			}

			if (idioma == 1) {
			    loc = new Localizacao("localizacao-pt.txt");
			    RegistroLog.registro("Usuário escolheu português.");
			} else if(idioma == 2) {
			    loc = new Localizacao("localizacao-en.txt");
			    RegistroLog.registro("Usuário escolheu inglês.");
			}
			else {
				System.out.println("Opção inválida!");
				repete = true;
			}
		}
		
		repete = true;
		
		Lista chamar = new Lista(lista, loc);
		
		do {
			while(repete) {
				System.out.println(loc.getTexto(0));
				System.out.println(loc.getTexto(1));
				System.out.println(loc.getTexto(2));
				System.out.println(loc.getTexto(3));
				System.out.println(loc.getTexto(4));
				System.out.println(loc.getTexto(5));
				System.out.println(loc.getTexto(6));
				System.out.println(loc.getTexto(7));
				System.out.println(loc.getTexto(8));
				
				try {
					op = scan.nextInt();
					scan.nextLine();
					repete = false;
				}catch(InputMismatchException e){
					System.out.println(loc.getTexto(9));
					scan.nextLine();
				}
			}
			
			repete = true;
		
			switch (op) {
				case 1:
					RegistroLog.registro("Usuário solicitou inserção de produto.");
					System.out.println(loc.getTexto(10));
					chamar.Inserir(scan.nextLine());
					RegistroLog.registro("Usuário inseriu o produto.");
					break;
				case 2:
					RegistroLog.registro("Usuário solicitou inserção de produto em posição específica.");
					System.out.println(loc.getTexto(11));
					int posicao = scan.nextInt();
					scan.nextLine();
					RegistroLog.registro("Usuário solicitou inserção de produto na posição " + posicao + ".");
					System.out.println(loc.getTexto(10));
					String nome = scan.nextLine();
					chamar.InserirEspecifico(posicao, nome);
					RegistroLog.registro("Usuário inseriu o produto.");
					break;
				case 3:
					RegistroLog.registro("Usuário solicitou consulta de produto por nome.");
					System.out.println(loc.getTexto(12));
					chamar.ConsultaNome(scan.nextLine());
					RegistroLog.registro("Usuário consultou o produto.");
					break;
				case 4:
					RegistroLog.registro("Usuário solicitou consulta de produto por posição.");
					System.out.println(loc.getTexto(13));
					chamar.ConsultaPosicao(scan.nextInt());
					scan.nextLine();
					RegistroLog.registro("Usuário consultou o produto.");
					break;
				case 5:
					RegistroLog.registro("Usuário solicitou substituição de produto.");
					System.out.println(loc.getTexto(14));
					int posicaoSub = scan.nextInt();
					scan.nextLine();
					RegistroLog.registro("Usuário selecionou a posição desejada.");
					System.out.println(loc.getTexto(15));
					String nomeNovo = scan.nextLine();
					chamar.Substituir(posicaoSub, nomeNovo);
					RegistroLog.registro("Usuário inseriu novo produto.");
					break;
				case 6:
					RegistroLog.registro("Usuário solicitou remoção de produto por nome.");
					System.out.println(loc.getTexto(16));
					chamar.RemoverNome(scan.nextLine());
					RegistroLog.registro("Usuário removeu o produto.");
					break;
				case 7:
					RegistroLog.registro("Usuário solicitou remoção de produto por posição.");
					System.out.println(loc.getTexto(17));
					chamar.RemoverPosicao(scan.nextInt());
					scan.nextLine();
					RegistroLog.registro("Usuário removeu o produto.");
					break;
				case 0:
					RegistroLog.registro("Usuário fechou o programa.");
					System.out.println(loc.getTexto(18));
					break;
				default:
					System.out.println(loc.getTexto(19));
					break;
			}
		} while (op != 0);

	}

}
