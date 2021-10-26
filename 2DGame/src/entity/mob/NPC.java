package entity.mob;

import entity.Entity;
import entity.projectile.Projectile;
import graphics.Screen;

public abstract class NPC extends Entity {

	protected boolean walking = false;

	protected enum Direction {
		UP, DOWN, LEFT, RIGHT, UP_LEFT, UP_RIGHT, DOWN_LEFT, DOWN_RIGHT
	}

	protected Direction dir;


	protected boolean move(int xA, int yA) {
		if (yA > 0) {
			dir = Direction.DOWN;
		} else if (yA < 0) {
			dir = Direction.UP;
		} else if (xA > 0) {
			dir = Direction.RIGHT;
		} else if (xA < 0) {
			dir = Direction.LEFT;
		} else {
			return false;
		}

		if (collision(xA, 0) && collision(0, yA)) {
			return false;
		} else if(collision(xA, 0)) {
			if(yA != 0) {
				y += yA;
			} else {
				return false;
			}
		} else if(collision(0, yA)) {
			if(xA != 0) {
				x += xA;
			} else {
				return false;
			}
		} else {
			x += xA;
			y += yA;
		}
		return true;
	}

//	public void move(int xA, int yA) {
//		if (xA != 0 && yA != 0) {
//			move(xA, 0);
//			move(0, yA);
//			return;
//		}
//		if (xA > 0) {
//			dir = Direction.RIGHT;
//		} else if (xA < 0) {
//			dir = Direction.LEFT;
//		} else if (yA > 0) {
//			dir = Direction.DOWN;
//		} else if (yA < 0) {
//			dir = Direction.UP;
//		}
//		if (!collision(xA, yA)) {
//			x += xA;
//			y += yA;
//		}
//	}

	public abstract void update(Screen screen);

	public abstract void render(Screen screen);

	protected void shoot(int x, int y, double dir, Projectile projectile) {
		level.add(projectile);
	}

	protected boolean collision(int xMovement, int yMovement) {
		for (int c = 0; c < 4; c++) {
			int xt = ((x + xMovement) + c % 2 * 18 - 10) / 32;
			int yt = ((y + yMovement) + c / 2 * 9 + 5) / 32;
			if (level.getTile(xt, yt).solid())
				return true;
		}
		return false;
	}
}
