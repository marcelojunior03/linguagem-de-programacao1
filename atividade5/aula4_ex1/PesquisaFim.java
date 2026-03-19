package aula4_ex1;

public class PesquisaFim extends Pesquisa {
	@Override
	protected final boolean buscarString(String cadeiaCaracteres) {
		if(texto.endsWith(cadeiaCaracteres)) {
			existe = true;
		}
		else {
			existe = false;
		}
		return existe;
	}
}
