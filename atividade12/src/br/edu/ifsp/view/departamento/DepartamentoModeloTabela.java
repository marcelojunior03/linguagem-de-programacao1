package br.edu.ifsp.view.departamento;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.edu.ifsp.model.departamento.Departamento;
import br.edu.ifsp.model.funcionario.Funcionario;

@SuppressWarnings("serial")
public class DepartamentoModeloTabela extends AbstractTableModel {
	private String[] colunas = { "Código", "Nome do Departamento", "Gerente" };
	private List<Departamento> departamentos;
	private List<Funcionario> funcionarios;
	
	public DepartamentoModeloTabela() { }

	public DepartamentoModeloTabela(List<Departamento> departamentos, List<Funcionario> funcionarios) {
		this.departamentos = departamentos;
		this.funcionarios = funcionarios;
	}
	
	@Override
	public int getColumnCount() { 
		return colunas.length;
	}
	
	@Override
	public String getColumnName(int coluna) {
		return colunas[coluna];
	}

	@Override
	public int getRowCount() {
		if (departamentos != null)
			return departamentos.size();	
		return 0;
	}

	@Override
    public Object getValueAt(int linha, int coluna) {
		Departamento departamento = departamentos.get(linha);
        Object valor = null;
		
        switch (coluna) {
            case 0:
            	valor = departamento.getId(); 
            	break;
            case 1:
            	valor = departamento.getNomeDepto(); 
            	break;
            case 2:
				if (funcionarios != null)
					for (Funcionario f : funcionarios)
						if (f.getId() == departamento.getGerente().getId())
							valor = f;
            	break;
        }
        return valor;
    }
	
	@Override 
	public boolean isCellEditable(int linha, int coluna) { 
		return false;
	}
}
