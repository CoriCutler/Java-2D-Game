package com.sorax.Knights_Journey.level;

public class Time {

	private static float time = 0f;
	private static boolean day = true;

	public static void clock() {
		if (day)
			time += 0.00001;
		if (!day)
			time -= 0.00001;
		if (time < 0.01)
			day = true;
		if (time >= 0.7)
			day = false;
	}

	public static float getTime() {
		return time;
	}
}
