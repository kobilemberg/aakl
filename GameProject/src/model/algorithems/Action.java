package model.algorithems;


public interface Action 
{
	State doAction(State state);
	String getActionName();
}
