package br.edu.ifsp.view.departamento;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import br.edu.ifsp.controller.DepartamentoController;
import br.edu.ifsp.dao.FuncionarioDao;
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
		lbNomeDepto.setBounds(20, 50, 100, 25);
		tfNomeDepto.setBounds(100, 50, 360, 25);
		lbIdFuncGerente.setBounds(20, 130, 100, 25);
		tfIdFuncGerente.setBounds(100, 130, 100, 25);
		btCadastrar.setBounds(200, 250, 100, 25);

		// Adi��o dos componentes de interface ao container.
		cp.add(lbTitulo);
		cp.add(lbNomeDepto);
		cp.add(tfNomeDepto);
		cp.add(lbIdFuncGerente);
		cp.add(tfIdFuncGerente);
		cp.add(btCadastrar);

		// Declara��o do processador de evento referente ao clique no bot�o Cadastrar.
		btCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				btCadastrarAction();
			}
		});
	} // Final do construtor.

	private void btCadastrarAction() { // M�todo acionado pelo clique no bot�o Cadastrar.
		Character sexo = null;
		BigDecimal salario = null;
		for (JRadioButton rb : rbSexo) // Recupera o texto do JRadionButton selecionado.
			if (rb.isSelected())
				sexo = rb.getText().charAt(0);
		
		if (!tfSalario.getText().equals(""))
			salario = new BigDecimal(tfSalario.getText().replace(".", "").replace(",", "."));

		List<String> erros = new ArrayList<String>();
		
		// Envia os dados do funcion�rio (informados no formul�rio) ao controller. 
		// O controller retorna ent�o um ArrayList contendo os erros encontrados.
		erros = new FuncionarioController().insereFuncionario(tfNome.getText(),
												              sexo,
												              salario,
										                      ckPlanoSaude.isSelected(),
										                      (Cargo) cbCargo.getSelectedItem());
		
		if (erros.get(0) == null) { // Se o primeiro elemento do ArrayList for null.
			JOptionPane.showMessageDialog(this, "Funcion�rio cadastrado com sucesso.", 
					                      "Informa��o", JOptionPane.INFORMATION_MESSAGE);
			this.setVisible(false); // Fecha a janela.
		} else { // Se o primeiro elemento do ArrayList n�o for null.
			String mensagem = "N�o foi poss�vel cadastrar o funcion�rio:\n";
			for (String e : erros) // Cria uma mensagem contendo todos os erros armazenados no ArrayList.
				mensagem = mensagem + e + "\n";
			JOptionPane.showMessageDialog(this, mensagem, "Erros", JOptionPane.ERROR_MESSAGE);
		}
	}
}
