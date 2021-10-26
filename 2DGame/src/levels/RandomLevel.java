package levels;

import java.util.Random;

public class RandomLevel extends Level {

	private final Random random = new Random();


	// constructors


	public RandomLevel(int width, int height) {
		super(width, height);
		generateLevel();
	}


	// methods

	// height and width is in Tiles
	protected void generateLevel() {
		for(int x=0; x<height; x++) {
			for(int y=0; y<width; y++) {
				tilesInt[x + y * width] = random.nextInt(4);
			}
		}
	}
}
