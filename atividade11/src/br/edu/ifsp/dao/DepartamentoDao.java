package br.edu.ifsp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.model.departamento.Departamento;
import br.edu.ifsp.model.funcionario.Funcionario;

public class DepartamentoDao extends GenericDao {
	private String instrucaoSql;
	private PreparedStatement comando;
	private ResultSet registros;
	private static String excecao = null;

    public String insereDepartamento(Departamento departamento) {
        instrucaoSql = "INSERT INTO Departamento (NomeDepto, IdFuncGerente) VALUES (?,?)";
        return insere(instrucaoSql, departamento.getNomeDepto(), departamento.getGerente().getId());
    }
    
    public List<Departamento> recuperaDepartamentos() {
        Departamento departamento;
        List<Departamento> departamentos = new ArrayList<Departamento>();
        instrucaoSql = "SELECT * FROM Departamento";
        
        try {
        	excecao = ConnectionDatabase.conectaBd();
        	if (excecao == null) {
                comando = ConnectionDatabase.getConexaoBd().prepareStatement(instrucaoSql);
                
                registros = comando.executeQuery();
                
                if (registros.next()) {
                    registros.beforeFirst();
        	        while (registros.next()) {
        	        	departamento = new Departamento();
        	        	departamento.setId(registros.getInt("Id"));
        	        	departamento.setNomeDepto(registros.getString("NomeDepto"));
        	        	departamento.setGerente((Funcionario) registros.getObject("IdFuncGerente"));
        	            
        	            departamentos.add(departamento);
        	        }
        	    }
                registros.close();
                comando.close();
                ConnectionDatabase.getConexaoBd().close(); 
            }
        } catch (Exception e) {
        	excecao = "Tipo de Exceção: " + e.getClass().getSimpleName() + "\nMensagem: " + e.getMessage();
        	departamentos = null;
        }
        return departamentos;
    }
    
	public String getExcecao() {
		return excecao;
	}
}