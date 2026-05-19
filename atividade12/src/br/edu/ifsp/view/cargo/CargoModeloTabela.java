package br.edu.ifsp.view.cargo;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.edu.ifsp.model.cargo.Cargo;
import br.edu.ifsp.model.departamento.Departamento;

@SuppressWarnings("serial")
public class CargoModeloTabela extends AbstractTableModel {
	private String[] colunas = { "Código", "Descrição", "Departamento" };
	private List<Cargo> cargos;
	private List<Departamento> departamentos;
	
	public CargoModeloTabela() { }

	public CargoModeloTabela(List<Cargo> cargos, List<Departamento> departamentos) {
		this.cargos = cargos;
		this.departamentos = departamentos;
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
		if (cargos != null)
			return cargos.size();	
		return 0;
	}

	@Override
    public Object getValueAt(int linha, int coluna) {
		Cargo cargo = cargos.get(linha);
        Object valor = null;
		
        switch (coluna) {
            case 0:
            	valor = cargo.getId(); 
            	break;
            case 1:
            	valor = cargo.getDescricao(); 
            	break;
            case 2:
				if (departamentos != null)
					for (Departamento d : departamentos)
						if (d.getId() == cargo.getDepartamento().getId())
							valor = d;
            	break;
        }
        return valor;
    }
	
	@Override 
	public boolean isCellEditable(int linha, int coluna) { 
		return false;
	}
}
