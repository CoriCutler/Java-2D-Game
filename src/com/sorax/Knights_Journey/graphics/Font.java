package com.sorax.Knights_Journey.graphics;

public class Font {

	public static SpriteSheet font = new SpriteSheet("/fonts/text.png", 260, 20);
	public static SpriteSheet text = new SpriteSheet(font, 0, 0, 26, 2, 10);

	private static String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789 ";

	public static void render(int x, int y, String text, Screen screen) {
		render(x, y, 0, 0, text, screen);
	}

	public void render(int x, int y, int colour, String text, Screen screen) {
		render(x, y, 0, colour, text, screen);
	}

	public static void render(int x, int y, int spacing, int colour,
			String msg, Screen screen) {
		int xOffset = 0;
		int line = 0;
		for (int i = 0; i < msg.length(); i++) {
			xOffset += 16 + spacing;
			int yOffset = 0;
			char currentChar = msg.toUpperCase().charAt(i);
			if (currentChar == 'g' || currentChar == 'y' || currentChar == 'q'
					|| currentChar == 'p' || currentChar == 'j'
					|| currentChar == ',')
				yOffset = 4;
			if (currentChar == '\n') {
				xOffset = 0;
				line++;
			}
			int index = chars.indexOf(currentChar);
			if (index == -1)
				continue;
			screen.renderSprite(x + xOffset, y + (line * 20) + yOffset,
					text.getSprite()[index], true);
		}
	}
}