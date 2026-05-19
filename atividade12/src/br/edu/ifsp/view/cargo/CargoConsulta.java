package br.edu.ifsp.view.cargo;

import java.awt.*;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

import br.edu.ifsp.controller.CargoController;
import br.edu.ifsp.dao.DepartamentoDao;
import br.edu.ifsp.model.departamento.Departamento;
import br.edu.ifsp.model.cargo.Cargo;

@SuppressWarnings("serial")
public class CargoConsulta extends JDialog {
	private JLabel lbTitulo;
	private JTable tbCargo;
	private CargoModeloTabela mtTabela;
	private JScrollPane spTabela;
	private Container cp;

	public CargoConsulta() {
		setTitle("Consulta de Cargos");
		setSize(700, 320);
		setLocationRelativeTo(null);
		setModal(true);
		
		String excecaoCargos = null;
		String excecaoDepartamentos = null;
		
		List<Cargo> cargos = new CargoController().recuperaCargos();
		excecaoCargos = new CargoController().getExcecao();
		
		List<Departamento> departamentos = new DepartamentoDao().recuperaDepartamentos();
		excecaoDepartamentos = new DepartamentoDao().getExcecao();
		
		if (excecaoCargos != null) {
			JOptionPane.showMessageDialog(null, "Não foi possível recuperar os dados dos cargos:\n" + excecaoCargos, 
					                      "Erro", JOptionPane.ERROR_MESSAGE);
			mtTabela = new CargoModeloTabela();
		} else if (excecaoDepartamentos != null) {
			JOptionPane.showMessageDialog(null, "Não foi possível recuperar os dados dos departamentos:\n" + excecaoDepartamentos, 
						                  "Erro", JOptionPane.ERROR_MESSAGE);
			mtTabela = new CargoModeloTabela();
		} else
			mtTabela = new CargoModeloTabela(cargos, departamentos);
		
		lbTitulo = new JLabel("Consulta de Cargos");
		lbTitulo.setFont(new Font("Arial", Font.BOLD, 19));
		
		tbCargo = new JTable(mtTabela);
		spTabela = new JScrollPane(tbCargo);
		
		tbCargo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tbCargo.getColumnModel().getColumn(0).setPreferredWidth(50);
		tbCargo.getColumnModel().getColumn(1).setPreferredWidth(160);
		tbCargo.getColumnModel().getColumn(2).setPreferredWidth(100);
		
		tbCargo.getTableHeader().setFont(new Font(null, Font.BOLD, 12));
		
		DefaultTableCellRenderer dtcrCentro = new DefaultTableCellRenderer();
		dtcrCentro.setHorizontalAlignment(SwingConstants.CENTER);
		tbCargo.getColumnModel().getColumn(0).setCellRenderer(dtcrCentro);
		
		tbCargo.getTableHeader().setReorderingAllowed(false);
		tbCargo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		cp = getContentPane();
		cp.setLayout(null);
		cp.setBackground(new Color(180, 205, 205));

		lbTitulo.setBounds(215, 10, 300, 25);
		spTabela.setBounds(20, 40, 645, 182);

		cp.add(lbTitulo);
		cp.add(spTabela);
	}
}
