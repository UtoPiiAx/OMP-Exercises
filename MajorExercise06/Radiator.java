
public class Radiator {
	
	private int level = 0;
	
	public void increaseLevel() {
		if (level < 5) {
			level++;
			System.out.println("Set radiator to level " + level);
		}
	}
	
	public void decreaseLevel() {
		if (level > 0) {
			level--;
			System.out.println("Set radiator to level " + level);
		}
	}
	
	public int getLevel() {
		return level;
	}

}
