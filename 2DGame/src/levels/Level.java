package levels;

import entity.Entity;
import entity.particles.Particle;
import entity.projectile.Projectile;
import graphics.Screen;
import levels.tile.Tile;

import java.util.ArrayList;
import java.util.List;

public class Level {

	protected int width, height;
	protected int[] tilesInt;
	protected int[] tiles;
	private List<Entity> entities = new ArrayList<>();
	private List<Projectile> projectiles = new ArrayList<>();
	private List<Particle> particles = new ArrayList<>();

	public static Level spawn = new SpawnLevel("/levels/Lothlorien.png");


	public Level(String path) {
		loadLevel(path);
		generateLevel();
	}

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tilesInt = new int[width * height];
		generateLevel();
	}


	public byte tileCollision(double x, double y, int size, int xOffsetNeg, int xOffsetPos, int yOffsetNeg, int yOffsetPos) {
//		for(int c = 0; c < 4; c++) {
//			double xt = (x + c % 2 * size + xOffset) / 32;
//			double yt = (y + c / 2 * size + yOffset) / 32;
//			if (getTile((int)xt, (int)yt).solid()) return true;
//		}
		// top left corner
		double xt = (x + xOffsetNeg) / 32;
		double yt = (y + yOffsetPos) / 32;
		if (getTile((int)xt, (int)yt).solid()) return 1;
		// top right corner
		xt = (x + size - xOffsetPos) / 32;
		yt = (y + yOffsetPos) / 32;
		if (getTile((int)xt, (int)yt).solid()) return 2;
		// bottom left corner
		xt = (x + xOffsetNeg) / 32;
		yt = (y + size - yOffsetNeg) / 32;
		if (getTile((int)xt, (int)yt).solid()) return 3;
		// bottom right corner
		xt = (x + size - xOffsetPos) / 32;
		yt = (y + size - yOffsetNeg) / 32;
		if (getTile((int)xt, (int)yt).solid()) return 4;

		return -1;
	}


	protected void generateLevel() {
	}

	protected void loadLevel(String path) {
	}

	public void update(Screen screen) {
		for (int i =0; i < entities.size(); i++) {
			entities.get(i).update(screen);
		}
		for (int i =0; i < projectiles.size(); i++) {
			projectiles.get(i).update(screen);
		}
		for(int i = 0; i < particles.size(); i++) {
			particles.get(i).update(screen);
		}
		remove();
	}

	private void remove() {
		for (int i =0; i < entities.size(); i++) {
			if(entities.get(i).isRemoved()) entities.remove(i);
		}
		for (int i =0; i < projectiles.size(); i++) {
			if(projectiles.get(i).isRemoved()) projectiles.remove(i);
		}
		for(int i = 0; i < particles.size(); i++) {
			if(particles.get(i).isRemoved()) particles.remove(i);
		}
	}

	public List<Projectile> getProjectiles() {
		return projectiles;
	}

	private void time() {
	}

	// public methods


	public void add(Entity e) {
		if(e instanceof Particle) {
			particles.add((Particle) e);
		} else if(e instanceof Projectile) {
			projectiles.add((Projectile) e);
		} else {
			entities.add(e);
		}
	}


	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> screen.getTILESIZE_BITWISE();
		int x1 = (xScroll + screen.getWidth() + screen.getTILESIZE()) >> screen.getTILESIZE_BITWISE();
		int y0 = yScroll >> screen.getTILESIZE_BITWISE();
		int y1 = (yScroll + screen.getHeight() + screen.getTILESIZE()) >> screen.getTILESIZE_BITWISE();
		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x,y).render(x, y, screen);
			}
		}
		for(int i = 0; i < entities.size(); i++) {
			entities.get(i).render(screen);
		}
		for(int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).render(screen);
		}
		for(int i = 0; i < particles.size(); i++) {
			particles.get(i).render(screen);
		}
	}

	public Tile getTile(int x, int y) {
		// if location is outside of the scope of the map then we do not want to draw anything
		if (x < 0 || y < 0 || x >= width || y >= height)            			return Tile.voidTile;
		// draw correct tile according to map pixel color
		if (tiles[x + y * width] == Tile.stoneTileCleanCode)			        return Tile.stoneTileClean;
		if (tiles[x + y * width] == Tile.stoneTileDirtyCode)			        return Tile.stoneTileDirty;
		if (tiles[x + y * width] == Tile.stoneTileGrass1Code)			        return Tile.stoneTileGrass1;
		if (tiles[x + y * width] == Tile.stoneTileGrass2Code)			        return Tile.stoneTileGrass2;
		if (tiles[x + y * width] == Tile.stoneTileGrass3Code)			        return Tile.stoneTileGrass3;
		if (tiles[x + y * width] == Tile.stoneTileFancy1Code)			        return Tile.stoneTileFancy1;
		if (tiles[x + y * width] == Tile.stoneTileFancy2Code)			        return Tile.stoneTileFancy2;
		if (tiles[x + y * width] == Tile.stoneTileFancy3Code)			        return Tile.stoneTileFancy3;
		if (tiles[x + y * width] == Tile.stoneTileWeedCode)			            return Tile.stoneTileWeed;
		if (tiles[x + y * width] == Tile.stoneTileIceCode)			            return Tile.stoneTileIce;
		if (tiles[x + y * width] == Tile.stoneTileGrass4Code)			        return Tile.stoneTileGrass4;
		if (tiles[x + y * width] == Tile.stoneTileGrass5Code)			        return Tile.stoneTileGrass5;
		if (tiles[x + y * width] == Tile.stoneTileGrass6Code)			        return Tile.stoneTileGrass6;
		if (tiles[x + y * width] == Tile.stoneTileBrokenCode)			        return Tile.stoneTileBroken;
		if (tiles[x + y * width] == Tile.stoneTileStringDrawings1Code)	        return Tile.stoneTileStringDrawings1;
		if (tiles[x + y * width] == Tile.stoneTileStringDrawings2Code)	        return Tile.stoneTileStringDrawings2;
		if (tiles[x + y * width] == Tile.grassTileHealthy4Code)			        return Tile.grassTileHealthy4;
		if (tiles[x + y * width] == Tile.grassTileHealthy3Code)			        return Tile.grassTileHealthy3;
		if (tiles[x + y * width] == Tile.grassTileHealthy2Code)			        return Tile.grassTileHealthy2;
		if (tiles[x + y * width] == Tile.grassTileHealthy1Code)			        return Tile.grassTileHealthy1;
		if (tiles[x + y * width] == Tile.stoneTileGraniteCode)			        return Tile.stoneTileGranite;
		if (tiles[x + y * width] == Tile.stoneTileGraniteRaisedCode)	        return Tile.stoneTileGraniteRaised;
		if (tiles[x + y * width] == Tile.stoneTileGraniteRaisedDesignCode)		return Tile.stoneTileGraniteRaisedDesign;
		if (tiles[x + y * width] == Tile.stoneTileGraniteFlatCode)			    return Tile.stoneTileGraniteFlat;
		if (tiles[x + y * width] == Tile.stoneTileDirtCoveredCode)			    return Tile.stoneTileDirtCovered;
		if (tiles[x + y * width] == Tile.dirtTileCode)			                return Tile.dirtTile;
		if (tiles[x + y * width] == Tile.dirtTileTriBrokenCode)			        return Tile.dirtTileTriBroken;
		if (tiles[x + y * width] == Tile.dirtTileTriCode)			            return Tile.dirtTileTri;
		if (tiles[x + y * width] == Tile.stoneTilePattern1Code)			        return Tile.stoneTilePattern1;
		if (tiles[x + y * width] == Tile.stoneTilePattern2Code)			        return Tile.stoneTilePattern2;
		if (tiles[x + y * width] == Tile.stoneTilePattern3Code)			        return Tile.stoneTilePattern3;
		if (tiles[x + y * width] == Tile.stoneTilePattern4Code)			        return Tile.stoneTilePattern4;
		if (tiles[x + y * width] == Tile.brickTileFloorWhiteCode)			    return Tile.brickTileFloorWhite;
		if (tiles[x + y * width] == Tile.brickTileFloorDarkRedCode)			    return Tile.brickTileFloorDarkRed;
		if (tiles[x + y * width] == Tile.brickTileFloorRedEdgedCode)			return Tile.brickTileFloorRedEdged;
		if (tiles[x + y * width] == Tile.brickTileSolidCode)			        return Tile.brickTileSolid;
		if (tiles[x + y * width] == Tile.brickTileRedCode)			            return Tile.brickTileRed;
		if (tiles[x + y * width] == Tile.brickTileSmokeCode)			        return Tile.brickTileSmoke;
		if (tiles[x + y * width] == Tile.brickTileNormalCode)			        return Tile.brickTileNormal;
		if (tiles[x + y * width] == Tile.brickTileNormalBotRigShadingCode)		return Tile.brickTileNormalBotRigShading;
		if (tiles[x + y * width] == Tile.brickTileNormalRigShadingCode)			return Tile.brickTileNormalRigShading;
		if (tiles[x + y * width] == Tile.brickTileNormalTopRigShadingCode)		return Tile.brickTileNormalTopRigShading;
		if (tiles[x + y * width] == Tile.brickTileNormalFullShadingCode)		return Tile.brickTileNormalFullShading;
		if (tiles[x + y * width] == Tile.brickTileUnderWaterDeepCode)			return Tile.brickTileUnderWaterDeep;
		if (tiles[x + y * width] == Tile.brickTileUnderWaterShallowCode)		return Tile.brickTileUnderWaterShallow;
		if (tiles[x + y * width] == Tile.brickTileUnderWaterFullCode)			return Tile.brickTileUnderWaterFull;
		if (tiles[x + y * width] == Tile.brickTileUnderIceCode)			        return Tile.brickTileUnderIce;
		if (tiles[x + y * width] == Tile.snowTile1Code)			                return Tile.snowTile1;
		if (tiles[x + y * width] == Tile.dirtTile1Code)			                return Tile.dirtTile1;
		if (tiles[x + y * width] == Tile.dirtTile2Code)			                return Tile.dirtTile2;
		if (tiles[x + y * width] == Tile.dirtTile3Code)			                return Tile.dirtTile3;
		if (tiles[x + y * width] == Tile.dirtTile4Code)			                return Tile.dirtTile4;
		if (tiles[x + y * width] == Tile.snowTile2Code)			                return Tile.snowTile2;
		if (tiles[x + y * width] == Tile.snowTile3Code)			                return Tile.snowTile3;
		if (tiles[x + y * width] == Tile.snowTileWaterCode)			            return Tile.snowTileWater;
		if (tiles[x + y * width] == Tile.snowTile4Code)			                return Tile.snowTile4;
		if (tiles[x + y * width] == Tile.grassTileWeedCode)			            return Tile.grassTileWeed;
		if (tiles[x + y * width] == Tile.grassTileWeedCleanCode)			    return Tile.grassTileWeedClean;
		if (tiles[x + y * width] == Tile.grassTileFloorSeedCode)			    return Tile.grassTileFloorSeed;
		if (tiles[x + y * width] == Tile.grassTileFloorSproutCode)			    return Tile.grassTileFloorSprout;
		if (tiles[x + y * width] == Tile.grassTileFloorYoungCode)			    return Tile.grassTileFloorYoung;
		if (tiles[x + y * width] == Tile.grassTileFloorBloomCode)			    return Tile.grassTileFloorBloom;
		if (tiles[x + y * width] == Tile.grassTileFloorDeathCode)			    return Tile.grassTileFloorDeath;
		if (tiles[x + y * width] == Tile.grassTileFloorCleanCode)			    return Tile.grassTileFloorClean;
		if (tiles[x + y * width] == Tile.treeTileTLCode)			            return Tile.treeTileTL;
		if (tiles[x + y * width] == Tile.treeTileTRCode)			            return Tile.treeTileTR;
		if (tiles[x + y * width] == Tile.treeTileBLCode)			            return Tile.treeTileBL;
		if (tiles[x + y * width] == Tile.treeTileBRCode)			            return Tile.treeTileBR;
		if (tiles[x + y * width] == Tile.mmWallCode)			                return Tile.mmWall;
		if (tiles[x + y * width] == Tile.woodFloorTileCode)			            return Tile.woodFloorTile;
		// If no code found return voidTile instead of null
		return Tile.voidTile;
	}
}
