package com.sorax.Knights_Journey.entity.mob.player.weapon;

import com.sorax.Knights_Journey.graphics.Screen;
import com.sorax.Knights_Journey.graphics.Sprite;
import com.sorax.Knights_Journey.graphics.SpriteSheet;

public class Weapon {
	
	private static SpriteSheet shield = new SpriteSheet("/players/armour/weapon/WEAPON_shield_cutout_body.png", 576, 256);
	private static SpriteSheet bow = new SpriteSheet("/players/armour/weapon/WEAPON_bow.png", 832, 256);
	private static SpriteSheet armour = null;
	
	private static Sprite sprite = null;
	
	public static void weapon(int id, int frame, String direction){
		
		int maxframe = 0;
		
		if(id == 0) {
			armour = new SpriteSheet(shield, 0, 0, 9,4,64);
			maxframe = 9;
		}
		if(id == 1) {
			armour = new SpriteSheet(bow, 0, 0, 13, 4, 64);
			maxframe = 13;
		}
		
		if(direction == "up")sprite = armour.getSprite()[frame];
		if(direction == "left")sprite = armour.getSprite()[frame + (maxframe)];
		if(direction == "down")sprite = armour.getSprite()[frame + (maxframe * 2)];
		if(direction == "right")sprite = armour.getSprite()[frame + (maxframe * 3)];
	}
	
	public static void render(Screen screen, int x, int y){
		if(sprite != null)screen.renderSprite(x, y, sprite, true);
	}
	
}
