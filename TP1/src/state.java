import java.util.ArrayList;

public class state {
	
	private int id;
	private ArrayList<transition> transitions;
	
	public state(int id) {
		this.id = id;
		this.transitions = new ArrayList<transition>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<transition> getTransitions() {
		return transitions;
	}

	public void setTransitions(ArrayList<transition> transitions) {
		this.transitions = transitions;
	}
	
	public void addTransition(transition transition) {
		this.transitions.add(transition);
	}
	
	/**
	 * 
	 * @param states
	 * Pour chaque transition, met à jour les Input et Output 
	 */
	public void updateInputOutput(ArrayList<state> states) {
		
		for(state state : states) {
			ArrayList<transition> transitions = state.getTransitions();
		}
	}

	@Override
	public boolean equals(Object obj) {
		state temp = (state) obj;
		return this.id == temp.getId();
	}

}
