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
package io.andrea_c.tiledloader.types;

import org.json.JSONObject;

public class Layer {
	
	protected int id;
	protected String name;
	protected double opacity;
	// private Type type;
	protected boolean visible;
	protected int x, y;
	
	public Layer(JSONObject layerData) {
		this.id = layerData.getInt("id");
		this.name = layerData.getString("name");
		this.opacity = layerData.getDouble("opacity");
		this.visible = layerData.getBoolean("visible");
		this.x = layerData.getInt("x");
		this.y = layerData.getInt("y");
	}
	
}
