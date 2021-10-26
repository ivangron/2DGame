package levels;

public class TileCoordinate {

	private int x,y;
	private final int TILE_SIZE;


	public TileCoordinate(int x, int y, int tileSize) {
		this.TILE_SIZE = tileSize;
		this.x = x * TILE_SIZE;
		this.y = y * TILE_SIZE;
	}


	public int x() {
		return x;
	}

	public int y() {
		return y;
	}

	public int[] xy() {
		int[] xy = new int[2];
		xy[0] = x;
		xy[1] = y;
		return xy;
	}


}
