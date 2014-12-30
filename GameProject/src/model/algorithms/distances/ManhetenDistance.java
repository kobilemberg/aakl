package model.algorithms.distances;

import model.algorithems.Distance;
import model.algorithems.State;

public class ManhetenDistance implements Distance {

	public ManhetenDistance() {
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
		return Math.abs((y1-x1)+(y2-x2));
	}

}
