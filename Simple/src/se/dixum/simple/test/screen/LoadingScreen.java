package se.dixum.simple.test.screen;

import se.dixum.simple.screen.base.SimpleScreen;
import se.dixum.simple.utils.SimpleLoaderUtil;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class LoadingScreen extends SimpleScreen {
	
	@SuppressWarnings("unused")
	private SimpleLoaderUtil loader;
	
	public LoadingScreen(Game game) {
		super(game);

	}

	@Override
	public void init() {
		loader = new SimpleLoaderUtil();
		SimpleLoaderUtil.MANAGER.load("gfx/box.png", Texture.class);
		SimpleLoaderUtil.MANAGER.load("gfx/animation.png", Texture.class);
		SimpleLoaderUtil.MANAGER.load("models/boat1.png", Texture.class);
		SimpleLoaderUtil.MANAGER.load("sound/soundeffect.wav",Sound.class);
		SimpleLoaderUtil.MANAGER.load("sound/music.ogg",Music.class);
	}

	@Override
	public void update(float delta) {
		if (SimpleLoaderUtil.MANAGER.update()) {
			getGame().setScreen(new GameScreen(getGame()));
		}else {
			System.out.println("Loading -- " +SimpleLoaderUtil.MANAGER.getProgress()  * 100 + "%");
		}
		
		
	}

	@Override
	public void draw() {
	}

}
