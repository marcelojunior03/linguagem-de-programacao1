package exercicio3;

public class Retangulo extends Forma implements IForma {
	private double base, altura;
	
	public Retangulo(double base, double altura, String cor) {
		this.base = base;
		this.altura = altura;
		setCor(cor);
		
		calcularArea();
	}
	
	@Override
	public void calcularArea(){
		area = base * altura;
	}
}
