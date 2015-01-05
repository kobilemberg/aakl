package model.domains.tiles;

import java.io.Serializable;

import model.algorithems.Action;
import model.algorithems.State;

public class TilesStateAction implements Action, Serializable {

	private int[] action; // (1,1)
	private String actionName; // go up .. 
	
	public TilesStateAction(int[] action) {
		//System.out.println("Creating " + action[0]+" "+action[1]);
		this.action = action;
		this.actionName="";
		if (action[0]==1) 
			this.actionName += String.format("%5s", "Up");
		if (action[0]==-1)                                
			this.actionName += String.format("%5s", "Down");
		if (action[1]==1) 
			this.actionName += String.format("%5s", "Right");
		if (action[1]==-1) 
			this.actionName += String.format("%5s", "Left");
		//System.out.println("Name: "+this.actionName);
		
	}

	public State doAction(State state) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getActionName() {
		String s = this.actionName;
		return s;
	}

}
