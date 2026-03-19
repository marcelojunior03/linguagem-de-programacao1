package aula4_ex2;

public abstract class Forma {
	protected String cor;
	protected double area;
	
	public abstract void calcularArea();
	
	public String getCor() {
		return cor;
	}
	
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public double getArea() {
		return area;
	}
	
	public void setArea(double area) {
		this.area = area;
	}
}
