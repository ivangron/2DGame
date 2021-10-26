package entity.mob;

import entity.projectile.MagicMissle;
import entity.projectile.Projectile;
import graphics.AnimatedSprite;
import graphics.Screen;
import graphics.SpriteSheet;
import input.KeyBoard;
import input.Mouse;

public class Player extends NPC {
	private KeyBoard input;
	private int actionRate = 0;
	private int moveSpeed = 2;

	private int pHealth, pStamina, pMana, pExperience, pLevel;

	private AnimatedSprite down = new AnimatedSprite(SpriteSheet.flyG_down, 64, 96, 8);
	private AnimatedSprite up = new AnimatedSprite(SpriteSheet.flyG_up, 64, 96, 8);
	private AnimatedSprite left = new AnimatedSprite(SpriteSheet.flyG_left, 64, 96, 8);
	private AnimatedSprite right = new AnimatedSprite(SpriteSheet.flyG_right, 64, 96, 8);
	private AnimatedSprite currentSprite;

	public Player(int x, int y, KeyBoard input) {
		this.x = x;
		this.y = y;
		this.input = input;
		currentSprite = down;
	}

	public void update(Screen screen) {
		if(walking) {
			currentSprite.update();
		} else {
			currentSprite.resting();
		}

		int xA = 0, yA = 0;
		if (input.up) {
			yA=yA-moveSpeed;
			currentSprite = up;
		}
		if (input.down) {
			yA=yA+moveSpeed;
			currentSprite = down;
		}
		if (input.left) {
			xA=xA-moveSpeed;
			currentSprite = left;
		}
		if (input.right) {
			xA=xA+moveSpeed;
			currentSprite = right;
		}

		walking = move(xA, yA);
		updateAction(screen);
		clear();
	}

	protected void updateAction(Screen screen) {
		double dx = Mouse.getX() - (screen.getWidth()*screen.getScale()/2);
		double dy = Mouse.getY() - (screen.getHeight()*screen.getScale()/2);
		double dir = Math.atan2(dy,dx);
		if(Mouse.getButton() == 1) {
			int xx = Math.abs(dir) <= 1.5 ? 4 : 28;
			int yy = 12;
			if(currentSprite.equals(left)) {
				xx = 18;
			} else if(currentSprite.equals(right)) {
				xx = 10;
			}
			Projectile p = new MagicMissle(x-xx, y-yy, dir);
			p.init(level);
			if(actionRate > p.getActionRate()) {
				shoot(x,y, dir, p);
				actionRate = 0;
			}
		}
		if(actionRate < 10000) {
			actionRate++;
		}
	}

	private void clear() {
		for(int i = 0; i < level.getProjectiles().size(); i++) {
			Projectile p = level.getProjectiles().get(i);
			if(p.isRemoved()) level.getProjectiles().remove(i);
		}
	}

	public void render(Screen screen) {
		screen.renderMob((x - (currentSprite.getSprite().getWidth() / 2)), (y - (currentSprite.getSprite().getHeight() / 2)), currentSprite.getSprite());
	}
}
