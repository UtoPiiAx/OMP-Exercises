
public class Environment {
	
	private Radiator radiator;
	private Temperature temperature;
	
	public Environment(Radiator radiator) {
		super();
		this.radiator = radiator;
	}
	
	public Temperature getTemperature() {
		if (temperature == null) {
			temperature = new Temperature();
		} else {
			int temp = temperature.getValue();
			int change = 0;
			if (radiator.getLevel() > 0) {
				change = radiator.getLevel();
			} else {
				if (temp > 20) {
					change = -2;
				} else if (temp > 15) {
					change = -1;
				}
			}
			temperature = new Temperature(temp + change);
		}
		return temperature;
	}

}
