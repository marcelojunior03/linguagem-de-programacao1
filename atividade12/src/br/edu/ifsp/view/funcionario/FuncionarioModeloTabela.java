package br.edu.ifsp.view.funcionario;

import java.text.DecimalFormat;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.edu.ifsp.model.cargo.Cargo;
import br.edu.ifsp.model.funcionario.Funcionario;

@SuppressWarnings("serial")
public class FuncionarioModeloTabela extends AbstractTableModel { // A classe abstrata AbstractTableModel implementa a interface TableModel.
	// Array de nomes a serem exibidos no cabe�alho do JTable.
	private String[] colunas = { "Código", "Nome", "Sexo", "Salário (R$)", "Plano de Saúde", "Cargo" };
	private List<Funcionario> funcionarios; // Lista que conter� os dados a serem exibidos no corpo do JTable.
	private List<Cargo> cargos; // Lista que conter� os dados dos cargos associados a cada funcion�rio.
	
	public FuncionarioModeloTabela() { } // Construtor vazio.

	public FuncionarioModeloTabela(List<Funcionario> funcionarios, List<Cargo> cargos) { // Construtor.
		// Obt�m um ArrayList de objetos Funcionario, contendo os dados dos funcion�rios cadastrados.
		this.funcionarios = funcionarios;
		this.cargos = cargos;
	}
	
	// M�todo da interface TableModel (implementa��o obrigat�ria). 
	// Retorna a quantidade de colunas do modelo da tabela.
	@Override
	public int getColumnCount() { 
		return colunas.length;
	}
	
    // M�todo da classe abstrata AbstractTableModel (implementa��o opcional). 
	// Retorna o nome da coluna recebida como argumento.
    // Sem este m�todo, os nomes das colunas s�o exibidos no JTable como: A, B, C, D etc. 
	@Override
	public String getColumnName(int coluna) {
		return colunas[coluna];
	}

	// M�todo da interface TableModel (implementa��o obrigat�ria). 
	// Retorna a quantidade de linhas do modelo da tabela. 
	@Override
	public int getRowCount() {
		if (funcionarios != null) // Se existir pelo menos um funcion�rio cadastrado.
			return funcionarios.size();	
		return 0;
	}
	
	// M�todo da classe abstrata AbstractTableModel (implementa��o opcional). 
	// Retorna a classe da coluna recebida como argumento.
    // Sem este m�todo, a coluna Plano de Sa�de do JTable exibe valores true ou false, em vez de checkboxes.
	@Override
	public Class<?> getColumnClass(int coluna) {
		return getValueAt(0, coluna).getClass(); // A linha � zero, mas poderia ser qualquer n�mero de linha,
		                                         // pois o que importa � a classe da coluna.
	}

	// M�todo da interface TableModel (implementa��o obrigat�ria).
	// Cada vez que � chamado, este m�todo recupera o valor de um dos atributos de um funcion�rio do ArrayList.
	// Cada valor recuperado � ent�o retornado para popular uma c�lula correspondente no JTable.
	@Override
    public Object getValueAt(int linha, int coluna) {
        Funcionario funcionario = funcionarios.get(linha); // Recupera o objeto Funcionario presente na posi��o "linha" do ArrayList.
        Object valor = null;
		// Formata os centavos do Sal�rio. #: d�gitos opcionais; 0: d�gitos obrigat�rios.
		DecimalFormat df = new DecimalFormat("##,##0.00");
		
        switch (coluna) { // Verifica qual atributo do funcion�rio ser� recuperado, com base na coluna recebida.
            case 0: // Coluna IdFuncionario
            	valor = funcionario.getId(); 
            	break;
            case 1: // Coluna Nome 
            	valor = funcionario.getNome(); 
            	break;
            case 2: // Coluna Sexo
				if (funcionario.getSexo() == 'M')
					valor = "Masculino";
				else
					valor = "Feminino";
            	break;
            case 3: // Coluna Salario
            	valor = df.format(funcionario.getSalario());
            	break;
            case 4: // Coluna PlanoSaude
            	valor = funcionario.isPlanoSaude(); 
            	break;
            case 5: // Coluna Cargo
				if (cargos != null) // Se existir pelo menos um cargo cadastrado.
					for (Cargo c : cargos)
						if (c.getId() == funcionario.getCargo().getId())
							// Ao ser carregado, o JTable chama automaticamente o m�todo toString dos objetos Cargo para convert�-los  
							// para String, pois o dado a ser exibido nele deve ser deste tipo. Como o m�todo toString foi sobrescrito
							// na classe Cargo, de modo a retornar a descri��o do cargo, � este o dado que ser� exibido no JTable.
							valor = c;
            	break;
        }
        return valor;
    }
	
	// M�todo da classe abstrata AbstractTableModel (implementa��o opcional).
	// Bloqueia para edi��o a c�lula recebida como argumento.
	@Override 
	public boolean isCellEditable(int linha, int coluna) { 
		return false;
	}
}