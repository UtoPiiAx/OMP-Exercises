import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

public class LocalSearchQueens extends LocalSearch<Queens> {
	
	private int size;
	
	public LocalSearchQueens(int size) {
		super();
		this.size = size;
	}

	@Override
	public Queens getInitialSolution() {
		return new Queens(size, new Random());
	}

	@Override
	public boolean isTerminated() {
		return iterationCount > 1000;
	}

	@Override
	public Collection<Queens> getNeighborhood(Queens current) {
		Collection<Queens> result = new HashSet<>();
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				if (current.isSet(row, col)) {
					if (row > 0) {
						Queens other = new Queens(current);
						other.remove(row, col);
						other.place(row - 1, col);
						result.add(other);
					}
					if (row < size - 1) {
						Queens other = new Queens(current);
						other.remove(row, col);
						other.place(row + 1, col);
						result.add(other);
					}
					if (col > 0) {
						Queens other = new Queens(current);
						other.remove(row, col);
						other.place(row, col - 1);
						result.add(other);
					}
					if (col < size - 1) {
						Queens other = new Queens(current);
						other.remove(row, col);
						other.place(row, col + 1);
						result.add(other);
					}
				}
			}
		}
		return result;
	}

	@Override
	public double getQuality(Queens solution) {
		return solution.getQuality();
	}

}
