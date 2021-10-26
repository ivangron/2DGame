package graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpriteSheet {

	private String path;
	public final int WIDTH, HEIGHT;

	public int[] pixels;

	public static SpriteSheet Tiles           = new SpriteSheet("/texture/SpriteSheet.png", 256, 256);
	public static SpriteSheet LothlorienTiles = new SpriteSheet("/texture/floortileset.png", 256, 256);


	public static SpriteSheet queen          = new SpriteSheet("/texture/queen.png", 128, 96);
	public static SpriteSheet queen_up       = new SpriteSheet(queen, 0, 0, 1, 3, 32);
	public static SpriteSheet queen_right    = new SpriteSheet(queen, 1, 0, 1, 3, 32);
	public static SpriteSheet queen_down     = new SpriteSheet(queen, 2, 0, 1, 3, 32);
	public static SpriteSheet queen_left     = new SpriteSheet(queen, 3, 0, 1, 3, 32);

	public static SpriteSheet king            = new SpriteSheet("/texture/king.png", 128, 96);
	public static SpriteSheet king_up         = new SpriteSheet(king, 0, 0, 1, 3, 32);
	public static SpriteSheet king_right      = new SpriteSheet(king, 1, 0, 1, 3, 32);
	public static SpriteSheet king_down       = new SpriteSheet(king, 2, 0, 1, 3, 32);
	public static SpriteSheet king_left       = new SpriteSheet(king, 3, 0, 1, 3, 32);

	public static SpriteSheet flyG            = new SpriteSheet("/texture/modflygirl.png",512,384);
	public static SpriteSheet flyG_up         = new SpriteSheet(flyG, 0, 3, 8, 1, 64, 96);
	public static SpriteSheet flyG_right      = new SpriteSheet(flyG, 0, 2, 8, 1, 64, 96);
	public static SpriteSheet flyG_down       = new SpriteSheet(flyG, 0, 0, 8, 1, 64, 96);
	public static SpriteSheet flyG_left       = new SpriteSheet(flyG, 0, 1, 8, 1, 64, 96);

	protected Sprite[] sprites;

	public SpriteSheet(SpriteSheet sheet, int x, int y, int width, int height, int spriteSize) {
		this(sheet, x, y, width, height, spriteSize, spriteSize);
	}

	public SpriteSheet(SpriteSheet sheet, int x, int y, int width, int height, int spriteWidth, int spriteHieght) {
		int xx = x * spriteWidth;
		int yy = y * spriteHieght;
		int w = width * spriteWidth;
		int h = height * spriteHieght;
		WIDTH = w;
		HEIGHT = h;
		pixels = new int[w * h];

		for (int y0 = 0; y0 < h; y0++) {
			int yp = yy + y0;
			for (int x0 = 0; x0 < w; x0++) {
				int xp = xx + x0;
				pixels[x0 + y0 * w] = sheet.pixels[xp + yp * sheet.WIDTH];
			}
		}

		int frame = 0;
		sprites = new Sprite[width * height];
		for (int ya = 0; ya < height; ya++) {
			for (int xa = 0; xa < width; xa++) {
				int[] spritePixels = new int[spriteWidth * spriteHieght];
				for (int y0 = 0; y0 < spriteHieght; y0++) {
					for (int x0 = 0; x0 < spriteWidth; x0++) {
						spritePixels[x0 + y0 * spriteWidth] = pixels[ (x0 + xa * spriteWidth) + (y0 + ya * spriteHieght) * WIDTH];
					}
				}
				sprites[frame++] = new Sprite(spritePixels, spriteWidth, spriteHieght);
			}
		}
	}


	public SpriteSheet(String path, int width, int height) {
		this.path = path;
		this.WIDTH = width;
		this.HEIGHT = height;
		pixels = new int[width*height];
		load();
	}

	public Sprite[] getSprites() {
		return sprites;
	}

	private void load() {
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			int width = image.getWidth();
			int height = image.getHeight();
			image.getRGB(0,0, width, height, pixels, 0, width);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}