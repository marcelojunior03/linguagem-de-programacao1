package br.edu.ifsp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.model.cargo.Cargo;
import br.edu.ifsp.model.departamento.Departamento;

public class CargoDao extends GenericDao {
	private String instrucaoSql;
	private PreparedStatement comando;
	private ResultSet registros;
	private static String excecao = null;
	
	public String insereCargo(Cargo cargo) {
        instrucaoSql = "INSERT INTO Cargo (Descricao, IdDepto) VALUES (?,?)";
        return insere(instrucaoSql, cargo.getDescricao(), cargo.getDepartamento().getId());
    }
	
    public List<Cargo> recuperaCargos() {
        Cargo cargo;
        Departamento departamento;
        List<Cargo> cargos = new ArrayList<Cargo>();
        instrucaoSql = "SELECT * FROM Cargo";
        
        try {
        	excecao = ConnectionDatabase.conectaBd();
        	if (excecao == null) {
                comando = ConnectionDatabase.getConexaoBd().prepareStatement(instrucaoSql);
                
                registros = comando.executeQuery();
                
                if (registros.next()) {
                    registros.beforeFirst();
        	        while (registros.next()) {
        	            cargo = new Cargo();
        	            cargo.setId(registros.getInt("Id"));
        	            cargo.setDescricao(registros.getString("Descricao"));
        	            
        	            departamento = new Departamento();
        	            departamento.setId(registros.getInt("IdDepto"));
        	            
        	            cargo.setDepartamento(departamento);
        	            
        	            cargos.add(cargo);
        	        }
        	    }
                registros.close();
                comando.close();
                ConnectionDatabase.getConexaoBd().close(); 
            }
        } catch (Exception e) {
        	excecao = "Tipo de Exceção: " + e.getClass().getSimpleName() + "\nMensagem: " + e.getMessage();
        	cargos = null;
        }
        return cargos;
    }
    
	public String getExcecao() {
		return excecao;
	}
}