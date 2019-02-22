/*******************************************************************************
 * Copyright (C) 2019 Andrea-C1201
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package io.andrea_c.tiledloader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import io.andrea_c.tiledloader.exceptions.LayerNotFoundException;
import io.andrea_c.tiledloader.level.layer.LayerType;
import io.andrea_c.tiledloader.level.layer.ObjectLayer;
import io.andrea_c.tiledloader.level.layer.TileLayer;
import io.andrea_c.tiledloader.types.Layer;

public class LayerLoader {

	@Deprecated
	public int[] layerTextureData;

	private JSONObject rootNode;

	public LayerLoader(String filename) { //TODO change String filename to an object that refers to the file
		try {
			JSONTokener tokener = new JSONTokener(new FileInputStream(filename));
			rootNode = new JSONObject(tokener);
			// loadLayer("Texture");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Layer loadLayer(String layerName, LayerType type) throws LayerNotFoundException { //TODO remove type
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
				TileLayer layer = new TileLayer(data);
				return layer;
			} else if(type == LayerType.OBJECT_GROUP) {
				ObjectLayer layer = new ObjectLayer(data);
				return layer;
			}

		} else {
			throw new LayerNotFoundException(layerName);
		}
		return null;
	}

}
