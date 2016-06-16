package com.sorax.Knights_Journey.entity.mob.player.armour;

import com.sorax.Knights_Journey.graphics.Screen;
import com.sorax.Knights_Journey.graphics.Sprite;
import com.sorax.Knights_Journey.graphics.SpriteSheet;

public class Belt {
	
	private static SpriteSheet chainArmour = new SpriteSheet("/players/armour/pants/LEGS_pants_greenish.png", 576, 256);
	private static SpriteSheet chain = new SpriteSheet(chainArmour, 0, 0, 9,4,64);
	
	public static void getTorso(int id){
	}
	
	public static void render(Screen screen, int x, int y){
		screen.renderSprite(x, y, chain.getSprite()[1], true);
	}
	
}
