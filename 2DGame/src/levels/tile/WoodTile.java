package levels.tile;

import graphics.Screen;
import graphics.Sprite;

public class WoodTile extends Tile {


	// constructor


	public WoodTile(Sprite sprite) {
		super(sprite);
	}


	// public methods


	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << screen.getTILESIZE_BITWISE(), y << screen.getTILESIZE_BITWISE(), this);
	}

}
