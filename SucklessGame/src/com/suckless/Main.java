package com.suckless;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new LwjglApplication(new GameMain(), "Suckless dude", 300, 300, true);

	}

}
