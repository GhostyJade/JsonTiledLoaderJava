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

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

/*
 ellipse	bool	Used to mark an object as an ellipse
gid	int	GID, only if object comes from a Tilemap
height	double	Height in pixels. Ignored if using a gid.
id	int	Incremental id - unique across all objects
name	string	String assigned to name field in editor
point	bool	Used to mark an object as a point
polygon	array	A list of x,y coordinates in pixels
polyline	array	A list of x,y coordinates in pixels
properties	array	A list of properties (name, value, type)
rotation	double	Angle in degrees clockwise
template	string	Reference to a template file, in case object is a template instance
text	object	String key-value pairs
type	string	String assigned to type field in editor
visible	bool	Whether object is shown in editor.
width	double	Width in pixels. Ignored if using a gid.
x	double	X coordinate in pixels
y	double	Y coordinate in pixels 
 */

/**
 * @author Andrea-C1201
 *
 */
public class Object {
	
	/**
	 * 
	 */
	private boolean ellipse;
	private int gid;
	private double height;
	private int id;
	private String name;
	private boolean point;
	//private Polygon[] poligon;
	//private Polyline[] polyline;
	private List<Property> properties = new ArrayList<Property>();
	private double rotation;
	private String template;
	private String text;
	private String type;
	private boolean visible;
	private double width;
	private double x;
	private double y;
	
	public Object(JSONObject data) {
		this.height = data.getDouble("height");
		this.id = data.getInt("id");
		//this.properties = dispatchProperties(data);
		this.visible = data.getBoolean("visible");
		this.width = data.getDouble("width");
		this.x = data.getDouble("x");
		this.y = data.getDouble("y");
	}
	
	private List<Property> dispatchProperties(JSONObject obj) {
		List<Property> temp = new ArrayList<Property>();
		JSONArray propertiesArray = obj.getJSONArray("properties");
		for(int i = 0; i < propertiesArray.length(); i++) {
			JSONObject currentObj = propertiesArray.getJSONObject(i);
			temp.add(new Property(currentObj.getString("name"), currentObj.getString("type"), currentObj.getString("value")));
		}
		return temp;
	}
	
	public double getHeight() {
		return height;
	}
	
	public double getWidth() {
		return width;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public List<Property> getProperties() {
		return properties;
	}
	
	public boolean hasProperties() {
		return !properties.isEmpty();
	}
	
	//TODO
	public Property getPropertyByName(String name) {
		return null;
	}
	
}
