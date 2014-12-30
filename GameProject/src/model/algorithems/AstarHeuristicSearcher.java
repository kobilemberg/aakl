package model.algorithems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

import model.algorithms.comparators.AlgComperator;
import model.algorithms.distances.AirDistance;

public class AstarHeuristicSearcher extends HeuristicSearcher {
	
	

	public AstarHeuristicSearcher(SearchDomain sd, Distance h, Distance g) 
	{
		super(sd, h, g);
		startComparator(new AlgComperator());
	}
	public AstarHeuristicSearcher() 
	{
		super();
		startComparator(new AlgComperator());
		
	}

	public ArrayList<Action> search(SearchDomain domain)
	{
		this.h = new AirDistance();
		this.g = new AirDistance();
		this.setSearchDomain(domain);
		startState = domain.getStartState();
		goalState = domain.getGoalState();
		
		ArrayList<Action> pathToRet = new ArrayList<Action>();
		System.out.println("StartState,"+startState.toString());
		addStateToOpenList(startState);
		
		startState.setG(0);
		startState.setF(h.getDistance(startState, goalState));
		startState.setCameFromState(startState);
		while (!isEmptyOpenList())
		{
			State current = getStateFromOpenList();
			if (current.equals(goalState))
				return reconstructPath(current);
			removeStateFromOpenList(current);
			addStateToColsedList(current);
			for(Action action : sd.getActions(current))
			{
				State next = action.doAction(current);
				
				//next.setCameFromState(current);
				//next.setCameFrom_Action(action);
				double tentativeGScor = current.getG()+next.getG();
				if ((this.isContainsClosedList(next))&&(tentativeGScor>=next.getG()))
				{
					continue;
				}
				
				else if((!this.isContainsClosedList(next))||(tentativeGScor < g.getDistance(current, next)))
				{
					
					
					
					next.setCameFrom_Action(null);
					
					//cameFromMap.put(next.getStateName(), current);
					next.setCameFromState(current);
					next.setCameFrom_Action(action);
					(next).setG(tentativeGScor);
					(next).setF(this.h.getDistance(next,goalState)+this.g.getDistance(next, next));
					if (!existsInTheQueue.contains(next.getStateName()))
					{
						System.out.println(next==null);
						boolean c = this.addStateToOpenList(next);
						existsInTheQueue.add(next.getStateName());
					}
					
				}
			}
		}
		
		
		
		System.out.println("unResolved maze");
		return null;
	}
	
	
	
	public int getNumOfEvaluatedNodes() {
		// TODO Auto-generated method stub
		return 0;
	}
	public String getName() {
		return "AstarHeuristicSearcher";
	}
	

}
