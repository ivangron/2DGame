package entity;

import graphics.Screen;
import graphics.Sprite;
import levels.Level;

import java.util.Random;

public abstract class Entity {

	protected int x, y;
	protected Sprite sprite;
	private boolean removed = false;

	protected final Random random = new Random();
	protected Level level;

	public void update(Screen screen) {
	}

	public void render(Screen screen) {
	}

	public void remove() {
		removed = true;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean isRemoved() {
		return removed;
	}

	public void init(Level level) {
		this.level = level;
	}

	public Sprite getSprite() {
		return sprite;
	}

	public int getSpriteWidth() {
		return sprite.getWidth();
	}

	public int getSpriteHeight() {
		return sprite.getHeight();
	}

}
