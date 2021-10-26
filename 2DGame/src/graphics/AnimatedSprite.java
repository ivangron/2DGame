package graphics;

public class AnimatedSprite extends Sprite {

	private int frame = 0;
	private Sprite sprite;
	private int rate = 6;
	private int length = -1;
	private int time = 0;

	public AnimatedSprite(SpriteSheet sheet, int width, int height, int length) {
		super(sheet, width, height);
		this.length = length;
		sprite = sheet.getSprites()[0];
		if(length > sheet.getSprites().length) {
			System.err.println("Error: Length of animation is to long!!!");
		}
	}


	public void update() {
		time++;
		if(time%rate == 0) {
			if(frame >= length-1) {
				frame = 0;
			} else {
				frame++;
			}
			sprite = sheet.getSprites()[frame];
		}
		if(time >= 30000) {
			time = 0;
		}
	}


	public void resting() {
		time=0;
		frame=0;
		sprite = sheet.getSprites()[frame];
	}

	public Sprite getSprite() {
		return sprite;
	}
}
