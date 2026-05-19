package br.edu.ifsp.view.departamento;

import java.awt.*;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

import br.edu.ifsp.controller.DepartamentoController;
import br.edu.ifsp.dao.FuncionarioDao;
import br.edu.ifsp.model.funcionario.Funcionario;
import br.edu.ifsp.model.departamento.Departamento;

@SuppressWarnings("serial")
public class DepartamentoConsulta extends JDialog {
	private JLabel lbTitulo;
	private JTable tbDepartamento;
	private DepartamentoModeloTabela mtTabela;
	private JScrollPane spTabela;
	private Container cp;

	public DepartamentoConsulta() {
		setTitle("Consulta de Departamentos");
		setSize(700, 320);
		setLocationRelativeTo(null);
		setModal(true);
		
		String excecaoDepartamentos = null;
		String excecaoFuncionarios = null;
		
		List<Departamento> departamentos = new DepartamentoController().recuperaDepartamentos();
		excecaoDepartamentos = new DepartamentoController().getExcecao();
		
		List<Funcionario> funcionarios = new FuncionarioDao().recuperaFuncionarios();
		excecaoFuncionarios = new FuncionarioDao().getExcecao();
		
		if (excecaoDepartamentos != null) {
			JOptionPane.showMessageDialog(null, "Não foi possível recuperar os dados dos departamentos:\n" + excecaoDepartamentos, 
					                      "Erro", JOptionPane.ERROR_MESSAGE);
			mtTabela = new DepartamentoModeloTabela();
		} else if (excecaoFuncionarios != null) {
			JOptionPane.showMessageDialog(null, "Não foi possível recuperar os dados dos funcionários:\n" + excecaoFuncionarios, 
						                  "Erro", JOptionPane.ERROR_MESSAGE);
			mtTabela = new DepartamentoModeloTabela();
		} else
			mtTabela = new DepartamentoModeloTabela(departamentos, funcionarios);
		
		lbTitulo = new JLabel("Consulta de Departamentos");
		lbTitulo.setFont(new Font("Arial", Font.BOLD, 19));
		
		tbDepartamento = new JTable(mtTabela);
		spTabela = new JScrollPane(tbDepartamento);
		
		tbDepartamento.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tbDepartamento.getColumnModel().getColumn(0).setPreferredWidth(50);
		tbDepartamento.getColumnModel().getColumn(1).setPreferredWidth(160);
		tbDepartamento.getColumnModel().getColumn(2).setPreferredWidth(100);
		
		tbDepartamento.getTableHeader().setFont(new Font(null, Font.BOLD, 12));
		
		DefaultTableCellRenderer dtcrCentro = new DefaultTableCellRenderer();
		dtcrCentro.setHorizontalAlignment(SwingConstants.CENTER);
		tbDepartamento.getColumnModel().getColumn(0).setCellRenderer(dtcrCentro);
		
		tbDepartamento.getTableHeader().setReorderingAllowed(false);
		tbDepartamento.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		cp = getContentPane();
		cp.setLayout(null);
		cp.setBackground(new Color(180, 205, 205));

		lbTitulo.setBounds(215, 10, 300, 25);
		spTabela.setBounds(20, 40, 645, 182);

		cp.add(lbTitulo);
		cp.add(spTabela);
	} 
}
