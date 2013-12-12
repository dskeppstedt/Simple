package se.dixum.simple.gfx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;

public class SimpleGL {
	/**
	 * Use this before anything else in you draw method to clear the screen
	 * with the chosen colour. Ranging from 0-1.
	 *
	 * @param float red
	 * @param float green
	 * @param float blue
	 * @param float alpha
	 */
	public static void OpenGLClear(float red,float green,float blue, float alpha){
		Gdx.gl.glClearColor(red, green, blue,alpha);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
	}
	
	
	

}
