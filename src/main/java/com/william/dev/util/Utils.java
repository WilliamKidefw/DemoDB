package com.william.dev.util;

import java.util.Random;

public class Utils {
	
	static Random random = new Random();

	private Utils() {
	    throw new IllegalStateException("Utility class");
	}

	public static int randomNumbers() {
		return random.ints(0, 1000)
			      .findFirst()
			      .getAsInt();
	}
}
