package io.andrea_c.tiledloader.exceptions;

public class LayerNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	private String layerName;

	public LayerNotFoundException(String layerName) {
		this.layerName = layerName;
	}
	
	public String getLayerName() {
		return layerName;
	}
}
