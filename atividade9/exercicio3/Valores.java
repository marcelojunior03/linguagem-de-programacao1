package exercicio3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Valores extends JFrame {
	private JLabel lbTitulo, lbValor, lbEstado, lbTipo, lbValorP, lbValorF, lbValorT;
	private JTextField tfValor;
	private JCheckBox ckFidelidade;
	private JComboBox<String> cbEstado;
	private static final String estados[] = {"SP", "RJ", "MG", "ES"};
	private static final String tipos[] = {"Sedex", "Sedex 10"};
	private JRadioButton rbTipo[];
	private ButtonGroup bgTipo;
	private JButton btCalcular;
	private Container cp;
	
	public Valores() {
		lbTitulo = new JLabel("Calculadora de Valores");
		lbValor = new JLabel("Valor do Produto");
		lbEstado = new JLabel("Estado");
		lbTipo = new JLabel("Tipo de Postagem");
		lbValorP = new JLabel("Valor do Produto:");
		lbValorF = new JLabel("Valor do Frete:");
		lbValorT = new JLabel("Valor Total:");
		tfValor = new JTextField();
		ckFidelidade = new JCheckBox("Cliente com Fidelidade");
		cbEstado = new JComboBox<>(estados);
		rbTipo = new JRadioButton[2];
		bgTipo = new ButtonGroup();
		btCalcular = new JButton("Calcular");
		
		setTitle("Exercício 3");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lbTitulo.setFont(new Font("Arial", Font.BOLD, 19));
		for(int i = 0; i < rbTipo.length; i++) {
			rbTipo[i] = new JRadioButton(tipos[i]);
			rbTipo[i].setBackground(new Color(180, 205, 205));
			bgTipo.add(rbTipo[i]);
		}
		rbTipo[0].setSelected(true);
		ckFidelidade.setBackground(new Color(180, 205, 205));
		btCalcular.setToolTipText("Executa o cálculo");
		cp = getContentPane();
		cp.setLayout(null);
		cp.setBackground(new Color(180, 205, 205));
		
		lbTitulo.setBounds(200, 10, 360, 25);
		lbValor.setBounds(30, 50, 120, 25);
		tfValor.setBounds(150, 50, 120, 25);
		ckFidelidade.setBounds(30, 90, 170, 25);
		lbEstado.setBounds(30, 130, 60, 25);
		cbEstado.setBounds(90, 130, 90, 25);
		lbTipo.setBounds(30, 170, 100, 25);
		rbTipo[0].setBounds(30, 190, 150, 25);
		rbTipo[1].setBounds(30, 210, 100, 25);
		btCalcular.setBounds(70, 300, 110, 30);
		lbValorP.setBounds(320, 70, 180, 25);
		lbValorF.setBounds(320, 120, 180, 25);
		lbValorT.setBounds(320, 170, 180, 25);
		
		cp.add(lbTitulo);
		cp.add(lbValor);
		cp.add(lbEstado);
		cp.add(lbTipo);
		cp.add(lbValorP);
		cp.add(lbValorF);
		cp.add(lbValorT);
		cp.add(tfValor);
		cp.add(ckFidelidade);
		cp.add(cbEstado);
		cp.add(rbTipo[0]);
		cp.add(rbTipo[1]);
		cp.add(btCalcular);
		
		btCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { btCalcularAction(); }
		});
	}
	
	private void btCalcularAction() {
		try {
			double valor = Double.parseDouble(tfValor.getText());
			boolean fidelidade = ckFidelidade.isSelected();
			String estado = cbEstado.getSelectedItem().toString();
			double frete = 0;
			
			if(fidelidade) {
	            valor = valor - (valor * 0.10);
	        }
			
			if(estado.equals("SP")) {
				frete = valor * 0.10;
			}
			else if(estado.equals("RJ") || estado.equals("MG")) {
				frete = valor * 0.15;
			}
			else if(estado.equals("ES")) {
				frete = valor * 0.20;
			}
			
			if(rbTipo[1].isSelected()) {
				frete = frete + (frete * 0.20);
			}
			
			double total = valor + frete;
			
			lbValorP.setText("Valor do Produto: " + valor);
			lbValorF.setText("Valor do Frete: " + frete);
			lbValorT.setText("Valor Total: " + total);
			
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Digite apenas números!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Valores().setVisible(true);
			}});
	}
	
}
