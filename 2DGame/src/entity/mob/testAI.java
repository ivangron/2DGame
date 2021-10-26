package entity.mob;

import graphics.AnimatedSprite;
import graphics.Screen;
import graphics.SpriteSheet;
import input.KeyBoard;

public class testAI extends NPC {
	private int actionRate = 0;
	private int moveSpeed = 2;

	private int pHealth, pStamina, pMana, pExperience, pLevel;

	private AnimatedSprite down = new AnimatedSprite(SpriteSheet.queen_down, 32, 32, 3);
	private AnimatedSprite up = new AnimatedSprite(SpriteSheet.queen_up, 32, 32, 3);
	private AnimatedSprite left = new AnimatedSprite(SpriteSheet.queen_left, 32, 32, 3);
	private AnimatedSprite right = new AnimatedSprite(SpriteSheet.queen_right, 32, 32, 3);
	private AnimatedSprite currentSprite;

	public testAI(int x, int y, KeyBoard input) {
		this.x = x;
		this.y = y;
		currentSprite = down;
	}

	public void update(Screen screen) {
		if(walking) {
			currentSprite.update();
		} else {
			currentSprite.resting();
		}
		int xA = 0, yA = 0;
		if (yA > 0) {
			currentSprite = up;
		}
		if (yA < 0 ) {
			currentSprite = down;
		}
		if (xA < 0) {
			currentSprite = left;
		}
		if (xA > 0) {
			currentSprite = right;
		}
		walking = move(xA, yA);
	}

	public void render(Screen screen) {
		screen.renderMob((x - (currentSprite.getSprite().getWidth() / 2)), (y - (currentSprite.getSprite().getHeight() / 2)), currentSprite.getSprite());
	}
}
