package com.sorax.Knights_Journey.level.tile;

import com.sorax.Knights_Journey.graphics.Screen;
import com.sorax.Knights_Journey.graphics.Sprite;
import com.sorax.Knights_Journey.graphics.SpriteSheet;
import com.sorax.Knights_Journey.level.Level;

public class GrassTile extends Tile {

	public GrassTile(SpriteSheet sheet) {
		super(sheet);
	}

	public void render(int x, int y, Screen screen) {
		// top left
		if (Level.getTile(x + 1, y) == Tile.grassTile
				&& Level.getTile(x - 1, y) == Tile.waterTile
				&& Level.getTile(x, y + 1) == Tile.grassTile
				&& Level.getTile(x, y - 1) == Tile.waterTile)
			screen.renderTile(x << 5, y << 5, sheet.getSprite()[0]);
		// top
		else if (Level.getTile(x + 1, y) == Tile.grassTile
				&& Level.getTile(x - 1, y) == Tile.grassTile
				&& Level.getTile(x, y + 1) == Tile.grassTile
				&& Level.getTile(x, y - 1) == Tile.waterTile)
			screen.renderTile(x << 5, y << 5, sheet.getSprite()[1]);
		// top right
		else if (Level.getTile(x + 1, y) == Tile.waterTile
				&& Level.getTile(x - 1, y) == Tile.grassTile
				&& Level.getTile(x, y + 1) == Tile.grassTile
				&& Level.getTile(x, y - 1) == Tile.waterTile)
			screen.renderTile(x << 5, y << 5, sheet.getSprite()[2]);
		// left
		else if (Level.getTile(x + 1, y) == Tile.grassTile
				&& Level.getTile(x - 1, y) == Tile.waterTile
				&& Level.getTile(x, y + 1) == Tile.grassTile
				&& Level.getTile(x, y - 1) == Tile.grassTile)
			screen.renderTile(x << 5, y << 5, sheet.getSprite()[4]);
		// right
		else if (Level.getTile(x + 1, y) == Tile.waterTile
				&& Level.getTile(x - 1, y) == Tile.grassTile
				&& Level.getTile(x, y + 1) == Tile.grassTile
				&& Level.getTile(x, y - 1) == Tile.grassTile)
			screen.renderTile(x << 5, y << 5, sheet.getSprite()[6]);
		// bottom left
		else if (Level.getTile(x + 1, y) == Tile.grassTile
				&& Level.getTile(x - 1, y) == Tile.waterTile
				&& Level.getTile(x, y + 1) == Tile.waterTile
				&& Level.getTile(x, y - 1) == Tile.grassTile)
			screen.renderTile(x << 5, y << 5, sheet.getSprite()[8]);
		// bottom
		else if (Level.getTile(x + 1, y) == Tile.grassTile
				&& Level.getTile(x - 1, y) == Tile.grassTile
				&& Level.getTile(x, y + 1) == Tile.waterTile
				&& Level.getTile(x, y - 1) == Tile.grassTile)
			screen.renderTile(x << 5, y << 5, sheet.getSprite()[9]);
		// bottom right
		else if (Level.getTile(x + 1, y) == Tile.waterTile
				&& Level.getTile(x - 1, y) == Tile.grassTile
				&& Level.getTile(x, y + 1) == Tile.waterTile
				&& Level.getTile(x, y - 1) == Tile.grassTile)
			screen.renderTile(x << 5, y << 5, sheet.getSprite()[10]);
		else
			screen.renderTile(x << 5, y << 5, sheet.getSprite()[5]);

	}
}
