package br.edu.ifsp.model.cargo;

import java.util.ArrayList;
import java.util.List;

public class CargoValidacao {
	private static List<String> errosValidacao;
	
	public static List<String> validaCargo(Cargo cargo){
		errosValidacao = new ArrayList<>();
		
		if (!cargo.getDescricao().equals("")) {
			if (cargo.getDescricao().length() < 5 || cargo.getDescricao().length() > 60)
				errosValidacao.add("* A Descrição deve ter entre 5 e 60 caracteres.");
		} else {
			errosValidacao.add("* A Descrição não foi informada.");
		}
		
		if (cargo.getDepartamento() == null)
			errosValidacao.add("* O Departamento não foi informado.");
		
		return errosValidacao;
	}
}