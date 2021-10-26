package levels.tile;

import graphics.Screen;
import graphics.Sprite;

public class TreeTile extends Tile {


	// constructor


	public TreeTile(Sprite sprite) {
		super(sprite);
	}


	// public methods


	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << screen.getTILESIZE_BITWISE(), y << screen.getTILESIZE_BITWISE(), this);
	}

	public boolean solid() {
		return true;
	}

}
