package se.dixum.simple.test.screen;

import com.badlogic.gdx.Game;

public class GameStarter extends Game{
	
	
	
	
	@Override
	public void create() {
		setScreen(new LoadingScreen(this));
	
	
	}
	
	

}
