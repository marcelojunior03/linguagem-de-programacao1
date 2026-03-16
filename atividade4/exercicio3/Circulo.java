package exercicio3;

public class Circulo extends Forma implements IForma {
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
