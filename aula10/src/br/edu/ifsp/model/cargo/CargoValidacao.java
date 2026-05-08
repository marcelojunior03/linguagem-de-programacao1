package br.edu.ifsp.model.cargo;

import java.util.ArrayList;
import java.util.List;

public class CargoValidacao {
	private static List<String> errosValidacao; // List para armazenar as mensagens de erro de valida��o.
	
	// Valida os dados informados conforme as regras abaixo.
	public static List<String> validaCargo(Cargo cargo){
		errosValidacao = new ArrayList<>();
		
		// Valida��o do campo Descricao.
		if (!cargo.getDescricao().equals("")) {
			if (cargo.getDescricao().length() < 5 || cargo.getDescricao().length() > 60)
				errosValidacao.add("* A Descrição deve ter entre 5 e 60 caracteres.");
		} else {
			errosValidacao.add("* A Descrição n�o foi informada.");
		}
		
		// Valida��o do campo Depto (para o caso de n�o existirem departamentos cadastrados).
		if (cargo.getDepartamento() == null)
			errosValidacao.add("* O Departamento n�o foi informado.");
		
		return errosValidacao; // Retorna o ArrayList contendo as mensagens de erro de valida��o.
	}
}
