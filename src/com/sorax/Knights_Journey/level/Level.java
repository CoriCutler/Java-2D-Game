package com.sorax.Knights_Journey.level;

import java.util.List;
import java.util.ArrayList;

import com.sorax.Knights_Journey.entity.Entity;
import com.sorax.Knights_Journey.entity.particle.Particle;
import com.sorax.Knights_Journey.entity.spawner.Spawner;
import com.sorax.Knights_Journey.graphics.Screen;
import com.sorax.Knights_Journey.level.tile.Tile;

public class Level {

	protected static int width, height;
	protected int[] tilesInt;
	protected static int[] tiles;

	private List<Entity> entities = new ArrayList<Entity>();
	private List<Particle> particles = new ArrayList<Particle>();

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tilesInt = new int[width * height];
		generateLevel();
	}

	public Level(String path) {
		loadLevel(path);
		generateLevel();

	}

	protected void generateLevel() {
	}

	protected void loadLevel(String path) {
	}

	public void update() {
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).update();
		}
		for (int i = 0; i < particles.size(); i++) {
			particles.get(i).update();
		}
		remove();
	}

	private void remove() {
		for (int i = 0; i < entities.size(); i++) {
			if (entities.get(i).isRemoved())
				entities.remove(i);
		}
		for (int i = 0; i < particles.size(); i++) {
			if (particles.get(i).isRemoved())
				particles.remove(i);
		}
	}

	private void time() {
	}

	public boolean tilecollision(int x, int y, int size, int xOffset,
			int yOffset) {
		boolean solid = false;
		for (int c = 0; c < 4; c++) {
			int xt = (x + c % 2 * size + xOffset) >> 5;
			int yt = (y + c / 2 * size + yOffset) >> 5;
			if (getTile(xt, yt).solid())
				solid = true;
		}
		return solid;
	}

	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 5;
		int x1 = (xScroll + screen.width + 32) >> 5;
		int y0 = yScroll >> 5;
		int y1 = (yScroll + screen.height + 32) >> 5;
		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);
			}
		}
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).render(screen);
		}
		for (int i = 0; i < particles.size(); i++) {
			particles.get(i).render(screen);
		}
	}

	public void add(Entity e) {
		e.init(this);
		if (e instanceof Particle) {
			particles.add((Particle) e);
		} else {
			entities.add(e);
		}
	}

	public static Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height)
			return Tile.voidTile;
		if (tiles[x + y * width] == 0xFF00FF00)
			return Tile.grassTile;
		if (tiles[x + y * width] == 0xFF0000FF)
			return Tile.waterTile;
		if (tiles[x + y * width] == 0xFF87702D)
			return Tile.grass_dirtTile;
		if (tiles[x + y * width] == 0xFF808080)
			return Tile.grass_stoneTile;
		if(tiles[x + y * width] == 0xFF7F3300)
			return Tile.dockTile;
		return Tile.voidTile;
	}

}
