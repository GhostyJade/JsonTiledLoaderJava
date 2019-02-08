package io.andrea_c.tiledloader;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Texture {

	private String textureFilename;
	private int textureId;
	private int[] textureData;
	
	private int x, y, width, height;

	public Texture(String filename, int id, int x, int y, int width, int height) {
		this.textureFilename = filename;
		this.textureId = id;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.textureData = new int[width * height];
		loadTexture();
	}
	
	private void loadTexture() {
		try {
			BufferedImage image = ImageIO.read(new File(textureFilename));
			image.getRGB(x, y, width, height, textureData, 0, width);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int[] getTextureIntArray() {
		return textureData;
	}

	public BufferedImage getTextureBufferedImage() {
		return null;
	}

	public int getTextureId() {
		return textureId;
	}

}
