package br.edu.ifsp.view.cargo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import br.edu.ifsp.controller.CargoController;
import br.edu.ifsp.dao.DepartamentoDao;
import br.edu.ifsp.model.departamento.Departamento;

@SuppressWarnings("serial")
public class CargoCadastro extends JDialog {
	private JLabel lbTitulo, lbDescricao, lbDepto;
	private JTextField tfDescricao;
	private JComboBox<Departamento> cbDepto;
	private JButton btCadastrar;
	private Container cp;

	public CargoCadastro() {
		setTitle("Cadastro de Cargos");
		setSize(500, 335);
		setLocationRelativeTo(null);
		setModal(true);
		
		lbTitulo = new JLabel("Cadastro de Cargos");
		lbTitulo.setFont(new Font("Arial", Font.BOLD, 19));
		
		lbDescricao = new JLabel("Descrição");
		lbDepto = new JLabel("Departamento");
		
		tfDescricao = new JTextField();
		
		cbDepto = new JComboBox<>();
		
		List<Departamento> departamentos = new ArrayList<Departamento>();
		
		departamentos = new DepartamentoDao().recuperaDepartamentos();
		if (departamentos != null)
			for (Departamento d : departamentos)
				cbDepto.addItem(d);
		
		String erro = new DepartamentoDao().getExcecao();
		
		if (erro != null)
			JOptionPane.showMessageDialog(null, "Não foi possível recuperar os dados dos departamentos:\n" + erro, 
					                      "Erro", JOptionPane.ERROR_MESSAGE);
		
		btCadastrar = new JButton("Cadastrar");

		cp = getContentPane();
		cp.setLayout(null);
		cp.setBackground(new Color(180, 205, 205));

		lbTitulo.setBounds(125, 10, 300, 25);
		lbDescricao.setBounds(20, 50, 100, 25);
		tfDescricao.setBounds(100, 50, 360, 25);
		lbDepto.setBounds(20, 90, 100, 25);
		lbDepto.setBounds(20, 170, 100, 25);
		cbDepto.setBounds(120, 170, 220, 25);
		btCadastrar.setBounds(200, 250, 100, 25);

		cp.add(lbTitulo);
		cp.add(lbDescricao);
		cp.add(tfDescricao);
		cp.add(lbDepto);
		cp.add(cbDepto);
		cp.add(btCadastrar);

		btCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				btCadastrarAction();
			}
		});
	}

	private void btCadastrarAction() {
		List<String> erros = new ArrayList<String>();
		
		erros = new CargoController().insereCargo(tfDescricao.getText(), (Departamento) cbDepto.getSelectedItem());
		
		if (erros.get(0) == null) {
			JOptionPane.showMessageDialog(this, "Cargo cadastrado com sucesso.", 
					                      "Informação", JOptionPane.INFORMATION_MESSAGE);
			this.setVisible(false);
		} else {
			String mensagem = "Não foi possível cadastrar o cargo:\n";
			for (String e : erros)
				mensagem = mensagem + e + "\n";
			JOptionPane.showMessageDialog(this, mensagem, "Erros", JOptionPane.ERROR_MESSAGE);
		}
	}
}