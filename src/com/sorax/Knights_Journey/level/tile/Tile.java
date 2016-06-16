package com.sorax.Knights_Journey.level.tile;

import com.sorax.Knights_Journey.graphics.Screen;
import com.sorax.Knights_Journey.graphics.Sprite;
import com.sorax.Knights_Journey.graphics.SpriteSheet;
import com.sorax.Knights_Journey.level.Level;

public class Tile {

	public int x, y;
	public Sprite sprite;
	public SpriteSheet sheet;

	// tiles
	public static Tile grassTile = new GrassTile(SpriteSheet.water);
	public static Tile waterTile = new WaterTile(SpriteSheet.water);
	public static Tile grass_dirtTile = new grass_dirtTile(SpriteSheet.grass_dirt);
	public static Tile grass_stoneTile = new grass_stoneTile(SpriteSheet.grass_stone);
	public static Tile dockTile = new dockTile(SpriteSheet.dock);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);

	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}

	public Tile(SpriteSheet sheet) {
		this.sheet = sheet;
	}

	public void render(int x, int y, Screen screen) {
	}

	public boolean solid() {
		return false;
	}
}
