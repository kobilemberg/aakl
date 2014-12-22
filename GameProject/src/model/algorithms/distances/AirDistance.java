package model.algorithms.distances;

import model.algorithems.Distance;
import model.algorithems.State;

public class AirDistance implements Distance {

	public AirDistance() {
		// TODO Auto-generated constructor stub
	}

	
	public double getDistance(State from, State to) 
	{
		Integer[] stateStartPlace = from.getPlace();
		Integer[] stateGoalPlace = to.getPlace();
		int x1 = stateStartPlace[0];
		int x2 = stateGoalPlace[0];
		int y1 = stateStartPlace[1];
		int y2 = stateGoalPlace[1];
		return Math.sqrt((y1-y2)*(y1-y2) + (x1-x2)*(x1-x2));
	}

}
