package com.sorax.Knights_Journey.entity.mob.player.armour;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.sorax.Knights_Journey.graphics.Screen;
import com.sorax.Knights_Journey.graphics.Sprite;

public abstract class Armour{
	
	protected static int[] Armour;
	protected static int frame;

	public static void armour(String armour, int frames, String direction){
		if(armour != null){
		      String[] stringArray = armour.split(",");
		      Armour = new int[stringArray.length];
		      for (int i = 0; i < stringArray.length; i++) {
		         String numberAsString = stringArray[i];
		         Armour[i] = Integer.parseInt(numberAsString);
		      } 
		}
		if(direction == "up")frame = frames;
		if(direction == "left")frame = frames + 9;
		if(direction == "down")frame = frames + 18;
		if(direction == "right")frame = frames + 27;
	}
	
	public static void render(Screen screen, int x, int y){
		if(Armour == null)armour("0,0,0,0,0,0", 0, "down");
		if(Armour[0] != 0)Head.render(screen, x, y);
		if(Armour[3] != 0)Legs.render(screen, x, y);
		if(Armour[1] != 0)Torso.render(screen, x, y);
	}
	
}
