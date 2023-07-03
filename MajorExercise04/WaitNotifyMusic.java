import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WaitNotifyMusic extends SheetMusic {
	
	private boolean composing = false;
	
	@Override
	public List<Note> getNotes() {
		synchronized (notes) {
			while (composing) {
				try {
					notes.wait();
				} catch (InterruptedException e) {
					return new ArrayList<>();
				}
			}
			return Collections.unmodifiableList(new ArrayList<>(notes));
		}
	}

	@Override
	public void add(Note note) {
		synchronized (notes) {
			if (!composing) {
				return;
			}
			super.add(note);
		}
	}

	@Override
	public void startComposing() {
		synchronized (notes) {
			composing = true;
		}
	}

	@Override
	public void stopComposing() {
		synchronized (notes) {
			composing = false;
			notes.notifyAll();
		}
	}

}
