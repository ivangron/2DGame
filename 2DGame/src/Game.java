import entity.mob.Player;
import graphics.Screen;
import input.KeyBoard;
import input.Mouse;
import levels.Level;
import levels.TileCoordinate;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1l;
	private static final String TITLE = "Ivan's Game";
	private static int width = 1000;
	private static int height = width / 16 * 9;
	private static int scale = 2;

	private Thread thread;
	private JFrame frame;
	private boolean running = false;
	private Screen screen;
	private KeyBoard key;
	private Level level;
	private Player player;

	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); // create image
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData(); // access image

	public Game() {

		Dimension size = new Dimension(width * scale, height * scale);  // create my frame screen dimensions
		setPreferredSize(size);  // set the frame size to the screen dimension created

		screen = new Screen(width, height, scale);
		frame = new JFrame();
		key = new KeyBoard();
		level = Level.spawn;

		TileCoordinate playerSpawn = new TileCoordinate(46, 67, screen.getTILESIZE());
		player = new Player(playerSpawn.x(),playerSpawn.y(), key);
		player.init(level);

		addKeyListener(key); // add the KeyBoard object to the canvas' key listener
		Mouse mouse = new Mouse();
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
	}


	public synchronized void start() {
		setRunning(true);  // set running to true so that loops starts in thread
		thread = new Thread(this, "gameThread");  // initialize the thread with this class and name it
		thread.start();  // start the thread
	}

	public synchronized void stop() {
		try {
			setRunning(false);  // set running to false so that loop stops in thread
			thread.join();  // join the thread to the main process so thread ends on process end
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	//---------------//
	public void run() {

		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		double fps = 60.0;
		final double ns = 1000000000.0 / fps;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		while (getRunning()) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				update();  // will do my screen updates via this class at rate control
				updates++;
				delta--;
			}
			render();  // will render all my frames at unlimited rate
			frames++;
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frame.setTitle(TITLE + " [fps:" + frames + ", updates:" + updates + "]");
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}

	public void update() {

		key.update();
		player.update(screen);
		level.update(screen);
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy(); // set reference to this objects graphics object
		if (bs == null) {
			createBufferStrategy(3); // buffer strategy of 3 is best in 99% of all cases
			return;
		}
		screen.clear(); // have the screen clear all its previous before rendering new
		int xScroll = player.getX() - screen.getWidth()/2;
		int yScroll = player.getY() - screen.getHeight()/2;
		level.render(xScroll, yScroll, screen);  // level object renders all the tiles
		player.render(screen);      // player object has its own render

//		screen.renderSheet(0, 0, SpriteSheet.flyG_down, false);

		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.getPixel(i);   // loop through the screen pixels and add them to the pixel array
		}

		Graphics g = bs.getDrawGraphics();  // create a graphic reference to the buffer graphics
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		/*
// debub info on screen
		g.setColor(Color.black);
		g.setFont(new Font("Verdana", 0, 20));
		int x1 = width*scale/2;
		int x2 = Mouse.getX();
		int y1 = height*scale/2;
		int y2 = Mouse.getY();
		double distance = Math.sqrt(   ((x1-x2)*(x1-x2)) + ((y1-y2)*(y1-y2))  );
		g.drawString("PlayerX: " + player.getX() + ", PlayerY: " + player.getY(), 100, 40);
		g.drawString("MouseX: " + x2 + ", MouseY: " + y2, 100, 60);
		g.drawString("XFromCenter: " + (x2 - x1) + ", YFromCenter: " + (y2 - y1), 100, 80);
		g.drawString("Distance To Mouse From Center: " + distance, 100,100);
		// g.fillRoundRect(Mouse.getX()-8, Mouse.getY()-8,16,16, 64, 64);
		double dx = Mouse.getX() - (screen.getWidth()*screen.getScale()/2);
		double dy = Mouse.getY() - (screen.getHeight()*screen.getScale()/2);
		double angle = Math.atan2(dy,dx);
		g.drawString("Radiants from player: " + angle, 100, 120);
		g.drawString("Degrees from player: " + (angle * (180/Math.PI)), 100, 140);
		g.fillRect(width*scale/2, height*scale/2,32,32);
		g.drawString("Button : " + Mouse.getButton(), 50, 50);
*/
		g.dispose();  // releases all system resources on current graphics
		bs.show();  // swap the buffer and remove render
		requestFocusInWindow();
	}
	//---------------//

	public static void main(String[] args) {
		Game game = new Game();
		game.frame.setResizable(false); // disable resizing so we don't have to worry about in game machanics by user resize
		game.frame.setTitle("Ivan"); // set the title of the frame
		game.frame.add(game); // adds game class as component
		game.frame.pack(); // sets the size of the frame to the component
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // make sure application ends on close
		game.frame.setLocationRelativeTo(null); // set the location of the canvas to center of frame
		game.frame.setVisible(true); // make sure to show frame

		game.start();
	}

	private synchronized void setRunning(boolean val) {
		running = val;
	}

	private synchronized boolean getRunning() {
		return running;
	}

	public int getWindowWidth() {
		return width;
	}

	public int getWindowHeight() {
		return height;
	}

	public int getWindowScale() {
		return scale;
	}
}