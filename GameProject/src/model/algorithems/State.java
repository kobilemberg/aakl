package model.algorithems;

public interface State 
{

	public  String getStateName();

	public  void setStateName(String stateName);

	public  Action getCameFrom_Action();

	public  void setCameFrom_Action(Action cameFrom_Action);

	public  Integer[] getPlace();

	public  boolean equals(State o);

	public  String toString();
	
	public void setF(double f);
	public double getF();
	
	public void setG(double g);
	
	public double getG();
	public State getCameFromState();
	public void setCameFromState(State cameFrom);
	
}