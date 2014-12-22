package model.algorithems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import model.algorithms.comparators.AlgComperator;

public class BFSCommonSearcher extends AbsCommonSearcher {
	
	private Distance h;
	/*private HashMap<String, State> camefromMap;*/
	private HashMap<String,State> existsInTheQueue;
	
	
	public BFSCommonSearcher(SearchDomain sd,Distance h) 
	{
		
		super(sd);
		this.h = h;
		//this.cameFromMap = new HashMap<String, State>();
		this.existsInTheQueue = new HashMap<String, State>();
		// TODO Auto-generated constructor stub
	}
	
	public BFSCommonSearcher() 
	{
		
		//startComparator(new AlgComperator());
		this.cameFromMap = new HashMap<String, State>();
		this.existsInTheQueue = new HashMap<String, State>();
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Action> search(SearchDomain domain)
	{
		ArrayList<Action> pathToRet = new ArrayList<Action>();
		State current = domain.getStartState();
		current.setCameFromState(current);
		State goal = domain.getGoalState();
		addStateToColsedList(current);
		while(!isEmptyOpenList())
		{
			State t = getStateFromOpenList();
			if (t.equals(goal))
			{
				
				return Reconstruct_Path(cameFromMap, current);
				
			}
			for (Action action: sd.getActions(t))
			{
				State next = action.doAction(current);
				
				if (!isContainsClosedList(next))
				{
					addStateToColsedList(next);
					next.setCameFromState(current);
					openList.remove(next);
				}
			}
		}
		System.out.println("Cannot resolve");
		return pathToRet;
		
	}
	

	
	private void updateState(String stateName, State state, Action action, State parent)
	{
		existsInTheQueue.get(state.getStateName()).setF(state.getF());
		existsInTheQueue.get(state.getStateName()).setCameFrom_Action(action);
		if (cameFromMap.containsKey(state.getStateName()))
		{
			cameFromMap.remove((state).getStateName());
		}
		cameFromMap.put(state.getStateName(), parent);
		state.setCameFromState(parent);
	}

}
