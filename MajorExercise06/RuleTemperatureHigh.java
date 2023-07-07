package de.uni_oldenburg.inf.omp.rulebook.temperature;

import java.util.List;

import com.deliveredtechnologies.rulebook.annotation.Given;
import com.deliveredtechnologies.rulebook.annotation.Rule;
import com.deliveredtechnologies.rulebook.annotation.Then;
import com.deliveredtechnologies.rulebook.annotation.When;

@Rule
public class RuleTemperatureHigh {
	
	@Given
	private List<Temperature> temperatures;
	
	@Given
	private List<Radiator> radiators;
	
	@When
	public boolean when() {
		return temperatures.stream().anyMatch(t -> t.getValue() > 22) && !radiators.isEmpty();
	}
	
	@Then
	public void then() {
		radiators.stream().forEach(r -> r.decreaseLevel());
	}

}
