package se.dixum.simple.test.screen;

import se.dixum.simple.gfx.SimpleGL;
import se.dixum.simple.gfx.SimpleTileMap;
import se.dixum.simple.physics.SimpleBodyFactory;
import se.dixum.simple.screen.base.SimpleScreen;
import se.dixum.simple.test.entities.Boat;
import se.dixum.simple.test.entities.Box;
import se.dixum.simple.test.entities.Player;
import se.dixum.simple.test.util.Resources;
import se.dixum.simple.test.util.SettingsUtil;
import se.dixum.simple.utils.SimpleInput;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

public class GameScreen extends SimpleScreen {

	private SpriteBatch batch;
	private Box box;
	private Player player;
	private SimpleTileMap map;
	private Boat boat;
	
	
	private World world;
	private Box2DDebugRenderer physRenderer;
	private OrthographicCamera physCamera;
	public static SimpleBodyFactory BODYFACTORY;
	
	
	public GameScreen(Game game) {
		super(game);
	}

	@Override
	public void init() {
		//Cameras and such
		camera = new OrthographicCamera(SettingsUtil.GWIDTH, SettingsUtil.GHEIGHT);
		camera.setToOrtho(false);
		batch = new SpriteBatch();
		Gdx.input.setInputProcessor(new SimpleInput());
		
		//Physics
		world = new World(new Vector2(0,-10),true);
		physRenderer = new Box2DDebugRenderer();
		physCamera = new OrthographicCamera(18, 10);
		physCamera.position.set(9, 5, 0);
		BODYFACTORY = new SimpleBodyFactory();
		
		
		//Create assets
		Resources.createEntityAssets();
		
		
		
		//Entites
		box = new Box(world);
		player = new Player(world);
		map = new SimpleTileMap("map/map.tmx",1);
		boat = new Boat(world);
		SimpleTileMap.parseTileMap(map, "Collision", world, 1/70f);
		
		
		
		
		
	}

	@Override
	public void update(float delta) {
		box.update(delta);
		player.update(delta);
		boat.update(delta);
		
		world.step(delta, 6, 3);
		
	}

	@Override
	public void draw() {
		SimpleGL.OpenGLClear(1, 1, 1, 1);
		camera.update();
		physCamera.update();
		
		map.draw(camera);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
			box.draw(batch);
			player.draw(batch);
			boat.draw(batch);
		batch.end();
		
		physRenderer.render(world, physCamera.combined);
		
		
		
	}
	@Override
	public void dispose() {
		super.dispose();
		
		player.dispose();
	}

}
