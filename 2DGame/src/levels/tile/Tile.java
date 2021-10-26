package levels.tile;

import graphics.Screen;
import graphics.Sprite;

public class Tile {

	public int x, y;
	public Sprite sprite;

	// floortileset.png

	public static Tile stoneTileClean = new StoneTile(Sprite.stoneTileClean);
	public static final int stoneTileCleanCode = 0xFF818578;
	public static Tile stoneTileDirty = new StoneTile(Sprite.stoneTileDirty);
	public static final int stoneTileDirtyCode = 0xFF8c8770;
	public static Tile stoneTileGrass1 = new StoneTile(Sprite.stoneTileGrass1);
	public static final int stoneTileGrass1Code = 0;
	public static Tile stoneTileGrass2 = new StoneTile(Sprite.stoneTileGrass2);
	public static final int stoneTileGrass2Code = 0;
	public static Tile stoneTileGrass3 = new StoneTile(Sprite.stoneTileGrass3);
	public static final int stoneTileGrass3Code = 0;
	public static Tile stoneTileFancy1 = new StoneTile(Sprite.stoneTileFancy1);
	public static final int stoneTileFancy1Code = 0;
	public static Tile stoneTileFancy2 = new StoneTile(Sprite.stoneTileFancy2);
	public static final int stoneTileFancy2Code = 0xFF606060;
	public static Tile stoneTileFancy3 = new StoneTile(Sprite.stoneTileFancy3);
	public static final int stoneTileFancy3Code = 0xFF636363;

	public static Tile stoneTileWeed = new StoneTile(Sprite.stoneTileWeed);
	public static final int stoneTileWeedCode = 0;
	public static Tile stoneTileIce = new StoneTile(Sprite.stoneTileIce);
	public static final int stoneTileIceCode = 0;
	public static Tile stoneTileGrass4 = new StoneTile(Sprite.stoneTileGrass4);
	public static final int stoneTileGrass4Code = 0xFF349E21;
	public static Tile stoneTileGrass5 = new StoneTile(Sprite.stoneTileGrass5);
	public static final int stoneTileGrass5Code = 0;
	public static Tile stoneTileGrass6 = new StoneTile(Sprite.stoneTileGrass6);
	public static final int stoneTileGrass6Code = 0;
	public static Tile stoneTileBroken = new StoneTile(Sprite.stoneTileBroken);
	public static final int stoneTileBrokenCode = 0;
	public static Tile stoneTileStringDrawings1 = new StoneTile(Sprite.stoneTileStringDrawings1);
	public static final int stoneTileStringDrawings1Code = 0xFF686868;
	public static Tile stoneTileStringDrawings2 = new StoneTile(Sprite.stoneTileStringDrawings2);
	public static final int stoneTileStringDrawings2Code = 0xFF3A3A3A;

	public static Tile grassTileHealthy4 = new GrassTile(Sprite.grassTileHealthy4);
	public static final int grassTileHealthy4Code = 0xff056508;
	public static Tile grassTileHealthy3 = new GrassTile(Sprite.grassTileHealthy3);
	public static final int grassTileHealthy3Code = 0;
	public static Tile grassTileHealthy2 = new GrassTile(Sprite.grassTileHealthy2);
	public static final int grassTileHealthy2Code = 0;
	public static Tile grassTileHealthy1 = new GrassTile(Sprite.grassTileHealthy1);
	public static final int grassTileHealthy1Code = 0;
	public static Tile stoneTileGranite = new StoneTile(Sprite.stoneTileGranite);
	public static final int stoneTileGraniteCode = 0;
	public static Tile stoneTileGraniteRaised = new StoneTile(Sprite.stoneTileGraniteRaised);
	public static final int stoneTileGraniteRaisedCode = 0;
	public static Tile stoneTileGraniteRaisedDesign = new StoneTile(Sprite.stoneTileGraniteRaisedDesign);
	public static final int stoneTileGraniteRaisedDesignCode = 0xFF979797;
	public static Tile stoneTileGraniteFlat = new StoneTile(Sprite.stoneTileGraniteFlat);
	public static final int stoneTileGraniteFlatCode = 0;

	public static Tile stoneTileDirtCovered = new StoneTile(Sprite.stoneTileDirtCovered);
	public static final int stoneTileDirtCoveredCode = 0xFF918849;
	public static Tile dirtTile = new DirtTile(Sprite.dirtTile);
	public static final int dirtTileCode = 0;
	public static Tile dirtTileTriBroken = new DirtTile(Sprite.dirtTileTriBroken);
	public static final int dirtTileTriBrokenCode = 0;
	public static Tile dirtTileTri = new DirtTile(Sprite.dirtTileTri);
	public static final int dirtTileTriCode = 0;
	public static Tile stoneTilePattern1 = new StoneTile(Sprite.stoneTilePattern1);
	public static final int stoneTilePattern1Code = 0xFF707070;
	public static Tile stoneTilePattern2 = new StoneTile(Sprite.stoneTilePattern2);
	public static final int stoneTilePattern2Code = 0;
	public static Tile stoneTilePattern3 = new StoneTile(Sprite.stoneTilePattern3);
	public static final int stoneTilePattern3Code = 0;
	public static Tile stoneTilePattern4 = new StoneTile(Sprite.stoneTilePattern4);
	public static final int stoneTilePattern4Code = 0;

