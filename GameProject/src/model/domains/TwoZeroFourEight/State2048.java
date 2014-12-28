package model.domains.TwoZeroFourEight;

import model.algorithems.CommonState;
import model.algorithems.State;




import java.util.Comparator;




public abstract class State2048 extends CommonState
{
	
	public State2048(String stateName, double f, double g, State cameFromState) {
		super(stateName, f, g, cameFromState);
		// TODO Auto-generated constructor stub
	}

	public State2048(String stateName, double f, double g) {
		super(stateName, f, g);
		// TODO Auto-generated constructor stub
	}

/*	public State getCameFromState()
	{
		return this.CameFromState;
	}
	
	public void setCameFromState(State cameFrom)
	{
		this.CameFromState = cameFrom;
	}
	
	public String getStateName() 
	{
		return stateName;
	}
	*/
	
	
	/* (non-Javadoc)
	 * @see model.algorithems.State#setStateName(java.lang.String)
	 */
	/*
	public void setStateName(String stateName) 
	{
		this.stateName = stateName;
	}
	
	
	public void setG(double g) 
	{
		this.g = g;
	}

	public double getG() 
	{
		return g;
	}
	
	public void setF(double f) 
	{
		this.f = f;
	}
	
	public double getF() 
	{
		return f;
	}

	*/
	
	/* (non-Javadoc)
	 * @see model.algorithems.State#getCameFrom_Action()
	 */
	
/*	public Action getCameFrom_Action() 
	{
		return cameFrom_Action;
	}

	 (non-Javadoc)
	 * @see model.algorithems.State#setCameFrom_Action(model.algorithems.Action)
	 
	
	public void setCameFrom_Action(Action cameFrom_Action) 
	{
		this.cameFrom_Action = cameFrom_Action;
	}*/

	// what is the state's evaluation with respect to the goal
	
	/* (non-Javadoc)
	 * @see model.algorithems.State#getPlace()
	 */
	
	public Integer[] getPlace()
	{
		
		Integer[] place = new Integer[2];
		String name = this.getStateName();
		place [0] = new Integer( (int)(name.charAt(1)-'0'));
		place[1] =  new Integer((int)(name.charAt(3)-'0'));
		
		return place;
		
	}
	
	
	/* (non-Javadoc)
	 * @see model.algorithems.State#equals(java.lang.Object)
	 */
/*	
	public boolean equals(State o)
	{
		return this.stateName.equals(o.getStateName());		
	}

	 (non-Javadoc)
	 * @see model.algorithems.State#toString()
	 
	
	@Override
	public String toString() 
	{
		return "State [stateName=" + stateName + ", g=" + g
				+ ", cameFrom_Action=" + cameFrom_Action + ", f=" + f + "]";
	}

	
	*/





	
}

