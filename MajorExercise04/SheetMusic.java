import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SheetMusic {
	
	protected List<Note> notes = new ArrayList<>();
	
	public List<Note> getNotes() {
		return Collections.unmodifiableList(notes);
	}
	
	public void startComposing() { }
	
	public void add(Note note) {
		notes.add(note);
	}
	
	public void stopComposing() { }
	
	public class Note {
		private NoteName name;
		private NoteDuration duration;
		public Note(NoteName name, NoteDuration duration) {
			super();
			this.name = name;
			this.duration = duration;
		}
		public NoteName getName() {
			return name;
		}
		public void setName(NoteName name) {
			this.name = name;
		}
		public NoteDuration getDuration() {
			return duration;
		}
		public void setDuration(NoteDuration duration) {
			this.duration = duration;
		}
		@Override
		public String toString() {
			return "[" + duration + " " + name + "] ";
		}
	}
	
	public enum NoteName {
		C, C_SHARP, D, D_SHARP, E, F, F_SHARP, G, G_SHARP, A, A_SHARP, B;
	}
	
	public enum NoteDuration {
		DOUBLE, WHOLE, HALF, QUARTER, EIGTH;
	}

	/*
	 * Alternativloesung von Florian Dyck:
	ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

	public void readNotes(Consumer<List<Note>> read) {
		try {
			lock.readLock().lock();
			read.accept(Collections.unmodifiableList(new ArrayList<>(notes)););
		} finally {
			lock.readLock().unlock();
		}
	}

	public void writeNotes(Consumer<List<Note>> write) {
		try {
			lock.writeLock().lock();
			write.accept(notes);
		} finally {
			lock.writeLock().unlock();
		}
	}

	public void addNotes(Consumer<Consumer<Note>> add) {
		try {
			lock.writeLock().lock();
			add.accept(notes::add);
		} finally {
			lock.writeLock().unlock();
		}
	}
	 */
}
