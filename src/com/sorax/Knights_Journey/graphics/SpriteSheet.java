package com.sorax.Knights_Journey.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

	private String path;
	public final int SIZE;
	public final int WIDTH, HEIGHT;
	public int[] pixels;

	// tiles
	public static SpriteSheet tiles = new SpriteSheet("/textures/tiles.png",512, 512);
	public static SpriteSheet paths = new SpriteSheet("/textures/path.png",512, 512);
	public static SpriteSheet title = new SpriteSheet("/menu/title.png", 451,160);
	public static SpriteSheet water = new SpriteSheet(paths, 0, 10, 4, 4, 32);
	public static SpriteSheet water_stone = new SpriteSheet(paths, 0,0,0,0,32);
	public static SpriteSheet grass_dirt = new SpriteSheet(paths, 6, 0, 3, 5,32);
	public static SpriteSheet grass_stone = new SpriteSheet(paths, 0, 0, 3, 5,32);
	public static SpriteSheet dock = new SpriteSheet(paths, 3, 11, 4, 3, 32);
	// player
	public static SpriteSheet player = new SpriteSheet("/players/male.png",576, 256);
	public static SpriteSheet player_up = new SpriteSheet(player, 0, 0, 9, 1,64);
	public static SpriteSheet player_down = new SpriteSheet(player, 0, 2, 9,1, 64);
	public static SpriteSheet player_left = new SpriteSheet(player, 0, 1, 9, 1,64);
	public static SpriteSheet player_right = new SpriteSheet(player, 0, 3, 9,1, 64);
	// UI
	// public static SpriteSheet hud = new SpriteSheet("/ui/hud-pieces.png",
	// 152, 124);

	private Sprite[] sprites;

	public SpriteSheet(SpriteSheet sheet, int x, int y, int width, int height,
			int spriteSize) {
		int xx = x * spriteSize;
		int yy = y * spriteSize;
		int w = width * spriteSize;
		int h = height * spriteSize;
		if (width == height)
			SIZE = width;
		else
			SIZE = -1;
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
				int[] spritePixels = new int[spriteSize * spriteSize];
				for (int y0 = 0; y0 < spriteSize; y0++) {
					for (int x0 = 0; x0 < spriteSize; x0++) {
						spritePixels[x0 + y0 * spriteSize] = pixels[(x0 + xa
								* spriteSize)
								+ (y0 + ya * spriteSize) * WIDTH];
					}
				}
				Sprite sprite = new Sprite(spritePixels, spriteSize, spriteSize);
				sprites[frame++] = sprite;
			}
		}
	}

	public SpriteSheet(String path, int size) {
		this.path = path;
		SIZE = size;
		WIDTH = size;
		HEIGHT = size;
		pixels = new int[SIZE * SIZE];
		load();
	}

	public SpriteSheet(String path, int width, int height) {
		this.path = path;
		SIZE = -1;
		WIDTH = width;
		HEIGHT = height;
		pixels = new int[WIDTH * HEIGHT];
		load();
	}

	public Sprite[] getSprite() {
		return sprites;
	}

	private void load() {
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class
					.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
