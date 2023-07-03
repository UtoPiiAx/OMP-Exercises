import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockMusic extends SheetMusic {
	
	private ReadWriteLock lock = new ReentrantReadWriteLock();

	@Override
	public List<Note> getNotes() {
		List<Note> result;
		lock.readLock().lock();
		try {
			result = Collections.unmodifiableList(new ArrayList<>(notes));
		} finally {
			lock.readLock().unlock();
		}
		return result;
	}

	@Override
	public void startComposing() {
		//lock.writeLock().lock();
	}

	@Override
	public void add(Note note) {
		lock.writeLock().lock();
		try {
			super.add(note);
		} finally {
			lock.writeLock().unlock();
		}
	}

	@Override
	public void stopComposing() {
		//lock.writeLock().unlock();
	}

}
