package com.alkerth.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.alkerth.game.StarWIP;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = StarWIP.height;
		config.width = StarWIP.width;
		new LwjglApplication(new StarWIP(), config);
	}
}
