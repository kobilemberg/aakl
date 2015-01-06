package model.algorithems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

import model.algorithms.distances.AirDistance;











public class BFSCommonSearcher extends AbsCommonSearcher {
	
	private Distance h;
	/*private HashMap<String, State> camefromMap;*/
	private HashMap<String,State> existsInTheQueue;
	//private PriorityQueue<State > closeList;
	
	public BFSCommonSearcher(SearchDomain sd,Distance h) 
	{
//		//
		super(sd);
		this.startState = sd.getStartState();
		this.goalState = sd.getGoalState();
		//startComparator(new AlgComperator());
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
		super();
		//startComparator(new AlgComperator());
		//this.cameFromMap = new HashMap<String, State>();
		
		//this.sd = sd;
		//startComparator(new AlgComperator());
		//this.existsInTheQueue = new HashMap<String, State>();
		//this.closeList = new PriorityQueue<State>();
		//this.openList = new PriorityQueue<State>();
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
			
			//HashMap<Action, State> nextStates = domain.getAllPossibleMoves(state);
			for (Action a : domain.getActions(state))
			{
				State nextState = a.doAction(state);
				//System.out.println(a.getActionPrice());
				//Distance distance = new AirDistance();
				double newPathPrice = state.getF() +a.getActionPrice();
				//double newPathPrice = distance.getDistance(state, nextState);
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
//							//me
							//nextState.setF(newPathPrice);
//							nextState.setCameFromState(state);
//							nextState.setCameFrom_Action(a);
//							
							
							openList.add(nextState);
							//me:
							//me
//							nextState.setCameFromState(state);
//							nextState.setCameFrom_Action(a);
						}
						else {
							
							
//							//me
//							nextState.setCameFromState(state);
//							nextState.setCameFrom_Action(a);
//							
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
		
		do
		{
			actions.add(0, state.getCameFrom_Action());
			state = state.getCameFromState();			
		} while (state.getCameFrom_Action() != null&&state.getCameFromState()!=null );
		
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
