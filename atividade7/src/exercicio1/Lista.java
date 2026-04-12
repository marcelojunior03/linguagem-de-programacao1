package exercicio1;

import java.util.ArrayList;

public class Lista {
	ArrayList<String> produtos;
	
	Localizacao loc;
	
	public Lista(ArrayList lista, Localizacao loc) {
		produtos = lista;
		this.loc = loc;
	}
	
	public void Inserir(String nome){
		produtos.add(nome);
		System.out.println(loc.getTexto(20));
	}
	
	public void InserirEspecifico(int posicao, String nome){
		produtos.add(posicao-1, nome);
		System.out.println(loc.getTexto(20));
	}
	
	public void ConsultaNome(String nome) {
		if(produtos.contains(nome)) {
			System.out.println(loc.getTexto(21));
		}
		else {
			System.out.println(loc.getTexto(22));
		}
	}
	
	public void ConsultaPosicao(int posicao) {
		if(produtos.size() < posicao) {
			System.out.println(loc.getTexto(23));
		}
		else {
			System.out.println(loc.getTexto(24) + produtos.get(posicao-1));
		}
	}
	
	public void Substituir(int posicao, String nomeNovo) {
		produtos.set(posicao-1, nomeNovo);
		System.out.println(loc.getTexto(25));
	}
	
	public void RemoverNome(String nome) {
		if(produtos.contains(nome)) {
			produtos.remove(nome);
			System.out.println(loc.getTexto(26));
		}
		else {
			System.out.println(loc.getTexto(27));
		}
	}
	
	public void RemoverPosicao(int posicao) {
		if(produtos.size() < posicao) {
			System.out.println(loc.getTexto(23));
		}
		else {
			produtos.remove(posicao-1);
			System.out.println(loc.getTexto(26));
		}
	}
}
