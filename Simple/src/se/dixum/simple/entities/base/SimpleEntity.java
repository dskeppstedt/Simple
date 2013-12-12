package se.dixum.simple.entities.base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class SimpleEntity {
	
	private Vector2 position;
	private float rotation = 0;
	private Vector2 dimensions;
	private Vector2 velocity;
	private Angle angle;
	private boolean alive;
	private Vector2 origin;
	private Vector2 scale;
	public float scaleX = Gdx.graphics.getWidth()/1260;
	public float scaleY = Gdx.graphics.getHeight()/700;
	
	
	
	/**
	 * Default constructor for an entiy.
	 * Sets the position and velocity to 0;0 Angle = UP
	 * and creates an empty sprite. Alive is true.
	 */
	public SimpleEntity() {
		setPosition(new Vector2(0,0));
		setVelocity(new Vector2(0,0));
		setDimensions(new Vector2(0,0));
		setOrigin(new Vector2(0,0));
		setScale(new Vector2(1,1));
		setAngle(Angle.UP);
		setAlive(true);
	
	}

	public Vector2 getPosition() {
		return position;
	}






	public void setPosition(Vector2 position) {
		this.position = position;
	}
	public void setPosition(float x, float y) {
		this.position.set(x, y);
	}


	
	
	public float getX() {
		return getPosition().x;
	}
	
	public void setX(float x) {
		getPosition().x = x;
	}
	
	public float getY() {
		return getPosition().y;
	}
	public void setY(float y) {
		getPosition().y = y;
	}

	
	

	public Vector2 getVelocity() {
		return velocity;
	}

	public float getVelX() {
		return getVelocity().x;
	}
	
	public void setVelX(float x) {
		getVelocity().x = x;
	}
	
	public float getVelY() {
		return getVelocity().y;
	}
	public void setVelY(float y) {
		getVelocity().y = y;
	}




	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}
	public void setVelocity(float x, float y) {
		getVelocity().set(x, y);
	}


	public boolean isAlive() {
		return alive;
	}



	public void setAlive(boolean alive) {
		this.alive = alive;
	}



	public Angle getAngle() {
		return angle;
	}



	public void setAngle(Angle angle) {
		this.angle = angle;
	}












	public Vector2 getDimensions() {
		return dimensions;
	}












	public void setDimensions(Vector2 dimensions) {
		this.dimensions = dimensions;
	}












	public float getRotation() {
		return rotation;
	}












	public void setRotation(float rotation) {
		this.rotation = rotation;
	}

	public Vector2 getOrigin() {
		return origin;
	}

	public void setOrigin(Vector2 origin) {
		this.origin = origin;
	}

	public Vector2 getScale() {
		return scale;
	}

	public void setScale(Vector2 scale) {
		this.scale = scale;
	}




	
	
	
	
	

}
