package io.andrea_c.tiledloader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import io.andrea_c.tiledloader.exceptions.LayerNotFoundException;
import io.andrea_c.tiledloader.level.layer.Layer;
import io.andrea_c.tiledloader.level.layer.LayerType;
import io.andrea_c.tiledloader.level.layer.TileLayer;

public class LayerLoader {

	public int[] layerTextureData;

	private JSONObject rootNode;

	public LayerLoader(String filename) {
		try {
			JSONTokener tokener = new JSONTokener(new FileInputStream(filename));
			rootNode = new JSONObject(tokener);
			// loadLayer("Texture");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/*public Layer loadLayer(String layerName, LayerType type) throws LayerNotFoundException {
		JSONArray layerArray = rootNode.getJSONArray("layers");
		List<JSONObject> objs = new ArrayList<JSONObject>();
		for (int i = 0; i < layerArray.length(); i++) {
			if (layerArray.getJSONObject(i) != null)
				objs.add(layerArray.getJSONObject(i));
		}
		JSONObject data = null;
		for (int i = 0; i < objs.size(); i++) {
			if (objs.get(i).getString("name").equals(layerName)) {
				data = objs.get(i);
				break;
			}
		}
		if (data != null) {
			if(type == LayerType.TILE_LAYER) {
				Layer layer = new Layer(data);
				
				return layer;
			} else if(type == LayerType.OBJECT_GROUP) {
				TileLayer layer = null;
				return layer;
			}

		} else {
			throw new LayerNotFoundException(layerName);
		}
	}*/

}
