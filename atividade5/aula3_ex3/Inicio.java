package aula3_ex3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Inicio {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		PessoaFisica[] pf = new PessoaFisica[10];
        PessoaJuridica[] pj = new PessoaJuridica[10];
		
		int op = 0;
		int codigo = 1;
		boolean repete = true;
		
		do {
			while(repete) {
				System.out.println("Escolha uma das seguintes opções:\n"
									+ "1 - Inserir cliente\n"
									+ "2 - Remover cliente\n"
									+ "3 - Consultar clientes\n"
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
			
			try {
				switch (op) {
					case 1:
						int pfpj = 0;
						while(repete) {
							try {
								System.out.println("\nDigite 1 se o cliente for PF ou 2 se for PJ: ");
								pfpj = scan.nextInt();
								scan.nextLine();
								repete = false;
							}catch(InputMismatchException e){
								System.out.println("Formato inválido!");
								scan.nextLine();
							}
						}
						
						repete = true;
						
						if(pfpj == 1) {
							for(int i = 0; i < pf.length; i++) {
								if(pf[i] == null) {
									PessoaFisica f = new PessoaFisica();
									
									System.out.println("\nInforme o nome: ");
									f.setNome(scan.nextLine());
									
									System.out.println("\nInforme o CPF: ");
									f.setCpf(scan.nextLine());
									
									System.out.println("\nInforme o endereço: ");
									f.setEndereco(scan.nextLine());
									
									System.out.println("\nInforme o telefone: ");
									f.setTelefone(scan.nextLine());
									
									f.setCodigo(codigo);
	
	                                pf[i] = f;
	
	                                codigo++;
	
	                                System.out.println("Cliente inserido com sucesso.");
	                                break;
								}
							}
						}
						else {
							if(pfpj == 2) {
								for(int i = 0; i < pj.length; i++) {
									if(pj[i] == null) {
										PessoaJuridica j = new PessoaJuridica();
										
										System.out.println("\nInforme a Razão Social: ");
										j.setRazaoSocial(scan.nextLine());
										
										System.out.println("\nInforme o CNPJ: ");
										j.setCnpj(scan.nextLine());
										
										System.out.println("\nInforme o endereço: ");
										j.setEndereco(scan.nextLine());
										
										System.out.println("\nInforme o telefone: ");
										j.setTelefone(scan.nextLine());
										
										j.setCodigo(codigo);
	
		                                pj[i] = j;
	
		                                codigo++;
	
		                                System.out.println("Cliente inserido com sucesso.");
		                                break;
									}
								}
							}
							else {
								System.out.println("\nOpção inválida!");
							}
						}
						break;
					case 2:
						int pfpj2 = 0;
						while(repete) {
							try {
								System.out.println("\nDigite 1 se o cliente for PF ou 2 se for PJ: ");
								pfpj2 = scan.nextInt();
								scan.nextLine();
								repete = false;
							}catch(InputMismatchException e){
								System.out.println("Formato inválido!");
								scan.nextLine();
							}
						}
						
						repete = true;
						
						int codi = 0;
						while(repete) {
							try {
								System.out.println("\nInforme o código do cliente: ");
								codi = scan.nextInt();
								scan.nextLine();
								repete = false;
							}catch(InputMismatchException e){
								System.out.println("Formato inválido!");
								scan.nextLine();
							}
						}
						
						if(pfpj2 == 1) {
							boolean achou = false;
							
							for(int i = 0; i < pf.length; i++) {
								if(pf[i] != null && pf[i].getCodigo() == codi) {
									pf[i] = null;
									achou = true;
									break;
								}
							}
							
							if (achou == false) {
			                    throw new IndexOutOfBoundsException("Código não encontrado para PF!");
			                }
							else {
								System.out.println("\nCliente removido com sucesso.");
							}
						}
						else {
							if(pfpj2 == 2) {
								boolean achou = false;
								
								for(int i = 0; i < pj.length; i++) {
									if(pj[i] != null && pj[i].getCodigo() == codi) {
										pj[i] = null;
										achou = true;
										break;
									}
								}
								
								if (achou == false) {
				                    throw new IndexOutOfBoundsException("Código não encontrado para PF!");
				                }
								else {
									System.out.println("\nCliente removido com sucesso.");
								}
							}
							else {
								System.out.println("\nOpção inválida!");
							}
						}
						break;
					case 3:
						System.out.println("\nPessoas físicas:");
						
						for(int i = 0; i < pf.length; i++) {
							if(pf[i] != null) {
								System.out.println("\nCódigo: " + pf[i].getCodigo() +
												   "\nNome: " + pf[i].getNome() + 
												   "\nCPF: " + pf[i].getCpf() +
												   "\nEndereço: " + pf[i].getEndereco() +
												   "\nTelefone: " + pf[i].getTelefone());
							}
						}
						
						System.out.println("\nPessoas jurídicas:");
						
						for(int i = 0; i < pj.length; i++) {
							if(pj[i] != null) {
								System.out.println("\nCódigo: " + pj[i].getCodigo() +
												   "\nRazão social: " + pj[i].getRazaoSocial() + 
												   "\nCNPJ: " + pj[i].getCnpj() +
												   "\nEndereço: " + pj[i].getEndereco() +
												   "\nTelefone: " + pj[i].getTelefone());
							}
						}
						break;
					case 0:
						System.out.println("Obrigado!");
						break;
					default:
						System.out.println("Opção inválida!");
						break;
				}
			}catch(IndexOutOfBoundsException e) {
			    System.out.println("Erro: " + e.getMessage());
			}
		} while (op != 0);

	}

}
