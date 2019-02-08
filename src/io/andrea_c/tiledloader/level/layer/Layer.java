package io.andrea_c.tiledloader.level.layer;

import org.json.JSONObject;

public class Layer {
	
	protected int height;
	protected int id;
	protected String name;
	protected double opacity;
	// private Type type;
	protected boolean visible;
	protected int width;
	protected int x, y;
	
	public Layer(JSONObject layerData) {
		this.height = layerData.getInt("height");
		this.id = layerData.getInt("id");
		this.name = layerData.getString("name");
		this.opacity = layerData.getDouble("opacity");
		this.visible = layerData.getBoolean("visible");
		this.width = layerData.getInt("width");
		this.x = layerData.getInt("x");
		this.opacity = layerData.getInt("y");
	}

}
