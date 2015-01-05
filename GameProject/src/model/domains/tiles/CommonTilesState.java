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
	
	public int evaluateMatrix()
	{
		Integer sum = 0;
//		System.out.println(this.matrix.length);
		
		for (Integer i = 0; i < this.matrix.length; i++) 
		{
			Integer count = 0;
			for (Integer j = i; j < this.matrix.length; j++) {
				System.out.println("j:"+j+" "+this.matrix[j]);
				if ((this.matrix[j] < this.matrix[i]) && (this.matrix[j] != 0))
					count++;
			}
			sum += count;
			//System.out.println(temp[i]+" "+count+" numbers");
			
		}
		return sum;
	}
	
	public void setMatrix(Integer[] matrix) {
		this.matrix = matrix;
	}

	public Integer[] getMatrix() {
		return matrix;
	}


	public String toString(){
		String result = "";
		System.out.println("State:"+this.getStateName()+" g:"+this.g+" f:"+this.f);
		printMatrix();
		return result;	
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
