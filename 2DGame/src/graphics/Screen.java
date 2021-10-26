package graphics;

import entity.projectile.Projectile;
import levels.tile.Tile;

public class Screen {

	private final int OPEC = 0xffff00ff;
	private int width, height, scale;
	// My tile... make sure mapsize is a multiple of 2^? for bitwise operations
	private final int TILESIZE = 32;
	private final int TILESIZE_OFFSET = TILESIZE - 1;  // mapsize - 1 because index starts at 0
	private final int TILESIZE_BITWISE = 5;  // (2)^TILESIZE_BITWISE=TILESIZE;  the mapsize needs to be multiple of 2  -- 2/4/8/16/32/64/128/256/512/1024/2048
	private int[] pixels;

	public int xOffset, yOffset;


	// Constructors


	public Screen(int width, int height) {
		this(width, height, 1);
	}

	public Screen(int width, int height, int scale) {
		this.width = width;
		this.height = height;
		this.scale = scale;
		pixels = new int[width * height];
	}


	// methods


	public void clear() {
		for (int i = 0; i < pixels.length; i++) {  // iterate through every pixels on y axis
			pixels[i] = 0x000000; // filling the pixel at coord with hex value for black
		}
	}

	public void renderSheet(int xp, int yp, SpriteSheet sheet, boolean fixed) {
		try {
			if (fixed) {
				xp -= xOffset;
				yp -= yOffset;
			}
			for (int y = 0; y < sheet.HEIGHT; y++) {
				int yA = y + yp;
				for (int x = 0; x < sheet.WIDTH; x++) {
					int xA = x + xp;
					if (xA < 0 || xA >= width || yA < 0 || yA >= height)
						continue;  // we do not want to draw pixels outside of bounds
					int color = sheet.pixels[x + y * sheet.WIDTH];
					if (color != OPEC)
						pixels[xA + yA * width] = color;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void renderSprite(int xp, int yp, Sprite sprite, boolean fixed) {
		try {
			if (fixed) {
				xp -= xOffset;
				yp -= yOffset;
			}
			for (int y = 0; y < sprite.getHeight(); y++) {
				int yA = y + yp;
				for (int x = 0; x < sprite.getWidth(); x++) {
					int xA = x + xp;
					if (xA < 0 || xA >= width || yA < 0 || yA >= height)
						continue;  // we do not want to draw pixels outside of bounds
					int color = sprite.pixels[x + y * sprite.getWidth()];
					if (color != OPEC)
						pixels[xA + yA * width] = color;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void renderTile(int xP, int yP, Tile tile) {
		try {
			xP -= xOffset;
			yP -= yOffset;
			for (int y = 0; y < tile.sprite.getHeight(); y++) {
				int yA = y + yP;
				for (int x = 0; x < tile.sprite.getWidth(); x++) {
					int xA = x + xP;
					if (xA < -tile.sprite.getWidth() || xA >= width || yA < 0 || yA >= height)
						break;
					if (xA < 0)
						xA = 0;
					int color = tile.sprite.pixels[x + y * tile.sprite.getWidth()];
					if (color != OPEC)
						pixels[xA + yA * width] = color;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void renderProjectile(int xP, int yP, Projectile p) {
		try {
			xP -= xOffset;
			yP -= yOffset;
			for (int y = 0; y < p.getSpriteHeight(); y++) {
				int yA = y + yP;
				for (int x = 0; x < p.getSpriteWidth(); x++) {
					int xA = x + xP;
					if (xA < -p.getSpriteWidth() || xA >= width || yA < 0 || yA >= height)
						break;
					if (xA < 0)
						xA = 0;
					int color = p.getSprite().pixels[x + y * p.getSpriteWidth()];
					if (color != OPEC)
						pixels[xA + yA * width] = color;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void renderMob(int xP, int yP, Sprite sprite) {
		renderMob(xP, yP, sprite, 0);
	}

	public void renderMob(int xP, int yP, Sprite sprite, int flip) {
		xP -= xOffset;
		yP -= yOffset;
		for (int y = 0; y < sprite.getHeight(); y++) {
			int yA = y + yP;
			int yS = y;
			if (flip == 2 || flip == 3)
				yS = (sprite.getHeight() - 1) - y;
			for (int x = 0; x < sprite.getWidth(); x++) {
				int xA = x + xP;
				int xS = x;
				if (flip == 1 || flip == 3)
					xS = (sprite.getWidth() - 1) - x;
				if (xA < -sprite.getWidth() || xA >= width || yA < 0 || yA >= height)
					break;
				if (xA < 0)
					xA = 0;
				int color = sprite.pixels[xS + yS * sprite.getWidth()];
				if (color != OPEC)
					pixels[xA + yA * width] = color;
			}
		}
	}

	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}


	// getters and setters


	public int getPixel(int i) {
		return pixels[i];
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getScale() {
		return scale;
	}

	public int getTILESIZE() {
		return TILESIZE;
	}

	public int getTILESIZE_OFFSET() {
		return TILESIZE_OFFSET;
	}

	public int getTILESIZE_BITWISE() {
		return TILESIZE_BITWISE;
	}
}