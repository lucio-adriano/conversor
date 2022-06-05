package br.com.adriano;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConversorMoeda {

	private BufferedReader reader;
	private String line;
	private StringBuffer responseContent = new StringBuffer();
	private Analisar analisar = new Analisar();

	private double valorConvertido;

	private static HttpURLConnection connection;

	public void setValorConvertido(String simbolo, double valorEmReal) throws IOException {
		URL url = new URL("https://economia.awesomeapi.com.br/json/" + simbolo);
		connection = (HttpURLConnection) url.openConnection();

		connection.setRequestMethod("GET");
		connection.setConnectTimeout(5000);
		connection.setReadTimeout(5000);

		int status = connection.getResponseCode();
		// System.out.println(status);

		if (status > 299) {
			reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
			while ((line = reader.readLine()) != null) {
				responseContent.append(line);
			}
			reader.close();
		} else {
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while ((line = reader.readLine()) != null) {
				responseContent.append(line);
			}
			reader.close();
		}
		analisar.setBid(responseContent.toString());

		this.valorConvertido = analisar.getBid();
	}

	public double getValorConvertido() {
		return valorConvertido;
	}
}
