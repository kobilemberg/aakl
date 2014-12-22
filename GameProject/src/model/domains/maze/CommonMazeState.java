package model.domains.maze;

import model.algorithems.CommonState;
import model.algorithems.State;

public class CommonMazeState extends CommonState {

	public CommonMazeState(String stateName, double f, double g) {
		super(stateName, f, g);
		// TODO Auto-generated constructor stub
	}
	
	public int compare(State arg0, State arg1) {
		if (arg0.getF() < arg1.getF())
			return -1;
		else if (((CommonState)arg0).getF() > ((CommonState)arg1).getF())
			return 1;
		return 0;
	}

}
