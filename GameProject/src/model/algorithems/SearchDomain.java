package model.algorithems;

import java.util.ArrayList;





public interface SearchDomain 
{
	State getStartState();
	State getGoalState();
	void setStartState(State state);
	void setGoalState(State state);
	void setSize(int size);
	public ArrayList<Action> getActions(State state);
	public String getProblemDescription();
}
