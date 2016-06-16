package com.sorax.Knights_Journey.entity.mob.player.armour;

import com.sorax.Knights_Journey.graphics.Screen;
import com.sorax.Knights_Journey.graphics.Sprite;
import com.sorax.Knights_Journey.graphics.SpriteSheet;

public class Torso extends Armour{
	
	private static SpriteSheet chainArmour = new SpriteSheet("/players/armour/torso/TORSO_chain_armor_torso.png", 576, 256);
	private static SpriteSheet chain = new SpriteSheet(chainArmour, 0, 0, 9,4,64);
	
	public static void getTorso(int id){
	}
	
	public static void render(Screen screen, int x, int y){
		screen.renderSprite(x, y, chain.getSprite()[frame], true);
	}
	
}