	public static Tile brickTileFloorWhite = new BrickTile(Sprite.brickTileFloorWhite);
	public static final int brickTileFloorWhiteCode = 0;
	public static Tile brickTileFloorDarkRed = new BrickTile(Sprite.brickTileFloorDarkRed);
	public static final int brickTileFloorDarkRedCode = 0;
	public static Tile brickTileFloorRedEdged = new BrickTile(Sprite.brickTileFloorRedEdged);
	public static final int brickTileFloorRedEdgedCode = 0;
	public static Tile brickTileSolid = new BrickTile(Sprite.brickTileSolid);
	public static final int brickTileSolidCode = 0;
	public static Tile brickTileRed = new BrickTile(Sprite.brickTileRed);
	public static final int brickTileRedCode = 0xFF54130F;
	public static Tile brickTileSmoke = new BrickTile(Sprite.brickTileSmoke);
	public static final int brickTileSmokeCode = 0;
	public static Tile brickTileNormal = new BrickTile(Sprite.brickTileNormal);
	public static final int brickTileNormalCode = 0;
	public static Tile brickTileNormalBotRigShading = new BrickTile(Sprite.brickTileNormalBotRigShading);
	public static final int brickTileNormalBotRigShadingCode = 0;

	public static Tile brickTileNormalRigShading = new BrickTile(Sprite.brickTileNormalRigShading);
	public static final int brickTileNormalRigShadingCode = 0;
	public static Tile brickTileNormalTopRigShading = new BrickTile(Sprite.brickTileNormalTopRigShading);
	public static final int brickTileNormalTopRigShadingCode = 0;
	public static Tile brickTileNormalFullShading = new BrickTile(Sprite.brickTileNormalFullShading);
	public static final int brickTileNormalFullShadingCode = 0;
	public static Tile brickTileUnderWaterDeep = new BrickTile(Sprite.brickTileUnderWaterDeep);
	public static final int brickTileUnderWaterDeepCode = 0;
	public static Tile brickTileUnderWaterShallow = new BrickTile(Sprite.brickTileUnderWaterShallow);
	public static final int brickTileUnderWaterShallowCode = 0;
	public static Tile brickTileUnderWaterFull = new BrickTile(Sprite.brickTileUnderWaterFull);
	public static final int brickTileUnderWaterFullCode = 0;
	public static Tile brickTileUnderIce = new BrickTile(Sprite.brickTileUnderIce);
	public static final int brickTileUnderIceCode = 0;
	public static Tile snowTile1 = new SnowTile(Sprite.snowTile1);
	public static final int snowTile1Code = 0;

	public static Tile dirtTile1 = new DirtTile(Sprite.dirtTile1);
	public static final int dirtTile1Code = 0;
	public static Tile dirtTile2 = new DirtTile(Sprite.dirtTile2);
	public static final int dirtTile2Code = 0;
	public static Tile dirtTile3 = new DirtTile(Sprite.dirtTile3);
	public static final int dirtTile3Code = 0;
	public static Tile dirtTile4 = new DirtTile(Sprite.dirtTile4);
	public static final int dirtTile4Code = 0;
	public static Tile snowTile2 = new SnowTile(Sprite.snowTile2);
	public static final int snowTile2Code = 0;
	public static Tile snowTile3 = new SnowTile(Sprite.snowTile3);
	public static final int snowTile3Code = 0;
	public static Tile snowTileWater = new SnowTile(Sprite.snowTileWater);
	public static final int snowTileWaterCode = 0;
	public static Tile snowTile4 = new SnowTile(Sprite.snowTile4);
	public static final int snowTile4Code = 0;

	public static Tile grassTileWeed = new GrassTile(Sprite.grassTileWeed);
	public static final int grassTileWeedCode = 0;
	public static Tile grassTileWeedClean = new GrassTile(Sprite.grassTileWeedClean);
	public static final int grassTileWeedCleanCode = 0;
	public static Tile grassTileFloorSeed = new GrassTile(Sprite.grassTileFloorSeed);
	public static final int grassTileFloorSeedCode = 0xFF91B236;
	public static Tile grassTileFloorSprout = new GrassTile(Sprite.grassTileFloorSprout);
	public static final int grassTileFloorSproutCode = 0xFF8AAC2D;
	public static Tile grassTileFloorYoung = new GrassTile(Sprite.grassTileFloorYoung);
	public static final int grassTileFloorYoungCode = 0xFF81A225;
	public static Tile grassTileFloorBloom = new GrassTile(Sprite.grassTileFloorBloom);
	public static final int grassTileFloorBloomCode = 0xFF7C9D20;
	public static Tile grassTileFloorDeath = new GrassTile(Sprite.grassTileFloorDeath);
	public static final int grassTileFloorDeathCode = 0xFF698813;
	public static Tile grassTileFloorClean = new GrassTile(Sprite.grassTileFloorClean);
	public static final int grassTileFloorCleanCode = 0;


	public static Tile mmWall = new BrickTile(Sprite.mmWall);
	public static final int mmWallCode = 0xFFA51F1F;
	public static Tile woodFloorTile = new WoodTile(Sprite.woodFloorTile);
	public static final int woodFloorTileCode = 0xFF420808;



	//

	public static Tile voidTile = new VoidTile(Sprite.voidSprite);

	public static Tile treeTileTL = new TreeTile(Sprite.treeTL);
	public static final int treeTileTLCode = 0xFF094C0B;
	public static Tile treeTileTR = new TreeTile(Sprite.treeTR);
	public static final int treeTileTRCode = 0xFF09490B;
	public static Tile treeTileBL = new TreeTile(Sprite.treeBL);
	public static final int treeTileBLCode = 0xFF09470B;
	public static Tile treeTileBR = new TreeTile(Sprite.treeBR);
	public static final int treeTileBRCode = 0xFF09440B;

	public static Tile magicMissle = new ProjectileTile(Sprite.magicMissle);

	// Constructors


	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}


	// private methods




	// public methods


	public void render(int x, int y, Screen screen) {
	}

	public boolean solid() {
		return false;
	}

}
