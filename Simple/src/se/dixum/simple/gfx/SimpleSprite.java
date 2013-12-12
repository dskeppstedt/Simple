package se.dixum.simple.gfx;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;


public class SimpleSprite{
	
	private Sprite sprite;
		
	
	
	/**
	 * Creates a Simple sprite for a
	 * static image that can be moved.
	 * @param sprite - The gfx asset
	 * @param position - The position 
	 */
	public SimpleSprite(TextureRegion sprite, Vector2 position) {
		this.sprite = new Sprite(sprite);
		this.sprite.setPosition(position.x, position.y);
		
	
	}
	

	/**
	 * Draws the sprite
	 * @param batch
	 */
	public void drawSprite(SpriteBatch batch) {
		sprite.draw(batch);
	}

	
	
	
	
	/**
	 * Gets the current sprite position
	 * @return
	 */
	public Vector2 getPosition() {
		return new Vector2(sprite.getX(),sprite.getY());
	}
	
	/**
	 *  Sets the position with a vector
	 * @param Vector2 position
	 */
	public void setPosition(Vector2 position) {
		sprite.setPosition(position.x, position.y);
	}
	/**
	 * Set the position with two floats
	 * @param  float x
	 * @param  float y
	 */
	public void setPosition(float x, float y) {
		sprite.setPosition(x,y);
	}
	
	
	/**
	 * Returns the sprite.
	 * @return
	 */
	public Sprite getSprite() {
		return sprite;
	}
	
	/**
	 * Sets the sprite.
	 * @param sprite
	 */
	
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	
	
	
	
	
	

}
