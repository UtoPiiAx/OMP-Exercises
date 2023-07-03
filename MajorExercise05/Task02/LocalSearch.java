import java.util.Collection;

public abstract class LocalSearch<T> {
	
	protected int iterationCount;
	
	public abstract T getInitialSolution();
	
	public abstract boolean isTerminated();
	
	public abstract Collection<T> getNeighborhood(T current);
	
	public abstract double getQuality(T solution);
	
	public T execute() {
		iterationCount = 0;
		T currentSolution = getInitialSolution();
		boolean change = true;
		while (change && !isTerminated()) {
			change = false;
			double qualityOfCurrentSolution = getQuality(currentSolution);
			Collection<T> neighborhood = getNeighborhood(currentSolution);
			for (T otherSolution : neighborhood) {
				double qualityOfOtherSolution = getQuality(otherSolution);
				if (qualityOfOtherSolution > qualityOfCurrentSolution) {
					currentSolution = otherSolution;
					qualityOfCurrentSolution = qualityOfOtherSolution;
					change = true;
					//break;
				}
			}
			iterationCount++;
		}
		return currentSolution;
	}

}