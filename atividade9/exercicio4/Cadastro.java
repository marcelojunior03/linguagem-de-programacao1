package exercicio4;

import javax.swing.*;
import java.awt.event.*;

public class Cadastro extends JFrame {
	JMenuBar barra;
	JMenu menuCadastro;
	JMenuItem miPessoaFisica;
	JMenuItem miPessoaJuridica;
	JMenuItem miFornecedores;
	JMenuItem miSair;

	public Cadastro() {

		setTitle("Exercício 4");
		setSize(500, 400);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		barra = new JMenuBar();
		setJMenuBar(barra);

		menuCadastro = new JMenu("Cadastro");
		barra.add(menuCadastro);

		miPessoaFisica = new JMenuItem("Pessoa Física");
		miPessoaJuridica = new JMenuItem("Pessoa Jurídica");
		miFornecedores = new JMenuItem("Fornecedores");
		miSair = new JMenuItem("Sair");

		menuCadastro.add(miPessoaFisica);
		menuCadastro.add(miPessoaJuridica);
		menuCadastro.add(miFornecedores);
		menuCadastro.addSeparator();
		menuCadastro.add(miSair);

		miPessoaFisica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PessoaFisica();
			}
		});

		miPessoaJuridica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PessoaJuridica();
			}
		});

		miFornecedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Fornecedores();
			}
		});

		miSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		setVisible(true);
	}

	public static void main(String[] args) {
		new Cadastro();
	}
}

class PessoaFisica extends JFrame {

	public PessoaFisica() {
		setTitle("Clientes - Pessoa Física");
		setSize(300, 200);
		setLayout(null);
		setVisible(true);
	}
}

class PessoaJuridica extends JFrame {

	public PessoaJuridica() {
		setTitle("Clientes - Pessoa Jurídica");
		setSize(300, 200);
		setLayout(null);
		setVisible(true);
	}
}

class Fornecedores extends JFrame {

	public Fornecedores() {
		setTitle("Fornecedores");
		setSize(300, 200);
		setLayout(null);
		setVisible(true);
	}
}
