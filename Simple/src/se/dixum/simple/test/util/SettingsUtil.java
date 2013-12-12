package se.dixum.simple.test.util;


public class SettingsUtil {
	public static final boolean DEBUGPHYSICS = false;
	public static short GWIDTH = 1260;
	public static short GHEIGHT = 700;

	
	
	/*Consider how many pixels you want to equal 1 meter in the game
	*For example if 70px = 1 meter 
	*then the constanst would be
	*	1/70f
	*	70
	*if 100px = 1 meter it would be
	* 1/100 = 0.01
	* 100
	*
	**/

	public static float WORLD_TO_BOX = 1/70f;
	public static float BOX_TO_WORLD = 70;
	
	public static float convertToBox(float x) {
		return x*WORLD_TO_BOX;
	}
	public static float convertToWorld(float x) {
		return x*BOX_TO_WORLD;
	}
	
	
	
	
}
