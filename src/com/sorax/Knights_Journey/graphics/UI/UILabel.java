package com.sorax.Knights_Journey.graphics.UI;

import com.sorax.Knights_Journey.graphics.Font;
import com.sorax.Knights_Journey.graphics.Screen;
import com.sorax.Knights_Journey.util.Vector2i;

public class UILabel extends UIComponent {

	public String text;
	private Font font;

	public UILabel(Vector2i position, String text) {
		super(position);
		font = new Font();
		this.text = text;
	}

	public void render(Screen screen) {
		font.render(position.x + offset.x, position.y + offset.y, -5, 0, text,
				screen);
	}

}
