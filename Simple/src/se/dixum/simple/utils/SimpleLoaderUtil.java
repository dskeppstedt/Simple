package se.dixum.simple.utils;


import com.badlogic.gdx.assets.AssetManager;

public class SimpleLoaderUtil {
	//Declares the variables needed
	public static AssetManager MANAGER;
	private float loadingProgress = 0;
	
	public SimpleLoaderUtil() {
		//Creates the asset manager object
		MANAGER = new AssetManager();
		
	}
	
	/**
	 * This method is best used for check if the asset manager is loading the assets.
	 */
	public boolean update(){
		setLoadingProgress(MANAGER.getProgress());
		return MANAGER.update();
		
		
		
	}
	
	
	
	
	public void setLoadingProgress(float progress) {
		this.loadingProgress +=progress;
	}
	public float getLoadingProgress(){
		return loadingProgress;
	}
	
	
	public void disposeAll() {
		MANAGER.dispose();
	}
	
	
	
	

}
