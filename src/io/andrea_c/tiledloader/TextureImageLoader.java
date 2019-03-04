package io.andrea_c.tiledloader;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

public class TextureImageLoader {

	private Map<Integer, Texture> textureMap = new HashMap<Integer, Texture>();
	private TextureLoader loader;

	public TextureImageLoader(TextureLoader loader) {
		this.loader = loader;
	}

	public void loadTextures() {
		loadTextures(loader.getFilename());
	}
	
	//TODO check this
	public void loadTextures(FileInputStream stream) {
		try {
			BufferedImage image = ImageIO.read(stream);
			final int width = loader.getTileWidth();
			final int height = loader.getTileHeight();
			final int cols = loader.getColumns();
			final int rows = loader.getFileImageWidth() / loader.getTileHeight();
			//BufferedImage[] sprites = new BufferedImage[rows * cols];
			List<BufferedImage> sprites = new ArrayList<BufferedImage>();
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					//sprites[(i * cols) + j] = image.getSubimage(j * width, i * height, width, height);
					sprites.add(image.getSubimage(j * width, i * height, width, height));
				}
			}
			Collections.reverse(sprites);
			for (int i = 0; i < sprites.size(); i++) {
				BufferedImage img = sprites.get(i);
				int w = img.getWidth();
				int h = img.getHeight();
				int pixels[] = new int[w*h];
				img.getRGB(0, 0, w, h, pixels, 0, w);
				textureMap.put(i, new Texture(i, 0, 0, w, h, pixels));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadTextures(String filename) {
		try {
			loadTextures(new FileInputStream(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Texture getTextureById(int id) {
		return this.textureMap.get(id);
	}

}
