package com.sorax.Knights_Journey.level.tile;

import com.sorax.Knights_Journey.graphics.Screen;
import com.sorax.Knights_Journey.graphics.SpriteSheet;
import com.sorax.Knights_Journey.level.Level;

public class grass_dirtTile extends Tile {

	public grass_dirtTile(SpriteSheet sheet) {
		super(sheet);
	}

	public void render(int x, int y, Screen screen) {
		// top left
		if (Level.getTile(x + 1, y) == Tile.grass_dirtTile
				&& Level.getTile(x - 1, y) == Tile.grassTile
				&& Level.getTile(x, y + 1) == Tile.grass_dirtTile
				&& Level.getTile(x, y - 1) == Tile.grassTile)
			screen.renderTile(x << 5, y << 5, sheet.getSprite()[0]);
		// top
		else if (Level.getTile(x + 1, y) == Tile.grass_dirtTile
				&& Level.getTile(x - 1, y) == Tile.grass_dirtTile
				&& Level.getTile(x, y + 1) == Tile.grass_dirtTile
				&& Level.getTile(x, y - 1) == Tile.grassTile)
			screen.renderTile(x << 5, y << 5, sheet.getSprite()[1]);
		// top right
		else if (Level.getTile(x + 1, y) == Tile.grassTile
				&& Level.getTile(x - 1, y) == Tile.grass_dirtTile
				&& Level.getTile(x, y + 1) == Tile.grass_dirtTile
				&& Level.getTile(x, y - 1) == Tile.grassTile)
			screen.renderTile(x << 5, y << 5, sheet.getSprite()[2]);
		// left
		else if (Level.getTile(x + 1, y) == Tile.grass_dirtTile
				&& Level.getTile(x - 1, y) == Tile.grassTile
				&& Level.getTile(x, y + 1) == Tile.grass_dirtTile
				&& Level.getTile(x, y - 1) == Tile.grass_dirtTile)
			screen.renderTile(x << 5, y << 5, sheet.getSprite()[3]);
		// right
		else if (Level.getTile(x + 1, y) == Tile.grassTile
				&& Level.getTile(x - 1, y) == Tile.grass_dirtTile
				&& Level.getTile(x, y + 1) == Tile.grass_dirtTile
				&& Level.getTile(x, y - 1) == Tile.grass_dirtTile)
			screen.renderTile(x << 5, y << 5, sheet.getSprite()[5]);
		// bottom left
		else if (Level.getTile(x + 1, y) == Tile.grass_dirtTile
				&& Level.getTile(x - 1, y) == Tile.grassTile
				&& Level.getTile(x, y + 1) == Tile.grassTile
				&& Level.getTile(x, y - 1) == Tile.grass_dirtTile)
			screen.renderTile(x << 5, y << 5, sheet.getSprite()[6]);
		// bottom
		else if (Level.getTile(x + 1, y) == Tile.grass_dirtTile
				&& Level.getTile(x - 1, y) == Tile.grass_dirtTile
				&& Level.getTile(x, y + 1) == Tile.grassTile
				&& Level.getTile(x, y - 1) == Tile.grass_dirtTile)
			screen.renderTile(x << 5, y << 5, sheet.getSprite()[7]);
		// bottom right
		else if (Level.getTile(x + 1, y) == Tile.grassTile
				&& Level.getTile(x - 1, y) == Tile.grass_dirtTile
				&& Level.getTile(x, y + 1) == Tile.grassTile
				&& Level.getTile(x, y - 1) == Tile.grass_dirtTile)
			screen.renderTile(x << 5, y << 5, sheet.getSprite()[8]);

		else if (Level.getTile(x + 1, y) == Tile.grass_dirtTile
				&& Level.getTile(x - 1, y) == Tile.grass_dirtTile
				&& Level.getTile(x, y + 1) == Tile.grass_dirtTile
				&& Level.getTile(x, y - 1) == Tile.grass_dirtTile
				&& Level.getTile(x - 1, y - 1) == Tile.grass_dirtTile
				&& Level.getTile(x + 1, y - 1) == Tile.grass_dirtTile
				&& Level.getTile(x - 1, y + 1) == Tile.grass_dirtTile
				&& Level.getTile(x + 1, y + 1) == Tile.grassTile)
			screen.renderTile(x << 5, y << 5, sheet.getSprite()[9]);

		else if (Level.getTile(x + 1, y) == Tile.grass_dirtTile
				&& Level.getTile(x - 1, y) == Tile.grass_dirtTile
				&& Level.getTile(x, y + 1) == Tile.grass_dirtTile
				&& Level.getTile(x, y - 1) == Tile.grass_dirtTile
				&& Level.getTile(x - 1, y - 1) == Tile.grass_dirtTile
				&& Level.getTile(x + 1, y - 1) == Tile.grass_dirtTile
				&& Level.getTile(x - 1, y + 1) == Tile.grassTile
				&& Level.getTile(x + 1, y + 1) == Tile.grass_dirtTile)
			screen.renderTile(x << 5, y << 5, sheet.getSprite()[10]);

		else if (Level.getTile(x + 1, y) == Tile.grass_dirtTile
				&& Level.getTile(x - 1, y) == Tile.grass_dirtTile
				&& Level.getTile(x, y + 1) == Tile.grass_dirtTile
				&& Level.getTile(x, y - 1) == Tile.grass_dirtTile
				&& Level.getTile(x - 1, y - 1) == Tile.grass_dirtTile
				&& Level.getTile(x + 1, y - 1) == Tile.grassTile
				&& Level.getTile(x - 1, y + 1) == Tile.grass_dirtTile
				&& Level.getTile(x + 1, y + 1) == Tile.grass_dirtTile)
			screen.renderTile(x << 5, y << 5, sheet.getSprite()[12]);

		else if (Level.getTile(x + 1, y) == Tile.grass_dirtTile
				&& Level.getTile(x - 1, y) == Tile.grass_dirtTile
				&& Level.getTile(x, y + 1) == Tile.grass_dirtTile
				&& Level.getTile(x, y - 1) == Tile.grass_dirtTile
				&& Level.getTile(x - 1, y - 1) == Tile.grassTile
				&& Level.getTile(x + 1, y - 1) == Tile.grass_dirtTile
				&& Level.getTile(x - 1, y + 1) == Tile.grass_dirtTile
				&& Level.getTile(x + 1, y + 1) == Tile.grass_dirtTile)
			screen.renderTile(x << 5, y << 5, sheet.getSprite()[13]);

		else if (Level.getTile(x + 1, y) == Tile.grassTile
				&& Level.getTile(x - 1, y) == Tile.grassTile
				&& Level.getTile(x, y + 1) == Tile.grassTile
				&& Level.getTile(x, y - 1) == Tile.grassTile)
			screen.renderTile(x << 5, y << 5, sheet.getSprite()[14]);

		else
			screen.renderTile(x << 5, y << 5, sheet.getSprite()[4]);
	}
}
