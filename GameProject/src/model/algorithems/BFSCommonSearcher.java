package model.algorithems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

import model.algorithms.distances.AirDistance;



public class BFSCommonSearcher extends AbsCommonSearcher {
	
	private Distance h;

	
	public BFSCommonSearcher(SearchDomain sd,Distance h) 
	{
		super(sd);
		this.startState = sd.getStartState();
		this.goalState = sd.getGoalState();
	}
	
	public BFSCommonSearcher() 
	{
		super();
	}
	
	public ArrayList<Action> search(SearchDomain domain) {		
		
		this.startState = domain.getStartState();
		this.goalState = domain.getGoalState();
		this.openList.add(startState);
		
		while (!openList.isEmpty())
		{
			State state = openList.poll();
			closeList.add(state);
			
			if (state.equals(goalState))
			{
				
				ArrayList<Action> actions = generatePathToGoal(state);
				
				return actions;
			}
			
			
			for (Action a : domain.getActions(state))
			{
				State nextState = a.doAction(state);
				
				double newPathPrice = state.getF() +a.getActionPrice();
				
				if (!openList.contains(nextState) && !closeList.contains(nextState))
				{
					nextState.setCameFromState(state);
					nextState.setCameFrom_Action(a);
					nextState.setF(newPathPrice);
										
					openList.add(nextState);
				}
				else
				{					
					if (newPathPrice < nextState.getF())
					{
						if (!openList.contains(nextState))
						{							
							openList.add(nextState);
						}
						else 
						{
							nextState.setF(newPathPrice);
							openList.remove(nextState);
							openList.add(nextState);
						}
					}
				}
					
			}
		}	
		System.out.println("un resolved domain");		
		return null;
	}
			
			




	public String getName() {
		return "bfs";
	}

}
