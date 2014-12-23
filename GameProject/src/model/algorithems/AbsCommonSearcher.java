package model.algorithems;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

import model.algorithms.comparators.AlgComperator;

public abstract class AbsCommonSearcher implements Searcher 
{

	 PriorityQueue<State> openList = new PriorityQueue<State>();
	 HashMap<String,State> closedSet = new HashMap<String, State>();
	 int evaluatedNodes=0;
	 SearchDomain sd;
	 State startState;
	 State goalState;
	protected HashMap<String, State> cameFromMap;
	 public AbsCommonSearcher(SearchDomain sd) 
	 {
		 this.sd =sd;
		 this.startState = sd.getStartState();
		 this.goalState= sd.getGoalState();
		 evaluatedNodes=0;
		 startComparator(new AlgComperator());
		 cameFromMap = new HashMap<String, State>();
		// openList.add(startState);
	 }
	 public AbsCommonSearcher() 
	 {
		 
		 evaluatedNodes=0;  
	 }
	 public void startComparator(Comparator<State> comp)
	 {
		evaluatedNodes=0; 
		openList = new PriorityQueue<State>(1, comp);
		closedSet = new HashMap<String, State>();
	 }
	 public void setSearchDomain(SearchDomain sd)
	 {
		 this.sd = sd;
	 }
	 public State getStateFromColsedList(String state_name)
	 {
		 return this.closedSet.get(state_name);
	 }
	 
	 public void addStateToColsedList(State state)
	 {
		 if(!this.closedSet.containsKey(state.getStateName()))
		 {
			 this.closedSet.put(state.getStateName(), state);
		 }
	 }
	 
	 public boolean isContainsClosedList(State state)
	 {
		 return this.closedSet.containsKey(state.toString());
	 }
	 
	 
	 
	 
	 
	 
	 
	 public boolean addStateToOpenList(State state)
	 {
		 return this.openList.add(state);
	 }
	 
	 												
	 public  ArrayList<Action> reconstructPath(State current) 
	 {	
		 ArrayList<Action> actionToRet = new ArrayList<Action>();
			while (current.getCameFromState()!=null&&current.getCameFrom_Action()!=null)
			{

				actionToRet.add(current.getCameFrom_Action());
				current = current.getCameFromState();
			}
			return actionToRet;
	}
	 
	 
	 
	 public void removeStateFromOpenList(State state)
	 {
		 this.openList.remove(state);
	 }
	 
	 public State getStateFromOpenList()
	 {
		 this.evaluatedNodes++;
		 return this.openList.poll();
	 }
	 
	 public boolean isEmptyOpenList()
	 {
		 return this.openList.isEmpty();
	 }
	 
	 public int getNumOfEvaluatedNodes()
	 {
		// TODO Auto-generated method stub
		return this.evaluatedNodes;
	}
	public abstract ArrayList<Action> search(SearchDomain domain);
	 
}

