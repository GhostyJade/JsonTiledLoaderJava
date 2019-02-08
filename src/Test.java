import io.andrea_c.tiledloader.LayerLoader;
import io.andrea_c.tiledloader.TextureLoader;

public class Test {

	public static void main(String[] args) {
		TextureLoader loader = new TextureLoader("textures.json");
		System.out.println(loader);
		LayerLoader lLoader = new LayerLoader("level.json");
	}

}
