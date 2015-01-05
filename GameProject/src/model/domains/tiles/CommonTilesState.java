package model.domains.tiles;

import java.util.Random;

import model.algorithems.CommonState;
import model.algorithems.State;

public class CommonTilesState extends CommonState {
	
	private Integer[] matrix;
	private Integer size=4;
	public CommonTilesState(String stateName, double f, double g) {
		super(stateName, f, g);
		this.matrix = new Integer[size*size];
	}
	

	public void setMatrix(Integer[] matrix) {
		this.matrix = matrix;
	}

	public Integer[] getMatrix() {
		return matrix;
	}


	
	
	
	public void printMatrix(){
		
		for (int i = 0; i < this.matrix.length; i++) 
		{
			if (this.matrix[i] != 0)
			{
				System.out.print(String.format("%02d",this.matrix[i])+" ");
			}
			if ((i+1) % size == 0)
			{
				System.out.println("");				
			}
		}
	/*
		for (int i = 0; i < this.matrix.length; i++) {
			System.out.println(i+":"+String.format("%02d",this.matrix[i])+"");
		}
		*/
	}

	public CommonTilesState(String stateName, double f, double g,
			State cameFromState) {
		super(stateName, f, g, cameFromState);
		// TODO Auto-generated constructor stub
	}

	public int compare(State arg0, State arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

}
