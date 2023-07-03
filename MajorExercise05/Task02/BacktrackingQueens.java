public class BacktrackingQueens {
	
	private Queens solution;

	public Queens search(int size) {
		solution = new Queens(size);
		if (searchBT(0)) {
			return solution;
		} else {
			return new Queens(0);
		}
	}
	
	private boolean searchBT(int row) {
		if (row < solution.getSize()) {
			for (int col = 0; col < solution.getSize(); col++) {
				if (solution.isSafe(row, col)) {
					solution.place(row, col);
					if (searchBT(row + 1)) {
						return true;
					} else {
						solution.remove(row, col);
					}
				}
			}
			return false;
		} else {
			return true;
		}
	}
	
}
