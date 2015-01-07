package model.algorithems;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

import model.algorithms.comparators.AlgComperator;

public abstract class AbsCommonSearcher implements Searcher 
{

	 PriorityQueue<State> openList;
	 PriorityQueue<State> closeList;

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
	public ArrayList<Action> generatePathToGoal(State state) {
		
		ArrayList<Action> actions = new ArrayList<Action>();
		
		do
		{
			actions.add(0, state.getCameFrom_Action());
			state = state.getCameFromState();			
		} while (state.getCameFrom_Action() != null&&state.getCameFromState()!=null );
		
		return actions;
	}
	 	
	public void startComparator(Comparator<State> comp)
	{
		evaluatedNodes=0; 
		openList = new PriorityQueue<State>(1, comp);
		closeList = new PriorityQueue<State>(1, comp);
		
		
	}
	
	public int getNumOfEvaluatedNodes()
	{
		
		return this.evaluatedNodes;
	}
	
	
	
	public String getName()
	{
		return "AbsCommonSearcher";
	}
	 	

	
	public void addStateToColsedList(State state)
	{

		 
		 if(!closeList.contains(state))
			 closeList.add(state);
	}
	 
	public boolean isContainsClosedList(State state)
	{
		
		return closeList.contains(state);
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
	

	
	public PriorityQueue<State> getOpenList() 
	{
		return openList;
	}
	public void setOpenList(PriorityQueue<State> openList) {
		this.openList = openList;
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

	public PriorityQueue<State> getCloseList() {
		return closeList;
	}

	public void setCloseList(PriorityQueue<State> closeList) {
		this.closeList = closeList;
	}
	
	

}

