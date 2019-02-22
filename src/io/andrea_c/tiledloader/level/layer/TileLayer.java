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
package io.andrea_c.tiledloader.level.layer;

import org.json.JSONArray;
import org.json.JSONObject;

import io.andrea_c.tiledloader.types.Layer;

public class TileLayer extends Layer {
	
	private int[] data;
	private int height;
	private int width;

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
		this.width = layerData.getInt("width");
	}
	
	public int[] getData() {
		return data;
	}

	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
}
