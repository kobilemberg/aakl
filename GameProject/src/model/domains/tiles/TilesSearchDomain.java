package model.domains.tiles;

import java.util.ArrayList;
import java.util.Random;

import model.algorithems.Action;
import model.algorithems.SearchDomain;
import model.algorithems.State;

public class TilesSearchDomain implements SearchDomain {
	
	int [] matrix;
	private int size;
	private State startState;
	private State goalState;
	
	
	public TilesSearchDomain(int size) {
		this.size = size; 
		this.matrix = new int[size*size];
		this.matrix = buildMatrix();
	}
	
	public int[] buildMatrix()
	{
		
		boolean canBeSolved = false;
		int[] temp = new int[this.size*this.size];
		
		while (canBeSolved == false)
		{
			
			/* create the matrix and fill it with the numbers. */
			for (int i = 0; i < temp.length; i++) {
				temp[i] = i;
			}
			
			/* mess up the matrix except the first one (00) */
			Random rand = new Random();
			for (int i = 1; i < temp.length; i++) {
				int switchWith = rand.nextInt(temp.length-1)+1;
				int tmp = temp[i];
				temp[i] = temp[switchWith];
				temp[switchWith] = tmp;
			}
			/* make sure 00 goes left bottom. */
			int tmp = size*size-1;
			temp[0] = temp[tmp];
			temp[tmp] = 0;
			
			/* check if the matrix is solavble */
			canBeSolved = checkIfSolveable(temp);
		}	
		return temp;
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
	
	public boolean checkIfSolveable(int[] matrix){
		boolean canBeSolved = false;
		
		int sum = evaluateMatrix(matrix);
		
		if (sum % 2 == 0){
			System.out.println("Matrix can be solved. sum is "+sum+"\n");
			printMatrix(matrix);
			canBeSolved = true;
		}
		return canBeSolved;
	}
	
	public void printMatrix(int[] matrix){
		for (int i = 0; i < matrix.length; i++) 
		{
			if (matrix[i] != 0)
			{
				System.out.print(String.format("%02d",matrix[i])+" ");
			}
			if ((i+1) % size == 0)
			{
				System.out.println("");				
			}
		}
		
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
