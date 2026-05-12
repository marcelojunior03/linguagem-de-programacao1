package br.edu.ifsp.controller;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.dao.DepartamentoDao;
import br.edu.ifsp.model.departamento.Departamento;
import br.edu.ifsp.model.funcionario.Funcionario;
import br.edu.ifsp.model.departamento.DepartamentoValidacao;

public class DepartamentoController {
	private Departamento departamento;
	private List<String> erros;

    public List<String> insereDepartamento(String nomeDepto, Funcionario gerente) {
    	recebeDadosDepartamento(null, nomeDepto, gerente);
    	
		// Se nenhum erro de valida��o for encontrado, tenta inserir o departamento no banco.
		if (erros.size() == 0)
			erros.add(new DepartamentoDao().insereDepartamento(departamento));
		
		// Retorna o ArrayList contendo:
		// - Em caso de sucesso: null na 1� posi��o; OU
		// - Em caso de exce��o: uma mensagem de exce��o na 1� posi��o; OU
		// - Em caso de erro de valida��o: mensagens de erro iniciando na 1� posi��o.
		return erros; 
    }
    
    // M�todo usado pelas opera��es de inser��o e altera��o de departamento.
    public void recebeDadosDepartamento(Integer id, String nomeDepto, Funcionario gerente) {
    	departamento = new Departamento();
    	erros = new ArrayList<String>();

		// Os m�todos set abaixo criam um objeto Departamento contendo os dados do departamento informado.
		// Este objeto ser� enviado � classe DAO, que far� a inser��o de seus dados no banco.
    	departamento.setId(id);
    	departamento.setNomeDepto(nomeDepto);
    	departamento.setGerente(gerente);
        
		// Retorna um ArrayList contendo os erros encontrados em regras de valida��o e de neg�cios.
		erros = DepartamentoValidacao.validaDepartamento(departamento);
    }
}
