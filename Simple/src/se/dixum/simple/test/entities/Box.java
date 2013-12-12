package se.dixum.simple.test.entities;

import se.dixum.simple.entities.base.SimpleBaseEntity;
import se.dixum.simple.gfx.SimpleSprite;
import se.dixum.simple.test.screen.GameScreen;
import se.dixum.simple.test.util.Resources;
import se.dixum.simple.test.util.SettingsUtil;
import se.dixum.simple.utils.SimpleInput;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.World;

public class Box implements SimpleBaseEntity {

	private SimpleSprite boxSprite;
	private Body boxBody;
	private World world;
	public Box(World world){
		this.world = world;
		init();
	}

	@Override
	public void init() {
		boxBody = GameScreen.BODYFACTORY.createBody(new Vector2(3,10), BodyType.DynamicBody).
				    createFixture(GameScreen.BODYFACTORY.createPolyShape(0.5f, 0.5f), 0.5f, 0.5f, 0.5f).build(world);
		boxSprite = new SimpleSprite(Resources.BOX, 
				    new Vector2(boxBody.getPosition().x * SettingsUtil.BOX_TO_WORLD,
				    boxBody.getPosition().y * SettingsUtil.BOX_TO_WORLD));
		boxBody.applyTorque(50, true);
		
	}

	@Override
	public void update(float delta) {
			
		boxSprite.setPosition(boxBody.getPosition().sub(new Vector2(0.5f,0.5f)).scl(SettingsUtil.BOX_TO_WORLD));
		boxSprite.getSprite().setRotation(boxBody.getAngle() * MathUtils.radiansToDegrees);
		if (SimpleInput.ACTION) {
			boxBody.applyTorque(10, true);
		}
		
		
		
	}

	@Override
	public void draw(SpriteBatch batch) {
		boxSprite.drawSprite(batch);
	}

}
