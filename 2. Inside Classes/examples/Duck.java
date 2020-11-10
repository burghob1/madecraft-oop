package examples;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Duck {

	/* Member Variables: data (encapsulated / private) */
	
	private String name;
	private int lifeExpectancy;
	private String favoriteFood;

	/* The Constructor: for creating instances */
	
	public Duck(String name, int lifeExpectancy, String favoriteFood) {
		super();
		this.name = name;
		this.lifeExpectancy = lifeExpectancy;
		this.favoriteFood = favoriteFood;
	}

	/* Methods: functionality */
	
	void waddle() {
		lifeExpectancy++;
		System.out.println(this.name + " is waddling");
	}

	void quack() {
		System.out.println(this.name + ": quack quack");
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(
					"madecraft-oop/sounds/quack.wav").toURI().toURL());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.loop(1);
			Thread.sleep(3400);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "My name is " + this.name + " and my favorite food is the mighty and lovely "
				+ this.favoriteFood + ". And to top it all of, my life expectancy is " + this.lifeExpectancy +
				" years.";
	}

}
