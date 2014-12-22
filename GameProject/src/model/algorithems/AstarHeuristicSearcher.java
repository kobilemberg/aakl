package model.algorithems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import model.algorithms.comparators.AlgComperator;

public class AstarHeuristicSearcher extends HeuristicSearcher {

	public AstarHeuristicSearcher(SearchDomain sd, Distance h, Distance g) 
	{
		super(sd, h, g);
		//startComparator(new AlgComperator());
	}

	public ArrayList<Action> search(SearchDomain domain)
	{
		
		
		ArrayList<Action> pathToRet = new ArrayList<Action>();
		
		addStateToOpenList(startState);
		startState.setG(0);
		startState.setF(h.getDistance(startState, goalState));
		startState.setCameFromState(startState);
		while (!isEmptyOpenList())
		{
			State current = getStateFromOpenList();
			if (current.equals(goalState))
				return Reconstruct_Path( cameFromMap,current);
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
					
					try
					{
						if (cameFromMap.containsKey(next.getStateName()))
						
						{
							cameFromMap.remove(next.getStateName());
						}
					}catch (Exception e){}
					cameFromMap.put(next.getStateName(), current);
					next.setCameFromState(current);
					next.setCameFrom_Action(action);
					(next).setG(tentativeGScor);
					(next).setF(this.h.getDistance(next,goalState)+this.g.getDistance(next, next));
					if (!existsInTheQueue.contains(next.getStateName()))
					{
						this.addStateToOpenList(next);
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

}
