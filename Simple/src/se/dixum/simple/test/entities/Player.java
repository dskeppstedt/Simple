package se.dixum.simple.test.entities;

import se.dixum.simple.audio.SimpleSound;
import se.dixum.simple.entities.base.SimpleBaseEntity;
import se.dixum.simple.gfx.SimpleAnimated;
import se.dixum.simple.test.screen.GameScreen;
import se.dixum.simple.test.util.Resources;
import se.dixum.simple.test.util.SettingsUtil;
import se.dixum.simple.utils.SimpleInput;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.World;

public class Player implements SimpleBaseEntity {
	private Body body;
	private SimpleAnimated playerSprite;
	private SimpleSound effect;
	private Animation walk,stand;
	
	private World world;
	
	public Player(World world) {
		this.world = world;
		init();
	}

	@Override
	public void init() {
		playerSprite = new SimpleAnimated(Resources.PLAYER_SHEET, 80, 94, 0.1f);
		walk = playerSprite.createAnimation(0, 6, 1);
		stand = playerSprite.createAnimation(0, 8, 0);
		playerSprite.setCurrentAnimation(stand);
		effect = new SimpleSound(Resources.EFFECT);
		
		body = GameScreen.BODYFACTORY.createBody(new Vector2(6,10), BodyType.DynamicBody).
				createFixture(GameScreen.BODYFACTORY.createPolyShape((80/70f)/2f, (94/70f)/2f), 0.5f, 0.5f, 0)
				.build(world);
		
		playerSprite.setPosition(body.getPosition());
		playerSprite.setOrigin(new Vector2(40,47));
		
		
		
	}

	@Override
	public void update(float delta) {
		
		playerSprite.setPosition(body.getPosition().sub(new Vector2(0.5f,0.5f)));
		playerSprite.setRotation(body.getAngle()*MathUtils.radiansToDegrees);
		
		
		
		playerSprite.updateAnimation(delta);
		
		if (SimpleInput.ACTION) {
			playerSprite.setCurrentAnimation(walk);
			body.applyTorque(10, true);
		}
		
		
	}

	@Override
	public void draw(SpriteBatch batch) {
	
		playerSprite.drawAnimation(batch,SettingsUtil.BOX_TO_WORLD);
	
	
	
	}
	
	
	public void dispose() {
		effect.dispose();
	}
	

}
