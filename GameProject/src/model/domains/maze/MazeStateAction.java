package model.domains.maze;

import model.algorithems.Action;
import model.algorithems.State;

public class MazeStateAction implements Action 
{
	private String actionName;
	private int[] action;
	
	//the CTOR will get the action that we need to do
	public MazeStateAction(int[] action) 
	{
		this.action = action;
		this.actionName="";
		if (action[0]==1) 
			this.actionName += " GoUp";
		if (action[0]==-1)                                
			this.actionName += " GoDwon";
		if (action[1]==1) 
			this.actionName += " GoRight";
		if (action[1]==-1) 
			this.actionName += " GoLeft";
		
	}

	
	public State doAction(State state) 
	{
		Integer[] statePlace = state.getPlace();
		return new CommonMazeState("("+(statePlace[0]+action[0])+","+(statePlace[1]+action[1])+")", 0, 0);
	}
	
	public String getActionName() 
	{
		return this.actionName;
	}


	@Override
	public String toString() {
		return "MazeStateAction [actionName=" + actionName + "]";
	}
	

}
