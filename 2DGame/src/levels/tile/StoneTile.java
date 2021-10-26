package levels.tile;

import graphics.Screen;
import graphics.Sprite;

public class StoneTile extends Tile {


	// constructor


	public StoneTile(Sprite sprite) {
		super(sprite);
	}


	// public methods


	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << screen.getTILESIZE_BITWISE(), y << screen.getTILESIZE_BITWISE(), this);
	}

}
