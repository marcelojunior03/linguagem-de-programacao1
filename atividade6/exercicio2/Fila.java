package exercicio2;

import java.util.LinkedList;

public class Fila {
	LinkedList<String> pessoas;
	
	public Fila(LinkedList fila) {
		pessoas = fila;
	}
	
	public void Inserir(String nome){
		pessoas.addLast(nome);
		System.out.println("\nNome adicionado com sucesso!");
	}
	
	public void Remover() {
		pessoas.pollFirst();
		System.out.println("\nPrimeira pessoa da fila removida com sucesso!");
	}
	
	public void ImprimirFila() {
		System.out.println("\nFila atual:\n");
		System.out.println(pessoas);
	}
}
