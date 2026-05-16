package br.edu.ifsp.view.departamento;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import br.edu.ifsp.controller.DepartamentoController;
import br.edu.ifsp.controller.FuncionarioController;
import br.edu.ifsp.model.funcionario.Funcionario;

@SuppressWarnings("serial")
public class DepartamentoCadastro extends JDialog {
	private JLabel lbTitulo, lbNomeDepto, lbIdFuncGerente;
	private JTextField tfNomeDepto, tfIdFuncGerente;
	private JButton btCadastrar;
	private Container cp;

	public DepartamentoCadastro() {
		setTitle("Cadastro de Departamentos");
		setSize(500, 335);
		setLocationRelativeTo(null);
		setModal(true);
		
		lbTitulo = new JLabel("Cadastro de Departamentos");
		lbTitulo.setFont(new Font("Arial", Font.BOLD, 19));
		
		lbNomeDepto = new JLabel("Nome do Departamento");
		lbIdFuncGerente = new JLabel("ID do Gerente");
		
		tfNomeDepto = new JTextField();
		tfIdFuncGerente = new JTextField();
		
		btCadastrar = new JButton("Cadastrar");

		cp = getContentPane();
		cp.setLayout(null);
		cp.setBackground(new Color(180, 205, 205));

		lbTitulo.setBounds(125, 10, 300, 25);
		lbNomeDepto.setBounds(20, 50, 160, 25);
		tfNomeDepto.setBounds(180, 50, 250, 25);
		lbIdFuncGerente.setBounds(20, 130, 100, 25);
		tfIdFuncGerente.setBounds(100, 130, 100, 25);
		btCadastrar.setBounds(200, 250, 100, 25);

		cp.add(lbTitulo);
		cp.add(lbNomeDepto);
		cp.add(tfNomeDepto);
		cp.add(lbIdFuncGerente);
		cp.add(tfIdFuncGerente);
		cp.add(btCadastrar);

		btCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				btCadastrarAction();
			}
		});
	}

	private void btCadastrarAction() {
		int id = Integer.parseInt(tfIdFuncGerente.getText());
		Funcionario gerente = new FuncionarioController().buscarPorId(id);
		
		List<String> erros = new ArrayList<String>();
		
		erros = new DepartamentoController().insereDepartamento(tfNomeDepto.getText(), gerente);
		
		if (erros.get(0) == null) {
			JOptionPane.showMessageDialog(this, "Departamento cadastrado com sucesso.", 
					                      "Informação", JOptionPane.INFORMATION_MESSAGE);
			this.setVisible(false);
		} else {
			String mensagem = "Não foi possível cadastrar o departamento:\n";
			for (String e : erros)
				mensagem = mensagem + e + "\n";
			JOptionPane.showMessageDialog(this, mensagem, "Erros", JOptionPane.ERROR_MESSAGE);
		}
	}
}