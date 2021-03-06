package levels;


import entity.mob.NPC;
import entity.mob.randomNPC;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpawnLevel extends Level {

	public SpawnLevel(String path) {
		super(path);
	}

	protected void loadLevel(String path) {
		try {
			BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
			width = image.getWidth();
			height = image.getHeight();
			tiles = new int[width*height];
			tiles = image.getRGB(0,0, width, height, tiles, 0, width);
			initMobs();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Exeception: Could not load level file!");
		}
	}

	protected void generateLevel() {
	}

	private void initMobs() {
		for(int i=0; i<3;i++) {
			NPC npc = new randomNPC(43, 63, 1);
			npc.init(this);
			add(npc);
		}
	}
}