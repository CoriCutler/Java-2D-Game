package com.sorax.Knights_Journey.entity.mob.player;

import java.awt.Graphics;
import java.awt.Image;

import com.sorax.Knights_Journey.Game;
import com.sorax.Knights_Journey.database.Database;
import com.sorax.Knights_Journey.entity.mob.Mob;
import com.sorax.Knights_Journey.entity.mob.player.armour.Armour;
import com.sorax.Knights_Journey.entity.mob.player.weapon.Weapon;
import com.sorax.Knights_Journey.graphics.AnimatedSprite;
import com.sorax.Knights_Journey.graphics.Font;
import com.sorax.Knights_Journey.graphics.Screen;
import com.sorax.Knights_Journey.graphics.Sprite;
import com.sorax.Knights_Journey.graphics.SpriteSheet;
import com.sorax.Knights_Journey.graphics.UI.UILabel;
import com.sorax.Knights_Journey.graphics.UI.UIManager;
import com.sorax.Knights_Journey.graphics.UI.UIPanel;
import com.sorax.Knights_Journey.input.Keyboard;
import com.sorax.Knights_Journey.input.Mouse;
import com.sorax.Knights_Journey.level.Level;
import com.sorax.Knights_Journey.level.tile.Tile;
import com.sorax.Knights_Journey.util.Vector2i;

public class Player extends Mob {

	private int speed = 1;
	public static String username = "";
	public static String armour = "1,1,1,1,1,1";
	public static int weapon = 0;
	public static boolean inventory = false;

	private Keyboard input;
	private Sprite sprite;
	private int anim;
	private boolean walking = false;
	private String dir = "down";
	//player
	private AnimatedSprite player_up = new AnimatedSprite(SpriteSheet.player_up, 64,64, 9);
	private AnimatedSprite player_down = new AnimatedSprite(SpriteSheet.player_down,64, 64, 9);
	private AnimatedSprite player_left = new AnimatedSprite(SpriteSheet.player_left,64, 64, 9);
	private AnimatedSprite player_right = new AnimatedSprite(SpriteSheet.player_right,64, 64, 9);

	protected AnimatedSprite animSprite = player_down;

	private UIManager ui;

	public Player(Keyboard input) {
		this.input = input;
		animSprite = player_down;
	}

	public Player(int x, int y, Keyboard input, String username, String armour) {
		this.x = (x * 32);
		this.y = (y * 32);
		this.input = input;
		this.username = username;
		sprite = SpriteSheet.player_down.getSprite()[0];
	}

	public void update() {
		
		ui = Game.getUIManager(); 
		UIPanel panel = new UIPanel(new Vector2i(Game.width - (Game.width / 6), 0));
		if(inventory){
			ui.addPanel(panel);
		}else{
			ui.removePanel(panel);
		}
		
		if (walking){
			animSprite.update();
			Armour.armour(armour, animSprite.frame, dir);
			Weapon.weapon(weapon, animSprite.frame, dir);
		}
		else{
			animSprite.setFrame(0);
			Armour.armour(armour, 0, dir);
			Weapon.weapon(weapon, 0, dir);
		}
		int xa = 0, ya = 0;
		if (anim < 7500)
			anim++;
		else
			anim = 0;

		if (input.up) {
			dir = "up";
			ya -= speed;
			animSprite = player_up;
		}
		if (input.down) {
			dir = "down";
			ya += speed;
			animSprite = player_down;
		}
		if (input.left) {
			dir = "left";
			xa -= speed;
			animSprite = player_left;
		}
		if (input.right) {
			dir = "right";
			xa += speed;
			animSprite = player_right;
		}
		if (xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		} else {
			walking = false;
		}
	}

	public void render(Screen screen) {
		sprite = animSprite.getSprite();
		if (username != null){
			if((username.length() & 1) == 0)Font.render((x - 32) - (username.length() / 2 * (username.length())), y - 40, -2, 0,username, screen);
			else Font.render((x - 32) - (username.length() / 2 * 10), y - 40, -2, 0,username, screen);
		}
		screen.renderMob(x - 32, y - 45, sprite);
		Armour.render(screen, x-32, y-45);
		Weapon.render(screen, x-32, y-45);
	}
}
