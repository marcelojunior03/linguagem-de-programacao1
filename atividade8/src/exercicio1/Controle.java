package exercicio1;

import java.util.ArrayList;
import java.util.List;

public class Controle {
	private List<Produto> produtosComEstoqueInsuficiente, produtosComEstoqueExcedente, produtosComEstoqueZerado, produtosComEstoqueAdequado;
	
	public void controlaEstoques(Estoque estoque) {
	    produtosComEstoqueInsuficiente = new ArrayList<>();
	    produtosComEstoqueExcedente = new ArrayList<>();
	    produtosComEstoqueZerado = new ArrayList<>();
	    produtosComEstoqueAdequado = new ArrayList<>();
	    
	    for(Produto p : estoque.getProdutos()) {
	    	double quantidade = p.getQuantidade();
	    	
	    	if(quantidade == 0) {
	    		produtosComEstoqueZerado.add(p);
	    	} else if (quantidade < p.getEstoqueMinimo()) {
	            produtosComEstoqueInsuficiente.add(p);
	        } else if (quantidade > p.getEstoqueMaximo()) {
	            produtosComEstoqueExcedente.add(p);
	        } else {
	            produtosComEstoqueAdequado.add(p);
	        }
	    }

	}
	
	public List<Produto> getProdutosComEstoqueInsuficiente(){
		return produtosComEstoqueInsuficiente;
	}
	
	public List<Produto> getProdutosComEstoqueExcedente(){
		return produtosComEstoqueExcedente;
	}
	
	public List<Produto> getProdutosComEstoqueZerado(){
		return produtosComEstoqueZerado;
	}
	
	public List<Produto> getProdutosComEstoqueAdequado(){
		return produtosComEstoqueAdequado;
	}
}
