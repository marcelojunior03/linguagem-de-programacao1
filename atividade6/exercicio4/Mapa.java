package exercicio4;

import java.util.HashMap;
import java.util.Map;

public class Mapa {
	HashMap<String, Double> produtos;
	
	public Mapa(HashMap mapa) {
		produtos = mapa;
	}
	
	public void inserir(String nome, double preco) {
		produtos.put(nome, preco);
		System.out.println("\nProduto adicionado com sucesso!");
	}
	
	public void consultarTudo() {
		System.out.println(produtos);
	}
	
	public void consultarNomes() {
		System.out.println("\nProdutos: " + produtos.keySet());
	}
	
	public void consultarPrecos() {
		System.out.println("\nPreços: " + produtos.values());
	}
	
	public void consultarPrecoNome(String nome) {
		System.out.println("\nPreço do produto: " + produtos.get(nome));
	}
	
	public void consultarSeExiste(String nome) {
		if(produtos.containsKey(nome)) {
			System.out.println("\nO produto existe no mapa!");
		}
		else {
			System.out.println("\nO produto não existe no mapa!");
		}
	}
	
	public void consultarProdutosPrecos(double preco) {
		if(produtos.containsValue(preco)) {
			System.out.println("\nProdutos: ");
			for (Map.Entry<String, Double> valor : produtos.entrySet()) {
	            if (valor.getValue().equals(preco)) {
	                System.out.println(valor.getKey());
	            }
			}
		}
		else {
			System.out.println("\nNão existe produtos com esse valor!");
		}
	}
	
	public void alterarPreco(String nome, double novoPreco) {
		if(produtos.containsKey(nome)) {
			produtos.put(nome, novoPreco);
			System.out.println("\nPreço alterado com sucesso!");
		}
		else {
			System.out.println("\nO produto não existe no mapa!");
		}
	}
	
	public void remover(String nome) {
		if(produtos.containsKey(nome)) {
			produtos.remove(nome);
			System.out.println("\nProduto removido com sucesso!");
		}
		else {
			System.out.println("\nO produto não existe no mapa!");
		}
	}
}
