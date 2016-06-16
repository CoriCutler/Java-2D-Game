package com.sorax.Knights_Journey.graphics.UI;

import com.sorax.Knights_Journey.graphics.Screen;
import com.sorax.Knights_Journey.util.Vector2i;

public class UIComponent {

	public int backgroundColour;
	public Vector2i position, offset;

	public UIComponent(Vector2i position) {
		this.position = position;
		offset = new Vector2i();
	}

	public void update() {
	}

	public void render(Screen screen) {
	}

	void setOffset(Vector2i offset) {
		this.offset = offset;
	}
}
