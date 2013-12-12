package se.dixum.simple.utils;

import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;

public class SimpleGesture implements GestureListener {
	
	
	public static boolean PAN = false,FLING = false;
	public static float PAN_DX = 0, PAN_DY =0;
	
	
	
	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {
		
		return false;
	}

	@Override
	public boolean tap(float x, float y, int count, int button) {
		
		return false;
	}

	@Override
	public boolean longPress(float x, float y) {
		
		return false;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		PAN = false;
		PAN_DX = 0;
		PAN_DY = 0;
		return false;
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		
		PAN = true;
		PAN_DX = deltaX;
		PAN_DY = deltaY;
		
		
		return false;
	}

	@Override
	public boolean zoom(float initialDistance, float distance) {
		
		return false;
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2,
			Vector2 pointer1, Vector2 pointer2) {
		
		
		return false;
	}

	@Override
	public boolean panStop(float x, float y, int pointer, int button) {
		
		return false;
	}

}
