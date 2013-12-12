package se.dixum.simple.gfx;

import se.dixum.simple.physics.SimpleBodyFactory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.PolylineMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

public class SimpleTileMap {

	private OrthogonalTiledMapRenderer mapRender;
	private TiledMap map;	
	private String filename;
	private float unitScale = 1;
	/**
	 * Creates a SipleTileMap object
	 * Used for TileMaps. Needs an map asset and 
	 * the unitsacale
	 * @param String filename
	 * @param float unitScale
	 */
	public SimpleTileMap(String filename,float unitScale) {
		this.unitScale = unitScale;
		this.filename = filename;
		init();
	}
	
	
	
	private void init() {
		map = new TmxMapLoader().load(filename);
		mapRender = new OrthogonalTiledMapRenderer(map,unitScale);
		
		
	}


	/**
	 * Draws the map in the current view from the selected camera
	 * @param OrthographicCamera camera
	 */
	public void draw(OrthographicCamera camera) {
		mapRender.setView(camera);
		mapRender.render();
	
	}
	/**
	 * /**
	 * Draws the map in the current view from the selected camera
	 * with the specified layers
	 * @param OrthographicCamera camera
	 */
	public void draw(OrthographicCamera camera,int [] layers) {
		mapRender.setView(camera);
		mapRender.render(layers);
	
	}
	
	/**
	 * Parse the map for Collision objects used in the physic engine.
	 * @param map
	 * @param nameofcollisionLayer
	 * @param world
	 */
	public static void parseTileMap(SimpleTileMap map,String nameofcollisionLayer,World world,float WORLD_TO_BOX) {
		MapLayer collisionLayer;
		
		 Array<PolygonMapObject> polygonCollision;
		 Array<RectangleMapObject> rectangleCollision;
		 Array<PolylineMapObject> polylineCollision;
		
		
		//Get the layer with collision 
		collisionLayer = map.getMapLayer(nameofcollisionLayer);
		if (collisionLayer == null) {
			System.err.println("Layer is null. Exiting...");
			Gdx.app.exit();
		}
		
		
		//Get objects
		MapObjects objects = collisionLayer.getObjects();
		
		//Create collections
		polygonCollision = new Array<PolygonMapObject>();
		rectangleCollision = new Array<RectangleMapObject>();
		polylineCollision = new Array<PolylineMapObject>();
		//Figure out which are which
		for (MapObject o: objects) {
			//System.out.println(o.getName());
			
			if (o.getClass().equals(PolygonMapObject.class)) {
				System.out.println("Polygon");
				polygonCollision.add((PolygonMapObject) o);
			}
			/*
			if (o.getClass().equals(PolylineMapObject.class)) {
				polylineCollision.add((PolylineMapObject) o);
			}
			*/
			
			if (o.getClass().equals(RectangleMapObject.class)) {
				System.out.println("Rectangle");
				rectangleCollision.add((RectangleMapObject) o);
			}
			
			
			
			
			
			
		}
		//Generate the world
		createStaticWorld(world,polygonCollision,rectangleCollision,polylineCollision,WORLD_TO_BOX);
		
		
		
		

		
	}
	
	
	private static void createStaticWorld(World world,Array<PolygonMapObject>  polygonCollision, Array<RectangleMapObject> rectangleCollision, Array<PolylineMapObject> polylineCollision,float WORLD_TO_BOX ) {
		
		SimpleBodyFactory bf  = new SimpleBodyFactory();
		
		
		for (PolygonMapObject poly : polygonCollision) {
			Polygon polygon = poly.getPolygon();
			polygon.setScale(WORLD_TO_BOX, WORLD_TO_BOX);
			polygon.setPosition(polygon.getX()*WORLD_TO_BOX,polygon.getY()*WORLD_TO_BOX);
			
			PolygonShape polyShape = new PolygonShape();
			polyShape.set(polygon.getTransformedVertices());
			
			Vector2 position = new Vector2(0,0);
			
			
			bf.createBody(position, BodyType.StaticBody).createFixture(polyShape).build(world);
			
		}
		/*
		for (PolylineMapObject poly : polylineCollision) {
			Polyline polygon = poly.getPolyline();
			
			polygon.setScale(WORLD_TO_BOX,WORLD_TO_BOX);
			polygon.setPosition(WORLD_TO_BOX*polygon.getX(),WORLD_TO_BOX*polygon.getY());
			
			
			 EdgeShape lineshape = new ChainShape();
			lineshape.createChain(polygon.getTransformedVertices());
			Vector2 position = new Vector2(0,0);
			
			bf.createBody(position, BodyType.StaticBody).createFixture(lineshape).build(world);
		}*/
		
		for (RectangleMapObject rec :rectangleCollision) {
			
			Rectangle rectangle = rec.getRectangle();
			
			rectangle.setPosition(new Vector2(WORLD_TO_BOX*rectangle.getX(),WORLD_TO_BOX*rectangle.getY()));
		
			rectangle.setSize(WORLD_TO_BOX*rectangle.getWidth(), WORLD_TO_BOX*rectangle.getHeight());
			
			
			PolygonShape rectShape = new PolygonShape();
			rectShape.setAsBox(rectangle.getWidth()/2,rectangle.getHeight()/2);
			
			Vector2 position = new Vector2(rectangle.getX() + rectangle.getWidth()/2,rectangle.getY() + rectangle.getHeight()/2);
			
			bf.createBody(position, BodyType.StaticBody).createFixture(rectShape).build(world);

		}
		
		
		
		
	}

	
	
	/**
	 * Returns the current TileID from the map int the layer you specifi.
	 * 
	 * @param float x
	 * @param float y
	 * @param int index
	 * @return TileID
	 */
	public int getTileID (float x, float y,int index) {
		TiledMapTileLayer tilelayer = (TiledMapTileLayer)map.getLayers().get(index);
		
		return tilelayer.getCell((int)x, (int)y).getTile().getId();
	}
	
	/**
	 * Returns the mapobjects in the map.
	 * @param index
	 * @return
	 */
	public int getMapObjects(int index) {
		
		return map.getLayers().get(index).getObjects().getCount();
	}
	/**
	 * Returns the MapLayer
	 * @param layername
	 * @return
	 */
	public MapLayer getMapLayer(String layername) {
		return map.getLayers().get(layername);
	}



	public TiledMap getMap() {
		return map;
	}



	public void setMap(TiledMap map) {
		this.map = map;
	}



	public OrthogonalTiledMapRenderer getMapRender() {
		return mapRender;
	}



	public void setMapRender(OrthogonalTiledMapRenderer mapRender) {
		this.mapRender = mapRender;
	}
	


}
