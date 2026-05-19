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
    	
		if (erros.size() == 0)
			erros.add(new CargoDao().insereCargo(cargo));
		
		return erros; 
    }
    
    public void recebeDadosCargo(Integer id, String descricao, Departamento depto) {
    	cargo = new Cargo();
    	erros = new ArrayList<String>();

    	cargo.setId(id);
    	cargo.setDescricao(descricao);
    	cargo.setDepartamento(depto);
        
		erros = CargoValidacao.validaCargo(cargo);
    }
    
    public List<Cargo> recuperaCargos() {
		return new CargoDao().recuperaCargos();
    }
    
    public String getExcecao() {
    	return new CargoDao().getExcecao();
    }
}
