public class Musician {
	
	protected SheetMusic music;
	
	public Musician(SheetMusic music) {
		super();
		this.music = music;
	}
	
	public void play() {
		for (SheetMusic.Note note : music.getNotes()) {
			System.out.print(note);
		}
		/*
		 * Alternativloesung von Florian Dyck:
		 * music.readNotes(notes -> notes.forEach(System.out::print));
		 */
	}

}
