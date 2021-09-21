import java.util.ArrayList;

public class transition {
	
	private String label;
	private state input;
	private state output;
	
	public transition(String label, state input, state output) {
		this.label = label;
		this.input = input;
		this.output = output;
	}
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public state getInput() {
		return input;
	}
	public void setInput(state input) {
		this.input = input;
	}
	public state getOutput() {
		return output;
	}
	public void setOutput(state output) {
		this.output = output;
	}
	
	/**
	 * 
	 * @param states
	 * Ajoute les states Input et Output 
	 */
	public void updateInputOutput(ArrayList<state> states) {
		
	}
	
	
	@Override
	public String toString() {
		return "[label=" + this.label + ", input=" + this.input.getId() + ", output=" + this.output.getId() + "]\n";
	}

}
