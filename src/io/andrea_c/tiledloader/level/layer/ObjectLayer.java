package io.andrea_c.tiledloader.level.layer;

import org.json.JSONArray;
import org.json.JSONObject;

import io.andrea_c.tiledloader.types.Layer;
import io.andrea_c.tiledloader.types.Object;

public class ObjectLayer extends Layer {
	
	private io.andrea_c.tiledloader.types.Object[] objects;
	
	public ObjectLayer(JSONObject layerData) {
		super(layerData);
		createLayer(layerData);
	}
	
	private void createLayer(JSONObject layerData) {
		JSONArray dataArray = layerData.getJSONArray("objects");
		this.objects = new io.andrea_c.tiledloader.types.Object[dataArray.length()];
		for (int i = 0; i < dataArray.length(); i++) {
			io.andrea_c.tiledloader.types.Object obj = new Object(dataArray.getJSONObject(i));
			objects[i] = obj;
		}
	}
	
	public Object[] getData() {
		return this.objects;
	}

}
