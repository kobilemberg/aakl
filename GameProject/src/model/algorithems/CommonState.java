package model.algorithems;

import java.util.Comparator;




public abstract class CommonState implements State,Comparator<State>
{
	
	//this will be coordinations int the format (x,y) coordinations;
	private String stateName;
	//this represent g value of state
	private double g;
	//this represent the action that created the state
	private Action cameFrom_Action;
	
	private State CameFromState;
	//this represent the f value of the state
	private double f;
	

	public CommonState(String stateName,double f,double g) 
	{
		this.stateName=stateName;
		this.g = g;
		this.cameFrom_Action=null;
		this.f= f;
		this.CameFromState = null;
	}
	
	public CommonState(String stateName,double f,double g,State cameFromState) 
	{
		this.stateName=stateName;
		this.g = g;
		this.cameFrom_Action=null;
		this.f= f;
		this.CameFromState = cameFromState;
	}
	
	public State getCameFromState()
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

	
	
	
	
	public Action getCameFrom_Action() 
	{
		return cameFrom_Action;
	}

	
	
	public void setCameFrom_Action(Action cameFrom_Action) 
	{
		this.cameFrom_Action = cameFrom_Action;
	}

		
	public Integer[] getPlace()
	{
		
		Integer[] place = new Integer[2];
		String name = this.getStateName();
		place [0] = new Integer( (int)(name.charAt(1)-'0'));
		place[1] =  new Integer((int)(name.charAt(3)-'0'));
		
		return place;
		
	}
	
	
	
//	@Override
//	public boolean equals(State o)
//	{
//		return this.stateName.equals(o.getStateName());		
//	}
	

	
	@Override
	public String toString() 
	{
		return this.getStateName();
	}

	

//	public boolean equals(State o) {
//		// TODO Auto-generated method stub
//		return this.stateName.equals(o.getStateName());
//	}

	@Override
	public boolean equals(Object obj) {
		return this.toString().equals(obj.toString());
	}
	
	
	public boolean equals(State o) {
		return this.getStateName().equals(o.getStateName());
	}
	
	





	
}
