package se.dixum.simple.audio;

import com.badlogic.gdx.audio.Music;

public class SimpleMusic {
	
	
	private Music music;
	private boolean looping = false;
	private float volume = 1.0f;
	
	/**
	 * Supply a filename to a sound and it will be created.
	 * Supported formats:	
	 * MP3, OGG and WAV files.
	 * @param filename the path to the sound asset
	 */
	public SimpleMusic(Music music) {
		this.music = music;
	}
	/**
	 * Supply a filename to a sound and it will be created.
	 * Supported formats:	
	 * MP3, OGG and WAV files.
	 * Also set the looping parameter.
	 * @param filename  the path to the sound asset
	 * @param looping if the sound should be looped
	 */
	public SimpleMusic(Music music,boolean looping) {
		this.music = music;
		setLooping(looping);
		
	}
	
	
	/**
	 * Supply a filename to a sound and it will be created.
	 * Supported formats:	
	 * MP3, OGG and WAV files.
	 * Also sets the looping and volume parameter.
	 * @param filename the path to the sound asset
	 * @param looping if the sound should be looped
	 * @param volume the volume of the sound
	 */
	public SimpleMusic(Music music,boolean looping, float volume) {
		this.music = music;
		setLooping(looping);
		setVolume(volume);
	}
	
	
	/**
	 * Plays the music
	 */
	public void play() {
		music.play();
	}
	/**
	 * Pauses the music
	 */
	public void pause() {
		music.pause();
	}
	/**
	 * Stops the music
	 */
	public void stop() {
		music.stop();
	}
	
	
	public void dispose() {
		music.dispose();
	}
	
	
	/**
	 * Checks whatever the music clips should loop.
	 * @return looping
	 */
	public boolean isLooping() {
		return looping;
	}

	public void setLooping(boolean looping) {
		this.looping = looping;
		music.setLooping(looping);
		
		
		
	}

	public float getVolume() {
		return volume;
	}
	/**
	 * Sets the volume of the music clip
	 * @param volume
	 */
	public void setVolume(float volume) {
		this.volume = volume;
		music.setVolume(volume);
	}
	
	
	

}

	
