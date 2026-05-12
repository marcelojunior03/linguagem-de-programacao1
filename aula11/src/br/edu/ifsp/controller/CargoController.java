package br.edu.ifsp.controller;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.dao.CargoDao;
import br.edu.ifsp.model.cargo.Cargo;
import br.edu.ifsp.model.departamento.Departamento;
import br.edu.ifsp.model.cargo.CargoValidacao;

public class CargoController {
	private Cargo cargo;
	private List<String> erros;

    public List<String> insereCargo(String descricao, Departamento depto) {
    	recebeDadosCargo(null, descricao, depto);
    	
		// Se nenhum erro de valida��o for encontrado, tenta inserir o cargo no banco.
		if (erros.size() == 0)
			erros.add(new CargoDao().insereCargo(cargo));
		
		// Retorna o ArrayList contendo:
		// - Em caso de sucesso: null na 1� posi��o; OU
		// - Em caso de exce��o: uma mensagem de exce��o na 1� posi��o; OU
		// - Em caso de erro de valida��o: mensagens de erro iniciando na 1� posi��o.
		return erros; 
    }
    
    // M�todo usado pelas opera��es de inser��o e altera��o de cargo.
    public void recebeDadosCargo(Integer id, String descricao, Departamento depto) {
    	cargo = new Cargo();
    	erros = new ArrayList<String>();

		// Os m�todos set abaixo criam um objeto Cargo contendo os dados do cargo informado.
		// Este objeto ser� enviado � classe DAO, que far� a inser��o de seus dados no banco.
    	cargo.setId(id);
    	cargo.setDescricao(descricao);
    	cargo.setDepartamento(depto);
        
		// Retorna um ArrayList contendo os erros encontrados em regras de valida��o e de neg�cios.
		erros = CargoValidacao.validaCargo(cargo);
    }
}
