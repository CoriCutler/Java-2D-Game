package com.sorax.Knights_Journey.graphics.UI;

import java.util.ArrayList;
import java.util.List;

import com.sorax.Knights_Journey.Game;
import com.sorax.Knights_Journey.graphics.Screen;
import com.sorax.Knights_Journey.graphics.Sprite;
import com.sorax.Knights_Journey.util.Vector2i;

public class UIPanel {

	private List<UIComponent> components = new ArrayList<UIComponent>();
	private Vector2i position;

	private Sprite sprite;

	public UIPanel(Vector2i position) {
		this.position = position;
		sprite = new Sprite(Game.width / 6, Game.width, 0xcacaca);
	}

	public void addComponent(UIComponent component) {
		components.add(component);
	}

	public void update() {
		for (UIComponent component : components) {
			component.setOffset(position);
			component.update();
		}
	}

	public void render(Screen screen) {
		screen.renderSprite(position.x, position.y, sprite, false);
		for (UIComponent component : components) {
			component.render(screen);
		}
	}
}
