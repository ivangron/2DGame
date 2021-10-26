package graphics;

public class Sprite {
	private int width, height;
	private int x, y;
	public int[] pixels;
	protected SpriteSheet sheet;

	public static Sprite voidSprite = new Sprite(32, 0x1B87E0);

	public static Sprite grass = new Sprite(32, 32, 0,0, SpriteSheet.Tiles);
	public static Sprite magicMissle = new Sprite(32, 32, 2,0, SpriteSheet.Tiles);
	public static Sprite mmWall = new Sprite(32, 32, 2,1, SpriteSheet.Tiles);
	public static Sprite woodFloorTile = new Sprite(32, 32, 3,2, SpriteSheet.Tiles);

	public static Sprite treeTL = new Sprite(32, 32, 0,1, SpriteSheet.Tiles);
	public static Sprite treeTR = new Sprite(32, 32, 1,1, SpriteSheet.Tiles);
	public static Sprite treeBL = new Sprite(32, 32, 0,2, SpriteSheet.Tiles);
	public static Sprite treeBR = new Sprite(32, 32, 1,2, SpriteSheet.Tiles);

	public static Sprite stoneTileClean = new Sprite(32, 32, 0,0, SpriteSheet.LothlorienTiles);
	public static Sprite stoneTileDirty = new Sprite(32, 32, 1,0, SpriteSheet.LothlorienTiles);
	public static Sprite stoneTileGrass1 = new Sprite(32, 32, 2,0, SpriteSheet.LothlorienTiles);
	public static Sprite stoneTileGrass2 = new Sprite(32, 32, 3,0, SpriteSheet.LothlorienTiles);
	public static Sprite stoneTileGrass3 = new Sprite(32, 32, 4,0, SpriteSheet.LothlorienTiles);
	public static Sprite stoneTileFancy1 = new Sprite(32, 32, 5,0, SpriteSheet.LothlorienTiles);
	public static Sprite stoneTileFancy2 = new Sprite(32, 32, 6,0, SpriteSheet.LothlorienTiles);
	public static Sprite stoneTileFancy3 = new Sprite(32, 32, 7,0, SpriteSheet.LothlorienTiles);

	public static Sprite stoneTileWeed = new Sprite(32, 32, 0,1, SpriteSheet.LothlorienTiles);
	public static Sprite stoneTileIce = new Sprite(32, 32, 1,1, SpriteSheet.LothlorienTiles);
	public static Sprite stoneTileGrass4 = new Sprite(32, 32, 2,1, SpriteSheet.LothlorienTiles);
	public static Sprite stoneTileGrass5 = new Sprite(32, 32, 3,1, SpriteSheet.LothlorienTiles);
	public static Sprite stoneTileGrass6 = new Sprite(32, 32, 4,1, SpriteSheet.LothlorienTiles);
	public static Sprite stoneTileBroken = new Sprite(32, 32, 5,1, SpriteSheet.LothlorienTiles);
	public static Sprite stoneTileStringDrawings1 = new Sprite(32, 32, 6,1, SpriteSheet.LothlorienTiles);
	public static Sprite stoneTileStringDrawings2 = new Sprite(32, 32, 7,1, SpriteSheet.LothlorienTiles);

	public static Sprite grassTileHealthy4 = new Sprite(32, 32, 0,2, SpriteSheet.LothlorienTiles);
	public static Sprite grassTileHealthy3 = new Sprite(32, 32, 1,2, SpriteSheet.LothlorienTiles);
	public static Sprite grassTileHealthy2 = new Sprite(32, 32, 2,2, SpriteSheet.LothlorienTiles);
	public static Sprite grassTileHealthy1 = new Sprite(32, 32, 3,2, SpriteSheet.LothlorienTiles);
	public static Sprite stoneTileGranite = new Sprite(32, 32, 4,2, SpriteSheet.LothlorienTiles);
	public static Sprite stoneTileGraniteRaised = new Sprite(32, 32, 5,2, SpriteSheet.LothlorienTiles);
	public static Sprite stoneTileGraniteRaisedDesign = new Sprite(32, 32, 6,2, SpriteSheet.LothlorienTiles);
	public static Sprite stoneTileGraniteFlat = new Sprite(32, 32, 7,2, SpriteSheet.LothlorienTiles);

	public static Sprite stoneTileDirtCovered = new Sprite(32, 32, 0,3, SpriteSheet.LothlorienTiles);
	public static Sprite dirtTile = new Sprite(32, 32, 1,3, SpriteSheet.LothlorienTiles);
	public static Sprite dirtTileTriBroken = new Sprite(32, 32, 2,3, SpriteSheet.LothlorienTiles);
	public static Sprite dirtTileTri = new Sprite(32, 32, 3,3, SpriteSheet.LothlorienTiles);
	public static Sprite stoneTilePattern1 = new Sprite(32, 32, 4,3, SpriteSheet.LothlorienTiles);
	public static Sprite stoneTilePattern2 = new Sprite(32, 32, 5,3, SpriteSheet.LothlorienTiles);
	public static Sprite stoneTilePattern3 = new Sprite(32, 32, 6,3, SpriteSheet.LothlorienTiles);
	public static Sprite stoneTilePattern4 = new Sprite(32, 32, 7,3, SpriteSheet.LothlorienTiles);

