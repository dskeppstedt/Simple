package se.dixum.simple.entities.base;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface SimpleBaseEntity {
	public void init();
	public void update(float delta);
	public void draw(SpriteBatch batch);

}
