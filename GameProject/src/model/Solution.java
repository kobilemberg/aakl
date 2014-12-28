package model;

import java.io.Serializable;
import java.util.ArrayList;

import model.algorithems.Action;

public class Solution implements Serializable 
{
	private ArrayList<Action> solutionsActions;
	private String problemDescription;

	public ArrayList<Action> getActions() {
		return solutionsActions;
	}

	public void setActions(ArrayList<Action> solutionsActions) {
		this.solutionsActions = solutionsActions;
	}

	public String getProblemDescription() 
	{
		return problemDescription;
	}

	public void setProblemDescription(String problemDescription) {
		this.problemDescription = problemDescription;
	}
}