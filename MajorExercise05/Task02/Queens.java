import java.util.Arrays;
import java.util.Random;

public class Queens {
	
	private boolean[][] positions;
	private int size;
	
	/**
	 * Create an empty board of size x size
	 */
	public Queens(int size) {
		this.size = size;
		positions = new boolean[size][size];
	}
	
	/**
	 * Create a copy of the given board
	 */
	public Queens(Queens other) {
		this(other.size);
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				positions[row][col] = other.positions[row][col];
			}
		}
	}
	
	/**
	 * Create new board of size x size with a random placement of queens
	 */
	public Queens(int size, Random random) {
		this(size);
		for (int row = 0; row < size; row++) {
			positions[row][random.nextInt(size)] = true;
		}
	}
	
	public boolean isSet(int row, int col) {
		return positions[row][col];
	}
	
	public void place(int row, int col) {
		positions[row][col] = true;
	}
	
	public void remove(int row, int col) {
		positions[row][col] = false;
	}
	
	public int getSize() {
		return size;
	}
	
	public double getQuality() {
		int result = 0;
		for (int row1 = 0; row1 < size; row1++) {
			for (int row2 = row1 + 1; row2 < size; row2++) {
				for (int col1 = 0; col1 < size; col1++) {
					for (int col2 = 0; col2 < size; col2++) {
						if (isSet(row1, col1) && isSet(row2, col2) && !threaten(row1, col1, row2, col2)) {
							result++;
						}
					}
				}
			}
		}
		return result;
	}

	public boolean isSafe(int row, int col) {
		for (int line2 = 0; line2 < size; line2++) {
			for (int row2 = 0; row2 < size; row2++) {
				if (isSet(line2, row2)) {
					if (row != line2 || col != row2) {
						if (threaten(row, col, line2, row2)) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	private boolean threaten(int row1, int col1, int row2, int col2) {
		return row1 == row2 || col1 == col2 || (Math.abs(row1 - row2) == Math.abs(col1 - col2));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(positions);
		result = prime * result + size;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Queens other = (Queens) obj;
		if (!Arrays.deepEquals(positions, other.positions))
			return false;
		if (size != other.size)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		for (int row = 0; row < getSize(); row++) {
			for (int col = 0; col < getSize(); col++) {
				if (isSet(row, col)) {
					b.append('X');
				} else {
					b.append('-');
				}
			}
			b.append('\n');
		}
		return b.toString();
	}
	
	public static void main(String[] args) {
		Queens solution;
		
		System.out.println("Backtracking");
		BacktrackingQueens btr = new BacktrackingQueens();
		solution = btr.search(8);
		System.out.println(solution.getQuality());
		System.out.println(solution);
		
		System.out.println("Local Search");
		LocalSearchQueens lsc = new LocalSearchQueens(8);
		solution = lsc.execute();
		System.out.println(solution.getQuality());
		System.out.println(solution);
	}

}
