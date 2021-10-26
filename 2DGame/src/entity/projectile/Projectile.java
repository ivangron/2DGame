package entity.projectile;

import entity.Entity;
import graphics.Sprite;

import java.util.Random;

public abstract class Projectile extends Entity {

	protected final int xOrigin, yOrigin;
	protected double x,y;
	protected double angle;
	protected double nx, ny;
	protected double speed, range, damage;
	protected int actionRate;

	public final Random random = new Random();

	public Projectile(int x, int y, double dir) {
		xOrigin = x;
		yOrigin = y;
		angle = dir;
		this.x = x;
		this.y = y;
	}

	public double distance() {
		return Math.sqrt(((xOrigin-x)*(xOrigin-x)) + ((yOrigin-y)*(yOrigin-y)));
	}
	public int getActionRate() {
		return actionRate;
	}

}
