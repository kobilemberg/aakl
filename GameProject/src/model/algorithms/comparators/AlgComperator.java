package model.algorithms.comparators;

import java.util.Comparator;

import model.algorithems.CommonState;
import model.algorithems.State;

public class AlgComperator implements Comparator<State> {

	public AlgComperator() {
		// TODO Auto-generated constructor stub
	}

	
	public int compare(State arg0, State arg1) {
		if (((CommonState)arg0).getF() < ((CommonState)arg1).getF())
			return -1;
		else if (((CommonState)arg0).getF() > ((CommonState)arg1).getF())
			return 1;
		return 0;
	}

}
