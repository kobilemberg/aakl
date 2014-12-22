package model.algorithems;

import java.util.ArrayList;





public interface SearchDomain 
{
	State getStartState();
	State getGoalState();
	//State getStatCurrent();
	//void setStateCurrent(State current);
	public ArrayList<Action> getActions(State state);
	double getEvaluationToTheGoal(State current);
}
