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

import java.awt.image.BufferedImage;

public class Texture {

	//private String textureFilename;
	private int textureId;
	private int[] textureData;
	
	private int x, y, width, height;

	public Texture(/*String filename,*/ int id, int x, int y, int width, int height, int textureData[]) {
		//this.textureFilename = filename;
		this.textureId = id;
		//this.x = x;
		//this.y = y;
		this.width = width;
		this.height = height;
		this.textureData = textureData; //new int[width * height];
		//loadTexture();
	}
	
	//private void loadTexture() {
		/*try {
			BufferedImage image = ImageIO.read(new File(textureFilename));
			image.getRGB(x, y, width, height, textureData, 0, width);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	//}

	public int[] getTextureIntArray() {
		return textureData;
	}

	@Deprecated
	public BufferedImage getTextureBufferedImage() {
		return null;
	}

	public int getTextureId() {
		return textureId;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}

}
