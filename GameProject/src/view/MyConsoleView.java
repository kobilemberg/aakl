package view;

import java.util.Observable;
import java.util.Scanner;

import model.Solution;
import model.SolutionManager;
import model.algorithems.Action;

public class MyConsoleView extends Observable implements View {

	private String action;
	
	
	public void start() {
		System.out.println("Welcome to my project");
		action = "";
		Scanner scanner = new Scanner(System.in);
		do
		{
			System.out.print("Enter command: ");
			action = scanner.nextLine();
			
			if (!(action.equals("exit")))
			{
				this.setChanged();
				this.notifyObservers();
			}
			
		} while (!(action.equals("exit")));
		
		SolutionManager.getInstance().saveSolutionsInFile();
	}

	
	public void displayCurrentState() {
		// TODO Auto-generated method stub

	}

	
	public void displaySolution(Solution solution) {
		for(Action a : solution.getActions())
			System.out.println(a);
	}

	
	public String getUserAction() {		
		return action;
	}
	

}