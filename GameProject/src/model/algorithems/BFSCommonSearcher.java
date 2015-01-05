package model.algorithems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;



//import model.algorithm.Action;
//import model.algorithm.SearchDomain;
//import model.algorithm.State;
import model.algorithms.comparators.AlgComperator;


public class BFSCommonSearcher extends AbsCommonSearcher {
	
	private Distance h;
	/*private HashMap<String, State> camefromMap;*/
	private HashMap<String,State> existsInTheQueue;
	private PriorityQueue<State > closeList;
	
	public BFSCommonSearcher(SearchDomain sd,Distance h) 
	{
//		//startComparator(new AlgComperator());
//		//super(sd);
//		this.h = h;
//		//this.cameFromMap = new HashMap<String, State>();
//		this.existsInTheQueue = new HashMap<String, State>();
//		this.closeList = new PriorityQueue<State>();
//		this.openList = new PriorityQueue<State>();
//		// TODO Auto-generated constructor stub
//		this.sd = sd;
	}
	
	public BFSCommonSearcher() 
	{
		
		//startComparator(new AlgComperator());
		//this.cameFromMap = new HashMap<String, State>();
		//super();
		//this.sd = sd;
		//startComparator(new AlgComperator());
		//this.existsInTheQueue = new HashMap<String, State>();
		//this.closeList = new PriorityQueue<State>();
		//this.openList = new PriorityQueue<State>();
	}
	
	public ArrayList<Action> search(SearchDomain domain) {	
		PriorityQueue<State> closedList = new PriorityQueue<State>();
		PriorityQueue<State> NewopenList = new PriorityQueue<State>();
		
		State start = domain.getStartState();
		State goal = domain.getGoalState();
		start.setF(0);
		
		NewopenList.add(start);
		while (!NewopenList.isEmpty())
		{
			State current = NewopenList.poll();
			closedList.add(current);
			
			if (current.equals(goal))
			{
				//ArrayList<Action> actions = generatePathToGoal(current);
				ArrayList<Action> actions = reconstructPath(current);
				return actions;
			}
			
			//HashMap<Action, State> nextStates = domain.getAllPossibleMoves(state);
			
			for(Action action : domain.getActions(current))
			{
				
				State next = action.doAction(current);
				double newPathPrice = current.getF()+next.getF();
				if (!NewopenList.contains(next) && !closedList.contains(next))
				{
					
					
					next.setCameFromState(current);
					next.setCameFrom_Action(action);
					next.setF(newPathPrice);
										
					NewopenList.add(next);
					next.setCameFromState(current);
					next.setCameFrom_Action(action);
				}
				else
				{	
					//next is in open or next is in close
					if (newPathPrice < next.getF())
					{
						
						
						if (!NewopenList.contains(next))
						{
							//System.out.println("Not in NewOpenList");
							//next.setF(newPathPrice);
							closedList.remove(next);
							next.setF(newPathPrice);
							NewopenList.add(next);
							
						}
						
							
						else {
							//System.out.println("in NewOpenList");
							next.setF(newPathPrice);
							closedList.add(next);
							//NewopenList.remove(next);
							//NewopenList.add(next);
						}
					}
				}
			}
			
		}
		System.out.println("Cannot resolve");	
		return null;
	}
			
			
			/*for (Action a : nextStates.keySet())
			{
				State nextState = nextStates.get(a);
				
				if (!openList.contains(nextState) && !closedList.contains(nextState))
				{
					nextState.setCameFrom(state);
					nextState.setCameWithAction(a);
					nextState.setPrice(newPathPrice);
										
					openList.add(nextState);
				}
				else
				{					
					if (newPathPrice < nextState.getPrice())
					{
						if (!openList.contains(nextState))
							openList.add(nextState);
						else {
							nextState.setPrice(newPathPrice);
							openList.remove(nextState);
							openList.add(nextState);
						}
					}
				}
					
			}
		}	
		System.out.println("Cannot resolve");	
		return null;
	}*/
	private ArrayList<Action> generatePathToGoal(State state) {
		// TODO Auto-generated method stub
		ArrayList<Action> actions = new ArrayList<Action>();
		System.out.println("Generete");
		do
		{
			actions.add(0, state.getCameFrom_Action());
			state = state.getCameFromState();			
		} while (state.getCameFromState() != null);
		
		return actions;
	}

	
//	private void updateState(String stateName, State state, Action action, State parent)
//	{
//		existsInTheQueue.get(state.getStateName()).setG(state.getG());
//		existsInTheQueue.get(state.getStateName()).setCameFrom_Action(action);
//		if (cameFromMap.containsKey(state.getStateName()))
//		{
//			cameFromMap.remove((state).getStateName());
//		}
//		cameFromMap.put(state.getStateName(), parent);
//		state.setCameFromState(parent);
//	}

	public String getName() {
		return "bfs";
	}

}
