import java.util.Random;

public class Composer extends Musician {

	private static final int MAX_NOTES = 5;
	private final Random random = new Random();

	public Composer(SheetMusic music) {
		super(music);
	}
	
	public void compose() {
		music.startComposing();
		int max = 1 + random.nextInt(MAX_NOTES);
		for (int i = 0; i < max; i++) {
			music.add(music.new Note(getRandomName(), getRandomDuration()));
		}
		music.stopComposing();
	}

	private SheetMusic.NoteName getRandomName() {
		return SheetMusic.NoteName.values()[random.nextInt(SheetMusic.NoteName.values().length)];
	}

	private SheetMusic.NoteDuration getRandomDuration() {
		return SheetMusic.NoteDuration.values()[random.nextInt(SheetMusic.NoteDuration.values().length)];
	}
	
}
