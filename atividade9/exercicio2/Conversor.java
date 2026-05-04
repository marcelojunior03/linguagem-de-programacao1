package exercicio2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Conversor extends JFrame {
	private JLabel lbTitulo, lbTemperatura, lbOperacoes;
	private JTextField tfTemperatura;
	private static final String conversoes[] = {"Celsius para Fahrenheit", 
												"Fahrenheit para Celsius",
												"Celsius para Kelvin",
												"Kelvin para Celsius",
												"Fahrenheit para Kelvin",
												"Kelvin para Fahrenheit"};
	private JRadioButton rbOperacoes[];
	private ButtonGroup bgOperacoes;
	private Container cp;
	
	public Conversor() {
		lbTitulo = new JLabel("Conversor de Temperatura");
		lbTemperatura = new JLabel("Temperatura");
		lbOperacoes = new JLabel("Operações:");
		tfTemperatura = new JTextField();
		rbOperacoes = new JRadioButton[6];
		bgOperacoes = new ButtonGroup();
		
		setTitle("Exercício 2");
		setSize(400, 270);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lbTitulo.setFont(new Font("Arial", Font.BOLD, 19));
		for(int i = 0; i < rbOperacoes.length; i++) {
			rbOperacoes[i] = new JRadioButton(conversoes[i]);
			rbOperacoes[i].setBackground(new Color(180, 205, 205));
			bgOperacoes.add(rbOperacoes[i]);
		}
		cp = getContentPane();
		cp.setLayout(null);
		cp.setBackground(new Color(180, 205, 205));
		
		lbTitulo.setBounds(75, 10, 300, 25);
		lbTemperatura.setBounds(20, 40, 100, 25);
		lbOperacoes.setBounds(30, 70, 100, 25);
		tfTemperatura.setBounds(100, 40, 200, 25);
		rbOperacoes[0].setBounds(100, 70, 360, 25);
		rbOperacoes[1].setBounds(100, 90, 360, 25);
		rbOperacoes[2].setBounds(100, 110, 360, 25);
		rbOperacoes[3].setBounds(100, 130, 360, 25);
		rbOperacoes[4].setBounds(100, 150, 360, 25);
		rbOperacoes[5].setBounds(100, 170, 360, 25);
		
		cp.add(lbTitulo);
		cp.add(lbTemperatura);
		cp.add(lbOperacoes);
		cp.add(tfTemperatura);
		cp.add(rbOperacoes[0]);
		cp.add(rbOperacoes[1]);
		cp.add(rbOperacoes[2]);
		cp.add(rbOperacoes[3]);
		cp.add(rbOperacoes[4]);
		cp.add(rbOperacoes[5]);
		
		rbOperacoes[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { rbOperacoes1Action(); }
		});
		rbOperacoes[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { rbOperacoes2Action(); }
		});
		rbOperacoes[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { rbOperacoes3Action(); }
		});
		rbOperacoes[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { rbOperacoes4Action(); }
		});
		rbOperacoes[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { rbOperacoes5Action(); }
		});
		rbOperacoes[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { rbOperacoes6Action(); }
		});
	}
	
	private void rbOperacoes1Action() {
		try {
			String tempTxt = tfTemperatura.getText();
			
			if(tempTxt.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Preencha campo de temperatura para continuar!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			double temp = Double.parseDouble(tempTxt);
			
			double resultado = temp * 1.8 + 32;
			
			JOptionPane.showMessageDialog(this, "Resultado da conversão: " + resultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
			
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Digite apenas números!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	private void rbOperacoes2Action() {
		try {
			String tempTxt = tfTemperatura.getText();
			
			if(tempTxt.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Preencha campo de temperatura para continuar!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			double temp = Double.parseDouble(tempTxt);
			
			double resultado = (temp - 32) / 1.8;
			
			JOptionPane.showMessageDialog(this, "Resultado da conversão: " + resultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
			
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Digite apenas números!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	private void rbOperacoes3Action() {
		try {
			String tempTxt = tfTemperatura.getText();
			
			if(tempTxt.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Preencha campo de temperatura para continuar!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			double temp = Double.parseDouble(tempTxt);
			
			double resultado = temp + 273.15;
			
			JOptionPane.showMessageDialog(this, "Resultado da conversão: " + resultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
			
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Digite apenas números!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	private void rbOperacoes4Action() {
		try {
			String tempTxt = tfTemperatura.getText();
			
			if(tempTxt.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Preencha campo de temperatura para continuar!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			double temp = Double.parseDouble(tempTxt);
			
			double resultado = temp - 273.15;
			
			JOptionPane.showMessageDialog(this, "Resultado da conversão: " + resultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
			
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Digite apenas números!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	private void rbOperacoes5Action() {
		try {
			String tempTxt = tfTemperatura.getText();
			
			if(tempTxt.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Preencha campo de temperatura para continuar!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			double temp = Double.parseDouble(tempTxt);
			
			double resultado = (temp + 459.67) / 1.8;
			
			JOptionPane.showMessageDialog(this, "Resultado da conversão: " + resultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
			
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Digite apenas números!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	private void rbOperacoes6Action() {
		try {
			String tempTxt = tfTemperatura.getText();
			
			if(tempTxt.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Preencha campo de temperatura para continuar!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			double temp = Double.parseDouble(tempTxt);
			
			double resultado = temp * 1.8 - 459.67;
			
			JOptionPane.showMessageDialog(this, "Resultado da conversão: " + resultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
			
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Digite apenas números!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Conversor().setVisible(true);
			}});
	}

}
