package model.domains.tiles;

import model.algorithems.CommonState;
import model.algorithems.State;

public class CommonTilesState extends CommonState {

	public CommonTilesState(String stateName, double f, double g) {
		super(stateName, f, g);
		// TODO Auto-generated constructor stub
	}

	public CommonTilesState(String stateName, double f, double g,
			State cameFromState) {
		super(stateName, f, g, cameFromState);
		// TODO Auto-generated constructor stub
	}

	public int compare(State arg0, State arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

}
