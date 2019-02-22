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

import org.json.JSONObject;
import org.json.JSONTokener;

public class TextureLoader {
	
	//load tilesets

	private String jsonFileName;

	private int columns;
	private String filename;
	private int fileImageWidth, fileImageHeight;
	private int margin;
	private String sheetName;
	private int spacing;
	private int tileCount;
	private int tileWidth, tileHeight;
	private Type tileType;

	public TextureLoader(String jsonFilename) {
		this.jsonFileName = jsonFilename;
		this.readInformationFile();
	}

	private void readInformationFile() {
		try {
			JSONTokener tokener = new JSONTokener(new FileInputStream(jsonFileName));
			JSONObject root = new JSONObject(tokener);
			this.columns = root.getInt("columns");
			this.filename = root.getString("image");
			this.fileImageHeight = root.getInt("imageheight");
			this.fileImageWidth = root.getInt("imagewidth");
			this.margin = root.getInt("margin");
			this.sheetName = root.getString("name");
			this.spacing = root.getInt("spacing");
			this.tileCount = root.getInt("tilecount");
			this.tileWidth = root.getInt("tilewidth");
			this.tileHeight = root.getInt("tileheight");
			this.tileType = Type.getType(root.getString("type"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "Columns: " + this.columns + "\nFilename: " + this.filename + "\nImage width: " + this.fileImageWidth
				+ "\nImage height: " + this.fileImageHeight + "\nMargin: " + this.margin + "\nName: " + this.sheetName
				+ "\nSpacing: " + this.spacing + "\nTile count: " + this.tileCount + "\nTile width: " + this.tileWidth
				+ "\nTile height: " + this.tileHeight + "\nType: " + this.tileType;
	}
	
	public String getFilename() {
		return filename;
	}
	
	public int getColumns() {
		return columns;
	}
	
	public int getTileCount() {
		return tileCount;
	}
	
	public int getTileWidth() {
		return tileWidth;
	}
	
	public int getTileHeight() {
		return tileHeight;
	}
	
	public int getFileImageWidth() {
		return fileImageWidth;
	}
	
	public int getFileImageHeight() {
		return fileImageHeight;
	}

}
