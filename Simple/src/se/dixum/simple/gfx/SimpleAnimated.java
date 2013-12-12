package se.dixum.simple.gfx;

import se.dixum.simple.entities.base.SimpleEntity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;


public class SimpleAnimated extends SimpleEntity {
	
	private Animation currentAnimation;
	private TextureRegion currentFrame;
	private float duration = 0;
	private Array<TextureRegion> frames = new Array<TextureRegion>();
	private int frameWidth,frameHeight;
	private Texture sheet;
	private boolean looping = true;
	
	/**
	 * The constructor for an animated object
	 * @param Texture sheet
	 * @param int frameWidth
	 * @param int frameHeight
	 * @param float duration
	 */
	public SimpleAnimated(Texture sheet,int frameWidth,int frameHeight, float duration) {
		this.sheet = sheet;
		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;
		this.duration = duration;
		setDimensions(new Vector2(frameWidth,frameHeight));
	}
	
	
	/**
	 * Creates an animation from the previously declared texture.
	 * @param int startPos
	 * @param int endPos
	 * @param int row
	 * @return Animation animation
	 */
	public Animation createAnimation(int startPos,int endPos, int row) {
		frames.clear();
		for (int i = startPos; i<endPos; i++) {
			frames.add(new TextureRegion(sheet,frameWidth*i,frameHeight*row,frameWidth,frameHeight));
		}
		return new Animation (duration,frames);
			
	}
	/**
	 * Sets the current frame that should be shown during animation.
	 * @param TextureRegion current
	 */
	public void setCurrentFrame(TextureRegion current) {
		this.currentFrame =current; 
	}
	
	/**
	 * Updates the animation
	 * @param float delta
	 */
	public void updateAnimation(float delta) {
		duration +=delta;
		setCurrentFrame(currentAnimation.getKeyFrame(duration,looping));
	}
	
	
	
	/**
	 * Draws the current frame in the animation.
	 * Supports scaling and rotation.
	 * @param Spritebatch batch
	 */
	public void drawAnimation (SpriteBatch batch) {
		batch.draw(getCurrentFrame(), getX(), getY(), getOrigin().x, getOrigin().y,
				getDimensions().x, getDimensions().y, getScale().x, getScale().y, getRotation());
		
		
		
	}
	
	
	/**
	 * Draws the current frame in the animation.
	 * Supports scaling and rotation.
	 * This could be used with the physics engine as it
	 * supports the scaling in units.
	 * @param batch
	 * @param BOX_TO_WORLD
	 */
	public void drawAnimation(SpriteBatch batch , float BOX_TO_WORLD) {
		batch.draw(getCurrentFrame(), getX()*BOX_TO_WORLD, getY()*BOX_TO_WORLD, getOrigin().x, getOrigin().y,
				getDimensions().x, getDimensions().y, getScale().x, getScale().y, getRotation());
	}
	
	
	
	/**
	 * Gets the current frame
	 * @return TextureRegion currentFrame
	 */
	public TextureRegion getCurrentFrame() {
		return currentFrame;
	}
	/**
	 * Sets the current animation
	 * @param Animation currentAnimation
	 */
	public void setCurrentAnimation(Animation currentAnimation) {
		this.currentAnimation = currentAnimation;
		
	}
	/**
	 * Gets the current animation
	 * @return Animation currentAnimation
	 */
	public Animation getCurrentAnimation() {
		return currentAnimation;
	}
	/**
	 * Checks if the animation is looping
	 * @return boolean looping
	 */
	public boolean isLooping() {
		return looping;
	}
	/**
	 * Sets whatever the animation should be looping
	 * @param boolean looping
	 */
	public void setLooping(boolean looping) {
		this.looping = looping;
	}

	public Texture getSheet() {
		return sheet;
	}

	public void setSheet(Texture sheet) {
		this.sheet = sheet;
	}

	public int getFrameWidth() {
		return frameWidth;
	}

	public void setFrameWidth(int frameWidth) {
		this.frameWidth = frameWidth;
	}

	public int getFrameHeight() {
		return frameHeight;
	}

	public void setFrameHeight(int frameHeight) {
		this.frameHeight = frameHeight;
	}

	public float getDuration() {
		return duration;
	}

	public void setDuration(float duration) {
		this.duration = duration;
	}
	
	
	public void dispose() {
		sheet.dispose();
		
	}
	
	
	
	
	
	
	

}
