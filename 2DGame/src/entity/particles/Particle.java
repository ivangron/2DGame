package entity.particles;

import entity.Entity;
import graphics.Screen;
import graphics.Sprite;

public class Particle extends Entity {
	private int life;
	protected double xa, ya, zz;
	protected double xx, yy, za;


	public Particle(int x, int y, int life, double angle) {
		this.x = x;
		this.y = y;
		this.xx = x;
		this.yy = y;

		this.life = life;
		sprite = Sprite.particle;
		this.xa = (double) (random.nextInt(200)-100) /100;
		this.ya = (double) (random.nextInt(200)-100) /100;
		this.zz = random.nextFloat();
	}

	public void update(Screen screen) {
		if(life <= 0) remove();
		life--;
		za -= 0.1;

		if(zz < 0) {
			zz = 0;
			za *= -.5;
			xa *= .4;
			ya *= .4;
		}
		move(xx + xa, (yy + ya) + (zz+za));
	}

	public void move(double x, double y) {
		if(collision(x, y)) {
			this.xa *= -.4;
			this.ya *= -.4;
			this.za *= -.4;
		}
		this.xx += xa;
		this.yy += ya;
		this.zz += za;
	}

	public boolean collision(double x, double y) {
//		for(int c = 0; c < 4; c++) {
//			double xt = (x + c % 2 * sprite.getSize()) / 32;
//			double yt = (y + c / 2 * sprite.getSize()) / 32;
//			if (level.getTile((int)xt, (int)yt).solid()) return true;
//		}

		// top left corner
		double xt = (x) / 32;
		double yt = (y) / 32;
		if (level.getTile((int)xt, (int)yt).solid()) return true;
		// top right corner
		xt = (x + sprite.getWidth()-1) / 32;
		yt = (y) / 32;
		if (level.getTile((int)xt, (int)yt).solid()) return true;
		// bottom left corneraw
		xt = (x) / 32;
		yt = (y + sprite.getHeight()-1) / 32;
		if (level.getTile((int)xt, (int)yt).solid()) return true;
		// bottom right corner
		xt = (x + sprite.getWidth()-1) / 32;
		yt = (y + sprite.getHeight()-1) / 32;
		if (level.getTile((int)xt, (int)yt).solid()) return true;

		return false;
	}

	public void render(Screen screen) {
		screen.renderSprite((int)xx, (int)yy - (int) zz, sprite, true);
	}
}