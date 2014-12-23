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
	private CommonMazeState startState;
	private CommonMazeState goalState;
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

	
	public CommonMazeState getStartState() {
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
	
	/*public ArrayList<Action> getActions(State state) 
	{
		ArrayList<Action> actions = new ArrayList<Action>();
		Integer[] state_co = state.getPlace();
		int x = -1;
		int y = -1;
		
		 * This while loop is the main program of this function, explanation: 
		 * 1)
		 * Checks to see if we're in the boundries of the maze or encountered an
		 * obstacle - if that's the case don't create a new possible action and
		 * move to the next possible action 
		 * 2) Will add to x+1 every iteration -
		 * that way we will cover a row, once we reach the end of the row,
		 * change x to -1 and change y(y+1) and start scan a new row. 
		 * 3) 
		 * x==0
		 * and y==0 means that we're in the middle - that's a place that we
		 * wouldn't like to scan since it's the current state, thus move x
		 * forward. 3) When created a new action, add it to the action ArrayList
		 * and set the maze value at the current position to -1 (scanned...)
		 
		while ((x <= 1 || y <= 1) && y != 2) {
			if (getMazeMatrixCoordinateValue((state_co[0] + x), (state_co[1] + y)) != -1) {
				actions.add(new MazeStateAction(new int[] { x, y }));
				try{
				mazeMatrix[state_co[0]][state_co[1]] = -1;
				}
				catch(Exception e){}
			}
			x++;
			if (x == 2) {
				y++;
				x = -1;
			} else if (x == 0 && y == 0)
				x++;
		}
		return actions;
	}*/
	
	public ArrayList<Action> getActions(State state) {
		ArrayList<Action> actionToRet = new ArrayList<Action>();
		Integer[] statePlace = state.getPlace();
		int xOfState = statePlace[0];
		int yOfState = statePlace[1];
		//int xToAdd = -1;
		//int yToAdd = -1;
		//while((xOfState<=1||yToAdd<=1)&&yToAdd!=2)  //y not allowed to be 2 beacause the defenition of action
		//{
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
			
			
			
			
			
			//if (getMazeMatrixCoordinateValue(xToAdd+xOfState,yToAdd+yOfState)!=-1)
			//{
				//actionToRet.add(new MazeStateAction(new int [] {xToAdd,yToAdd}));
				//mazeMatrix[xOfState][yOfState]=-1;
			//System.out.println(1);
			//}
			//xToAdd++;//go to new line
			//if (xToAdd==2)//that means that we scaned all the line
			//{
				//yToAdd++;
				//xToAdd = -1; //start to scan again
				//System.out.println(2);
			//}
			//if ((xToAdd==0)&&(yToAdd==0))//that means that we didnt moved
			//{
				//xToAdd++;//start new line
				//System.out.println(3);
			//}
			return actionToRet;
		//}
		//return null;
	}

	
	public double getEvaluationToTheGoal(State current) 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "MazeSearchDomain [mazeMatrix=" 
				+ ", startState=" + startState.getStateName() + ", goalState=" + goalState.getStateName()
				+ ", size=" + size + "]\n" + getStringMazeMatrix();
	}
	

}
