package model.algorithems;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

import model.algorithms.comparators.AlgComperator;

public abstract class AbsCommonSearcher implements Searcher 
{

	 PriorityQueue<State> openList;
	 PriorityQueue<State> closeList;//= new PriorityQueue<State>();
	 HashMap<String,State> closedSet; //= new HashMap<String, State>();
	 int evaluatedNodes=0;
	 SearchDomain sd;
	 State startState;
	 State goalState;
	protected HashMap<String, State> cameFromMap;
	
	public AbsCommonSearcher() 
	{
		 
		 evaluatedNodes=0;
		 startComparator(new AlgComperator());
		 cameFromMap = new HashMap<String, State>();
	}
	
	public AbsCommonSearcher(SearchDomain sd) 
	{
		 this.sd =sd;
		 startState = sd.getStartState();
		 goalState= sd.getGoalState();
		 evaluatedNodes=0;
		 startComparator(new AlgComperator());
		 cameFromMap = new HashMap<String, State>();
		
	}

	public abstract ArrayList<Action> search(SearchDomain domain);
	
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
	 	
	public void startComparator(Comparator<State> comp)
	{
		evaluatedNodes=0; 
		openList = new PriorityQueue<State>(1, comp);
		closeList = new PriorityQueue<State>(1, comp);
		closedSet = new HashMap<String, State>();
		
	}
	
	public int getNumOfEvaluatedNodes()
	{
		
		return this.evaluatedNodes;
	}
	
	
	
	public String getName()
	{
		return "AbsCommonSearcher";
	}
	 	
//closed list and open list methods:
	
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
	 	 
	public void removeStateFromOpenList(State state)
	{
		 openList.remove(state);
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
	
	public State getStateFromColsedList(String state_name)
	{
		return this.closedSet.get(state_name);
	}
	  
	 
	
// Getters and setters	
	
	
	public PriorityQueue<State> getOpenList() 
	{
		return openList;
	}
	public void setOpenList(PriorityQueue<State> openList) {
		this.openList = openList;
	}
	public HashMap<String, State> getClosedSet() {
		return closedSet;
	}
	public void setClosedSet(HashMap<String, State> closedSet) {
		this.closedSet = closedSet;
	}
	public int getEvaluatedNodes() {
		return evaluatedNodes;
	}
	public void setEvaluatedNodes(int evaluatedNodes) {
		this.evaluatedNodes = evaluatedNodes;
	}
	public SearchDomain getSd() {
		return sd;
	}
	public void setSd(SearchDomain sd) {
		this.sd = sd;
	}
	public State getStartState() {
		return startState;
	}
	public void setStartState(State startState) {
		this.startState = startState;
	}
	public State getGoalState() {
		return goalState;
	}
	public void setGoalState(State goalState) {
		this.goalState = goalState;
	}
	public HashMap<String, State> getCameFromMap() {
		return cameFromMap;
	}
	public void setCameFromMap(HashMap<String, State> cameFromMap) {
		this.cameFromMap = cameFromMap;
	}
	
	public void setSearchDomain(SearchDomain sd)
	{
		 this.sd = sd;
	}
	

}

