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
import javax.sound.midi.Soundbank;

import io.andrea_c.tiledloader.LayerLoader;
import io.andrea_c.tiledloader.TextureImageLoader;
import io.andrea_c.tiledloader.TextureLoader;
import io.andrea_c.tiledloader.exceptions.LayerNotFoundException;
import io.andrea_c.tiledloader.level.layer.LayerType;
import io.andrea_c.tiledloader.level.layer.TileLayer;
import io.andrea_c.tiledloader.utils.ColorUtils;

public class Test {

	public static void main(String[] args) {
		testColor();
		TextureLoader loader = new TextureLoader("textures.json");
		System.out.println(loader);
		LayerLoader lLoader = new LayerLoader("level.json");
		//Soundbank
		System.out.println(lLoader);
		
		TextureImageLoader imgLoader = new TextureImageLoader(loader);
		imgLoader.loadTextures();
		
		LayerLoader layerLoader = new LayerLoader("level.json"); 
		try {
			TileLayer layer = (TileLayer) layerLoader.loadLayer("Texture", LayerType.TILE_LAYER);
			System.out.println(layer);
		} catch (LayerNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static void testColor() {
		System.out.println(ColorUtils.hexToColor("ff00ff"));
		System.out.println(ColorUtils.hexToColor("ff0000"));
		System.out.println(ColorUtils.hexToColor("00ff00"));
		System.out.println(ColorUtils.hexToColor("0000ff"));
		System.out.println(ColorUtils.hexToColor("000000"));
		System.out.println(ColorUtils.hexToColor("ffffff"));
	}

}
