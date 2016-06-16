package com.sorax.Knights_Journey.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.sorax.Knights_Journey.Game;
import com.sorax.Knights_Journey.entity.mob.player.Player;
import com.sorax.Knights_Journey.level.Level;

public class Keyboard implements KeyListener {

	private boolean[] keys = new boolean[1000];
	public boolean up, down, left, right, space;

	public void update() {
		up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
		space = keys[KeyEvent.VK_SPACE];
	}

	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		
		if(e.getKeyCode() == e.VK_I) Player.inventory = !Player.inventory;
		if(e.getKeyCode() == e.VK_H && !Game.home) new Level("/level/Home.png");
		if(e.getKeyCode() == e.VK_H && Game.home) new Level("/level/map.png");
	}

	public void keyTyped(KeyEvent e) {

	}

}
