package model.domains.tiles;

import java.util.ArrayList;
import java.util.Random;

import model.algorithems.Action;
import model.algorithems.CommonState;
import model.algorithems.SearchDomain;
import model.algorithems.State;

public class TilesSearchDomain implements SearchDomain {
	
	int [] matrix;
	private int size=4;
	private CommonTilesState startState;
	private CommonTilesState goalState;
	public TilesSearchDomain(int size) {
		this.startState = new CommonTilesState("StartState", 0, 0);
		this.startState.setMatrix(buildMatrix());
		this.startState.printMatrix();
		System.out.println("");
		this.goalState = new CommonTilesState("GoalState", 0, 0);
		this.goalState.setMatrix(buildGoalMatrix());
		this.goalState.printMatrix();
	}


	public int[] buildMatrix()
	{
		
		boolean canBeSolved = false;
		int[] matrix = buildGoalMatrix();
		while (canBeSolved == false)
		{
			/* mess up the matrix except the last one (00) */
			Random rand = new Random();
			for (int i = 0; i < matrix.length-1; i++) {
				int switchWith = rand.nextInt(matrix.length-1);
				int tmp = matrix[i];
				matrix[i] = matrix[switchWith];
				matrix[switchWith] = tmp;
			}

			/* check if the matrix is solvable */
			canBeSolved = checkIfSolveable(matrix);
		}	
		
		return matrix;
	}

	public int[] buildGoalMatrix(){
		int[] matrix= new int[size*size];
		/* create the matrix and fill it with the numbers. */
		for (int i = 1; i < matrix.length; i++) {
			matrix[i-1] = i;
		}
		matrix[this.size*this.size-1] = 0;
		return matrix;
	}
	public boolean checkIfSolveable(int[] matrix){
		boolean canBeSolved = false;
		
		int sum = evaluateMatrix(matrix);
		
		if (sum % 2 == 0){
			System.out.println("Matrix can be solved. sum is "+sum+"\n");
			canBeSolved = true;
		}
		return canBeSolved;
	}
	
	public int evaluateMatrix(int[] matrix)
	{
		int sum = 0;
		
		for (int i = 0; i < matrix.length; i++) 
		{
			int count = 0;
			for (int j = i; j < matrix.length; j++) {
				if ((matrix[j] < matrix[i]) && (matrix[j] != 0))
					count++;
			}
			sum += count;
			//System.out.println(temp[i]+" "+count+" numbers");
			
		}
		return sum;
		
	}
	
	
	public State getStartState() {
		return this.startState;
	}

	public State getGoalState() {
		return this.goalState;
	}

	public void setStartState(State state) {
		this.startState = state;
	}

	public void setGoalState(State state) {
		this.goalState = state;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public ArrayList<Action> getActions(State state) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getProblemDescription() {
		// TODO Auto-generated method stub
		return null;
	}

}
