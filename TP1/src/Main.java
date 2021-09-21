import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		File file = new File("./coffeMachine.txt");
		automaton coffeeMachine = new automaton(file);
		
		System.out.println("Bienvenue dans la Machine à café!");
		
		ArrayList<String> actionsNoCoffee = new ArrayList<String>();
		actionsNoCoffee.add("coin");
		actionsNoCoffee.add("back");
		actionsNoCoffee.add("money");
		
		for(String action: actionsNoCoffee) {
			ArrayList<transition> res = coffeeMachine.getPossibleTransitions();
			System.out.print("\nNous sommes à l'état : " + coffeeMachine.getCurrentState() + ". ");
			System.out.println("Les différentes transitions possibles sont :");
			for (transition temp: res) {
				System.out.print(temp);
			}
			String perfomedAction = coffeeMachine.performTransitions(action);
			if(!action.equals(perfomedAction)) {
				System.out.println("Action impossible.");
				break;
			}
			System.out.println("Action réalisée : " + perfomedAction);
		}
		
		System.out.println("Fin de la machine à café.\n");
		
		coffeeMachine.restart();
		
		ArrayList<String> actionsCoffee = new ArrayList<String>();
		actionsCoffee.add("coin");
		actionsCoffee.add("coin");
		actionsCoffee.add("push");
		actionsCoffee.add("coffee");
		
		for(String action: actionsCoffee) {
			ArrayList<transition> res = coffeeMachine.getPossibleTransitions();
			System.out.print("\nNous sommes à l'état : " + coffeeMachine.getCurrentState() + ". ");
			System.out.println("Les différentes transitions possibles sont :");
			for (transition temp: res) {
				System.out.print(temp);
			}
			String perfomedAction = coffeeMachine.performTransitions(action);
			if(!action.equals(perfomedAction)) {
				System.out.println("Action impossible.");
				break;
			}
			System.out.println("Action réalisée : " + perfomedAction);
		}
		System.out.println("Fin de la machine à café.");	
	}

}
