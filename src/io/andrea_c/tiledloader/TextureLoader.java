package io.andrea_c.tiledloader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import org.json.JSONObject;
import org.json.JSONTokener;

public class TextureLoader {

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
	
	public void loadTexture(int textureId) {
		
	}
	
	public List<Texture> loadTextures() {
		final int TX_SINGLE_IMAGE_WIDTH = 0;
		final int TX_SINGLE_IMAGE_HEIGHT = 0;
		for(int y = 0; y < columns; y++) {
			
		}
		return null;
	}

	@Override
	public String toString() {
		return "Columns: " + this.columns + "\nFilename: " + this.filename + "\nImage width: " + this.fileImageWidth
				+ "\nImage height: " + this.fileImageHeight + "\nMargin: " + this.margin + "\nName: " + this.sheetName
				+ "\nSpacing: " + this.spacing + "\nTile count: " + this.tileCount + "\nTile width: " + this.tileWidth
				+ "\nTile height: " + this.tileHeight + "\nType: " + this.tileType;
	}

}
