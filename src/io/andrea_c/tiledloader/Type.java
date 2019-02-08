package io.andrea_c.tiledloader;

public enum Type { //TODO find better name

	TILESET;
	
	public static Type getType(String s) {
		if(s.equals("tileset"))
			return TILESET;
		return null;
	}
}
