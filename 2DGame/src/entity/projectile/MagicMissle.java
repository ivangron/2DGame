package entity.projectile;

import entity.spawner.ParticleSpawner;
import graphics.Screen;
import graphics.Sprite;

public class MagicMissle extends Projectile {

	public MagicMissle(int x, int y, double dir) {
		super(x, y, dir);
		range = 1000;
		speed = 6;
		damage = 20;
		sprite = Sprite.magicMissle;
		nx = speed * Math.cos(dir);
		ny = speed * Math.sin(dir);
		actionRate = 10;
	}

	public void update(Screen screen) {
		byte collisionType = level.tileCollision((x+nx), (y+ny), 32, 12, 13, 12, 13);
		if (collisionType != -1) {
			int xoffset = 16, yoffset = 16;
			if(collisionType == 1) {  // top left corner collides
				xoffset = 13;
				yoffset = 13;
			} else if(collisionType == 2) { // top right corner collides
				xoffset = 19;
				yoffset = 13;
			} else if(collisionType == 3) { // bottom left corner collides
				xoffset = 13;
				yoffset = 19;
			} else if(collisionType == 4) { // bottom right corner collides
				xoffset = 19;
				yoffset = 19;
			}
			level.add(new ParticleSpawner((int)x+xoffset, (int)y+yoffset, 500, 37, level, angle));
			remove();
		}
		move();
	}

	protected void move() {
		if (level.tileCollision((x+nx), (y+ny), 32, 12, 13, 12, 13) == -1) {
			x += nx;
			y += ny;
		}
		if (distance() >= range) {
			remove();
		}
	}

	public void render(Screen screen) {
		screen.renderProjectile((int) (x), (int) (y), this);
	}
}
