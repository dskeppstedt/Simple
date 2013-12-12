package se.dixum.simple.audio;
import com.badlogic.gdx.audio.Sound;

public class SimpleSound {
	
	
	private Sound sound;
	private float volume = 1.0f;
	private long id  =0 ;
	private boolean looping  = false;
	private float panSide = 0;
	/**
	 * Supply a filename to a sound and it will be created.
	 * Supported formats:	
	 * MP3, OGG and WAV files.
	 * @param filename
	 */
	public SimpleSound(Sound sound) {
		this.sound = sound;
		
	}

	
	
	/**
	 * Supply a filename to a sound and it will be created.
	 * Supported formats:	
	 * MP3, OGG and WAV files.
	 * Also sets the volume parameter.
	 * @param filename
	 * @param looping
	 * @param volume
	 */
	public SimpleSound(Sound sound, float volume) {
		this.sound = sound;
		setVolume(volume);
	}
	
	/**
	 * Supply a filename to a sound and it will be created.
	 * Supported formats:	
	 * MP3, OGG and WAV files.
	 * Also sets the volume parameter and looping parameter
	 * @param filename
	 * @param looping
	 * @param volume
	 */
	public SimpleSound(Sound sound, float volume, boolean looping) {
		this.sound = sound;
		setLooping(looping);
		setVolume(volume);
	}
	
	
	/**
	 * Plays the music
	 */
	public void play() {
		
		setId(sound.play(getVolume()));
	}
	/**
	 * Pauses the music
	 */
	public void pause() {
		sound.pause();
	}
	/**
	 * Stops the music
	 */
	public void stop() {
		sound.stop();
	}
	
	
	public void dispose() {
		sound.dispose();
	}
	

	
	public float getVolume() {
		return volume;
	}
	/**
	 * Sets the volume of the the current sound effect
	 * Between 0-1.
	 * @param float volume
	 */
	public void setVolume(float volume) {
		this.volume = volume;
		
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public boolean isLooping() {
		return looping;
	}

	/**
	 * Sets if the sound effect should loop.
	 * @param looping
	 */

	public void setLooping(boolean looping) {
		this.looping = looping;
		sound.loop();
	}



	public float getPanSide() {
		return panSide;
	}


	/**
	 * Observe can only be called after play!
	 * Sets the side of which the sound should be played
	 * -1 = left
	 * 0 = center
	 * 1 = right
	 * 
	 * @param panSide
	 */
	public void setPanSide(float panSide) {
		this.panSide = panSide;
		sound.setPan(id, panSide, getVolume());
	}




	
	
	

}

	
