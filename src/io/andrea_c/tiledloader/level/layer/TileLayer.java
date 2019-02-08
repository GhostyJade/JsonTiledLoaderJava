package io.andrea_c.tiledloader.level.layer;

import org.json.JSONArray;
import org.json.JSONObject;

public class TileLayer extends Layer {
	
	private int[] data;

	public TileLayer(JSONObject layerData) {
		super(layerData);
		this.createLayer(layerData);
	}
	
	private void createLayer(JSONObject layerData) {
		JSONArray dataArray = layerData.getJSONArray("data");
		this.data = new int[dataArray.length()];
		for (int i = 0; i < dataArray.length(); i++) {
			data[i] = dataArray.getInt(i);
		}
		this.height = layerData.getInt("height");
	}

}
