package br.com.adriano;

public class ConversorMedida {
	private double metros;
	
	public void setMetros(double metros) {
		this.metros = metros + 0;
	}
	
	public double getMetros(String medida) {
		if(medida == "Km") {
			return this.metros * 1000;
		}else if(medida == "centimetro") {
			return this.metros * 100;
		}
		return metros;
	}

}
