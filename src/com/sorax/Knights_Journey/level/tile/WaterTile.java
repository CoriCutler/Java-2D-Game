package com.sorax.Knights_Journey.level.tile;

import com.sorax.Knights_Journey.graphics.Screen;
import com.sorax.Knights_Journey.graphics.Sprite;
import com.sorax.Knights_Journey.graphics.SpriteSheet;
import com.sorax.Knights_Journey.level.Level;

public class WaterTile extends Tile {

	public WaterTile(SpriteSheet sheet) {
		super(sheet);
	}

	public void render(int x, int y, Screen screen) {
		// bottom left
		if (Level.getTile(x, y + 1) == Tile.waterTile
				&& Level.getTile(x, y - 1) == Tile.grassTile
				&& Level.getTile(x + 1, y - 1) == Tile.waterTile)
			screen.renderTile(x << 5, y << 5, sheet.getSprite()[14]);

		// bottom right
		else if (Level.getTile(x, y + 1) == Tile.waterTile
				&& Level.getTile(x, y - 1) == Tile.grassTile
				&& Level.getTile(x - 1, y - 1) == Tile.waterTile)
			screen.renderTile(x << 5, y << 5, sheet.getSprite()[12]);

		// bottom
		else if (Level.getTile(x, y - 1) == Tile.grassTile)
			screen.renderTile(x << 5, y << 5, sheet.getSprite()[13]);

		else
			screen.renderTile(x << 5, y << 5, sheet.getSprite()[3]);
	}

	public boolean solid() {
		return true;
	}
}
