package com.sorax.Knights_Journey.graphics.UI;

import java.util.ArrayList;
import java.util.List;

import com.sorax.Knights_Journey.graphics.Screen;

public class UIManager {

	private List<UIPanel> panels = new ArrayList<UIPanel>();

	public UIManager() {

	}

	public void addPanel(UIPanel panel) {
		panels.add(panel);
	}
	
	public void removePanel(UIPanel panel) {
		panels.clear();
	}

	public void update() {
		for (UIPanel panel : panels) {
			panel.update();
		}
	}

	public void render(Screen screen) {
		for (UIPanel panel : panels) {
			panel.render(screen);
		}
	}
}
