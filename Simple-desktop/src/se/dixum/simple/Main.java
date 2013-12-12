package se.dixum.simple;


import se.dixum.simple.test.screen.GameStarter;
import se.dixum.simple.utils.SimpleSettings;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.imagepacker.TexturePacker2.Settings;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Simple";
		cfg.useGL20 = true;
		cfg.width = SimpleSettings.GWIDTH;
		cfg.height = SimpleSettings.GHEIGHT;
		Settings setting = new Settings();
		setting.maxWidth = 2048;
		setting.maxHeight = 2048;
		//TexturePacker2.process(setting,"../Framework-android/assets/gfx/", "../Framework-android/assets/packed/", "packed");
		
		new LwjglApplication(new GameStarter(), cfg);
	}
}
