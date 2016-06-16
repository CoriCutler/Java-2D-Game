package com.sorax.Knights_Journey.entity.mob;

import java.util.List;
import java.util.ArrayList;

import com.sorax.Knights_Journey.entity.Entity;
import com.sorax.Knights_Journey.entity.particle.Particle;
import com.sorax.Knights_Journey.graphics.Screen;
import com.sorax.Knights_Journey.graphics.Sprite;

public abstract class Mob extends Entity {

	protected Sprite sprite;
	protected boolean moving = false;
	protected boolean walking = false;

	protected enum Direction {
		UP, DOWN, LEFT, RIGHT
	}

	public enum type {
		Dummy, Basic, Attack;
	}

	protected Direction dir;

	public void move(int xa, int ya) {
		if (xa != 0 && ya != 0) {
			move(xa, 0);
			move(0, ya);
			return;
		}

		if (xa > 0)
			dir = Direction.RIGHT;
		if (xa < 0)
			dir = Direction.LEFT;
		if (ya > 0)
			dir = Direction.DOWN;
		if (ya < 0)
			dir = Direction.UP;

		if (!collision(xa, ya, true)) {
			x += xa;
			y += ya;
		} else {
			// Particle p = new Particle(x, y, 50, 500);
			// level.add(p);
		}
	}

	public abstract void update();

	public abstract void render(Screen screen);

	private boolean collision(int xa, int ya, boolean square) {
		boolean solid = false;
		if(square){
			for (int c = 0; c < 4; c++) {
				int xt = ((x + xa) + c % 2 * 15 - 10) / 32;
				int yt = ((y + ya) + c / 2 * 24 - 4) / 32;
				if (level.getTile(xt, yt).solid())
					solid = true;
			}
		}
		else {
			for (int c = 0; c < 4; c++) {
				int xt = ((x + xa) + c % 2 * 15 - 10) / 32;
				int yt = ((y + ya) + c / 2 * 24 - 4) / 32;
				if (level.getTile(xt, yt).solid())
					solid = true;
			}
		}
		return solid;
	}
}
