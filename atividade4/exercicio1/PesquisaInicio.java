package exercicio1;

public class PesquisaInicio extends Pesquisa {
	@Override
	protected final boolean buscarString(String cadeiaCaracteres) {
		if(texto.startsWith(cadeiaCaracteres)) {
			existe = true;
		}
		else {
			existe = false;
		}
		return existe;
	}
}
