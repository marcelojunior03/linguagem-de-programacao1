package exercicio1;

import java.util.ArrayList;

public class Lista {
	ArrayList<String> produtos;
	
	public Lista(ArrayList lista) {
		produtos = lista;
	}
	
	public void Inserir(String nome){
		produtos.add(nome);
		System.out.println("\nProduto adicionado com sucesso!");
	}
	
	public void InserirEspecifico(int posicao, String nome){
		produtos.add(posicao-1, nome);
		System.out.println("\nProduto adicionado com sucesso!");
	}
	
	public void ConsultaNome(String nome) {
		if(produtos.contains(nome)) {
			System.out.println("\nO produto está na lista!");
		}
		else {
			System.out.println("\nO produto não está na lista!");
		}
	}
	
	public void ConsultaPosicao(int posicao) {
		if(produtos.size() < posicao) {
			System.out.println("\nA posição não existe na lista!");
		}
		else {
			System.out.println("\nProduto presente na posição " + posicao + ": " + produtos.get(posicao-1));
		}
	}
	
	public void Substituir(int posicao, String nomeNovo) {
		produtos.set(posicao-1, nomeNovo);
		System.out.println("\nSubstituição feita com sucesso!");
	}
	
	public void RemoverNome(String nome) {
		if(produtos.contains(nome)) {
			produtos.remove(nome);
			System.out.println("\nProduto removido com sucesso!");
		}
		else {
			System.out.println("\nProduto não encontrado!");
		}
	}
	
	public void RemoverPosicao(int posicao) {
		if(produtos.size() < posicao) {
			System.out.println("\nA posição não existe na lista!");
		}
		else {
			produtos.remove(posicao-1);
			System.out.println("\nProduto removido com sucesso!");
		}
	}
}
