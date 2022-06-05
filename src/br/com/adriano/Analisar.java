package br.com.adriano;

import org.json.JSONArray;
import org.json.JSONObject;

public class Analisar {
	
	private double bid;
	
	public void setBid(String responseBody) {
		try {
			JSONArray albums = new JSONArray(responseBody);
			for (int i = 0; i < albums.length(); i++) {
				JSONObject album = albums.getJSONObject(i);
				this.bid = album.getDouble("bid");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public double getBid() {
		return bid;
	}
}
