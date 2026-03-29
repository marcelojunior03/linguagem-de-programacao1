package exercicio3;

import java.util.TreeSet;

public class Conjunto {
	
	public void inserir(TreeSet<String> conjunto, String[] produtos){
		for(String p : produtos) {
			if(!conjunto.contains(p)) {
				conjunto.add(p);
			}
		}
		
		System.out.println("\nProduto(s) adicionado(s) com sucesso!");
	}
	
	public TreeSet<String> uniao(TreeSet<String> c1, TreeSet<String> c2){
		TreeSet<String> produtos = new TreeSet<>(c1);
		produtos.addAll(c2);
		return produtos;
	}
	
	public TreeSet<String> interseccao(TreeSet<String> c1, TreeSet<String> c2) {
		TreeSet<String> produtos = new TreeSet<>(c1);
		produtos.retainAll(c2);
		return produtos;
	}
	
	public TreeSet<String> diferenca(TreeSet<String> c1, TreeSet<String> c2) {
		TreeSet<String> produtos = new TreeSet<>(c1);
		produtos.removeAll(c2);
		return produtos;
	}
	
	public boolean comum(TreeSet<String> c1, TreeSet<String> c2) {
		return c2.containsAll(c1);
	}
}
