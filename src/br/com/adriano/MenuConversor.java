package br.com.adriano;

import java.io.IOException;

import javax.swing.JOptionPane;

public class MenuConversor {

	public static String opcaoEscolhida;

	public static void main(String[] args) throws IOException {
		while (true) {
			String opcaoEscolhida = (String) JOptionPane.showInputDialog(null, "Escolha um das opções",
					"Menu Conversor", JOptionPane.QUESTION_MESSAGE, null,
					new Object[] { "Conversor de Moeda", "Conversor de Temperatura", "Conversor de Medida" },
					"Conversor de Moeda");

			if (opcaoEscolhida == "Conversor de Moeda") {
				ConversorMoeda cm = new ConversorMoeda();

				boolean validaValor = true;
				boolean concluiCirculo = true;
				double valorEmReal;
				while (concluiCirculo) {
					try {
						while (validaValor) {
							try {
								valorEmReal = (Double.parseDouble(JOptionPane.showInputDialog("Informe um valor R$")));
								validaValor = false;
							} catch (NumberFormatException ex) {
								String msg = ex.getMessage();
								JOptionPane.showInternalMessageDialog(null,
										"Valor inválido, tente novamente.\n" + "'" + msg + "'", null,
										JOptionPane.ERROR_MESSAGE, null);
								break;
							}
							String simbolo = (String) JOptionPane.showInputDialog(null, "Qual moeda você quer?", null,
									JOptionPane.QUESTION_MESSAGE, null,
									new Object[] { "Selecione a moeda!", "USD-BRL", "EUR-BRL" }, "Selecione a moeda!");

							if (simbolo == "USD-BRL" || simbolo == "EUR-BRL") {
								cm.setValorConvertido(simbolo, valorEmReal);
								JOptionPane.showInternalMessageDialog(null,
										"Valor Convertido: " + cm.getValorConvertido() * valorEmReal);
								concluiCirculo = false;
							} else {
								JOptionPane.showInternalMessageDialog(null, "Operação cancelada", null,
										JOptionPane.ERROR_MESSAGE, null);
								concluiCirculo = false;
							}

						}
					} catch (NullPointerException ex) {
						JOptionPane.showInternalMessageDialog(null, "Operação cancelada", null,
								JOptionPane.ERROR_MESSAGE, null);
						break;
					}
				}

			} else if (opcaoEscolhida == "Conversor de Temperatura") {
				ConversorTemperatura ct = new ConversorTemperatura();
				ct.setTemperatura(Double.parseDouble(JOptionPane.showInputDialog("Informa Temperatura em Celsius")));
				String simbolo = (String) JOptionPane.showInputDialog(null, "Qual escala de temperatura?", null,
						JOptionPane.QUESTION_MESSAGE, null,
						new Object[] { "Selecione um escala!", "Kelvin", "Fahrenheit" }, "Selecione um escala!");
				JOptionPane.showInternalMessageDialog(null, "A temperatura em K: " + ct.getTemperatura(simbolo));

			} else if (opcaoEscolhida == "Conversor de Medida") {
				ConversorMedida cm = new ConversorMedida();
				cm.setMetros(Double.parseDouble(JOptionPane.showInputDialog("Informe a quantidade em Km: ")));
				String simbolo = (String) JOptionPane.showInputDialog(null, "Qual escala de temperatura?", null,
						JOptionPane.QUESTION_MESSAGE, null,
						new Object[] { "Selecione um escala!", "Kelvin", "Fahrenheit" }, "Selecione um escala!");

				JOptionPane.showInternalMessageDialog(null, "São: " + cm.getMetros(simbolo) + " metros");
			}
			int continua = JOptionPane.showConfirmDialog(null, "Deseja continuar no conversor?");
			if (continua != 0) {
				JOptionPane.showInternalMessageDialog(null, "O sistema está finalizado");
				break;
			}
		}
		System.exit(0);
	}
}
