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
		
		int canBeSolved = 0;
		int[] temp = new int[this.size*this.size];
		
		while (canBeSolved == 0)
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
			int sum = 0;
			
			for (int i = 0; i < temp.length; i++) {
				int count = 0;
				for (int j = i; j < temp.length; j++) {
					if ((temp[j] < temp[i]) && (temp[j] != 0))
						count++;
				}
				sum += count;
				//System.out.println(temp[i]+" "+count+" numbers");
			}
			
			if (sum % 2 == 0){
				System.out.println("Matrix made. Can be solved, sum is "+sum+"\n");
				canBeSolved = 1;
				
				for (int i = 0; i < temp.length; i++) {
					if (temp[i] != 0)
					{
						System.out.print(String.format("%02d",temp[i])+" ");
					}
					if ((i+1) % size == 0){
						System.out.println("");				
					}
				}
			}
			else
			{
				System.out.println("Matrix made. Can not be solved, sum is "+sum+". Retrying.");
			}	
		}	
		return temp;
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
