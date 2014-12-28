package model.domains.maze;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import model.algorithems.Action;
import model.algorithems.SearchDomain;
import model.algorithems.State;

import java.util.Random;

public class MazeSearchDomain implements SearchDomain 
{
	
	int [][] mazeMatrix;
	private State startState;
	private State goalState;
	private int size;
	
	public MazeSearchDomain(int size) 
	{
		this.size = size;
		mazeMatrix = new int[size][size];
		putTheCheesInTheMaze();
		putTheMouseInTheMaze();
		buildMazeMatrix();
	}
	
	public MazeSearchDomain() 
	{
		new MazeSearchDomain(20);
	}
	
	public void buildMazeMatrix()
	{
		int [] objectsToFill = {0,-1};
		
		Random random = new Random();
		for (int i=1;i<size;i++)
		{
			for(int j=1;j<size;j++)
			{
				if (mazeMatrix[i][j]==0)
				{
					int rangeForRandomNumber =2;
					mazeMatrix[i][j] = objectsToFill[random.nextInt(rangeForRandomNumber)];
				}
			}
		}
	}
	public Integer[] giveMePlace()
	{
		Random random = new Random();
		Integer chosenX;
		Integer chosenY;
		do
		{
			chosenX = new Integer(random.nextInt(size));
			chosenY = new Integer(random.nextInt(size));
		}
		
		while(this.mazeMatrix[chosenX][chosenY] == 1 || this.mazeMatrix[chosenX][chosenY] == 2 );
		Integer[] arrToReturn = {chosenX,chosenY};//,("("+((char)chosenX)+","+(char)(chosenY)+")")};
		return arrToReturn;	
	}
	public void putTheMouseInTheMaze()
	{
		Integer [] objArr = this.giveMePlace();
		this.setStartState(    new CommonMazeState(    "("+Integer.toString(objArr[0])+","+Integer.toString(objArr[1])+")"   ,0,0)   );
		this.mazeMatrix[objArr[0]][objArr[1]]  = 1;
	}
	private void setStartState(CommonMazeState commonMazeState) {
		this.startState = commonMazeState;
		
	}
	public void setGoalState(CommonMazeState goalState) {
		this.goalState = goalState;
	}

	public void putTheCheesInTheMaze()
	{
		Integer [] objArr = this.giveMePlace();
		this.setGoalState(    new CommonMazeState(    "("+Integer.toString(objArr[0])+","+Integer.toString(objArr[1])+")"   ,0,0)   );
		this.mazeMatrix[objArr[0]][objArr[1]]  = 2;
	}

	
	public State getStartState() {
		return this.startState;
	}

	
	public State getGoalState() {
		return this.goalState;
	}
	
	
	public int[][] getMazeMatrix()
	{
		return this.mazeMatrix;
	}
	public int getMazeMatrixCoordinateValue(int x,int y)
	{
		try
		{
			return this.mazeMatrix[x][y];
		}
		catch (Exception e)
		{
			return -1;
		}
	}
	public void setMazeMatrixCoordinateValue(int x,int y, int val)
	{
		if (x<size && y<size)
		{
			this.mazeMatrix[x][y] = val;
		}
	}
	
	
	
	
	public void printMaze()
	{
		System.out.println("Mouse at "+getStartState().getStateName());
		System.out.println("Chees at "+getGoalState().getStateName());
		for (int i = 0; i < size; i++) 
		{
			for (int j = 0; j < size; j++) 
			{
				System.out.print(mazeMatrix[i][j] + "\t");
			}
			System.out.println();
		}
		
	}
	public String getStringMazeMatrix()
	{
		String stringToRet = "";
		stringToRet += "Mouse at "+getStartState().getStateName() +"\n";
		stringToRet += "Cheese at "+getGoalState().getStateName() +"\n";
		for (int i = 0; i < size; i++) 
		{
			for (int j = 0; j < size; j++) 
			{
				stringToRet+=(mazeMatrix[i][j] + "\t");
			}
			stringToRet+="\n";
		}
		return stringToRet;
			
	}
	
	
	
	public ArrayList<Action> getActions(State state) {
		ArrayList<Action> actionToRet = new ArrayList<Action>();
		Integer[] statePlace = state.getPlace();
		int xOfState = statePlace[0];
		int yOfState = statePlace[1];
		
			if (getMazeMatrixCoordinateValue(xOfState-1, yOfState)!=-1)
				actionToRet.add(new MazeStateAction(new int [] {-1,0}));
			//if (getMazeMatrixCoordinateValue(xOfState-1, yOfState-1)!=-1)
				//actionToRet.add(new MazeStateAction(new int [] {-1,-1}));
			if (getMazeMatrixCoordinateValue(xOfState, yOfState-1)!=-1)
				actionToRet.add(new MazeStateAction(new int [] {0,-1}));
			if (getMazeMatrixCoordinateValue(xOfState+1, yOfState)!=-1)
				actionToRet.add(new MazeStateAction(new int [] {1,0}));
			if (getMazeMatrixCoordinateValue(xOfState, yOfState+1)!=-1)
				actionToRet.add(new MazeStateAction(new int [] {0,1}));
			//if (getMazeMatrixCoordinateValue(xOfState+1, yOfState+1)!=-1)
				//actionToRet.add(new MazeStateAction(new int [] {1,1}));
			
			
			return actionToRet;
		
	}

	
	

	@Override
	public String toString() {
		return "MazeSearchDomain [mazeMatrix=" 
				+ ", startState=" + startState.getStateName() + ", goalState=" + goalState.getStateName()
				+ ", size=" + size + "]\n" + getStringMazeMatrix();
	}

	public void setStartState(State state) 
	{
		this.startState = state;
		
	}

	public void setGoalState(State state) {
		this.goalState = state;
		
	}

	public void setSize(int size) {
		this.size = size;
		
	}

	public String getProblemDescription() {
		return ("start word: " + getStartState() + ", final word: " + getGoalState()); 
	}
	

}
