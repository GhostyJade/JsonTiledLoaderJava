package io.andrea_c.tiledloader.types;

/*
name: The name of the property.
type: The type of the property. Can be string (default), int, float, bool, color or file (since 0.16, with color and file added in 0.17).
value: The value of the property.
 */

public class Property {

	private String name;
	private String type;
	private String value;

	public Property(String name, String type, String value) {
		this.name = name;
		this.type = type;
		this.value = value;
	}
	
	public Property() {
	}

	public String getName() {
		return name;
	}

	public int getIntValue() {
		return Integer.parseInt(value);
	}
	
	public float getFloatValue() {
		return Float.parseFloat(name);
	}

	public String getStringValue() {
		return value;
	}

	public double getDoubleValue() {
		return Double.parseDouble(name);
	}
	
	public boolean getBooleanValue() {
		return Boolean.parseBoolean(name);
	}
	
	//TODO implement color and file

}
