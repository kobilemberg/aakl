package model.domains.tiles;

import java.io.Serializable;

import model.algorithems.Action;
import model.algorithems.State;

public class TilesStateAction implements Action, Serializable {

	private int[] action;
	private String actionName;
	
	public TilesStateAction(int[] action) {
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

	public State doAction(State state) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getActionName() {
		// TODO Auto-generated method stub
		return null;
	}

}
