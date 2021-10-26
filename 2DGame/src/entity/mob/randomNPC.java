package entity.mob;

import graphics.AnimatedSprite;
import graphics.Screen;
import graphics.SpriteSheet;

public class randomNPC extends NPC {

	private AnimatedSprite down  = new AnimatedSprite(SpriteSheet.queen_down, 32, 32, 3);
	private AnimatedSprite up    = new AnimatedSprite(SpriteSheet.queen_up, 32, 32, 3);
	private AnimatedSprite left  = new AnimatedSprite(SpriteSheet.queen_left, 32, 32, 3);
	private AnimatedSprite right = new AnimatedSprite(SpriteSheet.queen_right, 32, 32, 3);
	private AnimatedSprite currentSprite = down;
	private int xA, yA, movementSpeed;
	private int time;

	public randomNPC(int x, int y, int movementSpeed) {
		this.x = x << 5;
		this.y = y << 5;
		this.movementSpeed = movementSpeed;
	}

	public void update(Screen screen) {
		time++;
		if(time % (random.nextInt(60)+60) == 0) {
			xA = (random.nextInt(3)-1)*movementSpeed;
			yA = (random.nextInt(3)-1)*movementSpeed;
			if(random.nextInt(3) != 0) {
				xA = 0;
				yA = 0;
			}
		}

		if(walking) {
			currentSprite.update();
		} else {
			currentSprite = down;
			currentSprite.resting();
		}

		if (yA < 0) {
			currentSprite = up;
		}
		if (yA > 0) {
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


