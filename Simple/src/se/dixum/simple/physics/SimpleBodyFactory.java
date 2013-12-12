package se.dixum.simple.physics;

import se.dixum.simple.physics.util.BodyEditorLoader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;

public class SimpleBodyFactory {
	
	private  BodyDef def;
	private  FixtureDef fixDef;
	

	private  Body body;
	
	
	
	public SimpleBodyFactory() {
		
	}
	
	public SimpleBodyFactory  createBody(Vector2 position, BodyType type){
		def = new BodyDef();
		def.type = type;
		def.position.set( position);
		
		return this;
		
		
	}

	public  PolygonShape createPolyShape(float f, float g) {
		
		PolygonShape polyShape = new PolygonShape();
		polyShape.setAsBox(f, g);
		
		return polyShape;
	}

	public  CircleShape createCircelShape(float radius) {
		CircleShape circle = new CircleShape();
		circle.setRadius(radius);
		
		return circle;
		
	}
	
	public  SimpleBodyFactory createFixture(Shape shape,float density, float friction, float restitution) {
		fixDef = new FixtureDef();
		fixDef.shape = shape;
		
		fixDef.density = density;
		fixDef.restitution = restitution;
		fixDef.friction = friction;
		
		
		return this;
		
	}
	public SimpleBodyFactory setCollisionData(short groupIndex) {
		
		fixDef.filter.groupIndex = groupIndex;
		
		return this;
	}
	public  SimpleBodyFactory createFixture(Shape shape) {
		fixDef = new FixtureDef();
		fixDef.shape = shape;
		
	
		
		
		return this;
		
	}
	
	public  SimpleBodyFactory createFixture(float density, float friction, float restitution) {
		fixDef = new FixtureDef();
		fixDef.density = density;
		fixDef.restitution = restitution;
		fixDef.friction = friction;
		return this;
		
	}
	
	public  FixtureDef createFixture(Shape shape,boolean issensor) {
		
		
		FixtureDef fix = new FixtureDef();
		fix.isSensor = issensor;
		fix.shape = shape;
		return fix;
		
	}
	
	
	public void addFixture(Body body,FixtureDef fix) {
		
		
		body.getFixtureList().add(body.createFixture(fix));
		
	}
	
	
	public Body build(World world) {
		
		body = world.createBody(def);
		body.createFixture(fixDef);
		
		
		
		
		return body;
	}
	public Body build(World world,String modelFile,String modelName,float scale) {
		
		BodyEditorLoader loader = new BodyEditorLoader(Gdx.files.internal(modelFile));
		body = world.createBody(def);
		loader.attachFixture(body, modelName, fixDef, scale);
		body.createFixture(fixDef);
		
		
		
		
		return body;
	}
	
	
	
	
	
	
	
	
	
	
	

}
