package br.com.adriano;

public class ConversorTemperatura {
	
	private double temperatura;
	
	public void setTemperatura(double c) {
		this.temperatura = c + 0;
	}
	
	public double getTemperatura(String simbolo) {
		if(simbolo == "Kelvin") {
			return this.temperatura + 273.15;
		}else if (simbolo == "Fahrenheit"){
			return ((this.temperatura * 9)/5) +32;
		}else {
			return 0;
		}
	}

}
