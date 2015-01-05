package model.domains.tiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import model.algorithems.Action;
import model.algorithems.SearchDomain;
import model.algorithems.State;
import model.domains.maze.MazeStateAction;

public class TilesSearchDomain implements SearchDomain {
	
	Integer[] matrix;
	private int size;
	private CommonTilesState startState;
	private CommonTilesState goalState;
	
	public TilesSearchDomain(int size) {
		setSize(size);
		this.setStartState(new CommonTilesState("StartState", 0, 0));
		this.startState.printMatrix();
		System.out.println("");
		this.goalState = new CommonTilesState("GoalState", 0, 0);
		this.goalState.setMatrix(buildGoalMatrix());
		//this.goalState.printMatrix();
		//(ArrayList<TilesStateAction>) ArrayList<Action> actionList = getActions(startState);
		getActions(startState);
		//startState.toString();
		
		
	}


	public int getSize() {
		return size;
	}


	public Integer[] buildMatrix()
	{
		
		boolean canBeSolved = false;
		Integer[] matrix = buildGoalMatrix();
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

	public Integer[] buildGoalMatrix(){
		Integer[] matrix= new Integer[size*size];
		/* create the matrix and fill it with the numbers. */
		for (int i = 1; i < matrix.length; i++) {
			matrix[i-1] = i;
		}
		matrix[this.size*this.size-1] = 0;
		return matrix;
	}
	public boolean checkIfSolveable(Integer[] matrix){
		boolean canBeSolved = false;
		
		int sum = evaluateMatrix(matrix);
		
		if (sum % 2 == 0){
			System.out.println("Matrix can be solved. sum is "+sum+"\n");
			canBeSolved = true;
		}
		return canBeSolved;
	}
	
	public int evaluateMatrix(Integer[] matrix)
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
	


	public State getGoalState() {
		return this.goalState;
	}



	public void setSize(int size) {
		this.size = size;
	}

	public Integer[] getBlankLocation(CommonTilesState state){
		
		int location = Arrays.asList(state.getMatrix()).indexOf(0);
		Integer[] result = {location % this.size,location / this.size};
		return result;
	}
	

	
	public ArrayList<Action> getActions(State state) {
		
		ArrayList<Action> actionToRet = new ArrayList<Action>();
		Integer x = getBlankLocation((CommonTilesState)state)[0];
		Integer y = getBlankLocation((CommonTilesState)state)[1];
//		System.out.println("Checking for space in location ("+x+","+y+")");
		if (x-1 >=0)
		{
			actionToRet.add(new TilesStateAction(new int [] {-1,0}));
		}
		if (y-1 >= 0)
		{
			actionToRet.add(new TilesStateAction(new int [] {0,-1}));
		}
		
		if (x+1 < this.size)
		{
			actionToRet.add(new TilesStateAction(new int [] {1,0}));
		}
		if (y+1 < this.size)
		{
			actionToRet.add(new TilesStateAction(new int [] {0,1}));
		}
		return actionToRet;
	}

	public String getProblemDescription() {
		// TODO Auto-generated method stub
		return null;
	}


	public State getStartState() {
		return startState;
	}


	public void setStartState(State state) {
		this.startState = (CommonTilesState)state;
		this.startState.setMatrix(buildMatrix());
		
		
	}


	public void setGoalState(State state) {
		this.goalState = (CommonTilesState)state;		
	}



}
