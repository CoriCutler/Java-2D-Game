package com.sorax.Knights_Journey;

import java.awt.AlphaComposite;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.sorax.Knights_Journey.database.Database;
import com.sorax.Knights_Journey.database.Login;
import com.sorax.Knights_Journey.entity.mob.player.Player;
import com.sorax.Knights_Journey.entity.mob.player.PlayerMP;
import com.sorax.Knights_Journey.graphics.Font;
import com.sorax.Knights_Journey.graphics.Screen;
import com.sorax.Knights_Journey.graphics.Sprite;
import com.sorax.Knights_Journey.graphics.SpriteSheet;
import com.sorax.Knights_Journey.graphics.UI.UIManager;
import com.sorax.Knights_Journey.input.Keyboard;
import com.sorax.Knights_Journey.input.Mouse;
import com.sorax.Knights_Journey.level.Level;
import com.sorax.Knights_Journey.level.SpawnLevel;
import com.sorax.Knights_Journey.level.TileCoordinate;
import com.sorax.Knights_Journey.level.Time;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;

	public static String title = "Knight's Journey";
	public static int width = 900;
	public static int height = width / 16 * 9;
	public static int scale = 1;
	public static Dimension size = new Dimension(width * scale, height * scale);
	public static boolean home = false; 

	private Thread thread;
	public JFrame frame;
	public Keyboard key;
	public Level level;
	public Player player;
	private boolean running = false;

	public boolean debug = true;
	public boolean isApplet = false;
	public static boolean multiplayer = false;

	private static UIManager uiManager;

	private Screen screen;

	private BufferedImage image = new BufferedImage(width, height,
			BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer())
			.getData();

	public Game() {
		setPreferredSize(size);
		if(multiplayer){Login.login();}

		screen = new Screen(width, height);
		uiManager = new UIManager();
		frame = new JFrame();
		key = new Keyboard();
		level = new SpawnLevel("/level/map.png");
		player = new PlayerMP(538, 449, key, player.username, null);
		level.add(player);

		addKeyListener(key);

		Mouse mouse = new Mouse();
		addMouseListener(mouse);
		addMouseMotionListener(mouse);

	}

	public static int getWindowWidth() {
		return width * scale;
	}

	public static int getWindowHeight() {
		return height * scale;
	}

	public static UIManager getUIManager() {
		return uiManager;
	}

	public synchronized void start() {
		running = true;
		thread = new Thread(this, title + "_main");
		thread.start();
	}

	public synchronized void stop() {
		running = false;
		System.exit(0);
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		requestFocus();
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				update();
				updates++;
				delta--;
			}
			render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				debug(DebugLevel.INFO,updates + " ups, "
						+ frames + " fps");
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}

	public void update() {
		if (multiplayer) {
			 try { Database.database();} 
			 catch (SQLException e)
			 { e.printStackTrace(); }
		}
		key.update();
		player.update();
		level.update();
		Time.clock();
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		screen.clear();
		int xScroll = player.x - screen.width / 2;
		int yScroll = player.y - screen.height / 2;
		level.render(xScroll, yScroll, screen);
		uiManager.render(screen);
		player.render(screen);
		// screen.renderSheet(10, 10, SpriteSheet.title, false);
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		((Graphics2D) g).setComposite(AlphaComposite.getInstance(
				AlphaComposite.SRC_OVER, Time.getTime()));
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.dispose();
		bs.show();
	}

	public void debug(DebugLevel level, String msg) {
		switch (level) {
		default:
		case INFO:
			if (debug) {
				System.out.println("[" + title + "] " + msg);
				break;
			}
		case WARNING:
			if (debug) {
				System.out.println("[" + title + "][WARNING] " + msg);
				break;
			}
		case SEVERE:
			if (debug) {
				System.out.println("[" + title + "][SEVERE] " + msg);
				this.stop();
				break;
			}
		}
	}

	public static enum DebugLevel {
		INFO, WARNING, SEVERE;
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle(title);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		
		game.start();
	}
}
