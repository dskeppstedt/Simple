package se.dixum.simple.test.entities;

import se.dixum.simple.entities.base.SimpleBaseEntity;
import se.dixum.simple.gfx.SimpleSprite;
import se.dixum.simple.test.screen.GameScreen;
import se.dixum.simple.test.util.Resources;
import se.dixum.simple.test.util.SettingsUtil;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.World;

public class Boat implements SimpleBaseEntity{
	
	Body boatBody;
	SimpleSprite boat;
	
	
	public Boat(World world) {
		
		boatBody = GameScreen.BODYFACTORY.createBody(new Vector2(0,0), BodyType.KinematicBody).
				createFixture(1, 0, 0).build(world, "models/boat.json", "boat", 18.2f);
		
		init();
		
		
	}

	@Override
	public void init() {
		boat = new SimpleSprite(Resources.BOAT,new Vector2(boatBody.getPosition().x * SettingsUtil.BOX_TO_WORLD
				,boatBody.getPosition().y * SettingsUtil.BOX_TO_WORLD));
	}

	@Override
	public void update(float delta) {
		
		boatBody.setLinearVelocity(0, -0.6f);
		
		boat.setPosition(boatBody.getPosition().scl(SettingsUtil.BOX_TO_WORLD));
		
		
	}

	@Override
	public void draw(SpriteBatch batch) {
		boat.drawSprite(batch);
	}

}
