package aula4_ex1;

public class Pesquisa {
	protected String texto;
	protected boolean existe;
	
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	protected boolean buscarString(String cadeiaCaracteres) {
		if(texto.contains(cadeiaCaracteres)) {
			existe = true;
		}
		else {
			existe = false;
		}
		return existe;
	}
}
