import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class automaton {
	
	private ArrayList<state> states = new ArrayList<state>();
	private state currentState;
	private String word = "";
	
	public automaton(File file) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
	        String line = br.readLine();
	        while (line != null) {
	        	// On récupère la ligne qu'on sépare grâce au "->"
	        	String[] separation = line.split("->");
	        	// on récupère le state 
	            int id = Integer.parseInt(separation[0]);
	            state tmpState = new state(id);
	            // On récupère les transitions séparées par paranthèses
	            String[] transitionsString = separation[1].split("\\),\\(");
	            // Pour chaque (input, label, output) on récupère les variables pour créer une transition
	            for(String transitionString : transitionsString) {
	            	String[] transition = transitionString.replaceAll("[\\(\\)]*", "").split(",");
	            	String label = transition[1];
	            	state inputState = new state(Integer.parseInt(transition[0]));
	            	state outputState = new state(Integer.parseInt(transition[2]));
	            	transition newTransition = new transition(label, inputState, outputState);
	            	tmpState.addTransition(newTransition);
	            }
	            // On ajoute le state (id + transitions) à l'automaton
	            this.states.add(tmpState);
	            // On considère que le premier currentState est l'id = 1
            	if(tmpState.getId() == 1) {
            		this.currentState = tmpState;
            	}
	            line = br.readLine();
	        }
	        br.close();

		} catch (Exception e) {
            e.printStackTrace();
		}
	}

	public int getCurrentState() {
		return currentState.getId();
	}

	public String performTransitions(String label) {
		ArrayList<transition> transitions = this.currentState.getTransitions();
		String performedLabel = "";
		
		for(transition temp: transitions) {
			if((temp.getLabel().equals(label)) && (temp.getInput().getId() == this.currentState.getId())) {
				// TODO : il faudrait faire this.currentState = temp.getOutput(); mais pour l'instant ce n'est pas implémenté comme cela
				int performedStateId = temp.getOutput().getId();
				for(state state : this.states) {
					if(state.getId() == performedStateId) {
						this.currentState = state;
					}
				}
				// On garde en mémoire les actions
				this.word += temp.getLabel();
				// On retourne l'action réalisée
				performedLabel = temp.getLabel();
			}
		}
		return performedLabel;
	}
	
	public ArrayList<transition> getPossibleTransitions() {
		ArrayList<transition> res = new ArrayList<transition>();
		ArrayList<transition> transitions = this.currentState.getTransitions();
		
		for(transition temp: transitions) {
			if(temp.getInput().getId() == this.currentState.getId()){
				res.add(temp);
			}
		}
		return res;
	}

	public void restart() {
		for(state state : this.states) {
        	if(state.getId() == 1) {
        		this.currentState = state;
        	}
		}
	}
	

}
