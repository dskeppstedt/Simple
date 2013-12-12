package se.dixum.simple.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class SimpleInput implements InputProcessor {
 
	public static boolean UP,DOWN,LEFT,RIGHT,ACTION;
	public static boolean TOUCH = false;
	public static boolean MOUSE_LEFT = false;
	public static boolean MOUSE_RIGHT =false;
	public static float MOUSE_X, MOUSE_Y,END_X,END_Y;
	public static int FINGERS = 0;
	
	public SimpleInput() {
		UP= DOWN = LEFT = RIGHT = ACTION = false;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		
		
		switch (keycode) {
		case Input.Keys.A:
		case Input.Keys.LEFT:
			LEFT = true;
			break;
		case Input.Keys.D:
		case Input.Keys.RIGHT:
			RIGHT = true;
			break;
		case Input.Keys.W:
		case Input.Keys.UP:
			UP = true;
			break;
		case Input.Keys.S:
		case Input.Keys.DOWN:
			DOWN = true;
			break;
		case Input.Keys.SPACE:
		case Input.Keys.CONTROL_LEFT:
			ACTION = true;
			break;
		}
					
		
		
		return false;
	}


	@Override
	public boolean keyUp(int keycode) {
		switch (keycode) {
		case Input.Keys.A:
		case Input.Keys.LEFT:
			LEFT = false;
			break;
		case Input.Keys.D:
		case Input.Keys.RIGHT:
			RIGHT = false;
			break;
		case Input.Keys.W:
		case Input.Keys.UP:
			UP = false;
			break;
		case Input.Keys.S:
		case Input.Keys.DOWN:
			DOWN = false;
			break;
		case Input.Keys.SPACE:
		case Input.Keys.CONTROL_LEFT:
			ACTION = false;
			break;
		}
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		
		if (button == Input.Buttons.LEFT) {
			TOUCH = true;
			MOUSE_LEFT = true;
		}
		
		if (button ==Input.Buttons.RIGHT) {
			MOUSE_RIGHT = true;
			
		}
		;
		FINGERS +=1;
			MOUSE_X = screenX;
			MOUSE_Y = Gdx.graphics.getHeight()-screenY;
		
	
		
		
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		if (button == Input.Buttons.LEFT) {
		TOUCH = false;
		MOUSE_LEFT = false;
		}
		if (button == Input.Buttons.RIGHT) {
			MOUSE_RIGHT = false;
		}
		
		FINGERS -=1;
			END_X = screenX;
			END_Y = Gdx.graphics.getHeight()-screenY;
		
	
		
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		TOUCH = true;
		
			MOUSE_X = screenX;
			MOUSE_Y = Gdx.graphics.getHeight()-screenY;
		

			MOUSE_X = screenX;
			MOUSE_Y = screenY;
	
		
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		
			MOUSE_X = screenX;
			MOUSE_Y =	Gdx.graphics.getHeight()-screenY;
		
		
			MOUSE_X = screenX;
			MOUSE_Y = screenY;
		
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		
		return false;
	}

}
