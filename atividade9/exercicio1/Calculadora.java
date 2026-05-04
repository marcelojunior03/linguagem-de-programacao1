package exercicio1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Calculadora extends JFrame {
	private JLabel lbTitulo, lbValor1, lbValor2, lbOperacao;
	private JTextField tfValor1, tfValor2;
	private JComboBox<String> cbOperacao;
	private static final String sinais[] = {"+", "-", "*", "/", "%"};
	private JButton btCalcular;
	private Container cp;
	
	public Calculadora() {
		lbTitulo = new JLabel("Calculadora");
		lbValor1 = new JLabel("Valor 1");
		lbValor2 = new JLabel("Valor 2");
		lbOperacao = new JLabel("Operação");
		tfValor1 = new JTextField();
		tfValor2 = new JTextField();
		cbOperacao = new JComboBox<>(sinais);
		btCalcular = new JButton("Calcular");
		
		setTitle("Exercício 1");
		setSize(500, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lbTitulo.setFont(new Font("Arial", Font.BOLD, 19));
		btCalcular.setToolTipText("Executa o cálculo");
		cp = getContentPane();
		cp.setLayout(null);
		cp.setBackground(new Color(180, 205, 205));
		
		lbTitulo.setBounds(200, 10, 300, 25);
		lbValor1.setBounds(20, 40, 100, 25);
		lbValor2.setBounds(20, 70, 100, 25);
		lbOperacao.setBounds(20, 100, 100, 25);
		tfValor1.setBounds(100, 40, 360, 25);
		tfValor2.setBounds(100, 70, 360, 25);
		cbOperacao.setBounds(100, 100, 50, 25);
		btCalcular.setBounds(200, 100, 100, 25);
		
		cp.add(lbTitulo);
		cp.add(lbValor1);
		cp.add(lbValor2);
		cp.add(lbOperacao);
		cp.add(tfValor1);
		cp.add(tfValor2);
		cp.add(cbOperacao);
		cp.add(btCalcular);
		
		btCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { btCalcularAction(); }
		});
	}
	
	private void btCalcularAction() {
		try {
			String s1 = tfValor1.getText(), s2 = tfValor2.getText();
			
			if(s1.isEmpty() || s2.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Preencha os dois campos de valores para continuar!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			String op = cbOperacao.getSelectedItem().toString();
			
			if(op.equals("%")) {
				int v1 = Integer.parseInt(s1), v2 = Integer.parseInt(s2);
				
				if (v2 == 0) {
					JOptionPane.showMessageDialog(this, "Impossível dividir por 0!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				int resultado = v1 % v2;
				
				JOptionPane.showMessageDialog(this, "Resultado: " + resultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				double v1 = Double.parseDouble(s1), v2 = Double.parseDouble(s2), resultado = 0;
				
				switch(op) {
				case "+":
					resultado = v1 + v2;
					break;
				case "-":
					resultado = v1 - v2;
					break;
				case "*":
					resultado = v1 * v2;
					break;
				case "/":
					if (v2 == 0) {
						JOptionPane.showMessageDialog(this, "Impossível dividir por 0!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					resultado = v1 / v2;
					break;
				}
				
				JOptionPane.showMessageDialog(this, "Resultado: " + resultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
			}
			
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Digite apenas números!\nPara resto de divisão (%), digite apenas números inteiros.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Calculadora().setVisible(true);
			}});
	}
	
}
