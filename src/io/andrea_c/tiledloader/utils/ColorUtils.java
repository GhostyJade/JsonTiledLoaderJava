package io.andrea_c.tiledloader.utils;

import java.awt.Color;

public class ColorUtils {
	
	/**
	 * 
	 * @param value an rgb color string 
	 * @return a {@link Color} object created by the value String, <code>null</code> otherwise.
	 */
	public static Color hexToColor(String value) {
		try {
			int r = Integer.parseInt(value.substring(0, 2),16);
			int g = Integer.parseInt(value.substring(2, 4),16);
			int b = Integer.parseInt(value.substring(4, 6),16);
			return new Color(r,g,b);
		}catch(Exception e) {			
			return null;
		}
	}

}
