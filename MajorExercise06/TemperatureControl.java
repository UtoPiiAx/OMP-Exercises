import com.deliveredtechnologies.rulebook.FactMap;
import com.deliveredtechnologies.rulebook.model.runner.RuleBookRunner;

public class TemperatureControl {

	public static void main(String[] args) {
		FactMap<Object> facts = new FactMap<>();
		RuleBookRunner ruleBook = new RuleBookRunner("de.uni_oldenburg.inf.omp.rulebook.temperature");
		
		Radiator radiator = new Radiator();
		Environment environment = new Environment(radiator);
		Thermometer thermometer = new Thermometer(environment);
		facts.setValue("radiator", radiator);
		for (int i = 0; i < 20; i++) {
			facts.setValue("temp", thermometer.getTemperature());
			ruleBook.run(facts);
		}
	}
	
}
