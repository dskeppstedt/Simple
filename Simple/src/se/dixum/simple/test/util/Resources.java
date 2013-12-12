package se.dixum.simple.test.util;

import se.dixum.simple.utils.SimpleLoaderUtil;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Resources {
	
	public static TextureRegion BOX,BOAT;
	public static Texture PLAYER_SHEET;
	public static Sound EFFECT;
	public static Music MUSIC;
	
	public static void createEntityAssets() {
		BOX = new TextureRegion(SimpleLoaderUtil.MANAGER.get("gfx/box.png",Texture.class));
		PLAYER_SHEET = SimpleLoaderUtil.MANAGER.get("gfx/animation.png",Texture.class);
		EFFECT = SimpleLoaderUtil.MANAGER.get("sound/soundeffect.wav",Sound.class);
		MUSIC = SimpleLoaderUtil.MANAGER.get("sound/music.ogg",Music.class);
		BOAT = new TextureRegion(SimpleLoaderUtil.MANAGER.get("models/boat1.png",Texture.class));
	}
	
	
	
	
	
}
