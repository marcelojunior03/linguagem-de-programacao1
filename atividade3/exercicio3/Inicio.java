package exercicio3;

import java.util.Scanner;

public class Inicio {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		PessoaFisica[] pf = new PessoaFisica[10];
        PessoaJuridica[] pj = new PessoaJuridica[10];
		
		int op;
		int codigo = 1;
		
		do {
			System.out.println("Escolha uma das seguintes opções:\n"
								+ "1 - Inserir cliente\n"
								+ "2 - Remover cliente\n"
								+ "3 - Consultar clientes\n"
								+ "0 - Fechar");
			op = scan.nextInt();
		
			switch (op) {
				case 1:
					System.out.println("\nDigite 1 se o cliente for PF ou 2 se for PJ: ");
					int pfpj = scan.nextInt();
					
					if(pfpj == 1) {
						for(int i = 0; i < pf.length; i++) {
							if(pf[i] == null) {
								PessoaFisica f = new PessoaFisica();
								
								System.out.println("\nInforme o nome: ");
								f.setNome(scan.next());
								
								System.out.println("\nInforme o CPF: ");
								f.setCpf(scan.next());
								
								System.out.println("\nInforme o endereço: ");
								f.setEndereco(scan.next());
								
								System.out.println("\nInforme o telefone: ");
								f.setTelefone(scan.next());
								
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
									j.setRazaoSocial(scan.next());
									
									System.out.println("\nInforme o CNPJ: ");
									j.setCnpj(scan.next());
									
									System.out.println("\nInforme o endereço: ");
									j.setEndereco(scan.next());
									
									System.out.println("\nInforme o telefone: ");
									j.setTelefone(scan.next());
									
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
					System.out.println("\nDigite 1 se o cliente for PF ou 2 se for PJ: ");
					int pfpj2 = scan.nextInt();
					
					System.out.println("\nInforme o código do cliente: ");
					int codi = scan.nextInt();
					
					if(pfpj2 == 1) {
						boolean achou = false;
						
						for(int i = 0; i < pf.length; i++) {
							if(pf[i] != null && pf[i].getCodigo() == codi) {
								pf[i] = null;
								achou = true;
								break;
							}
						}
						
						if(achou == true) {
							System.out.println("\nCliente removido com sucesso.");
						}
						else {
							System.out.println("\nCódigo inválido!");
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
							
							if(achou == true) {
								System.out.println("\nCliente removido com sucesso.");
							}
							else {
								System.out.println("\nCódigo inválido!");
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
		} while (op != 0);

	}

}
