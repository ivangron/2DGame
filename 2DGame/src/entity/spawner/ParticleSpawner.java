package entity.spawner;

import entity.particles.Particle;
import levels.Level;

public class ParticleSpawner extends Spawner {

	private int life;

	public ParticleSpawner(int x, int y, int life, int amount, Level level, double angle) {
		super(x, y, Type.PARTICLE, amount, level);
		this.life = life;
		this.level = level;

		Particle p = new Particle(x, y, (random.nextInt(life)), angle);
		for (int i = 0; i < (amount / p.getSpriteWidth()); i++) {
			Particle pA = new Particle(x, y, (random.nextInt(life)), angle);
			pA.init(level);
			level.add(pA);
		}
	}
}
