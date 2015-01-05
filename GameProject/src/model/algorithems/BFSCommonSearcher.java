package model.algorithems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import model.algorithms.comparators.AlgComperator;
import model.algorithms.distances.AirDistance;

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
		//this.cameFromMap = new HashMap<String, State>();
		super();
		startComparator(new AlgComperator());
		this.existsInTheQueue = new HashMap<String, State>();
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Action> search(SearchDomain domain)
	{
		ArrayList<Action> pathToRet = new ArrayList<Action>();
		AirDistance distance = new AirDistance();
		
		
		
		State current = domain.getStartState();
		current.setG(0);
		current.setCameFromState(current);
		State goal = domain.getGoalState();
		addStateToOpenList(startState);
		while(!isEmptyOpenList())
		{
			State n = getStateFromOpenList();
			addStateToColsedList(n);
			
			
			if (n.equals(goal))
			{
				
				return reconstructPath(n);
				
			}
			for (Action action: sd.getActions(n))
			{
				State next = action.doAction(current);
				
				if ((!isContainsClosedList(next))&&(!openList.contains(next)))
				
				{
					next.setG(distance.getDistance(n, next));
					next.setCameFrom_Action(action);
					next.setCameFromState(current);
					addStateToOpenList(next);

	
				}
				else
				{
					if(!openList.contains(next))
					{
						addStateToOpenList(next);
					}
					if ((next.getCameFrom_Action()== null) || (next.getCameFromState()==null)||(next.getG()>distance.getDistance(n, next)))
					{
						updateState(next.getStateName(), next, action, n);
//						next.setG(distance.getDistance(n, next));
//						next.setCameFrom_Action(action);
//						next.setCameFromState(n);
					}
					if(openList.contains(next))
					{
						next.setG(distance.getDistance(n, next));
					}
				}
			}
		}
		 System.out.println("");
		System.out.println("Cannot resolve");
		return pathToRet;
		
	}
	

	
	private void updateState(String stateName, State state, Action action, State parent)
	{
		existsInTheQueue.get(state.getStateName()).setG(state.getG());
		existsInTheQueue.get(state.getStateName()).setCameFrom_Action(action);
		if (cameFromMap.containsKey(state.getStateName()))
		{
			cameFromMap.remove((state).getStateName());
		}
		cameFromMap.put(state.getStateName(), parent);
		state.setCameFromState(parent);
	}

	public String getName() {
		return "bfs";
	}

}
