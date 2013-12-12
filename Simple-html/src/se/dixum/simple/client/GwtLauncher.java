package se.dixum.simple.client;


import se.dixum.simple.test.screen.GameStarter;
import se.dixum.simple.utils.SimpleSettings;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;

public class GwtLauncher extends GwtApplication {
	@Override
	public GwtApplicationConfiguration getConfig () {
		GwtApplicationConfiguration cfg = new GwtApplicationConfiguration(SimpleSettings.GWIDTH, SimpleSettings.GHEIGHT);
		return cfg;
	}

	@Override
	public ApplicationListener getApplicationListener () {
		return new GameStarter();
	}
}