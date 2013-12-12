package se.dixum.simple.screen.base;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public abstract class SimpleScreen implements Screen {
	
	private Game game;
	protected OrthographicCamera camera;
	protected Stage stage;
	protected Table table;
	/**
	 * Defaulte contructor for a screen. 
	 * This constructor also calls init();
	 * @param game - the current game application listener.
	 */
	public SimpleScreen(Game game) {
		this.setGame(game);
		
		init();
	}
	
	
	public abstract void init();
	
	public abstract void update(float delta);
	
	public abstract void draw() ;
	
	
	
	
	
	@Override
	public void render(float delta) {
		update(delta);
		draw();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}


	public Game getGame() {
		return game;
	}


	public void setGame(Game game) {
		this.game = game;
	}


	public OrthographicCamera getCamera() {
		return camera;
	}


	public void setCamera(OrthographicCamera camera) {
		this.camera = camera;
	}

}
