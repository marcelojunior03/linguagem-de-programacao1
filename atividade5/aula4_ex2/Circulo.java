package aula4_ex2;

public class Circulo extends Forma {
	private double raio;
	
	public Circulo(double raio, String cor) {
		this.raio = raio;
		setCor(cor);
		
		calcularArea();
	}
	
	@Override
	public void calcularArea(){
		area = 3.14 * (raio * raio);
	}
}
