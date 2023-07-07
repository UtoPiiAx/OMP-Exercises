
public class Thermometer {
	
	private Environment environment;
	
	public Thermometer(Environment environment) {
		super();
		this.environment = environment;
	}
	
	public Temperature getTemperature() {
		return environment.getTemperature();
	}

}