	public static Sprite brickTileFloorWhite = new Sprite(32, 32, 0,4, SpriteSheet.LothlorienTiles);
	public static Sprite brickTileFloorDarkRed = new Sprite(32, 32, 1,4, SpriteSheet.LothlorienTiles);
	public static Sprite brickTileFloorRedEdged = new Sprite(32, 32, 2,4, SpriteSheet.LothlorienTiles);
	public static Sprite brickTileSolid = new Sprite(32, 32, 3,4, SpriteSheet.LothlorienTiles);
	public static Sprite brickTileRed = new Sprite(32, 32, 4,4, SpriteSheet.LothlorienTiles);
	public static Sprite brickTileSmoke = new Sprite(32, 32, 5,4, SpriteSheet.LothlorienTiles);
	public static Sprite brickTileNormal = new Sprite(32, 32, 6,4, SpriteSheet.LothlorienTiles);
	public static Sprite brickTileNormalBotRigShading = new Sprite(32, 32, 7,4, SpriteSheet.LothlorienTiles);

	public static Sprite brickTileNormalRigShading = new Sprite(32, 32, 0,5, SpriteSheet.LothlorienTiles);
	public static Sprite brickTileNormalTopRigShading = new Sprite(32, 32, 1,5, SpriteSheet.LothlorienTiles);
	public static Sprite brickTileNormalFullShading = new Sprite(32, 32, 2,5, SpriteSheet.LothlorienTiles);
	public static Sprite brickTileUnderWaterDeep = new Sprite(32, 32, 3,5, SpriteSheet.LothlorienTiles);
	public static Sprite brickTileUnderWaterShallow = new Sprite(32, 32, 4,5, SpriteSheet.LothlorienTiles);
	public static Sprite brickTileUnderWaterFull = new Sprite(32, 32, 5,5, SpriteSheet.LothlorienTiles);
	public static Sprite brickTileUnderIce = new Sprite(32, 32, 6,5, SpriteSheet.LothlorienTiles);
	public static Sprite snowTile1 = new Sprite(32, 32, 7,5, SpriteSheet.LothlorienTiles);

	public static Sprite dirtTile1 = new Sprite(32, 32, 0,6, SpriteSheet.LothlorienTiles);
	public static Sprite dirtTile2 = new Sprite(32, 32, 1,6, SpriteSheet.LothlorienTiles);
	public static Sprite dirtTile3 = new Sprite(32, 32, 2,6, SpriteSheet.LothlorienTiles);
	public static Sprite dirtTile4 = new Sprite(32, 32, 3,6, SpriteSheet.LothlorienTiles);
	public static Sprite snowTile2 = new Sprite(32, 32, 4,6, SpriteSheet.LothlorienTiles);
	public static Sprite snowTile3 = new Sprite(32, 32, 5,6, SpriteSheet.LothlorienTiles);
	public static Sprite snowTileWater = new Sprite(32, 32, 6,6, SpriteSheet.LothlorienTiles);
	public static Sprite snowTile4 = new Sprite(32, 32, 7,6, SpriteSheet.LothlorienTiles);

	public static Sprite grassTileWeed = new Sprite(32, 32, 0,7, SpriteSheet.LothlorienTiles);
	public static Sprite grassTileWeedClean = new Sprite(32, 32, 1,7, SpriteSheet.LothlorienTiles);
	public static Sprite grassTileFloorSeed = new Sprite(32, 32, 2,7, SpriteSheet.LothlorienTiles);
	public static Sprite grassTileFloorSprout = new Sprite(32, 32, 3,7, SpriteSheet.LothlorienTiles);
	public static Sprite grassTileFloorYoung = new Sprite(32, 32, 4,7, SpriteSheet.LothlorienTiles);
	public static Sprite grassTileFloorBloom = new Sprite(32, 32, 5,7, SpriteSheet.LothlorienTiles);
	public static Sprite grassTileFloorDeath = new Sprite(32, 32, 6,7, SpriteSheet.LothlorienTiles);
	public static Sprite grassTileFloorClean = new Sprite(32, 32, 7,7, SpriteSheet.LothlorienTiles);

	public static Sprite particle = new Sprite(1, 0xff0ED9EC);



	protected Sprite(SpriteSheet sheet, int width, int height) {
		this.width = width;
		this.height = height;
		this.sheet = sheet;
	}

	public Sprite(int width, int height, int x, int y, SpriteSheet sheet) {
		this(width, height, x, y, sheet, false);
	}

	public Sprite(int width, int height, int x, int y, SpriteSheet sheet, boolean flip) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		this.x = x * width;
		this.y = y * height;
		this.sheet = sheet;
		load();
	}

	public Sprite(int[] pixels, int width, int height) {
		this.width = width;
		this.height = height;
		this.pixels = pixels;
	}

	public Sprite(int width, int height, int colour) {
		this.width = width;
		this.height = height;
		pixels = new int[width*height];
		setColor(colour);
	}

	public Sprite(int size, int colour) {
		this.width = size;
		this.height = size;
		pixels = new int[size*size];
		setColor(colour);
	}

	private void setColor(int colour) {
		for(int i = 0; i<width*height; i++) {
			pixels[i] = colour;
		}
	}

	private void load() {
		try {
			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++) {
					pixels[x + y * width] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.WIDTH];
				}
			}
		} catch (Exception e ) {
			e.printStackTrace();
		}
	}

	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
}
