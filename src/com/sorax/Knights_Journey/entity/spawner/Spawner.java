package com.sorax.Knights_Journey.entity.spawner;

import java.util.List;
import java.util.ArrayList;

import com.sorax.Knights_Journey.entity.Entity;
import com.sorax.Knights_Journey.entity.particle.Particle;
import com.sorax.Knights_Journey.level.Level;

public class Spawner extends Entity {

	public enum Type {
		MOB, PARTICLE;
	}

	private Type type;

	public Spawner(int x, int y, Type type, int life, int amount, Level level) {
		init(level);
		this.x = x;
		this.y = y;
		this.type = type;
		for (int i = 0; i < amount; i++) {
			if (type == Type.PARTICLE) {
				level.add(new Particle(x, y, life));
			}
		}
	}
}
